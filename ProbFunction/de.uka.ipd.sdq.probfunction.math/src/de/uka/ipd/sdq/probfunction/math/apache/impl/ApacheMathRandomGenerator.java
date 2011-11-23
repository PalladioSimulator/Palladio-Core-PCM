package de.uka.ipd.sdq.probfunction.math.apache.impl;

import java.util.ArrayList;
import java.util.List;

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
	
	RandomGenerator rng;
	
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
		List<Integer> seedList = new ArrayList<Integer>();
		
		for(long s : seed)
		{
			if (s < Integer.MIN_VALUE || s > Integer.MAX_VALUE) {
		        throw new IllegalArgumentException
		            (s + " cannot be cast to int without changing its value.");
		    }
			seedList.add((int)s);
		}
		
	}

}
