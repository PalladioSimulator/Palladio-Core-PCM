package org.palladiosimulator.protocom.framework.java.ee.protocol;

import java.io.IOException;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * A RemoteCall object represents a remote method call.
 * @author Christian Klaussner
 */
public class RemoteCall {
	private static final ObjectMapper MAPPER;

	static {
		MAPPER = new ObjectMapper();
		MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}

	private String name;
	private Class<?>[] formalTypes, actualTypes;
	private Object[] arguments;

	/**
	 * Constructs a new RemoteCall object.
	 */
	public RemoteCall() {
	}

	/**
	 * Constructs a new RemoteCall object.
	 * @param name the name of the method to invoke
	 */
	public RemoteCall(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the method.
	 * @return the name of the method
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the method.
	 * @param name the name of the method
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the formal parameter types of the method.
	 * @return an array containing the formal parameters of the method
	 */
	public Class<?>[] getFormalTypes() {
		return formalTypes;
	}

	/**
	 * Sets the formal parameter types of the method.
	 * @param formalTypes an array containing the formal parameters of the method
	 */
	public void setFormalTypes(Class<?>[] formalTypes) {
		this.formalTypes = formalTypes;
	}

	/**
	 * Gets the actual parameter types of the method.
	 * @return an array containing the actual parameter types of the method
	 */
	public Class<?>[] getActualTypes() {
		return actualTypes;
	}

	/**
	 * Sets the actual parameter types of the method.
	 * @param actualTypes an array containing the actual parameter types
	 */
	public void setActualTypes(Class<?>[] actualTypes) {
		this.actualTypes = actualTypes;
	}

	/**
	 * Gets the arguments of the method call.
	 * @return an array containing the arguments of the method call
	 */
	public Object[] getArguments() {
		return arguments;
	}

	/**
	 * Sets the arguments of the method call.
	 * @param arguments an array containing the arguments of the method call
	 */
	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}

	/**
	 * Invokes the method represented by this remote call.
	 * @param target the invocation target
	 */
	public void dispatch(Object target) {
		try {
			target.getClass().getMethod(name, formalTypes).invoke(target, arguments);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Converts the remote call to JSON.
	 * @return a JSON object string representing the remote call
	 */
	public String toJson() {
		try {
			return MAPPER.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Converts a serialized JSON remote call to a RemoteCall object.
	 * @param serialized a JSON object string containing the remote call
	 * @return the deserialized remote call
	 */
	public static RemoteCall fromJson(String serialized) {
		try {
			RemoteCall call = MAPPER.readValue(serialized, RemoteCall.class);

			if (call.getArguments() != null) {
				for (int i = 0; i < call.arguments.length; i++) {
					if (call.arguments[i] instanceof LinkedHashMap<?, ?>) {
						call.arguments[i] = MAPPER.convertValue(call.arguments[i], call.actualTypes[i]);
					}
				}
			}

			return call;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
