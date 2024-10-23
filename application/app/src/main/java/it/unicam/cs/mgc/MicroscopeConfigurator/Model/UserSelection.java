package it.unicam.cs.mgc.MicroscopeConfigurator.Model;

import java.util.List;

/**
 * Represents a user's selection of a microscope configuration.
 * This class stores the selected microscope name, the URI of the selected microscope type,
 * and the URIs of the selected software and components.
 */
public class UserSelection {
    private final String microscopeName;
    private final String selectedMicroscopeUri;
    private final List<String> selectedSoftwaresUri;
    private final List<String> selectedComponentsUri;

    /**
     * Constructs a UserSelection object with the provided microscope name, selected microscope type URI,
     * and lists of URIs for selected software and components.
     *
     * @param microscopeName the name of the selected microscope.
     * @param selectedMicroscopeTypeName the name of the selected microscope type.
     * @param selectedSoftwaresNames a list of names for the selected software.
     * @param selectedComponentsNames a list of names for the selected components.
     */
    public UserSelection(String microscopeName, String selectedMicroscopeTypeName, List<String> selectedSoftwaresNames, List<String> selectedComponentsNames) {
        MyOntologyNameFormatter formatter = new MyOntologyNameFormatter();
        this.microscopeName = microscopeName;
        this.selectedMicroscopeUri = MyOntologyNameFormatter.formatName(selectedMicroscopeTypeName);
        this.selectedSoftwaresUri = formatter.formatNames(selectedSoftwaresNames);
        this.selectedComponentsUri = formatter.formatNames(selectedComponentsNames);
    }

    /**
     * Gets the name of the selected microscope.
     *
     * @return the name of the microscope.
     */
    public String getMicroscopeName() {
        return microscopeName;
    }

    /**
     * Gets the URI of the selected microscope type.
     *
     * @return the URI of the microscope type.
     */
    public String getSelectedMicroscopeUri() {
        return selectedMicroscopeUri;
    }

    /**
     * Gets the list of URIs for the selected software.
     *
     * @return a list of URIs for the selected software.
     */
    public List<String> getSelectedSoftwaresUri() {
        return this.selectedSoftwaresUri;
    }

    /**
     * Gets the list of URIs for the selected components.
     *
     * @return a list of URIs for the selected components.
     */
    public List<String> getSelectedComponentsUri() {
        return this.selectedComponentsUri;
    }
}