package edu.kit.ipd.sdq.eventsim.interpreter.state;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import edu.kit.ipd.sdq.eventsim.entities.User;

/**
 * A stack frame which holds the state of a {@link User} entity.
 * 
 * @author Philipp Merkle
 * 
 * @see UserState
 */
public class UserStateStackFrame extends AbstractStateStackFrame<AbstractUserAction> implements IUserState {

    // currently, there is no additional state information for User entities

    @Override
    public Object clone() throws CloneNotSupportedException {
        // currently, there is no need for cloning stack frames of users
        throw new CloneNotSupportedException();
    }

}
