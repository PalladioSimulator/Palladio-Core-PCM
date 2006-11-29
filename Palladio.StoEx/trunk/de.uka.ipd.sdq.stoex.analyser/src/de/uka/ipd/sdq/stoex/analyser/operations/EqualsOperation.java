package de.uka.ipd.sdq.stoex.analyser.operations;

import java.util.List;

import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

public class EqualsOperation extends CompareOperation {

	public IProbabilityMassFunction compare(double left, double right) {
		if (left == right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			double right) {
		List samples = left.getSamples();
		for (Object o : samples) {
			Sample sample = (Sample) o;
			if (sample.getValue() instanceof Double) {
				Double value = (Double) sample.getValue();
				if (value.doubleValue() == right) {
					return getBoolPMF(sample.getProbability());
				}
			}
		}
		return getBoolPMF(0.0);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		List leftSamples = left.getSamples();
		List rightSamples = right.getSamples();

		if (leftSamples.size() != rightSamples.size())
			return getBoolPMF(0.0);

		for (int i = 0; i < leftSamples.size(); i++) {
			Sample leftSample = (Sample) leftSamples.get(i);
			Sample rightSample = (Sample) rightSamples.get(i);

			if (leftSample.getProbability() != rightSample.getProbability()
					|| leftSample.getValue() != rightSample.getValue()) {
				return getBoolPMF(0.0);
			}
		}
		return getBoolPMF(1.0);
	}

	public IProbabilityMassFunction compare(double left,
			IProbabilityMassFunction right) {
		return compare(right, left);
	}

}
