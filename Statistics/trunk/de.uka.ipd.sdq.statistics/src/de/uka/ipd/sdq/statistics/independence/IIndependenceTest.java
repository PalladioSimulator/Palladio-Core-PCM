package de.uka.ipd.sdq.statistics.independence;

import java.util.Collection;

/**
 * Interface for classes implementing a test for statistical independence.
 * 
 * @author Philipp Merkle
 * 
 */
public interface IIndependenceTest {

	/**
	 * Tests, whether the sequence of samples appears to be independent.
	 * 
	 * @param samples
	 *            the sequence of samples.
	 * @return true, if the samples appears to be independent; false else.
	 */
	public boolean testIndependence(Collection<Double> samples);

	/**
	 * Returns the minimal number of samples necessary for a proper test result.
	 * Avoid testing sequences smaller than the lower limit.
	 * 
	 * @return the minimal number of samples necessary for a proper test result.
	 */
	public int getLowerSampleLimit();

}
