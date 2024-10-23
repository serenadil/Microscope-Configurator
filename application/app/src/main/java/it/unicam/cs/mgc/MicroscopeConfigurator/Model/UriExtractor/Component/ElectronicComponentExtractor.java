package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Component;


import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.MyExtractor;
import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Extracts electronic components from the RDF model.
 * Extends MyExtractor to retrieve data for specific electronic components of microscopes.
 */
public class ElectronicComponentExtractor extends MyExtractor {

    /**
     * Constructs an ElectronicComponentExtractor with the specified RDF model.
     *
     * @param model RDF model to extract data from
     */
    public ElectronicComponentExtractor(Model model) {
        super(model);
    }

    /**
     * Extracts data for the cannon component.
     *
     * @return List of URIs for the cannon
     */
    public List<String> extractCannon() {
        return super.obtainIndividual("Cannon");
    }

    /**
     * Extracts data for the vacuum pump component.
     *
     * @return List of URIs for the vacuum pump
     */
    public List<String> extractVacuumPump() {
        return super.obtainIndividual("Vacuum Pump");
    }

    /**
     * Extracts data for the detector component.
     *
     * @return List of URIs for the detector
     */
    public List<String> extractDetector() {
        return super.obtainIndividual("Detector");
    }
}
