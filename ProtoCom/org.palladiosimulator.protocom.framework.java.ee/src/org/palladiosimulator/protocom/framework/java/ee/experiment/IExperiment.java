package org.palladiosimulator.protocom.framework.java.ee.experiment;

/**
 * 
 * @author Christian Klaussner
 */
public interface IExperiment {
	/**
	 * 
	 * @param name
	 */
	void init(String name);
	
	/**
	 * 
	 */
	void reset();
	
	/**
	 * 
	 * @return
	 */
	String getId();
	
	/**
	 * 
	 */
	void startRun();
	
	/**
	 * 
	 */
	void stopRun();
	
	/**
	 * 
	 * @param name
	 * @param startTime
	 * @param endTime
	 */
	void takeMeasurement(String name, long startTime, long endTime);
}
