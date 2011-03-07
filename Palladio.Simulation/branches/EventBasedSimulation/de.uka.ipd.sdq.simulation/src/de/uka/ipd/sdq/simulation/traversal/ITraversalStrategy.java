package de.uka.ipd.sdq.simulation.traversal;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.entities.EventSimEntity;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public interface ITraversalStrategy<T extends Entity, A extends T, E extends EventSimEntity> {

    /**
     * 
     * @param action
     * @param user
     * @param state
     *            may be null, if there is no state (yet)
     * @return
     */
    public ITraversalInstruction<T> traverse(A action, E entity, TraversalState<T> state);

}
