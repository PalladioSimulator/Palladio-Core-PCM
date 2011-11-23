package de.uka.ipd.sdq.probfunction.math.apache.impl;

import org.apache.commons.math.distribution.ExponentialDistributionImpl;
//import umontreal.iro.lecuyer.probdist.ExponentialDist;
import de.uka.ipd.sdq.probfunction.math.IExponentialDistribution;
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

/**
 * Supports only the mean value so far. 
 * 
 * Some of the other methods could probably be provided. 
 * 
 * TODO: A number of calculations are possible, implement them instead of throwing UnsupportedOperationException().
 * 
 * See e.g. http://en.wikipedia.org/wiki/List_of_convolutions_of_probability_distributions
 * @author martens
 *
 */
public class ExponentialDistribution extends AbstractContinousPDF implements IExponentialDistribution {
	
	public ExponentialDistribution(double rate){
		double mean = 1.0/rate;
		this.internalFunction = new ExponentialDistributionImpl(mean);
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

	public double getRate() {
		return 1.0/((ExponentialDistributionImpl)this.internalFunction).getMean();
	}
	
	
	public IProbabilityDensityFunction scale(double scalar) {
		throw new UnsupportedOperationException();
	}

	public IProbabilityDensityFunction shiftDomain(double scalar)
			throws DomainNotNumbersException {
		throw new UnsupportedOperationException();
	}

	public IProbabilityDensityFunction stretchDomain(double scalar) {
		return new ExponentialDistribution(this.getRate() / scalar);
	}

	@Override
	public double getStandardDeviation() {
		/**
		 * Apache math uses the StandardDeviation as mean!
		 */
		final double m = ((ExponentialDistributionImpl)this.internalFunction).getMean();
        return m;
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
		return ((ExponentialDistributionImpl)this.internalFunction).getMean();
	}


}
