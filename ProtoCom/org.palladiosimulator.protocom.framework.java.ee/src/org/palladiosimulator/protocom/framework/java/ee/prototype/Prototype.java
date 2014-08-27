package org.palladiosimulator.protocom.framework.java.ee.prototype;

public final class Prototype {
	private static Prototype instance;

	private Prototype() {
	}

	public static Prototype getInstance() {
		if (instance == null) {
			instance = new Prototype();
		}

		return instance;
	}

	// Instance variables.

	private Container[] containers;
	private IUsageScenario[] scenarios;
	private System system;
	private Allocation[] allocations;

	// Instance methods.

	public void setContainers(Container[] containers) {
		this.containers = containers;
	}

	public Container[] getContainers() {
		return containers;
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

	public System getSystem() {
		return system;
	}

	public void setAllocations(Allocation[] allocations) {
		this.allocations = allocations;
	}

	public Allocation[] getAllocations() {
		return allocations;
	}
}
