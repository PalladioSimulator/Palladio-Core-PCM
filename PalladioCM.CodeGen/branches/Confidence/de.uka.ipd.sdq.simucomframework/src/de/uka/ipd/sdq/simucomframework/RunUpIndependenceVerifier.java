package de.uka.ipd.sdq.simucomframework;

import java.util.Collection;

/**
 * Implements the "run test" algorithm which tests a data sequence for
 * independence.
 * 
 * Confer [Donald E. Knuth: The art of computer programming. Seminumerical
 * algorithms]
 * 
 * @author Philipp Merkle
 * 
 */
public class RunUpIndependenceVerifier extends AIndependenceVerifier<Double> {

	private static final double[][] A = {
			{ 4529.4, 9044.9, 13568, 18091, 22615, 27892 },
			{ 9044.9, 18097, 27139, 36187, 45234, 55789 },
			{ 13568, 27139, 40721, 54281, 67852, 83685 },
			{ 18091, 36187, 54281, 72414, 90470, 111580 },
			{ 22615, 45234, 67852, 90470, 113262, 139476 },
			{ 27892, 55789, 83685, 111580, 139476, 172860 } };

	private static final double[] B = { 1.0 / 6, 5.0 / 24, 11.0 / 120,
			19.0 / 720, 29.0 / 5040, 1.0 / 840 };

	/**
	 * @return true if the specified data seems to be independent; false else.
	 */
	@Override
	public boolean verifyIndependence(Collection<Double> data, int lag) {
		int[] runCounts = calculateRunCounts(data);
		int n = data.size();

		double sum = 0.0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				sum += (runCounts[i] - n * B[i]) * (runCounts[j] - n * B[j])
						* A[i][j];
			}
		}

		double V = 1.0 / (n - 6) * sum;

		System.out.println(V);
		return V >= 1.635 && V <= 12.59; // TODO Adjust values!?
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
