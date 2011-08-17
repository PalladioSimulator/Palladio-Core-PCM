package de.uka.ipd.sdq.simuservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.runtime.IPath;

public class ConfigurationHelper {

	/**
	 * A singleton pattern ensures the existence of only one configuration
	 * helper.
	 */
	private static ConfigurationHelper singletonInstance;

	/**
	 * Retrieves the singleton instance.
	 * 
	 * @return the singleton instance
	 */
	public static ConfigurationHelper getHelper() {
		if (singletonInstance == null) {
			singletonInstance = new ConfigurationHelper();
		}
		return singletonInstance;
	}

	/**
	 * The constructor is made private according to the singleton pattern.
	 */
	private ConfigurationHelper() {
	}

	/**
	 * Retrieves the port information for the SimuService.
	 * 
	 * @return the port information; NULL if the information could not be
	 *         retrieved
	 */
	public String getPort() {
		String result = null;
		try {
			result = readPortFromConfigFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Reads the port where to publish the SimuService from the plugin's config
	 * file.
	 * 
	 * The config file is placed in the workspace under
	 * ".metadata/.plugins/de.uka.ipd.sdq.simuservice/". If the port information
	 * cannot be retrieved, NULL is returned.
	 * 
	 * @return the port information
	 * @throws IOException
	 *             if the file cannot be found or read
	 */
	private String readPortFromConfigFile() throws IOException {
		String result = null;
		IPath location = Activator.getDefault().getStateLocation();
		File configFile = location.append("simuservice.config").toFile();
		FileReader reader = new FileReader(configFile);
		BufferedReader bufferedReader = new BufferedReader(reader);
		while (bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			if (line.trim().startsWith("PORT=")) {
				result = line.trim().substring(5).trim();
				break;
			}
		}
		bufferedReader.close();
		return result;
	}
}
