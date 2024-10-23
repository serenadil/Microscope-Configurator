package it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.MyOntologyParserUri;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Component.MixedComponentExtractor;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Software.SoftwareAnalysisExtractor;
import org.apache.jena.rdf.model.Model;

import java.util.ArrayList;
import java.util.List;


/**
 * Abstract class representing options and software names for different types of microscopes.
 * It implements the MicroscopeOptionManager interface to manage microscope options, components, and software.
 */
public abstract class MicroscopeOptionsNames implements MicroscopeOptionManager {

    /**
     * Utility for parsing ontology URIs.
     * This instance is used to convert ontology URIs to string representations.
     */
    public final MyOntologyParserUri ontologyParserUri;

    private final List<String> camera;
    private final List<String> filter;
    private final List<String> threeDimensionalAnalysisSoftware;
    private final List<String> fluorescenceAnalysisSoftware;
    private final List<String> measuringAnalysisSoftware;
    private final List<String> morphologicalAnalysisSoftware;
    private final List<String> particleAnalysisSoftware;
    private final List<String> surfaceAnalysisSoftware;
    private final List<String> timeAnalysisSoftware;
    private final List<String> massiveDataAnalysisSoftware;
    private final List<String> spectralAnalysisSoftware;

    /**
     * Constructs a MicroscopeOptionsNames object.
     * Initializes lists for various components and software based on the provided model.
     *
     * @param model the model used to extract data for the microscope options and software.
     */
    public MicroscopeOptionsNames(Model model) {
        MixedComponentExtractor mixedComponentExtractor = new MixedComponentExtractor(model);
        SoftwareAnalysisExtractor softwareAnalysisExtractor = new SoftwareAnalysisExtractor(model);
        ontologyParserUri = new MyOntologyParserUri();
        this.camera = ontologyParserUri.parseUris(mixedComponentExtractor.extractCamera());
        this.filter = ontologyParserUri.parseUris(mixedComponentExtractor.extractFilter());
        this.threeDimensionalAnalysisSoftware = ontologyParserUri.parseUris(softwareAnalysisExtractor.extract3DAnalysisSoftware());
        this.fluorescenceAnalysisSoftware = ontologyParserUri.parseUris(softwareAnalysisExtractor.extractFluorescenceAnalysisSoftware());
        this.measuringAnalysisSoftware = ontologyParserUri.parseUris(softwareAnalysisExtractor.extractMeasuringAnalysisSoftware());
        this.morphologicalAnalysisSoftware = ontologyParserUri.parseUris(softwareAnalysisExtractor.extractMorphologicalAnalysisSoftware());
        this.particleAnalysisSoftware = ontologyParserUri.parseUris(softwareAnalysisExtractor.extractParticleAnalysisSoftware());
        this.surfaceAnalysisSoftware = ontologyParserUri.parseUris(softwareAnalysisExtractor.extractSurfaceAnalysisSoftware());
        this.spectralAnalysisSoftware = ontologyParserUri.parseUris(softwareAnalysisExtractor.extractSpectralAnalysisSoftware());
        this.timeAnalysisSoftware = ontologyParserUri.parseUris(softwareAnalysisExtractor.extractTimeAnalysisSoftware());
        this.massiveDataAnalysisSoftware = ontologyParserUri.parseUris(softwareAnalysisExtractor.extractMassiveDataAnalysisSoftware());
    }

    /**
     * Abstract method that subclasses must implement to provide a list of available microscope options.
     *
     * @return a list of available microscope options.
     */
    public abstract List<String> getMicroscopeOptions();

    /**
     * Gets the list of available camera components.
     *
     * @return a list of camera components.
     */
    public List<String> getCamera() {
        return camera;
    }

    /**
     * Gets the list of available filter components.
     *
     * @return a list of filter components.
     */
    public List<String> getFilter() {
        return filter;
    }


    /**
     * Gets a list of all components including cameras and filters.
     * This list combines the camera and filter components.
     *
     * @return a list of all components.
     */
    public List<String> getAllComponents() {
        List<String> components = new ArrayList<>();
        components.addAll(camera);
        components.addAll(filter);
        return components;
    }

    /**
     * Gets a list of all available software for various types of analysis.
     * This list combines all types of analysis software including 3D, fluorescence, and more.
     *
     * @return a list of all analysis software.
     */
    public List<String> getAllSoftware() {
        List<String> software = new ArrayList<>();
        software.addAll(threeDimensionalAnalysisSoftware);
        software.addAll(fluorescenceAnalysisSoftware);
        software.addAll(measuringAnalysisSoftware);
        software.addAll(morphologicalAnalysisSoftware);
        software.addAll(particleAnalysisSoftware);
        software.addAll(surfaceAnalysisSoftware);
        software.addAll(spectralAnalysisSoftware);
        software.addAll(timeAnalysisSoftware);
        software.addAll(massiveDataAnalysisSoftware);
        return software;
    }
}