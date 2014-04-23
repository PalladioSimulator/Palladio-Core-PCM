package de.uka.ipd.sdq.simulation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.recorderspec.IRecorderConfigurationFactory;
import org.palladiosimulator.recorderspec.launch.RecorderExtensionHelper;

import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationConfig;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ExperimentRunDescriptor;

/**
 * This is the abstract base class for simulation configurations. It encapsulates the configuration
 * elements that are common to all PCM simulators.
 * 
 * @author roman
 * @author Philipp Merkle
 * 
 */
public abstract class AbstractSimulationConfig implements Serializable, ISimulationConfig {

    /** Serialization ID of this class. */
    private static final long serialVersionUID = 891323270372759718L;

    public static final String SIMULATOR_ID = "simulatorId";
    public static final String PERSISTENCE_RECORDER_NAME = "persistenceFramework";
    public static final String USE_FIXED_SEED = "useFixedSeed";
    public static final String FIXED_SEED_PREFIX = "fixedSeed";
    public static final String MAXIMUM_MEASUREMENT_COUNT = "maximumMeasurementCount";

    // Default values
    /** Default simulator implementation */
    public static final String DEFAULT_SIMULATOR_ID = "de.uka.ipd.sdq.codegen.simucontroller.simucom";
    /** Default name for an experiment run. */
    public static final String DEFAULT_EXPERIMENT_RUN = "MyRun";
    /** Default for stop condition simulation time. */
    public static final String DEFAULT_SIMULATION_TIME = "150000";
    /** Default for stop condition maximum measurement count. */
    public static final String DEFAULT_MAXIMUM_MEASUREMENT_COUNT = "10000";
    /** Default name of persistence recorder. */
    public static final String DEFAULT_PERSISTENCE_RECORDER_NAME = "";

    public static String VERBOSE_LOGGING = "verboseLogging";
    /** the type of the ProbeFramework blackboard */
    public static String BLACKBOARD_TYPE = "blackboardType";

    /** Simulation configuration tab */
    public static final String EXPERIMENT_RUN = "experimentRun";
    public static final String SIMULATION_TIME = "simTime";

    private boolean verboseLogging;
    private boolean isDebug;

    private final List<ISimulationListener> listeners;
    /** configuration options */
    protected String nameExperimentRun;
    private String additionalExperimentRunDescription;
    protected long simuTime;
    protected Long maxMeasurementsCount;
    protected long[] randomSeed = null;
    protected IRandomGenerator randomNumberGenerator = null;
    protected String recorderName;
    protected IRecorderConfigurationFactory recorderConfigurationFactory;
    protected ExperimentRunDescriptor descriptor = null;
    private String simulatorId;

    /**
     * @param configuration
     *            a map which maps configuration option IDs to their values. The required keys are
     *            <ul>
     *            <li>SimuComConfig.VERBOSE_LOGGING
     *            </ul>
     */
    public AbstractSimulationConfig(final Map<String, Object> configuration, final boolean debug) {
        try {
            this.verboseLogging = (Boolean) configuration.get(VERBOSE_LOGGING);
            this.isDebug = debug;

            this.simulatorId = (String) configuration.get(SIMULATOR_ID);
            this.nameExperimentRun = (String) configuration.get(EXPERIMENT_RUN);
            this.simuTime = Long.valueOf((String) configuration.get(SIMULATION_TIME));
            this.maxMeasurementsCount = Long.valueOf((String) configuration.get(MAXIMUM_MEASUREMENT_COUNT));
            this.randomSeed = getSeedFromConfig(configuration);

            this.recorderName = (String) configuration.get(PERSISTENCE_RECORDER_NAME);
            this.recorderConfigurationFactory = RecorderExtensionHelper.getRecorderConfigurationFactoryForName(this.recorderName);
            this.recorderConfigurationFactory.initialize(configuration);

            this.listeners = new ArrayList<ISimulationListener>();
        } catch (final Exception e) {
            throw new RuntimeException("Setting up properties failed, please check launch config (check all tabs).", e);
        }
    }

    /**
     * @return the recorderConfigurationFactory
     */
    public final IRecorderConfigurationFactory getRecorderConfigurationFactory() {
        return recorderConfigurationFactory;
    }

    public boolean getVerboseLogging() {
        return verboseLogging || isDebug;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public void addListener(final ISimulationListener l) {
        listeners.add(l);
    }

    public List<ISimulationListener> getListeners() {
        return listeners;
    }

    private String asString(final Map<String, Object> configuration, final String propertyName) {
        final String result = (String) configuration.get(propertyName);
        return result == null ? "" : result;
    }

    public String getAdditionalExperimentRunDescription() {
        return additionalExperimentRunDescription;
    }

    public void setAdditionalExperimentRunDescription(final String additionalExperimentRunDescription) {
        this.additionalExperimentRunDescription = additionalExperimentRunDescription;
    }

    protected long[] getSeedFromConfig(final Map<String, Object> configuration) {
        if ((Boolean) configuration.get(USE_FIXED_SEED)) {
            final long[] seed = new long[6];
            for (int i = 0; i < 6; i++) {
                seed[i] = Long.parseLong((String) configuration.get(FIXED_SEED_PREFIX + i));
            }
            return seed;
        }
        return null;
    }

    @Override
    public String getNameExperimentRun() {
        String name = "";
        if (descriptor != null) {
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

    public void setNameBase(final String name) {
        this.nameExperimentRun = name;
    }

    public long getSimuTime() {
        return simuTime;
    }

    public long getMaxMeasurementsCount() {
        return maxMeasurementsCount;
    }

    public String getRecorderName() {
        return recorderName;
    }

    public String getEngine() {
        return "de.uka.ipd.sdq.simulation.abstractsimengine.ssj.SSJSimEngineFactory";
    }

    /**
     * Dispose random generator and delete reference to it so that this {@link SimuComConfig} can be
     * started again and will create a new RandomGenerator.
     * 
     * @author martens
     */
    public void disposeRandomGenerator() {
        this.randomNumberGenerator.dispose();
        this.randomNumberGenerator = null;
    }

    public void setExperimentRunDescriptor(final ExperimentRunDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public ExperimentRunDescriptor getExperimentRunDescriptor() {
        return descriptor;
    }

    public String getSimulatorId() {
        return simulatorId;
    }

}
