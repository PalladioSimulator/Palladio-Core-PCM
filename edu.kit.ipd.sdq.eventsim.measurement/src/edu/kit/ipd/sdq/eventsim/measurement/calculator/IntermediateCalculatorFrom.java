package edu.kit.ipd.sdq.eventsim.measurement.calculator;

/**
 * A half-finished {@link BinaryCalculator} that expects to be provided with the first probe ("from"-probe) in this
 * construction step.
 * <p>
 * Allows for a "fluent" construction of calculators. 
 * 
 * @author Philipp Merkle
 *
 * @param <R>
 * @param <F>
 * @param <S>
 * @param <T>
 */
public interface IntermediateCalculatorFrom<R, F, S, T> {

	/**
	 * Tells this calculator where and when a new calculation is supposed to start.
	 * 
	 * @param first
	 *            the element where the calculation starts
	 * @param property
	 *            the element's observed property; once this property changes, a new calculation starts
	 * @param measurementContexts
	 *            restricts the calculation to these measurement contexts; if supplied, a new calculation is started
	 *            only when the observed property change took place in the scope of the given contexts.
	 * @return a another half-finished, near to complete, calculator.
	 */
	IntermediateCalculatorTo<R, F, S, T> from(F first, String property, Object... measurementContexts);

}
