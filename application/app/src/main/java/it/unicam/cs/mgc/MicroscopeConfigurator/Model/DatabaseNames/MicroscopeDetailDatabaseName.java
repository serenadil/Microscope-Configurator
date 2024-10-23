package it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.MyOntologyParserUri;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.MicroscopeDetails;
import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Provides details on the components and software for a specific microscope model.
 */
public class MicroscopeDetailDatabaseName {
    private final MicroscopeDetails microscopeDetails;
    MyOntologyParserUri ontologyParserUri;

    /**
     * Constructs an instance of MicroscopeDetailDatabaseName.
     *
     * @param model          the model from which to extract information.
     * @param microscopeName the name of the specific microscope model.
     */
    public MicroscopeDetailDatabaseName(Model model, String microscopeName) {
        ontologyParserUri = new MyOntologyParserUri();
        this.microscopeDetails = new MicroscopeDetails(model, microscopeName);
    }

    /**
     * Gets the list of component names for the specified microscope model.
     *
     * @return a list of component names.
     */
    public List<String> getComponentsNames() {
        return ontologyParserUri.parseUris(microscopeDetails.extractMicroscopeComponents());
    }

    /**
     * Gets the list of software names for the specified microscope model.
     *
     * @return a list of software names.
     */
    public List<String> getSoftwareNames() {
        return ontologyParserUri.parseUris(microscopeDetails.extractMicroscopeSoftwares());
    }
}
