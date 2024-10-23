package it.unicam.cs.mgc.MicroscopeConfigurator.View;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.MyModel;
import org.apache.jena.rdf.model.Model;

/**
 * Singleton class providing access to the global instance of the application's model.
 * It initializes and provides access to the shared Model instance.
 */
public class GlobalModel {


    private static final Model modelInstance = new MyModel().getModel();

    /**
     * Retrieves the global instance of the application's model.
     *
     * @return The global Model instance.
     */
    public static Model getModelInstance() {
        return modelInstance;
    }
}