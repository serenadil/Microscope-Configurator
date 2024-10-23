package it.unicam.cs.mgc.MicroscopeConfigurator.Model;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyPrefixes;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.OntologyNameFormatter;

import java.util.ArrayList;
import java.util.List;



/**
 * A class for formatting ontology names.
 * This class provides methods for converting URIs to formatted names based on ontology prefixes.
 */
public class MyOntologyNameFormatter extends OntologyNameFormatter {

    /**
     * Formats a list of URIs to their string representations using the ontology prefix.
     *
     * @param uris a list of URIs to be formatted.
     * @return a list of formatted names derived from the URIs.
     */
    public List<String> formatNames(List<String> uris) {
        List<String> formattedNames = new ArrayList<>();
        for (String uri : uris) {
            String formattedName = formatName(MyPrefixes.getOntologyURI(), uri);
            formattedNames.add(formattedName);
        }
        return formattedNames;
    }

    /**
     * Formats a single URI to its string representation using the ontology prefix.
     *
     * @param uri the URI to be formatted.
     * @return the formatted name derived from the URI.
     */
    public static String formatName(String uri) {
        return formatName(MyPrefixes.getOntologyURI(), uri);
    }
}

