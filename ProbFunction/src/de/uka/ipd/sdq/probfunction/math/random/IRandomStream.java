package de.uka.ipd.sdq.probfunction.math.random;


/**
 * Interface for rngs from differing libraries.
 * 
 * @author joerg
 *
 */
public interface IRandomStream {

	public void setSeed(int[] seed);
	
	public double nextDouble();

	public void setSeed(long[] seed);
	
}
