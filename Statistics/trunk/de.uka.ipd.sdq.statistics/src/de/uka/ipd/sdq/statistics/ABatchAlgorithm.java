package de.uka.ipd.sdq.statistics;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements some recurring tasks arising when implementing the interface
 * {@link IBatchAlgorithm}.
 * 
 * @author Philipp Merkle
 * 
 */
public abstract class ABatchAlgorithm implements IBatchAlgorithm {

	protected List<Batch> batches;

	private boolean valid;

	@Override
	public void offerSamples(List<Double> values) {
		for (Double v : values) {
			offerSample(v);
		}
	}

	@Override
	public void offerSamples(double[] values) {
		for (double v : values) {
			offerSample(v);
		}
	}

	@Override
	public List<Double> getBatchMeans() {
		List<Double> means = new ArrayList<Double>();
		for (Batch b : batches) {
			means.add(b.getMean());
		}
		return means;
	}

	@Override
	public boolean hasValidBatches() {
		return valid;
	}

	protected void setValid(boolean valid) {
		this.valid = valid;
	}

}
