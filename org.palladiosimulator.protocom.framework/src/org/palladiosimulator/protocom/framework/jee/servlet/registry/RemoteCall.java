package org.palladiosimulator.protocom.framework.jee.servlet.registry;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A RemoteCall object represents a remote method call.
 * @author Christian Klaussner
 */
public class RemoteCall {
	private static ObjectMapper mapper = new ObjectMapper();
	
	private String name;
	private Class<?>[] parameters;
	private Object[] args;
	
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
	 * Gets the formal parameters of the method.
	 * @return an array containing the formal parameters of the method
	 */
	public Class<?>[] getParameters() {
		return parameters;
	}
	
	/**
	 * Sets the formal parameters of the method.
	 * @param parameters an array containing the formal parameters of the method
	 */
	public void setParameters(Class<?>[] parameters) {
		this.parameters = parameters;
	}
	
	/**
	 * Gets the arguments of the method call.
	 * @return an array containing the arguments of the method call
	 */
	public Object[] getArgs() {
		return args;
	}
	
	/**
	 * Sets the arguments of the method call.
	 * @param args an array containing the arguments of the method call
	 */
	public void setArgs(Object[] args) {
		this.args = args;
	}
	
	/**
	 * Invokes the method represented by this remote call.
	 * @param target the invocation target
	 */
	public void dispatch(Object target) {
		try {
			target.getClass().getMethod(name, parameters).invoke(target, args);
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
			return mapper.writeValueAsString(this);
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
			return mapper.readValue(serialized, RemoteCall.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
