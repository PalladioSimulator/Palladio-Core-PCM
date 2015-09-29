package edu.kit.ipd.sdq.eventsim.workload.command.usage;

import java.util.LinkedHashSet;
import java.util.Set;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.Branch;
import org.palladiosimulator.pcm.usagemodel.BranchTransition;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.Loop;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.Start;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

/**
 * This command collects all {@link EntryLevelSystemCall}s contained in the
 * specified scenario.
 * 
 * @author Philipp Merkle
 * 
 */
public class FindSystemCallsOfScenario implements IPCMCommand<Set<EntryLevelSystemCall>> {

	private UsageScenario scenario;

	/**
	 * Constructs a command that returns all EntryLevelSystemCalls contained in
	 * the given usage scenario.
	 * 
	 * @param scenario
	 *            the usage scenario
	 */
	public FindSystemCallsOfScenario(UsageScenario scenario) {
		this.scenario = scenario;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<EntryLevelSystemCall> execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
		ScenarioBehaviour behaviour = scenario.getScenarioBehaviour_UsageScenario();
		return findSystemCalls(behaviour, executor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean cachable() {
		return false;
	}

	/**
	 * Searches for and returns all system calls that are contained in the
	 * specified scenario behaviour
	 */
	private Set<EntryLevelSystemCall> findSystemCalls(ScenarioBehaviour behaviour, ICommandExecutor<IPCMModel> executor) {
		Set<EntryLevelSystemCall> calls = new LinkedHashSet<EntryLevelSystemCall>();

		// find start action
		AbstractUserAction currentAction = executor.execute(new FindActionInUsageBehaviour<Start>(behaviour, Start.class));
		while (currentAction != null) {
			if (UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall().isInstance(currentAction)) {
				calls.add((EntryLevelSystemCall) currentAction);
			} else if (UsagemodelPackage.eINSTANCE.getBranch().isInstance(currentAction)) {
				calls.addAll(findSystemCallsInBranch((Branch) currentAction, executor));
			} else if (UsagemodelPackage.eINSTANCE.getLoop().isInstance(currentAction)) {
				calls.addAll(findSystemCallsInLoop((Loop) currentAction, executor));
			}
			currentAction = currentAction.getSuccessor();
		}
		return calls;
	}

	/**
	 * Searches for and returns all system calls that are contained in the
	 * specified branch.
	 */
	private Set<EntryLevelSystemCall> findSystemCallsInBranch(Branch action, ICommandExecutor<IPCMModel> executor) {
		Set<EntryLevelSystemCall> calls = new LinkedHashSet<EntryLevelSystemCall>();
		for (BranchTransition t : action.getBranchTransitions_Branch()) {
			ScenarioBehaviour behaviour = t.getBranchedBehaviour_BranchTransition();
			calls.addAll(findSystemCalls(behaviour, executor));
		}
		return calls;
	}

	/**
	 * Searches for and returns all system calls that are contained in the
	 * specified loop.
	 */
	private Set<EntryLevelSystemCall> findSystemCallsInLoop(Loop action, ICommandExecutor<IPCMModel> executor) {
		ScenarioBehaviour behaviour = action.getBodyBehaviour_Loop();
		return findSystemCalls(behaviour, executor);
	}

}
