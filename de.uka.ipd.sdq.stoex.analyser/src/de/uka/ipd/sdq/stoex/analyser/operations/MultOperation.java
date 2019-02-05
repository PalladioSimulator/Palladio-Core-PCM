package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;

/**
 * Implements the operation "multiplication" for different kinds of operands.
 * @author martens, koziolek
 */
public class MultOperation extends TermProductOperation {

	@Override
	public double compute(double left, double right) {
		return left*right;
	}

	@Override
	public int compute(int left, int right) {
		return left*right;
	}

	@Override
	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			double right) throws DomainNotNumbersException {
		if (right == 0){
			throw new IllegalArgumentException("ProbabilityMassFunction "+left.toString()+" cannot be multiplied with 0, this operation is undefined.");
		}
		return left.stretchDomain(right);
	}



	@Override
	public IProbabilityDensityFunction compute(IProbabilityDensityFunction left, double right) throws DomainNotNumbersException {
		if (right == 0){
			throw new IllegalArgumentException("ProbabilityDensityFunction "+left.toString()+" cannot be multiplied with 0, this operation is undefined.");
		}
		return left.stretchDomain(right);
	}

	@Override
	protected Double calculateOperationForValues(Double value1, Double value2) {
		return value1 * value2;
	}

}
