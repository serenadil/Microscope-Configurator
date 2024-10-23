package it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;

import java.util.Objects;

/**
 * Represents an illumination system used in optical microscopes.
 * This class extends MicroscopeComponent and implements OpticalMicroscopeComponent.
 */

public class IlluminationSystem extends MicroscopeComponent implements OpticalMicroscopeComponent {

    private int lightIntensity;
    private final IlluminationSystemType illuminationSystemType;

    /**
     * Constructs an IlluminationSystem with the specified serial code, producer company, and type of illumination system.
     *
     * @param serialCode             the serial code of the illumination system.
     * @param producerCompany        the company that produced the illumination system.
     * @param illuminationSystemType the type of the illumination system.
     * @throws NullPointerException if illuminationSystemType is null.
     */
    public IlluminationSystem(int serialCode, String producerCompany, IlluminationSystemType illuminationSystemType) {
        super(serialCode, producerCompany);
        Objects.requireNonNull(illuminationSystemType, " illuminationSystemType is null");
        this.illuminationSystemType = illuminationSystemType;
    }

    /**
     * Sets the light intensity of the illumination system.
     *
     * @param lightIntensity the intensity of the light.
     */

    private void setLightIntensity(int lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    /**
     * Returns the light intensity of the illumination system.
     *
     * @return the light intensity of the illumination system.
     */

    public int getLightIntensity() {
        return this.lightIntensity;
    }

    /**
     * Returns the function of the component.
     *
     * @return a string representing the function of the component.
     */

    @Override
    public String getFunction() {
        return "Devices that provide light for observation in optical microscopes.";
    }

    /**
     * Returns the type of the illumination system.
     *
     * @return a IlluminationSystemType representing the type of the Illumination system.
     */
    public IlluminationSystemType getIlluminationSystemType() {
        return illuminationSystemType;
    }
}