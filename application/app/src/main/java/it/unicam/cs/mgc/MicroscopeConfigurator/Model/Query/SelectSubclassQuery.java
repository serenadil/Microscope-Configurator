package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;

/**
 * Class representing a SPARQL SELECT query to find subclasses of a specified class.
 */

public class SelectSubclassQuery extends Query<Prefixes>{

    /**
     * Constructs a SelectSubclassQuery for the given class.
     *
     * @param selectedClass the class to find subclasses of, must not be null
     */

    public SelectSubclassQuery(String selectedClass) {
        setQuery("SELECT ?subClass " +
                "WHERE { " +
                "?subClass rdfs:subClassOf <" + selectedClass + "> .}");
    }
}
