package de.uka.ipd.sdq.pipesandfilters.framework.filters;

import java.util.List;

/**
 * Implements the "Marginal Confidence Rule" (MCR) for filtering the warm-up
 * period of a steady state simulation.
 * 
 * The Filter is still experimental!
 * 
 * @author Philipp Merkle
 * 
 */
public class MCRWarmUpFilter extends Filter {

	private int minIndex = 0;

	public List<Double> filter(List<Double> samples) {
		
		if (samples.size() <= 150){
			System.out.println("MCRWarmUpFilter Warning: Too few samples to get a meaningful result.");
		}
		
		int truncatedSamplesSize = samples.size();
		double truncatedSamplesSum = 0;
		for (Double d : samples) {
			truncatedSamplesSum += d;
		}

		double minValue = Double.MAX_VALUE;

		for (int i = 0; i < samples.size() - 1; i++) {
			int remaining = samples.size() - i;
			double factor = 1 / Math.pow(remaining, 3.0);

			double truncatedSampleMean = truncatedSamplesSum
					/ truncatedSamplesSize;
			double sum = 0;
			for (int j = i + 1; j < samples.size(); j++) {
				sum += Math.pow(samples.get(j) - truncatedSampleMean, 2.0);
			}
			double d = factor * sum;

			if (d < minValue) {
//				System.out.println(i + ": " + d);
				minIndex = i;
				minValue = d;
			}

			truncatedSamplesSize--;
			truncatedSamplesSum -= samples.get(0);
		}

		if (minIndex > samples.size() / 3){
			//TODO: Kriterium nachschauen und logger
			System.out.println("MCRWarmUpFilter Warning: Truncation point is in the last two thirds of the samples, so the confidence in this result is low.");
		}
		
		// TODO Create new list?
		return samples.subList(minIndex, samples.size() - 1);
	}

	public int getTruncationIndex() {
		return minIndex;
	}
}
