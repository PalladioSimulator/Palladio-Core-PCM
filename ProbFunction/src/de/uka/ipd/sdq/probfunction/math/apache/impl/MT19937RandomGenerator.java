package de.uka.ipd.sdq.probfunction.math.apache.impl;

import org.apache.commons.math.random.MersenneTwister;


/**
 * MersenneTwister RNG.
 * 
 * @author joerg
 *
 */
public class MT19937RandomGenerator extends ApacheMathRandomGenerator {

	public MT19937RandomGenerator() {
		super(new MersenneTwister());

	}

}
