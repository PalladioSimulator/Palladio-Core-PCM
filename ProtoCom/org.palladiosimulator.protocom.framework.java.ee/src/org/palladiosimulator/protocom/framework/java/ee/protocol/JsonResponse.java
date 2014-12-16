package org.palladiosimulator.protocom.framework.java.ee.protocol;

import com.fasterxml.jackson.annotation.JsonRawValue;

/**
 * A JsonResponse object represents an HTTP response with a JSON payload. 
 * @author Christian Klaussner
 */
public class JsonResponse extends Response {
	@JsonRawValue
	private String payload = "";
	
	/**
	 * Constructs a new JsonResponse object.
	 */
	public JsonResponse() {
	}
	
	/**
	 * Constructs a new JsonResponse object.
	 * @param payload the payload of the response
	 */
	public JsonResponse(String payload) {
		error = OK;
		this.payload = payload;
	}
	
	/**
	 * Gets the payload of the response.
	 * @return the payload of the response
	 */
	public String getPayload() {
		return payload;
	}
	
	/**
	 * Sets the payload of the response.
	 * @param payload the payload of the response
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}
}
