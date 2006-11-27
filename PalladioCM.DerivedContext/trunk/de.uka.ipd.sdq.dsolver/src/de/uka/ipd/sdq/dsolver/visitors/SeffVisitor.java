/**
 * 
 */
package de.uka.ipd.sdq.dsolver.visitors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.allocation.ActualAllocationContext;
import de.uka.ipd.sdq.context.usage.Usage;
import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.dsolver.PCMInstance;
import de.uka.ipd.sdq.dsolver.handler.AbstractHandler;
import de.uka.ipd.sdq.dsolver.helper.EMFHelper;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;

/**
 * @author Koziolek
 * 
 */
public class SeffVisitor extends SeffSwitch {

	private static Logger logger = Logger.getLogger(SeffVisitor.class.getName());

	private Context myContext;

	private PCMInstance pcmInstance;

	private AbstractHandler handler;
	/**
	 * @param inst
	 * @param callContext
	 */
	public SeffVisitor(PCMInstance inst, Context callContext) {
		pcmInstance = inst;
		myContext = callContext;
		handler = AbstractHandler.createHandler(this);
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
	public Object caseStartAction(StartAction object) {
		return caseDefault(object);
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

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseInternalAction(de.uka.ipd.sdq.pcm.seff.InternalAction)
	 */
	@Override
	public Object caseInternalAction(InternalAction action) {
		return caseDefault(action);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseBranchAction(de.uka.ipd.sdq.pcm.seff.BranchAction)
	 */
	@Override
	public Object caseBranchAction(BranchAction branch) {
		return caseDefault(branch);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseLoopAction(de.uka.ipd.sdq.pcm.seff.LoopAction)
	 */
	@Override
	public Object caseLoopAction(LoopAction loop) {
		return caseDefault(loop);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseAquireAction(de.uka.ipd.sdq.pcm.seff.AquireAction)
	 */
	@Override
	public Object caseAquireAction(AquireAction acquire) {
		return caseDefault(acquire);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseReleaseAction(de.uka.ipd.sdq.pcm.seff.ReleaseAction)
	 */
	@Override
	public Object caseReleaseAction(ReleaseAction release) {
		return caseDefault(release);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseExternalCallAction(de.uka.ipd.sdq.pcm.seff.ExternalCallAction)
	 */
	@Override
	public Object caseExternalCallAction(ExternalCallAction call) {
		logger.debug("Calling "
				+ call.getCalledService_ExternalService().getServiceName());
		return caseDefault(call);
	}

	/**
	 * @param object
	 * @return
	 */
	private Object caseDefault(AbstractAction object) {
		logger.debug("Visit"+object.getClass().getSimpleName());

		// solve the dependencies for a particular type of action
		// (invokes chain of responsibility of handlers)
		handler.handle(object);
		
		// visit the following action 
		doSwitch(object.getSuccessor_AbstractAction());
		
		return object;
	}

	/**
	 * Stores the just built usage and actual allocation context to pcminstance
	 */
	private void saveContexts() {
		UsageContext usageContext = myContext.getUsageContext();
		pcmInstance.getUsage().getUsageContexts_Usage().add(usageContext);
		ActualAllocationContext actAll = myContext.getActualAllocationContext();
		pcmInstance.getActualAllocation().getActualAllocationContexts_ActualAllocation().add(actAll);
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

	public Context getMyContext() {
		return myContext;
	}

	public void setMyContext(Context myContext) {
		this.myContext = myContext;
	}

	public PCMInstance getPcmInstance() {
		return pcmInstance;
	}

	public void setPcmInstance(PCMInstance pcmInstance) {
		this.pcmInstance = pcmInstance;
	}
	
}
