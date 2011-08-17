package de.uka.ipd.sdq.simulation;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.probespec.framework.BlackboardFactory;
import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.simucomframework.ISimulationListener;
import de.uka.ipd.sdq.simucomframework.ssj.SSJSimEngineFactory;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.PCMStoExEvaluationVisitor;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;
import de.uka.ipd.sdq.simulation.command.BuildComponentInstances;
import de.uka.ipd.sdq.simulation.command.ICommand;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.PCMModelCommandExecutor;
import de.uka.ipd.sdq.simulation.command.parameter.InstallExternalCallParameterHandling;
import de.uka.ipd.sdq.simulation.command.parameter.InstallSystemCallParameterHandling;
import de.uka.ipd.sdq.simulation.debug.DebugSeffTraversalListener;
import de.uka.ipd.sdq.simulation.debug.DebugUsageTraversalListener;
import de.uka.ipd.sdq.simulation.debug.EntityTraceRecorder;
import de.uka.ipd.sdq.simulation.entities.EventSimEntity;
import de.uka.ipd.sdq.simulation.entities.SimActiveResource;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.probespec.CalculatorFactory;
import de.uka.ipd.sdq.simulation.probespec.EventSimGarbageCollector;
import de.uka.ipd.sdq.simulation.probespec.EventSimProbeStrategyRegistry;
import de.uka.ipd.sdq.simulation.probespec.commands.BuildActiveResourceCalculators;
import de.uka.ipd.sdq.simulation.probespec.commands.BuildPassiveResourceCalculators;
import de.uka.ipd.sdq.simulation.probespec.commands.BuildResponseTimeCalculators;
import de.uka.ipd.sdq.simulation.probespec.commands.MountActiveResourceProbes;
import de.uka.ipd.sdq.simulation.probespec.commands.MountExternalCallProbes;
import de.uka.ipd.sdq.simulation.probespec.commands.MountPassiveResourceProbes;
import de.uka.ipd.sdq.simulation.probespec.commands.MountSystemCallProbes;
import de.uka.ipd.sdq.simulation.probespec.commands.MountUsageScenarioProbes;
import de.uka.ipd.sdq.simulation.staticstructure.AllocationRegistry;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;
import de.uka.ipd.sdq.simulation.staticstructure.PassiveResourceRegistry;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceEnvironment;
import de.uka.ipd.sdq.simulation.staticstructure.commands.BuildAndRegisterPassiveResources;
import de.uka.ipd.sdq.simulation.staticstructure.commands.BuildResourceAllocation;
import de.uka.ipd.sdq.simulation.staticstructure.commands.BuildSimulatedResourceEnvironment;
import de.uka.ipd.sdq.simulation.traversal.seff.SeffTraversal;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviorTraversal;
import de.uka.ipd.sdq.simulation.workload.BuildWorkloadGenerator;
import de.uka.ipd.sdq.simulation.workload.IWorkloadGenerator;

