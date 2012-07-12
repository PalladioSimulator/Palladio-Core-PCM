/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.Random;

import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;

/**
 * @author Ihssane
 * 
 */
public class DefaultRandomGenerator implements IRandomGenerator {

	private Random randomGen;
	
	public void setSeed(Long seed) {
		this.randomGen = new Random(seed);
	}

	public DefaultRandomGenerator() {
		this.randomGen = new Random();
	}
	
	public double random() {
		return randomGen.nextDouble();
	}

	public void dispose() {	}

}
