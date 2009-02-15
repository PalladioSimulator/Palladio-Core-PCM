/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;

/**
 * @author Ihssane
 * 
 */
public class DefaultRandomGenerator implements IRandomGenerator {

	public double random() {
		return Math.random();
	}

	public void dispose() {	}

}
