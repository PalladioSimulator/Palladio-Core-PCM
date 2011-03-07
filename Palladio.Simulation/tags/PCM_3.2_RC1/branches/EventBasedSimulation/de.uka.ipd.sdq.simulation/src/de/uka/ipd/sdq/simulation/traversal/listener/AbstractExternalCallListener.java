package de.uka.ipd.sdq.simulation.traversal.listener;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.simulation.SimulatedComponentInstance;
import de.uka.ipd.sdq.simulation.entities.Request;

/**
 * This abstract class eases the implementation an {@link ITraversalListener} that is supposed to
 * listen for traversal events regarding {@link ExternalCallAction}s. It searches for the component
 * instance, from which the external call is originating, and passes this component instance to the
 * event handling methods.
 * 
 * @author Philipp Merkle
 * 
 */
public abstract class AbstractExternalCallListener implements ISeffTraversalListener {

    @Override
    public void before(AbstractAction action, Request who) {
        ExternalCallAction call = castToExternalCallActionOrThrowException(action);
        SimulatedComponentInstance component = who.getTraversalState().getStack().currentScope().getComponent();
        before(call, who, component);
    }

    @Override
    public void after(AbstractAction action, Request who) {
        ExternalCallAction call = castToExternalCallActionOrThrowException(action);
        SimulatedComponentInstance component = who.getTraversalState().getStack().currentScope().getComponent();
        after(call, who, component);
    }

    private ExternalCallAction castToExternalCallActionOrThrowException(AbstractAction action) {
        try {
            return (ExternalCallAction) action;
        } catch (ClassCastException ex) {
            throw new RuntimeException(
                    "This traversal listener may only be registered to listen for ExternalCallAction events, "
                            + "but an event originating from a " + action.eClass().getName() + " has been encountered.");
        }
    }

    public abstract void before(ExternalCallAction call, Request who, SimulatedComponentInstance callingComponent);

    public abstract void after(ExternalCallAction call, Request who, SimulatedComponentInstance callingComponent);

}
