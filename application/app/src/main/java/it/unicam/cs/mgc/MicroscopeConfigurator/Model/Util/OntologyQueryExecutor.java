package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for executing SPARQL queries on RDF models.
 */

public class OntologyQueryExecutor implements QueryExecutor {

    /**
     * Executes a SPARQL query on a given model.
     *
     * @param model       the RDF model
     * @param SPARQLQuery the SPARQL query string
     * @return a list of query solutions
     */

    public List<QuerySolution> execute(Model model, String SPARQLQuery) {
        ArrayList<QuerySolution> resultList = new ArrayList<>();
        Query sparqlQuery = QueryFactory.create(SPARQLQuery);
        try (QueryExecution exec = QueryExecution.create(sparqlQuery, model)) {
            ResultSet results = exec.execSelect();
            while (results.hasNext()) {
                QuerySolution sol = results.nextSolution();
                resultList.add(sol);
            }
        }
        return resultList;
    }


}
