package de.uka.ipd.sdq.probespec.framework.probes;

import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;

/**
 * This Interface determines how a concrete probe takes its sample. Each class
 * implementing this interface represents a measuring method for a specific
 * probe type.
 * 
 * @author pmerkle
 * 
 */
public interface IProbeStrategy {

	/**
	 * Takes a probe sample. The type of the probe is implied by the
	 * implementing class.
	 * <p>
	 * You can pass optional {@link Object}s when additional information is
	 * needed to take the measurement. For instance the measured entity can be
	 * passed.
	 * 
	 * @param probeId
	 *            the id of the probe representing the measuring method within
	 *            the underlying model
	 * @param o
	 *            optional passed objects. Concrete Implementations should
	 *            specify, whether this parameter is used.
	 * @return the {@link ProbeSample} representing the measured sample
	 */
	ProbeSample<?, ? extends Quantity> takeSample(String probeId, Object... o);

}
