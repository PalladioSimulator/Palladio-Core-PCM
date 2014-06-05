package edu.kit.ipd.sdq.eventsim.interpreter.state;

import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;

/**
 * A marker interface for classes storing the internal state of an {@link ITraversalStrategy}.
 * Traversal strategies that need to store their state on the {@link TraversalStateStack} implement
 * this interface to be able to store their state in an {@link AbstractStateStackFrame}.
 * 
 * @author Philipp Merkle
 * 
 */
public interface ITraversalStrategyState {

    // a marker interface is not supposed to declare method signatures

}
