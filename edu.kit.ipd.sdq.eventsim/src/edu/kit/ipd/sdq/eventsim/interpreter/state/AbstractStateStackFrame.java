package edu.kit.ipd.sdq.eventsim.interpreter.state;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * A stack frame which holds information of the traversal progress.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are to be traversed
 * @see AbstractInterpreterState
 */
public abstract class AbstractStateStackFrame<A extends Entity> implements IInterpreterState<A>, Cloneable {

    /**
     * maps actions to internal states of traversal strategies. Traversal strategies that need to
     * traverse an action repeatedly can use this data structure to store state information
     * regarding this action.
     */
    protected Map<A, ITraversalStrategyState> internalStatesMap;
    protected Queue<A> finishedActionsQueue;
    protected A currentPosition;
    protected A previousPosition;

    public AbstractStateStackFrame() {
        this.internalStatesMap = new HashMap<A, ITraversalStrategyState>();
        this.finishedActionsQueue = new LinkedList<A>();
    }

    @Override
    public void addInternalState(final A action, final ITraversalStrategyState state) {
        this.internalStatesMap.put(action, state);
    }

    @Override
    public ITraversalStrategyState getInternalState(final A action) {
        return this.internalStatesMap.get(action);
    }

    @Override
    public A getCurrentPosition() {
        return this.currentPosition;
    }

    @Override
    public void setCurrentPosition(final A position) {
        this.currentPosition = position;
    }

    @Override
    public A getPreviousPosition() {
        return this.previousPosition;
    }

    @Override
    public void setPreviousPosition(final A previousPosition) {
        this.previousPosition = previousPosition;
    }

    @Override
    public void enqueueFinishedAction(final A action) {
        this.finishedActionsQueue.add(action);
    }

    @Override
    public A dequeueFinishedAction() {
        return this.finishedActionsQueue.poll();
    }

    @Override
    public boolean hasFinishedActions() {
        return !this.finishedActionsQueue.isEmpty();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract Object clone() throws CloneNotSupportedException;
    
    /**
     * @param <T> 
     * @param stackFrame an empty stack frame, which is to be filled
     * @return
     */
    public <T extends AbstractStateStackFrame<A>> T clone(final T stackFrame)
    {
        T copy = stackFrame;
        
        // copy internal states map
        for (Entry<A, ITraversalStrategyState> entry : this.internalStatesMap.entrySet()) {
            // TODO clone map value as well?
            copy.internalStatesMap.put(entry.getKey(), entry.getValue());
        }

        // copy finished actions queue
        copy.finishedActionsQueue.addAll(this.finishedActionsQueue);
        
        copy.currentPosition = this.currentPosition;
        copy.previousPosition = this.previousPosition;

        return copy;
    }
    
}
