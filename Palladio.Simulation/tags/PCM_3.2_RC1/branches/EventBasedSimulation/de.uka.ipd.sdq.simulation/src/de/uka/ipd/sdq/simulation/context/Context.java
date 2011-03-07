package de.uka.ipd.sdq.simulation.context;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * Context of a simulated {@link Request}. This context inherits a stack context and enriches it
 * with information on the simulated execution environment.
 * 
 * @author Steffen Becker
 * @author Philipp Merkle
 * 
 */
public abstract class Context extends StackContext {

    private static final long serialVersionUID = 6754941165350670468L;

    protected final EventSimModel model;
    protected final TraversalState<?> state;

    /**
     * Initialise a new context for the given simulation model
     * 
     * @param myModel
     *            The simulation model used in this context
     */
    public Context(final EventSimModel model, final TraversalState<?> state) {
        this.model = model;
        this.state = state;
    }

    // public long getSessionId() {
    // return myThread.getCurrentSessionId();
    // }

    

}
