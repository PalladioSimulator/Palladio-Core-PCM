package de.uka.ipd.sdq.stoex.analyser.operations;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;

public abstract class CompareOperation {

	public abstract IProbabilityMassFunction compare(double left, double right);
	
	public abstract IProbabilityMassFunction compare(IProbabilityMassFunction left, double right);
		
	public abstract IProbabilityMassFunction compare(double left, IProbabilityMassFunction right);
	
	public abstract IProbabilityMassFunction compare(IProbabilityMassFunction left, IProbabilityMassFunction right);
	

	/**
	 * @param left
	 * @param right
	 * @return
	 */
	public IProbabilityMassFunction getBoolPMF(double trueProb) {
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
	
	public double getProbabilityForValue(IProbabilityMassFunction iPMF,
			double valueToSeek) {
		List<ISample> samplingPoints = iPMF.getSamples();
		for (ISample samplingPoint : samplingPoints) {
			Object value = samplingPoint.getValue();
			if (value instanceof Number){
				Number valueNumber = (Number)samplingPoint.getValue();
				if (valueNumber.doubleValue() == valueToSeek) {
					return samplingPoint.getProbability();
				}
			}
		}
		return 0.0;
	}
	
	public double getProbabilitySumUntil(IProbabilityMassFunction iPMF,
			double value, boolean includeValue) {
		double probabilitySum = 0.0;
		for (ISample samplingPoint : iPMF.getSamples()) {

			Object samplingPointValue = samplingPoint.getValue();
			if (samplingPointValue instanceof Number) {
				if (((Number) samplingPointValue).doubleValue() == value) {
					if (includeValue)
						probabilitySum += samplingPoint.getProbability();
					return probabilitySum;
				} else {
					probabilitySum += samplingPoint.getProbability();
				}
			} else
				return 0.0;
		}

		return 0.0;
	}
	
	/**
	 * @param left
	 * @param right
	 * @return
	 */
	public double comparePointWise(IProbabilityMassFunction left, 
			IProbabilityMassFunction right, CompareOperation op) {
		List<ISample> samplingPointsLeft = left.getSamples();
		List<ISample> samplingPointsRight = right.getSamples();
		double probabilitySum = 0.0;
		for (ISample leftSamplingPoint : samplingPointsLeft){
			Number leftNumber = getNumberFromSamplingPoint(leftSamplingPoint);
			for(ISample rightSamplingPoint : samplingPointsRight){
				Number rightNumber = getNumberFromSamplingPoint(rightSamplingPoint);

				// ok, we have to get a boolPMF to stay consistent with the interface
				IProbabilityMassFunction boolPMF = op.compare(leftNumber
						.doubleValue(), rightNumber.doubleValue());
				double trueProb = (Double) boolPMF.getSamples().get(1).getProbability();
				if (trueProb == 1.0) {
					probabilitySum += 
						leftSamplingPoint.getProbability() * rightSamplingPoint.getProbability();
				}
			}
		}
		return probabilitySum;
	}

	/**
	 * @param leftSamplingPoint
	 */
	private Number getNumberFromSamplingPoint(ISample leftSamplingPoint) {
		Object leftValue = leftSamplingPoint.getValue();
		if (leftValue instanceof Number){
			return (Number)leftValue;
		} else
			throw new UnsupportedOperationException();
	}
	
}
