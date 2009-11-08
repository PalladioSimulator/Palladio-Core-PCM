package de.uka.ipd.sdq.measurements.driver.common;

/**
 * This class provides a delegate to logging methods of Drivers.
 * 
 * @author hauck
 *
 */
public abstract class LoggerDelegate {
	
	public abstract void log(String logMessage);
	public abstract void logError(String logMessage);
	public abstract void logDebug(String debugMessage);
	public abstract void logDebugError(String debugMessage);

}
