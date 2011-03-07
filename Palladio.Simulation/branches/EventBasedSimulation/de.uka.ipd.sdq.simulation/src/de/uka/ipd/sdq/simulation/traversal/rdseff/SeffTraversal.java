package de.uka.ipd.sdq.simulation.traversal.rdseff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.SimulatedComponentInstance;
import de.uka.ipd.sdq.simulation.command.rdseff.FindActionInSEFF;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.BehaviourTraversal;
import de.uka.ipd.sdq.simulation.traversal.ITraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.listener.ISeffTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.rdseff.strategies.AcquireActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.rdseff.strategies.BranchActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.rdseff.strategies.ExternalCallActionStrategy;
import de.uka.ipd.sdq.simulation.traversal.rdseff.strategies.InternalActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.rdseff.strategies.LoopActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.rdseff.strategies.ReleaseActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.rdseff.strategies.SetVariableActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.rdseff.strategies.StartActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.rdseff.strategies.StopActionTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class SeffTraversal extends BehaviourTraversal<AbstractAction, Request> {

    private static final Map<EClass, ISeffTraversalStrategy<? extends AbstractAction>> traversalMap;
    private static final Map<AbstractAction, List<ISeffTraversalListener>> traversalListenerMap = new HashMap<AbstractAction, List<ISeffTraversalListener>>();
    private static final List<ISeffTraversalListener> traversalListenerList = new ArrayList<ISeffTraversalListener>();

    private final OperationSignature signature;

    private final SimulatedComponentInstance component;

    static {
        traversalMap = new HashMap<EClass, ISeffTraversalStrategy<? extends AbstractAction>>();
        traversalMap.put(SeffPackage.eINSTANCE.getStartAction(), new StartActionTraversalStrategy());
        traversalMap.put(SeffPackage.eINSTANCE.getInternalAction(), new InternalActionTraversalStrategy());
        traversalMap.put(SeffPackage.eINSTANCE.getStopAction(), new StopActionTraversalStrategy());
        traversalMap.put(SeffPackage.eINSTANCE.getExternalCallAction(), new ExternalCallActionStrategy());
        traversalMap.put(SeffPackage.eINSTANCE.getLoopAction(), new LoopActionTraversalStrategy());
        traversalMap.put(SeffPackage.eINSTANCE.getBranchAction(), new BranchActionTraversalStrategy());
        traversalMap.put(SeffPackage.eINSTANCE.getAcquireAction(), new AcquireActionTraversalStrategy());
        traversalMap.put(SeffPackage.eINSTANCE.getReleaseAction(), new ReleaseActionTraversalStrategy());
        traversalMap.put(SeffPackage.eINSTANCE.getSetVariableAction(), new SetVariableActionTraversalStrategy());
    }

    public SeffTraversal(final Request entity, final TraversalState<AbstractAction> context,
            final SimulatedComponentInstance component, final OperationSignature signature) {
        super(entity, context);
        this.signature = signature;
        this.component = component;
    }

    public SeffTraversal(final Request entity, final TraversalState<AbstractAction> context) {
        this(entity, context, null, null);
    }

    @Override
    public void beginTraversal() {
        this.entity.notifyEnteredSystem();

        // enter scope
        this.state.getStack().enterScope(new TraversalStackFrame<AbstractAction>());
        this.state.getStack().currentScope().setComponent(this.component);

        // find start action
        final EventSimModel model = super.getEntity().getModel();
        final ResourceDemandingSEFF seff = this.component.getSeff(this.signature);
        final StartAction startAction = model.execute(new FindActionInSEFF<StartAction>(seff, StartAction.class));

        // begin traversal
        this.state.getStack().currentScope().setCurrentPosition(startAction);
        super.traverse(startAction);
    }

    @Override
    public void resumeTraversal() {
        // find next action
        super.traverse(this.state.getStack().currentScope().getCurrentPosition());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends AbstractAction> ITraversalStrategy<AbstractAction, T, Request> obtainTraversalStrategy(
            final EClass eclass) {
        return (ITraversalStrategy<AbstractAction, T, Request>) traversalMap.get(eclass);
    }

    @Override
    public void notifyAfterListener(final AbstractAction action, final Request request) {
        final List<ISeffTraversalListener> listeners = traversalListenerMap.get(action);
        if (listeners != null) {
            for (final ISeffTraversalListener l : listeners) {
                l.after(action, request);
            }
        }
        for (final ISeffTraversalListener l : traversalListenerList) {
            l.after(action, request);
        }
    }

    @Override
    public void notifyBeforeListener(final AbstractAction action, final Request request) {
        final List<ISeffTraversalListener> listeners = traversalListenerMap.get(action);
        if (listeners != null) {
            for (final ISeffTraversalListener l : listeners) {
                l.before(action, request);
            }
        }
        for (final ISeffTraversalListener l : traversalListenerList) {
            l.before(action, request);
        }
    }

    public static void addTraversalListener(final AbstractAction action, final ISeffTraversalListener listener) {
        if (!traversalListenerMap.containsKey(action)) {
            traversalListenerMap.put(action, new ArrayList<ISeffTraversalListener>());
        }
        traversalListenerMap.get(action).add(listener);
    }

    public static void addTraversalListener(final ISeffTraversalListener listener) {
        traversalListenerList.add(listener);
    }

    public static void removeTraversalListener(final AbstractAction action, final ISeffTraversalListener listener) {
        traversalListenerMap.get(action).remove(listener);
    }

    public static void clearTraversalListeners() {
        traversalListenerMap.clear();
        traversalListenerList.clear();
    }

}
