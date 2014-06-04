package edu.kit.ipd.sdq.eventsim.system;

import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.simulation.ISimulationListener;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.IUserState;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.StateExchange;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.system.command.BuildComponentInstances;
import edu.kit.ipd.sdq.eventsim.system.command.FindAssemblyContextForSystemCall;
import edu.kit.ipd.sdq.eventsim.system.command.InstallExternalCallParameterHandling;
import edu.kit.ipd.sdq.eventsim.system.debug.DebugSeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.events.BeginSeffTraversalEvent;
import edu.kit.ipd.sdq.eventsim.system.handler.AfterSystemCallParameterHandler;
import edu.kit.ipd.sdq.eventsim.system.handler.BeforeSystemCallParameterHandler;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffInterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.system.probespec.commands.BuildResponseTimeCalculators;
import edu.kit.ipd.sdq.eventsim.system.probespec.commands.MountExternalCallProbes;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.AllocationRegistry;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.ComponentInstance;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.SimulatedResourceContainer;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.SimulatedResourceEnvironment;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.commands.BuildResourceAllocation;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.commands.BuildSimulatedResourceEnvironment;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.IUser;
import edu.kit.ipd.sdq.simcomp.system.events.SystemRequestProcessed;
import edu.kit.ipd.sdq.simcomp.system.events.SystemRequestStart;

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

	private SeffBehaviourInterpreter seffInterpreter;

	private SimulatedResourceEnvironment resourceEnvironment;
	private AllocationRegistry resourceAllocation;
	private Map<String, ComponentInstance> componentRegistry;

	public EventSimSystemModel(ISimulationMiddleware middleware) {
		super(middleware);
	}

	public void init() {

		// initialise behavior interpreters
		seffInterpreter = new SeffBehaviourInterpreter(new SeffInterpreterConfiguration(), this);

		// install debug traversal listeners, if debugging is enabled
		if (logger.isDebugEnabled()) {
			DebugSeffTraversalListener.install(this.seffInterpreter.getConfiguration());
		}

		this.initProbeSpecification();

		this.registerEventHandler();

		// initialise resource environment and allocation
		this.resourceEnvironment = this.execute(new BuildSimulatedResourceEnvironment(this));
		this.resourceAllocation = this.execute(new BuildResourceAllocation(this.resourceEnvironment));

		// initialise component instances
		this.componentRegistry = this.execute(new BuildComponentInstances(this, this.resourceAllocation));
		
		// install extern call parameter handling
		this.execute(new InstallExternalCallParameterHandling(this.seffInterpreter.getConfiguration()));

		// notify registered listeners that the simulation is about to start...
		// this.notifyStartListeners();
	}

	/**
	 * Register event handler to react on specific simulation events.
	 */
	private void registerEventHandler() {

		// setup system call parameter handling
		this.getSimulationMiddleware().registerEventHandler(SystemRequestStart.EVENT_ID, new BeforeSystemCallParameterHandler(this));
		this.getSimulationMiddleware().registerEventHandler(SystemRequestProcessed.EVENT_ID, new AfterSystemCallParameterHandler());

	}

	/**
	 * Initializes the Probe Specification by setting up the calculators and
	 * mounting the probes.
	 */
	private void initProbeSpecification() {

		// build calculators
		this.execute(new BuildResponseTimeCalculators(this));

		// mount probes
		this.execute(new MountExternalCallProbes(this.seffInterpreter.getConfiguration(), this.getSimulationMiddleware()));
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
		final Request request = new Request(this, call, user);

		new BeginSeffTraversalEvent(this, component, signature, (UserState) getUserState(user)).schedule(request, 0);
	}

	/**
	 * Fetches the user state created by the workload component from the state
	 * exchange service.
	 * 
	 * @param user
	 * @return A user state object
	 */
	private IUserState getUserState(IUser user) {
		return StateExchange.getUserState(user.getId());
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

}
