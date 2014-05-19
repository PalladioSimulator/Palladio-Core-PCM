package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies;

import java.util.List;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.workload.Activator;
import edu.kit.ipd.sdq.eventsim.workload.EventSimWorkload;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.IUsageTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.instructions.UsageTraversalInstructionFactory;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.system.component.ISystem;

/**
 * This traversal strategy is responsible to create service calls on a system
 * simulation component based on {@link EntryLevelSystemCall} actions.
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 */
public class EntryLevelSystemCallTraversalStrategy implements IUsageTraversalStrategy<EntryLevelSystemCall> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IUsageTraversalInstruction traverse(final EntryLevelSystemCall call, final User user, final UserState state) {

		// store EventSim specific state to the user
		user.setUserState(state);

		// fetch the system simulation component
		ISimulationMiddleware middleware = user.getEventSimModel().getSimulationMiddleware();

		EventSimWorkload workload = (EventSimWorkload) Activator.getDefault().getWorkloadComponent();
		List<ISystem> systemComponents = workload.getSystemComponents();
		ISystem system = (ISystem) middleware.getSimulationComponent(ISystem.class, systemComponents, null);

		// perform a service call
		system.callService(user, call);

		// interrupt the usage traversal until service call simulation finished
		return UsageTraversalInstructionFactory.interruptTraversal(call.getSuccessor());
	}

}
