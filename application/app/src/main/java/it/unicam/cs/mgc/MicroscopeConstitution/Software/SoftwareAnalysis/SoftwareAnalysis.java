package it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis;

import it.unicam.cs.mgc.MicroscopeConstitution.Software.Software;

/**
 * Represents a specific type of software used for analysis in microscopy.
 * This class extends the Software class with a specific type parameter
 * SoftwareAnalysisType which describes the type of analysis performed by the software.
 */
public class SoftwareAnalysis extends Software<SoftwareAnalysisType> {

    /**
     * Constructs a new SoftwareAnalysis object with the specified details.
     *
     * @param serialCode      the serial code of the software
     * @param type            the type of the software analysis, must not be null
     * @param softwareName    the name of the software, must not be null
     * @param softwareVersion the version of the software, must be at least 1.0
     * @param producerCompany the company that produced the software, must not be null
     */

    public SoftwareAnalysis(int serialCode, SoftwareAnalysisType type, String softwareName, double softwareVersion, String producerCompany) {
        super(serialCode, type, softwareName, softwareVersion, producerCompany);

    }
}
