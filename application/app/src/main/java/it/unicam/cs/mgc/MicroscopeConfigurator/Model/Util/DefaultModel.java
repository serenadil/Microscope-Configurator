package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * Class for creating and loading default RDF models.
 */

public class DefaultModel implements CreateDefaultModel {

    private final FileManager fileManager = FileManager.getInternal();

    /**
     * Builds a default RDF model.
     *
     * @return a new default RDF model
     */

    @Override
    public Model buildDefaultModel() {
        return ModelFactory.createDefaultModel();
    }

    /**
     * Builds a default RDF model from a specified file path.
     *
     * @param fileName the path to the RDF file
     * @return the loaded RDF model
     */

    @Override
    public Model buildDefaultModelFromPath(String fileName) {
        return this.loadModel(fileName, ModelFactory.createDefaultModel());
    }

    /**
     * Loads an RDF model from a specified file path into an existing model.
     *
     * @param fileName the path to the RDF file
     * @param model    the model to load the RDF data into
     * @return the loaded RDF model
     */

    @Override
    public Model loadModel(String fileName, Model model) {
        try (InputStream input = fileManager.open(fileName)) {
            Objects.requireNonNull(input, "file " + fileName + " not found");
            model.read(input, null);
        } catch (IOException ex) {
            throw new RuntimeException("Error reading RDF file from path: " + fileName, ex);
        }
        return model;
    }


}
