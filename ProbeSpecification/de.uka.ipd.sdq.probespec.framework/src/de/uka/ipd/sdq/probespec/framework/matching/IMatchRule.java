package de.uka.ipd.sdq.probespec.framework.matching;

import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;

/**
 * A MatchRule provides a simple mechanism which is able to decide whether a
 * specified property holds for an object. Here these objects are
 * {@link ProbeSample}s. The property to be checked has to be implemented within
 * the {@link #match(ProbeSample)} method.
 * <p>
 * Usually one wants to check whether an object's property is of a particular
 * value. Such a concrete value should be passed using a constructor parameter
 * and later on checked within the {@link #match(ProbeSample)} method.
 * 
 * @author pmerkle
 * 
 */
public interface IMatchRule {

	/**
	 * Checks whether a specified property holds for the passed ProbeSample. The
	 * property to be checked is implied by the concrete class implementing this
	 * Interface.
	 * 
	 * @param sample
	 *            the probe sample to check
	 * @return true if the passed object matches; false else
	 */
	boolean match(ProbeSample<?, ? extends Quantity> sample);

}
