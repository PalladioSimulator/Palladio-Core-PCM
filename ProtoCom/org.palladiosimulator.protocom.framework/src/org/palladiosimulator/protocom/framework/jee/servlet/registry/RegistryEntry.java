package org.palladiosimulator.protocom.framework.jee.servlet.registry;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A RegistryEntry object represents an object in the registry.
 * @author Christian Klaussner
 */
public class RegistryEntry {
	private static ObjectMapper mapper = new ObjectMapper();
	
	private String name;
	private Class<?>[] interfaces;
	private String location;
	private String path;
	
	/**
	 * Constructs a new RegistryEntry object.
	 */
	public RegistryEntry() {
	}
	
	/**
	 * Constructs a new RegistryEntry object.
	 * @param name the name of the registered object
	 * @param interfaces the interfaces of the registered object
	 * @param location the location part of the registered object's URL
	 * @param path the path part of the registered object's URL
	 */
	public RegistryEntry(String name, Class<?>[] interfaces, String location, String path) {
		this.name = name;
		this.interfaces = interfaces;
		this.location = location;
		this.path = path;
	}
	
	/**
	 * Sets the name of the registered object.
	 * @param name the name of the registered object
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the registered object.
	 * @return the name of the registered object
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the interfaces of the registered object.
	 * @param interfaces the interfaces of the registered object
	 */
	public void setInterfaces(Class<?>[] interfaces) {
		this.interfaces = interfaces;
	}
	
	/**
	 * Gets the interfaces of the registered object.
	 * @return the interfaces of the registered object
	 */
	public Class<?>[] getInterfaces() {
		return interfaces;
	}
	
	/**
	 * Sets the location of the registered object.
	 * @param location the location of the registered object
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Gets the location of the registered object.
	 * @return the location of the registered object
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the path of the registered object.
	 * @param path the path of the registered object
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * Gets the path of the registered object.
	 * @return the path of the registered object
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * Converts the registry entry to JSON.
	 * @return a JSON object string representing the registry entry
	 */
	public String toJson() {
		String result = "";
		
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Converts a serialized JSON registry entry to a RegistryEntry object.
	 * @param serialized a JSON object string containing the registry entry
	 * @return the deserialized registry entry
	 */
	public static RegistryEntry fromJson(String serialized) {
		RegistryEntry result = null;
		
		try {
			result = mapper.readValue(serialized, RegistryEntry.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
