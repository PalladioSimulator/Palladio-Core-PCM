package org.palladiosimulator.protocom.framework.java.ee.api.rest.data;

import java.util.List;

/**
 *
 * @author Christian Klaussner
 */
public class LogData {
	private Object payload;

	public LogData() {
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public void setPayload(List<String> payload) {
		this.payload = payload;
	}

	public Object getPayload() {
		return payload;
	}
}
