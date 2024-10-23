package it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;

public class Objective extends MicroscopeComponent implements OpticalMicroscopeComponent{

    private final int objectiveEnlargment;
    public Objective(int serialCode, String producerCompany, int objectiveEnlargment) {
        super(serialCode, producerCompany);
        this.objectiveEnlargment = objectiveEnlargment;
    }
    /**
     * Returns the function of the component.
     *
     * @return a string representing the function of the component.
     */

    @Override
    public String getFunction() {
        return "Lenses used in optical microscopes to magnify the image of the specimen.";
    }

    public int getObjectiveEnlargment() {
        return objectiveEnlargment;
    }
}
