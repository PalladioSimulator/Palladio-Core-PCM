package de.uka.ipd.sdq.simulation.traversal.state;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.traversal.BehaviourTraversal;

/**
 * Encapsulates the state of traversals conducted by subclasses of {@link BehaviourTraversal}. The
 * traversal state is encapsulated by a {@link TraversalStateStack} comprising
 * {@link TraversalStackFrame}s.
 * <p>
 * The traversal state also carries a {@link StackContext}, which is used to evaluate stochastic
 * expressions (StoEx) in the context of the present state, and therefore called the StoEx context.
 * In order to evaluate stochastic expressions or to modify this context, use the {@code
 * getStoExContext()} method.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are to be traversed
 */
public class TraversalState<A extends Entity> implements Cloneable {

    private final StackContext stoExContext;
    private TraversalStateStack<A> stack;
    private TraversalState<? extends Entity> parentState;

    /**
     * Creates an empty traversal state that uses the specified StoEx context.
     * 
     * @param stoExContext
     *            the initial StoEx context
     */
    public TraversalState(StackContext stoExContext) {
        this.stack = new TraversalStateStack<A>();
        this.stoExContext = stoExContext;
    }

    /**
     * Creates an empty traversal state with a reference to the specified parent state. The
     * traversal state is created with the specified initial StoEx context.
     * 
     * @param stoExContext
     *            the initial StoEx context
     * @param parent
     *            the parent traversal state
     */
    public TraversalState(StackContext stoExContext, TraversalState<? extends Entity> parent) {
        this(stoExContext);
        this.parentState = parent;
    }

    /**
     * Returns the stack comprising {@link TraversalStackFrame}s.
     * 
     * @return the stack
     */
    public TraversalStateStack<A> getStack() {
        return this.stack;
    }

    /**
     * Returns the state of the parent {@link BehaviourTraversal}, if there is one.
     * 
     * @return the parent state, if existing; null else
     */
    public TraversalState<? extends Entity> getParentState() {
        return parentState;
    }

    /**
     * Returns the context that is used to evaluate stochastic expressions (StoEx). The context
     * comprises a stack that contains the local variables of service calls. While traversing a
     * {@link UsageScenario} or a {@link ResourceDemandingSEFF}, the stack content changes according
     * to the traversal progress.
     * 
     * @return the context providing the evaluation of stochastic expressions
     */
    public StackContext getStoExContext() {
        return this.stoExContext;
    }

    /**
     * TODO is this method really needed?
     * 
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() throws CloneNotSupportedException {
        StackContext ctx = new StackContext();
        ctx.getStack().pushStackFrame(stoExContext.getStack().currentStackFrame().copyFrame());
        TraversalState<A> copy = null;
        if (parentState != null) {
            TraversalState<? extends Entity> parentStateCopy = (TraversalState<? extends Entity>) parentState.clone();
            copy = new TraversalState<A>(ctx, parentStateCopy);
        } else {
            copy = new TraversalState<A>(ctx);
        }
        copy.stack = (TraversalStateStack<A>) this.stack.clone();
        return copy;
    }

}
