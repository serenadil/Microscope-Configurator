package it.unicam.cs.mgc.MicroscopeConfigurator.Model;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyConfiguration;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.MyPrefixes;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Query.UpdateQuery;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.Util.UpdaterManager;
import org.apache.jena.rdf.model.Model;

/**
 * Configures a new microscope based on user selection.
 * This class handles the process of adding the user's configuration to the model.
 */
public class ConfigureNewMicroscope {

    /**
     * Adds a new microscope configuration to the model based on the user's selection.
     *
     * @param userSelection the user's selected microscope configuration.
     * @param model the model where the new configuration will be added.
     * @return true if the configuration was successfully added, false otherwise.
     */
    public boolean addUserConfiguration(UserSelection userSelection, Model model) {
        UpdaterManager manager = new UpdaterManager();
        UpdateQuery updateQuery = new UpdateQuery(new MyConfiguration(userSelection.getMicroscopeName(),
                userSelection.getSelectedMicroscopeUri(), userSelection.getSelectedSoftwaresUri(), userSelection.getSelectedComponentsUri()));
        updateQuery.setPrefix(new MyPrefixes());
        return manager.manageNewConfiguration(model, updateQuery);
    }
}