package it.unicam.cs.mgc.MicroscopeConfigurator.View;

import javafx.scene.Parent;

/**
 * Interface for a View in the application.
 * Implementing classes must provide a way to retrieve the view's root component.
 */
public interface View {

    /**
     * Gets the root component of the view.
     *
     * @return The root component of the view, typically a {@link Parent} node.
     */
    Parent getView();
}