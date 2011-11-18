package de.uka.ipd.sdq.simulation.interpreter.usage;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.interpreter.ITraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.state.UserState;

/**
 * Use this interface for traversal strategies containing the simulation logic for usage actions,
 * i.e. subclasses of {@link AbstractUserAction}.
 * 
 * @author Philipp Merkle
 * 
 * @param <T>
 *            the type of the action that is to be traversed by this strategy
 * 
 * @see ITraversalStrategy
 */
public interface IUsageTraversalStrategy<T extends AbstractUserAction> extends
        ITraversalStrategy<AbstractUserAction, T, User, UserState> {

    // The sole purpose of this interface is to define the type parameters
    // of a usage traversal strategy. Thus, no additional signatures are declared.

}
