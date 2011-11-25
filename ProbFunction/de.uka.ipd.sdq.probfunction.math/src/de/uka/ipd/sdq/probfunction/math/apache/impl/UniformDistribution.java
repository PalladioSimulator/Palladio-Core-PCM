/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.apache.impl;

import org.apache.commons.math.MathException;

import de.uka.ipd.sdq.probfunction.math.IUniformDistribution;
import de.uka.ipd.sdq.probfunction.math.apache.distribution.UniformDistributionImpl;
import de.uka.ipd.sdq.probfunction.math.apache.distribution.UniformIntDistributionImpl;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

/**
 * @author joerg
 *
 */
public class UniformDistribution extends AbstractContinousPDF implements IUniformDistribution{
	
	public UniformDistribution(double a, double b) 
	{
		try {
			this.internalFunction = new UniformDistributionImpl(a, b);
		} catch (MathException e) {
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IContinousPDF#getStandardDeviation()
	 */
	@Override
	public double getStandardDeviation() {
		return Math.sqrt(((UniformDistributionImpl)internalFunction).getVariance());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IContinousPDF#getXinf()
	 */
	@Override
	public double getXinf() {
		return ((UniformDistributionImpl)internalFunction).getB();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IContinousPDF#getXsup()
	 */
	@Override
	public double getXsup() {
		
		return ((UniformDistributionImpl)internalFunction).getA();
	}

	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IProbabilityFunction#getArithmeticMeanValue()
	 */
	@Override
	public double getArithmeticMeanValue() throws DomainNotNumbersException,
			FunctionNotInTimeDomainException {
		return ((UniformDistributionImpl)internalFunction).getMean();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IProbabilityFunction#getMedian()
	 */
	@Override
	public Object getMedian() throws UnorderedDomainException {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IProbabilityFunction#getPercentile(int)
	 */
	@Override
	public Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IProbabilityFunction#hasOrderedDomain()
	 */
	@Override
	public boolean hasOrderedDomain() {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getLowerDomainBorder() {
		return ((UniformDistributionImpl)internalFunction).getA();
	}

	@Override
	public double getA() {

		return ((UniformDistributionImpl)internalFunction).getA();
	}

	@Override
	public double getB() {

		return ((UniformDistributionImpl)internalFunction).getB();
	}
	
}
