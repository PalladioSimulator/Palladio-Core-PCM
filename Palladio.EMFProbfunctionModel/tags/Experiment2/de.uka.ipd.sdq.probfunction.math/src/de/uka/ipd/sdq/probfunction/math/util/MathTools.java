package de.uka.ipd.sdq.probfunction.math.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.ISample;
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
		if (x == 0.0)
			return y;
		if (y == 0.0)
			return x;
		while (Math.abs(x - y) > EPSILON_ERROR) {
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
	 * 
	 * @param d1
	 * @param d2
	 * @return True, if the difference between both values is lower than
	 *         EPSILON_ERROR; false otherwise.
	 */
	public static boolean equalsDouble(double d1, double d2) {
		boolean result = false;
		if (d1 == Double.NaN && d2 == Double.NaN) {
			result = true;
		} else {
			result = (Math.abs(d1 - d2) < EPSILON_ERROR);
		}
		return result;
	}

	public static boolean equalsComplex(Complex z1, Complex z2) {
		boolean result = false;
		if (z1.isNaN() && z2.isNaN()) {
			result = true;
		} else {
			result = equalsDouble(z1.getReal(), z2.getReal())
					&& equalsDouble(z1.getImag(), z2.getImag());
		}
		return result;

	}

	/**
	 * Compute the sum of probabilities associated with a set of
	 * IContinuousSamples.
	 * 
	 * @param list
	 * @return the computed value.
	 */
	public static double sumOfCountinuousSamples(List<IContinuousSample> list) {
		double sum = 0.0;
		for (IContinuousSample s : list)
			sum += s.getProbability();
		return sum;
	}

	/**
	 * Compute the sum of probabilities associated with a set of ISamples.
	 * 
	 * @param list
	 * @return the computed value.
	 */
	public static double sumOfSamples(List<ISample> list) {
		double sum = 0.0;
		for (ISample s : list) {
			sum += s.getProbability();
			System.out.println(sum);
		}
		return sum;
	}

	/**
	 * Compute the sum of a set Doubles.
	 * 
	 * @param list
	 * @return the computed value.
	 */
	public static double sumOfDoubles(List<Double> list) {
		double sum = 0.0;
		for (Double d : list)
			sum += d;
		return sum;
	}

	/**
	 * Returns the cumulative probabilities of the list of input probabilities.
	 * The size of the result list might be smaller than the size of the input list, 
	 * since the function terminates when it reaches 1.0.
	 * 
	 * @param probabilityList
	 * @return
	 */
	public static List<Double> computeCumulativeProbabilities(List<Double> probabilityList) {
		List<Double> resultList = new ArrayList<Double>();
		if (probabilityList == null || probabilityList.size() == 0)
			throw new IllegalArgumentException("ProbabilityList is empty or null!");
		resultList.add(probabilityList.get(0));

		for (int i = 1; i < probabilityList.size(); i++) {
			if (equalsDouble(1.0, resultList.get(i - 1)))
				break;
			resultList.add(resultList.get(i - 1) + probabilityList.get(i));
		}
		return resultList;
	}

	/**
	 * @param samples
	 * @param prob
	 * @return
	 */
	public static HashMap<Double, Line> computeLines(
			List<IContinuousSample> samples, List<Double> intervals) {
		HashMap<Double, Line> lines = new HashMap<Double, Line>();
		lines.put(intervals.get(0), new Line(0, 0, samples.get(0).getValue(),
				samples.get(0).getProbability()));

		for (int i = 1; i < intervals.size(); i++) {
			double x1 = samples.get(i - 1).getValue();
			double y1 = intervals.get(i - 1);
			double x2 = samples.get(i).getValue();
			double y2 = intervals.get(i);
			if (y1 != y2)
				lines.put(intervals.get(i), new Line(x1, y1, x2, y2));
		}

		return lines;
	}

	public static Comparator<IContinuousSample> getContinuousSampleComparator() {
		Comparator<IContinuousSample> comp = new Comparator<IContinuousSample>() {
			@SuppressWarnings("unchecked")
			public int compare(IContinuousSample o1, IContinuousSample o2) {
				return ((Comparable) o1.getValue()).compareTo(o2.getValue());
			}

		};
		return comp;
	}

	public static Comparator<ISample> getSampleComparator() {
		Comparator<ISample> sComparator = new Comparator<ISample>() {

			@SuppressWarnings("unchecked")
			public int compare(ISample o1, ISample o2) {
				return ((Comparable) o1.getValue()).compareTo(o2.getValue());
			}
		};
		return sComparator;
	}

	public static String asString(double val) {
		double rVal = ((double) Math.round(val * 10000.0)) / 10000.0;
		return Double.toString(rVal);
	}

	public static BigDecimal over(int n, int k) {
		return factorial(n).divide(factorial(k).multiply(factorial(n - k)));
	}
	
	public static BigDecimal over(int n, int[] nList){
		BigDecimal numerator = factorial(n);
		BigDecimal denominator = BigDecimal.ONE;
		for (int ni : nList) {
			denominator = denominator.multiply(factorial(ni));
		}
		return numerator.divide(denominator);
	}

	
	public static BigDecimal computeJointProbability(BigDecimal[] probList, int[] nList){
		assert(nList.length == probList.length);
		BigDecimal result = BigDecimal.ONE;
		for (int i = 0; i < nList.length; i++) {
			result = result.multiply(probList[i].pow(nList[i]));
		}
		return result;
	}
	

	public static BigDecimal factorial(long n) {
		if (n < 0)
			return null;
		if (n == 0)
			return BigDecimal.ONE;
		BigDecimal fac = BigDecimal.ONE;
		for (long i = 1; i <= n; i++) {
			fac = fac.multiply(new BigDecimal(i));
		}
		return fac;
	}

	public static boolean isNumeric(Object value) {
		if ((value instanceof Double) || (value instanceof Integer)
				|| (value instanceof Long) || (value instanceof Float))
			return true;
		return false;
	}

	public static List<Complex> transformSampleToComplex(List<ISample> samples) {
		List<Complex> resultList = new ArrayList<Complex>();
		for (ISample s : samples) {
			resultList.add(new Complex(s.getProbability(), convertToDouble(s
					.getValue())));
		}
		return resultList;
	}

	public static double convertToDouble(Object value) {
		double r = 0.0;
		if (value instanceof Double) {
			r = (Double) value;
		} else if (value instanceof Integer) {
			r = ((Integer) value).doubleValue();
		} else if (value instanceof Boolean) {
			r = ((Boolean) value).booleanValue() ? 1.0 : 0.0;
		} else if (value instanceof Float)
			r = ((Float) value).doubleValue();
		return r;
	}
	
	public static double round(double value,double precision){
		value *= 1 / precision;
		long temp = Math.round(value);
		return temp * precision;
	}
}
