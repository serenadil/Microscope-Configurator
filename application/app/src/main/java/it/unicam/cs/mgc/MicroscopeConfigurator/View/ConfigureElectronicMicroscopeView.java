package it.unicam.cs.mgc.MicroscopeConfigurator.View;


import it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames.ElectronicMicroscopeOptionsNames;
import org.apache.jena.rdf.model.Model;

import java.util.List;

/**
 * Represents a view for configuring an electronic microscope.
 */
public class ConfigureElectronicMicroscopeView extends ConfigureMicroscopeView {
    private static final ElectronicMicroscopeOptionsNames option = new ElectronicMicroscopeOptionsNames(GlobalModel.getModelInstance());

    /**
     * Constructor for ConfigureElectronicMicroscopeView.
     *
     * @param globalModel The global model instance.
     */
    public ConfigureElectronicMicroscopeView(Model globalModel) {
        super("electronic", option);
    }

    /**
     * Creates tabs specific to electronic microscope configuration.
     *
     * @return The list of checkbox list view wrappers for electronic microscope tabs.
     */
    @Override
    public List<CheckBoxListViewWrapper> createTabs() {
        List<CheckBoxListViewWrapper> wrappers = super.createTabs();
        wrappers.add(createTab("cannons", option.getCannon()));
        wrappers.add(createTab("detectors", option.getDetector()));
        wrappers.add(createTab("vacuum pumps", option.getVacuumPump()));
        return wrappers;
    }

    /**
     * Returns the selected components for the electronic microscope.
     *
     * @return The list of selected components.
     */
    @Override
    public List<String> getSelectedMicroscopeComponents() {
        List<String> selectedComponents = super.getSelectedMicroscopeComponents();
        selectedComponents.addAll(getSelectedData("cannons"));
        selectedComponents.addAll(getSelectedData("detectors"));
        selectedComponents.addAll(getSelectedData("vacuum pumps"));
        return selectedComponents;
    }
}
