package de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider;

import de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider;

public class LinearValueProviderStrategy implements IValueProviderStrategy {

	private LinearValueProvider specification;

	public LinearValueProviderStrategy(LinearValueProvider specification) {
		this.specification = specification;
	}

	@Override
	public long valueAtPosition(int position) {
		return (long) (specification.getFactor()*position + specification.getSummand());
	}
}
