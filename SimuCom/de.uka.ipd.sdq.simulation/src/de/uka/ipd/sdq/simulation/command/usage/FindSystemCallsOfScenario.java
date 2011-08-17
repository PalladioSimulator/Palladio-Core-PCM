package de.uka.ipd.sdq.simulation.command.usage;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;

/**
 * This command collects all {@link EntryLevelSystemCall}s contained in the specified scenario.
 * 
 * @author Philipp Merkle
 * 
 */
public class FindSystemCallsOfScenario implements IPCMCommand<List<EntryLevelSystemCall>> {

    private UsageScenario scenario;

    /**
     * Constructs a command that returns all EntryLevelSystemCalls contained in the given usage
     * scenario.
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
    public List<EntryLevelSystemCall> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
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
     * Searches for and returns all system calls that are contained in the specified scenario
     * behaviour
     */
    private List<EntryLevelSystemCall> findSystemCalls(ScenarioBehaviour behaviour, ICommandExecutor<PCMModel> executor) {
        List<EntryLevelSystemCall> calls = new ArrayList<EntryLevelSystemCall>();

        // find start action
        AbstractUserAction currentAction = executor.execute(new FindActionInUsageBehaviour<Start>(behaviour,
                Start.class));
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
     * Searches for and returns all system calls that are contained in the specified branch.
     */
    private List<EntryLevelSystemCall> findSystemCallsInBranch(Branch action, ICommandExecutor<PCMModel> executor) {
        List<EntryLevelSystemCall> calls = new ArrayList<EntryLevelSystemCall>();
        for (BranchTransition t : action.getBranchTransitions_Branch()) {
            ScenarioBehaviour behaviour = t.getBranchedBehaviour_BranchTransition();
            calls.addAll(findSystemCalls(behaviour, executor));
        }
        return calls;
    }

    /**
     * Searches for and returns all system calls that are contained in the specified loop.
     */
    private List<EntryLevelSystemCall> findSystemCallsInLoop(Loop action, ICommandExecutor<PCMModel> executor) {
        ScenarioBehaviour behaviour = action.getBodyBehaviour_Loop();
        return findSystemCalls(behaviour, executor);
    }

}
