package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import org.apache.log4j.Logger;

public class MarkovResultPrinter {

	/**
	 * A logger to give detailed information about the PCM instance
	 * transformation.
	 */
	private static Logger logger = Logger.getLogger(MarkovResultPrinter.class
			.getName());

	public void print(final String prefix, final double probability) {
		logger.info(String.format("- %1$-3s %2$.11f", prefix, probability));
	}

	public void print(final String prefix, final double lowerBound,
			final double upperBound) {
		MarkovResultApproximation approximation = new MarkovResultApproximation(
				lowerBound, upperBound);
		int places = approximation.getAccuracy() + 1;
		logger.info(String.format("- %1$-3s %2$." + places + "f - %3$."
				+ places + "f", prefix, approximation.getAdjustedLowerBound(),
				approximation.getAdjustedUpperBound()));
	}

}
