package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityDefType;
import LqnCore.ActivityMakingCallType;
import LqnCore.ActivityOrType;
import LqnCore.ActivityPhasesType;
import LqnCore.ActivityType;
import LqnCore.CallOrderType;
import LqnCore.EntryType;
import LqnCore.LqnCoreFactory;
import LqnCore.PhaseActivities;
import LqnCore.PrecedenceType;
import LqnCore.ProcessorType;
import LqnCore.SchedulingType;
import LqnCore.TaskSchedulingType;
import LqnCore.TaskType;
import LqnCore.TypeType;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.probfunction.math.IContinousPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.stoex.Expression;

/**
 * Visits one SEFF. An {@link Rdseff2Lqn} instance creates a new 
 * {@link Rdseff2Lqn} instance when visiting an external call, this new one
 * is responsible for the other SEFF. 
 * 
 * Thus, only information local to this SEFF could be stored as member variables here. 
 *  
 * @author koziolek, martens
 *
 */
public class Rdseff2Lqn extends SeffSwitch {

	private static Logger logger = Logger.getLogger(Rdseff2Lqn.class.getName());
	
	private ContextWrapper contextWrapper;
	private LqnBuilder lqnBuilder;
	
	public Rdseff2Lqn(LqnBuilder aLqnBuilder, ContextWrapper aContextWrapper) {
		lqnBuilder = aLqnBuilder;
		contextWrapper = aContextWrapper;
	}

	/**
	 * Does nothing yet, is ignored and the visitor continues with the successor.
	 * Can be implemented with a Semaphore task in LQN. 
	 * 
	 * Excerpt from LQN 4.3 documentation:
	 * 
	 * Semaphore Task: Semaphore tasks are used to model passive resources such as buffers. They always have two entries
	 * which are used to signal and wait the semaphore. The wait entry must be called using a synchronous request
	 * whereas the signal entry can be called using any type of request. Once a request is accepted by the wait entry,
	 * no further requests will be accepted until a request is processed by the signal entry. The signal and wait entries
	 * do not have to called from a common task. However, the two entries must share a common call graph, and the
	 * call graph must be deterministic. The entries themselves can be defined using phases or activies and can make
	 * requests to other tasks. Counting semaphores can be modeled using a multiserver.
	 * 
	 */
	@Override
	public Object caseAcquireAction(AcquireAction object) {
		
		String successorId;
		if (lqnBuilder.isLQSimAnalysis()) {
			String id = Pcm2LqnHelper.getId(object, contextWrapper);
			String passiveResourceId = Pcm2LqnHelper.getIdForPassiveResource(object.getPassiveresource_AcquireAction(), contextWrapper.getAssCtx());
			
			ProcessorType pt = lqnBuilder.addProcessor(passiveResourceId);
			
			lqnBuilder.addSemaphoreTask(passiveResourceId, pt, Integer.valueOf(object
					.getPassiveresource_AcquireAction()
					.getCapacity_PassiveResource().getSpecification()));

			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			adt.setCallOrder(CallOrderType.DETERMINISTIC);
			
			lqnBuilder.addActivityMakingCall(id, Pcm2LqnHelper.getWaitEntryId(passiveResourceId));
			successorId = (String) doSwitch(object
					.getSuccessor_AbstractAction());
			lqnBuilder.addSequencePrecedence(id, successorId);
			return id;
		} else {
			logger.warn("Ignored release action because it is not supported by LQNS. Be aware that the passive resource is not analysed.");
			successorId = (String) doSwitch(object
					.getSuccessor_AbstractAction());
			return successorId;
		}
		
		
	}

	/**
	 * Does nothing yet, is ignored and the visitor continues with the successor.
	 */
	@Override
	public Object caseReleaseAction(ReleaseAction object) {
		
		String successorId;
		if (lqnBuilder.isLQSimAnalysis()) {
			String id = Pcm2LqnHelper.getId(object, contextWrapper);
			
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			adt.setCallOrder(CallOrderType.DETERMINISTIC);
			
			String passiveResourceId = Pcm2LqnHelper.getIdForPassiveResource(object.getPassiveResource_ReleaseAction(), contextWrapper.getAssCtx());
			
			lqnBuilder.addActivityMakingCall(id, Pcm2LqnHelper.getSignalEntryId(passiveResourceId));
			successorId = (String) doSwitch(object.getSuccessor_AbstractAction());
			lqnBuilder.addSequencePrecedence(id, successorId);
			return id;
		
		} else {
			logger.warn("Ignored release action because it is not supported by LQNS. Be aware that the passive resource is not analysed.");
			successorId = (String) doSwitch(object
					.getSuccessor_AbstractAction());
			return successorId;
		}
		
	}

