package edu.kit.ipd.sdq.eventsim.system.interpreter.seff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.InterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.system.interpreter.listener.ISeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies.AcquireActionTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies.BranchActionTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies.ExternalCallActionStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies.ForkActionTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies.InternalActionTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies.LoopActionTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies.ReleaseActionTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies.SetVariableActionTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies.StartActionTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies.StopActionTraversalStrategy;

public class SeffInterpreterConfiguration implements InterpreterConfiguration<AbstractAction, Request, RequestState> {

    private static final Logger logger = Logger.getLogger(SeffInterpreterConfiguration.class);
    
    private final Map<EClass, ISeffTraversalStrategy<? extends AbstractAction>> handlerMap = new HashMap<EClass, ISeffTraversalStrategy<? extends AbstractAction>>();
    private final Map<AbstractAction, List<ISeffTraversalListener>> traversalListenerMap = new HashMap<AbstractAction, List<ISeffTraversalListener>>();
    private final List<ISeffTraversalListener> traversalListenerList = new ArrayList<ISeffTraversalListener>();
    
    public SeffInterpreterConfiguration() {
        registerDefaultHandlers();
    }
    
    private void registerDefaultHandlers() {
        // register default action handlers
        handlerMap.put(SeffPackage.eINSTANCE.getStartAction(), new StartActionTraversalStrategy());
        handlerMap.put(SeffPackage.eINSTANCE.getInternalAction(), new InternalActionTraversalStrategy());
        handlerMap.put(SeffPackage.eINSTANCE.getStopAction(), new StopActionTraversalStrategy());
        handlerMap.put(SeffPackage.eINSTANCE.getExternalCallAction(), new ExternalCallActionStrategy());
        handlerMap.put(SeffPackage.eINSTANCE.getLoopAction(), new LoopActionTraversalStrategy());
        handlerMap.put(SeffPackage.eINSTANCE.getBranchAction(), new BranchActionTraversalStrategy());
        handlerMap.put(SeffPackage.eINSTANCE.getAcquireAction(), new AcquireActionTraversalStrategy());
        handlerMap.put(SeffPackage.eINSTANCE.getReleaseAction(), new ReleaseActionTraversalStrategy());
        handlerMap.put(SeffPackage.eINSTANCE.getSetVariableAction(), new SetVariableActionTraversalStrategy());
        handlerMap.put(SeffPackage.eINSTANCE.getForkAction(), new ForkActionTraversalStrategy());
    }
    
    /**
     * Adds a handler for the specified action class, which must be a subtype of
     * {@link AbstractAction}.
     * 
     * @param actionClass
     *            the action class
     * @param handler
     *            the handler that is to be registered
     */
    public void registerActionHandler(final EClass actionClass, final ISeffTraversalStrategy<AbstractAction> handler) {
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
    public void addTraversalListener(final AbstractAction action, final ISeffTraversalListener listener) {
        if (!traversalListenerMap.containsKey(action)) {
            traversalListenerMap.put(action, new ArrayList<ISeffTraversalListener>());
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
    public void addTraversalListener(final ISeffTraversalListener listener) {
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
    public void removeTraversalListener(final AbstractAction action, final ISeffTraversalListener listener) {
        traversalListenerMap.get(action).remove(listener);
    }

    @Override
    public Map<EClass, ISeffTraversalStrategy<? extends AbstractAction>> getHandlerMap() {
        return handlerMap;
    }

    @Override
    public List<ISeffTraversalListener> getTraversalListenerList() {
        return traversalListenerList;
    }

    @Override
    public Map<AbstractAction, List<ISeffTraversalListener>> getTraversalListenerMap() {
        return traversalListenerMap;
    }
    
}
