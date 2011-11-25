/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.apache.impl;


import org.apache.commons.math.distribution.PoissonDistributionImpl;


import de.uka.ipd.sdq.probfunction.math.IPoissonDistribution;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;

import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

/**
 * @author joerg
 *
 */
public class PoissonDistribution extends AbstractDiscretePDF implements IPoissonDistribution{
	
	public PoissonDistribution(double lambda) 
	{
		this.internalFunction = new PoissonDistributionImpl(lambda);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.math.IContinousPDF#getStandardDeviation()
	 */
	@Override
	public double getStandardDeviation() 
	{
		
		double lambda = ((PoissonDistributionImpl)internalFunction).getMean();
		return Math.sqrt(lambda);
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
		
		return Double.POSITIVE_INFINITY;
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
		return ((PoissonDistributionImpl)internalFunction).getMean();
	}

}
