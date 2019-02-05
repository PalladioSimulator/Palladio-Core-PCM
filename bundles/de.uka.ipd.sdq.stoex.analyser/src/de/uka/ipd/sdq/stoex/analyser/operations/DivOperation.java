package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;

/**
 * Implements the operation "division" for different kinds of operands.
 * @author martens, koziolek
 */
public class DivOperation extends TermProductOperation {

	@Override
	public double compute(double left, double right) {
		return left / right;
	}

	@Override
	public int compute(int left, int right) {
		return left / right;
	}

	@Override
	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			double right) throws DomainNotNumbersException {
		return left.stretchDomain(1/right);
	}

	@Override
	public IProbabilityDensityFunction compute(IProbabilityDensityFunction left, double right) throws DomainNotNumbersException {
		return left.stretchDomain(1/right);
	}

	@Override
	protected Double calculateOperationForValues(Double value1, Double value2) {
		return value1 / value2;
	}

}
