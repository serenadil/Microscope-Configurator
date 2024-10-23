package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;

/**
 * Class representing a SPARQL SELECT query to find individuals of a specified class.
 */

public class SelectIndividualQuery extends Query<Prefixes> {

    /**
     * Constructs a SelectIndividualQuery for the given class.
     *
     * @param selectedClass the class to find individuals of, must not be null
     */

    public SelectIndividualQuery(String selectedClass) {
        setQuery("SELECT ?individual " +
                "WHERE { " +
                "?individual rdf:type <" + selectedClass + "> .}");
    }
}
