package de.uka.ipd.sdq.probfunction.math;

import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.InvalidSampleValueException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNameNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

/**
 * A ProbabilityFunction describes a random variable. For each probability
 * function there is a set of stochastic measures that can be derived.
 * 
 * @author ihssane, jens
 * 
 */
public interface IProbabilityFunction {

	/**
	 * A median is a number dividing the higher half of a sample, a population,
	 * or a probability distribution from the lower half. The median of a finite
	 * list of numbers can be found by arranging all the observations from
	 * lowest value to highest value and picking the middle one.
	 * 
	 * @return Object that is the border for the median.
	 * @throws UnorderedDomainException
	 */
	Object getMedian() throws UnorderedDomainException;

	/**
	 * For a probability function, whose domain is integer or real the
	 * arithmetic mean - the sum of all measurements divided by the number of
	 * observations in the data set - is returned.
	 * 
	 * @return The arithmetic mean.
	 * @throws DomainNotNumbersException
	 * @throws FunctionNotInTimeDomainException
	 */
	double getArithmeticMeanValue() throws DomainNotNumbersException,
			FunctionNotInTimeDomainException;

	/**
	 * In descriptive statistics, the 'p'th percentile is a scale value for a
	 * data series equal to the p/100 quantile. Thus:<br> * The 1st percentile
	 * cuts off lowest 1% of data <br> * The 98th percentile cuts off lowest 98%
	 * of data <br> * The 25th percentile is the first quartile <br> * The 50th
	 * percentile is the median.<br>
	 * 
	 * One definition is that the pth percentile of n ordered values is obtained
	 * by first calculating the rank k = p(n+1)/100, rounded to the nearest
	 * integer and then taking the value that corresponds to that rank.
	 * 
	 * @param p
	 *            sets the percentile which shall be computed. p must take
	 *            values between 0 and 100.
	 * @return Object that is the border for the 'p'th percentile.
	 * @throws
	 */
	Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException;

	/**
	 * Computes the sum of all probabilities specified in the function. For pdfs
	 * this is the area under the graph; for pmfs the sum of all probabilities.
	 * 
	 * @return Sum of all probabilities in the function.
	 * @throws FunctionNotInTimeDomainException
	 */
	double getProbabilitySum() throws FunctionNotInTimeDomainException;

	/**
	 * Returns the unit of the probability functions domain.
	 * 
	 * @return unit of the probability functions domain.
	 */
	IUnit getUnit();

	/**
	 * True, if the probability density function is the time domain (a time
	 * domain graph shows how a signal changes over time). This means that it is
	 * not a result of a Fourier transform.
	 * 
	 * @return True, if in time domain; false otherwise.
	 */
	boolean isInTimeDomain();

	/**
	 * True, if the probability density function is in the frequency domain
	 * (frequency domain graph shows how much of the signal lies within each
	 * given frequency band over a range of frequencies). This means it is the
	 * result of a Fourier transformation.
	 * 
	 * @return True, if in frequency domain, false otherwise.
	 */
	boolean isInFrequencyDomain();

	/**
	 * If the domain of the probability functions is ordered, true is returned;
	 * false otherwise.
	 * 
	 * @return True, if the domain is ordered.
	 */
	boolean hasOrderedDomain();

	/**
	 * checks whether the following constraints are fulfilled : the sum of all
	 * probabilities is one. all values are greater or equal 0.
	 * 
	 * @return True, if all constraints are fulfilled
	 * @throws NegativeDistanceException
	 * @throws ProbabilitySumNotOneException
	 * @throws FunctionNotInTimeDomainException
	 * @throws UnitNotSetException
	 * @throws UnitNameNotSetException 
	 * @throws InvalidSampleValueException 
	 */
	void checkConstrains() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException;

}
