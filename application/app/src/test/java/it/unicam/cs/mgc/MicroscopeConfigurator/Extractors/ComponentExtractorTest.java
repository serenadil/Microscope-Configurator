package it.unicam.cs.mgc.MicroscopeConfigurator.Extractors;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Component.ElectronicComponentExtractor;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Component.MixedComponentExtractor;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor.Component.OpticalComponentExtractor;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.MyModel;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyPrefixes;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.OntologyNameFormatter;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.OntologyUriParser;
import org.apache.jena.rdf.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComponentExtractorTest {

    private ElectronicComponentExtractor electronicExtractor;
    private OpticalComponentExtractor opticalExtractor;
    private MixedComponentExtractor mixedExtractor;

    @BeforeEach
    public void setUp() {
        Model model =new MyModel().getModel();
        electronicExtractor = new ElectronicComponentExtractor(model);
        opticalExtractor = new OpticalComponentExtractor(model);
        mixedExtractor = new MixedComponentExtractor(model);
    }

    @Test
    public void testCameraExtractor() {

        List<String> results = mixedExtractor.extractCamera();
        assertEquals(2, results.size());
        assertEquals(results.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "CMOS"));
    }
    @Test
    public void testCannonExtractor() {

        List<String> results = electronicExtractor.extractCannon();
        assertEquals(2, results.size());
        assertEquals(results.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "Thermoemission Cannon"));
        assertEquals("Thermoemission Cannon", OntologyUriParser.processUri(MyPrefixes.getOntologyURI(),results.getFirst()));
    }

    @Test
    public void testOcularExtractor() {

        List<String> results = opticalExtractor.extractOcular();
        assertEquals(6, results.size());
        assertEquals(results.getFirst(), OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), "Oc5x"));
    }
}
