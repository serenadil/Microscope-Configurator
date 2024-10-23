package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;


import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class for managing SPARQL prefixes.
 */

public abstract class Prefixes implements SPARQLPrefixes {

    private final Map<String, String> prefixes = new HashMap<>();

    /**
     * Adds a prefix with its URI.
     *
     * @param prefix the prefix string, must not be null
     * @param uri    the URI associated with the prefix, must not be null
     */

    @Override
    public void addPrefix(String prefix, String uri) {
        prefixes.put(prefix, uri);
    }

    /**
     * Removes a prefix.
     *
     * @param prefix the prefix string to remove, must not be null
     */

    @Override
    public void removePrefix(String prefix) {
        prefixes.remove(prefix);
    }

    /**
     * Gets all prefixes as a single string.
     *
     * @return a string containing all prefixes
     */

    @Override
    public String getPrefixes() {
        StringBuilder prefixBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : prefixes.entrySet()) {
            prefixBuilder.append(String.format("PREFIX %s: <%s>\n", entry.getKey(), entry.getValue()));
        }
        return prefixBuilder.toString();
    }
}
