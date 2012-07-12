package de.uka.ipd.sdq.probfunction.math.apache.impl;


import org.apache.commons.math.random.RandomGenerator;
import de.uka.ipd.sdq.probfunction.math.random.IRandomStream;


/**
 * Adapter for apache.math random generators.
 * 
 * @author joerg
 *
 */
public class ApacheMathRandomGenerator implements IRandomStream 
{
	
	protected RandomGenerator rng;
	
	public ApacheMathRandomGenerator(RandomGenerator rng) {
		super();
		this.rng = rng;
	}

	@Override
	public void setSeed(int[] seed) {
		rng.setSeed(seed);
	}

	@Override
	public double nextDouble() {
		return rng.nextDouble();
	}

	@Override
	public void setSeed(long[] seed) {
		int[] intSeed = new int[seed.length];
		
		for(int i=0;i<seed.length;i++)
		{
			long s = seed[i];
			if (s < Integer.MIN_VALUE || s > Integer.MAX_VALUE) {
		        throw new IllegalArgumentException
		            (s + " cannot be cast to int without changing its value.");
		    }
			intSeed[i] = (int)s;
		}
		setSeed(intSeed);
	}

}
