package it.unicam.cs.mgc.MicroscopeConfigurator.View;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames.MicroscopeOptionsNames;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An abstract class representing a view for configuring a microscope.
 * Provides a layout for entering microscope details, selecting types, and other configurations.
 */
public abstract class ConfigureMicroscopeView implements View {
    private final GridPane gridPane;
    private final UtilityView utilityView;
    private final MicroscopeOptionsNames microscopeOption;
    private HBox buttons;
    protected TextField nameTextField;
    protected ComboBox<String> typeComboBox;
    protected List<CheckBoxListViewWrapper> sectionList = new ArrayList<>();

    /**
     * Constructs a ConfigureMicroscopeView instance.
     *
     * @param type             The type of microscope to configure.
     * @param microscopeOption The available options for the microscope.
     */
    public ConfigureMicroscopeView(String type, MicroscopeOptionsNames microscopeOption) {
        this.utilityView = new UtilityView();
        this.gridPane = utilityView.createGridPane(3, 10, 20, 20, true, Pos.TOP_CENTER);
        this.microscopeOption = microscopeOption;
        configureLayout(type);
        addFieldListeners();
    }

    /**
     * Configures the layout of the view by adding title, type selection, name input,
     * microscope sections, and buttons.
     *
     * @param type The type of microscope to configure.
     */
    private void configureLayout(String type) {
        addTitleLabel(type);
        addTypeSection();
        addNameSection();
        addMicroscopeSections();
        addButtons();
    }

    /**
     * Adds a title label to the top of the layout.
     *
     * @param type The type of microscope to configure.
     */
    private void addTitleLabel(String type) {
        Label titleLabel = utilityView.createLabel("Configure " + type + " Microscope");
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        GridPane.setValignment(titleLabel, VPos.CENTER);
        gridPane.add(titleLabel, 0, 0, 3, 1);
    }

    /**
     * Adds a section for selecting the type of microscope.
     */
    private void addTypeSection() {
        typeComboBox = utilityView.createComboBox(microscopeOption.getMicroscopeOptions(), "", 300);
        HBox typeBox = utilityView.createHBox(10, Pos.CENTER, utilityView.createLabel("Select Type  "), typeComboBox);
        gridPane.add(typeBox, 0, 1, 3, 1);
    }

    /**
     * Adds a section for entering the name of the microscope.
     */
    private void addNameSection() {
        Label nameLabel = utilityView.createLabel("Enter Name, only letters and numbers");
        nameTextField = utilityView.createTextField("", 300);
        HBox nameBox = utilityView.createHBox(10, Pos.CENTER, nameLabel, nameTextField);
        gridPane.add(nameBox, 0, 2, 3, 1);
    }

    /**
     * Adds sections for configuring the different components of the microscope (e.g., cameras, filters).
     */
    private void addMicroscopeSections() {
        int rowIndex = 3;
        int colIndex = 0;
        List<CheckBoxListViewWrapper> wrappers = createTabs();
        for (CheckBoxListViewWrapper wrapper : wrappers) {
            VBox sectionBox = new VBox(10, wrapper.label(), wrapper.checkBoxListView());
            gridPane.add(sectionBox, colIndex, rowIndex);
            colIndex++;
            if (colIndex == 3) {
                colIndex = 0;
                rowIndex++;
            }
        }
    }

    /**
     * Adds a section with buttons (e.g., Back, Save) to the layout.
     */
    private void addButtons() {
        buttons = utilityView.createHBox(20, Pos.CENTER, utilityView.createSimpleButton("Back", 250, 60), utilityView.createSimpleButton("Save", 250, 60));
        ButtonUtility.setDisabled(buttons, "Save", true);
        gridPane.add(buttons, 0, 6, 3, 1);
    }

    /**
     * Sets the action handler for the Back button.
     *
     * @param handler The event handler to be set for the Back button.
     */
    public void setBackButtonAction(EventHandler<ActionEvent> handler) {
        ButtonUtility.setupActions(buttons, "Back", handler);
    }

    /**
     * Sets the action handler for the Save button.
     *
     * @param handler The event handler to be set for the Save button.
     */
    public void setSaveButtonAction(EventHandler<ActionEvent> handler) {
        ButtonUtility.setupActions(buttons, "Save", handler);
    }

