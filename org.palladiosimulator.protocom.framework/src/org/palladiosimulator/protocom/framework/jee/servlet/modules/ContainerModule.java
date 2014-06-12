package org.palladiosimulator.protocom.framework.jee.servlet.modules;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.palladiosimulator.protocom.framework.AbstractAllocationStorage;
import org.palladiosimulator.protocom.framework.ComponentAllocation;
import org.palladiosimulator.protocom.framework.jee.servlet.common.Log;

public class ContainerModule extends Module {

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
			Log.info("Start component '" + component.getComponentClass().getName() + "'");
			
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
