package de.uka.ipd.sdq.pcmsolver.visitors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.handler.CollectionIteratorActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.ExternalCallActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.ForkActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.GuardedBranchTransitionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.InternalActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.LoopActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.ProbabilisticBranchTransitionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.RecoveryBlockActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.SetVariableActionHandler;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;

/**
 * Visitor that builds the computed usage and computed allocation contexts.
 * 
 * @author Koziolek, Martens, Lankin, Brosch
 * 
 */
public class SeffVisitor extends SeffSwitch {

	/**
	 * Logging functionality.
	 */
	private static Logger logger = Logger
			.getLogger(SeffVisitor.class.getName());

	/**
	 * Handler for collection iterator actions.
	 */
	private CollectionIteratorActionHandler collectionIteratorHandler;

	/**
	 * Handler for external call actions.
	 */
	private ExternalCallActionHandler externalCallHandler;

	/**
	 * Handler for fork actions.
	 */
	private ForkActionHandler forkHandler;

	/**
	 * Handler for guarded branch transitions.
	 */
	private GuardedBranchTransitionHandler guardedBranchHandler;

	/**
	 * Handler for internal actions.
	 */
	private InternalActionHandler internalActionHandler;

	/**
	 * Handler for loop actions.
	 */
	private LoopActionHandler loopHandler;

	/**
	 * Handler for probabilistic branch transitions.
	 */
	private ProbabilisticBranchTransitionHandler probabilisticBranchHandler;

	/**
	 * Handler for recovery block actions.
	 */
	private RecoveryBlockActionHandler recoveryBlockHandler;

	/**
	 * Handler for set variable actions.
	 */
	private SetVariableActionHandler setVariableHandler;

	/**
	 * Context wrapper for access to context information.
	 */
	protected ContextWrapper contextWrapper;

	/**
	 * The constructor.
	 * 
	 * @param wrapper
	 *            reference to the context wrapper
	 */
	public SeffVisitor(final ContextWrapper wrapper) {
		contextWrapper = wrapper;
		externalCallHandler = new ExternalCallActionHandler(this);
		internalActionHandler = new InternalActionHandler(this);
		guardedBranchHandler = new GuardedBranchTransitionHandler(this);
		probabilisticBranchHandler = new ProbabilisticBranchTransitionHandler(
				this);
		collectionIteratorHandler = new CollectionIteratorActionHandler(this);
		loopHandler = new LoopActionHandler(this);
		setVariableHandler = new SetVariableActionHandler(this);
		recoveryBlockHandler = new RecoveryBlockActionHandler(this);
		forkHandler = new ForkActionHandler(this);
	}

	/**
	 * Handles recovery block actions.
	 * 
	 * This is a workaround implementing the case for the base class of the
	 * RecoveryBlockAction type, as the type itself is not directly in the SEFF
	 * package and thus not handled by the SeffSwitch.
	 * 
	 * @param action
	 *            the recovery block action
	 * @return the recovery block action
	 */
	@Override
	public Object caseAbstractInternalControlFlowAction(
			final AbstractInternalControlFlowAction action) {
		if (action instanceof RecoveryAction) {
			logger.debug("Visit " + action.getClass().getSimpleName() + " \""
					+ action.getEntityName() + "\"");
			recoveryBlockHandler.handle((RecoveryAction) action);
			doSwitch(action.getSuccessor_AbstractAction());
			return action;
		} else {
			return null;
		}
	}

