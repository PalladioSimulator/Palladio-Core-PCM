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
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
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
 * 
 * @author Philipp Merkle
 * 
 */
public class UsageBehaviorTraversal extends BehaviourTraversal<AbstractUserAction, User> {

    private static final Logger logger = Logger.getLogger(UsageBehaviorTraversal.class);
    private static final Map<EClass, IUsageTraversalStrategy<? extends AbstractUserAction>> actionHandlerMap = new HashMap<EClass, IUsageTraversalStrategy<? extends AbstractUserAction>>();
    private static final Map<AbstractUserAction, List<IUsageTraversalListener>> traversalListenerMap = new HashMap<AbstractUserAction, List<IUsageTraversalListener>>();
    private static final List<IUsageTraversalListener> traversalListenerList = new ArrayList<IUsageTraversalListener>();

    private final ScenarioBehaviour behaviour;

    static {
        actionHandlerMap.put(UsagemodelPackage.eINSTANCE.getStart(), new StartTraversalStrategy());
        actionHandlerMap.put(UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall(),
                new EntryLevelSystemCallTraversalStrategy());
        actionHandlerMap.put(UsagemodelPackage.eINSTANCE.getLoop(), new LoopTraversalStrategy());
        actionHandlerMap.put(UsagemodelPackage.eINSTANCE.getStop(), new StopTraversalStrategy());
        actionHandlerMap.put(UsagemodelPackage.eINSTANCE.getDelay(), new DelayTraversalStrategy());
        actionHandlerMap.put(UsagemodelPackage.eINSTANCE.getBranch(), new BranchTraversalStrategy());
    }

    public UsageBehaviorTraversal(final User user, final TraversalState<AbstractUserAction> context,
            final ScenarioBehaviour behaviour) {
        super(user, context);
        this.behaviour = behaviour;
    }

    public UsageBehaviorTraversal(final User user, final TraversalState<AbstractUserAction> context) {
        this(user, context, null);
    }

    @Override
    public void beginTraversal() {
        this.entity.notifyEnteredSystem();

        // enter scope
        this.state.getStack().enterScope(new TraversalStackFrame<AbstractUserAction>());

        // find start action
        final EventSimModel model = super.getEntity().getModel();
        final Start start = model.execute(new FindActionInUsageBehaviour<Start>(this.behaviour, Start.class));

        // begin traversal
        this.state.getStack().currentScope().setCurrentPosition(start);
        super.traverse(start);
    }

    @Override
    public void resumeTraversal() {
        // find next action
        super.traverse(this.state.getStack().currentScope().getCurrentPosition());
    }

    /**
     * 
     * @param actionClass
     *            has to be a subtype of {@link AbstractUserAction}
     * @param handler
     */
    public void registerActionHandler(final EClass actionClass,
            final IUsageTraversalStrategy<AbstractUserAction> handler) {
        assert (UsagemodelPackage.eINSTANCE.getAbstractUserAction().isSuperTypeOf(actionClass)) : "The parameter \"action\" has to be a subtype of AbstractUserAction, but was "
                + actionClass.getName();
        if (actionHandlerMap.containsKey(actionClass)) {
            logger.warn("Registered a handler for " + actionClass.getName()
                    + ", for which a handler was already registered. The former handler has been overwritten.");
        }
        actionHandlerMap.put(actionClass, handler);
    }

    public void unregisterActionHandler(final EClass actionClass) {
        assert (UsagemodelPackage.eINSTANCE.getAbstractUserAction().isSuperTypeOf(actionClass)) : "The parameter \"action\" has to be a subtype of AbstractUserAction, but was "
                + actionClass.getName();
        if (actionHandlerMap.containsKey(actionClass)) {
            logger.warn("Tried to unregister the action handler of " + actionClass.getName()
                    + ", but no handler has been registered for this action.");
        }
        actionHandlerMap.remove(actionClass);
    }

    public static void addTraversalListener(final AbstractUserAction action, final IUsageTraversalListener listener) {
        if (!traversalListenerMap.containsKey(action)) {
            traversalListenerMap.put(action, new ArrayList<IUsageTraversalListener>());
        }
        traversalListenerMap.get(action).add(listener);
    }

    public static void addTraversalListener(final IUsageTraversalListener listener) {
        traversalListenerList.add(listener);
    }

    public static void removeTraversalListener(final AbstractAction action, final IUsageTraversalListener listener) {
        traversalListenerMap.get(action).remove(listener);
    }

    public static void clearTraversalListeners() {
        traversalListenerMap.clear();
        traversalListenerList.clear();
    }

    @SuppressWarnings("unchecked")
    @Override
    public IUsageTraversalStrategy<AbstractUserAction> obtainTraversalStrategy(final EClass eclass) {
        return (IUsageTraversalStrategy<AbstractUserAction>) actionHandlerMap.get(eclass);
    }

    @Override
    public void notifyAfterListener(final AbstractUserAction action, final User user) {
        final List<IUsageTraversalListener> listeners = traversalListenerMap.get(action);
        if (listeners != null) {
            for (final IUsageTraversalListener l : listeners) {
                l.after(action, user);
            }
        }
        for (final IUsageTraversalListener l : traversalListenerList) {
            l.after(action, user);
        }
    }

    @Override
    public void notifyBeforeListener(final AbstractUserAction action, final User user) {
        final List<IUsageTraversalListener> listeners = traversalListenerMap.get(action);
        if (listeners != null) {
            for (final IUsageTraversalListener l : listeners) {
                l.before(action, user);
            }
        }
        for (final IUsageTraversalListener l : traversalListenerList) {
            l.before(action, user);
        }
    }

}
