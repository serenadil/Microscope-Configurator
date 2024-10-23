package it.unicam.cs.mgc.MicroscopeConstitution.Components;


import java.util.Objects;

/**
 * The MicroscopeComponent class is an abstract base class for all components of a microscope.
 * It implements the Component interface and provides common functionality for all components,
 * such as setting and getting the description, serial code, and producer company information.
 */

public abstract class MicroscopeComponent implements Component {

    private final int serialCode;
    private final String producerCompany;
    private String description;

    /**
     * Constructs a {@code MicroscopeComponent} with the specified serial code and producer company.
     *
     * @param serialCode the serial code of the component.
     * @param producerCompany the name of the producer company.
     * @throws NullPointerException if producerCompany is null.
     * @throws IllegalArgumentException if  serialCode is negative.
     */

    public MicroscopeComponent(int serialCode, String producerCompany) {
        Objects.requireNonNull(producerCompany, "Producer company cannot be null");
        if (serialCode < 0) throw new IllegalArgumentException("serialCode cannot be negative");
        this.serialCode = serialCode;
        this.producerCompany = producerCompany;
    }

    /**
     * Sets the description of the component.
     *
     * @param description a component representing the description of the component.
     * @throws NullPointerException if the description is null.
     */

    @Override
    public void setDescription(String description) {
        Objects.requireNonNull(description);
        this.description = description;
    }

    /**
     * Returns the description of the component.
     *
     * @return a description representing the description of the component.
     */

    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the serial code of the component.
     *
     * @return an int representing the serial code of the component.
     */

    @Override
    public int getSerialCode() {
        return this.serialCode;
    }

    /**
     * Returns the name of the producer company for the component.
     *
     * @return a string representing the name of the producer company.
     */

    @Override
    public String getProducerCompany() {
        return this.producerCompany;
    }

    /**
     * Returns the function of the component.
     *
     * @return a string representing the function of the component.
     */

    @Override
    public abstract String getFunction();


}
