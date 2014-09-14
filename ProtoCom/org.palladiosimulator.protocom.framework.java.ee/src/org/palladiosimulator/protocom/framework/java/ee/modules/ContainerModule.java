package org.palladiosimulator.protocom.framework.java.ee.modules;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.framework.java.ee.prototype.Allocation;

/**
 * A ContainerModule represents a PCM resource container and its assigned components.
 * @author Christian Klaussner
 */
public class ContainerModule extends Module {
	private static final Logger LOGGER = Logger.getRootLogger();

	private Allocation[] allocations;

	/**
	 * Constructs a new ContainerModule object.
	 * @param id the ID of the container
	 * @param name the display name of the container
	 */
	public ContainerModule(String id, String name, Allocation[] allocations) {
		super(id, name, true);

		this.allocations = allocations;
		setDisplayName("Container: " + name);
	}

	@Override
	public void startModule(String location) throws ModuleStartException {
		if (isStarted()) {
			LOGGER.error("Container '" + getName() + "' already started");
			throw new ModuleStartException();
		}

		LOGGER.info("Start container '" + getName() + "'");

		for (Allocation allocation : allocations) {

			LOGGER.info("Start component '" + allocation.getComponentClass().getSimpleName() + "'");

			try {
				Class<?>[] types = {String.class, String.class};
				Object[] arguments = {location, allocation.getAssemblyContext()};

				Constructor<?> constructor = allocation.getComponentClass().getConstructor(types);
				constructor.newInstance(arguments);

			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		setStarted(true);
	}
}
