package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;



/**
 * Class representing a SPARQL DELETE query.
 */

public class DeleteQuery extends Query<Prefixes> {

    /**
     * Constructs a DeleteQuery based on an existing UpdateQuery.
     *
     * @param updateQuery the update query to convert to a delete query, must not be null
     */

    public DeleteQuery(UpdateQuery updateQuery) {
        setPrefix(updateQuery.getPrefixies());
        setQuery("DELETE DATA {" + updateQuery.getConfiguration() + "}");
    }

}
