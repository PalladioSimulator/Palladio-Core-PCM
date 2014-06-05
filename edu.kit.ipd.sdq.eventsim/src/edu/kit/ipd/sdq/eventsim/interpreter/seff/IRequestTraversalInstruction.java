package edu.kit.ipd.sdq.eventsim.interpreter.seff;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;

/**
 * @author Philipp Merkle
 * 
 * @see ITraversalInstruction
 */
public interface IRequestTraversalInstruction extends ITraversalInstruction<AbstractAction, RequestState> {

    // The sole purpose of this interface is to define the type parameters
    // of a request traversal instruction. Thus, no additional signatures are declared.

}
