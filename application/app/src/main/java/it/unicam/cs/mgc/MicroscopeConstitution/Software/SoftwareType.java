package it.unicam.cs.mgc.MicroscopeConstitution.Software;

/**
 * This interface defines a contract for software types used in microscope composition representation.
 * Implementing classes must provide a method to retrieve the description of the software type.
 */

public interface SoftwareType {

    /**
     * Returns the description of the software type.
     *
     * @return the description of the software type
     */

    String getDescriptionSoftware();
}