	@Override
	public Object caseResourceDemandingSEFF(ResourceDemandingSEFF object) {
		String id = Pcm2LqnHelper.getId(object, contextWrapper);
				
		ProcessorType pt = lqnBuilder.addProcessor(id);
		
		TaskType tt = lqnBuilder.addTask(id, pt);
		//tt.setMultiplicity(new BigInteger("1"));
		//tt.setScheduling(TaskSchedulingType.INF);

		EntryType et = lqnBuilder.addEntry(id, tt);
		lqnBuilder.addTaskActivityGraph(tt);
		
		ResourceDemandingBehaviour rdb = (ResourceDemandingBehaviour)object;
		String startId = (String)doSwitch(getStartAction(rdb));
		String stopId = Pcm2LqnHelper.getId(getStopAction(rdb), contextWrapper);
		lqnBuilder.addReplyActivity(id, startId, stopId);
		
		lqnBuilder.restoreFormerTaskActivityGraph();
		
		return et.getName();
	}

	@Override
	public Object caseLoopAction(LoopAction object) {
		String id = Pcm2LqnHelper.getId(object, contextWrapper);
		handleLoop(object, id);
		return id;
		
	}

	private void handleLoop(AbstractLoopAction object, String id) {
		String startId = handleLoopBody(object,id);
		lqnBuilder.addActivityDef(id); // for the loop action
		// makes an external call to the task representing the loop body:
		ActivityMakingCallType amct = lqnBuilder.addActivityMakingCall(id,
				startId);
		amct.setCallsMean(getLoopIterations(object));

		String successorId = (String)doSwitch(object.getSuccessor_AbstractAction());
		lqnBuilder.addSequencePrecedence(id, successorId);
	}
	
	private String handleLoopBody(AbstractLoopAction loop,String id) {
		ProcessorType pt = lqnBuilder.addProcessor(id);
		TaskType tt = lqnBuilder.addTask(id,pt);
		EntryType et = lqnBuilder.addEntry(id,tt);
		lqnBuilder.addTaskActivityGraph(tt);

		ResourceDemandingBehaviour rdb = loop.getBodyBehaviour_Loop();
		String startId = (String) doSwitch(getStartAction(rdb));
		String stopId = Pcm2LqnHelper.getId(getStopAction(rdb), contextWrapper);
		lqnBuilder.addReplyActivity(id, startId, stopId);
		
		lqnBuilder.restoreFormerTaskActivityGraph();
		
		return startId;
	}

	private String getLoopIterations(AbstractLoopAction loop) {
		ManagedPMF pmf = contextWrapper.getLoopIterations(loop);
		if (pmf != null) {
			try {
				return pmf.getPmfTimeDomain().getArithmeticMeanValue() + "";
			} catch (DomainNotNumbersException e) {
				return "0.0";
			} catch (FunctionNotInTimeDomainException e) {
				return "0.0";
			}
		} else {
			return "0.0";
		}
	}

	@Override
	public Object caseCollectionIteratorAction(CollectionIteratorAction object) {
		String id = Pcm2LqnHelper.getId(object, contextWrapper);
		handleLoop(object, id);
		return id;
	}

