package de.uka.ipd.sdq.simucomframework.model;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.concurrency.ConcurrentSampleBlackboard;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.simucomframework.DiscardInvalidMeasurementsBlackboardDecorator;
import de.uka.ipd.sdq.simucomframework.ResourceRegistry;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComGarbageCollector;
import de.uka.ipd.sdq.simucomframework.SimuComResult;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEngineFactory;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimulationControlDelegate;
import de.uka.ipd.sdq.simucomframework.calculator.CalculatorFactory;
import de.uka.ipd.sdq.simucomframework.calculator.SetupPipesAndFiltersStrategy;
import de.uka.ipd.sdq.simucomframework.probes.SimuComProbeStrategyRegistry;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.simucomstatus.Action;
import de.uka.ipd.sdq.simucomframework.simucomstatus.Process;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.PCMStoExEvaluationVisitor;

/**
 * Central simulation class needed by desmoj. Keeps the simulation state
 * which is not part of the context of threads
 * @author Steffen Becker
 *
 */
public class SimuComModel {

	protected static Logger logger = 
		Logger.getLogger(SimuComModel.class.getName());
	
	protected ResourceRegistry resourceRegistry = null;
	private IWorkloadDriver[] workloadDrivers;
	private SimuComResult status = SimuComResult.OK;
	private Throwable errorMessage = null;
	private SimuComConfig config;
	private long mainMeasurementsCount;
	private ISimEngineFactory simulationEngineFactory;
	private ISimulationControlDelegate simControl;
	private SimuComStatus simulationStatus = null;
	
	public SimuComModel(SimuComConfig config, SimuComStatus status, ISimEngineFactory factory, boolean isRemoteRun) {
		this.config = config;
		this.simulationEngineFactory = factory;
		this.simControl = factory.createSimulationControl(this);
		resourceRegistry = new ResourceRegistry(this);
		this.simulationStatus = status;
		
		// initialise Random Generators
		StoExCache.initialiseStoExCache(config.getRandomGenerator());
		// the function lib caches random generators.
		PCMStoExEvaluationVisitor.deleteFunctionLib();
		ProbabilityFunctionFactoryImpl.getInstance().setRandomGenerator(config.getRandomGenerator());
		
		// initialise ProbeSpecification context
		ProbeSpecContext.clean();
		ProbeSpecContext context = ProbeSpecContext.instance();
		ISampleBlackboard sampleBlackboard = new DiscardInvalidMeasurementsBlackboardDecorator(
				new ConcurrentSampleBlackboard(), simControl);
		context.configure(
				sampleBlackboard,
				new SimuComGarbageCollector(sampleBlackboard),
				new SimuComProbeStrategyRegistry(),
				new CalculatorFactory(sampleBlackboard, this,
						new SetupPipesAndFiltersStrategy(this)));
	}

	private void initialiseSimStatus() {
		if (this.config.getVerboseLogging()) {
			EContentAdapter contentAdapter = new EContentAdapter() {

				/* (non-Javadoc)
				 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
				 */
				@Override
				public void notifyChanged(Notification notification) {
					super.notifyChanged(notification);
					if (notification.getEventType() == Notification.SET) {
						if (notification.getFeature() == SimucomstatusPackage.eINSTANCE.getProcess_CurrentAction()) {
							Process p = (Process) notification.getNotifier();
							Action a = (Action) notification.getNewValue();
							logger.debug("Process "+p.getId()+" changed currentAction to "+a.getClass().getName());
						}
					} else 
						logger.debug("Simulation Status Updated");
				}
				
			};
			simulationStatus.eAdapters().add(contentAdapter);
		}
		
	}

	public void doInitialSchedules() {
		for (IWorkloadDriver w : workloadDrivers)
		{
			w.run();
		}
	}

	/**
	 * Add the given usage scenarios to this simulation run
	 * @param workload Usage scenarios to execute during this
	 * simulation run
	 */
	public void setUsageScenarios(IWorkloadDriver[] workload)
	{
		this.workloadDrivers = workload;
	}

	/**
	 * @return The resource registry storing all simulated resources and
	 * their states
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
	public void initialiseResourceContainer(IResourceContainerFactory resourceContainerFactory) {
		for (String id : resourceContainerFactory.getResourceContainerIDList()) {
			SimulatedResourceContainer rc = (SimulatedResourceContainer) resourceRegistry.createResourceContainer(id);
			resourceContainerFactory.fillResourceContainer(rc);
		}
		for (String id : resourceContainerFactory.getLinkingResourceContainerIDList()) {
			SimulatedLinkingResourceContainer rc = (SimulatedLinkingResourceContainer) resourceRegistry.createLinkingResourceContainer(id);
			resourceContainerFactory.fillLinkingResourceContainer(rc);
		}
		resourceRegistry.activateAllActiveResources();
	}

	/**
	 * Set the simulation result
	 * @param error The new status
	 * @param t The exception message if any, null otherwise
	 */
	public void setStatus(SimuComResult error, Throwable t) {
		this.status = error;
		this.errorMessage = t;
	}
	
	/**
	 * @return The simulation status
	 */
	public SimuComResult getErrorStatus(){
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
	 */
	public SimuComConfig getConfig() {
		return config;
	}

	public void increaseMainMeasurementsCount(){
		mainMeasurementsCount++;
	}
	
	public long getMainMeasurementsCount() {
		return mainMeasurementsCount;
	}
	
	public ISimulationControlDelegate getSimulationControl() {
		return simControl;
	}

	public void setSimulationControl(ISimulationControlDelegate control) {
		this.simControl = control;
	}

	public void setSimulationEngineFactory(
			ISimEngineFactory factory) {
		this.simulationEngineFactory = factory;
	}

	public ISimEngineFactory getSimEngineFactory() {
		return this.simulationEngineFactory;
	}

	public SimuComStatus getSimulationStatus() {
		return simulationStatus;
	}

}
