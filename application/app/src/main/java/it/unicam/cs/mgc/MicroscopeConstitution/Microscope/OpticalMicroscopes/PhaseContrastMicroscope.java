package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.OpticalMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.IlluminationSystem;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.Objective;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysisType;

import java.util.Set;

/**
 * This class represents a phase contrast microscope, a type of optical microscope
 * that enhances the contrast of transparent samples without staining.
 */

public class PhaseContrastMicroscope extends OpticalMicroscope {
    public static final String microscopeDescription = "This type of microscope enhances the contrast of transparent " +
            "samples without staining.";

    /**
     * Constructs a new PhaseContrastMicroscope with the specified details.
     *
     * @param name               the name of the microscope, must not be null
     * @param serialCode         the unique identifier of the microscope, must not be negative
     * @param objective          the objective lens of the microscope, must not be null
     * @param illuminationSystem the illumination system of the microscope, must not be null
     * @throws NullPointerException     if any parameter is null
     * @throws IllegalArgumentException if the serial code is negative
     */

    PhaseContrastMicroscope(String name, int serialCode, Objective objective, IlluminationSystem illuminationSystem) {
        super(name, serialCode, microscopeDescription, objective, illuminationSystem);
        this.setForbiddenTypes(Set.of(
                SoftwareAnalysisType.SOFTWARE_ANALYSIS_MORPHOLOGICAL,
                SoftwareAnalysisType.SOFTWARE_ANALYSIS_SURFACE
        ));
    }


}
