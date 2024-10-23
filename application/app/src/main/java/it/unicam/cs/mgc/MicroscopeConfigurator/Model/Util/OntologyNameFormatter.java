package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

/**
 * Utility class for formatting ontology names.
 */
public class OntologyNameFormatter {

    /**
     * Formats a name by trimming whitespace, replacing spaces with underscores, and adding a prefix.
     *
     * @param prefix the prefix to prepend to the formatted name
     * @param name   the name to format
     * @return the formatted name with the prefix
     */
    public static String formatName(String prefix, String name) {
        String formattedName = name.trim().replaceAll("\\s+", "_");
        formattedName = prefix + formattedName;
        return formattedName;
    }
}