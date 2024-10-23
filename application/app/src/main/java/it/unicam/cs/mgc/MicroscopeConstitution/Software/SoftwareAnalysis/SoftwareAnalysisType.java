package it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis;

import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareType;

/**
 * This enum represents various types of software analysis used in microscope composition representation.
 * Each enum constant provides a description of the software type it represents.
 */

public enum SoftwareAnalysisType implements SoftwareType {

    SOFTWARE_ANALYSIS_3D("This type of software specializes " +
            "in analyzing three-dimensional images acquired by confocal microscopy " +
            "or other 3-D imaging techniques, enabling visualization, " +
            "segmentation, and analysis of three-dimensional structure"),

    SOFTWARE_ANALYSIS_FLUORESCENCE("This type of software is specifically " +
            "designed for analyzing fluorescent images acquired through the microscope."),

    SOFTWARE_ANALYSIS_MASSIVE_DATA("This type of software is used " +
            "for the analysis of large datasets generated by high-resolution or " +
            "high-throughput microscopy techniques."),

    SOFTWARE_ANALYSIS_MEASURING("Measurement software allows quantitative " +
            "measurements of the dimensions and characteristics of samples viewed through " +
            "an optical microscope. They can be used to measure lengths, areas, diameters, " +
            "angles and other dimensions of sample structures."),

    SOFTWARE_ANALYSIS_MORPHOLOGICAL("This type of software is designed for " +
            "analyzing the size and shape of structures observed through the microscope."),

    SOFTWARE_ANALYSIS_PARTICLE("Particle analysis software makes it possible " +
            "to identify, count and characterise the particles present in samples observed " +
            "through an optical microscope."),

    SOFTWARE_ANALYSIS_SPECTRAL("This type of software is designed for the " +
            "analysis of spectra obtained by spectroscopic microscopy."),

    SOFTWARE_ANALYSIS_SURFACE("Used for analysing the surface characteristics " +
            "of materials, such as roughness, topography and indentation depth."),

    SOFTWARE_ANALYSIS_TIME("This type of software is used to analyze temporal " +
            "data acquired by time-lapse microscopy.");

    private final String descriptionSoftware;

    /**
     * Constructor for SoftwareAnalysisType enum.
     *
     * @param descriptionSoftware the description of the software type
     */

    SoftwareAnalysisType(String descriptionSoftware) {
        this.descriptionSoftware = descriptionSoftware;
    }

    /**
     * Returns the description of the software type.
     *
     * @return the description of the software type
     */

    public String getDescriptionSoftware() {
        return this.descriptionSoftware;
    }
}
