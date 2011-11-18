package de.uka.ipd.sdq.simulation.traversal.usage;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.state.UserState;

/**
 * @author Philipp Merkle
 * 
 * @see ITraversalInstruction
 */
public interface IUsageTraversalInstruction extends ITraversalInstruction<AbstractUserAction, UserState> {

    // The sole purpose of this interface is to define the type parameters
    // of a usage traversal instruction. Thus, no additional signatures are declared.

}
