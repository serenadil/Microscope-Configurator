package it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;

/**
 * Represents an objective lens used in optical microscopes.
 * This class extends MicroscopeComponent and implements OpticalMicroscopeComponent.
 */

public class Ocular extends MicroscopeComponent implements OpticalMicroscopeComponent {

    private final int ocularEnlargement;

    /**
     * Constructs an Objective with the specified serial code, producer company, and enlargement factor.
     *
     * @param serialCode          the serial code of the objective lens.
     * @param producerCompany     the company that produced the objective lens.
     * @param ocularEnlargement the magnification factor of the objective lens.
     */
    public Ocular(int serialCode, String producerCompany, int ocularEnlargement) {
        super(serialCode, producerCompany);
        this.ocularEnlargement = ocularEnlargement;
    }

    /**
     * Returns the function of the component.
     *
     * @return a string representing the function of the component.
     */

    @Override
    public String getFunction() {
        return "Lenses through which the user views the magnified image in optical microscopes.";
    }
    /**
     * Returns the magnification factor of the objective lens.
     *
     * @return the magnification factor of the objective lens.
     */

    public int getOcularEnlargement() {
        return ocularEnlargement;
    }
}
