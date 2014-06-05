package edu.kit.ipd.sdq.eventsim.interpreter.usage;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;

/**
 * @author Philipp Merkle
 * 
 * @see ITraversalInstruction
 */
public interface IUsageTraversalInstruction extends ITraversalInstruction<AbstractUserAction, UserState> {

    // The sole purpose of this interface is to define the type parameters
    // of a usage traversal instruction. Thus, no additional signatures are declared.

}
