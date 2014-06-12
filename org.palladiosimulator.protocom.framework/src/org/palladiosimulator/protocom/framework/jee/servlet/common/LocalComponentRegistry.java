package org.palladiosimulator.protocom.framework.jee.servlet.common;

import java.util.HashMap;

public class LocalComponentRegistry {
	private static LocalComponentRegistry instance;
	
	private HashMap<String, Object> components;
	
	private LocalComponentRegistry() {
		components = new HashMap<String, Object>();
	}
	
	public static LocalComponentRegistry getInstance() {
		if (instance == null) instance = new LocalComponentRegistry();
		return instance;
	}
	
	public void addComponent(String id, Object component) {
		components.put(id, component);
	}
	
	public Object getComponent(String id) {
		return components.get(id);
	}
}
