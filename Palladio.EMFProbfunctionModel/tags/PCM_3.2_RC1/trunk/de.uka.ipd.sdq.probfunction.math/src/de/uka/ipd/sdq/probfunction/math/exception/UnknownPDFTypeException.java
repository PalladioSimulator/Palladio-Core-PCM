package de.uka.ipd.sdq.probfunction.math.exception;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;

public class UnknownPDFTypeException extends ProbabilityFunctionException {

	public UnknownPDFTypeException(IProbabilityDensityFunction pdf) {
		super("Unknown PDF type "+pdf.getClass().getName());
	}

	public UnknownPDFTypeException(ProbabilityDensityFunction epdf) {
		super("Unknown PDF type "+epdf.getClass().getName());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7712120781144936371L;

}
