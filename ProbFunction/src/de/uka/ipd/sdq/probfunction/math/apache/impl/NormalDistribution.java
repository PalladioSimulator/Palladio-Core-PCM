package de.uka.ipd.sdq.probfunction.math.apache.impl;


import org.apache.commons.math.distribution.NormalDistributionImpl;
//import umontreal.iro.lecuyer.probdist.NormalDist;
import de.uka.ipd.sdq.probfunction.math.INormalDistribution;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
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
 * TODO: A number of calculations are possible, implement them instead of throwing UnsupportedOperationException().
 * 
 * See e.g. http://en.wikipedia.org/wiki/List_of_convolutions_of_probability_distributions
 * @author martens
 *
 */
public class NormalDistribution extends AbstractContinousPDF implements
		INormalDistribution {
	
	public NormalDistribution(double mean, double sigma, IRandomGenerator rng){
		super(rng);
		double sd = sigma;
		this.internalFunction = new NormalDistributionImpl(mean, sd);
	}

	@Override
	public double getMean() {
		return ((NormalDistributionImpl)this.internalFunction).getMean();
	}

	@Override
	public double getSigma() {
		return ((NormalDistributionImpl)this.internalFunction).getStandardDeviation();
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
	public double getLowerDomainBorder() {
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
	/**
	 * ``substracting a constant [...] reduces the mean [..] by that constant''
	 * Statistical Methods for Psychology Von David C. Howell, p. 72 
	 */
	public IProbabilityDensityFunction shiftDomain(double scalar)
			throws DomainNotNumbersException {
		double newMean = this.getArithmeticMeanValue() + scalar;
		double newSigma = this.getSigma();
		return new NormalDistribution(newMean, newSigma, sampleDrawer);
	}

	@Override
	/**
	 * ``if we multiply or divide [...] by a constant [..], we multiply of divide the standard deviation by that constant.''
	 * and also the mean (in the cited case the mean was 0). 
	 * Statistical Methods for Psychology Von David C. Howell, p. 72 
	 */
	public IProbabilityDensityFunction stretchDomain(double scalar) {
		double newMean = this.getArithmeticMeanValue() * scalar;
		double newSigma = this.getSigma() * scalar;
		return new NormalDistribution(newMean, newSigma, sampleDrawer);
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
		// TODO Auto-generated method stub

	}

	@Override
	public Object getMedian() throws UnorderedDomainException {
		return ((NormalDistributionImpl)internalFunction).getMean();
	}

	@Override
	public Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasOrderedDomain() {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getStandardDeviation() {
		return ((NormalDistributionImpl)internalFunction).getStandardDeviation();
	}

	@Override
	public double getXinf() {
		
		return Double.NEGATIVE_INFINITY;
	}

	@Override
	public double getXsup() {
		return Double.POSITIVE_INFINITY;
	}

	@Override
	public double getArithmeticMeanValue() throws DomainNotNumbersException,
			FunctionNotInTimeDomainException {
		return ((NormalDistributionImpl)internalFunction).getMean();
		}

}
