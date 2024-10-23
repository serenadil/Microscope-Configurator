package it.unicam.cs.mgc.MicroscopeConfigurator.Extractors;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.MicroscopeTypesExtractor;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.MyModel;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyPrefixes;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.OntologyNameFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MicroscopeTypeExtractorTest {
    private MicroscopeTypesExtractor extractor;

    @BeforeEach
    public void setUp() {
        extractor = new MicroscopeTypesExtractor(new MyModel().getModel());
    }

    @Test
    public void testElectronicTypeMicroscopeExtractor() {
        List<String> results = extractor.ElectronicTypeMicroscopeExtractor();
        assertEquals(2, results.size());
        assertEquals(results.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "Transmission Electron Microscope"));
    }

    @Test
    public void testOpticalTypeMicroscopeExtractor() {
        List<String> results = extractor.OpticalTypeMicroscopeExtractor();
        assertEquals(6, results.size());
        assertEquals(results.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "Stereoscopic Microscope"));
    }
}
