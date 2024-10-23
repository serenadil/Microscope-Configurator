package it.unicam.cs.mgc.MicroscopeConstitution.Microscope.ElectronicMicroscopes;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.Cannon;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.Detector;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.ElectronicMicroscopeComponent;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.VacuumPump;
import it.unicam.cs.mgc.MicroscopeConstitution.Microscope.Microscope;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysis;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysisType;

import java.util.Objects;

/**
 * This class represents a general electronic microscope with basic functionalities.
 * It implements the GenericElectronicMicroscope interface.
 *
 */
public class ElectronicMicroscope extends Microscope<SoftwareAnalysisType, SoftwareAnalysis, ElectronicMicroscopeComponent> implements GenericElectronicMicroscope {

    private final Cannon cannon;
    private final VacuumPump vacuumPump;
    private final Detector detector;

    /**
     * Constructs a new ElectronicMicroscope with the specified details.
     *
     * @param name                  the name of the microscope, must not be null
     * @param serialCode            the unique identifier of the microscope, must not be negative
     * @param microscopeDescription a description of the microscope
     * @param cannon                the cannon component of the microscope, must not be null
     * @param vacuumPump            the vacuum pump component of the microscope, must not be null
     * @param detector              the detector component of the microscope, must not be null
     * @throws NullPointerException     if any parameter is null
     * @throws IllegalArgumentException if the serial code is negative
     */

    ElectronicMicroscope(String name, int serialCode, String microscopeDescription, Cannon cannon, VacuumPump vacuumPump, Detector detector) {
        super(name, serialCode, microscopeDescription);
        Objects.requireNonNull(cannon, "cannon cannot be null");
        Objects.requireNonNull(vacuumPump, "vacuumPump cannot be null");
        Objects.requireNonNull(detector, "detector cannot be null");
        this.cannon = cannon;
        this.vacuumPump = vacuumPump;
        this.detector = detector;
    }

    /**
     * Returns the cannon component of the electronic microscope.
     *
     * @return the cannon component
     */

    public Cannon getCannon() {
        return this.cannon;
    }

    /**
     * Returns the vacuum pump component of the electronic microscope.
     *
     * @return the vacuum pump component
     */

    public VacuumPump getVacuumPump() {
        return this.vacuumPump;
    }

    /**
     * Returns the detector component of the electronic microscope.
     *
     * @return the detector component
     */

    public Detector getDetector() {
        return this.detector;
    }

}
