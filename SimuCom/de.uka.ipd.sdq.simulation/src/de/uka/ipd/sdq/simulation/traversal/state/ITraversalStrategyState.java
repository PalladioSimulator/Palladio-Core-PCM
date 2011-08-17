package de.uka.ipd.sdq.simulation.traversal.state;

import de.uka.ipd.sdq.simulation.traversal.ITraversalStrategy;

/**
 * A marker interface for classes storing the internal state of an {@link ITraversalStrategy}.
 * Traversal strategies that need to store their state on the {@link TraversalStateStack} implement
 * this interface to be able to store their state in a {@link TraversalStackFrame}.
 * 
 * @author Philipp Merkle
 * 
 */
public interface ITraversalStrategyState {

    // a marker interface is not supposed to declare method signatures

}
