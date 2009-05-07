package de.uka.ipd.sdq.stoex.analyser.operations;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;

public class GreaterEqualOperation extends CompareOperation {

	public IProbabilityMassFunction compare(double left, double right) {
		if (left >= right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left, double right) {
		return getBoolPMF(1-getProbabilitySumUntil(left, right, false));
	}

	public IProbabilityMassFunction compare(double left, IProbabilityMassFunction right) {
		return compare(right,left);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		return getBoolPMF(comparePointWise(left, right, this));
		
		
		
//		int numberOfSamples = right.getSamples().size();
//		Object lastValueRight = right.getSamples().get(numberOfSamples-1).getValue();
//		if (lastValueRight instanceof Number){
//			Number lastValueRightNumber = (Number)lastValueRight;
//			double prob = getProbabilitySumUntil(left, lastValueRightNumber.doubleValue(), false);
//			return getBoolPMF(1-prob);
//		} else
//			throw new UnsupportedOperationException();
	}



}
