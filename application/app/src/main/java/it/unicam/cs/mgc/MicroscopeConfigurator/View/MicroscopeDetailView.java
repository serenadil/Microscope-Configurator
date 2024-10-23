package it.unicam.cs.mgc.MicroscopeConfigurator.View;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames.MicroscopeDetailDatabaseName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.jena.rdf.model.Model;

/**
 * Represents a view for displaying the details of a specific microscope.
 * Provides information on the microscope components and software,
 * and includes a button to navigate back to the previous view.
 */
public class MicroscopeDetailView implements View {
    private final MicroscopeDetailDatabaseName detailDatabaseName;
    private final String microscopeName;
    private final UtilityView utilityView;
    private final VBox Vbox;

    /**
     * Constructs a MicroscopeDetailView instance.
     *
     * @param microscopeName The name of the microscope to display details for.
     * @param globalModel     The global model containing data about microscopes.
     */
    public MicroscopeDetailView(String microscopeName, Model globalModel) {
        this.microscopeName = microscopeName;
        this.utilityView = new UtilityView();
        this.detailDatabaseName = new MicroscopeDetailDatabaseName(globalModel, microscopeName);
        this.Vbox = createLayout();
    }

    /**
     * Creates the layout for the microscope detail view.
     *
     * @return A VBox containing the layout of the microscope detail view.
     */
    private VBox createLayout() {
        return utilityView.createVBox(Pos.TOP_CENTER, 30, new Insets(30),
                loadTitle(),
                loadTitleDetails(),
                loadDetails(),
                loadBackButton());
    }

    /**
     * Creates and returns the title label for the view.
     *
     * @return A Label containing the microscope name and the word "details".
     */
    private Label loadTitle() {
        return utilityView.createLabel(microscopeName + " details:");
    }

    /**
     * Creates and returns an HBox containing the titles for components and software sections.
     *
     * @return An HBox containing labels for microscope components and software.
     */
    private HBox loadTitleDetails() {
        return utilityView.createHBox(170, Pos.CENTER,
                utilityView.createLabel("Microscope components:"),
                utilityView.createLabel("Microscope softwares:"));
    }

    /**
     * Creates and returns an HBox containing list views for microscope components and software.
     *
     * @return An HBox containing multi-select list views for components and software.
     */
    private HBox loadDetails() {
        return utilityView.createHBox(40, Pos.CENTER,
                utilityView.createMultiSelectListView(detailDatabaseName.getComponentsNames(), 300, 400),
                utilityView.createMultiSelectListView(detailDatabaseName.getSoftwareNames(), 300, 400));
    }

    /**
     * Creates and returns a Button for navigating back to the previous view.
     *
     * @return A Button labeled "Back".
     */
    private Button loadBackButton() {
        return utilityView.createSimpleButton("Back", 100, 60);
    }

    /**
     * Sets the action handler for the Back button.
     *
     * @param handler The event handler to be set for the Back button.
     */
    public void setBackButtonAction(EventHandler<ActionEvent> handler) {
        ButtonUtility.setupActions(Vbox, "Back", handler);
    }

    /**
     * Returns the root view of the microscope detail pane.
     *
     * @return The VBox containing the layout of the microscope detail view.
     */
    @Override
    public Parent getView() {
        return this.Vbox;
    }
}