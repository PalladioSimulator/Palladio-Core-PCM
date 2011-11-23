package de.uka.ipd.sdq.probfunction.math.ssj.impl;

import umontreal.iro.lecuyer.rng.RandomStreamBase;
import de.uka.ipd.sdq.probfunction.math.random.IRandomStream;

public abstract class SSJRandomGenerator implements IRandomStream 
{

	protected RandomStreamBase rng;
	
	public SSJRandomGenerator(RandomStreamBase rng)
	{
		this.rng = rng;
	}
	
	@Override
	public double nextDouble() {
		return rng.nextDouble();
	}

	
}
