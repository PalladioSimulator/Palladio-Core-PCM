package de.uka.ipd.sdq.simulation.traversal;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.entities.EventSimEntity;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * A traversal strategy contains the simulation logic for a specific action type. Whenever the
 * {@link BehaviourTraversal} encounters an action of this specific type, it delegates the execution
 * to the suitable traversal strategy. The strategy then handles the action by simulating the effect
 * on the system under simulation. When finished, the traversal strategy returns the execution to
 * the {@link BehaviourTraversal} together with an instruction on how to proceed the traversal.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are to be traversed
 * @param <T>
 *            the type of the action that is to be traversed by this strategy
 * @param <E>
 *            the type of the entity that initiates the traversal
 */
public interface ITraversalStrategy<A extends Entity, T extends A, E extends EventSimEntity> {

    /**
     * Executes the simulation logic associated with the specified action. When finished, an
     * instruction has to be returned containing information on how to proceed the traversal.
     * 
     * @param action
     *            the action that is to be simulated
     * @param entity
     *            the entity that has initiated the traversal
     * @param state
     *            the traversal state
     * @return the instruction on how to proceed the traversal
     */
    public ITraversalInstruction<A> traverse(T action, E entity, TraversalState<A> state);

}
