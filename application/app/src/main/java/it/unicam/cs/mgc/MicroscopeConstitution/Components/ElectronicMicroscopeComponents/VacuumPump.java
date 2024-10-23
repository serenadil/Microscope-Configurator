package it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;

import java.util.Objects;

/**
 * Represents a vacuum pump used in electron microscopes to maintain an air-free environment.
 * This class extends MicroscopeComponent and implements ElectronicMicroscopeComponent.
 */
public class VacuumPump extends MicroscopeComponent implements ElectronicMicroscopeComponent {

    private final VacuumPumpType vacuumPumpType;

    /**
     * Constructs a VacuumPump with the specified serial code, producer company, and type of vacuum pump.
     *
     * @param serialCode      the serial code of the vacuum pump.
     * @param producerCompany the company that produced the vacuum pump.
     * @param vacuumPumpType  the type of the vacuum pump.
     * @throws NullPointerException if vacuumPumpType is null.
     */

    public VacuumPump(int serialCode, String producerCompany, VacuumPumpType vacuumPumpType) {
        super(serialCode, producerCompany);
        Objects.requireNonNull(vacuumPumpType, "vacuumPumpType is null");
        this.vacuumPumpType = vacuumPumpType;
    }

    /**
     * Returns the function of the component.
     *
     * @return a string representing the function of the component.
     */

    @Override
    public String getFunction() {
        return "They are used in electron microscopes to maintain an air-free environment.";
    }

    /**
     * Returns the type of the pump.
     *
     * @return a VaacumPumpType representing the type of the pump.
     */

    public VacuumPumpType getVacuumPumpType() {
        return vacuumPumpType;
    }
}
