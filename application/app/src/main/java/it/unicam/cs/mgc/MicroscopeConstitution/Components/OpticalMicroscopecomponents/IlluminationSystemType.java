package it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.ComponentType;

/**
 * Enum representing various types of illumination systems used in microscopes.
 */

public enum IlluminationSystemType implements ComponentType {

    GAS_DISCHARGE("A type of lighting that generates light by passing an electric current through an ionised " +
            "gas. This type of lighting is used in gas discharge lamps, such as sodium, mercury and neon lamps."),

    HALOGENE("Incandescent lamps contain a small amount of halogen gas such as iodine or bromine, which " +
            "recycles evaporated tungsten to improve lamp efficiency and lifetime."),

    LASER("A device that emits light through optical amplification based on the stimulated emission " +
            "of electromagnetic radiation. It produces a coherent, highly collimated light beam with a specific " +
            "wavelength."),

    LED("A light-emitting diode that produces light through the junction of two semiconductors that emit " +
            "photons when an electric current passes through them. LEDs are efficient, durable.");


    private final String description;
    /**
     * Constructs an IlluminationSystemType with the specified description.
     *
     * @param description the description of the illumination system type.
     */

    IlluminationSystemType(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the component type.
     *
     * @return a String representing the description of the component type.
     */

    @Override
    public String getDescriptionType() {
        return description;
    }
}
