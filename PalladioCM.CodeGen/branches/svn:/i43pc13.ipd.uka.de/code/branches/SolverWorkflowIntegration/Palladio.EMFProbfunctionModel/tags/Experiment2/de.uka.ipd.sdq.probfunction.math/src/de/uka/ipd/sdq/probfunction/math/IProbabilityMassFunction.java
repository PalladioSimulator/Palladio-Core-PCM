package de.uka.ipd.sdq.probfunction.math;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;

/**
 * A probability mass function (abbreviated pmf) gives the probability that a
 * discrete random variable is exactly equal to some value. A probability mass
 * function differs from a probability density function in that the values of
 * the latter, defined only for continuous random variables, are not
 * probabilities; rather, its integral over a set of possible values of the
 * random variable is a probability.
 * 
 * @author ihssane, jens
 * 
 */
public interface IProbabilityMassFunction extends IProbabilityFunction {

	/**
	 * Generates a random number of the probability function's domain, whose
	 * distribution is defined by the probability function.
	 * 
	 * @return A sample of the PMF's domain.
	 */
	Object drawSample();

	/**
	 * Adds the probabilities of two probability mass functions (pmf) on a 'per
	 * value' basis.<br>
	 * h(x) = f(x) + g(x) (f = this, g = parameter pmf)<br>
	 * For the addition, the domains of both pmfs have to be equal. This means
	 * that
	 * <li> * the value objects of the pmf's samples have to be of the same
	 * class and </li>
	 * <li> * for each value object of the samples in function f (this) there is
	 * exactly one equal value object in the samples of function g (pmf) and
	 * vice versa. Here, equal means that Object.equal(...) returns true for
	 * both objects.</li>
	 * <br>
	 * 
	 * If the domain of both functions are not equal, a
	 * DifferentDomainsException is thrown.
	 * 
	 * @param pmf
	 *            Function to add.
	 * @return A new pmf that contains the sum of both.
	 * @throws DifferentDomainsException
	 *             if the domains of both function differ.
	 */
	IProbabilityMassFunction add(IProbabilityMassFunction pmf)
			throws DifferentDomainsException;

	/**
	 * Substracts the probabilities of two probability mass functions (pmf) on a
	 * 'per value' basis.<br>
	 * h(x) = f(x) - g(x) (f = this, g = parameter pmf) <br>
	 * For the substraction, the domains of both pmfs have to be equal. This
	 * means that
	 * <li> * the value objects of the pmf's samples have to be of the same
	 * class and </li>
	 * <li> * for each value object of the samples in function f (this) there is
	 * exactly one equal value object in the samples of function g (pmf) and
	 * vice versa. Here, equal means that Object.equal(...) returns true for
	 * both objects.</li>
	 * <br>
	 * 
	 * If the domain of both functions are not equal, a
	 * DifferentDomainsException is thrown.
	 * 
	 * @param pmf
	 *            Function to substract.
	 * @return A new pmf that contains the difference of both.
	 * @throws DifferentDomainsException
	 *             if the domains of both function differ.
	 */
	IProbabilityMassFunction sub(IProbabilityMassFunction pmf)
			throws DifferentDomainsException;

	/**
	 * Multiplies the probabilities of two probability mass functions (pmf) on a
	 * 'per value' basis.<br>
	 * h(x) = f(x) * g(x) (f = this, g = parameter pmf)<br>
	 * For the multiplication, the domains of both pmfs have to be equal. This
	 * means that
	 * <li> * the value objects of the pmf's samples have to be of the same
	 * class and </li>
	 * <li> * for each value object of the samples in function f (this) there is
	 * exactly one equal value object in the samples of function g (pmf) and
	 * vice versa. Here, equal means that Object.equal(...) returns true for
	 * both objects.</li>
	 * <br>
	 * 
	 * If the domain of both functions are not equal, a
	 * DifferentDomainsException is thrown.
	 * 
	 * @param pmf
	 *            Function to multiply with.
	 * @return A new pmf that contains the product of both.
	 * @throws DifferentDomainsException
	 *             if the domains of both function differ.
	 */
	IProbabilityMassFunction mult(IProbabilityMassFunction pmf)
			throws DifferentDomainsException;

