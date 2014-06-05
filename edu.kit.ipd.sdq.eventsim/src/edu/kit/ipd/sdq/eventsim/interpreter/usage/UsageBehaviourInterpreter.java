package edu.kit.ipd.sdq.eventsim.interpreter.usage;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.command.usage.FindActionInUsageBehaviour;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.BehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.IUsageTraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;

/**
 * An interpreter for {@link UsageScenario}s.
 * 
 * @author Philipp Merkle
 * 
 * @see BehaviourInterpreter
 */
public class UsageBehaviourInterpreter extends BehaviourInterpreter<AbstractUserAction, User, UserState> {

    private static final Logger logger = Logger.getLogger(UsageBehaviourInterpreter.class);

    private UsageInterpreterConfiguration configuration;

    public UsageBehaviourInterpreter(UsageInterpreterConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * {@inheritDoc}
     */
    public void beginTraversal(final User user, final ScenarioBehaviour behaviour) {
        user.notifyEnteredSystem();

        // initialise traversal state and StoEx context
        UserState state = new UserState();
        state.pushStackFrame();
        state.getStoExContext().getStack().createAndPushNewStackFrame();

        // find start action
        final EventSimModel model = user.getModel();
        final Start start = model.execute(new FindActionInUsageBehaviour<Start>(behaviour, Start.class));

        // begin traversal
        state.setCurrentPosition(start);
        this.traverse(user, start, state);
    }

    /**
     * {@inheritDoc}
     */
    public void resumeTraversal(final User user, final UserState state) {
        // find next action and resume traversal
        super.traverse(user, state.getCurrentPosition(), state);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public IUsageTraversalStrategy<? extends AbstractUserAction> loadTraversalStrategy(final EClass eclass) {
        return this.configuration.getHandlerMap().get(eclass);
    }

    @Override
    public UsageInterpreterConfiguration getConfiguration() {
        return this.configuration;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyAfterListener(final AbstractUserAction action, final User user, UserState state) {
        for (final IUsageTraversalListener l : this.configuration.getTraversalListenerList()) {
            l.after(action, user, state);
        }
        final List<IUsageTraversalListener> listeners = this.configuration.getTraversalListenerMap().get(action);
        if (listeners != null) {
            for (final IUsageTraversalListener l : listeners) {
                l.after(action, user, state);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyBeforeListener(final AbstractUserAction action, final User user, UserState state) {
        for (final IUsageTraversalListener l : this.configuration.getTraversalListenerList()) {
            l.before(action, user, state);
        }
        final List<IUsageTraversalListener> listeners = this.configuration.getTraversalListenerMap().get(action);
        if (listeners != null) {
            for (final IUsageTraversalListener l : listeners) {
                l.before(action, user, state);
            }
        }
    }

}
