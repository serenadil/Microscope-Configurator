package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor;

import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Extractor for different types of electronic microscopes from the RDF model.
 * Extends MyExtractor to extract data for specific types of electronic microscopes.
 */
public class ElectronicMicroscopeDatabase extends MyExtractor {

    /**
     * Constructs an ElectronicMicroscopeDatabase with the specified RDF model.
     *
     * @param model RDF model to extract data from
     */
    public ElectronicMicroscopeDatabase(Model model) {
        super(model);
    }

    /**
     * Extracts data for transmission electron microscopes (TEM).
     *
     * @return List of TEM microscope URIs
     */
    public List<String> obtainTEMMicroscopes() {
        return super.obtainIndividual("Transmission Electron Microscope");
    }

    /**
     * Extracts data for scanning electron microscopes (SEM).
     *
     * @return List of SEM microscope URIs
     */
    public List<String> obtainSEMMicroscopes() {
        return super.obtainIndividual("Scanning Electron Microscope");
    }
}