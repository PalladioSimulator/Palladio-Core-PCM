package de.uka.ipd.sdq.measurements.driver.common;


public class DriverLogger {

	public static boolean DEBUG = false;
	public static boolean LOGGING = true;
	
	public static void logError(String logMessage) {
		if (LOGGING) {
			System.err.println(logMessage);
		}
	}

	public static void log(String logMessage) {
		if (LOGGING) {
			System.out.println(logMessage);
		}
	}
	
	public static void logDebug(String debugMessage) {
		if (DEBUG) {
			System.out.println(debugMessage);
		}
	}

	public static void logDebugError(String debugMessage) {
		if (DEBUG) {
			System.err.println(debugMessage);
		}
	}
	
	

}
