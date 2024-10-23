package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;


/**
 * Class for creating inferred RDF models.
 */
public class InferredModel implements CreateInferredModel {

    /**
     * Builds an inferred RDF model using the given base model and reasoner.
     *
     * @param model    the base RDF model
     * @param reasoner the reasoner to use for inference
     * @return the inferred RDF model
     */
    public InfModel buildInferredModel(Model model, Reasoner reasoner) {
        reasoner.bindSchema(model);
        return ModelFactory.createInfModel(reasoner, model);
    }
}