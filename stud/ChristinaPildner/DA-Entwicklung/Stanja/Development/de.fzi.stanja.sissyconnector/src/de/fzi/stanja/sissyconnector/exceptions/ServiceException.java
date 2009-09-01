package de.fzi.stanja.sissyconnector.exceptions;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * changed default behavior. If there is no cause, <code>this</code> is
	 * returned instead of <code>null</code>
	 */
	@Override
	public Throwable getCause() {
		Throwable cause = super.getCause();
		if (null == cause) {
			cause = this;
		}
		return cause;
	}
}
