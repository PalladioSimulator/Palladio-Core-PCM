package de.uka.ipd.sdq.probfunction.math.apache.impl;


import org.apache.commons.math.distribution.GammaDistributionImpl;
//import umontreal.iro.lecuyer.probdist.GammaDist;
//import umontreal.iro.lecuyer.probdist.GammaDistFromMoments;
import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.apache.distribution.GammaDistributionFromMomentsImpl;
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
 * @see IGammaDistribution
 * @author martens
 */
public class GammaDistribution extends AbstractContinousPDF implements IGammaDistribution {

	/**
	 *  Constructs a GammaDist object with parameters alpha and theta.
	 * @param alpha shape parameter
	 * @param theta scale parameter = 1 / rate parameter
	 */
	public GammaDistribution(double alpha, double theta, IRandomGenerator rng){
		super(rng);
		/* 
		 * In contrast to SSJ apache common math uses beta as a direct replacement of theta! 
		 * No 1/theta required!
		 */ 
		this.internalFunction = new GammaDistributionImpl(alpha, theta);
	}
	
	@Override
	public double density(double x) {
		//SSJ compatibility
		if(x == 0.0)
			return 0.0;
		
		return super.density(x);
	}

	protected GammaDistribution(IRandomGenerator rng){
		super(rng);
	}

	private GammaDistribution(GammaDistributionImpl internal, IRandomGenerator rng){
		super(rng);
		this.internalFunction = internal;
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

	/**
	 * Shape parameter
	 */
	public double getAlpha() {
		return ((GammaDistributionImpl)this.internalFunction).getAlpha();
	}

	/**
	 * Scale parameter beta
	 */
	public double getTheta() {
		return ((GammaDistributionImpl)this.internalFunction).getBeta();
	}

	
	public IProbabilityDensityFunction getCumulativeFunction()
			throws FunctionNotInTimeDomainException {
		throw new UnsupportedOperationException();
	}

	
	public IProbabilityDensityFunction shiftDomain(double scalar)
			throws DomainNotNumbersException {
		double newMean = this.getArithmeticMeanValue() + scalar;
		double newVariance = this.getVariance();
		return new GammaDistribution(new GammaDistributionFromMomentsImpl(newMean, newVariance), sampleDrawer);
	}

	
	@Override
	public double getVariance() 
	{
		//variance is easier to calculate for gamma than sd
		return this.getAlpha()*this.getTheta()*this.getTheta();
	}

	public IProbabilityDensityFunction stretchDomain(double scalar) {
		double newMean = this.getArithmeticMeanValue() * scalar;
		double newVariance = this.getVariance() * scalar * scalar;
		return new GammaDistribution(new GammaDistributionFromMomentsImpl(newMean, newVariance), sampleDrawer);
	}

	@Override
	public double getStandardDeviation() {
		return Math.sqrt(this.getVariance());
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
		return this.getAlpha()*this.getTheta();
	}
}
