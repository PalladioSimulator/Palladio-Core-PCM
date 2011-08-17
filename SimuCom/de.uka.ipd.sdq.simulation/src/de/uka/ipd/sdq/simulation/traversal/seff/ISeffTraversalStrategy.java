package de.uka.ipd.sdq.simulation.traversal.seff;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.ITraversalStrategy;

/**
 * Use this interface for traversal strategies containing the simulation logic for SEFF actions,
 * i.e. subclasses of {@link AbstractAction}.
 * 
 * @author Philipp Merkle
 * 
 * @param <T>
 *            the type of the action that is to be traversed by this strategy
 * 
 * @see ITraversalStrategy
 */
public interface ISeffTraversalStrategy<T extends AbstractAction> extends
        ITraversalStrategy<AbstractAction, T, Request> {

    // The sole purpose of this interface is to define the type parameters
    // of a SEFF traversal strategy. Thus, no additional signatures are declared.

}
