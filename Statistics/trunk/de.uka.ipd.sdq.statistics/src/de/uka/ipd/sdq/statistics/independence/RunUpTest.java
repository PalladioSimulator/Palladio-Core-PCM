package de.uka.ipd.sdq.statistics.independence;

import java.util.Collection;

import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.probdist.ChiSquareDist;

/**
 * Implements the "run test" algorithm which tests a data sequence for
 * independence.
 * 
 * Confer [Donald E. Knuth: The Art of Computer Programming. Seminumerical
 * Algorithms]
 * 
 * @author Philipp Merkle
 * 
 */
public class RunUpTest implements IIndependenceTest {

	private Logger logger;
	
	private static final int LOWER_SAMPLE_LIMIT = 4000;

	private static final int CHI_SQUARE_DOF = 6;

	private static final double CHI_SQUARE_LOWER_QUANTILE = 0.01;

	private static final double CHI_SQUARE_UPPER_QUANTILE = 0.99;

	private static final double[][] A = {
			{ 4529.4, 9044.9, 13568, 18091, 22615, 27892 },
			{ 9044.9, 18097, 27139, 36187, 45234, 55789 },
			{ 13568, 27139, 40721, 54281, 67852, 83685 },
			{ 18091, 36187, 54281, 72414, 90470, 111580 },
			{ 22615, 45234, 67852, 90470, 113262, 139476 },
			{ 27892, 55789, 83685, 111580, 139476, 172860 } };

	private static final double[] B = { 1.0 / 6, 5.0 / 24, 11.0 / 120,
			19.0 / 720, 29.0 / 5040, 1.0 / 840 };
	
	public RunUpTest() {
		logger = Logger.getLogger(RunUpTest.class);
	}

	@Override
	public boolean testIndependence(Collection<Double> samples) {
		int[] runCounts = calculateRunCounts(samples);
		int n = samples.size();

		// calculate a statistics denoted by V. According to Knuth, V should
		// have the chi-square distribution with six degrees of freedom.
		double sum = 0.0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				sum += (runCounts[i] - n * B[i]) * (runCounts[j] - n * B[j])
						* A[i][j];
			}
		}
		double V = 1.0 / (n - 6) * sum;

		// test for chi-square distribution
		ChiSquareDist dist = new ChiSquareDist(CHI_SQUARE_DOF);
		double upperQuantile = dist.inverseF(CHI_SQUARE_UPPER_QUANTILE);
		double lowerQuantile = dist.inverseF(CHI_SQUARE_LOWER_QUANTILE);

		logger.info("Run Up Indepence test: F=" + V);
	
		return V >= lowerQuantile && V <= upperQuantile;
	}
	
	@Override
	public int getLowerSampleLimit() {
		return LOWER_SAMPLE_LIMIT;
	}

	private int[] calculateRunCounts(Collection<Double> sequence) {
		int[] runCounts = new int[6];

		int length = 0;
		double highest = Double.MIN_VALUE;
		for (Double d : sequence) {
			if (d > highest) {
				length++;
			} else {
				if (length > 6)
					length = 6;
				runCounts[length - 1]++;
				length = 1;
			}
			highest = d;
		}

		return runCounts;
	}

}
