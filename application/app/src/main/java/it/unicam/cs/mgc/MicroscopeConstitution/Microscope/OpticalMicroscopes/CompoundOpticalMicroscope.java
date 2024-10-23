package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.OpticalMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.IlluminationSystem;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.Objective;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.OpticalMicroscopeComponent;

/**
 * This class represents a compound optical microscope, a type of optical microscope
 * that provides a high degree of magnification and resolution through the use of multiple optical lenses.
 *
 * @param <P> the type of microscope component that also implements OpticalMicroscopeComponent
 */

public class CompoundOpticalMicroscope<P extends MicroscopeComponent & OpticalMicroscopeComponent> extends OpticalMicroscope {

    private static final String microscopeDescription = "The main characteristic of a compound optical microscope " +
            "is its ability to provide a high degree of magnification and resolution through the use of multiple optical lenses. ";

    /**
     * Constructs a new CompoundOpticalMicroscope with the specified details.
     *
     * @param name               the name of the microscope, must not be null
     * @param serialCode         the unique identifier of the microscope, must not be negative
     * @param objective          the objective lens of the microscope, must not be null
     * @param illuminationSystem the illumination system of the microscope, must not be null
     * @throws NullPointerException     if any parameter is null
     * @throws IllegalArgumentException if the serial code is negative
     */

    CompoundOpticalMicroscope(String name, int serialCode, Objective objective, IlluminationSystem illuminationSystem) {
        super(name, serialCode, microscopeDescription, objective, illuminationSystem);
    }


}
