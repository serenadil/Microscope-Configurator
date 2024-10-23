package it.unicam.cs.mgc.MicroscopeConstitution.Microscope;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.Component;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.Software;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * This class represents a microscope with basic functionalities.
 * It implements the GenericMicroscope interface.
 */

public class Microscope<T extends SoftwareType, S extends Software<T>, P extends Component>
        implements GenericMicroscope, MicroscopeSoftwareManagement<T, S>, MicroscopeComponentManagement<P> {

    private final String microscopeName;
    private final int serialCode;
    private final String microscopeDescription;
    private final Set<S> softwareList;
    private final Set<T> softwareTypes;
    private final Set<P> componentList;
    private Set<T> forbiddenTypes;


    /**
     * Constructs a new Microscope with the specified name and id.
     *
     * @param name       the name of the microscope, must not be null
     * @param serialCode the unique identifier of the microscope, must not be negative
     * @throws NullPointerException     if the name is null
     * @throws IllegalArgumentException if the id is negative
     */

    public Microscope(String name, int serialCode, String microscopeDescription) {
        Objects.requireNonNull(name, "name must not be null");
        if (serialCode < 0) throw new IllegalArgumentException("id must not be negative");
        this.microscopeName = name;
        this.serialCode = serialCode;
        this.microscopeDescription = microscopeDescription;
        this.softwareList = new HashSet<>();
        this.softwareTypes = new HashSet<>();
        this.componentList = new HashSet<>();
    }

    /**
     * Returns the name of the microscope.
     *
     * @return the name of the microscope
     */

    @Override
    public String getName() {
        return this.microscopeName;
    }

    /**
     * Returns the unique identifier of the microscope.
     *
     * @return the unique identifier of the microscope
     */

    @Override
    public int getSerialCode() {
        return this.serialCode;
    }

    /**
     * Returns a description of the microscope.
     * This method must be implemented by subclasses.
     *
     * @return a description of the microscope
     */

    @Override
    public String getDescription() {
        return this.microscopeDescription;
    }

    /**
     * Checks if a specific software is present in the list of installed software.
     *
     * @param software the software to be checked
     * @return true if the software is present, false otherwise
     * @throws NullPointerException if the software is null
     */

    @Override
    public boolean containsSoftware(S software) {
        Objects.requireNonNull(software, "software must not be null");
        return this.softwareList.contains(software);
    }

    /**
     * Sets the types of software that are forbidden to be added to the microscope.
     *
     * @param forbiddenTypes a set of forbidden software types
     * @throws NullPointerException if the forbiddenTypes set is null
     */

    @Override
    public void setForbiddenTypes(Set<T> forbiddenTypes) {
        this.forbiddenTypes = forbiddenTypes;
    }

    /**
     * Retrieves the set of all forbidden software associated with the microscope.
     *
     * @return a set of forbidden software
     */

    @Override
    public Set<T> getForbiddenTypes() {
        return this.forbiddenTypes;
    }

    /*
     * Checks if a specific software can be added to the microscope.
     * This method contains the logic to validate the software against the forbidden types.
     *
     * @param software the software to be checked
     * @return true if the software can be added, false if it wasn't
     * @throws NullPointerException     if the software is null
     * @throws IllegalArgumentException if the software type is forbidden
     */

    @Override
    public boolean checkSoftware(S software) {
        Objects.requireNonNull(software, "software must not be null");
        if (forbiddenTypes.contains(software.getType())) {
            throw new IllegalArgumentException("The software type " + software.getType() +
                    " is not useful in this type of microscope.");
        }
        return true;
    }

    /**
     * Adds a specific software to the list of installed software if it is valid.
     *
     * @param software the software to be added
     * @return true if the software was successfully added, false if it was already present
     * @throws NullPointerException     if the software is null
     * @throws IllegalArgumentException if the software is invalid
     */
    @Override
    public boolean addSoftware(S software) {
        if (checkSoftware(software) && !this.softwareList.contains(software)) {
            this.softwareList.add(software);
            this.softwareTypes.add(software.getType());
            return true;
        }
        return false;
    }

    /**
     * Removes a specific software from the list of installed software.
     *
     * @param software the software to be removed
     * @return true if the software was successfully removed, false if it was not found
     * @throws NullPointerException if the software is null
     */

    @Override
    public boolean removeSoftware(S software) {
        Objects.requireNonNull(software, "software must not be null");
        if (this.softwareList.contains(software)) {
            this.softwareList.remove(software);
            this.softwareTypes.remove(software.getType());
            return true;
        }
        return false;
    }

    /**
     * Clears all installed software from the list.
     */

    @Override
    public void clearSoftwares() {
        this.softwareList.clear();
        this.softwareTypes.clear();
    }

    /**
     * Retrieves the set of all installed software associated with the microscope.
     *
     * @return a set of installed software
     */

    @Override
    public Set<S> getSoftwareList() {
        return this.softwareList;
    }

    /**
     * Retrieves the set of all software types associated with the installed software.
     *
     * @return a set of software types
     */

    @Override
    public Set<T> getSoftwareTypeList() {
        return this.softwareTypes;
    }

    /**
     * Checks if a specific component is present in the list of components.
     *
     * @param component the component to be checked
     * @return true if the component is present, false otherwise
     * @throws NullPointerException if the component is null
     */

    @Override
    public boolean containSpecificComponent(P component) {
        Objects.requireNonNull(component, "component must not be null");
        return this.componentList.contains(component);
    }

    /**
     * Adds a specific component to the list of components if it is valid.
     *
     * @param component the component to be added
     * @return true if the component was successfully added, false if it was already present
     * @throws NullPointerException if the component is null
     */

    @Override
    public boolean addSpecificComponent(P component) {
        if (!containSpecificComponent(component)) {
            this.componentList.add(component);
            return true;
        }
        return false;
    }

    /**
     * Removes a specific component from the list of components.
     *
     * @param component the component to be removed
     * @return true if the component was successfully removed, false if it was not found
     * @throws NullPointerException if the component is null
     */

    @Override
    public boolean removeSpecificComponent(P component) {
        Objects.requireNonNull(component, "component must not be null");
        return this.componentList.remove(component);
    }

    /**
     * Clears all components from the list.
     */

    @Override
    public void clearSpecificComponents() {
        componentList.clear();
    }

    /**
     * Retrieves the set of all specific components associated with the microscope.
     *
     * @return a set of components
     */

    @Override
    public Set<P> getSpecificComponents() {
        return this.componentList;
    }

}
