package edu.kit.ipd.sdq.eventsim.interpreter.state;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import edu.kit.ipd.sdq.eventsim.staticstructure.ComponentInstance;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;

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

    @Override
    public RequestStateStackFrame clone() throws CloneNotSupportedException {
        RequestStateStackFrame copy = new RequestStateStackFrame();
        super.clone(copy);
        copy.component = this.component;
        return copy;
    }

}
