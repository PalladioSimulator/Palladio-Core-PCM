package de.uka.ipd.sdq.simucomframework;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
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

    public static final String SHOULD_THROW_EXCEPTION = "shouldThrowException";

    // Default values
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

    private boolean simulateFailures = false;
    private boolean simulateLinkingResources = false;
    private boolean useConfidence = false;
    private int confidenceLevel = 0;
    private int confidenceHalfWidth = 0;
    private URI confidenceModelElementURI;
    private String confidenceModelElementName;
    /* next three are batch algorithm settings */
    private boolean automaticBatches;
    private int batchSize;
    private int minNumberOfBatches;
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
    public SimuComConfig(final Map<String,Object> configuration, final boolean debug){
        super(configuration, debug);
        simuComConfigExtensions = new HashMap<String, SimuComConfigExtension>();
        try {
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

        } catch (final Exception e) {
            throw new RuntimeException("Setting up properties failed, please check launch config (check all tabs).", e);
        }
    }

    public void addSimuComConfigExtension(final String id, final SimuComConfigExtension simuComConfigExtension) {
        simuComConfigExtensions.put(id, simuComConfigExtension);
    }

    public SimuComConfigExtension getSimuComConfigExtension(final String id) {
        return simuComConfigExtensions.get(id);
    }

    public boolean getSimulateFailures() {
        return simulateFailures;
    }

    public boolean getSimulateLinkingResources() {
        return simulateLinkingResources;
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

    /**Returns a copy of the instance with a replaced descriptor.
     * @param descriptor Descriptor of the new instance.
     * @return Copy of the instance.
     */
    public SimuComConfig copy(final ExperimentRunDescriptor descriptor) {
        final SimuComConfig result = getClone();

        result.descriptor = descriptor;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        final SimuComConfig config = (SimuComConfig) super.clone();
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

        return config;
    }

    /**
     * @return Returns a clone of this instance.
     */
    public SimuComConfig getClone() {
        SimuComConfig config = null;
        try {
            config = (SimuComConfig) clone();
        } catch (final CloneNotSupportedException e) {
            if(logger.isEnabledFor(Level.FATAL)) {
                logger.fatal("Could not clone configuration.", e);
            }
        }
        return config;
    }

    public void setAutomaticBatches(final boolean automaticBatches) {
        this.automaticBatches = automaticBatches;
    }

    public boolean isAutomaticBatches() {
        return this.automaticBatches;
    }

    public void getBatchSize(final int batchSize) {
        this.batchSize = batchSize;
    }

    public int getBatchSize() {
        return this.batchSize;
    }

    public void setMinNumberOfBatches(final int minNumberOfBatches) {
        this.minNumberOfBatches = minNumberOfBatches;
    }

    public int getMinNumberOfBatches() {
        return this.minNumberOfBatches;
    }

    public IRandomGenerator getRandomGenerator() {
        if (randomNumberGenerator == null) {
            randomNumberGenerator = new SimuComDefaultRandomNumberGenerator(this.randomSeed);
        }
        return randomNumberGenerator;
    }


}
