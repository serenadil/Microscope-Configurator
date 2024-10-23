package it.unicam.cs.mgc.MicroscopeConfigurator.Controller;

import it.unicam.cs.mgc.MicroscopeConfigurator.View.AddedMicroscopesView;
import it.unicam.cs.mgc.MicroscopeConfigurator.View.ConfigureElectronicMicroscopeView;
import it.unicam.cs.mgc.MicroscopeConfigurator.View.ConfigureOpticalMicroscopeView;
import it.unicam.cs.mgc.MicroscopeConfigurator.View.HomeView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.jena.rdf.model.Model;

/**
 * Controller class for the application's home screen.
 * Handles initialization of the home view, setting up the stage, and managing actions.
 */
public class HomeController {
    private final Stage primaryStage;
    private final Scene homeScene;
    private final Model globalModel;
    private final HomeView homeView;

    /**
     * Constructs a new HomeController with the primary stage and global model.
     * Initializes the home view and sets up the stage and actions.
     *
     * @param primaryStage The primary stage of the application.
     * @param globalModel The global model instance shared across the application.
     */
    public HomeController(Stage primaryStage, Model globalModel) {
        this.primaryStage = primaryStage;
        this.globalModel = globalModel;
        this.homeView = new HomeView(this);
        this.homeScene = new Scene(homeView.getView(), 900, 700);
        setupStage();
        setupAction();
    }

    /**
     * Sets up the stage for the home scene.
     * Adds CSS styles, sets the title, and shows the stage.
     */
    private void setupStage() {
        homeScene.getStylesheets().add("/Style.css");
        primaryStage.setScene(homeScene);
        primaryStage.setTitle("Microscope Configurator");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Sets up the action handlers for the buttons in the home view.
     * Associates each button with a specific action to open corresponding microscope configuration pages.
     */
    private void setupAction() {
        homeView.setElectronicMicroscopeButtonAction(e -> openElectronicMicroscopePage());
        homeView.setOpticalMicroscopeButtonAction(e -> openOpticalMicroscopePage());
        homeView.setAddedMicroscopeButtonAction(e -> openAddedMicroscopesPage());
    }

    /**
     * Opens the electronic microscope configuration page.
     * Initializes the view and controller for configuring electronic microscopes.
     */
    private void openElectronicMicroscopePage() {
        ConfigureElectronicMicroscopeView view = new ConfigureElectronicMicroscopeView(globalModel);
        ConfigureMicroscopeController controller = new ConfigureMicroscopeController(primaryStage, view, globalModel);
        controller.show();
    }

    /**
     * Opens the optical microscope configuration page.
     * Initializes the view and controller for configuring optical microscopes.
     */
    private void openOpticalMicroscopePage() {
        ConfigureOpticalMicroscopeView view = new ConfigureOpticalMicroscopeView(globalModel);
        ConfigureMicroscopeController controller = new ConfigureMicroscopeController(primaryStage, view, globalModel);
        controller.show();
    }

    /**
     * Opens the added microscopes management page.
     * Initializes the view and controller for managing added microscopes.
     */
    private void openAddedMicroscopesPage() {
        AddedMicroscopesView view = new AddedMicroscopesView(globalModel);
        AddedMicroscopesController controller = new AddedMicroscopesController(primaryStage, view, globalModel);
        controller.show();
    }

    /**
     * Opens the home page by setting the primary stage scene to the home scene.
     */
    public void openHomePage() {
        primaryStage.setScene(homeScene);
    }
}