package org.palladiosimulator.protocom.framework.java.ee.modules;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.framework.java.ee.legacy.strategies.DemandConsumerStrategiesRegistry;
import org.palladiosimulator.protocom.framework.java.ee.prototype.PrototypeBridge;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.IDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.ResourceTypeEnum;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * A ContainerModule represents a PCM resource container and its assigned components.
 * @author Christian Klaussner
 */
public class ContainerModule extends Module {
	private static final Logger LOGGER = Logger.getRootLogger();

	private PrototypeBridge.Container container;
	private PrototypeBridge.Allocation[] allocations;

	/**
	 * Constructs a new ContainerModule object.
	 * @param id the ID of the container
	 * @param name the display name of the container
	 */
	public ContainerModule(PrototypeBridge.Container container, PrototypeBridge.Allocation[] allocations) {
		super(container.getId(), container.getName());

		this.container = container;
		this.allocations = allocations;

		setDisplayName("Container: " + container.getName());
	}

	@Override
	public void start(String location) throws ModuleStartException {
		if (isStarted()) {
			LOGGER.error("Container '" + getName() + "' already started");
			throw new ModuleStartException();
		}

		LOGGER.info("Starting container '" + getName() + "'");

		for (PrototypeBridge.Allocation allocation : allocations) {
			String componentName = allocation.getComponentClass().getSimpleName();
			LOGGER.info("Starting component '" + componentName + "'");

			try {
				Class<?> componentClass = allocation.getComponentClass();

				Class<?>[] types = {String.class, String.class};
				Object[] arguments = {location, allocation.getAssemblyContext()};

				Constructor<?> constructor = componentClass.getConstructor(types);
				constructor.newInstance(arguments);

			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Initialize the resource strategies for this component.
		// This has to be done here because the component that is started first determines
		// the resource environment.

		initializeStrategies();

		setStarted(true);
	}

	private void initializeStrategies() {
		double cpuRate = StackContext.evaluateStatic(container.getCpuRate(), Double.class);
		double hddRate = StackContext.evaluateStatic(container.getHddRate(), Double.class);

		DemandConsumerStrategiesRegistry registry = DemandConsumerStrategiesRegistry.singleton();

		IDemandStrategy cpu = registry.getStrategyFor(ResourceTypeEnum.CPU);
		IDemandStrategy hdd = registry.getStrategyFor(ResourceTypeEnum.HDD);

		cpu.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM, cpuRate);
		hdd.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM, hddRate);
	}
}
