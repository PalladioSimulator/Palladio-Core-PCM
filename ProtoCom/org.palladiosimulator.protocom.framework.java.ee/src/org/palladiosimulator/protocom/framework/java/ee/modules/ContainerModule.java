package org.palladiosimulator.protocom.framework.java.ee.modules;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.palladiosimulator.protocom.framework.java.ee.common.Log;
import org.palladiosimulator.protocom.framework.java.ee.legacy.AbstractAllocationStorage;
import org.palladiosimulator.protocom.framework.java.ee.legacy.ComponentAllocation;

/**
 * A ContainerModule represents a PCM resource container and its assigned components.
 * @author Christian Klaussner
 */
public class ContainerModule extends Module {
	/**
	 * Constructs a new ContainerModule object.
	 * @param id the ID of the container
	 * @param name the display name of the container
	 */
	public ContainerModule(String id, String name) {
		super(id, name, true);
	}

	@Override
	public void startModule(String location) throws ModuleStartException {
		if (isStarted()) {
			Log.error("Container '" + getName() + "' already started");
			throw new ModuleStartException();
		}

		Log.info("Start container '" + getName() + "'");

		Collection<ComponentAllocation> components = AbstractAllocationStorage.getComponents(getId());

		for (ComponentAllocation component : components) {
			Log.info("Start component '" + component.getComponentClass().getSimpleName() + "'");

			try {
				Class<?>[] types = {String.class, String.class};
				Object[] arguments = {location, component.getAssemblyContext()};

				Constructor<?> constructor = component.getComponentClass().getConstructor(types);
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
