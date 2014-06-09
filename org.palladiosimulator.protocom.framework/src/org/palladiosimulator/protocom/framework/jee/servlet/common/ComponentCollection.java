package org.palladiosimulator.protocom.framework.jee.servlet.common;

import java.util.HashMap;

public class ComponentCollection {
	private static ComponentCollection instance;
	
	private HashMap<String, Object> components;
	
	private ComponentCollection() {
		components = new HashMap<String, Object>();
	}
	
	public static ComponentCollection getInstance() {
		if (instance == null) instance = new ComponentCollection();
		return instance;
	}
	
	public void addComponent(String id, Object component) {
		components.put(id, component);
	}
	
	public Object getComponent(String id) {
		return components.get(id);
	}
}
