package org.palladiosimulator.protocom.framework.java.ee.api.http.data;

/**
 * The OptionsData class is used to store the options selected by the user in an IStorage instance.
 * @author Christian Klaussner
 */
public class OptionsData {
	private String name;
	private String cpuStrategy, hddStrategy;
	private String accuracy;
	private String seed;

	private String[] calibrated;

	/**
	 * Gets the name of the experiment.
	 * @return the name of the experiment
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the experiment.
	 * @param name the name of the experiment
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the CPU strategy.
	 * @return the name of the CPU strategy (format: cpu.[name])
	 */
	public String getCpuStrategy() {
		return cpuStrategy;
	}

	/**
	 * Sets the CPU strategy.
	 * @param cpuStrategy the of the CPU strategy (format: cpu.[name]) 
	 */
	public void setCpuStrategy(String cpuStrategy) {
		this.cpuStrategy = cpuStrategy;
	}

	/**
	 * Gets the HDD strategy.
	 * @return the name of the HDD strategy (format: hdd.[name])
	 */
	public String getHddStrategy() {
		return hddStrategy;
	}

	/**
	 * Sets the HDD strategy.
	 * @param hddStrategy the name of the HDD strategy (format: cpu.[name])
	 */
	public void setHddStrategy(String hddStrategy) {
		this.hddStrategy = hddStrategy;
	}

	/**
	 * Gets the accuracy.
	 * @return the accuracy
	 */
	public String getAccuracy() {
		return accuracy;
	}

	/**
	 * Sets the accuracy.
	 * @param accuracy the accuracy
	 */
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * Gets the seed for the StoEx evaluator.
	 * @return the seed for the StoEx evaluator
	 */
	public String getSeed() {
		return seed;
	}

	/**
	 * Sets the seed for the StoEx evaluator.
	 * @param seed the seed for the StoEx evaluator
	 */
	public void setSeed(String seed) {
		this.seed = seed;
	}

	/**
	 * Gets all calibrated strategies (CPU and HDD).
	 * @return an array containing the names of all calibrated strategies
	 */
	public String[] getCalibrated() {
		return calibrated;
	}

	/**
	 * Sets all calibrated strategies (CPU and HDD).
	 * @param calibrated an array containing the names of all calibrated strategies
	 */
	public void setCalibrated(String[] calibrated) {
		this.calibrated = calibrated;
	}
}
