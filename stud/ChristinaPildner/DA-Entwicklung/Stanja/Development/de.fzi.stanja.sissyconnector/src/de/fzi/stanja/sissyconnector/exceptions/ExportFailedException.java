package de.fzi.stanja.sissyconnector.exceptions;

public class ExportFailedException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ExportFailedException(String message) {
		super(message);
	}

	public ExportFailedException(String message, Throwable cause) {
		super(message, cause);
	}
}
