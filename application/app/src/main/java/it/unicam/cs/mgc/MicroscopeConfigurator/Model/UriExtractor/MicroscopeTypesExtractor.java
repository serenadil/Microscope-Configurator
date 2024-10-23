package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor;


import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Extractor for specific types of microscopes from the RDF model.
 *
 * <p>Responsibility: Extends MyExtractor to extract information about different types of microscopes.</p>
 */
public class MicroscopeTypesExtractor extends MyExtractor {

    /**
     * Constructs a MicroscopeTypesExtractor with the default configuration for extracting microscope types.
     *
     * @param model RDF model to extract data from
     */
    public MicroscopeTypesExtractor(Model model) {
        super(model);
    }

    /**
     * Extracts electronic microscope types.
     *
     * @return List of electronic microscope types
     */
    public List<String> ElectronicTypeMicroscopeExtractor() {
        return super.obtainSubClass("Electronic Microscope");
    }

    /**
     * Extracts optical microscope types.
     *
     * @return List of optical microscope types
     */
    public List<String> OpticalTypeMicroscopeExtractor() {
        return super.obtainSubClass("Optical Microscope");
    }
}