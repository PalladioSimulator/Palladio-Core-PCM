package de.uka.ipd.sdq.statistics.estimation.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import de.uka.ipd.sdq.statistics.estimation.SampleMeanEstimator;

public class TestMeanEstimator extends TestCase {

	private SampleMeanEstimator estimator;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		estimator = new SampleMeanEstimator();
	}
	
	public void testMeanPointEstimation() {
		List<Double> samples = new ArrayList<Double>();
		samples.add(1.0);
		samples.add(2.0);
		samples.add(3.0);
		samples.add(4.0);
		samples.add(5.0);

		double expectedMean = (1.0 + 2.0 + 3.0 + 4.0 + 5.0) / 5.0;
		double actualMean = estimator.estimatePoint(samples);

		assertEquals(expectedMean, actualMean);
	}

}
