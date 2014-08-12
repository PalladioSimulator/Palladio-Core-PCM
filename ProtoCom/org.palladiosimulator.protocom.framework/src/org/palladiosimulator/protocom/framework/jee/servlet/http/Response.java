package org.palladiosimulator.protocom.framework.jee.servlet.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A Response object represents an HTTP response.
 * @author Christian Klaussner
 */
public class Response {
	public static final int OK = 0;
	public static final int ALREADY_EXISTS = 1;
	public static final int INVALID = 2;
	public static final int FAILED = 3;
	
	protected static final ObjectMapper mapper = new ObjectMapper();
	
	protected int error;
	
	/**
	 * Constructs a new Response object.
	 */
	public Response() {
	}
	
	/**
	 * Constructs a new Response object.
	 * @param error the error code of the response
	 */
	public Response(int error) {
		this.error = error;
	}
	
	/**
	 * Gets the error code of the response.
	 * @return the error code of the response
	 */
	public int getError() {
		return error;
	}
	
	/**
	 * Sets the error code of the response.
	 * @param error the error code of the response
	 */
	public void setError(int error) {
		this.error = error;
	}
	
	/**
	 * Converts the response to JSON.
	 * @return a JSON object string representing the response
	 */
	public String toJson() {
		String json = "";
		
		try {
			json = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return json;
	}
}
