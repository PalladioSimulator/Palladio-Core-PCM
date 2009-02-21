/**
 * 
 */
package de.uka.ipd.sdq.pcmsolver.visitors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.handler.CollectionIteratorActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.ExternalCallActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.GuardedBranchTransitionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.InternalActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.LoopActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.ProbabilisticBranchTransitionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.SetVariableActionHandler;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;

/**
 * @author Koziolek
 * 
 */
public class SeffVisitor extends SeffSwitch {

	private static Logger logger = Logger.getLogger(SeffVisitor.class.getName());

	private ContextWrapper contextWrapper;

	private ExternalCallActionHandler extCallAH;
	private InternalActionHandler intAH;
	private GuardedBranchTransitionHandler guardedBTH;
	private ProbabilisticBranchTransitionHandler probBTH;
	private CollectionIteratorActionHandler collIterAH;
	private LoopActionHandler loopAH;
	private SetVariableActionHandler setVarAH;
	
	/**
	 * @param inst
	 * @param callContext
	 */
	public SeffVisitor(ContextWrapper ctxWrp) {
		contextWrapper = ctxWrp;
		
		extCallAH = new ExternalCallActionHandler(this);
		intAH = new InternalActionHandler(this);
		guardedBTH = new GuardedBranchTransitionHandler(this);
		probBTH = new ProbabilisticBranchTransitionHandler(this);
		collIterAH = new CollectionIteratorActionHandler(this);
		loopAH = new LoopActionHandler(this);
		setVarAH = new SetVariableActionHandler(this);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseResourceDemandingSEFF(de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF)
	 */
	@Override
	public Object caseResourceDemandingSEFF(ResourceDemandingSEFF seff) {
		logger.debug("Visit"+seff.getClass().getSimpleName());
		ResourceDemandingBehaviour rdb = (ResourceDemandingBehaviour) seff;
		doSwitch(getStartAction(rdb));
		return seff;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseResourceDemandingBehaviour(de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour)
	 */
	@Override
	public Object caseResourceDemandingBehaviour(
			ResourceDemandingBehaviour behaviour) {
		logger.debug("Visit"+behaviour.getClass().getSimpleName());
		doSwitch(getStartAction(behaviour));
		return behaviour;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseStartAction(de.uka.ipd.sdq.pcm.seff.StartAction)
	 */
	@Override
	public Object caseStartAction(StartAction start) {
		logger.debug("Visit"+start.getClass().getSimpleName());
		doSwitch(start.getSuccessor_AbstractAction());
		return start;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseStopAction(de.uka.ipd.sdq.pcm.seff.StopAction)
	 */
	@Override
	public Object caseStopAction(StopAction object) {
		logger.debug("Visit"+object.getClass().getSimpleName());
		if (object.eContainer() instanceof ResourceDemandingSEFF){
			saveContexts();			
		}
		// no more doSwitch, visitor ends here!
		return object;
	}

	@Override
	public Object caseInternalAction(InternalAction action) {
		logger.debug("Visit"+action.getClass().getSimpleName());
		intAH.handle(action);
		doSwitch(action.getSuccessor_AbstractAction());
		return action;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseBranchAction(de.uka.ipd.sdq.pcm.seff.BranchAction)
	 */
	@Override
	public Object caseBranchAction(BranchAction branch) {
		logger.debug("Visit"+branch.getClass().getSimpleName());
		EList<AbstractBranchTransition> abtList = branch.getBranches_Branch();
		for (AbstractBranchTransition abt : abtList) doSwitch(abt);
		doSwitch(branch.getSuccessor_AbstractAction());
		return branch;
	}
	
	@Override
	public Object caseGuardedBranchTransition(GuardedBranchTransition gbt) {
		guardedBTH.handle(gbt);
		return gbt;
	}

	@Override
	public Object caseProbabilisticBranchTransition(ProbabilisticBranchTransition pbt) {
		probBTH.handle(pbt);
		return pbt;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseLoopAction(de.uka.ipd.sdq.pcm.seff.LoopAction)
	 */
	@Override
	public Object caseLoopAction(LoopAction loop) {
		logger.debug("Visit"+loop.getClass().getSimpleName());
		loopAH.handle(loop);
		doSwitch(loop.getSuccessor_AbstractAction());
		return loop;
	}
	
	@Override
	public Object caseCollectionIteratorAction(CollectionIteratorAction ciAction) {
		logger.debug("Visit"+ciAction.getClass().getSimpleName());
		collIterAH.handle(ciAction);
		doSwitch(ciAction.getSuccessor_AbstractAction());
		return ciAction;
	}

	@Override
	public Object caseExternalCallAction(ExternalCallAction call) {
		logger.debug("Visit"+call.getClass().getSimpleName()+" "+call.getCalledService_ExternalService().getServiceName());
		extCallAH.handle(call);
		doSwitch(call.getSuccessor_AbstractAction());
		return call;
	}

	@Override
	public Object caseSetVariableAction(SetVariableAction object) {
		logger.debug("Visit"+object.getClass().getSimpleName());
		setVarAH.handle(object);
		doSwitch(object.getSuccessor_AbstractAction());
		return object;
	}

	/**
	 * Stores the just built usage and actual allocation context to pcminstance
	 */
	private void saveContexts() {
//		ComputedUsageContext usageContext = contextWrapper.getCompUsgCtx();
//		contextWrapper.getPcmInstance().getComputedUsage().getUsageContexts_ComputedUsage().add(usageContext);
//		ComputedAllocationContext actAll = contextWrapper.getCompAllCtx();
//		contextWrapper.getPcmInstance().getComputedAllocation().getComputedAllocationContexts_ComputedAllocation().add(actAll);
	}

	/**
	 * Searches for a StartAction within the chain of AbstractActions
	 * of the behaviour and returns it.
	 * @param behaviour
	 * @return
	 */
	private StartAction getStartAction(ResourceDemandingBehaviour behaviour) {
		StartAction startAction = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		return startAction;
	}

	public ContextWrapper getContextWrapper() {
		return contextWrapper;
	}

	public void setContextWrapper(ContextWrapper ctxWrp) {
		contextWrapper = ctxWrp;
	}
}
