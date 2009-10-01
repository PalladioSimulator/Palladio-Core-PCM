package de.uka.ipd.sdq.probespec.framework.probes;

import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;

/**
 * Represents an abstract measuring method whose subclasses takes the value of a
 * stochastic expression (StoEx).
 * <p>
 * Usually the StoEx to be measured is passed using the optional parameter of
 * the {@link #takeSample(String, Object...)} method.
 * 
 * @author pmerkle
 * 
 */
public abstract class ATakeStoExStrategy implements IProbeStrategy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract ProbeSample<Double, Dimensionless> takeSample(
			String probeId, Object... o);

}
