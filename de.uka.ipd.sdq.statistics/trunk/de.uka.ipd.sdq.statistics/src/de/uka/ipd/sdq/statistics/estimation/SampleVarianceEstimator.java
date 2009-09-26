package de.uka.ipd.sdq.statistics.estimation;

import java.util.List;

/**
 * Estimator for the sample variance.
 * 
 * @author pmerkle
 *
 */
public class SampleVarianceEstimator implements IPointEstimator {

	@Override
	public double estimatePoint(List<Double> samples) {
		double mean = new SampleMeanEstimator().estimatePoint(samples);
		double sum = 0.0;
		for (Double s : samples) {
			sum += Math.pow(s - mean, 2.0);
		}
		double sampleVariance = 1.0 / (samples.size() - 1) * sum;
		
		return sampleVariance;
	}

}
