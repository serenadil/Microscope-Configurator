package it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.MyOntologyParserUri;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.ConfigurationsDatabase;
import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Manages the database of all microscope names configurations.
 */
public class MicroscopesDatabaseNames {
    private final ConfigurationsDatabase databaseUri;
    private final MyOntologyParserUri ontologyParserUri;

    /**
     * Constructs an instance of MicroscopesDatabaseNames.
     *
     * @param model the model from which to extract information.
     */
    public MicroscopesDatabaseNames(Model model) {
        databaseUri = new ConfigurationsDatabase(model);
        ontologyParserUri = new MyOntologyParserUri();
    }

    /**
     * Gets the list of all microscope names from the database.
     *
     * @return a list of microscope names.
     */
    public List<String> getNames() {
        return ontologyParserUri.parseUris(databaseUri.getAllData());
    }
}