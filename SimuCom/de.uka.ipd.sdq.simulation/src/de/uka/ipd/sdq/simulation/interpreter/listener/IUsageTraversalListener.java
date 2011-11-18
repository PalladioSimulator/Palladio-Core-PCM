package de.uka.ipd.sdq.simulation.interpreter.listener;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.interpreter.state.UserState;

/**
 * A usage traversal listener observes a {@link UsageTraversal} for its traversal progress.
 * 
 * @author Philipp Merkle
 * 
 * @see ITraversalListener
 */
public interface IUsageTraversalListener extends ITraversalListener<AbstractUserAction, User, UserState> {

    // The sole purpose of this interface is to define the type parameters
    // of this listener. Thus, no additional signatures are declared.
}
