package de.uka.ipd.sdq.probfunction.math.impl;

import umontreal.iro.lecuyer.probdist.GammaDist;
import umontreal.iro.lecuyer.probdist.GammaDistFromMoments;
import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
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
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

public class GammaDistribution extends AbstractContinousPDF implements IGammaDistribution {

	public GammaDistribution(double alpha, double beta) {
		super();
		this.internalFunction = new GammaDist(alpha, beta);
	}

	private GammaDistribution(GammaDistFromMoments internal) {
		super();
		this.internalFunction = internal;
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
	public double drawSample() {
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


	@Override
	public Object getMedian() throws UnorderedDomainException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException {
		throw new UnsupportedOperationException();
	}

	@Override
	public IUnit getUnit() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasOrderedDomain() {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getAlpha() {
		return ((GammaDist)this.internalFunction).getAlpha();
	}

	@Override
	public double getBeta() {
		return ((GammaDist)this.internalFunction).getLambda();
	}

	@Override
	public IProbabilityDensityFunction getCumulativeFunction()
			throws FunctionNotInTimeDomainException {
		throw new UnsupportedOperationException();
	}

	@Override
	public IProbabilityDensityFunction shiftDomain(double scalar)
			throws DomainNotNumbersException {
		double newMean = this.getArithmeticMeanValue() + scalar;
		double newVariance = this.getVariance();
		return new GammaDistribution(new GammaDistFromMoments(newMean, newVariance));
	}

	@Override
	public IProbabilityDensityFunction stretchDomain(double scalar) {
		double newMean = this.getArithmeticMeanValue() * scalar;
		double newVariance = this.getVariance() * scalar * scalar;
		return new GammaDistribution(new GammaDistFromMoments(newMean, newVariance));
	}
}
