package de.uka.ipd.sdq.statistics.test;

import java.util.List;

import de.uka.ipd.sdq.statistics.IBatchAlgorithm;
import de.uka.ipd.sdq.statistics.PhiMixingBatchAlgorithm;
import de.uka.ipd.sdq.statistics.estimation.SampleMeanEstimator;
import junit.framework.TestCase;

public class TestPhiMixingBatchAlgorithm extends TestCase {

	private IBatchAlgorithm batchAlgorithm;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		batchAlgorithm = new PhiMixingBatchAlgorithm();
	}

	public void testPhiMixing() {
		List<Double> samples = TestUtils.createSampleSequence(32000, 4);
		batchAlgorithm.offerSamples(samples);

		double expectedMean = new SampleMeanEstimator().estimatePoint(samples);
		double actualMean = new SampleMeanEstimator().estimatePoint(batchAlgorithm
				.getBatchMeans());

		assertTrue(batchAlgorithm.hasValidBatches());
		assertEquals(expectedMean, actualMean, 0.01);
	}

}
