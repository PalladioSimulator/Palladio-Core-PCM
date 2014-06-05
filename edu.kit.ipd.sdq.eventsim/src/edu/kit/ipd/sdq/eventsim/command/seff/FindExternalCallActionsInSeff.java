package edu.kit.ipd.sdq.eventsim.command.seff;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;

/**
 * This command returns all {@link ExternalCallAction}s that are contained in a specified SEFF. The
 * search is recursive such that calls that are contained in e.g. loops or branches are returned as
 * well.
 * 
 * @author Philipp Merkle
 * 
 */
public class FindExternalCallActionsInSeff implements IPCMCommand<List<ExternalCallAction>> {

    private ResourceDemandingSEFF seff;

    /**
     * Constructs a command that returns all {@link ExternalCallAction}s contained in the given
     * SEFF.
     * 
     * @param seff
     *            the SEFF that is to be searched for external calls
     */
    public FindExternalCallActionsInSeff(ResourceDemandingSEFF seff) {
        assert (seff != null) : "The argument seff may not be null";
        this.seff = seff;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ExternalCallAction> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        return findExternalCalls(seff, executor);
    }

    /**
     * Searches for and returns all external calls that are contained in the specified resource
     * demanding behaviour.
     */
    private List<ExternalCallAction> findExternalCalls(ResourceDemandingBehaviour behaviour,
            ICommandExecutor<PCMModel> executor) {
        List<ExternalCallAction> calls = new ArrayList<ExternalCallAction>();

        // find start action
        AbstractAction currentAction = executor.execute(new FindActionInResourceDemandingBehaviour<StartAction>(
                behaviour, StartAction.class));
        while (currentAction != null) {
            if (SeffPackage.eINSTANCE.getExternalCallAction().isInstance(currentAction)) {
                calls.add((ExternalCallAction) currentAction);
            } else if (SeffPackage.eINSTANCE.getBranchAction().isInstance(currentAction)) {
                calls.addAll(findExternalCallsInBranch((BranchAction) currentAction, executor));
            } else if (SeffPackage.eINSTANCE.getLoopAction().isInstance(currentAction)) {
                calls.addAll(findExternalCallsInLoop((LoopAction) currentAction, executor));
            } else if (SeffPackage.eINSTANCE.getForkAction().isInstance(currentAction)) {
                calls.addAll(findExternalCallsInFork((ForkAction) currentAction, executor));
            }
            currentAction = currentAction.getSuccessor_AbstractAction();
        }
        return calls;
    }

    /**
     * Searches for and returns all external calls that are contained in the specified branch.
     */
    private List<ExternalCallAction> findExternalCallsInBranch(BranchAction branch, ICommandExecutor<PCMModel> executor) {
        List<ExternalCallAction> calls = new ArrayList<ExternalCallAction>();
        for (AbstractBranchTransition t : branch.getBranches_Branch()) {
            calls.addAll(findExternalCalls(t.getBranchBehaviour_BranchTransition(), executor));
        }
        return calls;
    }

    /**
     * Searches for and returns all external calls that are contained in the specified loop.
     */
    private List<ExternalCallAction> findExternalCallsInLoop(LoopAction loop, ICommandExecutor<PCMModel> executor) {
        return findExternalCalls(loop.getBodyBehaviour_Loop(), executor);
    }

    /**
     * Searches for and returns all external calls that are contained in the specified fork.
     */
    private List<ExternalCallAction> findExternalCallsInFork(ForkAction fork, ICommandExecutor<PCMModel> executor) {
        List<ExternalCallAction> calls = new ArrayList<ExternalCallAction>();
        for (ResourceDemandingBehaviour b : fork.getAsynchronousForkedBehaviours_ForkAction()) {
            calls.addAll(findExternalCalls(b, executor));
        }
        if(fork.getSynchronisingBehaviours_ForkAction() != null) {
            SynchronisationPoint s = fork.getSynchronisingBehaviours_ForkAction(); 
            for(ResourceDemandingBehaviour b : s.getSynchronousForkedBehaviours_SynchronisationPoint()) {
                calls.addAll(findExternalCalls(b, executor));
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