	/**
	 * Divides the probabilities of two probability mass functions (pmf) on a
	 * 'per value' basis.<br>
	 * h(x) = f(x) / g(x) (f = this, g = parameter pmf)<br>
	 * For the division, the domains of both pmfs have to be equal. This means
	 * that
	 * <li> * the value objects of the pmf's samples have to be of the same
	 * class and </li>
	 * <li> * for each value object of the samples in function f (this) there is
	 * exactly one equal value object in the samples of function g (pmf) and
	 * vice versa. Here, equal means that Object.equal(...) returns true for
	 * both objects.</li>
	 * <br>
	 * 
	 * If the domain of both functions are not equal, a
	 * DifferentDomainsException is thrown.
	 * 
	 * @param pmf
	 *            Function to divide by.
	 * @return A new pmf that contains the fraction of both.
	 * @throws DifferentDomainsException
	 *             if the domains of both function differ.
	 */
	IProbabilityMassFunction div(IProbabilityMassFunction pmf)
			throws DifferentDomainsException;

	/**
	 * Scales the probabilities of a probability mass functions (pmf) on a 'per
	 * value' basis.<br>
	 * h(x) = a * f(x) (f = this, a = parameter scalar)<br>
	 * 
	 * @param scalar
	 *            the value to scale the probabilities.
	 * @return A new pmf that contains the scaled probabilities.
	 */
	IProbabilityMassFunction scale(double scalar);

	
	/**
	 * Shifts each value of the PMF by the given scalar (i.e., adds the
	 * given scalar to each value). If the scalar is 
	 * larger than zero, the PMF gets shifted to the right, otherwise it
	 * gets shifted to the left. 
	 *
	 * @author Koziolek
	 * @param scalar
	 * @return
	 */
	IProbabilityMassFunction shiftDomain(double scalar) throws DomainNotNumbersException;
	
	/**
	 * Stretches the domain of the PMF by the given scalar (i.e, multiplies
	 * each value with the given scalar). If the scalar is larger than 1, 
	 * the PMF gets stretched. If the scalar is between zero and 1, the 
	 * PMF gets compressed.
	 * 
	 * @author Koziolek
	 * @param scalar
	 * @return
	 */
	IProbabilityMassFunction stretchDomain(double scalar) throws DomainNotNumbersException;
	
	
	/**
	 * Computes the Fourier transform of the probability mass function. Note,
	 * that you should only use this function if you really know what you are
	 * doing, as this doesn't make sense in many cases for pmfs! <br>
	 * <br>
	 * Can only be applied if 'isInTimeDomain()' is true, otherwise a
	 * FunctionNotInTimeDomainException is thrown.
	 * 
	 * @return Fourier transform of pmf (in time domain).
	 * @throws FunctionNotInTimeDomainException
	 * @return The transformed pmf.
	 */
	IProbabilityMassFunction getFourierTramsform()
			throws FunctionNotInTimeDomainException;

	/**
	 * Computes the inverse Fourier transform of the probability mass function.
	 * Note, that you should only use this function if you really know what you
	 * are doing, as this doesn't make sense in many cases for pmfs! <br>
	 * <br>
	 * Can only be applied if 'isInFrequencyDomain()' is true, otherwise a
	 * FunctionNotInFrequencyDomainException is thrown.
	 * 
	 * @return Fourier transform of pmf (in time domain).
	 * @throws FunctionNotInFrequencyDomainException
	 * @return The transformed pmf.
	 */
	IProbabilityMassFunction getInverseFourierTransform()
			throws FunctionNotInFrequencyDomainException;

	/**
	 * List of samples describing the pmf. They associate a value (x axis) with
	 * a probability (y axis). In case 'hasOrderedDomain' is true, they are
	 * sorted. Note: The function returns only a copy of the sample list.
	 * 
	 * @return A <i>Copy</i> of the list of (ordered) samples describing the
	 *         pmf.
	 */
	List<ISample> getSamples();

	/**
	 * List of samples describing the pmf. They associate a value (x axis) with
	 * a probability (y axis). In case the values can be ordered, they will be
	 * sorted.
	 * 
	 * Note: The sum of all probabilities has to be one!
	 * 
	 * @param samples
	 *            New list of samples describing the pmf.
	 * 
	 * @throws ProbabilitySumNotOneException
	 *             Thrown if the sum of the samples probabilities is not one.
	 */
	void setSamples(List<ISample> samples);

	/**
	 * @param pmf
	 * @return
	 */
	boolean haveSameDomain(IProbabilityMassFunction pmf);

	/**
	 * returns the cumulative probability function associated with this
	 * probability function.
	 * 
	 * @return the computed cumulative probability function.
	 */
	IProbabilityMassFunction getCumulativeFunction();

}
