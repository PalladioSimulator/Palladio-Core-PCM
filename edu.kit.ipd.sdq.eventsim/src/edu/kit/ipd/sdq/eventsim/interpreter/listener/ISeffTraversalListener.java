package edu.kit.ipd.sdq.eventsim.interpreter.listener;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;

/**
 * A SEFF traversal listener observes a {@link SeffBehaviourInterpreter} for its traversal progress.
 * 
 * @author Philipp Merkle
 * 
 * @see ITraversalListener
 */
public interface ISeffTraversalListener extends ITraversalListener<AbstractAction, Request, RequestState> {

    // The sole purpose of this interface is to define the type parameters
    // of this listener. Thus, no additional signatures are declared.

}
