package de.uka.ipd.sdq.simucomframework.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.palladiosimulator.probeframework.ProbeFrameworkContext;
import org.palladiosimulator.probeframework.calculator.DefaultCalculatorFactory;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import de.uka.ipd.sdq.simucomframework.ResourceRegistry;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.calculator.RecorderAttachingCalculatorFactoryDecorator;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.simucomstatus.Action;
import de.uka.ipd.sdq.simucomframework.simucomstatus.Process;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simulation.ISimulationListener;
import de.uka.ipd.sdq.simulation.SimulationResult;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

/**
 * Central simulation class needed by desmoj. Keeps the simulation state which is not part of the
 * context of threads
 * 
 * @author Steffen Becker, Sebastian Lehrig
 * 
 */
public class SimuComModel extends SchedulerModel {

    protected static Logger logger = Logger.getLogger(SimuComModel.class);

    protected ResourceRegistry resourceRegistry;
    private IWorkloadDriver[] workloadDrivers;
    private SimulationResult status = SimulationResult.OK;
    private Throwable errorMessage;
    private final SimuComConfig config;
    private long mainMeasurementsCount;
    private ISimEngineFactory simulationEngineFactory;
    private ISimulationControl simControl;
    private final SimuComStatus simulationStatus;
    /** List of issues experience during a simulation run of this configuration. */
    private List<SeverityAndIssue> issues;
    private final ProbeFrameworkContext probeFrameworkContext;
    private final ISchedulingFactory schedulingFactory;
    private final FailureStatistics failureStatistics = new FailureStatistics();

    public SimuComModel(final SimuComConfig config, final SimuComStatus status, final ISimEngineFactory factory,
            final boolean isRemoteRun) {
        this(config,status,factory,isRemoteRun,null);
    }

    public SimuComModel(final SimuComConfig config, final SimuComStatus status, final ISimEngineFactory factory,
            final boolean isRemoteRun, final ProbeFrameworkContext probeFrameworkContext) {
        this.config = config;
        this.simulationEngineFactory = factory;
        factory.setModel(this);
        this.simControl = factory.createSimulationControl();
        resourceRegistry = new ResourceRegistry(this);
        this.simulationStatus = status;
        issues = new ArrayList<SeverityAndIssue>();

        // TODO: All following uses of static objects have severy issues. Nobody really thought of
        // e.g. running Simucom in parallel (e.g. to utilise many cores)!

        final IProbabilityFunctionFactory probFunctionFactory = ProbabilityFunctionFactoryImpl.getInstance();

        probFunctionFactory.setRandomGenerator(config.getRandomGenerator());

        // TODO: This is not thread and hence concurrency safe...
        // initialise Random Generators
        StoExCache.initialiseStoExCache(probFunctionFactory);

        // set up the resource scheduler
        schedulingFactory = new SchedulingFactory(this);

        // set up the measurement framework
        this.probeFrameworkContext = probeFrameworkContext == null ? initialiseProbeFramework() : probeFrameworkContext;

        // setup debug log for console
        initialiseSimStatus();
    }

    private ProbeFrameworkContext initialiseProbeFramework() {
        // create ProbeFramework context
        final ProbeFrameworkContext result = new ProbeFrameworkContext(
                new RecorderAttachingCalculatorFactoryDecorator(
                        new DefaultCalculatorFactory(), this.config));

        return result;
    }

    /**
     * @return Gets the list of issues.
     */
    public List<SeverityAndIssue> getIssues() {
        return issues;
    }

    /**Sets the list of issues.
     * @param issues the list of issues to use. May not be {@code null}.
     */
    public void setIssues(final List<SeverityAndIssue> issues) {
        if (issues == null) {
            throw new IllegalArgumentException("issues must not be null. Create and provide an empty list if the list should be reset.");
        }
        this.issues = issues;
    }

    /**Adds an issues to the list of issues.
     * @param issue the issue.
     */
    public void addIssue(final SeverityAndIssue issue) {
        this.issues.add(issue);
    }

    private void initialiseSimStatus() {
        if (this.config.getVerboseLogging()) {
            final EContentAdapter contentAdapter = new EContentAdapter() {

                /* (non-Javadoc)
                 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
                 */
                @Override
                public void notifyChanged(final Notification notification) {
                    super.notifyChanged(notification);
                    if (notification.getEventType() == Notification.SET) {
                        if (notification.getFeature() == SimucomstatusPackage.eINSTANCE.getProcess_CurrentAction()) {
                            final Process p = (Process) notification.getNotifier();
                            final Action a = (Action) notification.getNewValue();
                            if(logger.isDebugEnabled()) {
                                logger.debug("Process "+p.getId()+" changed currentAction to "+a.getClass().getName());
                            }
                        }
                    } else
                        if(logger.isDebugEnabled()) {
                            logger.debug("Simulation Status Updated");
                        }
                }

            };
            simulationStatus.eAdapters().add(contentAdapter);
        }

    }

