package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;


/**
 * A class that extends the Prefixes class to provide default RDF prefixes.
 * This class sets up a set of common prefixes for RDF and OWL namespaces, as well as a custom prefix for a microscope ontology.
 */
public class MyPrefixes extends Prefixes {

    /**
     * The URI for the microscope ontology.
     */
    private static final String ontologyUri = "http://www.unicam.it/cs/serenadileonardo/microscope-ontology#";

    /**
     * Constructs a MyPrefixes instance with default prefixes.
     * The constructor initializes the following prefixes:
     */
    public MyPrefixes() {
        this.addPrefix("owl", "http://www.w3.org/2002/07/owl#");
        this.addPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
        this.addPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        this.addPrefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
        this.addPrefix("mo", ontologyUri);
    }

    /**
     * Returns the URI for the microscope ontology.
     *
     * @return the ontology URI as a string
     */
    public static String getOntologyURI() {
        return ontologyUri;
    }
}