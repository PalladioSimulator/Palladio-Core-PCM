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
		// TODO Auto-generated method stub
		return getBoolPMF(0.0);
	}

	public IProbabilityMassFunction compare(double left, IProbabilityMassFunction right) {
		// TODO Auto-generated method stub
		return getBoolPMF(0.0);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		// TODO Auto-generated method stub
		return getBoolPMF(0.0);
	}

}
