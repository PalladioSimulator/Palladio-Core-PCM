package de.uka.ipd.sdq.simulation.command.rdseff;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.exceptions.concrete.UnexpectedModelStructureException;

public class FindActionInSEFF<R extends AbstractAction> implements IPCMCommand<R> {

    private ResourceDemandingBehaviour behaviour;

    private Class<R> clazz;

    public FindActionInSEFF(ResourceDemandingBehaviour seff, Class<R> clazz) {
        assert(seff != null) : "The behaviour may not be null";
        assert(clazz != null) : "The class may not be null";
        this.behaviour = seff;
        this.clazz = clazz;
    }

    @Override
    public R execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (AbstractAction action : behaviour.getSteps_Behaviour()) {
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
