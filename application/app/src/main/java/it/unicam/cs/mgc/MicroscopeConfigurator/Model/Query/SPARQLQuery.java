package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;

/**
 * Interface representing a SPARQL query.
 */

public interface SPARQLQuery {

    /**
     * Sets the query string.
     *
     * @param query the SPARQL query string, must not be null
     */
    void setQuery(String query);

    /**
     * Gets the query string.
     *
     * @return the SPARQL query string
     */
    String getQuery();

    /**
     * Gets the complete query string including prefixes.
     *
     * @return the complete SPARQL query string
     */
    String getCompleteQuery();


}
