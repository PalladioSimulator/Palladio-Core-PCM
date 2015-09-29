package edu.kit.ipd.sdq.eventsim.workload.command.usage;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;

import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.UnexpectedModelStructureException;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

/**
 * This command searches for an action of the specified type in the specified scenario behaviour and
 * returns the first occurrence.
 * 
 * @author Philipp Merkle
 * 
 * @param <R>
 *            the type of the action that is to be searched for
 */
public class FindActionInUsageBehaviour<R extends AbstractUserAction> implements IPCMCommand<R> {

    private ScenarioBehaviour behaviour;
    private Class<R> actionClass;

    /**
     * Constructs a new command that searches in the passed behaviour for an action of the specified
     * class.
     * 
     * @param behaviour
     *            the behaviour in which to search
     * @param actionClass
     *            the class of the action that is to be found
     */
    public FindActionInUsageBehaviour(ScenarioBehaviour behaviour, Class<R> actionClass) {
        assert (behaviour != null) : "The argument behaviour may not be null";
        assert (actionClass != null) : "The argument actionClass may not be null";
        this.behaviour = behaviour;
        this.actionClass = actionClass;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public R execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
        for (AbstractUserAction action : behaviour.getActions_ScenarioBehaviour()) {
            if (actionClass.isInstance(action)) {
                return (R) action;
            }
        }
        throw new UnexpectedModelStructureException("Could not find an action of type " + actionClass.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

}
