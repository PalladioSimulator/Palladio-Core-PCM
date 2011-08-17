package de.uka.ipd.sdq.simulation.traversal.listener;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.exceptions.unchecked.EventSimException;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * This abstract class eases the implementation of an {@link ITraversalListener} which is supposed
 * to listen for traversal events regarding {@link ExternalCallAction}s. It searches for the
 * component instance, from which the external call is originating, and passes this component
 * instance to the event handling methods.
 * 
 * @author Philipp Merkle
 * 
 */
public abstract class AbstractExternalCallListener implements ISeffTraversalListener {

    /**
     * @see #before(AbstractAction, Request, TraversalState)
     */
    public abstract void before(ExternalCallAction call, Request request, ComponentInstance callingComponent,
            TraversalState<AbstractAction> state);

    /**
     * @see #after(AbstractAction, Request, TraversalState)
     */
    public abstract void after(ExternalCallAction call, Request request, ComponentInstance callingComponent,
            TraversalState<AbstractAction> state);

    /**
     * {@inheritDoc}
     */
    @Override
    public void before(AbstractAction action, Request request, TraversalState<AbstractAction> state) {
        ExternalCallAction call = castToExternalCallActionOrThrowException(action);
        ComponentInstance component = state.getStack().currentScope().getComponent();
        before(call, request, component, state);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void after(AbstractAction action, Request request, TraversalState<AbstractAction> state) {
        ExternalCallAction call = castToExternalCallActionOrThrowException(action);
        ComponentInstance component = state.getStack().currentScope().getComponent();
        after(call, request, component, state);
    }

    /**
     * Tries to cast the specified action to {@link ExternalCallAction}.
     * 
     * @param action
     *            the action
     * @return the ExternalCallAction if the cast is valid; otherwise an exception is thrown
     * @throws EventSimException
     *             if the cast is not valid
     */
    private ExternalCallAction castToExternalCallActionOrThrowException(AbstractAction action) {
        try {
            return (ExternalCallAction) action;
        } catch (ClassCastException ex) {
            throw new EventSimException(
                    "This traversal listener may only be registered to listen for ExternalCallAction events, "
                            + "but an event originating from a " + action.eClass().getName() + " has been encountered.");
        }
    }

}
