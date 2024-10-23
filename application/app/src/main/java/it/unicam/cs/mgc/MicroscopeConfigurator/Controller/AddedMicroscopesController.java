package it.unicam.cs.mgc.MicroscopeConfigurator.Controller;

import it.unicam.cs.mgc.MicroscopeConfigurator.View.AddedMicroscopesView;
import it.unicam.cs.mgc.MicroscopeConfigurator.View.MicroscopeDetailView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.jena.rdf.model.Model;

/**
 * Controller for managing interactions in the AddedMicroscopesView.
 * Handles actions such as navigating to the microscope detail page and going back to the home page.
 */
public class AddedMicroscopesController {
    private final Stage stage;
    private final AddedMicroscopesView view;
    private final Model globalModel;

    /**
     * Constructs an AddedMicroscopesController instance.
     *
     * @param stage         The primary stage for the application.
     * @param view          The AddedMicroscopesView to be managed.
     * @param globalModel   The global model containing data about microscopes.
     */
    public AddedMicroscopesController(Stage stage, AddedMicroscopesView view, Model globalModel) {
        this.stage = stage;
        this.view = view;
        this.globalModel = globalModel;
        setupActions();
    }

    /**
     * Sets up action handlers for the view's components.
     */
    private void setupActions() {
        view.setBackButtonAction(e -> goBackToHomePage());
        view.setDetailAction(e -> openMicroscopeDetailPage(view.getSelectedMicroscope()));
    }

    /**
     * Opens the microscope detail page for the selected microscope.
     *
     * @param name The name of the selected microscope.
     */
    private void openMicroscopeDetailPage(String name) {
        if (name != null && !name.isEmpty()) {
            MicroscopeDetailView detailView = new MicroscopeDetailView(name, globalModel);
            DetailController detailController = new DetailController(stage, detailView, globalModel);
            detailController.show();
        }
    }

    /**
     * Displays the AddedMicroscopesView on the stage.
     */
    public void show() {
        Scene scene = new Scene(view.getView(), 900, 700);
        scene.getStylesheets().add("/Style.css");
        stage.setScene(scene);
    }

    /**
     * Navigates back to the home page.
     */
    private void goBackToHomePage() {
        new HomeController(stage, globalModel).openHomePage();
    }
}