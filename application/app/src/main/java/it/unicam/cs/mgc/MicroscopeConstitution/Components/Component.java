package it.unicam.cs.mgc.MicroscopeConstitution.Components;

/**
 * The Component interface represents a general component in the microscope system.
 * It defines methods to set and get the description, retrieve serial code and producer information,
 * and define the function of the component.
 */

public interface Component {


    /**
     * Sets the description of the component.
     *
     * @param description a component representing the description of the component.
     * @throws NullPointerException if the description is null.
     */

    void setDescription(String description);

    /**
     * Returns the description of the component.
     *
     * @return a description representing the description of the component.
     */

    String getDescription();

    /**
     * Returns the serial code of the component.
     *
     * @return an int representing the serial code of the component.
     */

    int getSerialCode();

    /**
     * Returns the name of the producer company for the component.
     *
     * @return a string representing the name of the producer company.
     */

    String getProducerCompany();

    /**
     * Returns the function of the component.
     *
     * @return a string representing the function of the component.
     */

    String getFunction();




}
