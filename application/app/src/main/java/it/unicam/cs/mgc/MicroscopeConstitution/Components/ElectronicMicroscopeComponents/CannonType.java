package it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.ComponentType;

import java.util.Collections;
import java.util.List;

/**
 * The CannonType enum represents different types of electron guns used in electron microscopes.
 * Each type of cannon has a description and a list of forbidden electron sources.
 */

public enum CannonType implements ComponentType {

    THERMOEMISSION_CANNON("A device that generates an electron beam using the principle of " +
            "thermoemission, where electrons are emitted from a filament heated to high temperatures.",
            List.of(ElectronSourceType.SCHOTTY_SOURCE, ElectronSourceType.COLD_FEG)),

    FIELD_EMISSION_CANNON("A device that generates an electron beam through the phenomenon of " +
            "field emission, where a very strong electric field is applied to a very sharp metal tip (often tungsten) to extract electrons by tunnel effect. This type of emission occurs at low temperatures, without the need to heat the material.",
            List.of(ElectronSourceType.LaB6_THERMOIONIC_EMISSION_SOURCE, ElectronSourceType.TUNGSTEN_FILAMENT));

    private final String description;
    private final List<ElectronSourceType> forbiddenSources;

    /**
     * Constructs a CannonType with the specified description and a list of forbidden electron sources.
     *
     * @param description      a description of the cannon type.
     * @param forbiddenSources a list of ElectronSourceType representing sources that are forbidden for this cannon type.
     */

    CannonType(String description, List<ElectronSourceType> forbiddenSources) {
        this.description = description;
        this.forbiddenSources = Collections.unmodifiableList(forbiddenSources);
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

    /**
     * Returns the list of forbidden electron sources for this cannon type.
     *
     * @return a List of ElectronSourceType representing forbidden sources.
     */

    public List<ElectronSourceType> getForbiddenSources() {
        return forbiddenSources;
    }
}
