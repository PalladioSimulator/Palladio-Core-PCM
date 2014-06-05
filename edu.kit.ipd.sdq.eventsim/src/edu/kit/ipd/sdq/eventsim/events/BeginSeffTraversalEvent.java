package edu.kit.ipd.sdq.eventsim.events;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.staticstructure.ComponentInstance;

/**
 * Schedule this event to begin the traversal of a {@link ResourceDemandingSEFF} (RD-SEFF).
 * <p>
 * The {@link Request} that is supposed to traverse the SEFF, is passed to the {@code schedule()}
 * method.
 * 
 * @author Philipp Merkle
 * 
 */
public class BeginSeffTraversalEvent extends AbstractSimEventDelegator<Request> {

    private final ComponentInstance component;
    private final OperationSignature signature;
    private final UserState parentState;

    /**
     * Use this constructor to begin the traversal of the RD-SEFF provided by the specified {@code
     * component}. The {@code signature} specifies which SEFF is to be used, as a component may
     * contain a SEFF for each provided signature.
     * 
     * @param model
     *            the model
     * @param component
     *            the component providing the SEFF
     * @param signature
     *            the signature whose SEFF is to be traversed
     * @param parentState
     *            the state of the usage traversal
     */
    public BeginSeffTraversalEvent(final EventSimModel model, final ComponentInstance component,
            final OperationSignature signature, UserState parentState) {
        super(model, "BeginUsageTraversalEvent");
        this.component = component;
        this.signature = signature;
        this.parentState = parentState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final Request who) {
        SeffBehaviourInterpreter interpreter = who.getModel().getSeffInterpreter();
        interpreter.beginTraversal(who, this.component, this.signature, this.parentState);
    }

}
