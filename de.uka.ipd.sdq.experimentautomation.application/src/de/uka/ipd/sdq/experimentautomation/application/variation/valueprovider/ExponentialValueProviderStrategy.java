package de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider;

import de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider;

public class ExponentialValueProviderStrategy implements IValueProviderStrategy {

    private ExponentialValueProvider specification;

    public ExponentialValueProviderStrategy(ExponentialValueProvider specification) {
        this.specification = specification;
    }
    
    @Override
    public long valueAtPosition(int position) {
        double base = specification.getBase();   
        double result = Math.pow(base, position);
        return new Double(result).longValue();
    }

}
