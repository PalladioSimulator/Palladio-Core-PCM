package de.uka.ipd.sdq.simulation.interpreter.listener;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.interpreter.seff.SeffBehaviourInterpreter;
import de.uka.ipd.sdq.simulation.interpreter.state.RequestState;

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
