package de.uka.ipd.sdq.probespec.framework.probes;

import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;

/**
 * Represents an abstract measuring method whose subclasses takes the demand of
 * an entity regarding to the specified HDD.
 * <p>
 * Usually the affected HDD is passed using the optional parameter of the
 * {@link #takeSample(String, Object...)} method.
 * 
 * @author pmerkle
 * 
 */
public abstract class ATakeHDDDemandStrategy implements IProbeStrategy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract ProbeSample<Double, Dimensionless> takeSample(
			String probeId, Object... o);

}
