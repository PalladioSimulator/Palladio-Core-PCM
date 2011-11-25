/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.apache.impl;


import org.apache.commons.math.distribution.BinomialDistributionImpl;


import de.uka.ipd.sdq.probfunction.math.IBinomialDistribution;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;

import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

/**
 * @author joerg
 *
 */
public class BinomialDistribution extends AbstractDiscretePDF implements IBinomialDistribution
{
	
	public BinomialDistribution(int trials, double p) 
	{
		this.internalFunction = new BinomialDistributionImpl(trials, p);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IContinousPDF#getStandardDeviation()
	 */
	@Override
	public double getStandardDeviation() 
	{
		int n = ((BinomialDistributionImpl)internalFunction).getNumberOfTrials();
		double p = ((BinomialDistributionImpl)internalFunction).getProbabilityOfSuccess();
		return Math.sqrt(n*p*(1-p));
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IContinousPDF#getXinf()
	 */
	@Override
	public double getXinf() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IContinousPDF#getXsup()
	 */
	@Override
	public double getXsup() {
		
		return ((BinomialDistributionImpl)internalFunction).getNumberOfTrials();
	}

	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IProbabilityFunction#getArithmeticMeanValue()
	 */
	@Override
	public double getArithmeticMeanValue() throws DomainNotNumbersException,
			FunctionNotInTimeDomainException {
		return getMean();
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
		throw new UnsupportedOperationException();
	}

	

	@Override
	public double getMean() {
		int n = ((BinomialDistributionImpl)internalFunction).getNumberOfTrials();
		double p = ((BinomialDistributionImpl)internalFunction).getProbabilityOfSuccess();
		return n*p;
	}

	@Override
	public double getProbability() {
		
		return ((BinomialDistributionImpl)internalFunction).getProbabilityOfSuccess();
	}

	@Override
	public int getTrials() {
	
		return ((BinomialDistributionImpl)internalFunction).getNumberOfTrials();
	}

}
