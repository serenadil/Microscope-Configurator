package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.OpticalMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.IlluminationSystem;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.Objective;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysis;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysisType;

/**
 * This class represents a fluorescence microscope, a type of optical microscope
 * that uses specific lights to excite fluorophores in the sample, emitting visible light.
 */

public class FluorescenceMicroscope extends OpticalMicroscope {

    public static final String microscopeDescription = "It uses specific lights to excite fluorophores " +
            "in the sample, emitting visible light.";
    /**
     * Constructs a new FluorescenceMicroscope with the specified details.
     *
     * @param name                      the name of the microscope, must not be null
     * @param serialCode                the unique identifier of the microscope, must not be negative
     * @param objective                 the objective lens of the microscope, must not be null
     * @param illuminationSystem        the illumination system of the microscope, must not be null
     * @param fluorescenceAnalysisSoftware the fluorescence analysis software for the microscope, must not be null and must be of type SOFTWARE_ANALYSIS_FLUORESCENCE
     * @throws NullPointerException     if any parameter is null
     * @throws IllegalArgumentException if the serial code is negative or if the software analysis type is incorrect
     */

    FluorescenceMicroscope(String name, int serialCode, Objective objective, IlluminationSystem illuminationSystem, SoftwareAnalysis fluorescenceAnalysisSoftware) {
        super(name, serialCode, microscopeDescription, objective, illuminationSystem);
        if (fluorescenceAnalysisSoftware.getType() == SoftwareAnalysisType.SOFTWARE_ANALYSIS_FLUORESCENCE) {
            this.addSoftware(fluorescenceAnalysisSoftware);
        } else throw new IllegalArgumentException("The software analysis type is incorrect.");
    }
}
