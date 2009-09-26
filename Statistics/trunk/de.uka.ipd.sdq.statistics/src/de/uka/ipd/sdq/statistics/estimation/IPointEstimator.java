package de.uka.ipd.sdq.statistics.estimation;

import java.util.List;

/**
 * Interface for classes which are capable of doing a point estimation.
 * 
 * @author Philipp Merkle
 * 
 */
public interface IPointEstimator {

	/**
	 * Conducts a point estimation.
	 * 
	 * @param samples
	 *            the values for which a specific point is to be estimated.
	 * @return
	 */
	public double estimatePoint(List<Double> samples);

}
