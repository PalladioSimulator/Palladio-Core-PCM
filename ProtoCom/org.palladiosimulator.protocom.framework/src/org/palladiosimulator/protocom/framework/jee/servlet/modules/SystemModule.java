package org.palladiosimulator.protocom.framework.jee.servlet.modules;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.palladiosimulator.protocom.framework.jee.servlet.common.Log;
import org.palladiosimulator.protocom.framework.jee.servlet.registry.RegistryException;

/**
 * A SystemModule object represents a startable PCM system entity.
 * @author Christian Klaussner
 */
public class SystemModule extends Module {
	private String className;
	
	/**
	 * Constructs a new SystemModule object.
	 * @param id the ID of the system
	 * @param name the display name of the system
	 * @param className the class name of the system
	 */
	public SystemModule(String id, String name, String className) {
		super(id, name, true);
		
		this.className = className;
	}

	@Override
	public void startModule(String location) throws ModuleStartException {
		if (isStarted()) {
			Log.error("System '" + getName() + "' already started");
			throw new ModuleStartException();
		}
		
		Log.info("Start system '" + getName() + "'");
		
		try {
			Class<?> systemClass = Class.forName(className);
			
			Class<?>[] types = {String.class, String.class};
			Object[] arguments = {location, getId()};
			
			Constructor<?> constructor = systemClass.getConstructor(types);
			constructor.newInstance(arguments);
			
		} catch (InvocationTargetException e) {
			if (e.getCause() instanceof RegistryException) {
				Log.error("Failed to look up components in registry");
				throw new ModuleStartException();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setStarted(true);
	}
}
