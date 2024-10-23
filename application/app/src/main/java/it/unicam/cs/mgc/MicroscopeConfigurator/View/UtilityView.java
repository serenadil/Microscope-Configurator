package it.unicam.cs.mgc.MicroscopeConfigurator.View;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.List;
import java.util.Objects;

/**
 * A utility class providing methods for creating common JavaFX UI components.
 * This class simplifies the creation and configuration of UI elements.
 */
public class UtilityView {

    /**
     * Creates an ImageView with a specified image path, width, and height.
     *
     * @param imagePath The path to the image resource.
     * @param width The desired width of the ImageView.
     * @param height The desired height of the ImageView.
     * @return A configured ImageView with the specified image, width, and height.
     */
    public ImageView createImage(String imagePath, double width, double height) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    /**
     * Creates a Label with the specified text.
     *
     * @param text The text to display on the Label.
     * @return A Label with the specified text.
     */
    public Label createLabel(String text) {
        return new Label(text);
    }

    /**
     * Creates a simple Button with specified text, width, and height.
     *
     * @param buttonText The text to display on the Button.
     * @param width The desired width of the Button.
     * @param height The desired height of the Button.
     * @return A Button with the specified text, width, and height.
     */
    public Button createSimpleButton(String buttonText, double width, double height) {
        Button button = new Button(buttonText);
        button.setMinWidth(width);
        button.setPrefWidth(width);
        button.setMinHeight(height);
        button.setPrefHeight(height);
        return button;
    }

    /**
     * Creates a GridPane with specified number of columns, rows, gaps, and content alignment.
     *
     * @param columns The number of columns in the GridPane.
     * @param rows The number of rows in the GridPane.
     * @param hgap The horizontal gap between cells.
     * @param vgap The vertical gap between cells.
     * @param centerContent Whether to center-align the content in the GridPane.
     * @param alignment The alignment for the content of the GridPane.
     * @return A configured GridPane with the specified parameters.
     */
    public GridPane createGridPane(int columns, int rows, double hgap, double vgap, boolean centerContent, Pos alignment) {
        GridPane grid = new GridPane();
        grid.setHgap(hgap);
        grid.setVgap(vgap);
        for (int i = 0; i < columns; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(columnConstraints);
        }
        for (int i = 0; i < rows; i++) {
            grid.getRowConstraints().add(new RowConstraints());
        }
        if (centerContent) {
            grid.setAlignment(alignment);
        }
        return grid;
    }

    /**
     * Creates a VBox with specified alignment, spacing, padding, and child nodes.
     *
     * @param alignment The alignment of the VBox.
     * @param spacing The spacing between child nodes.
     * @param padding The padding around the content of the VBox.
     * @param children The child nodes to be added to the VBox.
     * @return A VBox with the specified parameters.
     */
    public VBox createVBox(Pos alignment, double spacing, Insets padding, Node... children) {
        VBox vbox = new VBox(spacing);
        vbox.setAlignment(alignment);
        vbox.setPadding(padding);
        vbox.getChildren().addAll(children);
        return vbox;
    }

    /**
     * Creates an HBox with specified spacing, alignment, and child nodes.
     *
     * @param spacing The spacing between child nodes.
     * @param alignment The alignment of the HBox.
     * @param children The child nodes to be added to the HBox.
     * @return An HBox with the specified parameters.
     */
    public HBox createHBox(double spacing, Pos alignment, Node... children) {
        HBox hbox = new HBox(spacing);
        hbox.setAlignment(alignment);
        hbox.getChildren().addAll(children);
        return hbox;
    }

    /**
     * Creates a ChoiceBox with a list of options and a default selected option.
     *
     * @param options The list of options for the ChoiceBox.
     * @param defaultOption The default selected option.
     * @param width The width of the ChoiceBox.
     * @return A ChoiceBox with the specified options, default option, and width.
     */
    public ChoiceBox<String> createChoiceBox(List<String> options, String defaultOption, double width) {
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(options);
        choiceBox.setValue(defaultOption);
        choiceBox.setPrefWidth(width);
        return choiceBox;
    }

    /**
     * Creates a ListView with multi-selection enabled and a specified size.
     *
     * @param options The list of options for the ListView.
     * @param width The width of the ListView.
     * @param height The height of the ListView.
     * @return A ListView with multi-selection enabled and specified size.
     */
    public ListView<String> createMultiSelectListView(List<String> options, double width, double height) {
        ListView<String> listView = new ListView<>(FXCollections.observableArrayList(options));
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setPrefSize(width, height);
        return listView;
    }

    /**
     * Creates a VBox containing a list of CheckBox elements.
     *
     * @param options The list of options for the CheckBox elements.
     * @param spacing The spacing between the CheckBox elements.
     * @param alignment The alignment of the VBox.
     * @return A VBox with CheckBox elements for each option.
     */
    public VBox createCheckBoxList(List<String> options, double spacing, Pos alignment) {
        VBox vbox = new VBox(spacing);
        vbox.setAlignment(alignment);
        for (String option : options) {
            CheckBox checkBox = new CheckBox(option);
            vbox.getChildren().add(checkBox);
        }
        return vbox;
    }

    /**
     * Creates a ComboBox with a list of options and a default selected option.
     *
     * @param options The list of options for the ComboBox.
     * @param defaultOption The default selected option.
     * @param width The width of the ComboBox.
     * @param <T> The type of the items in the ComboBox.
     * @return A ComboBox with the specified options, default option, and width.
     */
    public <T> ComboBox<T> createComboBox(List<T> options, T defaultOption, double width) {
        ComboBox<T> comboBox = new ComboBox<>(FXCollections.observableArrayList(options));
        comboBox.setValue(defaultOption);
        comboBox.setPrefWidth(width);
        return comboBox;
    }

    /**
     * Creates a VBox section with a title and content.
     *
     * @param title The title of the section.
     * @param content The content of the section.
     * @return A VBox containing the title and content.
     */
    public VBox createSection(String title, Node content) {
        Label sectionTitle = new Label(title);
        VBox sectionBox = new VBox(10, sectionTitle, content);
        sectionBox.setAlignment(Pos.TOP_LEFT);
        return sectionBox;
    }

    /**
     * Creates a ListView with a list of CheckBox elements.
     *
     * @param items The list of items for the CheckBox elements.
     * @return A ListView with CheckBox elements for each item.
     */
    public ListView<CheckBox> createCheckBoxListView(List<String> items) {
        ListView<CheckBox> listView = new ListView<>();
        listView.setPrefHeight(150);
        items.forEach(item -> listView.getItems().add(new CheckBox(item)));
        return listView;
    }

    /**
     * Creates a TextField with a specified prompt text and width.
     *
     * @param promptText The prompt text for the TextField.
     * @param width The width of the TextField.
     * @return A TextField with the specified prompt text and width.
     */
    public TextField createTextField(String promptText, double width) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setPrefWidth(width);
        return textField;
    }
}