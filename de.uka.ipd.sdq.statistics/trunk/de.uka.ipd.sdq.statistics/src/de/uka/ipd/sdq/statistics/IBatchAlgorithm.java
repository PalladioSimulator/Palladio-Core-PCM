package de.uka.ipd.sdq.statistics;

import java.util.List;

/**
 * Interface for batch mean algorithms. 
 * 
 * @author Philipp Merkle
 *
 */
public interface IBatchAlgorithm {

	public void offerSample(double value);
	
	public void offerSamples(List<Double> values);
	
	public void offerSamples(double[] values);

	public boolean hasValidBatches();
	
	public List<Double> getBatchMeans(); 
	
}
