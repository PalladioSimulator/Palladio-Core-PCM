package de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider;

import de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider;

public class PolynomialValueProviderStrategy implements IValueProviderStrategy {

    private PolynomialValueProvider specification;

    public PolynomialValueProviderStrategy(PolynomialValueProvider specification) {
        this.specification = specification;
    }

    @Override
    public long valueAtPosition(int position) {
        double result = Math.pow(position, specification.getExponent()) * specification.getFactor();
        return new Double(result).longValue();
    }

}
