/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.apache.impl;


import de.uka.ipd.sdq.probfunction.math.IBinomialDistribution;
import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IExponentialDistribution;
import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;
import de.uka.ipd.sdq.probfunction.math.ILognormalDistribution;
import de.uka.ipd.sdq.probfunction.math.INormalDistribution;
import de.uka.ipd.sdq.probfunction.math.IPoissonDistribution;
import de.uka.ipd.sdq.probfunction.math.IUniformDistribution;
import de.uka.ipd.sdq.probfunction.math.IUniformIntDistribution;

/**
 * @author joerg
 *
 */
public class PDFFactory implements IPDFFactory{

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.impl.IContinousPDFFactory#createExponentialDistribution(double)
	 */
	@Override
	public IExponentialDistribution createExponentialDistribution(double rate) {
		return new ExponentialDistribution(rate);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.impl.IContinousPDFFactory#createGammaDistribution(double, double)
	 */
	@Override
	public IGammaDistribution createGammaDistribution(double alpha, double theta) {
		return new GammaDistribution(alpha, theta);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.impl.IContinousPDFFactory#createLognormalDistribution(double, double)
	 */
	@Override
	public ILognormalDistribution createLognormalDistribution(double mu, double sigma) {
		return new LognormalDistribution(mu, sigma);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.impl.IContinousPDFFactory#createNormalDistribution(double, double)
	 */
	@Override
	public INormalDistribution createNormalDistribution(double mu, double sigma) {
		return new NormalDistribution(mu, sigma);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.impl.IContinousPDFFactory#createNormalDistribution(double, double)
	 */
	@Override
	public IGammaDistribution createGammaDistributionFromMoments(double mean,
			double coeffVar) {
		
		return new GammaDistributionFromMoments(mean, coeffVar);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.impl.IContinousPDFFactory#createNormalDistribution(double, double)
	 */
	@Override
	public ILognormalDistribution createLognormalDistributionFromMoments(
			double mean, double variance)  {

		return new LognormalDistributionFromMoments(mean, variance);
	}

	@Override
	public IBinomialDistribution createBinomialDistribution(int trials,
			double probability) {
		
		return new BinomialDistribution(trials, probability);
	}

	@Override
	public IPoissonDistribution createPoissonDistribution(double mean) {
		
		return new PoissonDistribution(mean);
	}

	@Override
	public IUniformIntDistribution createUniformIntDistribution(int a, int b) {

		return new UniformIntDistribution(a, b);
	}

	@Override
	public IUniformDistribution createUniformDistribution(double a, double b) {
		
		return new UniformDistribution(a, b);
	}

}
