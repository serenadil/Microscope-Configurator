package it.unicam.cs.mgc.MicroscopeConstitution.Components.GenericMicroscopeComponent;


import it.unicam.cs.mgc.MicroscopeConstitution.Components.ElectronicMicroscopeComponents.ElectronicMicroscopeComponent;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.MicroscopeComponent;
import it.unicam.cs.mgc.MicroscopeConstitution.Components.OpticalMicroscopecomponents.OpticalMicroscopeComponent;

import java.util.Objects;

/**
 * Represents a filter component used in both optical and electronic microscopes.
 * This class extends MicroscopeComponent and implements OpticalMicroscopeComponent and ElectronicMicroscopeComponent.
 */

public class Filter extends MicroscopeComponent implements OpticalMicroscopeComponent, ElectronicMicroscopeComponent {

    private final FilterType filterType;
    /**
     * Constructs a Filter with the specified serial code, producer company, and filter type.
     *
     * @param serialCode the serial code of the filter.
     * @param producerCompany the company that produced the filter.
     * @param filterType the type of the filter.
     * @throws NullPointerException if filterType is null.
     */

    public Filter(int serialCode, String producerCompany, FilterType filterType) {
        super(serialCode, producerCompany);
        Objects.requireNonNull(filterType, "filterType must not be null");
        this.filterType = filterType;
    }

    /**
     * Returns the function of the component.
     *
     * @return a string representing the function of the component.
     */

    @Override
    public String getFunction() {
        return " Filters are used to select specific wavelengths of light or electrons.";
    }

    /**
     * Returns the type of the filter.
     *
     * @return a FilterType representing the type of the filter.
     */

    public FilterType getFilterType() {
        return filterType;
    }
}