/**
 * The simulation model. This is the central class of an EventSim simulation run. Before the
 * simulation starts, it initialises the simulation in the {@code init()} method. During the
 * simulation, it provides information about the PCM model that is to be simulated, the simulation
 * configuration and the simulation status. Finally, it cleans up after a simulation run in the
 * {finalise()} method.
 * <p>
 * Instances are created by using the static {@code create} method that builds the simulation model
 * in accordance with a specified simulation configuration.
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimModel implements ISimulationModel<EventSimModel> {

    private static final Logger logger = Logger.getLogger(EventSimModel.class);

    private final BundleContext bundleContext;
    private final EventSimConfig config;
    private final ICommandExecutor<PCMModel> executor;
    private PCMModel pcmModel;
    private ISimEngineFactory<EventSimModel> factory;
    private ISimulationControl<EventSimModel> simControl;
    private long mainMeasurementsCount;

    private final PassiveResourceRegistry passiveResourceRegistry;
    private SimulatedResourceEnvironment resourceEnvironment;
    private AllocationRegistry resourceAllocation;
    private Map<String, ComponentInstance> componentRegistry;

    private EntityTraceRecorder traceRecorder;

    private EventSimModel(final EventSimConfig config, final ISimEngineFactory<EventSimModel> factory,
            final BundleContext context) {
        this.config = config;
        this.bundleContext = context;
        this.factory = factory;
        this.executor = new PCMModelCommandExecutor(this.getPCMModel());
        this.passiveResourceRegistry = new PassiveResourceRegistry();
    }

    /**
     * Creates the simulation model for the specified configuration.
     * 
     * @param config
     *            the simulation configuration
     * @param bundleContext
     * @return the created simulation model
     */
    public static EventSimModel create(final EventSimConfig config, final BundleContext bundleContext) {
        // create factory
        // TODO create factory depending on the simulation library that has been set (SSJ, DesmoJ)
        final ISimEngineFactory<EventSimModel> factory = new SSJSimEngineFactory<EventSimModel>();
        final EventSimModel model = new EventSimModel(config, factory, bundleContext);
        factory.setModel(model);

        return model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        // initialise random generators
        PCMStoExEvaluationVisitor.deleteFunctionLib();
        StoExCache.initialiseStoExCache(this.config.getRandomGenerator());
        ProbabilityFunctionFactoryImpl.getInstance().setRandomGenerator(this.config.getRandomGenerator());

        // initialise resource environment and allocation
        this.resourceEnvironment = this.execute(new BuildSimulatedResourceEnvironment(this));
        this.resourceAllocation = this.execute(new BuildResourceAllocation(this.resourceEnvironment));

        // initialise component instances
        this.componentRegistry = this.execute(new BuildComponentInstances(this, this.resourceAllocation));

        // initialise passive resources
        this.execute(new BuildAndRegisterPassiveResources(this, this.resourceAllocation));

        // setup handling for PCM parameter characterisations
        this.execute(new InstallSystemCallParameterHandling());
        this.execute(new InstallExternalCallParameterHandling());

        // initialise the Probe Specification
        this.initialiseProbeSpecification();

        // install debug traversal listeners, if debugging is enabled
        if (logger.isDebugEnabled()) {
            DebugUsageTraversalListener.install();
            DebugSeffTraversalListener.install();
            // SimSlowdown.install("_K_PPcEg4Ed2v5eXKEbOQ9g");
        }

        // this.traceRecorder = EntityTraceRecorder.install();

        // setup the stop conditions
        this.setupStopConditions();

        // notify registered listeners that the simulation is about to start...
        this.notifyStartListeners();

        // ...and start the simulation by generating the workload
        final List<IWorkloadGenerator> workloadGenerators = this.execute(new BuildWorkloadGenerator(this));
        for (final IWorkloadGenerator d : workloadGenerators) {
            d.processWorkload();
        }
    }

    private void setupStopConditions() {
        long MAX_MEASUREMENTS = getConfiguration().getMaxMeasurementsCount();
        long MAX_SIMULATION_TIME = getConfiguration().getSimuTime();

        if (MAX_MEASUREMENTS <= 0 && MAX_SIMULATION_TIME <= 0) {
            logger.debug("Deactivating maximum simulation time stop condition per user request");
            getSimulationControl().setMaxSimTime(0);
        } else {
            logger.debug("Enabling simulation stop condition at maximum simulation time of " + MAX_SIMULATION_TIME);
            if (MAX_SIMULATION_TIME > 0)
                getSimulationControl().setMaxSimTime(MAX_SIMULATION_TIME);
        }

        this.getSimulationControl().addStopCondition(new MaxMeasurementsStopCondition(this));

        // Add confidence stop condition if configured
        // if (model.getConfig().isUseConfidence()) {
        // double level = model.getConfig().getConfidenceLevel() / 100.0;
        // double halfWidth = model.getConfig().getConfidenceHalfWidth() / 100.0;
        // model.getSimulationControl().addStopCondition(
        // new ConfidenceStopCondition(model, new PhiMixingBatchAlgorithm(),
        // new SampleMeanEstimator(), level, halfWidth));
        // }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void finalise() {
        this.notifyStopListeners();

        // notify active resources about the simulation stop
        deactivateResources();

        // clean up
        if (logger.isDebugEnabled()) {
            logger.debug("Cleaning up...");
        }
        UsageBehaviorTraversal.clearTraversalListeners();
        SeffTraversal.clearTraversalListeners();
        EventSimEntity.resetIdGenerator();
        ProbeSpecContext.instance().finish();

        logger.info("Simulation took " + getSimulationControl().getCurrentSimulationTime() + " simulation seconds");

        // TODO
        // traceRecorder.print();
        // ((CountingPCMModelCommandExecutor)executor).printStatistics();
    }

    /**
     * Notifies all active resources that the simulation run has stopped.
     */
    private void deactivateResources() {
        for (SimulatedResourceContainer c : this.resourceEnvironment.getResourceContainers()) {
            for (SimActiveResource r : c.getResources()) {
                r.deactivateResource();
            }
        }
    }

    /**
     * Executes the specified command and returns the result.
     * 
     * @param <T>
     *            the return type
     * @param command
     *            the command that is to be executed
     * @return the command's result
     */
    public <T> T execute(final ICommand<T, PCMModel> command) {
        return this.executor.execute(command);
    }

    /**
     * Returns the resource environment comprising {@link SimulatedResourceContainer}.
     * 
     * @return the resource environment
     */
    public SimulatedResourceEnvironment getResourceEnvironment() {
        return this.resourceEnvironment;
    }

    /**
     * Returns the allocation of {@link AssemblyContext}s to {@link SimulatedResourceContainer}s.
     * 
     * @return a registry containing the resource allocations
     */
    public AllocationRegistry getResourceAllocation() {
        return this.resourceAllocation;
    }

    /**
     * Returns the component instance that is encapsulated by the specified assembly context.
     * 
     * @param assemblyContext
     *            the assembly context
     * @return the queried component instance
     */
    public ComponentInstance getComponent(final AssemblyContext assemblyContext) {
        return this.componentRegistry.get(assemblyContext.getId());
    }

    /**
     * Returns the registry for passive resources.
     * 
     * @return
     */
    public PassiveResourceRegistry getPassiveResourceRegistry() {
        return this.passiveResourceRegistry;
    }

    /**
     * Increases the number of measurements, which has been taken, by one.
     * <p>
     * Notice that one measurements refers to one {@link User} that has completely traversed the
     * simulated system.
     */
    public void increaseMainMeasurementsCount() {
        this.mainMeasurementsCount++;
    }

    /**
     * Returns the number of measurements, which has been taken.
     * <p>
     * Notice that one measurements refers to one {@link User} that has completely traversed the
     * simulated system.
     * 
     * @return the current number of measurements
     */
    public long getMainMeasurementsCount() {
        return this.mainMeasurementsCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ISimulationControl<EventSimModel> getSimulationControl() {
        if (this.simControl == null) {
            this.simControl = this.factory.createSimulationControl();
        }
        return this.simControl;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ISimEngineFactory<EventSimModel> getSimEngineFactory() {
        return this.factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSimulationControl(final ISimulationControl<EventSimModel> control) {
        this.simControl = control;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSimulationEngineFactory(final ISimEngineFactory<EventSimModel> factory) {
        this.factory = factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventSimConfig getConfiguration() {
        return this.config;
    }

    /**
     * Returns the execution context of this simulation run.
     * 
     * @return the bundle execution context
     */
    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    /**
     * Notfies all simulation observers that the simulation is about to start
     */
    private void notifyStartListeners() {
        for (final ISimulationListener l : this.config.getListeners()) {
            l.simulationStart();
        }
    }

    /**
     * Notfies all simulation observers that the simulation has stopped
     */
    private void notifyStopListeners() {
        for (final ISimulationListener l : this.config.getListeners()) {
            l.simulationStop();
        }
    }

    /**
     * Initialises the Probe Specification by building the {@link ProbeSpecContext}, setting up the
     * calculators and mounting the probes.
     */
    private void initialiseProbeSpecification() {
        // initialise context
        ProbeSpecContext.clean();
        final ProbeSpecContext context = ProbeSpecContext.instance();
        final ISampleBlackboard sampleBlackboard = BlackboardFactory.createBlackboard(this.config.getBlackboardType());
        context.configure(sampleBlackboard, new EventSimGarbageCollector(sampleBlackboard),
                new EventSimProbeStrategyRegistry(), new CalculatorFactory(sampleBlackboard, this));

        // build calculators
        this.execute(new BuildResponseTimeCalculators());
        this.execute(new BuildActiveResourceCalculators(this.resourceEnvironment));
        this.execute(new BuildPassiveResourceCalculators(this.passiveResourceRegistry));

        // mount probes
        this.execute(new MountUsageScenarioProbes());
        this.execute(new MountSystemCallProbes());
        this.execute(new MountExternalCallProbes());
        this.execute(new MountActiveResourceProbes(this, this.resourceEnvironment));
        this.execute(new MountPassiveResourceProbes(this, this.passiveResourceRegistry));
    }

    /**
     * Returns the PCM model that is to be simulated. If it has not been loaded before, this methods
     * loads the PCM model from the bundle.
     * 
     * @return the PCM model
     */
    private PCMModel getPCMModel() {
        if (this.pcmModel == null) {
            final IPath usageModelLocation = this.createRelativePathToModelFile(this.config.getUsageModelFile());
            final IPath allocationModelLocation = this.createRelativePathToModelFile(this.config
                    .getAllocationModelFile());
            this.pcmModel = PCMModel.loadFromBundle(this.bundleContext.getBundle(), usageModelLocation,
                    allocationModelLocation);
        }
        return this.pcmModel;
    }

    /**
     * Takes an absolute path and converts it to a path that is relative to the bundle.
     * 
     * @param absolutePath
     *            the absolute path
     * @return the relative path
     */
    private IPath createRelativePathToModelFile(final String absolutePath) {
        final URI fileSystemUri = URI.createFileURI(absolutePath);
        final String fileName = fileSystemUri.segment(fileSystemUri.segmentCount() - 1);
        final IPath path = new Path("model/" + fileName);
        return path;
    }

}
