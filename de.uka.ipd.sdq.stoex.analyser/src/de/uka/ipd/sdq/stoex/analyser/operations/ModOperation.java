package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;

/**
 * Implements the operation "modulo" for different kinds of operands.
 * Note, that so far only integers and doubles are supported.
 * @author koziolek
 */
public class ModOperation extends TermProductOperation {

	@Override
	public double compute(double left, double right) {
		return left % right;
	}

	@Override
	public int compute(int left, int right) {
		return left % right;
	}

	@Override
	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			double right) {
		//TODO
		//return left.mod(right);
		throw new UnsupportedOperationException();
	}

	@Override
	public IProbabilityDensityFunction compute(IProbabilityDensityFunction left, double right) throws DomainNotNumbersException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Double calculateOperationForValues(Double value1, Double value2) {
		return value1 % value2;
	}

}
