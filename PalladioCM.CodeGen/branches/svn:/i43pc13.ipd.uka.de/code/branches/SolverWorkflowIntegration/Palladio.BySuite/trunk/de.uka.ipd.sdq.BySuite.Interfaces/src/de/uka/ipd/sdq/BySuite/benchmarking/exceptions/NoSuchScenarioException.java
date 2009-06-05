package de.uka.ipd.sdq.BySuite.benchmarking.exceptions;

/**
 * @author Michael Kuperberg
 *
 */
public class NoSuchScenarioException extends Exception {

	/**
	 * As usual
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * TODO
	 * @param string
	 */
	public NoSuchScenarioException(String string) {
		super(string);
	}

}
