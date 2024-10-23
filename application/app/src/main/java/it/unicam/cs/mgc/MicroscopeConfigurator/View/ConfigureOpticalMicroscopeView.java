package it.unicam.cs.mgc.MicroscopeConfigurator.View;

import it.unicam.cs.mgc.MicroscopeConfigurator.Model.DatabaseNames.OpticalMicroscopeOptionNames;
import org.apache.jena.rdf.model.Model;

import java.util.List;


/**
 * Represents a view for configuring an optical microscope.
 */
public class ConfigureOpticalMicroscopeView extends ConfigureMicroscopeView {
    private static final OpticalMicroscopeOptionNames option = new OpticalMicroscopeOptionNames(GlobalModel.getModelInstance());

    /**
     * Constructor for ConfigureOpticalMicroscopeView.
     *
     * @param globalModel The global model instance.
     */
    public ConfigureOpticalMicroscopeView(Model globalModel) {
        super("optical", option);
    }

    /**
     * Creates tabs specific to optical microscope configuration.
     *
     * @return The list of checkbox list view wrappers for optical microscope tabs.
     */
    @Override
    public List<CheckBoxListViewWrapper> createTabs() {
        List<CheckBoxListViewWrapper> wrappers = super.createTabs();
        wrappers.add(createTab("illumination system", option.getIlluminationSystem()));
        wrappers.add(createTab("objective", option.getObjective()));
        wrappers.add(createTab("ocular", option.getOcular()));
        return wrappers;
    }

    /**
     * Returns the selected components for the optical microscope.
     *
     * @return The list of selected components.
     */
    @Override
    public List<String> getSelectedMicroscopeComponents() {
        List<String> selectedComponents = super.getSelectedMicroscopeComponents();
        selectedComponents.addAll(getSelectedData("illumination system"));
        selectedComponents.addAll(getSelectedData("objective"));
        selectedComponents.addAll(getSelectedData("ocular"));
        return selectedComponents;
    }
}