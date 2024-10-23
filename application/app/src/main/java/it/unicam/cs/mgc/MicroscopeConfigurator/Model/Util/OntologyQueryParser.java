package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

import org.apache.jena.query.QuerySolution;

import java.util.ArrayList;
import java.util.List;


/**
 * Class for parsing query solutions to extract URIs associated with a specific resource.
 */
public class OntologyQueryParser implements QueryParser {

    /**
     * Parses a list of query solutions to extract URIs for a specified resource.
     *
     * @param solutions the list of query solutions to parse
     * @param resource  the name of the resource whose URI is to be extracted
     * @return a list of URIs associated with the specified resource
     */
    @Override
    public List<String> parse(List<QuerySolution> solutions, String resource) {
        List<String> parseResult = new ArrayList<>();
        for (QuerySolution solution : solutions) {
            if (solution.contains(resource)) {
                String uri = solution.getResource(resource).getURI();
                parseResult.add(uri);
            }
        }
        return parseResult;
    }
}
