package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyPrefixes;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.OntologyNameFormatter;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.OntologyQueryExecutor;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.OntologyQueryParser;
import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Extractor for the microscope ontology with default query components.
 */
public abstract class MyExtractor {
    private final DefaultExtractor extractor;
    /**
     * Constructs a MyExtractor for the specified RDF model with default query components.
     *
     * @param model RDF model to extract data from
     */
    public MyExtractor(Model model) {
        extractor = new DefaultExtractor(model, new OntologyQueryExecutor(), new OntologyQueryParser(), new MyPrefixes());
    }

    /**
     * Gets subclasses of a formatted class name.
     *
     * @param className Name of the class
     * @return List of subclass URIs
     */
    public List<String> obtainSubClass(String className) {
        return extractor.SubclassExtractor(OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), className));
    }

    /**
     * Gets individuals of a formatted class name.
     *
     * @param className Name of the class
     * @return List of individual URIs
     */
    public List<String> obtainIndividual(String className) {
        return extractor.IndividualExtractor(OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), className));
    }

    /**
     * Gets property values for a formatted class name and property name.
     *
     * @param className    Name of the class
     * @param propertyName Name of the property
     * @return List of property values
     */
    public List<String> obtainPropertyValue(String className, String propertyName) {
        return extractor.PropertyValueExtractor(
                OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), className),
                OntologyNameFormatter.formatName(MyPrefixes.getOntologyURI(), propertyName)
        );
    }
}
