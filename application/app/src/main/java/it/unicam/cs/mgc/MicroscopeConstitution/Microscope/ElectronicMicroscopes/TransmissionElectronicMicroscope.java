package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.ElectronicMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.Cannon;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.Detector;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.VacuumPump;


/**
 * This class represents a Transmission Electronic Microscope, a type of Electronic Microscope that uses an electron beam
 * passing through the sample to create high-resolution images.
 */


public class TransmissionElectronicMicroscope extends ElectronicMicroscope {

    private static final String microscopeDescription = "This type of Microscope  uses an electron beam passing " +
            "through the sample to create high-resolution images.";

    /**
     * Constructs a new Transmission Electronic Microscope with the specified name, id, and components.
     *
     * @param name       the name of the microscope, must not be null
     * @param serialCode the unique identifier of the microscope, must not be negative
     * @param cannon     the cannon component of the microscope, must not be null
     * @param vacuumPump the vacuum pump component of the microscope, must not be null
     * @param detector   the detector component of the microscope, must not be null
     * @throws NullPointerException     if any of the parameters are null
     * @throws IllegalArgumentException if the id is negative
     */
    TransmissionElectronicMicroscope(String name, int serialCode, Cannon cannon, VacuumPump vacuumPump, Detector detector) {
        super(name, serialCode, microscopeDescription, cannon, vacuumPump, detector);
    }
}
