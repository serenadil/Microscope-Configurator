package it.unicam.cs.mgc.MicroscopeConfigurator;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyPrefixes;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.Prefixes;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.SelectIndividualQuery;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.SelectSubclassQuery;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.*;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OntologyQueryExecutorTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        DefaultModel defaultModel = new DefaultModel();
        model = defaultModel.buildDefaultModelFromPath("MO.rdf");

    }

    @Test
    public void QueryExecutor() {
        OntologyQueryExecutor executor = new OntologyQueryExecutor();
        String query = """
                PREFIX mo: <http://www.unicam.it/cs/serenadileonardo/microscope-ontology#>
                PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
                PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\
                SELECT ?subClass ?name \
                WHERE { \
                ?subClass rdfs:subClassOf <http://www.unicam.it/cs/serenadileonardo/microscope-ontology#Electronic_Microscope> .\
                ?subClass rdfs:label ?name .\
                 }""";
        List<QuerySolution> results = executor.execute(model, query);
        assertEquals(2, results.size());
        QueryParser parser = new OntologyQueryParser();
        List<String> result = parser.parse(results, "subClass");
        assertEquals(result.size(), 2);
        assertEquals(result.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "Transmission Electron Microscope"));
    }


    @Test
    public void SubclassQueryExecutor() {
        OntologyQueryExecutor executor = new OntologyQueryExecutor();
        Prefixes pr = new MyPrefixes();
        SelectSubclassQuery getSubclass =new SelectSubclassQuery(OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "Electronic Microscope"));
        getSubclass.setPrefix(pr);
        List<QuerySolution> results = executor.execute(model, getSubclass.getCompleteQuery());
        assertEquals(results.size(), 2);
        OntologyQueryParser parser = new OntologyQueryParser();
        List<String> result = parser.parse(results, "subClass");
        assertEquals(result.size(), 2);
        assertEquals(result.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "Transmission Electron Microscope"));


    }
    @Test
    public void IndividualQueryExecutor() {
        OntologyQueryExecutor executor = new OntologyQueryExecutor();
        Prefixes pr = new MyPrefixes();
        SelectIndividualQuery getIndividual =new SelectIndividualQuery(OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "Cannon"));
        getIndividual.setPrefix(pr);
        List<QuerySolution> results = executor.execute(model, getIndividual.getCompleteQuery());
        assertEquals(results.size(), 2);
        OntologyQueryParser parser = new OntologyQueryParser();
        List<String> result = parser.parse(results, "individual");
        assertEquals(result.size(), 2);
        assertEquals(result.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "Thermoemission Cannon"));

    }

}
