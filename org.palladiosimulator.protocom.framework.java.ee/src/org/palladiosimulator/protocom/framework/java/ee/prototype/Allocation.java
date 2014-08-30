package org.palladiosimulator.protocom.framework.java.ee.prototype;

/**
 *
 * @author Christian Klaussner
 */
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
