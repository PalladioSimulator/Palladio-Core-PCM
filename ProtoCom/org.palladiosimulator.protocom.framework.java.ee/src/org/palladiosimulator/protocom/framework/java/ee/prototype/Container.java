package org.palladiosimulator.protocom.framework.java.ee.prototype;

/**
 *
 * @author Christian Klaussner
 */
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
