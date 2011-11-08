package de.uka.ipd.sdq.stoex.analyser.operations;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;

/**
 * Abstract class with interface for compare operations (e.g., equals, less,
 * etc.). Includes some helper methods for probability functions.
 * 
 * @author koziolek
 * 
 */
public abstract class CompareOperation {

	private static final Object TRUE_STRING = "true";
	private static final Object FALSE_STRING = "false";

	/**
	 * Compares to objects that represent the left-hand side and the right-hand
	 * side of a comparison expression.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public IProbabilityMassFunction compare(Object left, Object right) {

		// Assure proper handling of boolean values:
		if (left instanceof String) {
			if (((String) left).toLowerCase().equals(TRUE_STRING)) {
				left = new Boolean(true);
			} else if (((String) left).toLowerCase().equals(FALSE_STRING)) {
				left = new Boolean(false);
			}
		}
		if (right instanceof String) {
			if (((String) right).toLowerCase().equals(TRUE_STRING)) {
				right = new Boolean(true);
			} else if (((String) right).toLowerCase().equals(FALSE_STRING)) {
				right = new Boolean(false);
			}
		}

		// Propagate to the type-dependent handling:
		if ((left instanceof Double) && (right instanceof Double)) {
			return getComparePMF((Double) left, (Double) right);
		}
		if ((left instanceof IProbabilityMassFunction)
				&& (right instanceof Double)) {
			return getComparePMF((IProbabilityMassFunction) left,
					(Double) right);
		}
		if ((left instanceof Double)
				&& (right instanceof IProbabilityMassFunction)) {
			return getComparePMF((Double) left,
					(IProbabilityMassFunction) right);
		}
		if ((left instanceof IProbabilityMassFunction)
				&& (right instanceof IProbabilityMassFunction)) {
			return getComparePMF((IProbabilityMassFunction) left,
					(IProbabilityMassFunction) right);
		}
		if ((left instanceof String) && (right instanceof String)) {
			return getComparePMF((String) left, (String) right);
		}
		if ((left instanceof String)
				&& (right instanceof IProbabilityMassFunction)) {
			return getComparePMF((String) left,
					(IProbabilityMassFunction) right);
		}
		if ((left instanceof Boolean) && (right instanceof Boolean)) {
			return getComparePMF((Boolean) left, (Boolean) right);
		}

		// Type not supported:
		throw new UnsupportedOperationException();
	}

	/**
	 * Compares two probability mass functions pointwise.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public double comparePointWise(IProbabilityMassFunction left,
			IProbabilityMassFunction right, CompareOperation op) {
		List<ISample> samplingPointsLeft = left.getSamples();
		List<ISample> samplingPointsRight = right.getSamples();
		double probabilitySum = 0.0;
		for (ISample leftSamplingPoint : samplingPointsLeft) {
			Object leftValue = leftSamplingPoint.getValue();
			for (ISample rightSamplingPoint : samplingPointsRight) {
				Object rightValue = rightSamplingPoint.getValue();
				IProbabilityMassFunction boolPMF = op.compare(leftValue,
						rightValue);
				if ((Double) boolPMF.getSamples().get(1).getProbability() == 1.0) {
					probabilitySum += leftSamplingPoint.getProbability()
							* rightSamplingPoint.getProbability();
				}
			}
		}
		return probabilitySum;
	}

	/**
	 * Converts a probability into a boolean PMF. The probability is taken as
	 * value for true and 1-probability as value for false.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public IProbabilityMassFunction getBoolPMF(double trueProb) {
		IProbabilityFunctionFactory probFac = IProbabilityFunctionFactory.eINSTANCE;

		IUnit unit = probFac.createUnit("bool");

		List<ISample> sampleList = new ArrayList<ISample>();
		sampleList.add(probFac.createSample(TRUE_STRING, trueProb));
		sampleList.add(probFac.createSample(FALSE_STRING, 1 - trueProb));

		IProbabilityMassFunction boolPMF = probFac
				.createProbabilityMassFunction(sampleList, unit, true);

		return boolPMF;
	}

	/**
	 * Retrieves the probability for a given value from a PMF.
	 * 
	 * @param iPMF
	 * @param valueToSeek
	 * @return
	 */
	public double getProbabilityForValue(IProbabilityMassFunction iPMF,
			double valueToSeek) {
		List<ISample> samplingPoints = iPMF.getSamples();
		for (ISample samplingPoint : samplingPoints) {
			Object value = samplingPoint.getValue();
			if (value instanceof Number) {
				Number valueNumber = (Number) samplingPoint.getValue();
				if (valueNumber.doubleValue() == valueToSeek) {
					return samplingPoint.getProbability();
				}
			}
		}
		return 0.0;
	}

