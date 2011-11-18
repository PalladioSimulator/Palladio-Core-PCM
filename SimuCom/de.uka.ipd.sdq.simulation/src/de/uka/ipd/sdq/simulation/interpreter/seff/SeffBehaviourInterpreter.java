package de.uka.ipd.sdq.simulation.interpreter.seff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.command.seff.FindActionInResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.interpreter.BehaviourInterpreter;
import de.uka.ipd.sdq.simulation.interpreter.listener.ISeffTraversalListener;
import de.uka.ipd.sdq.simulation.interpreter.seff.strategies.AcquireActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.strategies.BranchActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.strategies.ExternalCallActionStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.strategies.ForkActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.strategies.InternalActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.strategies.LoopActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.strategies.ReleaseActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.strategies.SetVariableActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.strategies.StartActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.strategies.StopActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.state.RequestState;
import de.uka.ipd.sdq.simulation.interpreter.state.UserState;
import de.uka.ipd.sdq.simulation.interpreter.usage.UsageBehaviourInterpreter;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;

/**
 * An interpreter for {@link ResourceDemandingSEFF}s.
 * 
 * @author Philipp Merkle
 * 
 * @see BehaviourInterpreter
 */
public class SeffBehaviourInterpreter extends BehaviourInterpreter<AbstractAction, Request, RequestState> {

    private static final Logger logger = Logger.getLogger(SeffBehaviourInterpreter.class);
    private static final Map<EClass, ISeffTraversalStrategy<? extends AbstractAction>> handlerMap = new HashMap<EClass, ISeffTraversalStrategy<? extends AbstractAction>>();
    private static final Map<AbstractAction, List<ISeffTraversalListener>> traversalListenerMap = new HashMap<AbstractAction, List<ISeffTraversalListener>>();
    private static final List<ISeffTraversalListener> traversalListenerList = new ArrayList<ISeffTraversalListener>();

    private static final SeffBehaviourInterpreter singleInstance = new SeffBehaviourInterpreter();

    static {
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

    // make the constructor private in order to prevent multiple instances.
    private SeffBehaviourInterpreter() {
        // nothing to do
    }

    public static SeffBehaviourInterpreter instance() {
        return singleInstance;
    }

    /**
     * Starts the traversal of the {@link ResourceDemandingSEFF} associated with the specified
     * component and signature.
     */
    public void beginTraversal(Request request, final ComponentInstance component, final OperationSignature signature,
            final UserState usageState) {
        request.notifyEnteredSystem();

        // initialise traversal state and StoEx context
        RequestState state = new RequestState(usageState, usageState.getStoExContext());
        state.pushStackFrame();
        state.setComponent(component);

        // find start action
        final EventSimModel model = request.getModel();
        final ResourceDemandingSEFF seff = component.getServiceEffectSpecification(signature);
        final StartAction startAction = model.execute(new FindActionInResourceDemandingBehaviour<StartAction>(seff,
                StartAction.class));

        // begin traversal
        state.setCurrentPosition(startAction);
        this.traverse(request, startAction, state);
    }

    public void beginTraversal(Request request, ForkedBehaviour behaviour, final RequestState parentState) {
        request.notifyEnteredSystem();

        // initialise traversal state and StoEx context
        StackContext stoExContext = new StackContext();
        stoExContext.getStack()
                .pushStackFrame(parentState.getStoExContext().getStack().currentStackFrame().copyFrame());

        RequestState state = null;
        try {
            state = parentState.clone();
        } catch (CloneNotSupportedException e) {
            // TODO log error and throw exception
            e.printStackTrace();
        }
        state.setComponent(parentState.getComponent());

        // find start action
        final EventSimModel model = request.getModel();
        final StartAction startAction = model.execute(new FindActionInResourceDemandingBehaviour<StartAction>(
                behaviour, StartAction.class));

        // begin traversal
        state.setCurrentPosition(startAction);
        this.traverse(request, startAction, state);
    }

    public void resumeTraversal(Request request, final RequestState state) {
        // find next action and resume traversal
        super.traverse(request, state.getCurrentPosition(), state);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ISeffTraversalStrategy<? extends AbstractAction> loadTraversalStrategy(final EClass eclass) {
        return handlerMap.get(eclass);
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
    public static void addTraversalListener(final AbstractAction action, final ISeffTraversalListener listener) {
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
    public static void addTraversalListener(final ISeffTraversalListener listener) {
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
    public static void removeTraversalListener(final AbstractAction action, final ISeffTraversalListener listener) {
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
    public void notifyAfterListener(final AbstractAction action, final Request request, RequestState state) {
        final List<ISeffTraversalListener> listeners = traversalListenerMap.get(action);
        if (listeners != null) {
            for (final ISeffTraversalListener l : listeners) {
                l.after(action, request, state);
            }
        }
        for (final ISeffTraversalListener l : traversalListenerList) {
            l.after(action, request, state);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyBeforeListener(final AbstractAction action, final Request request, RequestState state) {
        final List<ISeffTraversalListener> listeners = traversalListenerMap.get(action);
        if (listeners != null) {
            for (final ISeffTraversalListener l : listeners) {
                l.before(action, request, state);
            }
        }
        for (final ISeffTraversalListener l : traversalListenerList) {
            l.before(action, request, state);
        }
    }

}
