package de.fzi.se.validation.effort.blackbox;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

/**
 * This QVT Operational black-box library implements utility functions for mathematical operations,
 * which are not included in OCL. Examples are the logarithm or the ceiling function.
 *
 * @author Martin Krogmann
 * @author Henning Groenda
 *
 */
public class MathFunctionsLibrary {

	/**Required default constructor.
	 */
	public MathFunctionsLibrary() {
	}

	/**
	 * Logarithm function from the {@link Math} library.
	 * Named mathLog, as log is already reserved for the logging function.
	 * @see Math#log(double)
	 * @param r Real value.
	 * @return Math.log(r)
	 */
	@Operation(kind=Kind.QUERY, contextual=false)
	public Double mathLog(Double r) {
		return Math.log(r);
	}

	/**
	 * Logarithm function from the {@link Math} library.
	 * @see Math#ceil(double)
	 * @param value Real value.
	 * @return Math.ceil(r)
	 */
	@Operation(kind=Kind.QUERY, contextual=false)
	public Long ceiling(Double value) {
		return new Double(Math.ceil(value)).longValue();
	}

	/**
	 * Minimal normal {@link Double} value.
	 * @see Double#MIN_NORMAL
	 * @return {@link Double#MIN_NORMAL}
	 */
	@Operation(kind=Kind.QUERY, contextual=false)
	public Double DoubleMinNormal() {
		return Double.MIN_NORMAL;
	}
}
