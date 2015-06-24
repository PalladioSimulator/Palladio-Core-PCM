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
 * @author martens, koziolek
 */
public class AddOperation extends TermProductOperation {

	@Override
	public int compute(int left, int right) {
		return left+right;
	}

	@Override
	public double compute(double left, double right) {
		return left+right;
	}

	@Override
	public IProbabilityMassFunction compute(IProbabilityMassFunction left, double right) throws DomainNotNumbersException {
		if (right == 0){
			return left;
		} else {
			return left.shiftDomain(right);
		}
	}

	@Override
	public IProbabilityDensityFunction compute(IProbabilityDensityFunction left, double right) throws DomainNotNumbersException {
		if (right == 0){
			return left;
		} else {
			return left.shiftDomain(right);
		}
	}

	@Override
	protected Double calculateOperationForValues(Double value1, Double value2) {
		return value1 + value2;
	}

}
