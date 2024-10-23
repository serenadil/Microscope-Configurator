package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.OpticalMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.IlluminationSystem;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.Objective;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysisType;

import java.util.Set;

/**
 * This class represents a stereoscopic microscope, a type of optical microscope
 * that provides a three-dimensional view of the specimen.
 */

public class StereoscopicMicroscope extends OpticalMicroscope {

    public static final String microscopeDescription = "This type of microscope provides a three-dimensional " +
            "view of the specimen.";

    /**
     * Constructs a new StereoscopicMicroscope with the specified details.
     *
     * @param name               the name of the microscope, must not be null
     * @param serialCode         the unique identifier of the microscope, must not be negative
     * @param objective          the objective lens of the microscope, must not be null
     * @param illuminationSystem the illumination system of the microscope, must not be null
     * @throws NullPointerException     if any parameter is null
     * @throws IllegalArgumentException if the serial code is negative
     */

    public StereoscopicMicroscope(String name, int serialCode, String microscopeDescription, Objective objective, IlluminationSystem illuminationSystem) {
        super(name, serialCode, microscopeDescription, objective, illuminationSystem);
        this.setForbiddenTypes(Set.of(
                SoftwareAnalysisType.SOFTWARE_ANALYSIS_MORPHOLOGICAL,
                SoftwareAnalysisType.SOFTWARE_ANALYSIS_MASSIVE_DATA,
                SoftwareAnalysisType.SOFTWARE_ANALYSIS_SPECTRAL,
                SoftwareAnalysisType.SOFTWARE_ANALYSIS_FLUORESCENCE
        ));
    }

}
