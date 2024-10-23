package it.unicam.cs.mgc.MicroscopeConfigurator.Controller;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.ConfigureNewMicroscope;
import it.unicam.cs.mgc.MicroscopeConfigurator.Model.UserSelection;
import it.unicam.cs.mgc.MicroscopeConfigurator.View.ConfigureMicroscopeView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.jena.rdf.model.Model;
/**
 * Controller class responsible for managing the configuration of a microscope.
 */
public class ConfigureMicroscopeController {
    private final Stage stage;
    private final ConfigureMicroscopeView view;
    private final Model globalModel;

    /**
     * Constructor for ConfigureMicroscopeController.
     *
     * @param stage The primary stage of the application.
     * @param view The view component for configuring the microscope.
     * @param globalModel The global model containing application data.
     */
    public ConfigureMicroscopeController(Stage stage, ConfigureMicroscopeView view, Model globalModel) {
        this.stage = stage;
        this.view = view;
        this.globalModel = globalModel;
        setupActions();
    }

    /**
     * Sets up actions for buttons in the view.
     * Sets actions for the Back button to navigate to the home page and the Save button to save configuration.
     */
    private void setupActions() {
        view.setBackButtonAction(e -> goBackToHomePage());
        view.setSaveButtonAction(e -> saveConfiguration());
    }

    /**
     * Displays the configured microscope view in a scene.
     *
     */
    public void show() {
        Scene scene = new Scene(view.getView(), 900, 700);
        scene.getStylesheets().add("/Style.css");
        stage.setScene(scene);
    }

    /**
     * Navigates back to the home page when the back button is clicked
     */
    private void goBackToHomePage() {
        new HomeController(stage, globalModel).openHomePage();
    }

    /**
     * Saves the current microscope configuration.
     * If successful, updates the view to indicate the configuration has been saved.
     */
    private void saveConfiguration() {
        UserSelection userSelection = new UserSelection(
                view.getMicroscopeName(),
                view.getSelectedMicroscopeType(),
                view.getSelectedSoftwares(),
                view.getSelectedMicroscopeComponents()
        );
        ConfigureNewMicroscope configurator = new ConfigureNewMicroscope();
        boolean success = configurator.addUserConfiguration(userSelection, globalModel);
        if (success) {
            view.setSaveButtonToSaved();
        }
    }
}