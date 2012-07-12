package de.uka.ipd.sdq.probfunction.math;

/**
 * Describes a sample of a probability mass function. It contains a value and
 * the probability that is associated to that value.
 * 
 * @author ihssane, jens
 * 
 */
public interface ISample {

	/**
	 * Returns the probability of the value stored in the sample.
	 * 
	 * @return Probability of the value.
	 */
	double getProbability();

	/**
	 * Returns the value for which the probability is specified.
	 * 
	 * @return Value object.
	 */
	Object getValue();
	
	void setProbability(double probability); 
}
