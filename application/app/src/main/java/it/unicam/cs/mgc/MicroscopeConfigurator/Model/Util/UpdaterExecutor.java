package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.update.UpdateAction;


/**
 * Class for executing SPARQL update queries on RDF models.
 */
public class UpdaterExecutor {

    /**
     * Executes a SPARQL update query on a given RDF model.
     *
     * @param model             the RDF model to be updated
     * @param sparqlUpdateQuery the SPARQL update query to execute
     */
    public void executeSparqlUpdate(Model model, String sparqlUpdateQuery) {
        UpdateAction.parseExecute(sparqlUpdateQuery, model);
    }
}