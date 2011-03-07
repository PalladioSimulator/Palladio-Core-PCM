package de.uka.ipd.sdq.simulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.concurrency.ConcurrentSampleBlackboard;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.PCMStoExEvaluationVisitor;
import de.uka.ipd.sdq.simulation.PCMModel.PCMPartialModel;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;
import de.uka.ipd.sdq.simulation.command.BuildAndRegisterPassiveResources;
import de.uka.ipd.sdq.simulation.command.BuildComponentInstances;
import de.uka.ipd.sdq.simulation.command.ICommand;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.PCMModelCommandExecutor;
import de.uka.ipd.sdq.simulation.command.allocation.BuildResourceAllocation;
import de.uka.ipd.sdq.simulation.command.parameter.InstallExternalCallParameterHandling;
import de.uka.ipd.sdq.simulation.command.parameter.InstallSystemCallParameterHandling;
import de.uka.ipd.sdq.simulation.command.probespec.BuildProbeSpecCalculators;
import de.uka.ipd.sdq.simulation.command.probespec.MountExternalCallProbes;
import de.uka.ipd.sdq.simulation.command.probespec.MountResourceProbes;
import de.uka.ipd.sdq.simulation.command.probespec.MountSystemCallProbes;
import de.uka.ipd.sdq.simulation.command.probespec.MountUsageScenarioProbes;
import de.uka.ipd.sdq.simulation.command.resourceenvironment.BuildSimulatedResourceEnvironment;
import de.uka.ipd.sdq.simulation.command.usage.BuildWorkloadDriver;
import de.uka.ipd.sdq.simulation.debug.DebugSeffTraversalListener;
import de.uka.ipd.sdq.simulation.debug.DebugUsageTraversalListener;
import de.uka.ipd.sdq.simulation.entities.EventSimEntity;
import de.uka.ipd.sdq.simulation.probespec.CalculatorFactory;
import de.uka.ipd.sdq.simulation.probespec.EventSimGarbageCollector;
import de.uka.ipd.sdq.simulation.probespec.EventSimProbeStrategyRegistry;
import de.uka.ipd.sdq.simulation.probespec.SetupPipesAndFiltersStrategy;
import de.uka.ipd.sdq.simulation.resources.PassiveResourceRegistry;
import de.uka.ipd.sdq.simulation.resources.ResourceAllocation;
import de.uka.ipd.sdq.simulation.resources.SimulatedResourceEnvironment;
import de.uka.ipd.sdq.simulation.traversal.rdseff.SeffTraversal;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviorTraversal;
import de.uka.ipd.sdq.simulation.workload.IWorkloadDriver;

public class EventSimModel implements ISimulationModel<EventSimModel> {

    private static final Logger logger = Logger.getLogger(EventSimModel.class);

    private final BundleContext bundleContext;
    private final EventSimConfig config;
    private PCMModel pcmModel;
    private final ICommandExecutor<PCMModel> executor;
    private SimulatedResourceEnvironment resourceEnvironment;
    private ResourceAllocation resourceAllocation;
    private ISimEngineFactory<EventSimModel> factory;
    private ISimulationControl<EventSimModel> simControl;
    private PassiveResourceRegistry passiveResourceRegistry;
    private Map<String, SimulatedComponentInstance> componentRegistry;

    public EventSimModel(final EventSimConfig config, final ISimEngineFactory<EventSimModel> factory,
            final BundleContext context) {
        this.config = config;
        this.bundleContext = context;
        this.factory = factory;
        this.executor = new PCMModelCommandExecutor(this.getPCMModel());
        // this.executor = new CachingPCMModelCommandExecutor(getPCMModel());
        this.passiveResourceRegistry = new PassiveResourceRegistry();
    }

    @Override
    public void doInitialSchedules() {
        final List<IWorkloadDriver> workloadDrivers = this.execute(new BuildWorkloadDriver(this));
        for (final IWorkloadDriver d : workloadDrivers) {
            d.start();
        }
    }

