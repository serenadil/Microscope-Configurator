package it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.ComponentType;

/**
 * Enum representing various types of electron sources used in electron microscopes.
 */

public enum ElectronSourceType implements ComponentType {

    SCHOTTY_SOURCE("It combines moderate heating with a strong electric field to stabilise electron emission."),

    COLD_FEG("It uses only the electric field without heating, resulting in a very stable and coherent electron " +
            "emission."),

    TUNGSTEN_FILAMENT(" A LaB₆ crystal heated to emit electrons via thermionic emission."),

    LaB6_THERMOIONIC_EMISSION_SOURCE("A tungsten filament heated to high temperatures (~2700 K) to emit electrons " +
            "via thermionic emission.");

    private final String description;

    /**
     * Constructs an ElectronSourceType with the specified description.
     *
     * @param description the description of the electron source type.
     */

    ElectronSourceType(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the component type.
     *
     * @return a0 String representing the description of the component type.
     */

    @Override
    public String getDescriptionType() {
        return description;
    }
}
