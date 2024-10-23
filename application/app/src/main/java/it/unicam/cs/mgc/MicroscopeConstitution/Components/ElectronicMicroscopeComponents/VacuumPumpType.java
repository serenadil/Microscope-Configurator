package it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.ComponentType;

/**
 * The VacuumPumpType enum represents various types of vacuum pumps used in electron microscopes.
 * Each type of pump serves different vacuum levels and has specific applications.
 */

public enum VacuumPumpType implements ComponentType {

    CRYOGENIC_PUMP("Used for ultra-high vacuums with cooling capacity."),

    TURBO_MOLECULAR_PUMP("Used for high vacuums (up to 10^-7 mbar)."),

    IONIC_PUMP("Used for ultra-high vacuums (up to 10^-10 mbar)."),

    MECHANICAL_PUMP("Used for medium vacuums (up to 10^-3 mbar).");


    private final String description;

    /**
     * Constructs a VacuumPumpType with the specified description.
     *
     * @param description the description of the vacuum pump type.
     */

    VacuumPumpType(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the component type.
     *
     * @return a String representing the description of the component type.
     */

    @Override
    public String getDescriptionType() {
        return this.description;
    }
}
