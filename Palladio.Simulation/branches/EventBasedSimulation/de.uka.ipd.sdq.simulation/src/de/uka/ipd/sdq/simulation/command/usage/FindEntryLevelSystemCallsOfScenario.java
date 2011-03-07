package de.uka.ipd.sdq.simulation.command.usage;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;

public class FindEntryLevelSystemCallsOfScenario implements IPCMCommand<List<EntryLevelSystemCall>> {

    private UsageScenario scenario;

    public FindEntryLevelSystemCallsOfScenario(UsageScenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public List<EntryLevelSystemCall> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        Start start = executor.execute(new FindStartOfScenario(scenario));
        return findSystemCalls(start, executor);
    }
    
    @Override
    public boolean cachable() {
        return false;
    }

    private List<EntryLevelSystemCall> findSystemCalls(AbstractUserAction action, ICommandExecutor<PCMModel> executor) {
        List<EntryLevelSystemCall> calls = new ArrayList<EntryLevelSystemCall>();
        AbstractUserAction currentAction = action;
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

    private List<EntryLevelSystemCall> findSystemCallsInBranch(Branch action, ICommandExecutor<PCMModel> executor) {
        List<EntryLevelSystemCall> calls = new ArrayList<EntryLevelSystemCall>();
        for (BranchTransition t : action.getBranchTransitions_Branch()) {
            Start start = executor.execute(new FindStartOfScenario(t.getBranchedBehaviour_BranchTransition()));
            calls.addAll(findSystemCalls(start, executor));
        }
        return calls;
    }

    private List<EntryLevelSystemCall> findSystemCallsInLoop(Loop action, ICommandExecutor<PCMModel> executor) {
        Start start = executor.execute(new FindStartOfScenario(action.getBodyBehaviour_Loop()));
        return findSystemCalls(start, executor);
    }

}
