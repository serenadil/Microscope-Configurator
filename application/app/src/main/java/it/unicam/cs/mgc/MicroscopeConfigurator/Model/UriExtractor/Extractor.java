package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor;

import java.util.List;


/**
 * Interface for extracting data from an RDF model.
 * Defines methods for extracting subclasses and individuals from a class in an RDF model.</p>
 */
public interface Extractor {

    /**
     * Extracts subclasses of a given class.
     *
     * @param selectedClass URI of the class to get subclasses for
     * @return List of subclass URIs
     */
    List<String> SubclassExtractor(String selectedClass);

    /**
     * Extracts individuals of a given class.
     *
     * @param selectedClass URI of the class to get individuals for
     * @return List of individual URIs
     */
    List<String> IndividualExtractor(String selectedClass);

    /**
     * Extracts property values for a given class and property from the RDF model.
     *
     * @param selectedClass URI of the class
     * @param property      URI of the property
     * @return List of property values
     */
    List<String> PropertyValueExtractor(String selectedClass, String property);
}