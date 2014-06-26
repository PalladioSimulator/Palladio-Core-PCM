package de.uka.ipd.sdq.experimentautomation.application.variation;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.experimentautomation.application.utils.EcoreHelper;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

public class ForkedBehaviourReplication implements IVariationStrategy {

    /** the action that is to be replicated */
    private ForkAction fork;

    @Override
    public void setVariedObject(EObject o) {
        if (!ForkAction.class.isInstance(o)) {
            throw new RuntimeException("Expected an instance of " + ForkAction.class.getName() + ", but encountered a "
                    + o.getClass().getName());
        }
        fork = (ForkAction) o;

        if (fork.getAsynchronousForkedBehaviours_ForkAction().size() != 1) {
            throw new RuntimeException("Expected a fork with a single (asynchronous) "
                    + ForkedBehaviour.class.getName() + ", but encountered two or more behaviours.");
        }
    }

    @Override
    public String vary(long value) {
        ForkedBehaviour referenceBehaviour = fork.getAsynchronousForkedBehaviours_ForkAction().get(0);
        for (int i = 0; i < value; i++) {
            ForkedBehaviour copy = EcoreHelper.copy(referenceBehaviour);
            copy.setForkAction_ForkedBehaivour(fork);
        }

        return "Replication count = " + value + ": ForkedBehaviour of " + PCMEntityHelper.toString(fork);
    }

}
