package de.uka.ipd.sdq.simulation.interpreter.state;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simulation.entities.User;

/**
 * A stack frame which holds the state of a {@link User} entity.
 * 
 * @author Philipp Merkle
 * 
 * @see UserState
 */
public class UserStateStackFrame extends AbstractStateStackFrame<AbstractUserAction> implements IUserState {

    // currently, there is no additional state information for User entities

}
