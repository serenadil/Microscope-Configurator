package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Software;


import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.MyExtractor;
import org.apache.jena.rdf.model.Model;

import java.util.List;
/**
 * Extracts various types of analysis software from the RDF model.
 *
 * <p>Responsibility: Extends MyExtractor to retrieve data for specific types of analysis software.</p>
 */
public class SoftwareAnalysisExtractor extends MyExtractor {

    /**
     * Constructs a SoftwareAnalysisExtractor with the specified RDF model.
     *
     * @param model RDF model to extract data from
     */
    public SoftwareAnalysisExtractor(Model model) {
        super(model);
    }

    /**
     * Extracts data for 3D analysis software.
     *
     * @return List of URIs for 3D analysis software
     */
    public List<String> extract3DAnalysisSoftware() {
        return super.obtainIndividual("3D Analysis Software");
    }

    /**
     * Extracts data for fluorescence analysis software.
     *
     * @return List of URIs for fluorescence analysis software
     */
    public List<String> extractFluorescenceAnalysisSoftware() {
        return super.obtainIndividual("Fluorescence Analysis Software");
    }

    /**
     * Extracts data for massive data analysis software.
     *
     * @return List of URIs for massive data analysis software
     */
    public List<String> extractMassiveDataAnalysisSoftware() {
        return super.obtainIndividual("Massive Data Analysis Software");
    }

    /**
     * Extracts data for measuring analysis software.
     *
     * @return List of URIs for measuring analysis software
     */
    public List<String> extractMeasuringAnalysisSoftware() {
        return super.obtainIndividual("Measuring Analysis Software");
    }

    /**
     * Extracts data for morphological analysis software.
     *
     * @return List of URIs for morphological analysis software
     */
    public List<String> extractMorphologicalAnalysisSoftware() {
        return super.obtainIndividual("Morphological Analysis Software");
    }

    /**
     * Extracts data for particle analysis software.
     *
     * @return List of URIs for particle analysis software
     */
    public List<String> extractParticleAnalysisSoftware() {
        return super.obtainIndividual("Particle Analysis Software");
    }

    /**
     * Extracts data for spectral analysis software.
     *
     * @return List of URIs for spectral analysis software
     */
    public List<String> extractSpectralAnalysisSoftware() {
        return super.obtainIndividual("Spectral Analysis Software");
    }

    /**
     * Extracts data for surface analysis software.
     *
     * @return List of URIs for surface analysis software
     */
    public List<String> extractSurfaceAnalysisSoftware() {
        return super.obtainIndividual("Surface Analysis Software");
    }

    /**
     * Extracts data for time analysis software.
     *
     * @return List of URIs for time analysis software
     */
    public List<String> extractTimeAnalysisSoftware() {
        return super.obtainIndividual("Time Analysis Software");
    }
}
