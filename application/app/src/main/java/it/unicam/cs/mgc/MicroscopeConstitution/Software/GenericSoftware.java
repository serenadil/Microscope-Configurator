package it.unicam.cs.mgc.MicroscopeConstitution.Software;


/**
 * This interface represents a generic software
 */

public interface GenericSoftware<T extends SoftwareType> {

    /**
     * Returns the serial code of the software.
     *
     * @return the serial code of the software
     */
    int getSerialCode();

    /**
     * Returns the name of the software.
     *
     * @return the name of the software
     */

    String getName();

    /**
     * Returns the version of the software.
     *
     * @return the version of the software
     */
    double getVersion();

    /**
     * Returns the type of the software.
     *
     * @return the type of the software as a string
     */

    T getType();

    /**
     * Returns the producer company of the software.
     *
     * @return the producer company of the software
     */
    String getSoftwareProducerCompany();


    /**
     * Returns the function description of the software analysis.
     *
     * @return the function description of the software analysis
     */

    String getSoftwareFunction();
}
