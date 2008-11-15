package de.uka.ipd.sdq.probfunction.math;

import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

/**
 * In mathematics, a probability density function (pdf) serves to represent a
 * probability distribution in terms of integrals. A probability density
 * function is non-negative everywhere and its integral from -inf to +inf is
 * equal to 1. If a probability distribution has density f(x), then intuitively
 * the infinitesimal interval [x, x + dx] has probability f(x) dx. Informally, a
 * probability density function can be seen as a "smoothed out" version of a
 * histogram: if one empirically measures values of a continuous random variable
 * repeatedly and produces a histogram depicting relative frequencies of output
 * ranges, then this histogram will resemble the random variable's probability
 * density (assuming that the variable is sampled sufficiently often and the
 * output ranges are sufficiently narrow).<br>
 * 
 * For more information see
 * http://en.wikipedia.org/wiki/Probability_Density_Function <br>
 * 
 * @author ihssane, jens
 * 
 */
public interface IProbabilityDensityFunction extends IProbabilityFunction {

	/**
	 * Generates a random number of the probability function's domain, whose
	 * distribution is defined by the probability function.
	 * 
	 * @return A sample of the PDF's domain.
	 */
	double drawSample();

	/**
	 * Returns the smallest values of the domain. At the moment this will be
	 * zero. However, future implementations might allow arbitrary values here.
	 * 
	 * @return Smallest value of the domain.
	 */
	double getLowerDomainBorder();

