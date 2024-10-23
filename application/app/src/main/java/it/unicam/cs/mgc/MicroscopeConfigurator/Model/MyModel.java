package it.unicam.cs.mgc.MicroscopeConfigurator.Model;


import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.DefaultModel;
import org.apache.jena.rdf.model.Model;


/**
 * Provides an RDF model for interacting with the microscope ontology data.
 * The model is initialized from the "MO.rdf" file, which defines the ontology for microscopes, including
 * types, components, and software.
 */
public class MyModel {

    /**
     * The RDF model instance initialized from "MO.rdf".
     */
    public final Model model;

    /**
     * Constructs a MyModel object and initializes the RDF model with "MO.rdf".
     */
    public MyModel() {
        model = new DefaultModel().buildDefaultModelFromPath("MO.rdf");
    }

    /**
     * Returns the RDF model instance.
     *
     * @return the RDF model.
     */
    public Model getModel() {
        return model;
    }
}