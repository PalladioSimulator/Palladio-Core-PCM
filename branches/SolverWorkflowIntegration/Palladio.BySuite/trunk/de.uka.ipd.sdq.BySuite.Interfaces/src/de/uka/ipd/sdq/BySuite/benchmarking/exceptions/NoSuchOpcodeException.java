package de.uka.ipd.sdq.BySuite.benchmarking.exceptions;

/**
 * @author Michael Kuperberg
 *
 */
public class NoSuchOpcodeException extends Exception {

	/**
	 * As usual
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * TODO
	 * @param x
	 */
	public NoSuchOpcodeException(String x){
		super(x);
	}

	/**
	 * TODO
	 */
	public NoSuchOpcodeException() {

	}

}
