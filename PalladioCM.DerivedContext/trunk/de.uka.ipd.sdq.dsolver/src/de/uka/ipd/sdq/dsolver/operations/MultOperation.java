package de.uka.ipd.sdq.dsolver.operations;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.dsolver.visitors.ExpressionSolveSwitch;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;

public class MultOperation implements IOperation {

	private static Logger logger = Logger.getLogger(MultOperation.class
			.getName());
	
	public double opDoubleDouble(double left, double right) {
		return left*right;
	}

	public int opIntInt(int left, int right) {
		return left*right;
	}

	public IProbabilityMassFunction opPMFInt(IProbabilityMassFunction left,
			int right) {
		//return left.strechDomain(right);
		return null;
	}

	public IProbabilityMassFunction opPMFPMF(IProbabilityMassFunction left,
			IProbabilityMassFunction right) throws DifferentDomainsException {
		IProbabilityMassFunction result = left.mult(right);
		logger.debug("Result: "+result.getSamples().toString());
		return result;
	}

}
