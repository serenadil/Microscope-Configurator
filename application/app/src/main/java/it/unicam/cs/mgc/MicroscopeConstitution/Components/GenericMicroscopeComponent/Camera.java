package it.unicam.cs.mgc.MicroscopeConstitution.Components.GenericMicroscopeComponent;


import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.ElectronicMicroscopeComponent;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.OpticalMicroscopeComponent;

/**
 * Represents a camera component used in both optical and electronic microscopes.
 * This class extends MicroscopeComponent and implements OpticalMicroscopeComponent and ElectronicMicroscopeComponent.
 */

public class Camera extends MicroscopeComponent implements OpticalMicroscopeComponent, ElectronicMicroscopeComponent {

    public final int cameraResolution;
    public final int acquisitionSpeed;

    /**
     * Constructs a Camera with the specified component ID, producer company, resolution, and acquisition speed.
     *
     * @param componentId      the unique identifier for the camera component.
     * @param producerCompany  the company that produced the camera.
     * @param cameraResolution the resolution of the camera, must be greater than 0.
     * @param acquisitionSpeed the acquisition speed of the camera, must be greater than 0.
     * @throws IllegalArgumentException if cameraResolution or acquisitionSpeed is less than 1.
     */

    public Camera(int componentId, String producerCompany, int cameraResolution, int acquisitionSpeed) {
        super(componentId, producerCompany);
        if (cameraResolution < 1)
            throw new IllegalArgumentException("cameraResolution value is not allowed");
        if (acquisitionSpeed < 1)
            throw new IllegalArgumentException("acquisitionSpeed value is not allowed");
        this.cameraResolution = cameraResolution;
        this.acquisitionSpeed = acquisitionSpeed;
    }

    /**
     * Returns the function of the component.
     *
     * @return a string representing the function of the component.
     */

    @Override
    public String getFunction() {
        return "- Cameras are used to capture images of samples observed under the microscope.";
    }

    /**
     * Returns the resolution of the camera.
     *
     * @return an int representing the resolution of the camera.
     */
    public int getCameraResolution() {
        return this.cameraResolution;
    }

    /**
     * Returns the acquisition speed of the camera.
     *
     * @return an int representing the acquisition speed of the camera.
     */

    public int getAcquisitionSpeed() {
        return this.acquisitionSpeed;
    }
}
