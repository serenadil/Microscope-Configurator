package it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;

import java.util.Objects;

/**
 * The Detector class represents a type of microscope component responsible for detecting electrons or photons emitted by a sample.
 * It extends MicroscopeComponent and implements ElectronicMicroscopeComponent.
 */

public class Detector extends MicroscopeComponent implements ElectronicMicroscopeComponent {
    private final DetectorType detectorType;

    /**
     * Constructs a Detector with the specified serial code and producer company.
     *
     * @param serialCode      the serial code of the detector.
     * @param producerCompany the name of the producer company.
     */

    public Detector(int serialCode, String producerCompany, DetectorType detectorType) {
        super(serialCode, producerCompany);
        Objects.requireNonNull(detectorType, "detectorType is null");
        this.detectorType = detectorType;
    }

    /**
     * Returns the function of the component.
     *
     * @return a string representing the function of the component.
     */

    @Override
    public String getFunction() {
        return "Used to detect electrons or photons emitted by samples.";
    }

    /**
     * Returns the type of the detector.
     *
     * @return a DetectorType representing the type of the detector.
     */

    public DetectorType getDetectorType() {
        return detectorType;
    }
}
