package org.palladiosimulator.protocom.framework.java.ee.prototype;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Singleton;

/**
 *
 * @author Christian Klaussner
 */
@Singleton
public final class PrototypeBridge {


	public class System {
		private String name;
		private String className;

		public System(String name, String className) {
			this.name = name;
			this.className = className;
		}

		public String getName() {
			return name;
		}

		public String getClassName() {
			return className;
		}
	}

	public class Container {
		private String id;
		private String name;
		private String cpuRate;
		private String hddRate;

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

		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getCpuRate() {
			return cpuRate;
		}

		public String getHddRate() {
			return hddRate;
		}
	}


	public class Allocation {
		private String containerId;
		private Class<?> componentClass;
		private String assemblyContext;

		/**
		 * Constructs a new Allocation object.
		 * @param containerId
		 * @param componentClass
		 * @param assemblyContext
		 */
		public Allocation(String containerId, Class<?> componentClass, String assemblyContext) {
			this.containerId = containerId;
			this.componentClass = componentClass;
			this.assemblyContext = assemblyContext;
		}

		public String getContainerId() {
			return containerId;
		}

		public Class<?> getComponentClass() {
			return componentClass;
		}

		public String getAssemblyContext() {
			return assemblyContext;
		}
	}


	private Container[] containers;
	private IUsageScenario[] scenarios;
	private System system;
	private Allocation[] allocations;

	public void setContainers(Container[] containers) {
		this.containers = containers;
	}

	public Container[] getContainers() {
		return containers;
	}

	public Container getContainer(String containerId) {
		for (Container container : containers) {
			if (container.getId().equals(containerId)) {
				return container;
			}
		}

		return null;
	}

	public void setUsageScenarios(IUsageScenario[] scenarios) {
		this.scenarios = scenarios;
	}

	public IUsageScenario[] getUsageScenarios() {
		return scenarios;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	/**
	 *
	 * @return
	 */
	public System getSystem() {
		return system;
	}

	/**
	 *
	 * @param allocations
	 */
	public void setAllocations(Allocation[] allocations) {
		this.allocations = allocations;
	}

	/**
	 *
	 * @return
	 */
	public Allocation[] getAllocations() {
		return allocations;
	}

	/**
	 * Gets the allocations for the specified container.
	 * @param containerId
	 * @return
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
