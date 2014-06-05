package edu.kit.ipd.sdq.eventsim.interpreter.state;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * 
 * @author Philipp Merkle
 *
 */
public class ForkedRequestState extends RequestState {

    private RequestState parentRequestState;

    private ForkedRequestState(UserState usageState, StackContext stoExContext) {
        super(usageState, stoExContext);
    }

    public ForkedRequestState(RequestState requestState, StackContext stoExContext) {
        this(requestState.getUsageState(), stoExContext);
        this.parentRequestState = requestState;
    }

    public RequestState getParentRequestState() {
        return this.parentRequestState;
    }

    public boolean isForkedRequestState() {
        return true;
    }
    
}
