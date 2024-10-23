package it.unicam.cs.mgc.MicroscopeConfigurator.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.util.Objects;

/**
 * Utility class for managing button actions and properties in JavaFX.
 * Provides methods to set actions, change text, and enable/disable buttons.
 */
public class ButtonUtility {

    /**
     * Sets the action handler for a button within a parent container.
     *
     * @param parent     The parent container containing the button.
     * @param buttonText The text of the button to set the action for.
     * @param handler    The event handler to be set for the button.
     */
    public static void setupActions(Parent parent, String buttonText, EventHandler<ActionEvent> handler) {
        Objects.requireNonNull(getButton(parent, buttonText)).setOnAction(handler);
    }

    /**
     * Sets the text of a button within a parent container.
     *
     * @param parent     The parent container containing the button.
     * @param buttonText The text of the button to be updated.
     * @param newText    The new text to set on the button.
     */
    public static void setText(Parent parent, String buttonText, String newText) {
        Objects.requireNonNull(getButton(parent, buttonText)).setText(newText);
    }

    /**
     * Enables or disables a button within a parent container.
     *
     * @param parent     The parent container containing the button.
     * @param buttonText The text of the button to be enabled or disabled.
     * @param disabled   True to disable the button, false to enable it.
     */
    public static void setDisabled(Parent parent, String buttonText, boolean disabled) {
        Objects.requireNonNull(getButton(parent, buttonText)).setDisable(disabled);
    }

    /**
     * Retrieves a button from a parent container based on the button's text.
     *
     * @param parent     The parent container to search within.
     * @param buttonText The text of the button to retrieve.
     * @return The button with the specified text, or null if not found.
     */
    private static Button getButton(Parent parent, String buttonText) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof Button button && button.getText().equals(buttonText)) {
                return button;
            }
        }
        return null;
    }
}
