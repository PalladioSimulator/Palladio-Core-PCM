package de.uka.ipd.sdq.probespec.framework.probes;

import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;

/**
 * Represents an abstract measuring method whose subclasses takes the state of a
 * passive resource like a mutex or a connection pool. The state indicates the
 * amount of free resources. The state changes when resources are acquired or
 * released. In general a mutex has 1 resource and connection pools have at
 * least 2 resources.
 * <p>
 * Usually the passive resource to be measured is passed using the optional
 * parameter of the {@link #takeSample(String, Object...)} method.
 * 
 * @author pmerkle
 * 
 */
public abstract class ATakePassiveResourceStateStrategy implements
		IProbeStrategy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract ProbeSample<Integer, Dimensionless> takeSample(
			String probeId, Object... o);

}
