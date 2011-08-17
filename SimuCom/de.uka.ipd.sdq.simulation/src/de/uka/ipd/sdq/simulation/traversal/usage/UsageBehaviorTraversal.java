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
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.command.usage.FindActionInUsageBehaviour;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.BehaviourTraversal;
import de.uka.ipd.sdq.simulation.traversal.listener.IUsageTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.BranchTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.DelayTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.EntryLevelSystemCallTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.LoopTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.StartTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.strategies.StopTraversalStrategy;

/**
 * Provides the traversal of {@link UsageScenario}s.
 * 
 * @author Philipp Merkle
 * 
 * @see BehaviourTraversal
 */
public class UsageBehaviorTraversal extends BehaviourTraversal<AbstractUserAction, User> {

    private static final Logger logger = Logger.getLogger(UsageBehaviorTraversal.class);
    private static final Map<EClass, IUsageTraversalStrategy<? extends AbstractUserAction>> handlerMap = new HashMap<EClass, IUsageTraversalStrategy<? extends AbstractUserAction>>();
    private static final Map<AbstractUserAction, List<IUsageTraversalListener>> traversalListenerMap = new HashMap<AbstractUserAction, List<IUsageTraversalListener>>();
    private static final List<IUsageTraversalListener> traversalListenerList = new ArrayList<IUsageTraversalListener>();

    private ScenarioBehaviour behaviour;
    private TraversalState<AbstractUserAction> state;

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

    /**
     * Use this constructor to begin the traversal of the specified behaviour.
     * 
     * @param user
     *            the user that traverses the behaviour
     * @param behaviour
     *            the behaviour that is to be traversed
     */
    public UsageBehaviorTraversal(final User user, final ScenarioBehaviour behaviour) {
        super(user);
        this.behaviour = behaviour;
    }

    /**
     * Use this constructor when a previous traversal is to be restored by using the {@code
     * resumeTraversal} method.
     * 
     * @param user
     *            the user that traverses the behaviour
     */
    public UsageBehaviorTraversal(final User user) {
        super(user);
    }

    /**
     * {@inheritDoc}
     */
    public void beginTraversal() {
        this.entity.notifyEnteredSystem();

        // initialise traversal state and StoEx context
        this.state = new TraversalState<AbstractUserAction>(new StackContext());
        this.state.getStoExContext().getStack().createAndPushNewStackFrame();

        // enter scope
        this.state.getStack().enterScope(new TraversalStackFrame<AbstractUserAction>());

        // find start action
        final EventSimModel model = this.getEntity().getModel();
        final Start start = model.execute(new FindActionInUsageBehaviour<Start>(this.behaviour, Start.class));

        // begin traversal
        this.state.getStack().currentScope().setCurrentPosition(start);
        this.traverse(start, this.state);
    }

    /**
     * {@inheritDoc}
     */
    public void resumeTraversal(final TraversalState<AbstractUserAction> state) {
        // restore traversal state
        this.state = state;

        // find next action
        super.traverse(this.state.getStack().currentScope().getCurrentPosition(), this.state);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public IUsageTraversalStrategy<AbstractUserAction> obtainTraversalStrategy(final EClass eclass) {
        return (IUsageTraversalStrategy<AbstractUserAction>) handlerMap.get(eclass);
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
    public void notifyAfterListener(final AbstractUserAction action, final User user,
            TraversalState<AbstractUserAction> state) {
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
    public void notifyBeforeListener(final AbstractUserAction action, final User user,
            TraversalState<AbstractUserAction> state) {
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
