package de.uka.ipd.sdq.probfunction.math;

public interface INormalDistribution extends IContinousPDF {
	
	/**
	 * Get mean mu
	 * @return
	 */
	public double getMean();
	
	/**
	 * Get standard deviation sigma
	 * @return
	 */
	public double getSigma();

}
