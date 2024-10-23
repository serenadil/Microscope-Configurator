package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;

import java.util.List;

/**
 * Class representing the configuration of a microscope for SPARQL queries.
 */

public class MyConfiguration implements Configuration {
    private final String configuration;

    /**
     * Constructs a MyConfiguration instance with the specified details.
     *
     * @param microscopeName     the name of the microscope, must not be null
     * @param selectedMicroscope the selected microscope type, must not be null
     * @param selectedSoftwares  the list of selected software URIs, must not be null
     * @param selectedComponents the list of selected component URIs, must not be null
     */
    public MyConfiguration(String microscopeName, String selectedMicroscope, List<String> selectedSoftwares, List<String> selectedComponents) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(String.format("mo:%s rdf:type <%s> ; ", microscopeName, selectedMicroscope));
        queryBuilder.append(String.format("rdfs:label \"%s\" ; ", microscopeName));
        addInstalledSoftware(queryBuilder, selectedSoftwares);
        addComponents(queryBuilder, selectedComponents);
        int lastIndex = queryBuilder.lastIndexOf(" ; ");
        if (lastIndex != -1) {
            queryBuilder.replace(lastIndex, lastIndex + 3, " .");
        } else {
            queryBuilder.append(" .");
        }
        this.configuration = queryBuilder.toString();
    }

    /**
     * Adds installed software information to the query.
     *
     * @param queryBuilder      the query builder to append to, must not be null
     * @param selectedSoftwares the list of selected software URIs, must not be null
     */
    private void addInstalledSoftware(StringBuilder queryBuilder, List<String> selectedSoftwares) {
        if (selectedSoftwares != null && !selectedSoftwares.isEmpty()) {
            for (String softwareUri : selectedSoftwares) {
                queryBuilder.append(String.format("mo:integrate <%s> ; ", softwareUri));
            }
        }
    }

    /**
     * Adds components information to the query.
     *
     * @param queryBuilder       the query builder to append to, must not be null
     * @param selectedComponents the list of selected component URIs, must not be null
     */
    private void addComponents(StringBuilder queryBuilder, List<String> selectedComponents) {
        if (selectedComponents != null && !selectedComponents.isEmpty()) {
            for (String componentUri : selectedComponents) {
                queryBuilder.append(String.format("mo:is_composed_by <%s> ; ", componentUri));
            }
        }
    }

    /**
     * Gets the configuration string.
     *
     * @return the configuration string
     */
    public String getConfiguration() {
        return configuration;
    }
}

