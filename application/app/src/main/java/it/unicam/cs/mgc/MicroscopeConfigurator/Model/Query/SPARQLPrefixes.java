package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;

/**
 * Interface for managing SPARQL prefixes.
 */

public interface SPARQLPrefixes {
    /**
     * Adds a prefix with its URI.
     *
     * @param prefix the prefix string, must not be null
     * @param uri    the URI associated with the prefix, must not be null
     */
    void addPrefix(String prefix, String uri);

    /**
     * Removes a prefix.
     *
     * @param prefix the prefix string to remove, must not be null
     */
    void removePrefix(String prefix);

    /**
     * Gets all prefixes as a single string.
     *
     * @return a string containing all prefixes
     */
    String getPrefixes();
}
