package de.uka.ipd.sdq.probfunction.math.apache.impl;

import org.apache.commons.math.distribution.ChiSquaredDistributionImpl;

import de.uka.ipd.sdq.probfunction.math.IChiSquareDistribution;
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
 * Chi-square distribution. The chi-square distribution has a single parameter called the degrees of
 * freedoms.
 * <p>
 * The implementation of this class is partly based on the information given in [1].
 * <p>
 * [1] http://en.wikipedia.org/w/index.php?title=Chi-squared_distribution&oldid=461800524
 * 
 * @author Philipp Merkle
 * 
 */
public class ChiSquareDistribution extends AbstractContinousPDF implements IChiSquareDistribution {

    private int degreesOfFreedom;

    /**
     * Default constructor.
     * 
     * @param degreesOfFreedom
     *            the parameter of this distribution, which must be a positive integer
     */
    public ChiSquareDistribution(int degreesOfFreedom) {
        assert (degreesOfFreedom > 0) : "The parameter degrees of freedom must be a positive integer.";
        this.degreesOfFreedom = degreesOfFreedom;
        this.internalFunction = new ChiSquaredDistributionImpl(degreesOfFreedom);
    }

    @Override
    public double getDegreesOfFreedom() {
        return this.degreesOfFreedom;
    }

    @Override
    public double getVariance() {
        // this method has been implemented in accordance with [1]
        return 2.0 * this.degreesOfFreedom;
    }

    @Override
    public double getStandardDeviation() {
        return Math.sqrt(this.getVariance());
    }

    @Override
    public double getXinf() {
        return 0;
    }

    @Override
    public double getXsup() {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public IProbabilityDensityFunction add(IProbabilityDensityFunction pdf) throws FunctionsInDifferenDomainsException,
            UnknownPDFTypeException, IncompatibleUnitsException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IProbabilityDensityFunction div(IProbabilityDensityFunction pdf) throws FunctionsInDifferenDomainsException,
            UnknownPDFTypeException, IncompatibleUnitsException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IProbabilityDensityFunction getCumulativeFunction() throws FunctionNotInTimeDomainException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IProbabilityDensityFunction getFourierTransform() throws FunctionNotInTimeDomainException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IProbabilityDensityFunction getInverseFourierTransform() throws FunctionNotInFrequencyDomainException {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getLowerDomainBorder() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double greaterThan(IProbabilityDensityFunction pdf) throws ProbabilityFunctionException {
        throw new UnsupportedOperationException();
    }

    @Override
    public double lessThan(IProbabilityDensityFunction pdf) throws ProbabilityFunctionException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IProbabilityDensityFunction mult(IProbabilityDensityFunction pdf)
            throws FunctionsInDifferenDomainsException, UnknownPDFTypeException, IncompatibleUnitsException {
        throw new UnsupportedOperationException();
    }

    @Override
    public double probabilisticEquals(IProbabilityDensityFunction pdf) throws ProbabilityFunctionException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IProbabilityDensityFunction scale(double scalar) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IProbabilityDensityFunction shiftDomain(double scalar) throws DomainNotNumbersException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IProbabilityDensityFunction stretchDomain(double scalar) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IProbabilityDensityFunction sub(IProbabilityDensityFunction pdf) throws FunctionsInDifferenDomainsException,
            UnknownPDFTypeException, IncompatibleUnitsException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void checkConstrains() throws NegativeDistanceException, ProbabilitySumNotOneException,
            FunctionNotInTimeDomainException, UnitNotSetException, UnitNameNotSetException, InvalidSampleValueException {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getArithmeticMeanValue() throws DomainNotNumbersException, FunctionNotInTimeDomainException {
        // this method has been implemented in accordance with [1]
        return this.getDegreesOfFreedom();
    }

    @Override
    public Object getMedian() throws UnorderedDomainException {
        // this method has been implemented in accordance with [1]
        double intermediateResult = 1 - (2 / (9 * degreesOfFreedom));
        return degreesOfFreedom * Math.pow(intermediateResult, 3);
    }

    @Override
    public Object getPercentile(int p) throws IndexOutOfBoundsException, UnorderedDomainException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasOrderedDomain() {
        throw new UnsupportedOperationException();
    }

}
