package de.uka.ipd.sdq.probfunction.math.apache.impl;

import org.apache.commons.math.random.RandomGenerator;

import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;

public class ApacheMathRandomGenerator implements IRandomGenerator 
{
	
	RandomGenerator rng;
	
	public ApacheMathRandomGenerator(RandomGenerator rng) {
		super();
		this.rng = rng;
	}

	@Override
	public void dispose() {

	}

	@Override
	public double random() {
		return rng.nextDouble();
	}

}