	@Override
	public Object caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
		return doSwitch(getStartAction(object));
	}
	
	@Override
	public Object caseStartAction(StartAction object) {
		String id = Pcm2LqnHelper.getId(object, contextWrapper);
		String entryId = "";
		
		if (object.eContainer() instanceof ResourceDemandingSEFF){
			ResourceDemandingSEFF rdseff = (ResourceDemandingSEFF)object.eContainer();
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			entryId = Pcm2LqnHelper.getId(rdseff, contextWrapper)+"_Entry";
			adt.setBoundToEntry(entryId);
		} else if (object.eContainer().eContainer() instanceof LoopAction){
			LoopAction la = (LoopAction)object.eContainer().eContainer();
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			entryId = Pcm2LqnHelper.getId(la, contextWrapper)+"_Entry";
			adt.setBoundToEntry(entryId);
		} else if (object.eContainer().eContainer() instanceof CollectionIteratorAction){
			CollectionIteratorAction cia = (CollectionIteratorAction)object.eContainer().eContainer();
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			entryId = Pcm2LqnHelper.getId(cia, contextWrapper)+"_Entry";
			adt.setBoundToEntry(entryId);
		} else { //nested resource demanding behaviour
			lqnBuilder.addActivityDef(id);
		}
		
		String successorId = (String) doSwitch(object.getSuccessor_AbstractAction());
		lqnBuilder.addSequencePrecedence(id, successorId);
		
		if (entryId.equals("")) return id;
		else return entryId;
	}
	

	@Override
	public Object caseBranchAction(BranchAction object) {
		String id = Pcm2LqnHelper.getId(object, contextWrapper);
		
		lqnBuilder.addActivityDef(id);
		PrecedenceType ptBegin = lqnBuilder.addBeginBranchPrecedence(id);
		PrecedenceType ptEnd = lqnBuilder.addEndBranchPrecedence();

		EList<AbstractBranchTransition> btList = object.getBranches_Branch();
		for (AbstractBranchTransition bt : btList) {
			ResourceDemandingBehaviour rdb = bt.getBranchBehaviour_BranchTransition();

			// the lqn solver complains if a branch has zero probability
//			if(contextWrapper.getBranchProbability(bt)!=0.0){
			Double branchProbNumeric = new Double(contextWrapper.getBranchProbability(bt));
			if (branchProbNumeric > 0){
				String startId = (String) doSwitch(rdb);
	
				String branchProb = branchProbNumeric.toString();
				
				lqnBuilder.addActivityOrType(startId,branchProb, ptBegin);

				String stopId = Pcm2LqnHelper.getId(getStopAction(rdb), contextWrapper);
				lqnBuilder.addActivityType(stopId, ptEnd);
			}
		}

		String successorId = (String) doSwitch(object.getSuccessor_AbstractAction());
		ptEnd.getPost().getActivity().setName(successorId);

		//If a precedence with exactly the same activities is already there, 
		//this one needs to be deleted. 
		//This can happen if this SEFF is called from multiple contexts. 
		//TODO: should we not be able to distinguish multiple contexts?
		// -> I have put the deletion of duplicate precedences in the LQNBuilder. 
		

		return id;
	}

	@Override
	public Object caseSetVariableAction(SetVariableAction object) {
		Pcm2LqnHelper.getId(object, contextWrapper);
		return doSwitch(object.getSuccessor_AbstractAction());
	}

	@Override
	public Object caseExternalCallAction(ExternalCallAction object) {
		String id = Pcm2LqnHelper.getId(object, contextWrapper);
		
		AllocationContext from = contextWrapper.getAllCtx();
		
		ResourceDemandingSEFF seff = (ResourceDemandingSEFF)contextWrapper.getNextSEFF(object);
		if (seff == null){
			// this is a system external call
			// we continue with the internal action added after this action
			return doSwitch(object.getSuccessor_AbstractAction());
		} else {
			ContextWrapper oldContextWrapper = (ContextWrapper)contextWrapper.clone();
			contextWrapper = contextWrapper.getContextWrapperFor(object);
			
			AllocationContext to = contextWrapper.getAllCtx();
			
			String entryId = "";
			Rdseff2Lqn seffVisitor = new Rdseff2Lqn(lqnBuilder, contextWrapper);
			try {
				entryId = (String)seffVisitor.doSwitch(seff);
			} catch (RuntimeException e) {
				logger.error("Error while visiting RDSEFF");
				e.printStackTrace();
				throw e;
			}
			
			contextWrapper = oldContextWrapper;
			
			lqnBuilder.addActivityDef(id);
			lqnBuilder.addActivityMakingCall(id, entryId);
			
			String successorId = (String) doSwitch(object.getSuccessor_AbstractAction());
			
			// Add linking resource demand if this is a remote call.
			// careful: The linking resource processor is also only generated if the latency is != 0. 
			if (from.getResourceContainer_AllocationContext() != to.getResourceContainer_AllocationContext()){
				// call latency entry of linking resource before and after call.
				
				// get resource that connects the two
				CommunicationLinkResourceSpecification link = oldContextWrapper.getConcreteLinkingResource(object);
				
				// only create a call if latency is larger than 0
				if (Double.valueOf(link.getLatency_CommunicationLinkResourceSpecification().getSpecification()) > 0){

					String linkId = Pcm2LqnHelper.getIdForCommResource(link.getLinkingResource_CommunicationLinkResourceSpecification(), link.getCommunicationLinkResourceType_CommunicationLinkResourceSpecification());
					String latencyId = Pcm2LqnHelper.getIdForLatency(linkId);

					String networkCallId = "LAN_"+id;
					String networkResponseId = "LAN_"+id+"_return";

					lqnBuilder.addActivityDef(networkCallId);
					lqnBuilder.addActivityMakingCall(networkCallId, latencyId+"_Entry");

					lqnBuilder.addActivityDef(networkResponseId);
					lqnBuilder.addActivityMakingCall(networkResponseId, latencyId+"_Entry");

					// TODO: call throughput entry if bytesize characterization is available
					// there is sme very initial implementation at 
					// contextWrapper.getDelayOnLinkingResource(eca, clrs);
					// pay attention to use the right context wraper (old or new?)

					//first LAN, then external, then LAN, then successor
					lqnBuilder.addSequencePrecedence(networkCallId, id);
					lqnBuilder.addSequencePrecedence(id, networkResponseId);
					lqnBuilder.addSequencePrecedence(networkResponseId, successorId);

					return networkCallId;
				}
				// else go to return statement below and return the id of the external call itself.
			} 
			
			//only come here if no linking resource calls have been created.  
			lqnBuilder.addSequencePrecedence(id, successorId);

			return id; // for predecessor



		}
	}

	@Override
	public Object caseInternalAction(InternalAction object) {
		String id = Pcm2LqnHelper.getId(object, contextWrapper);
		
		EList<ParametricResourceDemand> resDemList = object.getResourceDemand_Action();
		int counter = 0; // for the number of resource demands (mapped to entry name)
		for (ParametricResourceDemand resourceDemand : resDemList){
			String processorId = getProcessorName(resourceDemand);

//			// create a new task for the resource demand
//			ProcessorType pt = lqnBuilder.getProcessor(processorId);
//			TaskType tt = lqnBuilder.addTaskForResourceDemand(id+counter, pt);
//			EntryType et = lqnBuilder.addEntry(id+counter, tt);
//			et.setType(TypeType.PH1PH2);
			
			// first a new entry for the resource demand
			TaskType tt = lqnBuilder.getTaskForProcessor(processorId);
			EntryType et = lqnBuilder.addEntry(id+counter, tt);
			et.setType(TypeType.PH1PH2);

			// the entry makes a call to the processor
			ActivityPhasesType apt = lqnBuilder.addActivityPhases(id+counter);
			Double demand = contextWrapper.getMeanTimeConsumption(resourceDemand);
			String hostDemand = demand.toString();
			apt.setHostDemandMean(hostDemand);
			
			//if continuous function, get coefficient of variance
			//TODO: also get this for stepwise defined functions!
			//Check whether this has been a distribution originally 
			if (contextWrapper.getIsOriginalPDFFor(resourceDemand)){
				ManagedPDF pdf = contextWrapper.getTimeConsumptionAsPDF(resourceDemand);
				IProbabilityDensityFunction innerPDF = pdf.getPdfTimeDomain();
				if (innerPDF instanceof IContinousPDF){
					IContinousPDF innerContPDF = (IContinousPDF)innerPDF; 
					double coeffv = innerContPDF.getCoefficientOfVariance();
					Double squaredcv = coeffv * coeffv;
					apt.setHostDemandCvsq(squaredcv.toString());
				}
			}
			
			PhaseActivities pa = lqnBuilder.addPhaseActivities(apt);
			et.setEntryPhaseActivities(pa);
			
			// now another activity in the current task graph making the 
			// call to the entry created for the resource demand
			lqnBuilder.addActivityDef(id+counter);
			lqnBuilder.addActivityMakingCall(id+counter, et.getName());
			if (counter<resDemList.size()-1){
				lqnBuilder.addSequencePrecedence(id+counter, id+(counter+1));	
			}
			
			counter++;
		}
		
		String successorId = (String) doSwitch(object.getSuccessor_AbstractAction());
		if ( resDemList.size() > 0){
			//Only add a sequence predecence if there actually was a resource demand in the list, i.e. if an activity etc. has been created
			lqnBuilder.addSequencePrecedence(id+(counter-1), successorId);
			return id+0; // for predecessor
		} else {
			//If no resource demands were there, just let the predecessor connect itself to this action's successor (action disappears)
			return successorId;
		}


	}

	private String getProcessorName(ParametricResourceDemand resourceDemand) {
		ProcessingResourceSpecification prs = contextWrapper.getConcreteProcessingResource(resourceDemand);
		if (prs == null){
			throw new RuntimeException("Could not find "+ProcessingResourceSpecification.class.getName()
					+"of type "+resourceDemand.getRequiredResource_ParametricResourceDemand().getEntityName()+"(id:"+resourceDemand.getRequiredResource_ParametricResourceDemand().getId()+")"
					+" adressed by resource demand of action "+resourceDemand.getAction_ParametricResourceDemand().getEntityName()+" ("+resourceDemand.getAction_ParametricResourceDemand().getId()+"). Check your model that the required resources are available on the server.");
		}
		ResourceContainer rc = (ResourceContainer)prs.eContainer();
		ProcessingResourceType prt = prs.getActiveResourceType_ActiveResourceSpecification();
		String name = Pcm2LqnHelper.getIdForProcResource(rc, prt); 
		return name;
	}

	@Override
	public Object caseStopAction(StopAction object) {
		String id = Pcm2LqnHelper.getId(object, contextWrapper);
		lqnBuilder.addActivityDef(id);
		// Precedence has already been created by predecessor
		return id;
	}
	
	private StartAction getStartAction(ResourceDemandingBehaviour behaviour) {
		StartAction startAction = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		return startAction;
	}

	
	private StopAction getStopAction(ResourceDemandingBehaviour behaviour) {
		StopAction stopAction = (StopAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StopAction.class);
		return stopAction;
	}
	
}
