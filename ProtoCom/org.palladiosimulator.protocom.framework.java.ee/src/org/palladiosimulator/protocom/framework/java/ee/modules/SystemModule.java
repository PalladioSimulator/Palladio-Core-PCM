package org.palladiosimulator.protocom.framework.java.ee.modules;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.framework.java.ee.registry.RegistryException;

/**
 * A SystemModule object represents a startable PCM system entity.
 * @author Christian Klaussner
 */
public class SystemModule extends Module {
	private static Logger LOGGER = Logger.getRootLogger();

	private String className;

	/**
	 * Constructs a new SystemModule object.
	 * @param name the display name of the system
	 * @param className the class name of the system
	 */
	public SystemModule(String name, String className) {
		super("0", name);

		this.className = className;
		setDisplayName("System: " + name);
	}

	@Override
	public void start(String location) throws ModuleStartException {
		if (isStarted()) {
			LOGGER.error("System '" + getName() + "' already started");
			throw new ModuleStartException();
		}

		LOGGER.info("Starting system '" + getName() + "'");

		try {
			Class<?> systemClass = Class.forName(className);

			Class<?>[] types = {String.class, String.class};
			Object[] arguments = {location, getId()};

			Constructor<?> constructor = systemClass.getConstructor(types);
			constructor.newInstance(arguments);

		} catch (InvocationTargetException e) {
			if (e.getCause() instanceof RegistryException) {
				LOGGER.error("Failed to look up components in registry");
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
