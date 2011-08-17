/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math;

/**
 * @author Ihssane
 * 
 */
public interface IRandomGenerator {

	/**
	 * generates a double value greater than or equal 0.0 and less than 1.0
	 * 
	 * @return
	 */
	public double random();
	
	public void dispose();
}
