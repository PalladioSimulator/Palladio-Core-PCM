package de.uka.ipd.sdq.measurements.driver.os;

import de.uka.ipd.sdq.measurements.driver.common.AbstractPropertyManager;


public class PropertyManager extends AbstractPropertyManager {

	private static PropertyManager instance = null;

	public static PropertyManager getInstance() {
		if (instance == null) {
			instance = new PropertyManager();
		}
		return instance;
	}

	private PropertyManager() {
		super(OSDriver.getLoggerDelegate());
	}

	public int getDriverRmiPort() {
		return getIntProperty(MidisHostConstants.JavaPropertyHostRmiPort,
				"OS Driver RMI port", Constants.OSDriverRMIRegistryPort);
	}
	
	public String getCalibrationFilePath() {
		return getStringProperty(
				MidisHostConstants.JavaPropertyCalibrationFilePath,
				"Calibration file path");
	}

	public String getHostRmiIp() {
		return getStringProperty(MidisHostConstants.JavaPropertyHostIP,
				"Host RMI IP");
	}

	public boolean getLoggingDebug() {
		return getBooleanProperty(
				MidisHostConstants.JavaPropertyHostLoggingDebug,
				"Host debug logging");
	}

	public boolean getLogging() {
		return getBooleanProperty(
				MidisHostConstants.JavaPropertyHostLogging, "Host logging");
	}

	@Override
	protected String getDefaultPropertyPath() {
		return "conf/host.properties";
	}
}
