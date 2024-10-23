package it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Component.ElectronicComponentExtractor;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.MicroscopeTypesExtractor;
import org.apache.jena.rdf.model.Model;

import java.util.List;


/**
 * Represents the names for the available options in electronic microscopes.
 * This class extends the MicroscopeOptionsNames class to include specific components for electronic microscopes.
 */
public class ElectronicMicroscopeOptionsNames extends MicroscopeOptionsNames {

    private final List<String> microscopeOptions;
    private final List<String> cannon;
    private final List<String> detector;
    private final List<String> vacuumPump;

    /**
     * Constructs an instance of ElectronicMicroscopeOptionsNames.
     *
     * @param model the model from which to extract information.
     */
    public ElectronicMicroscopeOptionsNames(Model model) {
        super(model);
        MicroscopeTypesExtractor microscopeTypesExtractor = new MicroscopeTypesExtractor(model);
        ElectronicComponentExtractor electronicComponentExtractor = new ElectronicComponentExtractor(model);
        this.microscopeOptions = ontologyParserUri.parseUris(microscopeTypesExtractor.ElectronicTypeMicroscopeExtractor());
        this.cannon = ontologyParserUri.parseUris(electronicComponentExtractor.extractCannon());
        this.detector = ontologyParserUri.parseUris(electronicComponentExtractor.extractDetector());
        this.vacuumPump = ontologyParserUri.parseUris(electronicComponentExtractor.extractVacuumPump());
    }

    /**
     * Gets the list of available microscope options for electronic microscopes.
     *
     * @return a list of electronic microscope options.
     */
    @Override
    public List<String> getMicroscopeOptions() {
        return microscopeOptions;
    }

    /**
     * Gets the list of available cannon components for electronic microscopes.
     *
     * @return a list of cannon components.
     */
    public List<String> getCannon() {
        return cannon;
    }

    /**
     * Gets the list of available detector components for electronic microscopes.
     *
     * @return a list of detector components.
     */
    public List<String> getDetector() {
        return detector;
    }

    /**
     * Gets the list of available vacuum pump components for electronic microscopes.
     *
     * @return a list of vacuum pump components.
     */
    public List<String> getVacuumPump() {
        return vacuumPump;
    }

    /**
     * Gets the list of all components including those specific to electronic microscopes.
     *
     * @return a list of all electronic microscope components.
     */
    @Override
    public List<String> getAllComponents() {
        List<String> components = super.getAllComponents();
        components.addAll(cannon);
        components.addAll(detector);
        components.addAll(vacuumPump);
        return components;
    }
}