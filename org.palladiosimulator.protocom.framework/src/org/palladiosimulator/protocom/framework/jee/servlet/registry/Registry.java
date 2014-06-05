package org.palladiosimulator.protocom.framework.jee.servlet.registry;

import org.palladiosimulator.protocom.framework.jee.servlet.http.Parameter;
import org.palladiosimulator.protocom.framework.jee.servlet.http.Request;
import org.palladiosimulator.protocom.framework.jee.servlet.http.Response;
import org.palladiosimulator.protocom.framework.jee.servlet.http.StringResponse;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * The Registry singleton provides methods for registering and accessing remote objects.
 * Communication with registered objects is performed over HTTP.
 * 
 * @author Christian Klaussner
 */
public class Registry {
	private static Registry instance;
	private static String location;
	
	/**
	 * Private constructor.
	 */
	private Registry() {
	}
	
	/**
	 * Singleton accessor.
	 * @return the registry instance
	 */
	public static Registry getInstance() {
		if (instance == null) instance = new Registry();
		return instance;
	}
	
	/**
	 * Sets the location of the registry.
	 * @param location the location URL of the registry
	 */
	public static void setLocation(String location) {
		Registry.location = location;
	}
	
	/**
	 * Registers the specified object in the registry.
	 * @param name the name under which the object is registered
	 * @param iface the interface of the object
	 * @param location the location part of the object's URL
	 * @param path the path part of the object's URL
	 * @throws RegistryException
	 */
	public static void register(String name, Class<?> iface, String location, String path)
			throws RegistryException {
		
		RegistryEntry entry = new RegistryEntry(name, iface, location, path);
		ArrayList<Parameter> params = new ArrayList<Parameter>(2);
		
		params.add(new Parameter("action", "register"));
		params.add(new Parameter("entry", entry.toJson()));	
			
		String responseString = Request.get(Registry.location, "/Registry", params);
		StringResponse response = StringResponse.fromJson(responseString);
		
		if (response.getError() == Response.ALREADY_EXISTS) {
			throw new RegistryException("Object '" + name + "' is already registered");
		}
	}
	
	/**
	 * Removes the specified object from the registry.
	 * @param name the name of the object to remove
	 * @throws RegistryException
	 */
	public static void unregister(String name) throws RegistryException {
		ArrayList<Parameter> params = new ArrayList<Parameter>(2);
		
		params.add(new Parameter("action", "unregister"));
		params.add(new Parameter("name", name));
		
		String responseString = Request.get(Registry.location, "/Registry", params);
		StringResponse response = StringResponse.fromJson(responseString);
		
		if (response.getError() == Response.INVALID) {
			throw new RegistryException("Object '" + name + "' is not registered");
		}
	}
	
	/**
	 * Returns a stub for an object with the specified name.
	 * @param name the name under which the object is registered
	 * @return a stub for the object
	 * @throws RegistryException
	 */
	public static Object lookup(String name) throws RegistryException {
		ArrayList<Parameter> params = new ArrayList<Parameter>(2);
		
		params.add(new Parameter("action", "lookup"));
		params.add(new Parameter("name", name));
		
		String responseString = Request.get(location, "/Registry", params);
		StringResponse response = StringResponse.fromJson(responseString);
		
		if (response.getError() != Response.OK) {
			throw new RegistryException("Failed to look up '" + name + "' in registry");
		}
		
		RegistryEntry entry = RegistryEntry.fromJson(response.getPayload());
			
		Object stub = Proxy.newProxyInstance(
				entry.getInterface().getClassLoader(), 
				new Class<?>[] {entry.getInterface()}, 
				new RemoteStub(entry.getLocation(), entry.getPath()));
		
		return stub;
	}
}