	/**
	 * Adds two ProbabilityDensityFunctions on a "per value" basis: <br>
	 * h(x) = f(x) + g(x) <br>
	 * 
	 * An addition can only be performed if both functions are in the same
	 * domain (frequency or time). If not a FunctionsInDifferenDomainsException
	 * is thrown. <br>
	 * 
	 * @param pdf
	 *            g(x), probability density function to add.
	 * @return The sum of this function (f(x)) and pdf (g(x))
	 * @throws FunctionsInDifferenDomainsException
	 *             Thrown if both functions are in different domains.
	 * @throws UnknownPDFTypeException
	 *             Thrown if one of the function is of an unknown type (not
	 *             SamplePDf or BoxedPDF).
	 * @throws IncompatibleUnitsException
	 *             Thrown if both functions have units that do not match.
	 */
	IProbabilityDensityFunction add(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException;

	/**
	 * Multiplies two ProbabilityDensityFunctions on a "per value" basis: <br>
	 * h(x) = f(x) * g(x) <br>
	 * 
	 * A multiplication can only be performed if both functions are in the same
	 * domain (frequency or time). If not a FunctionsInDifferenDomainsException
	 * is thrown.
	 * 
	 * @param pdf
	 *            g(x), probability density function to multiply with.
	 * @return The product of this function (f(x)) and pdf (g(x))
	 * @throws FunctionsInDifferenDomainsException
	 *             Thrown if both functions are in different domains.
	 * @throws UnknownPDFTypeException
	 *             Thrown if one of the function is of an unknown type (not
	 *             SamplePDf or BoxedPDF).
	 * @throws IncompatibleUnitsException
	 *             Thrown if both functions have units that do not match.
	 */
	IProbabilityDensityFunction mult(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException;

	/**
	 * Subtracts two ProbabilityDensityFunctions on a "per value" basis: <br>
	 * h(x) = f(x) - g(x) <br>
	 * 
	 * A substraction can only be performed if both functions are in the same
	 * domain (frequency or time). If not a FunctionsInDifferenDomainsException
	 * is thrown.
	 * 
	 * @param pdf
	 *            g(x), probability density function to substract.
	 * @return The difference of this function (f(x)) and pdf (g(x))
	 * @throws FunctionsInDifferenDomainsException
	 *             Thrown if both functions are in different domains.
	 * @throws UnknownPDFTypeException
	 *             Thrown if one of the function is of an unknown type (not
	 *             SamplePDf or BoxedPDF).
	 * @throws IncompatibleUnitsException
	 *             Thrown if both functions have units that do not match.
	 */
	IProbabilityDensityFunction sub(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException;

	/**
	 * Divides two ProbabilityDensityFunctions on a "per value" basis: <br>
	 * h(x) = f(x) / g(x) <br>
	 * 
	 * A division can only be performed if both functions are in the same domain
	 * (frequency or time). If not a FunctionsInDifferenDomainsException is
	 * thrown.
	 * 
	 * @param pdf
	 *            g(x), probability density function to divide by.
	 * @return The fraction of this function (f(x)) and pdf (g(x))
	 * @throws FunctionsInDifferenDomainsException
	 * @throws IncompatibleUnitsException
	 * @throws UnknownPDFTypeException
	 */
	IProbabilityDensityFunction div(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException;

	/**
	 * Scales a ProbabilityDensityFunctions on a "per value" basis: <br>
	 * h(x) = a * f(x)
	 * 
	 * @param scalar
	 *            a, value to scale with.
	 * @return The scaled function a*f(x)
	 */
	IProbabilityDensityFunction scale(double scalar);

	/**
	 * Computes the fourier transform of the probability density function. Can
	 * only be applied if 'isInTimeDomain()' is true, otherwise a
	 * FunctionNotInTimeDomain exception is thrown.
	 * 
	 * @return fourier transform of the PDF (in frequency domain)
	 * @throws FunctionNotInTimeDomainException
	 */
	IProbabilityDensityFunction getFourierTransform()
			throws FunctionNotInTimeDomainException;

	/**
	 * Computes the inverse fourier transform of the probability density
	 * function. Can only be applied if 'isInFrequencyDomain()' is true,
	 * otherwise a FunctionNotInFrequencyDomainException is thrown.
	 * 
	 * @return inverse fourier transform of the PDF (in time domain)
	 * @throws FunctionNotInFrequencyDomainException
	 */
	IProbabilityDensityFunction getInverseFourierTransform()
			throws FunctionNotInFrequencyDomainException;

	/**
	 * returns the cumulative probability function associated with this
	 * probability function.
	 * 
	 * @return the computed cumulative probability function.
	 * @throws FunctionNotInTimeDomainException 
	 */
	IProbabilityDensityFunction getCumulativeFunction() throws FunctionNotInTimeDomainException;

	/**
	 * Computes the probability that two random variables characterised by the
	 * given PDFs are equal. Note that the randomvariables have to be
	 * independent.
	 * 
	 * @param pdf
	 *            PDF to compare to.
	 * @return Probability that the two random variables characterised by the
	 *         PDFs are equal.
	 * @throws ProbabilityFunctionException
	 */
	double probabilisticEquals(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException;

	/**
	 * Computes the probability that the random variable specified by this PDF
	 * is greater than the random variable specified by pdf. Note that the
	 * randomvariables have to be independent.
	 * 
	 * @param pdf
	 *            PDF to compare to.
	 * @return Probability X_this > X_pdf
	 * @throws ProbabilityFunctionException
	 */
	double greaterThan(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException;

	/**
	 * Computes the probability that the random variable specified by this PDF
	 * is less than the random variable specified by pdf. Note that the
	 * randomvariables have to be independent.
	 * 
	 * @param pdf
	 *            PDF to compare to.
	 * @return Probability X_this < X_pdf
	 * @throws ProbabilityFunctionException
	 */
	double lessThan(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException;

	/**
	 * Stretches the domain values of the PDF. This is equivalent to the
	 * multiplication of the specified random variable by the given scalar.
	 * 
	 * @param scalar
	 * @return
	 */
	IProbabilityDensityFunction stretchDomain(double scalar);
	
	/**
	 * Shifts the domain values of the PDF by the given scalar  
	 *
	 * @author Koziolek
	 * @param scalar
	 * @return
	 */
	IProbabilityDensityFunction shiftDomain(double scalar) throws DomainNotNumbersException;


}
