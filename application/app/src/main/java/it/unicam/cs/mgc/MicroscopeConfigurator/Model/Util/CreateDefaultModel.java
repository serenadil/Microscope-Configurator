package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

import org.apache.jena.rdf.model.Model;

/**
 * Interface for creating and loading RDF models.
 */
public interface CreateDefaultModel {
    /**
     * Builds a default RDF model.
     *
     * @return a new default RDF model
     */
    Model buildDefaultModel();

    /**
     * Builds a default RDF model from a specified path.
     *
     * @param path the path to the RDF file
     * @return the loaded RDF model
     */
    Model buildDefaultModelFromPath(String path);

    /**
     * Loads an RDF model from a specified path into an existing model.
     *
     * @param path  the path to the RDF file
     * @param model the model to load the RDF data into
     * @return the loaded RDF model
     */
    Model loadModel(String path, Model model);
}
