package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Component;


import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.MyExtractor;
import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Extracts optical components from the RDF model.
 * Extends MyExtractor to retrieve data for specific optical components of microscopes.
 */
public class OpticalComponentExtractor extends MyExtractor {

    /**
     * Constructs an OpticalComponentExtractor with the specified RDF model.
     *
     * @param model RDF model to extract data from
     */
    public OpticalComponentExtractor(Model model) {
        super(model);
    }

    /**
     * Extracts data for the illumination system component.
     *
     * @return List of URIs for the illumination system
     */
    public List<String> extractIlluminationSystem() {
        return super.obtainIndividual("Illumination System");
    }

    /**
     * Extracts data for the ocular component.
     *
     * @return List of URIs for the ocular
     */
    public List<String> extractOcular() {
        return super.obtainIndividual("Ocular");
    }

    /**
     * Extracts data for the objective component.
     *
     * @return List of URIs for the objective
     */
    public List<String> extractObjective() {
        return super.obtainIndividual("Objective");
    }
}