    /**
     * Updates the Save button to indicate that changes have been saved.
     */
    public void setSaveButtonToSaved() {
        ButtonUtility.setText(buttons, "Save", "Saved");
        ButtonUtility.setDisabled(buttons, "Saved", true);
    }

    /**
     * Creates and returns a list of CheckBoxListViewWrapper instances for different microscope components.
     *
     * @return A list of CheckBoxListViewWrapper instances.
     */
    public List<CheckBoxListViewWrapper> createTabs() {
        List<CheckBoxListViewWrapper> wrappers = new ArrayList<>();
        wrappers.add(createTab("cameras", microscopeOption.getCamera()));
        wrappers.add(createTab("filters", microscopeOption.getFilter()));
        wrappers.add(createTab("softwares", microscopeOption.getAllSoftware()));
        return wrappers;
    }

    /**
     * Creates a CheckBoxListViewWrapper for a specific type of microscope component.
     *
     * @param type The type of the component (e.g., "cameras", "filters").
     * @param list The list of component options.
     * @return A CheckBoxListViewWrapper instance.
     */
    public CheckBoxListViewWrapper createTab(String type, List<String> list) {
        Label sectionLabel = utilityView.createLabel("Select " + type + ":");
        ListView<CheckBox> checkBoxListView = utilityView.createCheckBoxListView(list);
        CheckBoxListViewWrapper wrapper = new CheckBoxListViewWrapper(sectionLabel, checkBoxListView);
        sectionList.add(wrapper);
        return wrapper;
    }

    /**
     * Returns the name entered in the name text field.
     *
     * @return The entered name.
     */
    public String getMicroscopeName() {
        return nameTextField.getText();
    }

    /**
     * Returns the selected microscope type.
     *
     * @return The selected microscope type.
     */
    public String getSelectedMicroscopeType() {
        return typeComboBox.getValue();
    }

    /**
     * Returns a list of selected microscope components (cameras and filters).
     *
     * @return A list of selected microscope components.
     */
    public List<String> getSelectedMicroscopeComponents() {
        List<String> cameras = getSelectedData("cameras");
        List<String> filters = getSelectedData("filters");
        List<String> allComponents = new ArrayList<>();
        allComponents.addAll(cameras);
        allComponents.addAll(filters);
        return allComponents;
    }

    /**
     * Returns a list of selected software components.
     *
     * @return A list of selected software components.
     */
    public List<String> getSelectedSoftwares() {
        return getSelectedData("softwares");
    }

    /**
     * Retrieves the selected items from a specific section by its label name.
     *
     * @param labelName The label name of the section.
     * @return A list of selected items in that section.
     */
    public List<String> getSelectedData(String labelName) {
        for (CheckBoxListViewWrapper wrapper : sectionList) {
            if (wrapper.label().getText().equals("Select " + labelName + ":")) {
                return wrapper.checkBoxListView().getItems().stream()
                        .filter(CheckBox::isSelected)
                        .map(CheckBox::getText)
                        .collect(Collectors.toList());
            }
        }
        return Collections.emptyList();
    }

    /**
     * Updates the state of the Save button based on the current input values.
     * The Save button is enabled only if both the name field and the type combo box have valid inputs.
     */
    public void updateSaveButtonState() {
        boolean isNameFilled = !nameTextField.getText().trim().isEmpty();
        boolean isTypeSelected = typeComboBox.getValue() != null && !typeComboBox.getValue().trim().isEmpty();
        ButtonUtility.setDisabled(buttons, "Save", !(isNameFilled && isTypeSelected));
    }

    /**
     * Adds listeners to the name text field and type combo box to update the Save button state
     * whenever the inputs change.
     */
    private void addFieldListeners() {
        nameTextField.textProperty().addListener((observable, oldValue, newValue) -> updateSaveButtonState());
        typeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> updateSaveButtonState());
    }

    /**
     * Returns the root view of the configuration pane.
     *
     * @return The root view of the configuration pane.
     */
    @Override
    public Parent getView() {
        return gridPane;
    }
}