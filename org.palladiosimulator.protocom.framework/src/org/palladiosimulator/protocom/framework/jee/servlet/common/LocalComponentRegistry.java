package org.palladiosimulator.protocom.framework.jee.servlet.common;

import java.util.HashMap;

/**
 * The LocalComponentRegistry singleton provides methods for registering components and systems.
 * It is used to transfer references of components and systems to their respective ports. 
 * @author Christian Klaussner
 */
public class LocalComponentRegistry {
	private static LocalComponentRegistry instance;
	
	private HashMap<String, Object> components;
	
	/**
	 * Private constructor.
	 */
	private LocalComponentRegistry() {
		components = new HashMap<String, Object>();
	}
	
	/**
	 * Singleton accessor.
	 * @return the component registry instance
	 */
	public static LocalComponentRegistry getInstance() {
		if (instance == null) instance = new LocalComponentRegistry();
		return instance;
	}
	
	/**
	 * Adds a component or system to the local registry.
	 * @param id the ID of the component or system
	 * @param component the component or system obejct
	 */
	public void addComponent(String id, Object component) {
		components.put(id, component);
	}
	
	/**
	 * Gets the component or system with the specified ID.
	 * @param id the ID of the component or system
	 * @return the component or system
	 */
	public Object getComponent(String id) {
		return components.get(id);
	}
}
