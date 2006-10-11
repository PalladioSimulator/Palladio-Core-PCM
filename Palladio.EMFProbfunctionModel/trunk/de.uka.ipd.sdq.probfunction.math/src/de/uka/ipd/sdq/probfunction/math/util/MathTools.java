package de.uka.ipd.sdq.probfunction.math.util;

import java.util.ArrayList;
import java.util.List;

import flanagan.complex.Complex;

/**
 * MathTools contains a set of commonly used mathematical functions, that are
 * not provided by the Java libraries.
 * 
 * @author ihssane, jens
 * 
 */
public class MathTools {

	/**
	 * Difference up to which two values are considered as equal.
	 */
	public static final double EPSILON_ERROR = 1e-10;

	/**
	 * Computes the greatest common divisor (GDC) of a set of numbers.
	 * 
	 * @param numbers
	 *            List of numbers for which the GDC shall be computed.
	 * @return Returns the greatest common divisor of all numbers
	 */
	public static double gcd(List<Double> numbers) {
		if (numbers.size() < 2)
			throw new IllegalArgumentException(
					"number of digit must be greater than 2");

		double gcd = gcd(numbers.get(0), numbers.get(1));
		for (int i = 2; i < numbers.size(); i++)
			gcd = gcd(gcd, numbers.get(i));
		return gcd;
	}

	/**
	 * Computes thre greatest common divisor (GDC) of two numbers
	 * 
	 * @param x
	 *            first number
	 * @param y
	 *            second number
	 * @return Returns the GDC of y and x.
	 */
	public static double gcd(double x, double y) {
		while (Math.abs(x - y) > 1e-10) {
			if (x > y) {
				x -= y;

			} else {
				y -= x;

			}
		}
		return x;
	}

	/**
	 * Transforms a list of complex values to a list of double values by
	 * throwing away the imaginary part.
	 * 
	 * @param values
	 *            List of complex values to transform.
	 * @return The real part of the value list as doubles.
	 */
	public static List<Double> transformComplexToDouble(List<Complex> values) {
		List<Double> resultList = new ArrayList<Double>();
		for (Complex complex : values) {
			resultList.add(complex.getReal());
		}
		return resultList;
	}

	/**
	 * Transforms a list of double values to a list of complex values. The real
	 * parts are set to the values in the list, the imaginary part is set to
	 * zero.
	 * 
	 * @param values
	 *            List of double values to transform.
	 * @return A list of complex values equivalent to the doubles.
	 */
	public static List<Complex> transformDoubleToComplex(List<Double> values) {
		List<Complex> resultList = new ArrayList<Complex>();
		for (Double d : values) {
			resultList.add(new Complex(d));
		}
		return resultList;
	}
	
	/**
	 * Compares two doubles.
	 * @param d1
	 * @param d2
	 * @return True, if the difference between both values is lower than EPSILON_ERROR; false otherwise.
	 */
	public static boolean equalsDouble(double d1, double d2){
		return (Math.abs(d1 - d2) < EPSILON_ERROR);
	}
}
