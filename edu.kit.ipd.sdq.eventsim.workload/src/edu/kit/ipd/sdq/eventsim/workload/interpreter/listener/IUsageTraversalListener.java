package edu.kit.ipd.sdq.eventsim.workload.interpreter.listener;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ITraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;

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
