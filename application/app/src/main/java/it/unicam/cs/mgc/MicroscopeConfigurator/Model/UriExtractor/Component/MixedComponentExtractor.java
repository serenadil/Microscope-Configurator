package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Component;


import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.MyExtractor;
import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Extracts mixed components from the RDF model.
 * Extends MyExtractor to retrieve data for specific mixed components used in microscopes.
 */
public class MixedComponentExtractor extends MyExtractor {

    /**
     * Constructs a MixedComponentExtractor with the specified RDF model.
     *
     * @param model RDF model to extract data from
     */
    public MixedComponentExtractor(Model model) {
        super(model);
    }

    /**
     * Extracts data for the filter component.
     *
     * @return List of URIs for the filter
     */
    public List<String> extractFilter() {
        return super.obtainIndividual("Filter");
    }

    /**
     * Extracts data for the camera component.
     *
     * @return List of URIs for the camera
     */
    public List<String> extractCamera() {
        return super.obtainIndividual("Camera");
    }
}