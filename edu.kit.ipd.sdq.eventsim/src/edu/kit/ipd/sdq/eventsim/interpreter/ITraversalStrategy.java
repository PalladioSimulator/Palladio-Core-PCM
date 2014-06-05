package edu.kit.ipd.sdq.eventsim.interpreter;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.interpreter.state.AbstractInterpreterState;

/**
 * A traversal strategy contains the simulation logic for a specific action type. Whenever the
 * {@link BehaviourInterpreter} encounters an action of this specific type, it delegates the
 * execution to the suitable traversal strategy. The strategy then handles the action by simulating
 * the effect on the system under simulation. When finished, the traversal strategy returns the
 * execution to the {@link BehaviourInterpreter} together with an instruction on how to proceed the
 * traversal.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are to be traversed
 * @param <T>
 *            the type of the action that is to be traversed by this strategy
 * @param <E>
 *            the type of the entity that initiates the traversal
 * @param <S>
 *            TODO
 */
public interface ITraversalStrategy<A extends Entity, T extends A, E extends EventSimEntity, S extends AbstractInterpreterState<A>> {

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
     * @return an instruction on how to proceed the traversal
     */
    public ITraversalInstruction<A, S> traverse(T action, E entity, S state);

}
