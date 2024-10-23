package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.ElectronicMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.Cannon;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.Detector;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.VacuumPump;

/**
 * This interface defines the methods to get the essential components of an electronic microscope.
 */

public interface GenericElectronicMicroscope {

    /**
     * Returns the cannon component of the electronic microscope.
     *
     * @return the cannon component
     */

    Cannon getCannon();

    /**
     * Returns the vacuum pump component of the electronic microscope.
     *
     * @return the vacuum pump component
     */

    VacuumPump getVacuumPump();

    /**
     * Returns the detector component of the electronic microscope.
     *
     * @return the detector component
     */

    Detector getDetector();
}
