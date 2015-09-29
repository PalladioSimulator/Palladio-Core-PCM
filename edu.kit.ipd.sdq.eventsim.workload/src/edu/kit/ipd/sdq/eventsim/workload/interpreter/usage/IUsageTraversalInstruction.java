package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;

import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;

/**
 * @author Philipp Merkle
 * 
 * @see ITraversalInstruction
 */
public interface IUsageTraversalInstruction extends ITraversalInstruction<AbstractUserAction, UserState> {

    // The sole purpose of this interface is to define the type parameters
    // of a usage traversal instruction. Thus, no additional signatures are declared.

}
