package edu.kit.ipd.sdq.eventsim.system;

import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.probespec.framework.BlackboardFactory;
import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import de.uka.ipd.sdq.simulation.ISimulationListener;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.probespec.commands.BuildActiveResourceCalculators;
import edu.kit.ipd.sdq.eventsim.probespec.commands.BuildPassiveResourceCalculators;
import edu.kit.ipd.sdq.eventsim.probespec.commands.BuildResponseTimeCalculators;
import edu.kit.ipd.sdq.eventsim.probespec.commands.MountActiveResourceProbes;
import edu.kit.ipd.sdq.eventsim.probespec.commands.MountExternalCallProbes;
import edu.kit.ipd.sdq.eventsim.probespec.commands.MountPassiveResourceProbes;
import edu.kit.ipd.sdq.eventsim.probespec.commands.MountSystemCallProbes;
import edu.kit.ipd.sdq.eventsim.probespec.commands.MountUsageScenarioProbes;
import edu.kit.ipd.sdq.eventsim.system.command.BuildComponentInstances;
import edu.kit.ipd.sdq.eventsim.system.command.FindAssemblyContextForSystemCall;
import edu.kit.ipd.sdq.eventsim.system.command.parameter.InstallExternalCallParameterHandling;
import edu.kit.ipd.sdq.eventsim.system.debug.DebugSeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.system.events.BeginSeffTraversalEvent;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffInterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.AllocationRegistry;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.ComponentInstance;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.PassiveResourceRegistry;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.SimulatedResourceContainer;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.SimulatedResourceEnvironment;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.commands.BuildAndRegisterPassiveResources;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.commands.BuildResourceAllocation;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.commands.BuildSimulatedResourceEnvironment;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.IUser;
import edu.kit.ipd.sdq.simcomp.event.system.SystemRequestStart;
import edu.kit.ipd.sdq.simcomp.middleware.probespec.CalculatorFactory;
import edu.kit.ipd.sdq.simcomp.middleware.probespec.SimCompGarbageCollector;
import edu.kit.ipd.sdq.simcomp.middleware.probespec.EventSimProbeStrategyRegistry;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.MaxMeasurementsStopCondition;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.SimulationModel;

