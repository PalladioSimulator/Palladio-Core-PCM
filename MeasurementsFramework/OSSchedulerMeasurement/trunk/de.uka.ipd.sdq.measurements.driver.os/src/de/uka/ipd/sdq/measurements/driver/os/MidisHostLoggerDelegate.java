package de.uka.ipd.sdq.measurements.driver.os;

import de.uka.ipd.sdq.measurements.driver.common.LoggerDelegate;

public class MidisHostLoggerDelegate extends LoggerDelegate {

	@Override
	public void log(String logMessage) {
		OSDriver.log(logMessage);
	}

	@Override
	public void logDebug(String debugMessage) {
		OSDriver.logDebug(debugMessage);
	}

	@Override
	public void logDebugError(String debugMessage) {
		OSDriver.logDebugError(debugMessage);
	}

	@Override
	public void logError(String logMessage) {
		OSDriver.logError(logMessage);
	}

}
