package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.OpticalMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.IlluminationSystem;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.Objective;


/**
 * This class represents a confocal microscope, a type of optical microscope
 * that uses a laser for optical scanning at different depths, creating high-resolution three-dimensional images.
 */

public class ConfocalMicroscope extends OpticalMicroscope {

    public static final String microscopeDescription = "Uses a laser for optical scanning at different depths, " +
            "creating high-resolution three-dimensional images.";

    /**
     * Constructs a new ConfocalMicroscope with the specified details.
     *
     * @param name               the name of the microscope, must not be null
     * @param serialCode         the unique identifier of the microscope, must not be negative
     * @param objective          the objective lens of the microscope, must not be null
     * @param illuminationSystem the illumination system of the microscope, must not be null
     * @throws NullPointerException     if any parameter is null
     * @throws IllegalArgumentException if the serial code is negative
     */

    ConfocalMicroscope(String name, int serialCode, Objective objective, IlluminationSystem illuminationSystem) {
        super(name, serialCode, microscopeDescription, objective, illuminationSystem);
    }
}
