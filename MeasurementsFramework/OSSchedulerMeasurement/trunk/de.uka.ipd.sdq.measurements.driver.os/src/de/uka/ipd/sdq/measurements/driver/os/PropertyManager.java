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
		super();
	}

	public int getDriverRmiPort() {
		return getIntProperty(OSDriverConstants.JavaPropertyOSDriverRmiPort,
				"OS Driver RMI port", OSDriverConstants.OSDriverDefaultRMIRegistryPort);
	}
	
	public String getCalibrationFilePath() {
		return getStringProperty(
				OSDriverConstants.JavaPropertyOSDriverCalibrationFilePath,
				"Calibration file path");
	}

	public String getHostRmiIp() {
		return getStringProperty(OSDriverConstants.JavaPropertyOSDriverRmiIP,
				"Host RMI IP");
	}
	
	public String getParentHostRmiIp() {
		return getStringProperty(OSDriverConstants.JavaPropertyOSDriverRmiParentHostIP,
				"Parent Host RMI IP");
	}
	
	public int getParentHostRmiPort() {
		return getIntProperty(OSDriverConstants.JavaPropertyOSDriverRmiParentHostPort,
				"Parent Host RMI Port", OSDriverConstants.OSDriverDefaultRMIRegistryPort);
	}

	public boolean getLoggingDebug() {
		return getBooleanProperty(
				OSDriverConstants.JavaPropertyOSDriverLoggingDebug,
				"Host debug logging");
	}

	public boolean getLogging() {
		return getBooleanProperty(
				OSDriverConstants.JavaPropertyOSDriverLogging, "Host logging");
	}

	@Override
	protected String getDefaultPropertyPath() {
		return "conf/osdriver.properties";
	}
}
