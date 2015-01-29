package org.palladiosimulator.protocom.framework.java.ee.experiment;

/**
 * Classes implementing the IExperiment interface provide methods for conducting experiments.
 * @author Christian Klaussner
 */
public interface IExperiment {
	/**
	 * Initializes the experiment.
	 * @param name the name of the experiment
	 */
	void init(String name);
	
	/**
	 * Resets the experiment.
	 */
	void reset();
	
	/**
	 * Gets the ID.
	 * @return the ID
	 */
	String getId();
	
	/**
	 * Starts an experiment run.
	 */
	void startRun();
	
	/**
	 * Stops an experiment run.
	 */
	void stopRun();
	
	/**
	 * Adds measurement data (time interval) for the sensor with the specified name.
	 * @param name the name of the sensor
	 * @param startTime the start time
	 * @param endTime the end time
	 */
	void takeMeasurement(String name, long startTime, long endTime);
}
