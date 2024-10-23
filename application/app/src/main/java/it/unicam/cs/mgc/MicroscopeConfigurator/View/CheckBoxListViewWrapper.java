package it.unicam.cs.mgc.MicroscopeConfigurator.View;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * A record representing a wrapper for a label and a ListView of CheckBoxes.
 */
public record CheckBoxListViewWrapper(Label label, ListView<CheckBox> checkBoxListView) {
}

