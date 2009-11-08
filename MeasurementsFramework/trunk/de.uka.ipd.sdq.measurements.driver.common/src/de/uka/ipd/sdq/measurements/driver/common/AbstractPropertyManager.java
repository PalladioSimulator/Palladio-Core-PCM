package de.uka.ipd.sdq.measurements.driver.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;

public abstract class AbstractPropertyManager {

	private LoggerDelegate logger = null;

	private PropertyResourceBundle resourceBundle = null;

	protected AbstractPropertyManager(LoggerDelegate logger) {
		this.logger = logger;
	}

	protected abstract String getDefaultPropertyPath();

	public final boolean initializeProperties(File file) {
		if (file == null) {
			// Try to initialize default file
			return initializeDefaultProperties();
		} else if (!file.exists()) {
			logger.log("Specified property file " + file.getName() + " does not exist. Initializing default property file.");
			return initializeDefaultProperties();
		} else if (!file.canRead()) {
			logger.log("Can't access property file " + file.getName() + ". Initializing default property file.");
			return initializeDefaultProperties();
		}
		return loadProperties(file);
	}

	private boolean initializeDefaultProperties() {
		java.io.InputStream propertyFileInputStream = this.getClass().getClassLoader().getResourceAsStream(
				getDefaultPropertyPath());
		if (propertyFileInputStream == null) {
			logger.logError("Can't access default property file " + getDefaultPropertyPath() + ".");
			return false;
		}
		return loadDefaultProperties(propertyFileInputStream);
	}

	private boolean loadDefaultProperties(InputStream propertyFileInputStream) {
		try {
			resourceBundle = new PropertyResourceBundle(propertyFileInputStream);
		} catch (IOException e) {
			logger.logError("Error while reading default property file.");
			return false;
		}
		logger.log("Using default property file.");
		return true;
	}

	private boolean loadProperties(File propertyFile) {
		try {
			resourceBundle = new PropertyResourceBundle(new FileInputStream(
					propertyFile));
		} catch (IOException e) {
			logger.logError("Error while reading property file " + propertyFile.getName() + ".");
			return false;
		}
		logger.log("Using property file: " + propertyFile.getPath());
		return true;
	}

	protected int getIntProperty(String propertyKey, String propertyName, int defaultValue) {
		int propertyInt = 0;
		String propertyString = null;
		try {
			propertyInt = Integer.parseInt(System.getProperty(propertyKey));
			if (propertyInt != 0) {
				return propertyInt;
			}
		} catch (NumberFormatException e) {
		}
		try {
			propertyString = resourceBundle.getString(propertyKey);
		} catch (MissingResourceException e) {
			logger.logDebugError("Failed to retrieve " + propertyName + ".");
			logger.logError("Using default value for " + propertyName + ".");
			propertyInt = defaultValue;
			return propertyInt;
		}
		try {
			propertyInt = Integer.parseInt(propertyString);
		} catch (NumberFormatException e) {
			logger.logDebugError("Failed to retrieve " + propertyName + " from property entry " + propertyString + ".");
			logger.logError("Using default value for " + propertyName + ".");
			propertyInt = defaultValue;
		}
		return propertyInt;
	}

	protected String getStringProperty(String propertyKey, String propertyName) {
		String propertyString = null;
		try {
			propertyString = System.getProperty(propertyKey);
		} catch (SecurityException e) {
			logger.logDebugError("Failed to retrieve " + propertyName + ". May not access property. Please adapt security manager.");
		}
		if (propertyString != null) {
			return propertyString;
		}
		try {
			propertyString = resourceBundle.getString(propertyKey);
		} catch (MissingResourceException e) {
			logger.logDebugError("Failed to retrieve " + propertyName + ".");
		}
		return propertyString;
	}
	
	protected boolean getBooleanProperty(String propertyKey, String propertyName) {
		// look in system properties first (can be passed via command line)
		String propertyString = System.getProperty(propertyKey);
		if (propertyString != null) {
			if ((propertyString.toLowerCase().equals("false")) || propertyString.equals("0")) {
				return false;
			}
			if ((propertyString.toLowerCase().equals("true")) || propertyString.equals("1")) {
				return true;
			}
		}
		// if no system property found, look in own properties
		try {
			propertyString = resourceBundle.getString(propertyKey);
		} catch (MissingResourceException e) {
			logger.logDebugError("Failed to retrieve " + propertyName + ".");
		}
		if (propertyString != null) {
			if ((propertyString.toLowerCase().equals("false")) || propertyString.equals("0")) {
				return false;
			}
			if ((propertyString.toLowerCase().equals("true")) || propertyString.equals("1")) {
				return true;
			}
		}
		return false;
	}

}
