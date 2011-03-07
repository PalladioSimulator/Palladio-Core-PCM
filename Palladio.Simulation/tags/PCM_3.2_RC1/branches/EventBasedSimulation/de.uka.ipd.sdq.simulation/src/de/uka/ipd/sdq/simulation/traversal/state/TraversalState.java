package de.uka.ipd.sdq.simulation.traversal.state;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

public class TraversalState<A extends Entity> {

    private final TraversalStateStack<A> stack;
    
    public TraversalState() {
        this.stack = new TraversalStateStack<A>();
    }

    public TraversalStateStack<A> getStack() {
        return this.stack;
    }
    
}
