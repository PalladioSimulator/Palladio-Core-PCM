package de.uka.ipd.sdq.probespec.framework.probes;

import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;

/**
 * Represents an abstract measuring method whose subclasses takes the state of a
 * HDD. The state indicates the current job queue length, starting at 0 (idle
 * state).
 * 
 * @author pmerkle
 *
 */
public abstract class ATakeHDDStateStrategy implements IProbeStrategy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract ProbeSample<Integer, Dimensionless> takeSample(
			String probeId, Object... o);

}
