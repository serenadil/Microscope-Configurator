package it.unicam.cs.mgc.MicroscopeConfigurator.Model;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyPrefixes;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.OntologyUriParser;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for parsing ontology URIs.
 * This class provides methods for converting URIs to their string representations by processing them with ontology prefixes.
 */
public class MyOntologyParserUri extends OntologyUriParser {

    /**
     * Parses a list of URIs to their string representations by processing them with ontology prefixes.
     *
     * @param uris a list of URIs to be parsed.
     * @return a list of parsed URIs.
     */
    public List<String> parseUris(List<String> uris) {
        List<String> parseUris = new ArrayList<>();
        for (String uri : uris) {
            String parseUri = processUri(MyPrefixes.getOntologyURI(), uri);
            parseUris.add(parseUri);
        }
        return parseUris;
    }

    /**
     * Parses a single URI to its string representation by processing it with ontology prefixes.
     *
     * @param uri the URI to be parsed.
     * @return the parsed URI.
     */
    public String parseUri(String uri) {
        return processUri(MyPrefixes.getOntologyURI(), uri);
    }
}
