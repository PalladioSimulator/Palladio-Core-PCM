package edu.kit.ipd.sdq.eventsim.system.command.seff;

import java.util.ArrayList;
import java.util.List;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.AbstractBranchTransition;
import org.palladiosimulator.pcm.seff.BranchAction;
import org.palladiosimulator.pcm.seff.ForkAction;
import org.palladiosimulator.pcm.seff.LoopAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.StartAction;
import org.palladiosimulator.pcm.seff.SynchronisationPoint;

import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

/**
 * This command returns all {@link AbstractAction}s of a specified type that are contained in the specified SEFF. The
 * search is recursive such that action contained in loops or branches, for instance, are returned as well.
 * 
 * @author Philipp Merkle
 * 
 */
public class FindActionsInSeff<A extends AbstractAction> implements IPCMCommand<List<A>> {

	private ResourceDemandingSEFF seff;

	private Class<A> actionType;

	/**
	 * Constructs a command that returns all actions of the specified type contained in the given SEFF.
	 * 
	 * @param seff
	 *            the SEFF to be searched for actions
	 * @param actionType
	 *            the type of actions to be searched for
	 */
	public FindActionsInSeff(ResourceDemandingSEFF seff, Class<A> actionType) {
		assert (seff != null) : "The argument seff may not be null";
		this.seff = seff;
		this.actionType = actionType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<A> execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
		return findActionsByType(seff, executor);
	}

	/**
	 * Searches for and returns all external calls that are contained in the specified resource demanding behaviour.
	 */
	private List<A> findActionsByType(ResourceDemandingBehaviour behaviour, ICommandExecutor<IPCMModel> executor) {
		List<A> actions = new ArrayList<>();

		// find start action
		AbstractAction currentAction = executor.execute(new FindActionInBehaviour<StartAction>(
				behaviour, StartAction.class));
		while (currentAction != null) {
			if (actionType.isInstance(currentAction)) {
				// cast is safe
				actions.add((A) currentAction);
			} else if (SeffPackage.eINSTANCE.getBranchAction().isInstance(currentAction)) {
				actions.addAll(findExternalCallsInBranch((BranchAction) currentAction, executor));
			} else if (SeffPackage.eINSTANCE.getLoopAction().isInstance(currentAction)) {
				actions.addAll(findExternalCallsInLoop((LoopAction) currentAction, executor));
			} else if (SeffPackage.eINSTANCE.getForkAction().isInstance(currentAction)) {
				actions.addAll(findExternalCallsInFork((ForkAction) currentAction, executor));
			}
			currentAction = currentAction.getSuccessor_AbstractAction();
		}
		return actions;
	}

	/**
	 * Searches for and returns all external calls that are contained in the specified branch.
	 */
	private List<A> findExternalCallsInBranch(BranchAction branch, ICommandExecutor<IPCMModel> executor) {
		List<A> calls = new ArrayList<>();
		for (AbstractBranchTransition t : branch.getBranches_Branch()) {
			calls.addAll(findActionsByType(t.getBranchBehaviour_BranchTransition(), executor));
		}
		return calls;
	}

	/**
	 * Searches for and returns all external calls that are contained in the specified loop.
	 */
	private List<A> findExternalCallsInLoop(LoopAction loop, ICommandExecutor<IPCMModel> executor) {
		return findActionsByType(loop.getBodyBehaviour_Loop(), executor);
	}

	/**
	 * Searches for and returns all external calls that are contained in the specified fork.
	 */
	private List<A> findExternalCallsInFork(ForkAction fork, ICommandExecutor<IPCMModel> executor) {
		List<A> calls = new ArrayList<>();
		for (ResourceDemandingBehaviour b : fork.getAsynchronousForkedBehaviours_ForkAction()) {
			calls.addAll(findActionsByType(b, executor));
		}
		if (fork.getSynchronisingBehaviours_ForkAction() != null) {
			SynchronisationPoint s = fork.getSynchronisingBehaviours_ForkAction();
			for (ResourceDemandingBehaviour b : s.getSynchronousForkedBehaviours_SynchronisationPoint()) {
				calls.addAll(findActionsByType(b, executor));
			}
		}
		return calls;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean cachable() {
		return false;
	}

}