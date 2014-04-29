package edu.kit.ipd.sdq.eventsim.interpreter.state;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import edu.kit.ipd.sdq.eventsim.interpreter.BehaviourInterpreter;

/**
 * This interface specifies which state information can be set and returned to describe the progress
 * of an {@link BehaviourInterpreter}.
 * 
 * @author Philipp Merkle
 * 
 */
public interface IInterpreterState<A extends Entity> {

    /**
     * Stores the given state for the specified action.
     * 
     * @param action
     *            the action with which the state is to be associated
     * @param state
     *            the internal state
     */
    public void addInternalState(final A action, final ITraversalStrategyState state);

    /**
     * Returns the internal state associated with the specified action.
     * 
     * @param action
     *            the action whose associated state is to be returned
     * @return the internal state
     */
    public ITraversalStrategyState getInternalState(final A action);

    /**
     * Returns the current position of the traversal.
     * 
     * @return the action that is being traversed currently
     */
    public A getCurrentPosition();

    /**
     * Sets the current position of the traversal.
     * 
     * @param position
     *            the action that is being traversed currently
     */
    public void setCurrentPosition(final A position);

    /**
     * Returns the previous position of the traversal.
     * 
     * @return the action that has been traversed before the current action
     */
    public A getPreviousPosition();

    /**
     * Sets the previous position of the traversal.
     * 
     * @param previousPosition
     *            the action that has been traversed before the current action
     */
    public void setPreviousPosition(final A previousPosition);

    /**
     * Adds the specified action to a queue of actions that has been traversed completely.
     * 
     * @param action
     *            the action that is to be added to the queue
     */
    public void enqueueFinishedAction(final A action);

    /**
     * Returns and removes the head of the queue. The actions are dequeued in the same order in
     * which they have been enqueued.
     * 
     * @return the action at the head of the queue
     */
    public A dequeueFinishedAction();

    /**
     * Returns whether there are elements in the queue of finished actions.
     * 
     * @return true, if there are actions in the queue that has not yet been dequeued; false else
     */
    public boolean hasFinishedActions();

}
