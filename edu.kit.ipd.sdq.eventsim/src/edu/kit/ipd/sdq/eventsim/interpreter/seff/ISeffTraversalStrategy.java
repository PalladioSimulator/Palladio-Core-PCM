package edu.kit.ipd.sdq.eventsim.interpreter.seff;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;

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
        ITraversalStrategy<AbstractAction, T, Request, RequestState> {

    // The sole purpose of this interface is to define the type parameters
    // of a SEFF traversal strategy. Thus, no additional signatures are declared.
    
}
