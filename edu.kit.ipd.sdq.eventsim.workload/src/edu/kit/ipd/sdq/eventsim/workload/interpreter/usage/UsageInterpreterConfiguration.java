package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.InterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.listener.IUsageTraversalListener;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies.BranchTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies.DelayTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies.EntryLevelSystemCallTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies.LoopTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies.StartTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies.StopTraversalStrategy;

public class UsageInterpreterConfiguration implements InterpreterConfiguration<AbstractUserAction, User, UserState> {

    private static final Logger logger = Logger.getLogger(UsageInterpreterConfiguration.class);
    
    private final Map<EClass, ITraversalStrategy<AbstractUserAction, ? extends AbstractUserAction, User, UserState>> handlerMap = new HashMap<>();
    private final Map<AbstractUserAction, List<IUsageTraversalListener>> traversalListenerMap = new HashMap<>();
    private final List<IUsageTraversalListener> traversalListenerList = new ArrayList<>();

    public UsageInterpreterConfiguration() {
        registerDefaultHandlers();
    }

    private void registerDefaultHandlers() {
        // register default action handlers
        handlerMap.put(UsagemodelPackage.eINSTANCE.getStart(), new StartTraversalStrategy());
        handlerMap.put(UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall(), new EntryLevelSystemCallTraversalStrategy());
        handlerMap.put(UsagemodelPackage.eINSTANCE.getLoop(), new LoopTraversalStrategy());
        handlerMap.put(UsagemodelPackage.eINSTANCE.getStop(), new StopTraversalStrategy());
        handlerMap.put(UsagemodelPackage.eINSTANCE.getDelay(), new DelayTraversalStrategy());
        handlerMap.put(UsagemodelPackage.eINSTANCE.getBranch(), new BranchTraversalStrategy());
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
			final ITraversalStrategy<AbstractUserAction, ? extends AbstractUserAction, User, UserState> handler) {
        assert (UsagemodelPackage.eINSTANCE.getAbstractUserAction().isSuperTypeOf(actionClass)) : "The parameter \"action\" has to be a subtype of AbstractUserAction, but was "
                + actionClass.getName();
        if (handlerMap.containsKey(actionClass)) {
        	if(logger.isEnabledFor(Level.WARN))
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
        	if(logger.isEnabledFor(Level.WARN))
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
    public void addTraversalListener(final AbstractUserAction action, final IUsageTraversalListener listener) {
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
    public void addTraversalListener(final IUsageTraversalListener listener) {
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
    public void removeTraversalListener(final AbstractUserAction action, final IUsageTraversalListener listener) {
        traversalListenerMap.get(action).remove(listener);
    }

    /**
     * Removes all traversal listeners that has been registered by the {@code addTraversalListener}
     * method.
     */
    public void clearTraversalListeners() {
        traversalListenerMap.clear();
        traversalListenerList.clear();
    }
    
    @Override
    public Map<EClass, ITraversalStrategy<AbstractUserAction, ? extends AbstractUserAction, User, UserState>> getHandlerMap() {
        return handlerMap;
    }

    @Override
    public List<IUsageTraversalListener> getTraversalListenerList() {
        return traversalListenerList;
    }

    @Override
    public Map<AbstractUserAction, List<IUsageTraversalListener>> getTraversalListenerMap() {
        return traversalListenerMap;
    }

}
