package de.uka.ipd.sdq.stoex.analyser.operations;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;

public class EqualsOperation implements ICompareOperation {

	public IProbabilityMassFunction compare(double left, double right) {
		if (left == right){
			return getBoolPMF(1.0);
		}
		return null;
		
		

	}

	/**
	 * @param left
	 * @param right
	 * @return
	 */
	private IProbabilityMassFunction getBoolPMF(double trueProb) {
		IProbabilityFunctionFactory probFac = 
			IProbabilityFunctionFactory.eINSTANCE;

		IUnit unit = probFac.createUnit("bool");
		
		List<ISample> sampleList = new ArrayList<ISample>();
		sampleList.add(probFac.createSample("TRUE", trueProb));
		sampleList.add(probFac.createSample("FALSE", 1-trueProb));

		IProbabilityMassFunction boolPMF = probFac
				.createProbabilityMassFunction(sampleList, unit, true);

		return boolPMF;
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left, double right) {
		List samples = left.getSamples();
		for (Object o : samples){
			Sample sample = (Sample)o;
			if (sample.getValue() instanceof Double){
				Double value = (Double)sample.getValue();
				if (value.doubleValue() == right){
					return sample.getProbability();
				}
			}
		}
		return 0.0;
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		List leftSamples = left.getSamples();
		List rightSamples = right.getSamples();

		if (leftSamples.size() != rightSamples.size())
			return 0.0;

		for (int i = 0; i < leftSamples.size(); i++) {
			Sample leftSample = (Sample) leftSamples.get(i);
			Sample rightSample = (Sample) rightSamples.get(i);

			if (leftSample.getProbability() != rightSample.getProbability()
					|| leftSample.getValue() != rightSample.getValue()) {
				return 0.0;
			}
		}
		return 1.0;
	}

	public IProbabilityMassFunction compare(double left, IProbabilityMassFunction right) {
		return compare(right,left);
	}

}
