package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies;

import java.util.List;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.InterruptTraversal;
import edu.kit.ipd.sdq.eventsim.workload.Activator;
import edu.kit.ipd.sdq.eventsim.workload.EventSimWorkload;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.system.component.ISystem;

/**
 * This traversal strategy is responsible to create service calls on a system
 * simulation component based on {@link EntryLevelSystemCall} actions.
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 */
public class EntryLevelSystemCallTraversalStrategy implements ITraversalStrategy<AbstractUserAction, EntryLevelSystemCall, User, UserState> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITraversalInstruction<AbstractUserAction, UserState> traverse(final EntryLevelSystemCall call, final User user, final UserState state) {

		// store EventSim specific state to the user
		user.setUserState(state);

		// fetch the system simulation component
		ISimulationMiddleware middleware = user.getEventSimModel().getSimulationMiddleware();

		EventSimWorkload workload = (EventSimWorkload) Activator.getDefault().getWorkloadComponent();
		List<ISystem> systemComponents = workload.getSystemComponents();
		ISystem system = (ISystem) middleware.getSimulationComponent(EventSimWorkload.class, ISystem.class, systemComponents, null);

		// perform a service call
		system.callService(user, call);

		// interrupt the usage traversal until service call simulation finished
		return new InterruptTraversal<>(call.getSuccessor());
	}

}
