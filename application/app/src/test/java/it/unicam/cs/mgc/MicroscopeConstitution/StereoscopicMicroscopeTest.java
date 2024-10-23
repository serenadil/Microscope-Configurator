package it.unicam.cs.mgc.MicroscopeConstitution;

import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.IlluminationSystem;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.IlluminationSystemType;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.Objective;
import it.unicam.cs.mgc.MicroscopeConstitution.Microscope.OpticalMicroscopes.StereoscopicMicroscope;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysis;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysisType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StereoscopicMicroscopeTest {

    private StereoscopicMicroscope microscope;
    private Objective objective;
    private IlluminationSystem illuminationSystem;

    @BeforeEach
    public void setUp() {
        objective = new Objective(8956,"High Power",89);
        illuminationSystem = new IlluminationSystem(8962,"", IlluminationSystemType.LED);
        microscope = new StereoscopicMicroscope("StereoScope", 12345, StereoscopicMicroscope.microscopeDescription, objective, illuminationSystem);
    }

    @Test
    public void testConstructorValidInputs() {
        assertNotNull(microscope);
        assertEquals("StereoScope", microscope.getName());
        assertEquals(12345, microscope.getSerialCode());
        assertEquals(StereoscopicMicroscope.microscopeDescription, microscope.getDescription());
        assertEquals(objective, microscope.getObjective());
        assertEquals(illuminationSystem, microscope.getIlluminationSystem());
    }

    @Test
    public void testConstructorNullName() {
        assertThrows(NullPointerException.class, () -> new StereoscopicMicroscope(null, 12345, StereoscopicMicroscope.microscopeDescription, objective, illuminationSystem));
    }

    @Test
    public void testConstructorNegativeSerialCode() {
        assertThrows(IllegalArgumentException.class, () -> new StereoscopicMicroscope("StereoScope", -1, StereoscopicMicroscope.microscopeDescription, objective, illuminationSystem));
    }

    @Test
    public void testConstructorNullObjective() {
        assertThrows(NullPointerException.class, () -> new StereoscopicMicroscope("StereoScope", 12345, StereoscopicMicroscope.microscopeDescription, null, illuminationSystem));
    }

    @Test
    public void testConstructorNullIlluminationSystem() {
        assertThrows(NullPointerException.class, () -> new StereoscopicMicroscope("StereoScope", 12345, StereoscopicMicroscope.microscopeDescription, objective, null));
    }

    @Test
    public void testForbiddenSoftwareTypes() {
        Set<SoftwareAnalysisType> forbiddenTypes = microscope.getForbiddenTypes();
        assertTrue(forbiddenTypes.contains(SoftwareAnalysisType.SOFTWARE_ANALYSIS_MORPHOLOGICAL));
        assertTrue(forbiddenTypes.contains(SoftwareAnalysisType.SOFTWARE_ANALYSIS_MASSIVE_DATA));
        assertTrue(forbiddenTypes.contains(SoftwareAnalysisType.SOFTWARE_ANALYSIS_SPECTRAL));
        assertTrue(forbiddenTypes.contains(SoftwareAnalysisType.SOFTWARE_ANALYSIS_FLUORESCENCE));
    }

    @Test
    public void testAddForbiddenSoftware() {
        SoftwareAnalysis forbiddenSoftware = new SoftwareAnalysis(1001, SoftwareAnalysisType.SOFTWARE_ANALYSIS_MORPHOLOGICAL, "Morpho Analyzer", 1.0, "SoftCorp");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> microscope.addSoftware(forbiddenSoftware));
        assertEquals("The software type SOFTWARE_ANALYSIS_MORPHOLOGICAL is not useful in this type of microscope.", thrown.getMessage());
    }

    @Test
    public void testAddAllowedSoftware() {
        SoftwareAnalysis allowedSoftware = new SoftwareAnalysis(1002, SoftwareAnalysisType.SOFTWARE_ANALYSIS_3D, "Data Analyzer", 1.0, "SoftCorp");
        assertTrue(microscope.addSoftware(allowedSoftware));
        assertTrue(microscope.getSoftwareList().contains(allowedSoftware));
    }
}
