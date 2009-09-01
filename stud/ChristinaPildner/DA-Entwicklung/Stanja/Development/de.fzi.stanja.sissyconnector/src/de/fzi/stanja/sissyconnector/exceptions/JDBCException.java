package de.fzi.stanja.sissyconnector.exceptions;

public class JDBCException extends AccessException {
	private static final long serialVersionUID = 1L;

	public JDBCException(String message) {
		super(message);
	}

	public JDBCException(String message, Throwable cause) {
		super(message, cause);
	}

}
