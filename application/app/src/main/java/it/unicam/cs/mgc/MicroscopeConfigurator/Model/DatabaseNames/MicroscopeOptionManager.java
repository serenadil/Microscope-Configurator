package it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames;

import java.util.List;

/**
 * Interface for managing microscope options.
 */
public interface MicroscopeOptionManager {

    /**
     * Gets the list of available microscope options.
     *
     * @return a list of microscope options.
     */
    List<String> getMicroscopeOptions();

    /**
     * Gets the list of all available components for the microscope.
     *
     * @return a list of all microscope components.
     */
    List<String> getAllComponents();

    /**
     * Gets the list of all available software for the microscope.
     *
     * @return a list of all microscope software.
     */
    List<String> getAllSoftware();
}