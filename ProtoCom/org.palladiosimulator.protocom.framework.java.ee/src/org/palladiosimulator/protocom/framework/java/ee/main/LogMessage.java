package org.palladiosimulator.protocom.framework.java.ee.main;

/**
 * The LogMessage class stores the data of a log entry.
 * @author Christian Klaussner
 */
public class LogMessage {
	private String text;
	private boolean isError;

	/**
	 * Constructs a new LogMessage object.
	 * @param text the text of the message
	 * @param isError true if the message describes an error, otherwise false
	 */
	public LogMessage(String text, boolean isError) {
		this.text = text;
		this.isError = isError;
	}

	/**
	 * Gets the text of the message.
	 * @return the text of the message
	 */
	public String getText() {
		return text;
	}

	/**
	 * Checks whether the message describes an error.
	 * @return true if the message describes an error, otherwise false
	 */
	public boolean isError() {
		return isError;
	}
}
