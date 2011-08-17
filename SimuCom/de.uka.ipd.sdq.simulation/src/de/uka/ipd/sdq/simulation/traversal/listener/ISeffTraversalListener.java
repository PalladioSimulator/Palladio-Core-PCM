package de.uka.ipd.sdq.simulation.traversal.listener;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.seff.SeffTraversal;

/**
 * A SEFF traversal listener observes a {@link SeffTraversal} for its traversal progress.
 * 
 * @author Philipp Merkle
 * 
 * @see ITraversalListener
 */
public interface ISeffTraversalListener extends ITraversalListener<AbstractAction, Request> {

    // The sole purpose of this interface is to define the type parameters
    // of this listener. Thus, no additional signatures are declared.

}
