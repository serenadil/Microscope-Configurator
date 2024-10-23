package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.OpticalMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.IlluminationSystem;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.Objective;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.OpticalMicroscopeComponent;
import it.unicam.cs.mgc.MicroscopeConstitution.Microscope.Microscope;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysis;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysisType;

import java.util.Objects;

/**
 * This abstract class represents an optical microscope with basic functionalities.
 * It extends the Microscope class and implements the GenericOpticalMicroscope interface.
 */

public class OpticalMicroscope extends Microscope<SoftwareAnalysisType, SoftwareAnalysis, OpticalMicroscopeComponent> implements GenericOpticalMicroscope {

    private final Objective objective;
    private final IlluminationSystem illuminationSystem;

    /**
     * Constructs a new OpticalMicroscope with the specified details.
     *
     * @param name                  the name of the microscope, must not be null
     * @param serialCode            the unique identifier of the microscope, must not be negative
     * @param microscopeDescription a description of the microscope, must not be null
     * @param objective             the objective lens of the microscope, must not be null
     * @param illuminationSystem    the illumination system of the microscope, must not be null
     * @throws NullPointerException     if any parameter is null
     * @throws IllegalArgumentException if the serial code is negative
     */

    OpticalMicroscope(String name, int serialCode, String microscopeDescription, Objective objective, IlluminationSystem illuminationSystem) {
        super(name, serialCode, microscopeDescription);
        Objects.requireNonNull(objective, "objective must not be null");
        Objects.requireNonNull(illuminationSystem, "illuminationSystem must not be null");
        this.objective = objective;
        this.illuminationSystem = illuminationSystem;

    }

    /**
     * Gets the objective lens of the microscope.
     *
     * @return the objective lens
     */

    @Override
    public Objective getObjective() {
        return this.objective;
    }

    /**
     * Gets the illumination system of the microscope.
     *
     * @return the illumination system
     */

    @Override
    public IlluminationSystem getIlluminationSystem() {
        return this.illuminationSystem;
    }


}
