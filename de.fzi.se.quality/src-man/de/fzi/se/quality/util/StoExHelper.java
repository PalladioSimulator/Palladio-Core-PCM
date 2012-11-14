/**
 *
 */
package de.fzi.se.quality.util;

/**Class with helper function for StoEx processing.
 * @author groenda
 *
 */
public class StoExHelper {

	/**StoEx for the mathematical function max(leftSpecification,rightSpecification).
	 * @param leftSpecification Left specification.
	 * @param rightSpecification Right specification.
	 * @return StoEx specification for the function.
	 */
	public static String stoExMax(String leftSpecification, String rightSpecification) {
		return "Max(" + leftSpecification + ", " + rightSpecification + ")";
	}

	/**StoEx for the mathematical function min(leftSpecification,rightSpecification).
	 * @param leftSpecification Left specification.
	 * @param rightSpecification Right specification.
	 * @return StoEx specification for the function.
	 */
	public static String stoExMin(String leftSpecification, String rightSpecification) {
		return "Min(" + leftSpecification + ", " + rightSpecification + ")";
	}

	/**StoEx for the mathematical function (leftSpecification - rightSpecification).
	 * @param leftSpecification Left specification.
	 * @param rightSpecification Right specification.
	 * @return StoEx specification for the function.
	 */
	public static String stoExMinus(String leftSpecification, String rightSpecification) {
		return "(" + leftSpecification + ") - (" + rightSpecification + ")";
	}

	/**StoEx for the mathematical function (leftSpecification + rightSpecification).
	 * @param leftSpecification Left specification.
	 * @param rightSpecification Right specification.
	 * @return StoEx specification for the function.
	 */
	public static String stoExPlus(String leftSpecification, String rightSpecification) {
		return "(" + leftSpecification + ") + (" + rightSpecification + ")";
	}

	/**StoEx for the mathematical function (leftSpecification * rightSpecification).
	 * @param leftSpecification Left specification.
	 * @param rightSpecification Right specification.
	 * @return StoEx specification for the function.
	 */
	public static String stoExMul(String leftSpecification, String rightSpecification) {
		return "(" + leftSpecification + ") * (" + rightSpecification + ")";
	}
}
