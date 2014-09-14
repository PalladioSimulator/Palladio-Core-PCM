package org.palladiosimulator.protocom.framework.java.ee.api.rest.data;

import java.util.List;

import org.palladiosimulator.protocom.framework.java.ee.ui.LogMessage;

/**
 *
 * @author Christian Klaussner
 */
public class LogData {
	private Object payload;

	public LogData() {
	}

	public void setPayload(LogMessage payload) {
		this.payload = payload;
	}

	public void setPayload(List<LogMessage> payload) {
		this.payload = payload;
	}

	public Object getPayload() {
		return payload;
	}
}
