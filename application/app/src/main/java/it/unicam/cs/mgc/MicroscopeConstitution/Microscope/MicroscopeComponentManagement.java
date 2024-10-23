package it.unicam.cs.mgc.MicroscopeConstitution.Microscope;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;

import java.util.Set;

/**
 * This interface defines the management operations for microscope components.
 * It provides methods to handle specific components used in the microscope.
 *
 * @param <P> the type of the microscope component that extends MicroscopeComponent
 */

public interface MicroscopeComponentManagement<P> {
    /**
     * Checks if a specific component is present in the list of components.
     *
     * @param component the component to be checked
     * @return true if the component is present, false otherwise
     * @throws NullPointerException if the component is null
     */

    boolean containSpecificComponent(P component);


    /**
     * Adds a specific component to the list of components if it is valid.
     *
     * @param component the component to be added
     * @return true if the component was successfully added, false if it was already present
     * @throws NullPointerException     if the component is null
     */

    boolean addSpecificComponent(P component);

    /**
     * Removes a specific component from the list of components.
     *
     * @param component the component to be removed
     * @return true if the component was successfully removed, false if it was not found
     * @throws NullPointerException     if the component is null
     */

    boolean removeSpecificComponent(P component);

    /**
     * Clears all components from the list.
     */

    void clearSpecificComponents();

    /**
     * Retrieves the set of all specific components associated with the microscope.
     *
     * @return a set of components
     */

    Set<P> getSpecificComponents();

}