	/**
	 * Handles acquire actions.
	 * 
	 * Nothing to do for the dependency solver. Just goes to the next action.
	 * 
	 * @param action
	 *            the acquire action
	 * @return the acquire action
	 */
	@Override
	public Object caseAcquireAction(final AcquireAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/**
	 * Handles branch actions.
	 * 
	 * Proceeds with the inner branch transitions, then goes to the next action.
	 * 
	 * @param action
	 *            the branch action
	 * @return the branch action
	 */
	@Override
	public Object caseBranchAction(final BranchAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		EList<AbstractBranchTransition> abtList = action.getBranches_Branch();
		for (AbstractBranchTransition abt : abtList) {
			doSwitch(abt);
		}
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/**
	 * Handles collection iterator actions.
	 * 
	 * Invokes the collectionIteratorHandler, then goes to the next action.
	 * 
	 * @param action
	 *            the collection iterator action
	 * @return the collection iterator action
	 */
	@Override
	public Object caseCollectionIteratorAction(
			final CollectionIteratorAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		collectionIteratorHandler.handle(action);
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/**
	 * Handles external call actions.
	 * 
	 * Invokes the externalCallHandler, then goes to the next action.
	 * 
	 * @param action
	 *            the external call action
	 * @return the external call action
	 */
	@Override
	public Object caseExternalCallAction(final ExternalCallAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		externalCallHandler.handle(action);
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/**
	 * Handles fork actions.
	 * 
	 * Invokes the forkActionHandler, then goes to the next action.
	 * 
	 * @param action
	 *            the fork action
	 * @return the fork action
	 */
	@Override
	public Object caseForkAction(final ForkAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		forkHandler.handle(action);
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/**
	 * Handles guarded branch transitions.
	 * 
	 * Invokes the guardedBranchHandler.
	 * 
	 * @param transition
	 *            the branch transition
	 * @return the branch transition
	 */
	@Override
	public Object caseGuardedBranchTransition(
			final GuardedBranchTransition transition) {
		guardedBranchHandler.handle(transition);
		return transition;
	}

	/**
	 * Handles internal actions.
	 * 
	 * Invokes the internalActionHandler, then goes to the next action.
	 * 
	 * @param action
	 *            the internal action
	 * @return the internal action
	 */
	@Override
	public Object caseInternalAction(final InternalAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		internalActionHandler.handle(action);
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/**
	 * Handles loop actions.
	 * 
	 * Invokes the loopActionHandler, then goes to the next action.
	 * 
	 * @param action
	 *            the loop action
	 * @return the loop action
	 */
	@Override
	public Object caseLoopAction(final LoopAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		loopHandler.handle(action);
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/**
	 * Handles probabilistic branch transitions.
	 * 
	 * Invokes the probabilisticBranchHandler, then goes to the next action.
	 * 
	 * @param transition
	 *            the branch transition
	 * @return the branch transition
	 */
	@Override
	public Object caseProbabilisticBranchTransition(
			final ProbabilisticBranchTransition transition) {
		probabilisticBranchHandler.handle(transition);
		return transition;
	}

	/**
	 * Handles release actions.
	 * 
	 * Nothing to do for the dependency solver. Just goes to the next action.
	 * 
	 * @param action
	 *            the release action
	 * @return the release action
	 */
	@Override
	public Object caseReleaseAction(final ReleaseAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/**
	 * Handles resource demanding behaviours.
	 * 
	 * Goes to the first action within the behaviour.
	 * 
	 * @param behaviour
	 *            the resource demanding behaviour
	 * @return the resource demanding behaviour
	 */
	@Override
	public Object caseResourceDemandingBehaviour(
			final ResourceDemandingBehaviour behaviour) {
		doSwitch(getStartAction(behaviour));
		return behaviour;
	}

	/**
	 * Handles resource demanding seffs.
	 * 
	 * Goes to the first action within the seff.
	 * 
	 * @param behaviour
	 *            the resource demanding seff
	 * @return the resource demanding seff
	 */
	@Override
	public Object caseResourceDemandingSEFF(
			final ResourceDemandingSEFF behaviour) {
		ResourceDemandingBehaviour rdb = (ResourceDemandingBehaviour) behaviour;
		doSwitch(getStartAction(rdb));
		return behaviour;
	}

	/**
	 * Handles set variable actions.
	 * 
	 * Invokes the setVariableHandler, then goes to the next action.
	 * 
	 * @param action
	 *            the set variable action
	 * @return the set variable action
	 */
	@Override
	public Object caseSetVariableAction(final SetVariableAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		setVariableHandler.handle(action);
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/**
	 * Handles start actions.
	 * 
	 * Nothing to do for the dependency solver. Just goes to the next action.
	 * 
	 * @param action
	 *            the start action
	 * @return the start action
	 */
	@Override
	public Object caseStartAction(final StartAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/**
	 * Handles stop actions.
	 * 
	 * Saves the contexts that have been created for the surrounding resource
	 * demanding seff.
	 * 
	 * @param action
	 *            the stop action
	 * @return the stop action
	 */
	@Override
	public Object caseStopAction(final StopAction action) {
		logger.debug("Visit " + action.getClass().getSimpleName() + " \""
				+ action.getEntityName() + "\"");
		if (action.eContainer() instanceof ResourceDemandingSEFF) {
			saveContexts();
		}
		// no more doSwitch, visitor ends here!
		return action;
	}

	/**
	 * Retrieves the context wrapper.
	 * 
	 * @return the context wrapper
	 */
	public ContextWrapper getContextWrapper() {
		return contextWrapper;
	}

	/**
	 * Sets the context wrapper.
	 * 
	 * @param wrapper
	 *            the context wrapper
	 */
	public void setContextWrapper(final ContextWrapper wrapper) {
		contextWrapper = wrapper;
	}

	/**
	 * Searches for a StartAction within the chain of AbstractActions of the
	 * behaviour and returns it.
	 * 
	 * @param behaviour
	 *            the behaviour
	 * @return the start action
	 */
	private StartAction getStartAction(
			final ResourceDemandingBehaviour behaviour) {
		StartAction startAction = (StartAction) EMFQueryHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		return startAction;
	}

	/**
	 * Stores the just built usage and actual allocation context to the PCM
	 * instance.
	 */
	private void saveContexts() {
		// ComputedUsageContext usageContext = contextWrapper.getCompUsgCtx();
		// contextWrapper.getPcmInstance().getComputedUsage().getUsageContexts_ComputedUsage().add(usageContext);
		// ComputedAllocationContext actAll = contextWrapper.getCompAllCtx();
		// contextWrapper.getPcmInstance().getComputedAllocation().getComputedAllocationContexts_ComputedAllocation().add(actAll);
	}
}
