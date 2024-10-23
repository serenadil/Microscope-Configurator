package it.unicam.cs.mgc.MicroscopeConstitution.Components.GenericMicroscopeComponent;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.ComponentType;

/**
 * Enum representing various types of optical filters.
 * Each filter type is associated with a specific optical property or application.
 */

public enum FilterType implements ComponentType {

    ANTIREFLECTION_FILTER("Antireflection filter used to reduce reflections from surfaces.It minimizes " +
            "the amount of light reflected off the surface of the optical component."),

    COLOR_CORRECTION_FILTER("Color correction filter used to adjust the color balance of the image.It " +
            "compensates for color inaccuracies in optical systems."),

    POLARIZATION_FILTER("Polarization filter used to control the orientation of light waves.It allows only " +
            "light waves with a specific polarization direction to pass through."),

    PROTECTIVE_FILTER("Protective filter used to safeguard optical components from dust, scratches, and other " +
            "damage.It acts as a physical barrier to protect more expensive optical elements."),

    LEUVIR_FILTER("Leuvier filter, also known as a color balancing filter.It is used to correct the color " +
            "temperature of light in optical systems.");

    private final String description;

    /**
     * Constructs a new FilterType with the specified description.
     *
     * @param description A brief description of the filter type's function or application.
     */

    FilterType(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the filter type.
     *
     * @return A string providing a description of the filter type.
     */

    @Override
    public String getDescriptionType() {
        return this.description;
    }
}
