package org.palladiosimulator.protocom.resourcestrategies.activeresource;

import java.util.Properties;

public interface IDemandStrategy {

    /**
     * Initialize the strategy and perform necessary calibrations
     *
     * @param degreeOfAccuracy
     *            The degree of accuracy used for calibration: HIGH, MEDIUM, LOW WARNING: The use of
     *            HIGH can result in a significant increase in the execution time
     * @param processingRate
     *            [units/seconds] The rate to initialize with (demand/processingRate = time)
     */
    void initializeStrategy(DegreeOfAccuracyEnum degreeOfAccuracy, double processingRate);

    /**
     * Initialize the strategy and perform necessary calibrations
     *
     * @param degreeOfAccuracy
     *            The degree of accuracy used for calibration: HIGH, MEDIUM, LOW WARNING: The use of
     *            HIGH can result in a significant increase in the execution time
     * @param processingRate
     *            [units/seconds] The rate to initialize with (demand/processingRate = time)
     * @param calibrationPath
     *            Path where the calibration is stored
     */
    void initializeStrategy(DegreeOfAccuracyEnum degreeOfAccuracy, double processingRate, String calibrationPath);

    /**
     * Consume a resource according to its demand & processing rate(specified in initaliseStrategy)
     * WARNING: initializeStrategy() has to be run first
     *
     * @param demand
     *            [units] The demand to consume
     */
    void consume(double demand);

    /**
     * Do not use default properties, but set properties externally.
     *
     * @param properties
     */
    void setProperties(Properties properties);

    /**
     * Get the resource this strategy is able to simulate
     *
     * @return The resource type we can simulate
     */
    ResourceTypeEnum getStrategysResource();

    /**
     * Gets the name of the strategy.
     * @return a string containing the name of the strategy
     */
    String getName();

    // New methods
    
    /**
     * Sets the calibration listener that receives progress updates during the calibration.
     * @param listener the calibration listener to receive the updates
     */
    void setCalibrationListener(ICalibrationListener listener);
    
    /**
     * Sets the calibration table.
     * @param table the calibration table
     */
    void setCalibrationTable(CalibrationTable table);
    
    /**
     * Checks whether the strategy has a calibration table.
     * @return true if the strategy has a calibration table, otherwise false
     */
    boolean hasCalibrationTable();
    
    /**
     * Calibrates the strategy and sets the internal calibration table.
     * @return a calibration table containing the results of the calibration
     */
    CalibrationTable calibrate();
    
    /**
     * Enables or disables debug mode. When debug mode is enabled, the calibration returns
     * dummy results instead of actually calibrating the strategy.
     * 
     * @param enable true if debug mode should be enabled, otherwise false
     */
    void setDebug(boolean enable);
    
    /**
     * Checks whether debug mode is enabled.
     * @return true if debug mode is enabled, otherwise false
     */
    boolean debugEnabled();

    //
    
    /**
     * Do cleanup work.
     */
    void cleanup();
}
