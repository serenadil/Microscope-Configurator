package it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query;

/**
 * Interface for providing prefixes.
 *
 * @param <P> the type of prefixes provided
 */

public interface PrefixProvider<P extends SPARQLPrefixes>  {

    /**
     * Sets the prefixes.
     *
     * @param prefix the prefixes to set, must not be null
     */

    void setPrefix(P prefix);

    /**
     * Gets the prefixes.
     *
     * @return the prefixes
     */

    Prefixes getPrefixies();

}
