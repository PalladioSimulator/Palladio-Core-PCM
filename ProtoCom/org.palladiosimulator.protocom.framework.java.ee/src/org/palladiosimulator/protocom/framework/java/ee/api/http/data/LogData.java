package org.palladiosimulator.protocom.framework.java.ee.api.http.data;

import java.util.List;

import org.palladiosimulator.protocom.framework.java.ee.main.LogMessage;

/**
 * The LogData class is used to store the data of log messages to be sent via LogSockets.
 * @author Christian Klaussner
 */
public class LogData {
	private Object payload;

	/**
	 * Constructs a new LogData object.
	 */
	public LogData() {
	}

	/**
	 * Sets the data payload.
	 * @param payload a single log message
	 */
	public void setPayload(LogMessage payload) {
		this.payload = payload;
	}

	/**
	 * Sets the data payload.
	 * @param payload a list of log messages
	 */
	public void setPayload(List<LogMessage> payload) {
		this.payload = payload;
	}

	/**
	 * Gets the data payload.
	 * @return a single log message or a list of log messages
	 */
	public Object getPayload() {
		return payload;
	}
}
