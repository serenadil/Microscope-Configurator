package it.unicam.cs.mgc.MicroscopeConstitution.Microscope;

import it.unicam.cs.mgc.MicroscopeConstitution.Software.GenericSoftware;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareType;

import java.util.Set;

/**
 * This interface defines the operations for managing software in a microscope system.
 */

public interface MicroscopeSoftwareManagement<T extends SoftwareType, S extends GenericSoftware<T>> {
    /**
     * Checks if a specific software is present in the list of installed software.
     *
     * @param software the software to be checked
     * @return true if the software is present, false otherwise
     * @throws NullPointerException if the software is null
     */
    boolean containsSoftware(S software);

    /**
     * Sets the types of software that are forbidden to be added to the microscope.
     *
     * @param forbiddenTypes a set of forbidden software types
     * @throws NullPointerException if the forbiddenTypes set is null
     */

    void setForbiddenTypes(Set<T> forbiddenTypes);

    Set<T> getForbiddenTypes();

    /*
     * Checks if a specific software can be added to the microscope.
     * This method contains the logic to validate the software against the forbidden types.
     *
     * @param software the software to be checked
     * @return true if the software can be added, false if it wasn't
     * @throws NullPointerException     if the software is null
     * @throws IllegalArgumentException if the software type is forbidden
     */



    boolean checkSoftware(S software);

    /**
     * Adds a specific software to the list of installed software if it is valid.
     *
     * @param software the software to be added
     * @return true if the software was successfully added, false if it was already present
     * @throws NullPointerException     if the software is null
     * @throws IllegalArgumentException if the software is invalid
     */

    boolean addSoftware(S software);

    /**
     * Removes a specific software from the list of installed software.
     *
     * @param software the software to be removed
     * @return true if the software was successfully removed, false if it was not found
     * @throws NullPointerException if the software is null
     */
    boolean removeSoftware(S software);

    /**
     * Clears all installed software from the list.
     */

    void clearSoftwares();

    /**
     * Retrieves the set of all installed software associated with the microscope.
     *
     * @return a set of installed software
     */

    Set<S> getSoftwareList();

    /**
     * Retrieves the set of all software types associated with the installed software.
     *
     * @return a set of software types
     */

    Set<T> getSoftwareTypeList();

}
