package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor;


import org.apache.jena.rdf.model.Model;

import java.util.List;


/**
 * Extractor for different types of optical microscopes from the RDF model.
 *
 * <p>Responsibility: Extends MyExtractor to extract data for specific types of optical microscopes.</p>
 */
public class OpticalMicroscopeDatabase extends MyExtractor {

    /**
     * Constructs an OpticalMicroscopeDatabase with the specified RDF model.
     *
     * @param model RDF model to extract data from
     */
    public OpticalMicroscopeDatabase(Model model) {
        super(model);
    }

    /**
     * Extracts data for compound optical microscopes.
     *
     * @return List of compound optical microscope URIs
     */
    public List<String> obtainCompoundMicroscopes() {
        return super.obtainIndividual("Compound Optical Microscope");
    }

    /**
     * Extracts data for confocal microscopes.
     *
     * @return List of confocal microscope URIs
     */
    public List<String> obtainConfocalMicroscopes() {
        return super.obtainIndividual("Confocal Microscope");
    }

    /**
     * Extracts data for fluorescence microscopes.
     *
     * @return List of fluorescence microscope URIs
     */
    public List<String> obtainFluorescenceMicroscopes() {
        return super.obtainIndividual("Fluorescence Microscope");
    }

    /**
     * Extracts data for metallographic microscopes.
     *
     * @return List of metallographic microscope URIs
     */
    public List<String> obtainMetallographicMicroscopes() {
        return super.obtainIndividual("Metallographic Microscope");
    }

    /**
     * Extracts data for phase contrast microscopes.
     *
     * @return List of phase contrast microscope URIs
     */
    public List<String> obtainPhaseContrastMicroscopes() {
        return super.obtainIndividual("Phase Contrast Microscope");
    }

    /**
     * Extracts data for stereoscopic microscopes.
     *
     * @return List of stereoscopic microscope URIs
     */
    public List<String> obtainSteroscopicMicroscopes() {
        return super.obtainIndividual("Stereoscopic Microscope");
    }
}