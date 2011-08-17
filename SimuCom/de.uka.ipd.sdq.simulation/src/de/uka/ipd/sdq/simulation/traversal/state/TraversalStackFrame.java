package de.uka.ipd.sdq.simulation.traversal.state;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;

/**
 * Comprises various traversal state information.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are to be traversed
 * @see TraversalStateStack
 */
public class TraversalStackFrame<A extends Entity> implements Cloneable {

    /**
     * maps actions to internal states of traversal strategies. Traversal strategies that need to
     * traverse an action repeatedly can use this data structure to store state information
     * regarding this action.
     */
    private final Map<A, ITraversalStrategyState> internalStatesMap;
    private final Queue<A> finishedActionsQueue;
    private A currentPosition;
    private A previousPosition;
    private ComponentInstance component;

    /**
     * Constructs an empty stack frame.
     */
    public TraversalStackFrame() {
        this.internalStatesMap = new HashMap<A, ITraversalStrategyState>();
        this.finishedActionsQueue = new LinkedList<A>();
    }

    /**
     * Annotates the specified action with the given internal state.
     * 
     * @param action
     *            the action with which the state is to be associated
     * @param state
     *            the internal state
     */
    public void addInternalState(final A action, final ITraversalStrategyState state) {
        this.internalStatesMap.put(action, state);
    }

    /**
     * Returns the internal state associated with the specified action.
     * 
     * @param action
     *            the action whose associated state is to be returned
     * @return the internal state
     */
    public ITraversalStrategyState getInternalState(final A action) {
        return this.internalStatesMap.get(action);
    }

    /**
     * Returns the current position of the traversal.
     * 
     * @return the action that is being traversed currently
     */
    public A getCurrentPosition() {
        return this.currentPosition;
    }

    /**
     * Sets the current position of the traversal.
     * 
     * @param position
     *            the action that is being traversed currently
     */
    public void setCurrentPosition(final A position) {
        this.currentPosition = position;
    }

    /**
     * Returns the previous position of the traversal.
     * 
     * @return the action that has been traversed before the current action
     */
    public A getPreviousPosition() {
        return this.previousPosition;
    }

    /**
     * Sets the previous position of the traversal.
     * 
     * @param previousPosition
     *            the action that has been traversed before the current action
     */
    public void setPreviousPosition(final A previousPosition) {
        this.previousPosition = previousPosition;
    }

    /**
     * Adds the specified action to a queue of actions that has been traversed completely.
     * 
     * @param action
     *            the action that is to be added to the queue
     */
    public void enqueueFinishedAction(final A action) {
        this.finishedActionsQueue.add(action);
    }

    /**
     * Returns and removes the head of the queue. The actions are dequeued in the same order in
     * which they have been enqueued.
     * 
     * @return the action at the head of the queue
     */
    public A dequeueFinishedAction() {
        return this.finishedActionsQueue.poll();
    }

    /**
     * Returns whether there are elements in the queue of finished actions.
     * 
     * @return true, if there are actions in the queue that has not yet been dequeued; false else
     */
    public boolean hasFinishedActions() {
        return !this.finishedActionsQueue.isEmpty();
    }

    /**
     * Returns the component that provides the SEFF that is being traversed in the current scope.
     * 
     * @return the providing component
     */
    public ComponentInstance getComponent() {
        return component;
    }

    /**
     * Sets the component that provides the SEFF that is being traversed in the current scope. If no
     * SEFF is being traversed, the component should not be set.
     * 
     * @param component
     *            the providing component
     */
    public void setComponent(ComponentInstance component) {
        this.component = component;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        TraversalStackFrame<A> copy = new TraversalStackFrame<A>();
        // copy internal states map
        for (Entry<A, ITraversalStrategyState> entry : this.internalStatesMap.entrySet()) {
            // TODO clone map value as well?
            copy.internalStatesMap.put(entry.getKey(), entry.getValue());
        }

        // copy finished actions queue
        copy.finishedActionsQueue.addAll(this.finishedActionsQueue);

        copy.currentPosition = this.currentPosition;
        copy.previousPosition = this.previousPosition;
        copy.component = this.component;

        return copy;
    }

}
