package de.uka.ipd.sdq.probfunction.math.impl;

import de.uka.ipd.sdq.probfunction.math.IExponentialDistribution;
import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;
import de.uka.ipd.sdq.probfunction.math.ILognormalDistribution;
import de.uka.ipd.sdq.probfunction.math.INormalDistribution;

public interface IContinousPDFFactory 
{

	/**
	 * Creates a new ExponentialDistribution for doing math.
	 * 
	 * @param rate The rate parameter
	 * @return The distribution
	 */
	public IExponentialDistribution createExponentialDistribution(double rate);
	
	/**
	 * Creates a new GammaDistribution for doing math.
	 * 
	 * @param alpha The alpha value
	 * @param theta The theta value
	 * @return The distribution
	 */
	public IGammaDistribution createGammaDistribution(double alpha, double theta);
	
	/**
	 * Creates a new GammaDistribution for doing math.
	 * 
	 * @param mean The mean value
	 * @param coeffVar The coeffVar value
	 * @return The distribution
	 */
	public IGammaDistribution createGammaDistributionFromMoments(double mean, double coeffVar);
	
	/**
	 * Creates a new LognormalDistribution for doing math.
	 * 
	 * @param mu The mean value
	 * @param sigma The standard deviation
	 * @return The distribution
	 */
	public ILognormalDistribution createLognormalDistribution(double mu, double sigma);
	
	
	/**
	 * Creates a new LognormalDistribution for doing math.
	 * 
	 * @param mean The mean value
	 * @param variance The variance value
	 * @return The distribution
	 */
	public ILognormalDistribution createLognormalDistributionFromMoments(double mean, double variance);
	
	
	/**
	 * Creates a new NormalDistribution for doing math.
	 * 
	 * @param mu The mean value
	 * @param sigma The standard deviation
	 * @return The distribution
	 */
	public INormalDistribution createNormalDistribution(double mu, double sigma);
	
}
