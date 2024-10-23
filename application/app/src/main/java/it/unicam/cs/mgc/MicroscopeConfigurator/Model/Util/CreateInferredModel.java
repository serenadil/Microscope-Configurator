package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;


import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;

/**
 * Interface for creating inferred RDF models.
 */
public interface CreateInferredModel {
    /**
     * Builds an inferred RDF model using the given base model and reasoner.
     *
     * @param model    the base RDF model
     * @param reasoner the reasoner to use for inference
     * @return the inferred RDF model
     */
    InfModel buildInferredModel(Model model, Reasoner reasoner);

    /**
     * Checks the consistency of the given inferred RDF model.
     *
     * @param infModel the inferred RDF model to check
     * @return true if the model is consistent, false otherwise
     */
    static boolean isConsistent(InfModel infModel) {
        ValidityReport validity = infModel.validate();
        return validity.isValid();
    }

    /**
     * Creates a standard reasoner for OWL.
     *
     * @return a standard OWL reasoner
     */
    static Reasoner createStandardReasoner() {
        return ReasonerRegistry.getOWLReasoner();
    }
}