package de.uka.ipd.sdq.simulation.command.usage;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.command.rdseff.FindActionInSEFF;

public class FindExternalCallActionsOfRDSEFF implements IPCMCommand<List<ExternalCallAction>> {

    private ResourceDemandingSEFF seff;

    public FindExternalCallActionsOfRDSEFF(ResourceDemandingSEFF seff) {
        assert(seff != null) : "The argument seff may not be null";
        this.seff = seff;
    }

    @Override
    public List<ExternalCallAction> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        StartAction startAction = executor.execute(new FindActionInSEFF<StartAction>(seff, StartAction.class));
        return findExternalCalls(startAction, executor);
    }

    private List<ExternalCallAction> findExternalCalls(AbstractAction action, ICommandExecutor<PCMModel> executor) {
        List<ExternalCallAction> calls = new ArrayList<ExternalCallAction>();
        AbstractAction currentAction = action;
        // TODO: Further hierarchical control flow constructs?
        while (currentAction != null) {
            if (SeffPackage.eINSTANCE.getExternalCallAction().isInstance(currentAction)) {
                calls.add((ExternalCallAction) currentAction);
            } else if (SeffPackage.eINSTANCE.getBranchAction().isInstance(currentAction)) {
                calls.addAll(findExternalCallsInBranch((BranchAction) currentAction, executor));
            } else if (SeffPackage.eINSTANCE.getLoopAction().isInstance(currentAction)) {
                calls.addAll(findExternalCallsInLoop((LoopAction) currentAction, executor));
            }
            currentAction = currentAction.getSuccessor_AbstractAction();
        }
        return calls;
    }

    private List<ExternalCallAction> findExternalCallsInBranch(BranchAction branch, ICommandExecutor<PCMModel> executor) {
        List<ExternalCallAction> calls = new ArrayList<ExternalCallAction>();
        for (AbstractBranchTransition t : branch.getBranches_Branch()) {
            StartAction startAction = executor.execute(new FindActionInSEFF<StartAction>(t.getBranchBehaviour_BranchTransition(), StartAction.class));
            calls.addAll(findExternalCalls(startAction, executor));
            
//            if(SeffPackage.eINSTANCE.getGuardedBranchTransition().isInstance(t)) {
//                
//            } else if(SeffPackage.eINSTANCE.getProbabilisticBranchTransition().isInstance(t)) {
//                
//            }
        }
        return calls;
    }

    private List<ExternalCallAction> findExternalCallsInLoop(LoopAction loop, ICommandExecutor<PCMModel> executor) {
        StartAction startAction = executor.execute(new FindActionInSEFF<StartAction>(loop.getBodyBehaviour_Loop(), StartAction.class));
        return findExternalCalls(startAction, executor);
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
