package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.DeleteQuery;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.UpdateQuery;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.reasoner.Reasoner;

/**
 * Manages RDF model updates and checks configuration validity.
 */
public class UpdaterManager {

    private final Reasoner reasoner;
    private final UpdaterExecutor updaterExecutor;

    /**
     * Constructs an UpdaterManager with a standard OWL reasoner and an UpdaterExecutor.
     */
    public UpdaterManager() {
        this.reasoner = CreateInferredModel.createStandardReasoner();
        updaterExecutor = new UpdaterExecutor();
    }

    /**
     * Manages a new configuration by executing an update query and checking the model's consistency.
     * If the model is not consistent after the update, a delete query is executed to revert the changes.
     *
     * @param model      the RDF model to be updated
     * @param updateQuery the update query containing the SPARQL query to be executed
     * @return true if the model is consistent after the update, false otherwise
     */
    public boolean manageNewConfiguration(Model model, UpdateQuery updateQuery) {
        updaterExecutor.executeSparqlUpdate(model, updateQuery.getCompleteQuery());
        if (!checkModel(model)) {
            DeleteQuery deleteQuery = new DeleteQuery(updateQuery);
            updaterExecutor.executeSparqlUpdate(model, deleteQuery.getCompleteQuery());
            return false;
        } else return true;
    }

    /**
     * Checks the consistency of the RDF model using the OWL reasoner.
     *
     * @param model the RDF model to be checked
     * @return true if the model is consistent, false otherwise
     */
    private boolean checkModel(Model model) {
        InferredModel inferredModel = new InferredModel();
        InfModel infModel = inferredModel.buildInferredModel(model, reasoner);
        return CreateInferredModel.isConsistent(infModel);
    }
}
