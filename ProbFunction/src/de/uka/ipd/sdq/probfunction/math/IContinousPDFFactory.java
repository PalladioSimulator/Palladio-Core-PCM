package de.uka.ipd.sdq.probfunction.math;


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
	

	/**
	 * Creates a new UniformDistribution for doing math.
	 * 
	 * @param a The a value
	 * @param b The b value
	 * @return The distribution
	 */
	public IUniformDistribution createUniformDistribution(double a, double b);
	
    /**
     * Creates a new chi-square distribution with the specified parameter.
     * 
     * @param degreesOfFreedom
     *            the degrees of freedom
     * @return the distribution
     */
    public IChiSquareDistribution createChiSquareDistribution(int degreesOfFreedom);
	
    /**
     * Creates a new student's t-distribution with the specified parameter.
     * 
     * @param degreesOfFreedom
     *            the degrees of freedom
     * @return the distribution
     */    
    public IStudentTDistribution createStudentTDistribution(int degreesOfFreedom);
	
}
