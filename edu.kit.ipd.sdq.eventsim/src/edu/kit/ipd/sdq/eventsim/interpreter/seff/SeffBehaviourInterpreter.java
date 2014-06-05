package edu.kit.ipd.sdq.eventsim.interpreter.seff;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.command.seff.FindActionInResourceDemandingBehaviour;
import edu.kit.ipd.sdq.eventsim.entities.ForkedRequest;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.BehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ISeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.state.ForkedRequestState;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.staticstructure.ComponentInstance;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;
import edu.kit.ipd.sdq.eventsim.util.ParameterHelper;

/**
 * An interpreter for {@link ResourceDemandingSEFF}s.
 * 
 * @author Philipp Merkle
 * 
 * @see BehaviourInterpreter
 */
public class SeffBehaviourInterpreter extends BehaviourInterpreter<AbstractAction, Request, RequestState> {

    private static final Logger logger = Logger.getLogger(SeffBehaviourInterpreter.class);

    private SeffInterpreterConfiguration configuration;

    public SeffBehaviourInterpreter(SeffInterpreterConfiguration configuration) {
        this.configuration = configuration;
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
        
        final EntryLevelSystemCall call = (EntryLevelSystemCall) request.getSystemCall();
        final StackContext ctx = state.getStoExContext();

        // get a reference on the current stack frame which is being covered soon
        final SimulatedStackframe<Object> outerFrame = ctx.getStack().currentStackFrame();

        // enter a new scope in which the call is being executed
        final SimulatedStackframe<Object> serviceBodyFrame = ctx.getStack().createAndPushNewStackFrame();

        // add component parameters
        serviceBodyFrame.addVariables(component.getComponentParameters());

        // evaluate the input parameters and add them to the call's scope
        final List<VariableUsage> parameters = call.getInputParameterUsages_EntryLevelSystemCall();
        ParameterHelper.evaluateParametersAndCopyToFrame(parameters, outerFrame, serviceBodyFrame);

        if (logger.isDebugEnabled()) {
            logger.debug("Finished handling system call input parameters");
        }

        // find start action
        final EventSimModel model = request.getModel();
        final ResourceDemandingSEFF seff = component.getServiceEffectSpecification(signature);
        final StartAction startAction = model.execute(new FindActionInResourceDemandingBehaviour<StartAction>(seff,
                StartAction.class));

        // begin traversal
        state.setCurrentPosition(startAction);

        if(logger.isDebugEnabled())
        	logger.debug("Begin interpreting SEFF " + seff.getId() + " (AssemblyContext: "
                + PCMEntityHelper.toString(component.getAssemblyCtx()) + ", OperationSignature: "
                + PCMEntityHelper.toString(signature));
        this.traverse(request, startAction, state);
    }

    public void beginTraversal(ForkedRequest request, ForkedBehaviour behaviour, final RequestState parentState) {
        request.notifyEnteredSystem();

        // initialise traversal state and StoEx context
        StackContext stoExContext = new StackContext();
        stoExContext.getStack()
                .pushStackFrame(parentState.getStoExContext().getStack().currentStackFrame().copyFrame());
        ForkedRequestState state = new ForkedRequestState(parentState, stoExContext);
        state.pushStackFrame();
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
        return this.configuration.getHandlerMap().get(eclass);
    }

    @Override
    public SeffInterpreterConfiguration getConfiguration() {
        return this.configuration;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyAfterListener(final AbstractAction action, final Request request, RequestState state) {
        for (final ISeffTraversalListener l : this.configuration.getTraversalListenerList()) {
            l.after(action, request, state);
        }
        final List<ISeffTraversalListener> listeners = this.configuration.getTraversalListenerMap().get(action);
        if (listeners != null) {
            for (final ISeffTraversalListener l : listeners) {
                l.after(action, request, state);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyBeforeListener(final AbstractAction action, final Request request, RequestState state) {
        for (final ISeffTraversalListener l : this.configuration.getTraversalListenerList()) {
            l.before(action, request, state);
        }
        final List<ISeffTraversalListener> listeners = this.configuration.getTraversalListenerMap().get(action);
        if (listeners != null) {
            for (final ISeffTraversalListener l : listeners) {
                l.before(action, request, state);
            }
        }
    }

}
