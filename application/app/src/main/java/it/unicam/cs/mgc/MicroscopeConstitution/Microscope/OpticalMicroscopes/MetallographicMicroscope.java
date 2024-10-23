package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.OpticalMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.IlluminationSystem;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.Objective;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysis;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysisType;

/**
 * This class represents a metallographic microscope, a type of compound optical microscope
 * used for the microscopic examination of metals and alloys.
 */

public class MetallographicMicroscope extends OpticalMicroscope {
    public static final String microscopeDescription = "A metallographic microscope is a type of compound optical " +
            "microscope used for the microscopic examination of metals and alloys. It is equipped with reflected " +
            "(episcopic) illumination, which allows opaque surfaces to be observed by reflected rather " +
            "than transmitted light.";

    /**
     * Constructs a new MetallographicMicroscope with the specified details.
     *
     * @param name               the name of the microscope, must not be null
     * @param serialCode         the unique identifier of the microscope, must not be negative
     * @param objective          the objective lens of the microscope, must not be null
     * @param illuminationSystem the illumination system of the microscope, must not be null
     * @param AnalysisSoftware3D the 3D analysis software for the microscope, must not be null and must be of type SOFTWARE_ANALYSIS_FLUORESCENCE
     * @throws NullPointerException     if any parameter is null
     * @throws IllegalArgumentException if the serial code is negative or if the software analysis type is incorrect
     */
    MetallographicMicroscope(String name, int serialCode, Objective objective, IlluminationSystem illuminationSystem, SoftwareAnalysis AnalysisSoftware3D) {
        super(name, serialCode, microscopeDescription, objective, illuminationSystem);
        if (AnalysisSoftware3D.getType() == SoftwareAnalysisType.SOFTWARE_ANALYSIS_FLUORESCENCE) {
            this.addSoftware(AnalysisSoftware3D);
        } else throw new IllegalArgumentException("The software analysis type is incorrect.");
    }
}
