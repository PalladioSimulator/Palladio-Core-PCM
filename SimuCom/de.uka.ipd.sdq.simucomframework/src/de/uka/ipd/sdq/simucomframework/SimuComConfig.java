package de.uka.ipd.sdq.simucomframework;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.IRecorderConfiguration;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.RecorderExtensionHelper;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ExperimentRunDescriptor;
/**
 * @author roman
 *
 * The class encapsulates all configuration options for SimuCom.
 */
public class SimuComConfig extends AbstractSimulationConfig implements Serializable, Cloneable {
	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(SimuComConfig.class);

	/** Serialization ID of this class. */
	private static final long serialVersionUID = -3364130550065874984L;

	public static final String PERSISTENCE_RECORDER_NAME = "persistenceFramework";
	public static final String SHOULD_THROW_EXCEPTION = "shouldThrowException";
	public static final String MAXIMUM_MEASUREMENT_COUNT = "maximumMeasurementCount";
	public static final String USE_FIXED_SEED = "useFixedSeed";
	public static final String FIXED_SEED_PREFIX = "fixedSeed";

	// Default values
	/** Default name for an experiment run. */
	public static final String DEFAULT_EXPERIMENT_RUN = "MyRun";
	/** Default for stop condition simulation time. */
	public static final String DEFAULT_SIMULATION_TIME = "150000";
	/** Default for stop condition maximum measurement count.*/
	public static final String DEFAULT_MAXIMUM_MEASUREMENT_COUNT = "10000";
	/** Default name of persistence recorder. */
	public static final String DEFAULT_PERSISTENCE_RECORDER_NAME = "";
	/** Default name of model element for the stop condition confidence. */
	public static final String DEFAULT_CONFIDENCE_MODELELEMENT_NAME = "";
	/** Stop condition confidence, URI to model element ? */
	public static final String DEFAULT_CONFIDENCE_MODELELEMENT_URI = "";
	/** Default selection if stop condition confidence is used. */
	public static final Boolean DEFAULT_USE_CONFIDENCE = false;
	/** Default value for confidence level of the stop condition confidence. */
	public static final Integer DEFAULT_CONFIDENCE_LEVEL = 95;
	/** Default value for the half width of the stop condition confidence.*/
	public static final Integer DEFAULT_CONFIDENCE_HALFWIDTH = 10;
	/** Default value for the automated batch calculation */
	public static final Boolean DEFAULT_CONFIDENCE_USE_AUTOMATIC_BATCHES = true;
	/** default batch size, arbitrarily chosen */
	public static final Integer DEFAULT_CONFIDENCE_BATCH_SIZE = 200;
	/** default minimum number of batches, arbitrarily chosen */
	public static final Integer DEFAULT_CONFIDENCE_MIN_NUMBER_OF_BATCHES = 60;

	

	/** SimuCom configuration tab */
	public static final String EXPERIMENT_RUN = "experimentRun";
	public static final String SIMULATION_TIME = "simTime";
	public static final String SIMULATE_FAILURES = "simulateFailures";
	public static final String SIMULATE_LINKING_RESOURCES = "simulateLinkingResources";
	public static final String USE_CONFIDENCE = "useConfidenceStopCondition";
	public static final String CONFIDENCE_LEVEL = "confidenceLevel";
	public static final String CONFIDENCE_HALFWIDTH = "confidenceHalfWidth";
	public static final String CONFIDENCE_MODELELEMENT_URI = "confidenceModelElementURI";
	public static final String CONFIDENCE_MODELELEMENT_NAME = "confidenceModelElementName";
	public static final String CONFIDENCE_USE_AUTOMATIC_BATCHES = "confidenceUseAutomaticBatches";
	public static final String CONFIDENCE_BATCH_SIZE = "confidenceBatchSize";
	public static final String CONFIDENCE_MIN_NUMBER_OF_BATCHES = "confidenceMinNumberOfBatches";

	/** configuration options */
	private String nameExperimentRun;
	private String additionalExperimentRunDescription;
	private long simuTime;
	private boolean simulateFailures = false;
	private boolean simulateLinkingResources = false;
	private Long maxMeasurementsCount;
	private long[] randomSeed = null;
	private IRandomGenerator randomNumberGenerator = null;
	private boolean useConfidence = false;
	private int confidenceLevel = 0;
	private int confidenceHalfWidth = 0;
	private URI confidenceModelElementURI;
	private String confidenceModelElementName;
	/* next three are batch algorithm settings */
	private boolean automaticBatches;
	private int batchSize;
	private int minNumberOfBatches;
	private String recorderName;
	private IRecorderConfiguration recorderConfig;
	private ExperimentRunDescriptor descriptor = null;
	
