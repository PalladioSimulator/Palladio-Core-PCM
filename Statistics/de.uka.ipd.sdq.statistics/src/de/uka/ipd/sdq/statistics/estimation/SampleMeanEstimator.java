package de.uka.ipd.sdq.statistics.estimation;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IContinousPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IStudentTDistribution;
import de.uka.ipd.sdq.probfunction.math.apache.impl.PDFFactory;

/**
 * Estimator for the sample mean.
 * 
 * @author Philipp Merkle
 *
 */
public class SampleMeanEstimator implements IPointEstimator, IConfidenceEstimator {

    private IContinousPDFFactory pdfFactory;

    public SampleMeanEstimator() {
        this(new PDFFactory());
    }

    public SampleMeanEstimator(IContinousPDFFactory pdfFactory) {
        assert pdfFactory != null : "The passed PDF factory may not be null.";
        this.pdfFactory = pdfFactory;
    }
    
	@Override
	public ConfidenceInterval estimateConfidence(List<Double> samples,
			double level) {
		int degreesOfFreedom = samples.size() - 1;
		if (degreesOfFreedom > 0){
			IStudentTDistribution dist = this.pdfFactory.createStudentTDistribution(degreesOfFreedom);
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
		} else {
			return null;
		}
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
