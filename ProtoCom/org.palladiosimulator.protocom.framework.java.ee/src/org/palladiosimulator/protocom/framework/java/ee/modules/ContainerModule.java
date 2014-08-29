package org.palladiosimulator.protocom.framework.java.ee.modules;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.palladiosimulator.protocom.framework.java.ee.common.Log;
import org.palladiosimulator.protocom.framework.java.ee.prototype.Allocation;
import org.palladiosimulator.protocom.framework.java.ee.prototype.Prototype;

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


		Allocation[] allocations = Prototype.getInstance().getAllocations(getId());

		for (Allocation allocation : allocations) {

			Log.info("Start component '" + allocation.getComponentClass().getSimpleName() + "'");

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
