package de.uka.ipd.sdq.probfunction.math.apache.impl;


import org.apache.commons.math.MathException;


import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.apache.distribution.LognormalDistributionFromMomentsImpl;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;

public class LognormalDistributionFromMoments extends LognormalDistribution  {
	
	/**
	 * Constructs a GammaDist object based on the distribution mean and 
	 * distribution coefficient of variance. 
	 * @param distribution mean 
	 * @param coefficient of variance ( = standard deviation / mean)  
	 * @throws MathException 
	 */
	public LognormalDistributionFromMoments(double mean, double variance, IRandomGenerator rng){
		super(rng);
		
		
		try {
			this.internalFunction = new LognormalDistributionFromMomentsImpl(mean, variance);
		} catch (MathException e) {
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
			
		}
	}


}
