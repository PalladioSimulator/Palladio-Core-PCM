package de.uka.ipd.sdq.statistics;

import java.util.ArrayList;

/**
 * Implements the "Crossing the mean" heuristic for filtering the warm-up period
 * of a steady state simulation. The warm-up period will rather be underestimated.
 * <p>
 * Please note that there is no common interface for warm-up filters so far!
 * Thus the interface will likely change soon.
 * 
 * @author Philipp Merkle
 * 
 */
public class CrossingMeanWarmUpFilter {

	/**
	 * determines how often the mean have to be crossed until subsequent samples
	 * are considered to be stationary
	 */
	private static final int MEAN_CROSSINGS_STATIONARY = 5;
	
	private ArrayList<Double> buffer;

	/** sum of buffered samples. Enables efficient mean calculation */
	private double samplesSum;

	public CrossingMeanWarmUpFilter() {
		buffer = new ArrayList<Double>();
	}
	
	public void offerSample(Double sample) {
		buffer.add(sample);
		samplesSum += sample;
	}

	public boolean isStationary() {
		return computeMeanCrossings(computeCurrentMean()) >= MEAN_CROSSINGS_STATIONARY;
	}

	private int computeMeanCrossings(double mean) {
		int crossings = 0;
		Double prevSample = null;
		for (Double currSample : buffer) {
			if (prevSample == null) {
				prevSample = currSample;
				continue;
			}

			if (prevSample < currSample) {
				if (prevSample < mean && currSample > mean) {
					++crossings;
				}
			} else {
				if (prevSample > mean && currSample < mean) {
					++crossings;
				}
			}

			prevSample = currSample;
		}
		return crossings;
	}

	private double computeCurrentMean() {
		return samplesSum / buffer.size();
	}

}
