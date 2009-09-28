package de.uka.ipd.sdq.statistics.estimation;

import java.util.List;

import umontreal.iro.lecuyer.probdist.StudentDist;

/**
 * Estimator for the sample mean.
 * 
 * @author Philipp Merkle
 *
 */
public class SampleMeanEstimator implements IPointEstimator, IConfidenceEstimator {

	@Override
	public ConfidenceInterval estimateConfidence(List<Double> samples,
			double level) {
		int degreesOfFreedom = samples.size() - 1;
		StudentDist dist = new StudentDist(degreesOfFreedom);
		double upperQuantile = dist.inverseF(level);

		// calculate sample standard deviation
		double stdDev = Math.sqrt(new SampleVarianceEstimator()
				.estimatePoint(samples));

		// calculate sample mean
		double mean = estimatePoint(samples);

		// calculate confidence interval
		double lowerBound = mean - upperQuantile * stdDev
				/ Math.sqrt(samples.size());
		double upperBound = mean + upperQuantile * stdDev
				/ Math.sqrt(samples.size());

		return new ConfidenceInterval(mean, lowerBound, upperBound, level);
	}

	@Override
	public double estimatePoint(List<Double> samples) {
		double sum = 0;
		for (Double sample : samples) {
			sum += sample;
		}
		return sum / samples.size();
	}
}
