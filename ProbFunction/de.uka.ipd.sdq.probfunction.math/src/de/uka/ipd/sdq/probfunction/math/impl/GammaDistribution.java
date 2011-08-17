package de.uka.ipd.sdq.probfunction.math.impl;

import umontreal.iro.lecuyer.probdist.GammaDist;
import umontreal.iro.lecuyer.probdist.GammaDistFromMoments;
import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;
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
 * @see IGammaDistribution
 * @author martens
 */
public class GammaDistribution extends AbstractContinousPDF implements IGammaDistribution {

	/**
	 *  Constructs a GammaDist object with parameters alpha and theta.
	 * @param alpha shape parameter
	 * @param theta scale parameter = 1 / rate parameter
	 */
	public GammaDistribution(double alpha, double theta) {
		super();
		/* Note that there is an error in the umontreal.iro.lecuyer.probdist.GammaDist
		 * documentation: They name the second parameter lambda the scale parameter,
		 * but it acts as the rate parameter beta, not the scale parameter theta (terms as defined at 
		 * wikipedia version http://en.wikipedia.org/w/index.php?title=Gamma_distribution&oldid=413746510),
		 * as becomes visible when comparing the function definition in the documentation 
		 * with the function defined on the Wikipedia page. 
		 */ 
		this.internalFunction = new GammaDist(alpha, 1.0/theta);
	}
	
	protected GammaDistribution(){
		super();
	}

	private GammaDistribution(GammaDist internal) {
		super();
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
		return ((GammaDist)this.internalFunction).getAlpha();
	}

	/**
	 * Scale parameter = 1 / rate parameter
	 */
	public double getTheta() {
		return 1.0/((GammaDist)this.internalFunction).getLambda();
	}

	
	public IProbabilityDensityFunction getCumulativeFunction()
			throws FunctionNotInTimeDomainException {
		throw new UnsupportedOperationException();
	}

	
	public IProbabilityDensityFunction shiftDomain(double scalar)
			throws DomainNotNumbersException {
		double newMean = this.getArithmeticMeanValue() + scalar;
		double newVariance = this.getVariance();
		return new GammaDistribution(new GammaDistFromMoments(newMean, newVariance));
	}

	
	public IProbabilityDensityFunction stretchDomain(double scalar) {
		double newMean = this.getArithmeticMeanValue() * scalar;
		double newVariance = this.getVariance() * scalar * scalar;
		return new GammaDistribution(new GammaDistFromMoments(newMean, newVariance));
	}
}
