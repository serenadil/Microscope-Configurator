package it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.ComponentType;

/**
 * The DetectorType enum represents various types of detectors used in electron microscopes.
 * Each type of detector has a specific application and provides different kinds of information about the sample.
 */

public enum DetectorType implements ComponentType {
    BACKSCATTERED_ELECTRON_DETECTOR(" It detects backscattered electrons that are reflected or scattered by the " +
            "sample after elastic interactions with atoms in the sample. It provides information on the chemical composition " +
            "and topography of the sample."),

    ElECTRON_ENERGY_LOSS_DETECTOR("It measures the energy loss of electrons transmitted through the sample. This " +
            "energy loss provides detailed information on the chemical composition, electronic structure and properties of " +
            "materials."),

    ENERGY_DISPERSIVE_XRAY_DETECTOR("It detects the characteristic X-rays emitted by the sample when it is hit by " +
            "an electron beam. These X-rays are characteristic of the elements in the sample and provide information about " +
            "its elemental composition."),

    HIGANGLE_DIFFUSE_ELECTRON_DETECTOR("It detects electrons transmitted at high angles to the direction of the " +
            "incident beam, which have undergone incoherent scattering. It provides images with contrast mainly based on " +
            "atomic number, also known as Z-contrast."),

    SECONDARY_ELECTRON_DETECTOR("It detects the secondary electrons emitted by the sample after interaction with " +
            "the primary electron beam. It provides images with very fine topographical detail."),

    TTRASMITTED_ELECTRON_DETECTOR("It detects electrons that have passed through the sample. It can include " +
            "various types of detectors such as Bright Field (BF) and Dark Field (DF) to achieve different imaging modes."),

    WAVELENGHT_DISPERSIVE_XRAY_DETECTOR("It detects X-rays emitted by the sample with wavelength resolution, " +
            "allowing elemental analysis with greater precision than EDX. It uses a diffraction crystal to separate " +
            "X-rays according to their wavelength.");


    private final String description;

    /**
     * Constructs a DetectorType with the specified description.
     *
     * @param description the description of the detector type.
     */
    DetectorType(String description) {
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
