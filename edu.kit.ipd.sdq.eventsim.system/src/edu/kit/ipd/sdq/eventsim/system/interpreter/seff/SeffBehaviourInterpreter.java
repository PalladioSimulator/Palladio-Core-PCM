package edu.kit.ipd.sdq.eventsim.system.interpreter.seff;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ForkedBehaviour;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.StartAction;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.BehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.system.command.seff.FindActionInResourceDemandingBehaviour;
import edu.kit.ipd.sdq.eventsim.system.entities.ForkedRequest;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.listener.ISeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.ForkedRequestState;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.ComponentInstance;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;
import edu.kit.ipd.sdq.simcomp.system.events.SystemRequestStart;

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
	private AbstractEventSimModel model;

    public SeffBehaviourInterpreter(SeffInterpreterConfiguration configuration, AbstractEventSimModel model) {
        this.configuration = configuration;
        this.model = model;
    }

    /**
     * Starts the traversal of the {@link ResourceDemandingSEFF} associated with the specified
     * component and signature.
     */
    public void beginTraversal(Request request, final ComponentInstance component, final OperationSignature signature, final UserState usageState) {
        request.notifyEnteredSystem();

        // initialize traversal state and StoEx context
        RequestState state = new RequestState(usageState, usageState.getStoExContext());
        state.pushStackFrame();
        state.setComponent(component);
        request.setRequestState(state);
        
        // fire request start event
        this.model.getSimulationMiddleware().triggerEvent(new SystemRequestStart(request));

        // find start action
        final ResourceDemandingSEFF seff = component.getServiceEffectSpecification(signature);
        final StartAction startAction = this.model.execute(new FindActionInResourceDemandingBehaviour<StartAction>(seff, StartAction.class));

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
        stoExContext.getStack().pushStackFrame(parentState.getStoExContext().getStack().currentStackFrame().copyFrame());
        ForkedRequestState state = new ForkedRequestState(parentState, stoExContext);
        state.pushStackFrame();
        state.setComponent(parentState.getComponent());
        request.setRequestState(state);

        // find start action
        final StartAction startAction = this.model.execute(new FindActionInResourceDemandingBehaviour<StartAction>(behaviour, StartAction.class));

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
