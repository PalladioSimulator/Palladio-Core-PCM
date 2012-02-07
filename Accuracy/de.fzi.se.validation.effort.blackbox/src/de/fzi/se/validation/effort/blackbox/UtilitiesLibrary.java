package de.fzi.se.validation.effort.blackbox;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

/**
 * This class implements blackbox utility functions accessible 
 * from QVT-Operational.
 * @author Martin Krogmann
 *
 */
public class UtilitiesLibrary {
	
	public UtilitiesLibrary() {
		super();
	}

	/**
	 * Logarithm function from the {@link Math} library.
	 * @see Math#log(double)
	 * @param r Real value.
	 * @return Math.log(r)
	 */
	@Operation(kind=Kind.QUERY, contextual=false)
	public Double mathLog(Double r) {
		return Math.log(r);
	}
}
