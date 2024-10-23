package it.unicam.cs.mgc.MicroscopeConstitution.Software;

import java.util.Objects;

/**
 * This abstract class represents a software with a specific type.
 *
 * @param <T> the type of the software
 */

public abstract class Software<T extends SoftwareType> implements GenericSoftware<T> {

    private final int serialCode;
    private final T type;
    private final String softwareName;
    private final double softwareVersion;
    private final String producerCompany;

    /**
     * Constructs a new software instance.
     *
     * @param serialCode      the serial code of the software
     * @param type            the type of the software
     * @param softwareName    the name of the software
     * @param softwareVersion the version of the software
     * @param producerCompany the producer company of the software
     */

    public Software(int serialCode, T type, String softwareName, double softwareVersion, String producerCompany) {
        Objects.requireNonNull(type, "Type must not be null");
        Objects.requireNonNull(softwareName, "Software name must not be null");
        Objects.requireNonNull(producerCompany, "Producer company must not be null");
        if (serialCode < 0) throw new IllegalArgumentException("Serial code must not be negative");
        if (softwareVersion < 1.0) throw new IllegalArgumentException("Software version must not be less than 1.0");
        this.serialCode = serialCode;
        this.type = type;
        this.softwareName = softwareName;
        this.softwareVersion = softwareVersion;
        this.producerCompany = producerCompany;
    }

    /**
     * Returns the serial code of the software.
     *
     * @return the serial code of the software
     */

    @Override
    public int getSerialCode() {
        return this.serialCode;
    }

    /**
     * Returns the name of the software.
     *
     * @return the name of the software
     */

    @Override
    public String getName() {
        return this.softwareName;
    }

    /**
     * Returns the version of the software.
     *
     * @return the version of the software
     */

    @Override
    public double getVersion() {
        return this.softwareVersion;
    }

    /**
     * Returns the type of the software.
     *
     * @return the type of the software as a string
     */

    @Override
    public T getType() {
        return this.type;
    }

    /**
     * Returns the producer company of the software.
     *
     * @return the producer company of the software
     */

    @Override
    public String getSoftwareProducerCompany() {
        return this.producerCompany;
    }

    /**
     * Returns the function description of the software analysis.
     *
     * @return the function description of the software analysis
     */


    @Override
    public String getSoftwareFunction() {
        return this.type.getDescriptionSoftware();
    }

    /**
     * Returns a string representation of the software analysis.
     *
     * @return a string representation of the software analysis
     */

    @Override
    public String toString() {
        return "SoftwareAnalysis{" +
                ", type=" + this.getType() +
                ", softwareName='" + softwareName + '\'' +
                ", softwareVersion=" + softwareVersion +
                ", producerCompany='" + producerCompany + '\'' +
                '}';
    }
}
