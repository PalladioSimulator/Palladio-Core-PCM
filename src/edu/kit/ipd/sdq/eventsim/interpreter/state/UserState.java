package edu.kit.ipd.sdq.eventsim.interpreter.state;

import java.util.Stack;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * This class holds the state of a {@link User}. The state is organised as a stack of
 * {@link UserStateStackFrame}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class UserState extends AbstractInterpreterState<AbstractUserAction> implements IUserState {

    private static final Logger logger = Logger.getLogger(UserState.class);
    
    private final Stack<UserStateStackFrame> stack;
    private final StackContext stoExContext;

    public UserState() {
        this.stack = new Stack<UserStateStackFrame>();
        this.stoExContext = new StackContext();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pushStackFrame() {
        if(logger.isDebugEnabled()) {
            logger.debug("Entering scope");
        }
        final UserStateStackFrame f = new UserStateStackFrame();
        this.stack.push(f);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void popStackFrame() {
        if(logger.isDebugEnabled()) {
            logger.debug("Leaving scope");
        }
        assert !this.stack.isEmpty() : "Tried to leave scope but there is no outer scope";
        this.stack.pop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasOpenScope() {
        return this.stack.size() > 1;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return !this.stack.isEmpty();   
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addInternalState(final AbstractUserAction action, final ITraversalStrategyState state) {
        this.stack.peek().addInternalState(action, state);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractUserAction dequeueFinishedAction() {
        return this.stack.peek().dequeueFinishedAction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enqueueFinishedAction(final AbstractUserAction action) {
        this.stack.peek().enqueueFinishedAction(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractUserAction getCurrentPosition() {
        return this.stack.peek().getCurrentPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalStrategyState getInternalState(final AbstractUserAction action) {
        return this.stack.peek().getInternalState(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractUserAction getPreviousPosition() {
        return this.stack.peek().getPreviousPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasFinishedActions() {
        return this.stack.peek().hasFinishedActions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrentPosition(final AbstractUserAction position) {
        this.stack.peek().setCurrentPosition(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPreviousPosition(final AbstractUserAction previousPosition) {
        this.stack.peek().setPreviousPosition(previousPosition);
    }

    /**
     * Returns the context that is used to evaluate stochastic expressions (StoEx). The context
     * comprises a stack that contains the local variables of service calls. While traversing a
     * {@link UsageScenario}, the stack content changes according to the traversal progress.
     * 
     * @return the evaluation context for stochastic expressions
     */
    public StackContext getStoExContext() {
        return this.stoExContext;
    }

}
