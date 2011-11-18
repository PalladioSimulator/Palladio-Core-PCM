package de.uka.ipd.sdq.simulation.traversal.seff;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.state.RequestState;

/**
 * @author Philipp Merkle
 * 
 * @see ITraversalInstruction
 */
public interface IRequestTraversalInstruction extends ITraversalInstruction<AbstractAction, RequestState> {

    // The sole purpose of this interface is to define the type parameters
    // of a request traversal instruction. Thus, no additional signatures are declared.

}
