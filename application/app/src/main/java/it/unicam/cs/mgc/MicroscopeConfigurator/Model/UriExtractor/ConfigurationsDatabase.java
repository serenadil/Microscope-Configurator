package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor;

import org.apache.jena.rdf.model.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages and retrieves data for both electronic and optical microscopes.
 * Aggregates data from ElectronicMicroscopeDatabase and OpticalMicroscopeDatabase for all microscope configurations.</p>
 */
public class ConfigurationsDatabase implements Database {

    private final ElectronicMicroscopeDatabase electronicMicroscopeDatabase;
    private final OpticalMicroscopeDatabase opticalMicroscopeDatabase;

    /**
     * Constructs a ConfigurationsDatabase with the specified RDF model.
     *
     * @param model RDF model to extract data from
     */
    public ConfigurationsDatabase(Model model) {
        electronicMicroscopeDatabase = new ElectronicMicroscopeDatabase(model);
        opticalMicroscopeDatabase = new OpticalMicroscopeDatabase(model);
    }

    /**
     * Retrieves data for all types of microscopes.
     *
     * @return List of URIs for all microscope configurations
     */
    public List<String> getAllData() {
        List<String> configurations = new ArrayList<>();
        configurations.addAll(electronicMicroscopeDatabase.obtainTEMMicroscopes());
        configurations.addAll(electronicMicroscopeDatabase.obtainSEMMicroscopes());
        configurations.addAll(opticalMicroscopeDatabase.obtainCompoundMicroscopes());
        configurations.addAll(opticalMicroscopeDatabase.obtainConfocalMicroscopes());
        configurations.addAll(opticalMicroscopeDatabase.obtainFluorescenceMicroscopes());
        configurations.addAll(opticalMicroscopeDatabase.obtainMetallographicMicroscopes());
        configurations.addAll(opticalMicroscopeDatabase.obtainPhaseContrastMicroscopes());
        configurations.addAll(opticalMicroscopeDatabase.obtainSteroscopicMicroscopes());
        return configurations;
    }
}