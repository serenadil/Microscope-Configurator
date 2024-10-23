package it.unicam.cs.mgc.MicroscopeConfigurator.View;

import it.unicam.cs.mgc.MicroscopeConfigurator.Controller.HomeController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * A view class for the home screen of the application.
 * Implements the View interface and provides a layout for various microscope options.
 */
public class HomeView implements View {
    private final VBox vbox;
    private final UtilityView utilityView;

    /**
     * Constructs a new HomeView with the given controller.
     *
     * @param controller The HomeController for handling actions in the view.
     */
    public HomeView(HomeController controller) {
        this.utilityView = new UtilityView();
        this.vbox = utilityView.createVBox(Pos.CENTER, 10, new Insets(30),
                loadImageLogo(),
                loadLabel("Create your own Microscope!"),
                loadLabel("Choose your type:"),
                loadButton("Electronic Microscope"),
                loadButton("Optical Microscope"),
                loadLabel("Other:"),
                loadButton("Added Microscopes")
        );
    }

    /**
     * Sets the action handler for the Electronic Microscope button.
     *
     * @param handler The event handler to be set for the button.
     */
    public void setElectronicMicroscopeButtonAction(EventHandler<ActionEvent> handler) {
        ButtonUtility.setupActions(vbox, "Electronic Microscope", handler);
    }

    /**
     * Sets the action handler for the Optical Microscope button.
     *
     * @param handler The event handler to be set for the button.
     */
    public void setOpticalMicroscopeButtonAction(EventHandler<ActionEvent> handler) {
        ButtonUtility.setupActions(vbox, "Optical Microscope", handler);
    }

    /**
     * Sets the action handler for the Added Microscopes button.
     *
     * @param handler The event handler to be set for the button.
     */
    public void setAddedMicroscopeButtonAction(EventHandler<ActionEvent> handler) {
        ButtonUtility.setupActions(vbox, "Added Microscopes", handler);
    }

    /**
     * Loads and returns an ImageView with a logo image.
     *
     * @return The loaded ImageView containing the logo image.
     */
    private ImageView loadImageLogo() {
        return utilityView.createImage("/logo.png", 220, 220);
    }

    /**
     * Creates and returns a Label with the specified text.
     *
     * @param text The text to be displayed on the Label.
     * @return The created Label with the specified text.
     */
    private Label loadLabel(String text) {
        return utilityView.createLabel(text);
    }

    /**
     * Creates and returns a Button with the specified text and dimensions.
     *
     * @param text The text to be displayed on the Button.
     * @return The created Button with the specified text and dimensions.
     */
    private Button loadButton(String text) {
        return utilityView.createSimpleButton(text, 300, 60);
    }

    /**
     * Gets the root component of the view.
     *
     * @return The root component of the view, typically a {@link Parent} node.
     */
    @Override
    public Parent getView() {
        return vbox;
    }
}
