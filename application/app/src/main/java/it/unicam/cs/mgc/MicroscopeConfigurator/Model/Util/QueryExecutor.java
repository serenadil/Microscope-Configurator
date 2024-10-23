package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Interface for executing SPARQL queries.
 */

public interface QueryExecutor {

    /**
     * Executes a SPARQL query on a given model.
     *
     * @param model       the RDF model
     * @param SPARQLQuery the SPARQL query string
     * @return a list of query solutions
     */

    List<QuerySolution> execute(Model model, String SPARQLQuery);
}
