package org.palladiosimulator.protocom.framework.java.ee.main;

/**
*
*/
public class LogMessage {
	private String text;
	private boolean isError;

	public LogMessage(String text, boolean isError) {
		this.text = text;
		this.isError = isError;
	}

	public String getText() {
		return text;
	}

	public boolean isError() {
		return isError;
	}
}
