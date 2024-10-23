package it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Component.OpticalComponentExtractor;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.MicroscopeTypesExtractor;
import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Represents the names for optical microscopes options.
 * This class extends the MicroscopeOptionsNames class to include specific components for optical microscopes.
 */
public class OpticalMicroscopeOptionNames extends MicroscopeOptionsNames {
    private final List<String> microscopeOptions;
    private final List<String> illuminationSystem;
    private final List<String> ocular;
    private final List<String> objective;

    /**
     * Constructs an instance of OpticalMicroscopeOptionNames.
     *
     * @param model the model from which to extract information.
     */
    public OpticalMicroscopeOptionNames(Model model) {
        super(model);
        MicroscopeTypesExtractor microscopeTypesExtractor = new MicroscopeTypesExtractor(model);
        OpticalComponentExtractor opticalComponentExtractor = new OpticalComponentExtractor(model);
        this.microscopeOptions = ontologyParserUri.parseUris(microscopeTypesExtractor.OpticalTypeMicroscopeExtractor());
        this.illuminationSystem = ontologyParserUri.parseUris(opticalComponentExtractor.extractIlluminationSystem());
        this.ocular = ontologyParserUri.parseUris(opticalComponentExtractor.extractOcular());
        this.objective = ontologyParserUri.parseUris(opticalComponentExtractor.extractObjective());
    }

    /**
     * Gets the list of available microscope options for optical microscopes.
     *
     * @return a list of optical microscope options.
     */
    @Override
    public List<String> getMicroscopeOptions() {
        return microscopeOptions;
    }

    /**
     * Gets the list of available illumination systems for optical microscopes.
     *
     * @return a list of illumination systems.
     */
    public List<String> getIlluminationSystem() {
        return illuminationSystem;
    }

    /**
     * Gets the list of available ocular components for optical microscopes.
     *
     * @return a list of ocular components.
     */
    public List<String> getOcular() {
        return ocular;
    }

    /**
     * Gets the list of available objectives for optical microscopes.
     *
     * @return a list of objectives.
     */
    public List<String> getObjective() {
        return objective;
    }

    /**
     * Gets the list of all components including those specific to optical microscopes.
     *
     * @return a list of all optical microscope components.
     */
    @Override
    public List<String> getAllComponents() {
        List<String> components = super.getAllComponents();
        components.addAll(illuminationSystem);
        components.addAll(ocular);
        components.addAll(objective);
        return components;
    }
}