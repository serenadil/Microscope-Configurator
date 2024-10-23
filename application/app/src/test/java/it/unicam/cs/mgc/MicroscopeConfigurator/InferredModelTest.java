package it.unicam.cs.mgc.MicroscopeConfigurator;


import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.CreateInferredModel;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.DefaultModel;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.InferredModel;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.reasoner.Reasoner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InferredModelTest {
    @Test
    public void testInferredModelConsistency() {
        DefaultModel defaultModel = new DefaultModel();
        Model model = defaultModel.buildDefaultModelFromPath("MO.rdf");
        Reasoner r = CreateInferredModel.createStandardReasoner();
        InferredModel inferredModel = new InferredModel();
        InfModel infModel = inferredModel.buildInferredModel(model, r);
        boolean isConsistent = CreateInferredModel.isConsistent(infModel);
        assertTrue(isConsistent);

   }
}



