package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

import org.apache.jena.query.QuerySolution;

import java.util.List;

/**
 * Interface for parsing query solutions.
 */
public interface QueryParser {

    /**
     * Parses a list of query solutions to extract information for a specific resource.
     *
     * @param solutions the list of query solutions to parse
     * @param resource  the name of the resource to extract information for
     * @return a list of strings representing extracted information for the resource
     */
    List<String> parse(List<QuerySolution> solutions, String resource);
}