package de.uka.ipd.sdq.probfunction.math.apache.impl;

import org.apache.commons.math.MathException;

import de.uka.ipd.sdq.probfunction.math.apache.distribution.LognormalDistributionFromMomentsImpl;
import de.uka.ipd.sdq.probfunction.math.apache.distribution.LognormalDistributionImpl;
//import umontreal.iro.lecuyer.probdist.LognormalDist;
//import umontreal.iro.lecuyer.probdist.LognormalDistFromMoments;
import de.uka.ipd.sdq.probfunction.math.ILognormalDistribution;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.InvalidSampleValueException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNameNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

public class LognormalDistribution extends AbstractContinousPDF  implements ILognormalDistribution {
	
	public LognormalDistribution(double mu, double sigma) {
		super();
		this.internalFunction = new LognormalDistributionImpl(mu, sigma);
	}
	
	protected LognormalDistribution(){
		super();
	}

	private LognormalDistribution(LognormalDistributionImpl internal){
		super();
		this.internalFunction = internal;
	}
	
	
	@Override
	public double cdf(double x) {
		//SSJ compatibility
    	if(x == 0.0)
    		return 0;
		return super.cdf(x);
	}

	@Override
	public double density(double x) {
		//SSJ compatibility
		if(x == 0.0)
			return 0.0;
		
		return super.density(x);
	}

	@Override
	public double inverseF(double u) 
	{
		//SSJ compatibility
		if(u == 0.0)
			return 0.0;
		return super.inverseF(u);
	}


	
	public IProbabilityDensityFunction add(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		throw new UnsupportedOperationException();
	}

	
	public IProbabilityDensityFunction div(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		throw new UnsupportedOperationException();
	}

	
	public IProbabilityDensityFunction getCumulativeFunction()
			throws FunctionNotInTimeDomainException {
		throw new UnsupportedOperationException();
	}

	
	public IProbabilityDensityFunction getFourierTransform()
			throws FunctionNotInTimeDomainException {
		throw new UnsupportedOperationException();
	}

	
	public IProbabilityDensityFunction getInverseFourierTransform()
			throws FunctionNotInFrequencyDomainException {
		throw new UnsupportedOperationException();
	}

	
	public double getLowerDomainBorder() {
		throw new UnsupportedOperationException();
	}

	
	public double greaterThan(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException {
		throw new UnsupportedOperationException();
	}

	
	public double lessThan(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException {
		throw new UnsupportedOperationException();
	}

	
	public IProbabilityDensityFunction mult(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		throw new UnsupportedOperationException();
	}

	
	public double probabilisticEquals(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException {
		throw new UnsupportedOperationException();
	}

	
	public IProbabilityDensityFunction scale(double scalar) {
		throw new UnsupportedOperationException();
	}

	
	public IProbabilityDensityFunction sub(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		throw new UnsupportedOperationException();
	}

	
	public void checkConstrains() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		throw new UnsupportedOperationException();

	}

	
	public Object getMedian() throws UnorderedDomainException {
		throw new UnsupportedOperationException();
	}

	
	public Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException {
		throw new UnsupportedOperationException();
	}

	public boolean hasOrderedDomain() {
		throw new UnsupportedOperationException();
	}

	
	public double getMu() {
		return ((LognormalDistributionImpl)this.internalFunction).getMean();
	}

	
	public double getSigma() {
		return ((LognormalDistributionImpl)this.internalFunction).getStandardDeviation();
	}

	
	public IProbabilityDensityFunction shiftDomain(double scalar)
			throws DomainNotNumbersException {
		double newMean = this.getArithmeticMeanValue() + scalar;
		double newVariance = this.getVariance();
		try {
			return new LognormalDistribution(new LognormalDistributionFromMomentsImpl(newMean, newVariance));
		} catch (MathException e) {
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
		}
	}

	
	public IProbabilityDensityFunction stretchDomain(double scalar) {
		double newMean = this.getArithmeticMeanValue() * scalar;
		double newVariance = this.getVariance() * scalar * scalar;
		try {
			return new LognormalDistribution(new LognormalDistributionFromMomentsImpl(newMean, newVariance));
		} catch (MathException e) {
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
		}
	}

	@Override
	public double getStandardDeviation() {
		return Math.sqrt(getVariance());
	}

	@Override
	public double getXinf() {
		return 0.0;
	}

	@Override
	public double getXsup() {
		return Double.POSITIVE_INFINITY;
	}

	@Override
	public double getArithmeticMeanValue() throws DomainNotNumbersException,
			FunctionNotInTimeDomainException {
		double sigma = getSigma();
		double sigma2 = sigma*sigma;
		double mu = getMu();
		return Math.exp(mu+sigma2/2);
	}

	@Override
	public double getVariance() {
		double sigma = getSigma();
		double sigma2 = sigma*sigma;
		double mu = getMu();
		return Math.exp(sigma2 + 2*mu)*Math.expm1(sigma2);
	}
	
	
	

}
