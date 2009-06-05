package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

/**
 * Implements the operation "addition" for different kinds of operands.
 * @author koziolek
 */
public class AddOperation implements TermProductOperation {

	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			IProbabilityMassFunction right) throws DifferentDomainsException {
		return left.add(right);
	}

	public int compute(int left, int right) {
		return left+right;
	}

	public double compute(double left, double right) {
		return left+right;
	}

	public IProbabilityMassFunction compute(IProbabilityMassFunction left, double right) throws DomainNotNumbersException {
		return left.shiftDomain(right);
	}

	public IProbabilityDensityFunction compute(
			IProbabilityDensityFunction leftPDF,
			IProbabilityDensityFunction rightPDF)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		return leftPDF.add(rightPDF);
	}

	public IProbabilityDensityFunction compute(IProbabilityDensityFunction left, double right) throws DomainNotNumbersException {
		return left.shiftDomain(right);
	}

}
