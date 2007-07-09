package de.uka.ipd.sdq.simucomframework;

import java.util.Map;

/**
 * @author roman
 * 
 * The class encases all configuration options for SimuCom.
 */
public class SimuComConfig {

	public static final String DATASOURCE_ID = "datasourceID";
	public static final String SHOULD_THROW_EXCEPTION = "shouldThrowException";
	/** SimuCom configuration tab */
	public static String EXPERIMENT_RUN = "experimentRun";
	public static String SIMULATION_TIME = "simTime";
	public static String VERBOSE_LOGGING = "verboseLogging";
	
	/** configuration options */
	private String nameExperimentRun;
	private long simuTime;
	private boolean verboseLogging;
	private long datasourceID;

	/**
	 * @param ILaunchConfiguration
	 */
	public SimuComConfig(Map configuration){
		try {
			this.nameExperimentRun = (String) configuration.get(
					EXPERIMENT_RUN);
			this.simuTime = Long.valueOf((String)configuration.get(
					SIMULATION_TIME));
			this.verboseLogging = (Boolean)configuration.get(
					VERBOSE_LOGGING);
			this.datasourceID = (Integer)configuration.get(
					DATASOURCE_ID);
		} catch (Exception e) {
			throw new RuntimeException("Setting up properties failed, please check launch config", e);
		}
	}

	public String getNameExperimentRun() {
		return nameExperimentRun;
	}

	public long getSimuTime() {
		return simuTime;
	}

	public boolean getVerboseLogging() {
		return verboseLogging;
	}

	public long getDatasourceID() {
		return this.datasourceID;
	}

}
