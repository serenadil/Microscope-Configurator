package it.unicam.cs.mgc.MicroscopeConfigurator;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.*;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames.MicroscopeDetailDatabaseName;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.OpticalMicroscopeDatabase;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyConfiguration;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyPrefixes;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.SelectPropertyValuesQuery;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.UpdateQuery;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.*;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.reasoner.Reasoner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigureNewMicroscopeTest {
    private UserSelection userSelection;
    private MyConfiguration expectedConfiguration;
    private UpdaterManager updaterManager;
    private MyOntologyNameFormatter formatter;

    @BeforeEach
    public void setUp() {
        formatter = new MyOntologyNameFormatter();
        userSelection = new UserSelection("Microscope1", "Confocal Microscope", List.of("OMERO", "Imaris"), List.of("Oc5x", "Obj15x", "Gas Discharge", "CMOS"));
    }

    @Test
    public void testUpdaterExecutor() {
        UpdateQuery updateQuery = new UpdateQuery(new MyConfiguration(userSelection.getMicroscopeName(), userSelection.getSelectedMicroscopeUri(), userSelection.getSelectedSoftwaresUri(), userSelection.getSelectedComponentsUri()));
        updateQuery.setPrefix(new MyPrefixes());
        Model myModel = new MyModel().getModel();
        UpdaterExecutor executor = new UpdaterExecutor();
        executor.executeSparqlUpdate(myModel, updateQuery.getCompleteQuery());
        OpticalMicroscopeDatabase database = new OpticalMicroscopeDatabase(myModel);
        assertEquals(database.obtainConfocalMicroscopes().size(), 1);
        assertEquals(database.obtainConfocalMicroscopes().getFirst(), MyOntologyNameFormatter.formatName("Microscope1"));
        Reasoner r = CreateInferredModel.createStandardReasoner();
        InferredModel inferredModel = new InferredModel();
        InfModel infModel = inferredModel.buildInferredModel(myModel, r);
        assertTrue(CreateInferredModel.isConsistent(infModel));
    }

    @Test
    public void testUpdateManager() {
        UpdateQuery updateQuery = new UpdateQuery(new MyConfiguration(userSelection.getMicroscopeName(), userSelection.getSelectedMicroscopeUri(), userSelection.getSelectedSoftwaresUri(), userSelection.getSelectedComponentsUri()));
        updateQuery.setPrefix(new MyPrefixes());
        Model myModel = new MyModel().getModel();
        UpdaterManager manager = new UpdaterManager();
        assertTrue(manager.manageNewConfiguration(myModel, updateQuery));
        OpticalMicroscopeDatabase database = new OpticalMicroscopeDatabase(myModel);
        assertEquals(database.obtainConfocalMicroscopes().size(), 1);

    }

    @Test
    public void testUserAdd() {
        Model myModel = new MyModel().getModel();
        ConfigureNewMicroscope configurator = new ConfigureNewMicroscope();
        assertTrue(configurator.addUserConfiguration(userSelection, myModel));
        OpticalMicroscopeDatabase database = new OpticalMicroscopeDatabase(myModel);
        assertEquals(database.obtainConfocalMicroscopes().size(), 1);
        assertEquals(database.obtainConfocalMicroscopes().getFirst(), MyOntologyNameFormatter.formatName("Microscope1"));
        SelectPropertyValuesQuery propertyQuery = new SelectPropertyValuesQuery(MyOntologyNameFormatter.formatName("Microscope1"), formatter.formatName("is composed by"));
        MicroscopeDetailDatabaseName detailDatabaseName = new MicroscopeDetailDatabaseName(myModel,"Microscope1");
        assertEquals(detailDatabaseName.getComponentsNames().size(), 4);
        assertEquals(detailDatabaseName.getSoftwareNames().size(), 2);
        propertyQuery.setPrefix(new MyPrefixes());
        OntologyQueryExecutor executor = new OntologyQueryExecutor();
        List<QuerySolution> results = executor.execute(myModel, propertyQuery.getCompleteQuery());
        assertEquals(results.size(), 4);
        OntologyQueryParser parser = new OntologyQueryParser();
        List<String> result = parser.parse(results, "value");
        assertEquals(result.size(), 4);
        assertEquals(result.getFirst(), MyOntologyNameFormatter.formatName("CMOS"));
        assertEquals(result.getLast(), MyOntologyNameFormatter.formatName("Oc5x"));
    }
}
