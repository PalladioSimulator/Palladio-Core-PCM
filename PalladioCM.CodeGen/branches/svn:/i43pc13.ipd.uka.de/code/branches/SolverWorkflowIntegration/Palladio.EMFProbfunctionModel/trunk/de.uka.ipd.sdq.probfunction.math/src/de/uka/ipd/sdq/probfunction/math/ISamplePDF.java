package de.uka.ipd.sdq.probfunction.math;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.SizeTooSmallException;
import flanagan.complex.Complex;

/**
 * For the implementation of the SamplePDF, we used a simplified version of
 * probability density functions to ease the following computations and
 * analyses. The pdf is approximated by a number of sampling points, which are
 * seperated by a fixed distance. Each sampling point contains the probability
 * for a sample to lie in a certain interval. For example, if we have a pdf with
 * a distance of 5 between the sampling points, the probability stored in the
 * first point is for the interval [0, 2.5), the second for the interval [2.5,
 * 7.5), and so on. The probabilities of the intervals [a, b) are derived from the
 * original pdf by computing difference F(b) - F(a) of its integral, which is
 * the the probability for a sample lying in the interval.
 * 
 * @author ihssane, jens
 * 
 */
public interface ISamplePDF extends IProbabilityDensityFunction {

	/**
	 * Increases the number of sampling points. The new enries are filled with
	 * the value returned by 'getFillValue()'. The values are added at the end
	 * of the pdf.
	 * 
	 * @param newSize
	 *            the new number of sampling points. If newSize is smaller than
	 *            the original size, an exception is thrown.
	 * @throws SizeTooSmallException
	 *             Thrown if newSize is small than the current number of
	 *             elements.
	 */
	void expand(int newSize) throws SizeTooSmallException;

	/**
	 * Returns the distance between the sampling points.
	 * 
	 * @return distance between the sampling points.
	 */
	double getDistance();

	/**
	 * Creates a new SamplePDF that describes the same PDF, but whose sampling
	 * points are computed according to a new distance.
	 * 
	 * @param distance
	 *            Distance of the new function.
	 * @return A new SamplePDF that describes the same PDF, but whose sampling
	 *         points are adjusted to the new distance.
	 * @throws FunctionNotInTimeDomainException
	 * @throws NegativeDistanceException
	 */
	ISamplePDF getFunctionWithNewDistance(double distance)
			throws NegativeDistanceException, FunctionNotInTimeDomainException;

	/**
	 * Returns the real part of the function's samples. <i>Copy only!</i>
	 * 
	 * @return Samples of the function.
	 */
	List<Double> getValuesAsDouble();

	/**
	 * Returns the sampling points of the function as complex numbers. <i>Copy
	 * only!</i>
	 * 
	 * @return Samples of the function.
	 */
	List<Complex> getValues();
	
	Complex getValue(int pos);
	
	Double getValueAsDouble(int pos);

	/**
	 * /** Sets the sampling points of the function. As the values are doubles,
	 * only the real part of the complex numbers is set. The imaginary part is
	 * set to zero. The function is automatically set to the time domain.
	 * 
	 * Note: The sum of all values has to be one, otherwise a
	 * ProbabilitySumNotOneException is thrown.
	 * 
	 * @param values
	 *            a new list of sampling points.
	 * 
	 * @throws ProbabilitySumNotOneException
	 *             Thrown, if the sum of the values is not one.
	 */
	void setValuesAsDouble(List<Double> values);

	/**
	 * Sets the sampling points of the function.
	 * 
	 * @param values
	 *            a new list of sampling points.
	 * @throws ProbabilitySumNotOneException
	 *             Thrown, if the sum of the real part of the values is not one,
	 *             if the function is in the time domain (isInFrequencyDomain ==
	 *             false).
	 */
	void setValues(List<Complex> values, boolean isInFrequencyDomain);

	/**
	 * Returns the real part of the value used to fill unset sampling points at
	 * the end of the function.
	 * 
	 * @return Real part of the fill value.
	 */
	double getFillValueAsDouble();

	/**
	 * Returns the value used to fill unset sampling points at the end of the
	 * function.
	 * 
	 * @return Fill value.
	 */
	Complex getFillValue();

	/**
	 * Sets the real part of the fill value to fillValue and the imaginary part
	 * to zero.
	 * 
	 * @param fillValue
	 *            the real part of the new fill value.
	 */
	void setFillValue(double fillValue);

	/**
	 * Sets the new fill value.
	 * 
	 * @param fillValue
	 *            New fill value.
	 */
	void setFillValue(Complex fillValue);

	/**
	 * The number of samples used to approximate the pdf.
	 * 
	 * @return Number of Samples.
	 */
	int numberOfSamples();
}
