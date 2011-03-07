package de.uka.ipd.sdq.simulation.command.usage;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.exceptions.concrete.UnexpectedModelStructureException;

public class FindActionInUsageBehaviour<R extends AbstractUserAction> implements IPCMCommand<R> {

    private ScenarioBehaviour behaviour;

    private Class<R> clazz;

    public FindActionInUsageBehaviour(ScenarioBehaviour behaviour, Class<R> clazz) {
        assert(behaviour != null) : "The behaviour may not be null";
        assert(clazz != null) : "The class may not be null";
        this.behaviour = behaviour;
        this.clazz = clazz;
    }

    @Override
    public R execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (AbstractUserAction action : behaviour.getActions_ScenarioBehaviour()) {
            if (clazz.isInstance(action)) {
                return (R) action;
            }

        }
        throw new UnexpectedModelStructureException("Could not find an action of type " + clazz.getName());

        // // if there are no actions in the behaviour
        // if (action == null) {
        // // this should not happen, as an OCL constraint ensures exactly one start action
        // throw new UnexpectedModelStructureException("Could not find a start action in "
        // +
        // PCMEntityHelper.toString(behaviour.getAbstractBranchTransition_ResourceDemandingBehaviour()));
        // }
        // try {
        // return (StartAction) action;
        // } catch (ClassCastException e) {
        // throw new
        // UnexpectedModelStructureException("The first action of a behavior is expected to be a start "
        // + "action. However, an action of type " + action.eClass().getName() + " was found.");
        // }
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
