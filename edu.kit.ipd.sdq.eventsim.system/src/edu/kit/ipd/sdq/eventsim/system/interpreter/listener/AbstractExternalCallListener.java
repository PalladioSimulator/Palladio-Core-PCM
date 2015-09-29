package edu.kit.ipd.sdq.eventsim.system.interpreter.listener;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ExternalCallAction;

import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ITraversalListener;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.ComponentInstance;

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
            RequestState state);

    /**
     * @see #after(AbstractAction, Request, TraversalState)
     */
    public abstract void after(ExternalCallAction call, Request request, ComponentInstance callingComponent,
            RequestState state);

    /**
     * {@inheritDoc}
     */
    @Override
    public void before(AbstractAction action, Request request, RequestState state) {
        ExternalCallAction call = castToExternalCallActionOrThrowException(action);
        ComponentInstance component = state.getComponent();
        before(call, request, component, state);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void after(AbstractAction action, Request request, RequestState state) {
        ExternalCallAction call = castToExternalCallActionOrThrowException(action);
        ComponentInstance component = state.getComponent();
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
