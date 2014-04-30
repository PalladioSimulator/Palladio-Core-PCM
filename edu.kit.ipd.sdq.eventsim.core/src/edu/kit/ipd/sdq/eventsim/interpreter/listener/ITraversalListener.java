package edu.kit.ipd.sdq.eventsim.interpreter.listener;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;
import edu.kit.ipd.sdq.eventsim.interpreter.BehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.interpreter.state.AbstractInterpreterState;

/**
 * A traversal listener observes subclasses of {@link BehaviourInterpreter} for their traversal
 * progress. Whenever an action is about to be traversed or has been traversed completely, the
 * BehaviourTraversal notifies its observers by calling either the {@code before} or the {@code
 * after} method on the listeners.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are to be traversed
 * @param <E>
 *            the type of the entity whose behaviour is simulated by the traversal
 */
public interface ITraversalListener<A extends Entity, E extends AbstractSimEntityDelegator, F extends AbstractInterpreterState<A>> {

    /**
     * Called by the {@link BehaviourInterpreter} when the specified action is about to be traversed
     * by the given entity.
     * 
     * @param action
     *            the action that is traversed soon
     * @param entity
     *            the entity that traverses the action
     * @param state
     *            the traversal state before traversing the specified action
     */
    public void before(A action, E entity, F state);

    /**
     * Called by the {@link BehaviourInterpreter} when the specified action has been traversed
     * completely by the given entity.
     * 
     * @param action
     *            the action that has been traversed
     * @param entity
     *            the entity that has traversed the action
     * @param state
     *            the traversal state right after the specified action has been traversed and before
     *            the next action is about to be traversed
     */
    public void after(A action, E entity, F state);

}
