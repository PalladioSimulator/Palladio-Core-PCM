package de.uka.ipd.sdq.experimentautomation.application.variation;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.experimentautomation.application.utils.EcoreHelper;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

public class AbstractActionReplication implements IVariationStrategy {

    /** the action that is to be replicated */
    private AbstractAction action;

    @Override
    public void setVariedObject(EObject o) {
        if (!AbstractAction.class.isInstance(o)) {
            throw new RuntimeException("Expected an instance of " + AbstractAction.class.getName()
                    + ", but encountered a " + o.getClass().getName());
        }
        action = (AbstractAction) o;
    }

    @Override
    public String vary(long value) {
        AbstractAction lastAction = action;
        for (int i = 0; i < value; i++) {
            AbstractAction previousSuccessor = lastAction.getSuccessor_AbstractAction();
            AbstractAction copy = EcoreHelper.copy(action);
            lastAction.setSuccessor_AbstractAction(copy);
            copy.setResourceDemandingBehaviour_AbstractAction(action.getResourceDemandingBehaviour_AbstractAction());
            copy.setPredecessor_AbstractAction(lastAction);
            copy.setSuccessor_AbstractAction(previousSuccessor);
            copy.setEntityName(copy.getEntityName() + (i + 1));
            lastAction = copy;
        }

        return "Replication count = " + value + ": " + PCMEntityHelper.toString(action);
    }

}
