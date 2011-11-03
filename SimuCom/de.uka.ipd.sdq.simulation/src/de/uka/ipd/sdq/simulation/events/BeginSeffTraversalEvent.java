package de.uka.ipd.sdq.simulation.events;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;
import de.uka.ipd.sdq.simulation.traversal.seff.SeffTraversal;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * Schedule this event to begin the traversal of a {@link ResourceDemandingSEFF} (RD-SEFF).
 * <p>
 * The {@link Request} that is supposed to traverse the SEFF, is passed to the {@code schedule()}
 * method.
 * 
 * @author Philipp Merkle
 * 
 */
public class BeginSeffTraversalEvent extends AbstractSimEvent<EventSimModel, Request> {

    private final ComponentInstance component;
    private final OperationSignature signature;
    private final TraversalState<AbstractUserAction> parentState;

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
            final OperationSignature signature, TraversalState<AbstractUserAction> parentState) {
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
        new SeffTraversal(who).beginTraversal(this.component, this.signature, this.parentState);
    }

}
