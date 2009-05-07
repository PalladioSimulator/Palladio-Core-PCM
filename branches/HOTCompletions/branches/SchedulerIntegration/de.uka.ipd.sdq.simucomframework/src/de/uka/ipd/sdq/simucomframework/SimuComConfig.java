package de.uka.ipd.sdq.simucomframework;

import java.io.Serializable;
import java.util.Map;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;

/**
 * @author roman
 * 
 * The class encapsulates all configuration options for SimuCom.
 */
public class SimuComConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3364130550065874984L;
	
	public static final String DATASOURCE_ID = "datasourceID";
	public static final String SHOULD_THROW_EXCEPTION = "shouldThrowException";
	public static final String MAXIMUM_MEASUREMENT_COUNT = "maximumMeasurementCount";
	public static final String USE_FIXED_SEED = "useFixedSeed";
	public static final String FIXED_SEED_PREFIX = "fixedSeed";
	
	/** SimuCom configuration tab */
	public static String EXPERIMENT_RUN = "experimentRun";
	public static String SIMULATION_TIME = "simTime";
	public static String VERBOSE_LOGGING = "verboseLogging";
	
	/** configuration options */
	private String nameExperimentRun;
	private long simuTime;
	private boolean verboseLogging;
	private long datasourceID;
	private Integer runNumber;
	private Long maxMeasurementsCount;
	private boolean isDebug;
	private long[] randomSeed = null;
	private IRandomGenerator randomNumberGenerator = null;

	/**
	 * @param a map which maps configuation option IDs to their values
	 */
	public SimuComConfig(Map<String,Object> configuration, int runNo, boolean debug){
		try {
			this.nameExperimentRun = (String) configuration.get(
					EXPERIMENT_RUN);
			this.simuTime = Long.valueOf((String)configuration.get(
					SIMULATION_TIME));
			this.maxMeasurementsCount = Long.valueOf((String)configuration.get(
					MAXIMUM_MEASUREMENT_COUNT));
			this.verboseLogging = (Boolean)configuration.get(
					VERBOSE_LOGGING);
			this.datasourceID = (Integer)configuration.get(
					DATASOURCE_ID);
			this.runNumber = runNo;
			this.isDebug = debug;
			this.randomSeed = getSeedFromConfig(configuration);
		} catch (Exception e) {
			throw new RuntimeException("Setting up properties failed, please check launch config", e);
		}
	}

	private long[] getSeedFromConfig(Map<String,Object> configuration) {
		if ((Boolean)configuration.get(USE_FIXED_SEED)) {
			long[] seed = new long[6];
			for (int i = 0; i < 6; i++) {
				seed[i] = Long.parseLong((String)configuration.get(FIXED_SEED_PREFIX+i));
			}
			return seed;
		}
		return null;
	}
	
	public String getNameExperimentRun() {
		return nameExperimentRun + " RunNo. "+runNumber;
	}

	public long getSimuTime() {
		return simuTime;
	}

	public long getMaxMeasurementsCount() {
		return maxMeasurementsCount;
	}
	
	public boolean getVerboseLogging() {
		return verboseLogging;
	}

	public long getDatasourceID() {
		return this.datasourceID;
	}

	public boolean isDebug() {
		return this.isDebug;
	}
	
	public String getEngine() {
		return "de.uka.ipd.sdq.simucomframework.ssj.SSJSimEngineFactory";
	}
	
	public IRandomGenerator getRandomGenerator() {
		if (randomNumberGenerator == null) {
			randomNumberGenerator = new SimuComDefaultRandomNumberGenerator(randomSeed);
		}
		return randomNumberGenerator;
	}

}
