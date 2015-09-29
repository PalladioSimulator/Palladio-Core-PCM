package edu.kit.ipd.sdq.eventsim.exceptions.unchecked;

import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;

import edu.kit.ipd.sdq.eventsim.exceptions.UncheckedSimulationException;

/**
 * This exception indicates a problem while traversing the actions of a {@link ScenarioBehaviour} or
 * a {@link ResourceDemandingBehaviour}.
 * 
 * @author Philipp Merkle
 * 
 */
public class TraversalException extends UncheckedSimulationException {

    private static final long serialVersionUID = 3436608203944313127L;
    private static final String MESSAGE_PREFIX = "Failure while traversing";

    public TraversalException() {
        super();
    }

    public TraversalException(String message) {
        super(MESSAGE_PREFIX + ": " + message);
    }

}
