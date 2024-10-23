package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;

import java.util.Objects;

/**
 * Abstract class representing a query with prefixes.
 *
 * @param <P> the type of prefixes used in the query
 */

public abstract class Query<P extends Prefixes> implements SPARQLQuery, PrefixProvider<P> {
    private String query;
    private Prefixes prefix;

    /**
     * Sets the prefixes for the query.
     *
     * @param prefix the prefixes to set, must not be null
     */

    @Override
    public void setPrefix(P prefix) {
        Objects.requireNonNull(prefix, "Prefix cannot be null");
        this.prefix = prefix;
    }

    /**
     * Sets the query string.
     *
     * @param query the query string to set, must not be null
     */

    @Override
    public void setQuery(String query) {
        Objects.requireNonNull(query, "Query cannot be null");
        this.query = query;
    }

    /**
     * Gets the prefixes used in the query.
     *
     * @return the prefixes
     */

    @Override
    public Prefixes getPrefixies() {
        return this.prefix;
    }

    /**
     * Gets the query string.
     *
     * @return the query string
     */

    @Override
    public String getQuery() {
        return this.query;
    }

    /**
     * Gets the complete query string including prefixes.
     *
     * @return the complete query string
     */

    @Override
    public String getCompleteQuery() {
        return this.prefix.getPrefixes() + this.query;
    }
}
