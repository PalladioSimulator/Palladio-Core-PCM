package de.uka.ipd.sdq.simulation.interpreter.state;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;

/**
 * A stack frame which holds the state of a {@link Request} entity.
 * 
 * @author Philipp Merkle
 * 
 * @see AbstractInterpreterState
 */
public class RequestStateStackFrame extends AbstractStateStackFrame<AbstractAction> implements IRequestState {

    private ComponentInstance component;

    /**
     * {@inheritDoc}
     */
    @Override
    public ComponentInstance getComponent() {
        return component;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setComponent(ComponentInstance component) {
        this.component = component;
    }

}
