package de.uka.ipd.sdq.edp2.impl;

public class DataNotAccessibleException extends Exception {
	/**Necessary for serialization. */
	private static final long serialVersionUID = 1L;

	public DataNotAccessibleException(String message, Throwable arg1) {
		super(message, arg1);
	}
}
