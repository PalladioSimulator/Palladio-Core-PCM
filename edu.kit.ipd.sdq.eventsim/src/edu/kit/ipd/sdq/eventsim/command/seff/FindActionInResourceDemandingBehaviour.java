package edu.kit.ipd.sdq.eventsim.command.seff;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.UnexpectedModelStructureException;

/**
 * This command searches for an action of the specified type in the specified service effect
 * specification and returns the first occurrence.
 * 
 * @author Philipp Merkle
 * 
 * @param <R>
 *            the type of the action that is to be searched for
 */
public class FindActionInResourceDemandingBehaviour<R extends AbstractAction> implements IPCMCommand<R> {

    private ResourceDemandingBehaviour behaviour;
    private Class<R> actionClass;
//    private int hashCode;

    public FindActionInResourceDemandingBehaviour(ResourceDemandingBehaviour seff, Class<R> actionClass) {
        assert (seff != null) : "The argument behaviour may not be null";
        assert (actionClass != null) : "The argument actionClass may not be null";
        this.behaviour = seff;
        this.actionClass = actionClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public R execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (AbstractAction action : behaviour.getSteps_Behaviour()) {
            if (actionClass.isInstance(action)) {
                return (R) action;
            }
        }
        throw new UnexpectedModelStructureException("Could not find an action of type " + actionClass.getName());
    }

    @Override
    public boolean cachable() {
        return true;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actionClass == null) ? 0 : actionClass.hashCode());
		result = prime * result
				+ ((behaviour == null) ? 0 : behaviour.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FindActionInResourceDemandingBehaviour other = (FindActionInResourceDemandingBehaviour) obj;
		if (actionClass == null) {
			if (other.actionClass != null)
				return false;
		} else if (!actionClass.equals(other.actionClass))
			return false;
		if (behaviour == null) {
			if (other.behaviour != null)
				return false;
		} else if (!behaviour.equals(other.behaviour))
			return false;
		return true;
	}
    
    
    
    
//    @Override
//    public int hashCode() {
//        if (this.hashCode == 0) {
//            final int prime = 31;
//            final int result = 1;
//            this.hashCode = prime * result + ((this.behaviour == null) ? 0 : this.behaviour.hashCode());
//        }
//        return this.hashCode;
//    }
//
//    @Override
//    public boolean equals(final Object obj) {
//        final FindStartOfScenario other = (FindStartOfScenario) obj;
//        return PCMEntityHelper.equals(this.behaviour.getUsageScenario_SenarioBehaviour(), other.behaviour
//                .getUsageScenario_SenarioBehaviour());
//    }

}
