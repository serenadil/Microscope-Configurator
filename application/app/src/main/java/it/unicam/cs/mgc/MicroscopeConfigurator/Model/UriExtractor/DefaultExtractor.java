package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.*;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.QueryExecutor;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.QueryParser;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * class for extracting data from an RDF model using SPARQL queries.
 * Provides methods to extract information from an RDF model using SPARQL queries.
 */
public class DefaultExtractor implements Extractor {

    private final QueryExecutor executor;
    private final Model model;
    private final QueryParser parser;
    private final Prefixes prefixes;

    /**
     * Constructs a DefaultExtractor with the specified RDF model, query executor, parser, and prefixes.
     *
     * @param model    RDF model to extract data from
     * @param executor SPARQL query executor
     * @param parser   Query solution parser
     * @param prefixes SPARQL query prefixes
     */
    public DefaultExtractor(Model model, QueryExecutor executor, QueryParser parser, Prefixes prefixes) {
        this.model = model;
        this.executor = executor;
        this.parser = parser;
        this.prefixes = prefixes;
    }

    /**
     * Extracts subclasses of a given class from the RDF model.
     *
     * @param selectedClass URI of the class to get subclasses for
     * @return List of subclass URIs
     */
    public List<String> SubclassExtractor(String selectedClass) {
        SelectSubclassQuery getSubclass = new SelectSubclassQuery(selectedClass);
        getSubclass.setPrefix(prefixes);
        List<QuerySolution> results = executor.execute(model, getSubclass.getCompleteQuery());
        return parser.parse(results, "subClass");
    }

    /**
     * Extracts individuals of a given class from the RDF model.
     *
     * @param selectedClass URI of the class to get individuals for
     * @return List of individual URIs
     */
    public List<String> IndividualExtractor(String selectedClass) {
        SelectIndividualQuery query = new SelectIndividualQuery(selectedClass);
        query.setPrefix(new MyPrefixes());
        List<QuerySolution> result = executor.execute(model, query.getCompleteQuery());
        return parser.parse(result, "individual");
    }

    /**
     * Extracts property values for a given class and property from the RDF model.
     *
     * @param selectedClass URI of the class
     * @param property      URI of the property
     * @return List of property values
     */
    public List<String> PropertyValueExtractor(String selectedClass, String property) {
        SelectPropertyValuesQuery query = new SelectPropertyValuesQuery(selectedClass, property);
        query.setPrefix(new MyPrefixes());
        List<QuerySolution> result = executor.execute(model, query.getCompleteQuery());
        return parser.parse(result, "value");
    }
}
