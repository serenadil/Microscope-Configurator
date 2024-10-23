package it.unicam.cs.mgc.MicroscopeConfigurator.Controller;

import it.unicam.cs.mgc.MicroscopeConfigurator.View.AddedMicroscopesView;
import it.unicam.cs.mgc.MicroscopeConfigurator.View.MicroscopeDetailView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.jena.rdf.model.Model;

/**
 * Controller for managing the interactions in the MicroscopeDetailView.
 * Handles the navigation and actions related to the microscope details view.
 */
public class DetailController {
    private final Stage stage;
    private final MicroscopeDetailView view;
    private final Model globalModel;

    /**
     * Constructs a DetailController instance.
     *
     * @param stage   The primary stage for the application.
     * @param view    The MicroscopeDetailView to be managed.
     * @param globalModel The global model containing data about microscopes.
     */
    public DetailController(Stage stage, MicroscopeDetailView view, Model globalModel) {
        this.stage = stage;
        this.view = view;
        this.globalModel = globalModel;
        setupActions();
    }

    /**
     * Sets up the action handlers for the view's components.
     */
    private void setupActions() {
        view.setBackButtonAction(e -> goBackToAddedMicroscopesPage());
    }

    /**
     * Displays the microscope detail view on the stage.
     */
    public void show() {
        Scene scene = new Scene(view.getView(), 900, 700);
        scene.getStylesheets().add("/Style.css");
        stage.setScene(scene);
    }

    /**
     * Navigates back to the AddedMicroscopesView.
     */
    private void goBackToAddedMicroscopesPage() {
        AddedMicroscopesView addedMicroscopesView = new AddedMicroscopesView(globalModel);
        AddedMicroscopesController controller = new AddedMicroscopesController(stage, addedMicroscopesView, globalModel);
        controller.show();
    }
}