package de.uka.ipd.sdq.probespec.framework.probes;

import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;

/**
 * Represents an abstract measuring method whose subclasses takes the value of a
 * service effect specification (SEFF) parameter.
 * <p>
 * Usually the SEFF parameter to be measured is passed using the optional
 * parameter of the {@link #takeSample(String, Object...)} method.
 * 
 * @author pmerkle
 * 
 */
public abstract class ATakeSEFFParameterStrategy implements IProbeStrategy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract ProbeSample<?, Dimensionless> takeSample(String probeId,
			Object... o);

}