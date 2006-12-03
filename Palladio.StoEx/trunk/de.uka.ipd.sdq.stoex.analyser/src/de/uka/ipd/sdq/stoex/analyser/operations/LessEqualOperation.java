package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

public class LessEqualOperation extends CompareOperation {

	public IProbabilityMassFunction compare(double left, double right) {
		if (left <= right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left, double right) {
		return getBoolPMF(getProbabilitySumUntil(left, right, true));
	}

	public IProbabilityMassFunction compare(double left, IProbabilityMassFunction right) {
		return compare(right, left);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		Object firstValueRight = right.getSamples().get(0).getValue();
		if (firstValueRight instanceof Number){
			Number firstValueRightNumber = (Number)firstValueRight;
			double prob = getProbabilitySumUntil(left, firstValueRightNumber.doubleValue(), true);
			return getBoolPMF(prob);
		} else
			throw new UnsupportedOperationException();
	}

}
