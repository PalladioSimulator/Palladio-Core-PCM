package org.palladiosimulator.protocom.framework.java.ee.registry;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

import org.palladiosimulator.protocom.framework.java.ee.http.Parameter;
import org.palladiosimulator.protocom.framework.java.ee.http.Request;
import org.palladiosimulator.protocom.framework.java.ee.http.Response;
import org.palladiosimulator.protocom.framework.java.ee.http.StringResponse;

/**
 * The Registry singleton provides methods for registering and accessing remote objects.
 * Communication with registered objects is performed over HTTP.
 *
 * @author Christian Klaussner
 */
public final class Registry {
	private static Registry instance;

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
		if (instance == null) {
			instance = new Registry();
		}

		return instance;
	}

	//

	private String location;

	/**
	 * Sets the location of the registry.
	 * @param location the location URL of the registry
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	/**
	 * Registers the specified object in the registry.
	 * @param name the name under which the object is registered
	 * @param interfaces the interfaces of the object
	 * @param location the location part of the object's URL
	 * @param path the path part of the object's URL
	 * @throws RegistryException when the object could not be registered
	 */
	public void register(String name, Class<?>[] interfaces, String location, String path)
			throws RegistryException {

		RegistryEntry entry = new RegistryEntry(name, interfaces, location, path);
		ArrayList<Parameter> params = new ArrayList<Parameter>(2);

		params.add(new Parameter("action", "register"));
		params.add(new Parameter("entry", entry.toJson()));

		String responseString = Request.get(location, "/Registry", params);
		StringResponse response = StringResponse.fromJson(responseString);

		if (response.getError() == Response.ALREADY_EXISTS) {
			throw new RegistryException("Object '" + name + "' is already registered");
		}
	}

	/**
	 * Removes the specified object from the registry.
	 * @param name the name of the object to remove
	 * @throws RegistryException when the object could not be unregistered
	 */
	public void unregister(String name) throws RegistryException {
		ArrayList<Parameter> params = new ArrayList<Parameter>(2);

		params.add(new Parameter("action", "unregister"));
		params.add(new Parameter("name", name));

		String responseString = Request.get(location, "/Registry", params);
		StringResponse response = StringResponse.fromJson(responseString);

		if (response.getError() == Response.INVALID) {
			throw new RegistryException("Object '" + name + "' is not registered");
		}
	}

	/**
	 * Returns a stub for an object with the specified name.
	 * @param name the name under which the object is registered
	 * @return a stub for the object
	 * @throws RegistryException when the object was not registered
	 */
	public Object lookup(String name) throws RegistryException {
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
				entry.getInterfaces()[0].getClassLoader(),
				entry.getInterfaces(),
				new LocalStub(entry.getLocation(), entry.getPath()));

		return stub;
	}
}
