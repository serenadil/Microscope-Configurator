package it.unicam.cs.mgc.MicroscopeConfigurator.Extractors;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Software.SoftwareAnalysisExtractor;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.MyModel;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyPrefixes;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.OntologyNameFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoftwareAnalysisExtractorTest {
    private SoftwareAnalysisExtractor extractor;

    @BeforeEach
    public void setUp() {
        extractor = new SoftwareAnalysisExtractor(new MyModel().getModel());
    }

    @Test
    public void testSoftwareAnalysis3DExtractor() {
        List<String> results = extractor.extract3DAnalysisSoftware();
        assertEquals(2, results.size());
        assertEquals(results.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "Imaris"));

    }

    @Test
    public void testSoftwareAnalysisMeasuringExtractor() {
        List<String> results = extractor.extractMeasuringAnalysisSoftware();
        assertEquals(1, results.size());
        assertEquals(results.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "ImageJ"));


    }

    @Test
    public void testSoftwareAnalysisMassiveDataExtractor() {
        List<String> results = extractor.extractMassiveDataAnalysisSoftware();
        assertEquals(2, results.size());
        assertEquals(results.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "OMERO"));

    }


}