	/**
	 * Returns the sum of probabilities before a given value of a PMF.
	 * 
	 * @param iPMF
	 * @param threshold
	 * @param includeThreshold
	 * @return
	 */
	public double getThresholdProbability(IProbabilityMassFunction iPMF,
			double threshold, boolean includeThreshold) {
		double probabilitySum = 0.0;
		for (ISample sample : iPMF.getSamples()) {
			Object sampleValueObject = sample.getValue();
			if (sampleValueObject instanceof Number) {
				Double sampleValue = ((Number) sampleValueObject).doubleValue();
				if (sampleValue > threshold) {
					return probabilitySum;
				} else if (sampleValue == threshold) {
					return (includeThreshold) ? probabilitySum
							+ sample.getProbability() : probabilitySum;
				} else {
					probabilitySum += sample.getProbability();
				}
			} else
				throw new UnsupportedOperationException();
		}
		return 0.0;
	}

	/**
	 * Compares two boolean values.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	protected abstract IProbabilityMassFunction getComparePMF(boolean left,
			boolean right);

	/**
	 * Compares two doubles.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	protected abstract IProbabilityMassFunction getComparePMF(double left,
			double right);

	/**
	 * Compares a PMF with a double.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	protected abstract IProbabilityMassFunction getComparePMF(double left,
			IProbabilityMassFunction right);

	/**
	 * Compares a PMF with a double.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	protected abstract IProbabilityMassFunction getComparePMF(
			IProbabilityMassFunction left, double right);

	/**
	 * Compares two PMFs.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	protected abstract IProbabilityMassFunction getComparePMF(
			IProbabilityMassFunction left, IProbabilityMassFunction right);

	/**
	 * Compares a String and an EnumPMF
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	protected abstract IProbabilityMassFunction getComparePMF(String left,
			IProbabilityMassFunction right);

	/**
	 * Compares two Strings.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	protected abstract IProbabilityMassFunction getComparePMF(String left,
			String right);
	
	/**
	 * This method inverts a BoolPMF as required by a NOT statement. 
	 * This method would be better placed elsewhere, but it accesses internal knowledge how 
	 * a BoolPMF is represented as a IProbabilityMassFunction which is only available in this class.
	 * @see #getBoolPMF(double).
	 * @param function
	 * @return The inverted function, assuming this is a BoolPMF. 
	 * @throws UnsupportedOperationException if the passed PMF is not a BoolPMF, 
	 * i.e. if it does not contain the String literals "TRUE" and "FALSE".
	 */
	public static IProbabilityMassFunction invertBoolPMF(IProbabilityMassFunction function){
		//check whether this is a BoolPMF, i.e. two samples with labels TRUE and FALSE.  
		List<ISample> samples = function.getSamples();
		if (samples.size() == 2){
			ISample sample1 = samples.get(0);
			ISample sample2 = samples.get(1);
			
			ISample sampleTrue = null;
			ISample sampleFalse = null;
			
			if (sampleIsTrue(sample1)){
				if (sampleIsFalse(sample2)){
					sampleTrue = sample1;
					sampleFalse = sample2;
				} 
			} else if (sampleIsFalse(sample1)){
				if (sampleIsTrue(sample2)){
					sampleTrue = sample2;
					sampleFalse = sample1;
				}
			}
			
			if (sampleTrue != null && sampleFalse != null){
				
				IProbabilityFunctionFactory probFac = ProbabilityFunctionFactoryImpl.eINSTANCE;
				
				//is probably never used. 
				IUnit unit = probFac.createUnit("bool");

				List<ISample> sampleList = new ArrayList<ISample>();
				
				ISample newTrueSample = probFac.createSample(true, sampleFalse.getProbability());
				ISample newFalseSample = probFac.createSample(false, sampleTrue.getProbability());
				sampleList.add(newTrueSample);
				sampleList.add(newFalseSample);

				IProbabilityMassFunction boolPMF = probFac
						.createProbabilityMassFunction(sampleList, unit, true);
				
				return boolPMF;
				
			}
		}
		throw new UnsupportedOperationException("Cannot invert PMF "+function.toString()+" as it is no valid BoolPMF.");
	}

	private static boolean sampleIsTrue(ISample sample) {
		if (sample.getValue() instanceof Boolean)
			return (Boolean)sample.getValue();
		return TRUE_STRING.equals(sample.getValue());
	}
	
	private static boolean sampleIsFalse(ISample sample) {
		if (sample.getValue() instanceof Boolean)
			return !(Boolean)sample.getValue();
		return FALSE_STRING.equals(sample.getValue());
	}
}
