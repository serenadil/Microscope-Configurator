package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor;

import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Extracts detailed information about a specific microscope from the RDF model.
 * Extends MyExtractor to retrieve components and software related to a specific microscope.
 */
public class MicroscopeDetails extends MyExtractor {

    private final String microscopeName;

    /**
     * Constructs a MicroscopeDetails instance with the specified RDF model and microscope URI.
     *
     * @param model         RDF model to extract data from
     * @param microscopeUri URI of the microscope to get details for
     */
    public MicroscopeDetails(Model model, String microscopeUri) {
        super(model);
        this.microscopeName = microscopeUri;
    }

    /**
     * Extracts the components of the specified microscope.
     *
     * @return List of URIs representing the components of the microscope
     */
    public List<String> extractMicroscopeComponents() {
        return super.obtainPropertyValue(microscopeName, "is composed by");
    }

    /**
     * Extracts the software integrated into the specified microscope.
     *
     * @return List of URIs representing the software integrated into the microscope
     */
    public List<String> extractMicroscopeSoftwares() {
        return super.obtainPropertyValue(microscopeName, "integrate");
    }
}
