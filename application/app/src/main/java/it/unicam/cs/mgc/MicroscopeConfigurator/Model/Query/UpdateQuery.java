package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;


/**
 * Class representing a SPARQL UPDATE query.
 */

public class UpdateQuery extends Query<Prefixes> {

    private final Configuration configuration;

    /**
     * Constructs an UpdateQuery with the given configuration.
     *
     * @param configuration the configuration for the update query, must not be null
     */

    public UpdateQuery(Configuration configuration) {
        this.configuration = configuration;
        setQuery("INSERT DATA  {" + configuration.getConfiguration() + "}");
    }

    /**
     * Gets the configuration string.
     *
     * @return the configuration string
     */

    public String getConfiguration() {
        return this.configuration.getConfiguration();
    }


}
