package org.palladiosimulator.protocom.framework.java.ee.api.http.data;

/**
 * The RegistryData class is used to store the location of the registry.
 * @author Christian Klaussner
 */
public class RegistryData {
	private String location;

	/**
	 * Constructs a new RegistryData object.
	 */
	public RegistryData() {
	}

	/**
	 * Sets the location of the registry.
	 * @param location the location of the registry
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the location of the registry.
	 * @return the location of the registry
	 */
	public String getLocation() {
		return location;
	}
}
