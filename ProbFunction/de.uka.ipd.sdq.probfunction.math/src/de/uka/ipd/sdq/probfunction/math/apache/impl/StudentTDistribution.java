package de.uka.ipd.sdq.probfunction.math.apache.impl;

import org.apache.commons.math.distribution.TDistributionImpl;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IStudentTDistribution;
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
 * Student's t-distribution. This distribution has a single parameter called the degrees of freedom.
 * <p>
 * The implementation of this class is partly based on the information given in [1].
 * <p>
 * [1] http://en.wikipedia.org/w/index.php?title=Student%27s_t-distribution&oldid=462316896
 * 
 * @author Philipp Merkle
 * 
 */
public class StudentTDistribution extends AbstractContinousPDF implements IStudentTDistribution {

    private int degreesOfFreedom;

    /**
     * Default constructor.
     * 
     * @param degreesOfFreedom
     *            the parameter of this distribution, which must be a positive integer
     */
    public StudentTDistribution(int degreesOfFreedom) {
        assert (degreesOfFreedom > 0) : "The parameter degrees of freedom must be a positive integer.";
        this.degreesOfFreedom = degreesOfFreedom;
        this.internalFunction = new TDistributionImpl(degreesOfFreedom);
    }

    @Override
    public double getDegreesOfFreedom() {
        return degreesOfFreedom;
    }

    @Override
    public double getVariance() {
        // this method has been implemented in accordance with [1]
        if (this.degreesOfFreedom == 2) {
            return Double.POSITIVE_INFINITY;
        } else if (this.degreesOfFreedom > 2) {
            return this.degreesOfFreedom / (this.degreesOfFreedom - 2.0);
        } else {
            // undefined value
            return Double.NaN;
        }
    }

    @Override
    public double getStandardDeviation() {
        return Math.sqrt(this.getVariance());
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
        if (this.degreesOfFreedom > 1) {
            return 0.0;
        } else {
            // undefined value
            return Double.NaN;
        }
    }

    @Override
    public Object getMedian() throws UnorderedDomainException {
        return 0.0;
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
