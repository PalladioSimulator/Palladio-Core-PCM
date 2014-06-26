package de.uka.ipd.sdq.experimentautomation.application.variation;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.experimentautomation.application.utils.EcoreHelper;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

public class AbstractUserActionReplication implements IVariationStrategy {

    /** the action that is to be replicated */
    private AbstractUserAction action;

    @Override
    public void setVariedObject(EObject o) {
        if (!AbstractUserAction.class.isInstance(o)) {
            throw new RuntimeException("Expected an instance of " + AbstractUserAction.class.getName()
                    + ", but encountered a " + o.getClass().getName());
        }
        action = (AbstractUserAction) o;
    }

    @Override
    public String vary(long value) {
        AbstractUserAction lastAction = action;
        for (int i = 0; i < value; i++) {
            AbstractUserAction previousSuccessor = lastAction.getSuccessor();
            AbstractUserAction copy = EcoreHelper.copy(action);
            lastAction.setSuccessor(copy);
            copy.setScenarioBehaviour_AbstractUserAction(action.getScenarioBehaviour_AbstractUserAction());
            copy.setPredecessor(lastAction);
            copy.setSuccessor(previousSuccessor);
            copy.setEntityName(copy.getEntityName() + (i + 1));
            lastAction = copy;
        }

        return "Replication count = " + value + ": " + PCMEntityHelper.toString(action);
    }

}
