package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

/**
 * Implement this interface to listen for the calculation results of a
 * {@link Calculator}.
 * 
 * @author Philipp Merkle
 * 
 */
public interface ICalculatorListener {

	/**
	 * After having registered at a {@link Calculator}, this method gets invoked
	 * whenever a new result has been calculated.
	 * 
	 * @param resultTuple
	 *            the calculated result
	 */
	public void calculated(Vector<Measure<?, ? extends Quantity>> resultTuple);

}
