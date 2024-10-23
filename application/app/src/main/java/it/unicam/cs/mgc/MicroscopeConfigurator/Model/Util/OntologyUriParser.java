package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

/**
 * Utility class for processing URIs to extract human-readable names.
 */
public class OntologyUriParser {

    /**
     * Processes a URI by removing a specified prefix and replacing underscores with spaces.
     *
     * @param prefix the prefix to remove from the URI
     * @param uri    the URI to process
     * @return the name extracted from the URI with spaces instead of underscores
     */
    public static String processUri(String prefix, String uri) {
        String name = uri.startsWith(prefix) ? uri.substring(prefix.length()) : uri;
        name = name.replace('_', ' ');
        return name;
    }
}