package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.traversal.ITraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * Traversal instructions are used to provide a means to the {@link ITraversalStrategy} to express
 * their knowledge of how the traversal is supposed to continue.
 * 
 * @author Philipp Merkle
 * 
 * @param <T>
 */
public interface ITraversalInstruction<T extends Entity> {

    /**
     * Processes the traversal instruction. Results are provided in two ways. 1) the method returns
     * the next action with which the traversal is supposed to continue and 2) the method can change
     * the traversal context, influencing the way of traversal.
     * 
     * TODO more detailed
     * 
     * @param context
     * @return the next action that is to be processed
     */
    public T process(TraversalState<T> context);

}