    @Override
    public void init() {
        // initialise random Generators
        StoExCache.initialiseStoExCache(this.config.getRandomGenerator());
        PCMStoExEvaluationVisitor.deleteFunctionLib();

        // initialise components (TODO)
        componentRegistry = this.execute(new BuildComponentInstances());

        // initialise resource environment and allocation
        this.resourceEnvironment = this.execute(new BuildSimulatedResourceEnvironment(
                GlobalConstants.PATHMAP_TO_SCHEDULER_LIBRARY));
        this.resourceAllocation = this.execute(new BuildResourceAllocation(this.resourceEnvironment));

        // initialse passive resources
        this.executor.execute(new BuildAndRegisterPassiveResources(this));

        // initialise ProbeSpecification context
        final ProbeSpecContext context = ProbeSpecContext.instance();
        context.clean();
        final ISampleBlackboard sampleBlackboard = new ConcurrentSampleBlackboard();
        context.configure(sampleBlackboard, new EventSimGarbageCollector(sampleBlackboard),
                new EventSimProbeStrategyRegistry(), new CalculatorFactory(sampleBlackboard, this,
                        new SetupPipesAndFiltersStrategy(this)));

        // build calculators
        this.execute(new BuildProbeSpecCalculators());

        // mount probes
        this.execute(new MountUsageScenarioProbes());
        this.execute(new MountSystemCallProbes());
        this.execute(new MountExternalCallProbes());
        this.execute(new MountResourceProbes(this, this.resourceEnvironment));

        
        // setup parameter handling
        this.execute(new InstallSystemCallParameterHandling());
        this.execute(new InstallExternalCallParameterHandling());
        
        if (logger.isDebugEnabled()) {
            DebugUsageTraversalListener.install();
            DebugSeffTraversalListener.install();
        }
    }

    public PCMModel getPCMModel() {
        if (this.pcmModel == null) {
            final IPath usagePath = this.obtainPartialModelFileName(this.config.getUsageModelFile());
            final IPath allocationPath = this.obtainPartialModelFileName(this.config.getAllocationModelFile());

            final Map<PCMPartialModel, IPath> modelLocations = new HashMap<PCMPartialModel, IPath>();
            modelLocations.put(PCMPartialModel.USAGE, usagePath);
            modelLocations.put(PCMPartialModel.ALLOCATION, allocationPath);

            this.pcmModel = PCMModel.loadFromBundle(this.bundleContext.getBundle(), modelLocations);
        }
        return this.pcmModel;
    }

    public SimulatedResourceEnvironment getResourceEnvironment() {
        return this.resourceEnvironment;
    }

    public ResourceAllocation getResourceAllocation() {
        return this.resourceAllocation;
    }

    public ICommandExecutor<PCMModel> getPCMModelCommandExecutor() {
        return this.executor;
    }

    private IPath obtainPartialModelFileName(final String fileSystemPath) {
        final URI fileSystemUri = URI.createFileURI(fileSystemPath);
        final String fileName = fileSystemUri.segment(fileSystemUri.segmentCount() - 1);
        final IPath path = new Path("model/" + fileName);
        return path;
    }

    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public <T> T execute(final ICommand<T, PCMModel> command) {
        return this.executor.execute(command);
    }

    @Override
    public void finalise() {
        if (logger.isDebugEnabled()) {
            logger.debug("Cleaning up...");
        }
        UsageBehaviorTraversal.clearTraversalListeners();
        SeffTraversal.clearTraversalListeners();
        EventSimEntity.resetIdGenerator();
    }

    @Override
    public EventSimConfig getConfiguration() {
        return this.config;
    }

    @Override
    public ISimEngineFactory<EventSimModel> getSimEngineFactory() {
        return this.factory;
    }

    @Override
    public ISimulationControl<EventSimModel> getSimulationControl() {
        if (this.simControl == null) {
            this.simControl = this.factory.createSimulationControl();
        }
        return this.simControl;
    }

    @Override
    public void setSimulationControl(final ISimulationControl<EventSimModel> control) {
        this.simControl = control;
    }

    @Override
    public void setSimulationEngineFactory(final ISimEngineFactory<EventSimModel> factory) {
        this.factory = factory;
    }

    public PassiveResourceRegistry getPassiveResourceRegistry() {
        return passiveResourceRegistry;
    }

    public SimulatedComponentInstance getComponent(AssemblyContext assemblyContext) {
        return componentRegistry.get(assemblyContext.getId());
    }

}
