package de.uka.ipd.sdq.measurement.strategies.activeresource;

import java.util.Properties;

public interface IDemandStrategy {

	/**
	 * Initialize the strategy and perform necessary calibrations
	 * 
	 * @param degreeOfAccuracy
	 *            The degree of accuracy used for calibration: HIGH, MEDIUM, LOW
	 *            WARNING: The use of HIGH can result in a significant increase
	 *            in the execution time
	 * @param processingRate
	 *            [units/seconds] The rate to initialize with
	 *            (demand/processingRate = time)
	 */
	void initializeStrategy(DegreeOfAccuracyEnum degreeOfAccuracy,
			double processingRate);
	
	/**
	 * Initialize the strategy and perform necessary calibrations
	 * 
	 * @param degreeOfAccuracy
	 *            The degree of accuracy used for calibration: HIGH, MEDIUM, LOW
	 *            WARNING: The use of HIGH can result in a significant increase
	 *            in the execution time
	 * @param processingRate
	 *            [units/seconds] The rate to initialize with
	 *            (demand/processingRate = time)
	 * @param calibrationPath
	 * 			  Path where the calibration is stored
	 */
	void initializeStrategy(DegreeOfAccuracyEnum degreeOfAccuracy,
			double processingRate,
			String calibrationPath);

	/**
	 * Consume a resource according to its demand & processing rate(specified in
	 * initaliseStrategy) WARNING: initializeStrategy() has to be run first
	 * 
	 * @param demand
	 *            [units] The demand to consume
	 */
	void consume(double demand);
	
	/**
	 * Do not use default properties, but set properties externally.
	 * @param properties
	 */
	void setProperties(Properties properties);

	/**
	 * Get the resource this strategy is able to simulate
	 * 
	 * @return The resource type we can simulate
	 */
	ResourceTypeEnum getStrategysResource();

	String getName();
	
	/**
	 * Do cleanup work.
	 */
	void cleanup();
}