	// SimuCom extensions can also provide extension to the SimuCom configuration.
	// This map stores the extension configurations.
	private HashMap<String, SimuComConfigExtension> simuComConfigExtensions = null;

	


	/**
	 * @param configuration a map which maps configuration option IDs to their values.
	 * The required keys are SimuComConfig.EXPERIMENT_RUN, SimuComConfig.SIMULATION_TIME
	 * SimuComConfig.MAXIMUM_MEASUREMENT_COUNT SimuComConfig.VERBOSE_LOGGING,
	 * SimuComConfig.DATASOURCE_ID. Optional keys are SimuComConfig.SIMULATE_FAILURES,
	 * SimuComConfig.SIMULATE_LINKING_RESOURCES and SimuComConfig.USE_CONFIDENCE. If
	 * SimuComConfig.USE_CONFIDENCE is set to true, you also need to set
	 * SimuComConfig.CONFIDENCE_LEVEL, SimuComConfig.CONFIDENCE_HALFWIDTH,
	 * SimuComConfig.CONFIDENCE_MODELELEMENT_NAME, SimuComConfig.CONFIDENCE_MODELELEMENT_URI
	 *
	 */
	public SimuComConfig(Map<String,Object> configuration, boolean debug){
	    super(configuration, debug);
		simuComConfigExtensions = new HashMap<String, SimuComConfigExtension>();
		try {
			this.nameExperimentRun = (String) configuration.get(
					EXPERIMENT_RUN);
			this.simuTime = Long.valueOf((String)configuration.get(
					SIMULATION_TIME));
			this.maxMeasurementsCount = Long.valueOf((String)configuration.get(
					MAXIMUM_MEASUREMENT_COUNT));
			this.randomSeed = getSeedFromConfig(configuration);

			if (configuration.containsKey(SIMULATE_FAILURES)){
				this.simulateFailures = (Boolean)configuration.get(
						SIMULATE_FAILURES);
			}

			if (configuration.containsKey(SIMULATE_LINKING_RESOURCES)){
				this.simulateLinkingResources = (Boolean)configuration.get(
						SIMULATE_LINKING_RESOURCES);
			}

			// confidence information is optional in the map. It this.useConfidence defaults to false.
			if (configuration.containsKey(USE_CONFIDENCE)) {
				this.useConfidence = (Boolean) configuration
						.get(USE_CONFIDENCE);
				this.confidenceLevel = Integer.valueOf((String) configuration
						.get(CONFIDENCE_LEVEL));
				this.confidenceHalfWidth = Integer
						.valueOf((String) configuration
								.get(CONFIDENCE_HALFWIDTH));
				this.confidenceModelElementName = (String) configuration
						.get(CONFIDENCE_MODELELEMENT_NAME);
				this.confidenceModelElementURI = URI
						.createURI((String) configuration
								.get(CONFIDENCE_MODELELEMENT_URI));
				
				this.automaticBatches = (Boolean) configuration.get(CONFIDENCE_USE_AUTOMATIC_BATCHES);
				if (!this.automaticBatches){
					//only need batch settings if they are manually defined
					this.batchSize = Integer.valueOf((String) configuration
							.get(CONFIDENCE_BATCH_SIZE));
					this.minNumberOfBatches = Integer.valueOf((String) configuration
							.get(CONFIDENCE_MIN_NUMBER_OF_BATCHES));
					
				}

			}

			this.recorderName = (String) configuration
					.get(PERSISTENCE_RECORDER_NAME);
			recorderConfig = RecorderExtensionHelper
					.getRecorderConfigForName(recorderName);
			if (recorderConfig != null) {
				recorderConfig.setConfiguration(configuration);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Setting up properties failed, please check launch config (check all tabs).", e);
		}
	}
	
	public void addSimuComConfigExtension(String id, SimuComConfigExtension simuComConfigExtension) {
		simuComConfigExtensions.put(id, simuComConfigExtension);
	}
	
	public SimuComConfigExtension getSimuComConfigExtension(String id) {
		return simuComConfigExtensions.get(id);
	}

	public String getAdditionalExperimentRunDescription() {
		return additionalExperimentRunDescription;
	}

	public void setAdditionalExperimentRunDescription(
			String additionalExperimentRunDescription) {
		this.additionalExperimentRunDescription = additionalExperimentRunDescription;
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
		String name = "";
		if(descriptor != null) {
			name += descriptor.getNameExperimentRun();
		} else {
			name += getNameBase();
		}
		if (additionalExperimentRunDescription != null) {
			name += additionalExperimentRunDescription;
		}
		return name;
	}

	public String getNameBase() {
		return nameExperimentRun;
	}

	public void setNameBase(String  name) {
		this.nameExperimentRun = name;
	}

	public long getSimuTime() {
		return simuTime;
	}

	public long getMaxMeasurementsCount() {
		return maxMeasurementsCount;
	}

	public boolean getSimulateFailures() {
		return simulateFailures;
	}

	public boolean getSimulateLinkingResources() {
		return simulateLinkingResources;
	}

	public String getRecorderName() {
		return recorderName;
	}

	public boolean isUseConfidence() {
		return useConfidence;
	}

	public int getConfidenceLevel() {
		return confidenceLevel;
	}

	public int getConfidenceHalfWidth() {
		return confidenceHalfWidth;
	}

	public String getConfidenceModelElementName() {
		return confidenceModelElementName;
	}

	public URI getConfidenceModelElementURI() {
		return confidenceModelElementURI;
	}

	public String getEngine() {
		return "de.uka.ipd.sdq.simulation.abstractsimengine.ssj.SSJSimEngineFactory";
	}

	public IRandomGenerator getRandomGenerator() {
		if (randomNumberGenerator == null) {
			randomNumberGenerator = new SimuComDefaultRandomNumberGenerator(this.randomSeed);
		}
		return randomNumberGenerator;
	}

	/**
	 * Dispose random generator and delete reference to it
	 * so that this {@link SimuComConfig} can be started again and will create a
	 * new RandomGenerator.
	 * @author martens
	 */
	public void disposeRandomGenerator() {
		this.randomNumberGenerator.dispose();
		this.randomNumberGenerator = null;
	}

	public void setExperimentRunDescriptor(ExperimentRunDescriptor descriptor){
		this.descriptor  = descriptor;
	}

	public ExperimentRunDescriptor getExperimentRunDescriptor(){
		return descriptor;
	}

	public IRecorderConfiguration getRecorderConfig() {
		return recorderConfig;
	}

	/**Returns a copy of the instance with a replaced descriptor.
	 * @param descriptor Descriptor of the new instance.
	 * @return Copy of the instance.
	 */
	public SimuComConfig copy(ExperimentRunDescriptor descriptor) {
		SimuComConfig result = getClone();

		result.descriptor = descriptor;
		return result;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		SimuComConfig config = (SimuComConfig) super.clone();
		config.confidenceHalfWidth = this.confidenceHalfWidth;
		config.confidenceLevel = this.confidenceLevel;
		config.confidenceModelElementName = new String(this.confidenceModelElementName);
		config.maxMeasurementsCount = this.maxMeasurementsCount;
		config.nameExperimentRun = new String (this.nameExperimentRun);
		config.recorderName = new String(this.recorderName);
		config.simulateFailures = this.simulateFailures;
		config.simulateLinkingResources = this.simulateLinkingResources;
		config.simuTime = this.simuTime;
		config.useConfidence = this.useConfidence;

		// Warning: References are used in the following section instead of cloning the objects/arrays.
		config.confidenceModelElementURI = this.confidenceModelElementURI;
		config.descriptor = this.descriptor;
		config.randomNumberGenerator = this.randomNumberGenerator;
		config.randomSeed = this.randomSeed;
		config.recorderConfig = this.recorderConfig;

		return config;
	}

	/**
	 * @return Returns a clone of this instance.
	 */
	public SimuComConfig getClone() {
		SimuComConfig config = null;
		try {
			config = (SimuComConfig) clone();
		} catch (CloneNotSupportedException e) {
			logger.fatal("Could not clone configuration.", e);
		}
		return config;
	}
	
	public void setAutomaticBatches(boolean automaticBatches) {
		this.automaticBatches = automaticBatches;
	}

	public boolean isAutomaticBatches() {
		return this.automaticBatches;
	}

	public void getBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	
	public int getBatchSize() {
		return this.batchSize;
	}
	
	public void setMinNumberOfBatches(int minNumberOfBatches) {
		this.minNumberOfBatches = minNumberOfBatches;
	}

	public int getMinNumberOfBatches() {
		return this.minNumberOfBatches;
	}


}
