package de.uka.ipd.sdq.statistics.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestUtils {

	/**
	 * 
	 * @param numberOfSamples
	 * @param desiredLag
	 *            set lag > 1 in order to obtain a sequence of dependent values.
	 * @return
	 */
	public static List<Double> createSampleSequence(int numberOfSamples,
			int desiredLag) {
		Random random = new Random();
		List<Double> samples = new ArrayList<Double>();
		for (int i = 0; i < numberOfSamples; i += desiredLag) {
			double randDbl = random.nextDouble();
			for (int j = 0; j < desiredLag && i + j < numberOfSamples; j++) {
				samples.add(randDbl + (j * randDbl));
			}
		}

		return samples;
	}
	
}
