package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.OpticalMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.IlluminationSystem;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.Objective;

/**
 * This interface represents a generic optical microscope with essential components.
 */

public interface GenericOpticalMicroscope {
    /**
     * Gets the objective lens of the microscope.
     *
     * @return the objective lens
     */

    Objective getObjective();

    /**
     * Gets the illumination system of the microscope.
     *
     * @return the illumination system
     */

    IlluminationSystem getIlluminationSystem();
}
