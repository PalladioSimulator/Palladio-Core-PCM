package de.uka.ipd.sdq.simulation.traversal.usage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.command.usage.FindActionInUsageBehaviour;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.BehaviourInterpreter;
import de.uka.ipd.sdq.simulation.traversal.listener.IUsageTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.state.UserState;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.BranchTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.DelayTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.EntryLevelSystemCallTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.LoopTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.StartTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.StopTraversalStrategy;

/**
 * An interpreter for {@link UsageScenario}s.
 * 
 * @author Philipp Merkle
 * 
 * @see BehaviourInterpreter
 */
public class UsageBehaviourInterpreter extends BehaviourInterpreter<AbstractUserAction, User, UserState> {

    private static final Logger logger = Logger.getLogger(UsageBehaviourInterpreter.class);
    private static final Map<EClass, IUsageTraversalStrategy<? extends AbstractUserAction>> handlerMap = new HashMap<EClass, IUsageTraversalStrategy<? extends AbstractUserAction>>();
    private static final Map<AbstractUserAction, List<IUsageTraversalListener>> traversalListenerMap = new HashMap<AbstractUserAction, List<IUsageTraversalListener>>();
    private static final List<IUsageTraversalListener> traversalListenerList = new ArrayList<IUsageTraversalListener>();

    private static final UsageBehaviourInterpreter singleInstance = new UsageBehaviourInterpreter();

    static {
        // register default action handlers
        handlerMap.put(UsagemodelPackage.eINSTANCE.getStart(), new StartTraversalStrategy());
        handlerMap.put(UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall(),
                new EntryLevelSystemCallTraversalStrategy());
        handlerMap.put(UsagemodelPackage.eINSTANCE.getLoop(), new LoopTraversalStrategy());
        handlerMap.put(UsagemodelPackage.eINSTANCE.getStop(), new StopTraversalStrategy());
        handlerMap.put(UsagemodelPackage.eINSTANCE.getDelay(), new DelayTraversalStrategy());
        handlerMap.put(UsagemodelPackage.eINSTANCE.getBranch(), new BranchTraversalStrategy());
    }
    
    // make the constructor private in order to prevent multiple instances.
    private UsageBehaviourInterpreter() {
        // nothing to do
    }

    public static UsageBehaviourInterpreter instance() {
        return singleInstance;
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
        return handlerMap.get(eclass);
    }

    /**
     * Adds a handler for the specified action class, which must be a subtype of
     * {@link AbstractUserAction}.
     * 
     * @param actionClass
     *            the action class
     * @param handler
     *            the handler that is to be registered
     */
    public void registerActionHandler(final EClass actionClass,
            final IUsageTraversalStrategy<AbstractUserAction> handler) {
        assert (UsagemodelPackage.eINSTANCE.getAbstractUserAction().isSuperTypeOf(actionClass)) : "The parameter \"action\" has to be a subtype of AbstractUserAction, but was "
                + actionClass.getName();
        if (handlerMap.containsKey(actionClass)) {
            logger.warn("Registered a handler for " + actionClass.getName()
                    + ", for which a handler was already registered. The former handler has been overwritten.");
        }
        handlerMap.put(actionClass, handler);
    }

    /**
     * Removes the handler for the specified action class.
     * 
     * @param actionClass
     *            the action class whose handler is to be unregistered
     */
    public void unregisterActionHandler(final EClass actionClass) {
        assert (UsagemodelPackage.eINSTANCE.getAbstractUserAction().isSuperTypeOf(actionClass)) : "The parameter \"action\" has to be a subtype of AbstractUserAction, but was "
                + actionClass.getName();
        if (handlerMap.containsKey(actionClass)) {
            logger.warn("Tried to unregister the action handler of " + actionClass.getName()
                    + ", but no handler has been registered for this action.");
        }
        handlerMap.remove(actionClass);
    }

    /**
     * Adds a traversal listener that is notified whenever the specified action is about to be
     * traversed or has been traversed completely.
     * 
     * @param action
     *            the action that is to be observed
     * @param listener
     *            the listener that is to be registered
     */
    public static void addTraversalListener(final AbstractUserAction action, final IUsageTraversalListener listener) {
        if (!traversalListenerMap.containsKey(action)) {
            traversalListenerMap.put(action, new ArrayList<IUsageTraversalListener>());
        }
        traversalListenerMap.get(action).add(listener);
    }

    /**
     * Adds a traversal listener that is notified whenever an arbitrary action is about to be
     * traversed or has been traversed completely.
     * 
     * @param listener
     *            the listener that is to be registered
     */
    public static void addTraversalListener(final IUsageTraversalListener listener) {
        traversalListenerList.add(listener);
    }

    /**
     * Removes the specified traversal listener that has been registered to listen for traversal
     * events associated with the specified action.
     * 
     * @param action
     *            the action that is observed by the specified listener
     * @param listener
     *            the listener that is to be unregistered
     */
    public static void removeTraversalListener(final AbstractAction action, final IUsageTraversalListener listener) {
        traversalListenerMap.get(action).remove(listener);
    }

    /**
     * Removes all traversal listeners that has been registered by the {@code addTraversalListener}
     * method.
     */
    public static void clearTraversalListeners() {
        traversalListenerMap.clear();
        traversalListenerList.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyAfterListener(final AbstractUserAction action, final User user, UserState state) {
        final List<IUsageTraversalListener> listeners = traversalListenerMap.get(action);
        if (listeners != null) {
            for (final IUsageTraversalListener l : listeners) {
                l.after(action, user, state);
            }
        }
        for (final IUsageTraversalListener l : traversalListenerList) {
            l.after(action, user, state);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyBeforeListener(final AbstractUserAction action, final User user, UserState state) {
        final List<IUsageTraversalListener> listeners = traversalListenerMap.get(action);
        if (listeners != null) {
            for (final IUsageTraversalListener l : listeners) {
                l.before(action, user, state);
            }
        }
        for (final IUsageTraversalListener l : traversalListenerList) {
            l.before(action, user, state);
        }
    }

}