/**
 * The simulation model. This is the central class of an EventSim simulation
 * run. Before the simulation starts, it initialises the simulation in the
 * {@code init()} method. During the simulation, it provides information about
 * the PCM model that is to be simulated, the simulation configuration and the
 * simulation status. Finally, it cleans up after a simulation run in the
 * {finalise()} method.
 * <p>
 * Instances are created by using the static {@code create} method that builds
 * the simulation model in accordance with a specified simulation configuration.
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimSystemModel extends AbstractEventSimModel {

	private static final Logger logger = Logger.getLogger(EventSimSystemModel.class);

	private long mainMeasurementsCount;

	private final PassiveResourceRegistry passiveResourceRegistry;
	private SimulatedResourceEnvironment resourceEnvironment;
	private AllocationRegistry resourceAllocation;

	private SeffBehaviourInterpreter seffInterpreter;

	private Map<String, ComponentInstance> componentRegistry;
	private ISchedulingFactory schedulingFactory;

	public EventSimSystemModel(ISimulationMiddleware middleware) {
		super(middleware);

		this.passiveResourceRegistry = new PassiveResourceRegistry();
	}

	@Override
	public void init() {

		// initialise behaviour interpreters
		seffInterpreter = new SeffBehaviourInterpreter(new SeffInterpreterConfiguration(), this);

		// TODO (SimComp): we have already initialized the StoExContext in the workload
		// initialise probfunction factory and random generator
		// IProbabilityFunctionFactory probFunctionFactory =
		// ProbabilityFunctionFactoryImpl.getInstance();
		// probFunctionFactory.setRandomGenerator(this.getEventSimConfig().getRandomGenerator());
		// StoExCache.initialiseStoExCache(probFunctionFactory);

		// set up the resource scheduler
		SimulationModel simModel = (SimulationModel) this.getSimulationMiddleware().getSimulationModel();
		this.schedulingFactory = new SchedulingFactory(simModel);

		// initialise resource environment and allocation
		this.resourceEnvironment = this.execute(new BuildSimulatedResourceEnvironment(this, schedulingFactory));
		this.resourceAllocation = this.execute(new BuildResourceAllocation(this.resourceEnvironment));

		// initialise component instances
		this.componentRegistry = this.execute(new BuildComponentInstances(this, this.resourceAllocation));

		// initialise passive resources
		this.execute(new BuildAndRegisterPassiveResources(this, this.resourceAllocation, this.passiveResourceRegistry));

		// install debug traversal listeners, if debugging is enabled
		if (logger.isDebugEnabled()) {
			DebugSeffTraversalListener.install(this.seffInterpreter.getConfiguration());
		}

		// setup handling for PCM parameter characterisations
		this.execute(new InstallExternalCallParameterHandling(this.seffInterpreter.getConfiguration()));

		// initialise the Probe Specification
		//this.initialiseProbeSpecification();

		// notify registered listeners that the simulation is about to start...
		//this.notifyStartListeners();
	}

	/**
	 * Initialises the Probe Specification by building the
	 * {@link ProbeSpecContext}, setting up the calculators and mounting the
	 * probes.
	 */
	private void initialiseProbeSpecification() {
		// create ProbeSpecification context
		probeSpecContext = new ProbeSpecContext();

		// create a blackboard of the specified type
		ISampleBlackboard blackboard = BlackboardFactory.createBlackboard(config.getBlackboardType(), probeSpecContext.getThreadManager());

		// initialise ProbeSpecification context
		probeSpecContext.initialise(blackboard, new EventSimProbeStrategyRegistry(), new CalculatorFactory(this));

		// install a garbage collector which keeps track of the samples stored
		// on the blackboard and
		// removes samples when they become obsolete
		IRegionBasedGarbageCollector<RequestContext> garbageCollector = new SimCompGarbageCollector(blackboard);
		probeSpecContext.setBlackboardGarbageCollector(garbageCollector);

		// build calculators
		this.execute(new BuildResponseTimeCalculators(this));
		this.execute(new BuildActiveResourceCalculators(this, this.resourceEnvironment));
		this.execute(new BuildPassiveResourceCalculators(this, this.passiveResourceRegistry));

		// mount probes
		this.execute(new MountUsageScenarioProbes(this.usageInterpreter.getConfiguration()));
		this.execute(new MountSystemCallProbes(this.usageInterpreter.getConfiguration()));
		this.execute(new MountExternalCallProbes(this.seffInterpreter.getConfiguration()));
		this.execute(new MountActiveResourceProbes(this, this.resourceEnvironment));
		this.execute(new MountPassiveResourceProbes(this, this.passiveResourceRegistry));
	}

	/**
	 * Handles the simulation of a service call. Service calls are usually
	 * generated by a workload simulation component.
	 * 
	 * @param user
	 *            The user which initiated the call
	 * @param call
	 *            The called service in form of a PCM entry level system call
	 *            action
	 */
	public void callService(IUser user, EntryLevelSystemCall call) {
		// find the component which provides the call
		final AssemblyContext assemblyCtx = this.execute(new FindAssemblyContextForSystemCall(call));
		final ComponentInstance component = this.getComponent(assemblyCtx);
		final OperationSignature signature = call.getOperationSignature__EntryLevelSystemCall();

		// spawn a new EventSim request
		User eventSimUser = (User) user;
		final Request request = new Request(this, call, eventSimUser);
		this.getSimulationMiddleware().triggerEvent(new SystemRequestStart(request));
		new BeginSeffTraversalEvent(this, component, signature, eventSimUser.getUserState()).schedule(request, 0);
	}

	public void finalise() {
		// TODo (SimComp): move the finalise of both event sim model to a good place based on event
		// notify observers that the simulation is finished (below we just clean
		// up...)
		this.notifyStopListeners();

		// notify active entities that the simulation is finished (and
		// therefore, also their
		// existence in the simulated system)
		//for (EventSimEntity entity : activeEntitiesList) {
		//	assert entity.getState().equals(EventSimEntity.EntityState.ENTERED_SYSTEM) : "Found an entity in the " + "list of active entities which is in the state " + entity.getState() + ", and therefore can not be an active entity.";
		//	entity.notifyLeftSystem();
		//}
		//assert activeEntitiesList.isEmpty() : "There are some entities left in the list of active entities, though " + "each of them was asked to leave the system.";

		// notify active resources about the simulation stop
		deactivateResources();

		// clean up
		if (logger.isDebugEnabled()) {
			logger.debug("Cleaning up...");
		}
		EventSimEntity.resetIdGenerator();
		probeSpecContext.finish();
		AbstractActiveResource.cleanProcesses();

		if (logger.isEnabledFor(Level.INFO))
			logger.info("Simulation took " + this.getSimulationMiddleware().getSimulationControl().getCurrentSimulationTime() + " simulation seconds");

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
	 * Returns the resource environment comprising
	 * {@link SimulatedResourceContainer}.
	 * 
	 * @return the resource environment
	 */
	public SimulatedResourceEnvironment getResourceEnvironment() {
		return this.resourceEnvironment;
	}

	/**
	 * Returns the allocation of {@link AssemblyContext}s to
	 * {@link SimulatedResourceContainer}s.
	 * 
	 * @return a registry containing the resource allocations
	 */
	public AllocationRegistry getResourceAllocation() {
		return this.resourceAllocation;
	}

	/**
	 * Returns the component instance that is encapsulated by the specified
	 * assembly context.
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
	 * Notice that one measurements refers to one {@link User} that has
	 * completely traversed the simulated system.
	 */
	public void increaseMainMeasurementsCount() {
		this.mainMeasurementsCount++;
	}

	/**
	 * Returns the number of measurements, which has been taken.
	 * <p>
	 * Notice that one measurements refers to one {@link User} that has
	 * completely traversed the simulated system.
	 * 
	 * @return the current number of measurements
	 */
	public long getMainMeasurementsCount() {
		return this.mainMeasurementsCount;
	}

	public SeffBehaviourInterpreter getSeffInterpreter() {
		return seffInterpreter;
	}

	/**
	 * Notfies all simulation observers that the simulation is about to start
	 */
	private void notifyStartListeners() {
		for (final ISimulationListener l : this.getEventSimConfig().getListeners()) {
			l.simulationStart();
		}
	}

	/**
	 * Notfies all simulation observers that the simulation has stopped
	 */
	private void notifyStopListeners() {
		for (final ISimulationListener l : this.getEventSimConfig().getListeners()) {
			l.simulationStop();
		}
	}

	public ISchedulingFactory getSchedulingFactory() {
		return schedulingFactory;
	}

}
