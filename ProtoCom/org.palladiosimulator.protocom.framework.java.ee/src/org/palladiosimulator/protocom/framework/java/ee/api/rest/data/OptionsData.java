package org.palladiosimulator.protocom.framework.java.ee.api.rest.data;

/**
*
* @author Christian Klaussner
*/
public class OptionsData {
	private String name;
	private String cpuStrategy, hddStrategy;
	private String accuracy;
	private String seed;

	private String[] calibrated;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpuStrategy() {
		return cpuStrategy;
	}

	public void setCpuStrategy(String cpuStrategy) {
		this.cpuStrategy = cpuStrategy;
	}

	public String getHddStrategy() {
		return hddStrategy;
	}

	public void setHddStrategy(String hddStrategy) {
		this.hddStrategy = hddStrategy;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getSeed() {
		return seed;
	}

	public void setSeed(String seed) {
		this.seed = seed;
	}

	public String[] getCalibrated() {
		return calibrated;
	}

	public void setCalibrated(String[] calibrated) {
		this.calibrated = calibrated;
	}
}
