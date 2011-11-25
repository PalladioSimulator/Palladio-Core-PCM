package de.uka.ipd.sdq.probfunction.math.apache.impl;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.AbstractIntegerDistribution;


import de.uka.ipd.sdq.probfunction.math.IDiscretePDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.IUnit;
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

public abstract class AbstractDiscretePDF implements IDiscretePDF {

	protected AbstractIntegerDistribution internalFunction = null;
	protected IRandomGenerator sampleDrawer = null;
	
		
	public AbstractDiscretePDF() {
		super();
	}

	/**
	 * Returns the distribution function F(x) as defined in 
	 * {@link umontreal.iro.lecuyer.probdist.Distribution#cdf(double)}
	 * @param x
	 * @return F(x)
	 */
	public double cdf(int x){
		try {
			return this.internalFunction.cumulativeProbability(x);
		} catch (MathException e) {
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
		}
	}

	
	
	public double getCoefficientOfVariance() {
		return this.getStandardDeviation() / this.getArithmeticMeanValue();
	}


	public double getVariance() {
		double std = this.getStandardDeviation();
		return std * std;
	}

	public double getProbabilitySum() {
		return 1;
	}

	@Override
	public double probability(int x) {
		return internalFunction.probability(x);
	}



	public boolean isInFrequencyDomain() {
		return false;
	}

	public boolean isInTimeDomain() {
		return true;
	}
	
	/**
	 * Returns the distribution function F(x) as defined in 
	 * {@link umontreal.iro.lecuyer.probdist.Distribution#cdf(double)}
	 * @param x
	 * @return F(x)
	 */
	public double cdf(double x){
		try {
			return this.internalFunction.cumulativeProbability(x);
		} catch (MathException e) {
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
		}
	}
	
	
	
	public double drawSample() {
		if (sampleDrawer == null) {
			throw new ProbabilityFunctionException("RNG was not set!");

		}
		try {
			return internalFunction.inverseCumulativeProbability(sampleDrawer.random());
		} catch (MathException e) {
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
		}
	}


	


	/**
	 * Computes and returns the inverse distribution function x = F^{-1}(u). 
	 * This can be used to get the quantiles of the distribution. 
	 * Pass 0.9 to get the x value of this function for which this.cdf(x) = 0.9 holds.
	 * Uses the implementation of the concrete function in the {@link umontreal.iro.lecuyer.probdist} package. 
	 * @param u - value in the interval [0, 1] for which the inverse distribution function is evaluated 
	 * @return the inverse distribution function evaluated at u
	 */
	public int inverseF(double u) {
		
		try {
			return this.internalFunction.inverseCumulativeProbability(u);
		} catch (MathException e) {
			e.printStackTrace();
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
		}
	}


	public IUnit getUnit() {
		return null;
	}
	
	



	@Override
	public IProbabilityDensityFunction add(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		throw new UnsupportedOperationException();
	}



	@Override
	public IProbabilityDensityFunction div(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		throw new UnsupportedOperationException();
		
	}



	@Override
	public IProbabilityDensityFunction getCumulativeFunction()
			throws FunctionNotInTimeDomainException {
		throw new UnsupportedOperationException();
	}



	@Override
	public IProbabilityDensityFunction getFourierTransform()
			throws FunctionNotInTimeDomainException {
		throw new UnsupportedOperationException();
	}



	@Override
	public IProbabilityDensityFunction getInverseFourierTransform()
			throws FunctionNotInFrequencyDomainException {
		throw new UnsupportedOperationException();
	}



	



	@Override
	public double greaterThan(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException {
		throw new UnsupportedOperationException();
	}



	@Override
	public double lessThan(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException {
		throw new UnsupportedOperationException();
	}



	@Override
	public IProbabilityDensityFunction mult(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		throw new UnsupportedOperationException();
	}



	@Override
	public double probabilisticEquals(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException {
		throw new UnsupportedOperationException();
	}



	@Override
	public IProbabilityDensityFunction scale(double scalar) {
		throw new UnsupportedOperationException();
	}



	@Override
	public IProbabilityDensityFunction shiftDomain(double scalar)
			throws DomainNotNumbersException {
		throw new UnsupportedOperationException();
	}



	@Override
	public IProbabilityDensityFunction stretchDomain(double scalar) {
		throw new UnsupportedOperationException();
	}



	@Override
	public IProbabilityDensityFunction sub(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		throw new UnsupportedOperationException();
	}



	@Override
	public void checkConstrains() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		throw new UnsupportedOperationException();
		
	}



	

	
	
	


}
