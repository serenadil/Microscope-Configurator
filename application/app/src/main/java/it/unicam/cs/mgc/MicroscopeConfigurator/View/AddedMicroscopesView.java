package it.unicam.cs.mgc.MicroscopeConfigurator.View;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames.MicroscopesDatabaseNames;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import org.apache.jena.rdf.model.Model;

/**
 * View class for displaying a list of added microscopes.
 * Allows the user to select a microscope to view its details and provides a button to navigate back.
 */
public class AddedMicroscopesView implements View {
    private final VBox vbox;
    private final UtilityView utilityView;
    private final MicroscopesDatabaseNames microscopesDatabaseNames;
    private EventHandler<ActionEvent> detailHandler;
    private ListView<String> listView;

    /**
     * Constructs an AddedMicroscopesView instance.
     *
     * @param globalModel The global model containing data about microscopes.
     */
    public AddedMicroscopesView(Model globalModel) {
        this.utilityView = new UtilityView();
        this.microscopesDatabaseNames = new MicroscopesDatabaseNames(globalModel);
        this.vbox = createLayout();
        setupListViewAction();
    }

    /**
     * Creates the layout for the added microscopes view.
     *
     * @return A VBox containing the layout of the added microscopes view.
     */
    private VBox createLayout() {
        return utilityView.createVBox(
                Pos.TOP_CENTER,
                20,
                new Insets(50),
                loadTitle(),
                loadData(),
                loadBackButton()
        );
    }

    /**
     * Creates and returns the title label for the view.
     *
     * @return A Label with the title "Added Microscopes".
     */
    private Label loadTitle() {
        return utilityView.createLabel("Added Microscopes");
    }

    /**
     * Creates and returns a ListView for displaying the names of added microscopes.
     *
     * @return A ListView containing the names of added microscopes.
     */
    private ListView<String> loadData() {
        listView = utilityView.createMultiSelectListView(microscopesDatabaseNames.getNames(), 200, 500);
        return listView;
    }

    /**
     * Creates and returns a Button for navigating back to the previous view.
     *
     * @return A Button labeled "Back".
     */
    private Button loadBackButton() {
        return utilityView.createSimpleButton("Back", 150, 60);
    }

    /**
     * Sets the action handler for the Back button.
     *
     * @param handler The event handler to be set for the Back button.
     */
    public void setBackButtonAction(EventHandler<ActionEvent> handler) {
        ButtonUtility.setupActions(vbox, "Back", handler);
    }

    /**
     * Sets the action handler for selecting a microscope to view its details.
     *
     * @param handler The event handler to be set for the microscope detail action.
     */
    public void setDetailAction(EventHandler<ActionEvent> handler) {
        this.detailHandler = handler;
    }

    /**
     * Sets up an action for the ListView to handle double-click events.
     */
    private void setupListViewAction() {
        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && detailHandler != null) {
                String selectedName = listView.getSelectionModel().getSelectedItem();
                if (selectedName != null) {
                    detailHandler.handle(new ActionEvent(selectedName, null));
                }
            }
        });
    }

    /**
     * Gets the name of the currently selected microscope in the ListView.
     *
     * @return The name of the selected microscope.
     */
    public String getSelectedMicroscope() {
        return listView.getSelectionModel().getSelectedItem();
    }

    /**
     * Returns the root view of the added microscopes pane.
     *
     * @return The VBox containing the layout of the added microscopes view.
     */
    @Override
    public Parent getView() {
        return vbox;
    }
}