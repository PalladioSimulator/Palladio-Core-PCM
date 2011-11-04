package de.uka.ipd.sdq.simulation.traversal.seff;

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
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.command.seff.FindActionInResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;
import de.uka.ipd.sdq.simulation.traversal.BehaviourTraversal;
import de.uka.ipd.sdq.simulation.traversal.ITraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.listener.ISeffTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.seff.strategies.AcquireActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.strategies.BranchActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.strategies.ExternalCallActionStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.strategies.ForkActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.strategies.InternalActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.strategies.LoopActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.strategies.ReleaseActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.strategies.SetVariableActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.strategies.StartActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.seff.strategies.StopActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * Provides the traversal of {@link ResourceDemandingSEFF}s.
 * 
 * @author Philipp Merkle
 * 
 * @see BehaviourTraversal
 */
public class SeffTraversal extends BehaviourTraversal<AbstractAction, Request> {

    private static final Logger logger = Logger.getLogger(SeffTraversal.class);
    private static final Map<EClass, ISeffTraversalStrategy<? extends AbstractAction>> handlerMap = new HashMap<EClass, ISeffTraversalStrategy<? extends AbstractAction>>();
    private static final Map<AbstractAction, List<ISeffTraversalListener>> traversalListenerMap = new HashMap<AbstractAction, List<ISeffTraversalListener>>();
    private static final List<ISeffTraversalListener> traversalListenerList = new ArrayList<ISeffTraversalListener>();

    private TraversalState<AbstractAction> state;

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

    /**
     * Default constructor. (TODO)
     * 
     * @param request
     *            the request that traverses the behaviour
     */
    public SeffTraversal(final Request request) {
        super(request);
    }

    /**
     * Use this constructor to begin the traversal of the SEFF specified by the passed forked
     * behaviour.
     * 
     * @param request
     * @param usageState
     */
    public SeffTraversal(final Request request, final ForkedBehaviour behaviour,
            final TraversalState<AbstractUserAction> usageState) {
        super(request);
    }

    /**
     * Starts the traversal of the {@link ResourceDemandingSEFF} associated with the specified
     * component and signature.
     */
    public void beginTraversal(final ComponentInstance component, final OperationSignature signature,
            final TraversalState<AbstractUserAction> usageState) {
        this.entity.notifyEnteredSystem();

        // initialise traversal state and StoEx context
        this.state = new TraversalState<AbstractAction>(usageState.getStoExContext(), usageState);

        // enter scope
        this.state.getStack().enterScope(new TraversalStackFrame<AbstractAction>());
        this.state.getStack().currentScope().setComponent(component);

        // find start action
        final EventSimModel model = this.getEntity().getModel();
        final ResourceDemandingSEFF seff = component.getServiceEffectSpecification(signature);
        final StartAction startAction = model.execute(new FindActionInResourceDemandingBehaviour<StartAction>(seff,
                StartAction.class));

        // begin traversal
        this.state.getStack().currentScope().setCurrentPosition(startAction);
        this.traverse(startAction, this.state);
    }

    public void beginTraversal(ForkedBehaviour behaviour, final TraversalState<AbstractAction> parentState) {
        this.entity.notifyEnteredSystem();

        // initialise traversal state and StoEx context
        StackContext stoExContext = new StackContext();
        stoExContext.getStack().pushStackFrame(parentState.getStoExContext().getStack().currentStackFrame().copyFrame());
        this.state = new TraversalState<AbstractAction>(stoExContext);

        // enter scope
        this.state.getStack().enterScope(new TraversalStackFrame<AbstractAction>());
        this.state.getStack().currentScope().setComponent(parentState.getStack().currentScope().getComponent());

        // find start action
        final EventSimModel model = this.getEntity().getModel();
        final StartAction startAction = model.execute(new FindActionInResourceDemandingBehaviour<StartAction>(behaviour,
                StartAction.class));

        // begin traversal
        this.state.getStack().currentScope().setCurrentPosition(startAction);
        this.traverse(startAction, this.state);
    }

    public void resumeTraversal(final TraversalState<AbstractAction> state) {
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
    public <T extends AbstractAction> ITraversalStrategy<AbstractAction, T, Request> loadTraversalStrategy(
            final EClass eclass) {
        return (ITraversalStrategy<AbstractAction, T, Request>) handlerMap.get(eclass);
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
    public void notifyAfterListener(final AbstractAction action, final Request request,
            TraversalState<AbstractAction> state) {
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
    public void notifyBeforeListener(final AbstractAction action, final Request request,
            TraversalState<AbstractAction> state) {
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
