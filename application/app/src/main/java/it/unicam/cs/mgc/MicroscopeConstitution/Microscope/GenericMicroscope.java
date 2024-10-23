package it.unicam.cs.mgc.MicroscopeConstitution.Microscope;

/**
 * This interface represents a generic microscope with basic functionalities.
 */

public interface GenericMicroscope {

    /**
     * Returns the name of the microscope.
     *
     * @return the name of the microscope
     */

    String getName();

    /**
     * Returns the unique identifier of the microscope.
     *
     * @return the unique identifier of the microscope
     */

    int getSerialCode();

    /**
     * Returns a description of the microscope.
     * This method must be implemented by subclasses.
     *
     * @return a description of the microscope
     */

    String getDescription();

}
