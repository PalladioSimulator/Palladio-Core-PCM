package org.palladiosimulator.protocom.framework.jee.servlet.http;

import java.io.IOException;

/**
 * A StringResponse object represents an HTTP response with a string payload. 
 * @author Christian Klaussner
 */
public class StringResponse extends Response {
	private String payload = "";
	
	/**
	 * Constructs a new StringResponse object.
	 */
	public StringResponse() {
	}
	
	/**
	 * Constructs a new StringResponse object.
	 * @param payload the payload of the response
	 */
	public StringResponse(String payload) {
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
	 * @param playload the payload of the response
	 */
	public void setPayload(String playload) {
		this.payload = playload;
	}
	
	/**
	 * Converts a serialized JSON response to a StringResponse object.
	 * @param serialized a JSON object string containing the response
	 * @return the deserialized response
	 */
	public static StringResponse fromJson(String serialized) {
		StringResponse result = null;
		
		// System.out.println("Plain response: " + serialized);
		
		try {
			result = mapper.readValue(serialized, StringResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
