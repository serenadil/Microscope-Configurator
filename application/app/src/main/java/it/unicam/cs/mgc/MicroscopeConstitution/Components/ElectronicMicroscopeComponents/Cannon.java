package it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;

import java.util.Objects;

/**
 * The Cannon class represents a specific type of microscope component that generates and accelerates
 * an electron beam used for illumination and scanning of the sample.
 * It extends MicroscopeComponent and implements ElectronicMicroscopeComponent.
 */

public class Cannon extends MicroscopeComponent implements ElectronicMicroscopeComponent {
    private final CannonType cannonType;
    private final ElectronSourceType electronicSourceType;

    /**
     * Constructs a Cannon with the specified serial code, producer company, cannon type, and electronic source type.
     *
     * @param serialCode           the serial code of the cannon.
     * @param producerCompany      the name of the producer company.
     * @param cannonType           the type of cannon.
     * @param electronicSourceType the type of electronic source.
     * @throws NullPointerException     if cannonType or electronicSourceType is null.
     * @throws IllegalArgumentException if electronicSourceType is not compatible with cannonType.
     */

    public Cannon(int serialCode, String producerCompany, CannonType cannonType, ElectronSourceType electronicSourceType) {
        super(serialCode, producerCompany);
        Objects.requireNonNull(cannonType, "cannonType must not be null");
        Objects.requireNonNull(electronicSourceType, "electronicSourceType must not be null");
        if (cannonType.getForbiddenSources().contains(electronicSourceType))
            throw new IllegalArgumentException("Source type " + electronicSourceType + " is not compatible");
        this.electronicSourceType = electronicSourceType;
        this.cannonType = cannonType;
    }

    /**
     * Returns the function of the component.
     *
     * @return a string representing the function of the component.
     */

    @Override
    public String getFunction() {
        return " It is responsible for generating and accelerating an electron beam that is used to illuminate ù" +
                "and scan the sample to be observed.";
    }

    /**
     * Returns the type of electronic source used by the cannon.
     *
     * @return an ElectronSourceType representing the type of electronic source.
     */

    public ElectronSourceType getElectronicSourceType() {
        return electronicSourceType;
    }

    /**
     * Returns the type of the Cannon.
     *
     * @return a CannonType representing the type of the cannon.
     */

    public CannonType getCannonType() {
        return cannonType;
    }
}
