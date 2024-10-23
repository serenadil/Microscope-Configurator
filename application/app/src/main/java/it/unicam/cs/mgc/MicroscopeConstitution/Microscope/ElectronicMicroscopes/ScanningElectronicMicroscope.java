package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.ElectronicMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.Cannon;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.Detector;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.ElectronicMicroscopeComponent;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.VacuumPump;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysisType;

import java.util.Set;

/**
 * This class represents a Scanning Electronic Microscope, a type of Electronic Microscope that scans the surface
 * of the sample with an electron beam to create detailed three-dimensional images.
 */

public class ScanningElectronicMicroscope extends ElectronicMicroscope {

    private static final String microscopeDescription = "This type of Microscope scans the surface of the sample " +
            "with an electron beam, creating detailed three-dimensional images.";

    /**
     * Constructs a new ScanningElectronicMicroscope with the specified details.
     *
     * @param name       the name of the microscope, must not be null
     * @param serialCode the unique identifier of the microscope, must not be negative
     * @param cannon     the cannon component of the microscope, must not be null
     * @param vacuumPump the vacuum pump component of the microscope, must not be null
     * @param detector   the detector component of the microscope, must not be null
     * @throws NullPointerException     if any parameter is null
     * @throws IllegalArgumentException if the serial code is negative
     */

    public ScanningElectronicMicroscope(String name, int serialCode, Cannon cannon, VacuumPump vacuumPump, Detector detector) {
        super(name, serialCode, microscopeDescription, cannon, vacuumPump, detector);
        this.setForbiddenTypes(Set.of(
                SoftwareAnalysisType.SOFTWARE_ANALYSIS_MASSIVE_DATA,
                SoftwareAnalysisType.SOFTWARE_ANALYSIS_TIME
        ));
    }


}