    @Override
    public void init() {
        // start the workload
        notifyStartListeners();
        for (final IWorkloadDriver w : workloadDrivers) {
            w.run();
        }
    }

    /**
     * Add the given usage scenarios to this simulation run
     * 
     * @param workload
     *            Usage scenarios to execute during this simulation run
     */
    public void setUsageScenarios(final IWorkloadDriver[] workload) {
        this.workloadDrivers = workload;
    }

    /**
     * @return The resource registry storing all simulated resources and their states
     */
    public ResourceRegistry getResourceRegistry() {
        return resourceRegistry;
    }

    /**
     * Create this simulation run's resources using the resource factory given.
     * The factory is queried for the list of IDs of the resources to create and
     * creates and inialises each of them
     * @param resourceContainerFactory The resource factory used to initialse the simulated
     * resources
     */
    public void initialiseResourceContainer(final IResourceContainerFactory resourceContainerFactory) {
        for (final String id : resourceContainerFactory.getResourceContainerIDList()) {
            final SimulatedResourceContainer rc = (SimulatedResourceContainer) resourceRegistry.createResourceContainer(id);
            resourceContainerFactory.fillResourceContainerWithResources(rc);
        }
        for (final String id : resourceContainerFactory.getResourceContainerIDList()) {
            final SimulatedResourceContainer rc = (SimulatedResourceContainer) resourceRegistry.getResourceContainer(id);
            resourceContainerFactory.fillResourceContainerWithNestedResourceContainers(rc);
        }
        for (final String id : resourceContainerFactory.getLinkingResourceContainerIDList()) {
            final SimulatedLinkingResourceContainer rc = (SimulatedLinkingResourceContainer) resourceRegistry.createLinkingResourceContainer(id);
            resourceContainerFactory.fillLinkingResourceContainer(rc);
        }
        resourceRegistry.activateAllActiveResources();
    }

    /**
     * Set the simulation result
     * @param error The new status
     * @param t The exception message if any, null otherwise
     */
    public void setStatus(final SimulationResult error, final Throwable t) {
        this.status = error;
        this.errorMessage = t;
    }

    /**
     * @return The simulation status
     */
    public SimulationResult getErrorStatus(){
        return status;
    }

    /**
     * @return The exception caused during the last simulation run. Null
     * if there was no such exception
     */
    public Throwable getErrorThrowable(){
        return this.errorMessage;
    }

    /**
     * @return The configuration settings of this simulation model instance
     * @deprecated use {@link #getConfiguration()} instead
     */
    public SimuComConfig getConfig() {
        return config;
    }

    public void increaseMainMeasurementsCount() {
        mainMeasurementsCount++;
    }

    public long getMainMeasurementsCount() {
        return mainMeasurementsCount;
    }

    @Override
    public ISimulationControl getSimulationControl() {
        return simControl;
    }

    @Override
    public void setSimulationControl(final ISimulationControl control) {
        this.simControl = control;
    }

    @Override
    public void setSimulationEngineFactory(final ISimEngineFactory factory) {
        this.simulationEngineFactory = factory;
    }

    @Override
    public ISimEngineFactory getSimEngineFactory() {
        return this.simulationEngineFactory;
    }

    public SimuComStatus getSimulationStatus() {
        return simulationStatus;
    }

    public ProbeFrameworkContext getProbeFrameworkContext() {
        return probeFrameworkContext;
    }

    public ISchedulingFactory getSchedulingFactory() {
        return schedulingFactory;
    }

    @Override
    public void finalise() {
        notifyStopListeners();

        this.getResourceRegistry().deactivateAllActiveResources();
        this.getResourceRegistry().deactivateAllPassiveResources();

        if(logger.isEnabledFor(Level.INFO)) {
            logger.info("Simulation took " + getSimulationControl().getCurrentSimulationTime() + " simulated time units");
        }

        AbstractActiveResource.cleanProcesses();

        // Print failure statistics:
        if (getConfiguration().getSimulateFailures()) {
            getFailureStatistics().printFailureStatistics(logger, getSimulationControl().getCurrentSimulationTime());
        }
    }

    @Override
    public SimuComConfig getConfiguration() {
        return config;
    }

    private void notifyStartListeners() {
        for (final ISimulationListener l : config.getListeners()) {
            l.simulationStart();
        }
    }

    private void notifyStopListeners() {
        for (final ISimulationListener l : config.getListeners()) {
            l.simulationStop();
        }
    }

    public FailureStatistics getFailureStatistics() {
        return this.failureStatistics;
    }
}
