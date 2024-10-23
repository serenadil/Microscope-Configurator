package it.unicam.cs.mgc.MicroscopeConfigurator.Model.UriExtractor;

import java.util.List;


/**
 * Interface for retrieving data from a database.
 * Defines a method to get all data from a database.
 */
public interface Database {

    /**
     * Retrieves all data from the database.
     *
     * @return List of all data URIs
     */
    List<String> getAllData();
}