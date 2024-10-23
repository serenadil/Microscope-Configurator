package it.unicam.cs.mgc.MicroscopeConstitution;


import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.*;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.GenericMicroscopeComponent.Camera;
import it.unicam.cs.mgc.MicroscopeConstitution.Microscope.ElectronicMicroscopes.ScanningElectronicMicroscope;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysis;
import it.unicam.cs.mgc.MicroscopeConstitution.Software.SoftwareAnalysis.SoftwareAnalysisType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ScanningElectronicMicroscopeTest{
    private ScanningElectronicMicroscope microscope;
    private Cannon cannon;
    private VacuumPump vacuumPump;
    private Detector detector;

    @BeforeEach
    public void setUp() {
        cannon = new Cannon(12345, "HighPowerCo", CannonType.THERMOEMISSION_CANNON, ElectronSourceType.TUNGSTEN_FILAMENT);
        vacuumPump = new VacuumPump(54321, "VacuumTech", VacuumPumpType.CRYOGENIC_PUMP);
        detector = new Detector(67890, "DetectaCorp", DetectorType.SECONDARY_ELECTRON_DETECTOR);
        microscope = new ScanningElectronicMicroscope("SEM-1000", 1, cannon, vacuumPump, detector);
    }
    @Test
    public void testConstructor() {
        assertEquals("SEM-1000", microscope.getName());
        assertEquals(1, microscope.getSerialCode());
        assertEquals("This type of Microscope scans the surface of the sample with an electron beam, creating detailed three-dimensional images.", microscope.getDescription());
        assertEquals(cannon, microscope.getCannon());
        assertEquals(vacuumPump, microscope.getVacuumPump());
        assertEquals(detector, microscope.getDetector());
    }

    @Test
    public void testAddSoftwareValid() {
        SoftwareAnalysis validSoftware = new SoftwareAnalysis(1001, SoftwareAnalysisType.SOFTWARE_ANALYSIS_3D, "3D Analyzer", 1.0, "SoftCorp");
        assertTrue(microscope.addSoftware(validSoftware));
        assertFalse(microscope.addSoftware(validSoftware));
        assertTrue(microscope.containsSoftware(validSoftware));
    }

    @Test
    public void testAddSoftwareInvalid() {
        SoftwareAnalysis invalidSoftware = new SoftwareAnalysis(1002, SoftwareAnalysisType.SOFTWARE_ANALYSIS_MASSIVE_DATA, "Data Analyzer", 1.0, "SoftCorp");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> microscope.addSoftware(invalidSoftware));
        assertEquals("The software type SOFTWARE_ANALYSIS_MASSIVE_DATA is not useful in this type of microscope.", thrown.getMessage());
    }

    @Test
    public void testRemoveSoftware() {
        SoftwareAnalysis validSoftware = new SoftwareAnalysis(1001, SoftwareAnalysisType.SOFTWARE_ANALYSIS_3D, "3D Analyzer", 1.0, "SoftCorp");
        microscope.addSoftware(validSoftware);
        assertTrue(microscope.removeSoftware(validSoftware));
        assertFalse(microscope.containsSoftware(validSoftware));
    }


    @Test
    public void testAddComponent() {
        Camera camera = new Camera(2001, "LensCorp", 400,9);
        assertTrue(microscope.addSpecificComponent(camera));
        assertTrue(microscope.removeSpecificComponent(camera));
        microscope.addSpecificComponent(camera);
        assertTrue(microscope.removeSpecificComponent(camera));
        vacuumPump = new VacuumPump(5478, "VacuumTech", VacuumPumpType.CRYOGENIC_PUMP);
        detector = new Detector(77890, "DetectaCorp", DetectorType.SECONDARY_ELECTRON_DETECTOR);
        microscope.addSpecificComponent(vacuumPump);
        assertFalse(microscope.addSpecificComponent(vacuumPump));
        microscope.addSpecificComponent(detector);
        microscope.clearSpecificComponents();
        assertTrue(microscope.getSpecificComponents().isEmpty());
    }



}
