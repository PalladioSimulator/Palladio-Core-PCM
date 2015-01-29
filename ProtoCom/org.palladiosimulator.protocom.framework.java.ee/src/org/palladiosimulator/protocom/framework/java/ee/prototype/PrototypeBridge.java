package org.palladiosimulator.protocom.framework.java.ee.prototype;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Singleton;

/**
 * The PrototypeBridge class is used to make generated prototype data available to the framework.
 * @author Christian Klaussner
 */
@Singleton
public final class PrototypeBridge {

/**
 * The System class stores the data of a PCM system.
 * @author Christian Klaussner
 */
	public class System {
		private String name;
		private String className;

		/**
		 * Constructs a new System object.
		 * @param name the name of the system
		 * @param className the name of the system class
		 */
		public System(String name, String className) {
			this.name = name;
			this.className = className;
		}

		/**
		 * Gets the name.
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Gets the name of the system class.
		 * @return the name of the system class
		 */
		public String getClassName() {
			return className;
		}
	}

	/**
	 * The Container class stores the data of a PCM resource container.
	 * @author Christian Klaussner
	 */
	public class Container {
		private final String id;
		private final String name;
		private final String cpuRate;
		private final String hddRate;

		/**
		 * Constructs a new Container object.
		 * @param id the PCM identifier of the container
		 * @param name the name of the container
		 * @param cpuRate the processing rate of the container's CPU
		 * @param hddRate the processing rate of the container's HDD
		 */
		public Container(String id, String name, String cpuRate, String hddRate) {
			this.id = id;
			this.name = name;
			this.cpuRate = cpuRate;
			this.hddRate = hddRate;
		}

		/**
		 * Gets the ID.
		 * @return the ID
		 */
		public String getId() {
			return id;
		}

		/**
		 * Gets the name.
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Gets the specification of the CPU rate.
		 * @return the specification of the CPU rate
		 */
		public String getCpuRate() {
			return cpuRate;
		}

		/**
		 * Gets the specification of the HDD rate.
		 * @return the specification of the HDD rate
		 */
		public String getHddRate() {
			return hddRate;
		}
	}

	/**
	 * The Allocation class stores the data of a PCM allocation.
	 * @author Christian Klaussner
	 */
	public class Allocation {
		private final String containerId;
		private final Class<?> componentClass;
		private final String assemblyContext;

		/**
		 * Constructs a new Allocation object.
		 * @param containerId the ID of the container
		 * @param componentClass the class of the component
		 * @param assemblyContext the assembly context
		 */
		public Allocation(String containerId, Class<?> componentClass, String assemblyContext) {
			this.containerId = containerId;
			this.componentClass = componentClass;
			this.assemblyContext = assemblyContext;
		}

		/**
		 * Gets the ID of the container.
		 * @return the ID of the container
		 */
		public String getContainerId() {
			return containerId;
		}

		/**
		 * Gets the class of the component.
		 * @return the class of the component
		 */
		public Class<?> getComponentClass() {
			return componentClass;
		}

		/**
		 * Gets the assembly context.
		 * @return the assembly context
		 */
		public String getAssemblyContext() {
			return assemblyContext;
		}
	}

	private Container[] containers;
	private IUsageScenario[] scenarios;
	private System system;
	private Allocation[] allocations;

	/**
	 * Sets the containers.
	 * @param containers the containers
	 */
	public void setContainers(Container[] containers) {
		this.containers = containers;
	}

	/**
	 * Gets the containers.
	 * @return an array with all containers
	 */
	public Container[] getContainers() {
		return containers;
	}

	/**
	 * Gets the container with the specified ID.
	 * @param containerId the ID of the container to retrieve
	 * @return the container with the specified ID
	 */
	public Container getContainer(String containerId) {
		for (Container container : containers) {
			if (container.getId().equals(containerId)) {
				return container;
			}
		}

		return null;
	}

	/**
	 * Sets the usage scenarios.
	 * @param scenarios the usage scenarios
	 */
	public void setUsageScenarios(IUsageScenario[] scenarios) {
		this.scenarios = scenarios;
	}

	/**
	 * Gets the usage scenarios.
	 * @return the usage scenarios
	 */
	public IUsageScenario[] getUsageScenarios() {
		return scenarios;
	}

	/**
	 * Sets the system.
	 * @param system the system
	 */
	public void setSystem(System system) {
		this.system = system;
	}

	/**
	 * Gets the system.
	 * @return the system
	 */
	public System getSystem() {
		return system;
	}

	/**
	 * Sets the allocations.
	 * @param allocations the allocations
	 */
	public void setAllocations(Allocation[] allocations) {
		this.allocations = allocations;
	}

	/**
	 * Gets the allocations.
	 * @return the allocations
	 */
	public Allocation[] getAllocations() {
		return allocations;
	}

	/**
	 * Gets the allocations for the specified container.
	 * @param containerId the container whose allocations will be retrieved
	 * @return the allocations for the specified container
	 */
	public Allocation[] getAllocations(String containerId) {
		List<Allocation> list = new LinkedList<Allocation>();

		for (Allocation allocation : allocations) {
			if (allocation.getContainerId().equals(containerId)) {
				list.add(allocation);
			}
		}

		return list.toArray(new Allocation[0]);
	}
}
