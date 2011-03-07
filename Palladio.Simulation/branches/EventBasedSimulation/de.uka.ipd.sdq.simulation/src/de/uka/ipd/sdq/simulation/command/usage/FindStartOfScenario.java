package de.uka.ipd.sdq.simulation.command.usage;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.exceptions.concrete.UnexpectedModelStructureException;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

public class FindStartOfScenario implements IPCMCommand<Start> {

    private final ScenarioBehaviour behaviour;

    private int hashCode;

    public FindStartOfScenario(final UsageScenario scenario) {
        this(scenario.getScenarioBehaviour_UsageScenario());
    }

    public FindStartOfScenario(final ScenarioBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    @Override
    public Start execute(final PCMModel pcm, final ICommandExecutor<PCMModel> executor) {
        final AbstractUserAction action = this.behaviour.getActions_ScenarioBehaviour().get(0);
        // if there are no actions in the behaviour
        if (action == null) {
            // this should not happen, as an OCL constraint ensures exactly one start action
            throw new UnexpectedModelStructureException("Could not find a start action in "
                    + PCMEntityHelper.toString(this.behaviour));
        }
        try {
            return (Start) action;
        } catch (final ClassCastException e) {
            throw new UnexpectedModelStructureException(
                    "The first action of a scenario behavior is expected to be a start "
                            + "action. However, an action of type " + action.eClass().getName() + " was found.");
        }
    }

    @Override
    public boolean cachable() {
        return true;
    }

    @Override
    public int hashCode() {
        if (this.hashCode == 0) {
            final int prime = 31;
            final int result = 1;
            this.hashCode = prime * result + ((this.behaviour == null) ? 0 : this.behaviour.hashCode());
        }
        return this.hashCode;
    }

    @Override
    public boolean equals(final Object obj) {
        final FindStartOfScenario other = (FindStartOfScenario) obj;
        return PCMEntityHelper.equals(this.behaviour.getUsageScenario_SenarioBehaviour(), other.behaviour
                .getUsageScenario_SenarioBehaviour());
    }

}
