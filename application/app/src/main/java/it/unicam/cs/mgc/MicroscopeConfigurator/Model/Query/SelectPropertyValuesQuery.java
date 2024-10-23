package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;

/**
 * A query for selecting distinct values of a specific property for a given individual.
 * This class builds a SPARQL query that retrieves the values of a property for a specified individual.
 */
public class SelectPropertyValuesQuery extends Query<Prefixes> {

    /**
     * Constructs a SelectPropertyValuesQuery with the given individual URI and property URI.
     * The query string is formulated to select distinct values for a specific property of a given individual.
     * @param individualURI the URI of the individual whose property values are to be retrieved
     * @param propertyURI   the URI of the property whose values are to be selected
     */
    public SelectPropertyValuesQuery(String individualURI, String propertyURI) {
        String queryString = "SELECT DISTINCT ?value  " +
                "WHERE { " +
                "<" + individualURI + "> <" + propertyURI + "> ?value . " +
                "}";

        setQuery(queryString);
    }
}