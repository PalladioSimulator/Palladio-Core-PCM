package edu.kit.ipd.sdq.eventsim.system.interpreter.state;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;

/**
 * 
 * @author Philipp Merkle
 *
 */
public class ForkedRequestState extends RequestState {

    private IRequestState parentRequestState;

    private ForkedRequestState(UserState usageState, StackContext stoExContext) {
        super(usageState, stoExContext);
    }

    public ForkedRequestState(RequestState requestState, StackContext stoExContext) {
        this(requestState.getUsageState(), stoExContext);
        this.parentRequestState = requestState;
    }

    public IRequestState getParentRequestState() {
        return this.parentRequestState;
    }

    public boolean isForkedRequestState() {
        return true;
    }
    
}
