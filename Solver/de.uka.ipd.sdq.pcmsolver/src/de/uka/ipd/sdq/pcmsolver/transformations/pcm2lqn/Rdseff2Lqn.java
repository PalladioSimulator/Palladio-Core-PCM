package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityDefType;
import LqnCore.ActivityMakingCallType;
import LqnCore.ActivityPhasesType;
import LqnCore.CallOrderType;
import LqnCore.EntryType;
import LqnCore.PhaseActivities;
import LqnCore.PrecedenceType;
import LqnCore.ProcessorType;
import LqnCore.TaskType;
import LqnCore.TypeType;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFQueryHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.probfunction.math.IContinousPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;

/**
 * Visits one SEFF. An {@link Rdseff2Lqn} instance creates a new 
 * {@link Rdseff2Lqn} instance when visiting an external call, this new one
 * is responsible for the other SEFF. 
 * 
 * Thus, only information local to this SEFF could be stored as member variables here.
 * 
 *  Each visitor method (case*) returns the id of the first generated LQN model element, 
 *  so that it can be used by the handler of the previous model element
 *  to connect itself to this successor.
 *  
 * @author koziolek, martens
 *
 */
public class Rdseff2Lqn extends SeffSwitch<String> {

	private static Logger logger = Logger.getLogger(Rdseff2Lqn.class.getName());

	private ContextWrapper myContextWrapper;
	private LqnBuilder lqnBuilder;
	
	public Rdseff2Lqn(LqnBuilder aLqnBuilder, ContextWrapper aContextWrapper) {
		lqnBuilder = aLqnBuilder;
		myContextWrapper = aContextWrapper;
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
	public String caseAcquireAction(AcquireAction object) {
		
		String successorId;
		if (lqnBuilder.isLQSimAnalysis()) {
			String id = Pcm2LqnHelper.getId(object, myContextWrapper);
			String passiveResourceId = Pcm2LqnHelper.getIdForPassiveResource(object.getPassiveresource_AcquireAction(), myContextWrapper.getAllCtx());
			
			ProcessorType pt = lqnBuilder.addProcessor(passiveResourceId);
			
			lqnBuilder.addSemaphoreTask(passiveResourceId, pt, Integer.valueOf(object
					.getPassiveresource_AcquireAction()
					.getCapacity_PassiveResource().getSpecification()));

			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			adt.setCallOrder(CallOrderType.DETERMINISTIC);
			
			lqnBuilder.addActivityMakingCall(id, Pcm2LqnHelper.getWaitEntryId(passiveResourceId), CallType.SYNCH);
			successorId = (String) doSwitch(object
					.getSuccessor_AbstractAction());
			lqnBuilder.addSequencePrecedence(id, successorId);
			return id;
		} else {
			if (object.getPassiveresource_AcquireAction().getEntityName().toLowerCase().contains("pool")){
				logger.warn("Passive resource pool found. Support by PCM2LQN is limited. Please analyze the results carefully.");
				Integer poolCapacity = Integer.valueOf(object.getPassiveresource_AcquireAction().getCapacity_PassiveResource().getSpecification());	
				lqnBuilder.setPoolCapacity(poolCapacity);
			} else {
				logger.warn("Ignored release action because it is not supported by LQNS. Be aware that the passive resource is not analysed.");
			}
			successorId = (String) doSwitch(object
					.getSuccessor_AbstractAction());
			return successorId;
		}
		
		
	}

	/**
	 * Does nothing yet, is ignored and the visitor continues with the successor.
	 */
	@Override
	public String caseReleaseAction(ReleaseAction object) {
		
		String successorId;
		if (lqnBuilder.isLQSimAnalysis()) {
			String id = Pcm2LqnHelper.getId(object, myContextWrapper);
			
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			adt.setCallOrder(CallOrderType.DETERMINISTIC);
			
			String passiveResourceId = Pcm2LqnHelper.getIdForPassiveResource(object.getPassiveResource_ReleaseAction(), myContextWrapper.getAllCtx());
			
			lqnBuilder.addActivityMakingCall(id, Pcm2LqnHelper.getSignalEntryId(passiveResourceId), CallType.SYNCH);
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
	public String caseResourceDemandingSEFF(ResourceDemandingSEFF object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
				
		ProcessorType pt = lqnBuilder.addProcessor(id);
		
		TaskType tt = lqnBuilder.addTask(id, pt);
		//tt.setMultiplicity(new BigInteger("1"));
		//tt.setScheduling(TaskSchedulingType.INF);

		EntryType et = lqnBuilder.addEntry(id, tt);
		lqnBuilder.addTaskActivityGraph(tt);
		
		ResourceDemandingBehaviour rdb = (ResourceDemandingBehaviour)object;
		String startId = (String)doSwitch(getStartAction(rdb));
		String stopId = Pcm2LqnHelper.getId(getStopAction(rdb), myContextWrapper);
		lqnBuilder.addReplyActivity(id, startId, stopId);
		
		lqnBuilder.restoreFormerTaskActivityGraph();
		
		return et.getName();
	}

	@Override
	public String caseLoopAction(LoopAction object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		handleLoop(object, id);
		return id;
		
	}

	private void handleLoop(AbstractLoopAction object, String id) {
		String startId = handleLoopBody(object,id);
		lqnBuilder.addActivityDef(id); // for the loop action
		// makes an external call to the task representing the loop body:
		ActivityMakingCallType amct = lqnBuilder.addActivityMakingCall(id,
				startId, CallType.SYNCH);
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
		String stopId = Pcm2LqnHelper.getId(getStopAction(rdb), myContextWrapper);
		lqnBuilder.addReplyActivity(id, startId, stopId);
		
		lqnBuilder.restoreFormerTaskActivityGraph();
		
		return startId;
	}

	private String getLoopIterations(AbstractLoopAction loop) {
		ManagedPMF pmf = myContextWrapper.getLoopIterations(loop);
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
	public String caseCollectionIteratorAction(CollectionIteratorAction object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		handleLoop(object, id);
		return id;
	}

	@Override
	public String caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
		return doSwitch(getStartAction(object));
	}
	
	@Override
	public String caseStartAction(StartAction object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		String entryId = "";
		
		if (object.eContainer() instanceof ResourceDemandingSEFF){
			ResourceDemandingSEFF rdseff = (ResourceDemandingSEFF)object.eContainer();
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			entryId = Pcm2LqnHelper.getId(rdseff, myContextWrapper)+"_Entry";
			adt.setBoundToEntry(entryId);
		} else if (object.eContainer().eContainer() instanceof LoopAction){
			LoopAction la = (LoopAction)object.eContainer().eContainer();
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			entryId = Pcm2LqnHelper.getId(la, myContextWrapper)+"_Entry";
			adt.setBoundToEntry(entryId);
		} else if (object.eContainer().eContainer() instanceof CollectionIteratorAction){
			CollectionIteratorAction cia = (CollectionIteratorAction)object.eContainer().eContainer();
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			entryId = Pcm2LqnHelper.getId(cia, myContextWrapper)+"_Entry";
			adt.setBoundToEntry(entryId);
		} else if (object.eContainer().eContainer() instanceof SynchronisationPoint){
			lqnBuilder.addActivityDef(id);
		} else if (object.eContainer() instanceof ForkedBehaviour){
			ForkedBehaviour fb = (ForkedBehaviour)object.eContainer();
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			entryId = Pcm2LqnHelper.getIdForForkedBehaviour(fb, myContextWrapper)+"_Entry";
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
	public String caseBranchAction(BranchAction object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		
		lqnBuilder.addActivityDef(id);
		PrecedenceType ptBegin = lqnBuilder.addBeginBranchPrecedence(id);
		PrecedenceType ptEnd = lqnBuilder.addEndBranchPrecedence();

		EList<AbstractBranchTransition> btList = object.getBranches_Branch();
		for (AbstractBranchTransition bt : btList) {
			ResourceDemandingBehaviour rdb = bt.getBranchBehaviour_BranchTransition();

			// the lqn solver complains if a branch has zero probability
//			if(contextWrapper.getBranchProbability(bt)!=0.0){
			Double branchProbNumeric = myContextWrapper.getBranchProbability(bt);
			if (branchProbNumeric > 0){
				String startId = (String) doSwitch(rdb);
	
				String branchProb = branchProbNumeric.toString();
				
				lqnBuilder.addActivityOrType(startId,branchProb, ptBegin);

				String stopId = Pcm2LqnHelper.getId(getStopAction(rdb), myContextWrapper);
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
	public String caseSetVariableAction(SetVariableAction object) {
		Pcm2LqnHelper.getId(object, myContextWrapper);
		return doSwitch(object.getSuccessor_AbstractAction());
	}

	@Override
	public String caseExternalCallAction(ExternalCallAction object) {
		return handleExternalCallAction(object, CallType.SYNCH, object.getSuccessor_AbstractAction());
	}
	
	/**
	 * Handle an {@link ExternalCallAction}
	 * @param object The {@link ExternalCallAction}
	 * @param callType
	 * @param successor The successor action is determined by the caller, so that it does not necessarily have to be 
	 *        object.getSuccessor_AbstractAction(). For example, when simplifying a fork with internal ExternalCalls
	 *        to asynchronous LQN calls, the proper successor is the successor of the ForkAction, not of the 
	 *        ExternalCall (which is a StopAction that is pruned in that case) 
	 * @return The id of the first generated LQN model element, to be connected with the successor.  
	 */
	private String handleExternalCallAction(ExternalCallAction object, CallType callType, AbstractAction successor){
		String callId = Pcm2LqnHelper.getId(object, myContextWrapper);
		
		AllocationContext callerAllocationContext = myContextWrapper.getAllCtx();
		
		ResourceDemandingSEFF seff = (ResourceDemandingSEFF)myContextWrapper.getNextSEFF(object);
		if (seff == null){
			// this is a system external call
			// we continue with the internal action added after this action
			//logger.warn("Call "+object.getId()+" does not call a seff, ignoring it. Note that time required for system external calls are not supported by PCM2LQN yet.");
			return doSwitch(object.getSuccessor_AbstractAction());
		} else {
			ContextWrapper oldContextWrapper = (ContextWrapper)myContextWrapper.clone();


			List<ContextWrapper> contextWrapperList = myContextWrapper.getContextWrapperFor(object);
			List<AllocationContext> calledAllocationContextList = new ArrayList<AllocationContext>(contextWrapperList.size());
						
			// if one of the contextWrappers refers to the same allocation context than the current one, then 
			// then direct all calls to only this one
			// assume there is at most component instance per resource container (more should be prohibited by the metamodel)
			boolean localComponentInstanceAvailable = false;
			ContextWrapper localContextWrapper = null;
			for (ContextWrapper contextWrapper : contextWrapperList) {
				if (contextWrapper.getAllCtx().getId().equals(oldContextWrapper.getAllCtx().getId())){
					localComponentInstanceAvailable = true;
					localContextWrapper = contextWrapper;
					break;
				}
			}

			if (localComponentInstanceAvailable || contextWrapperList.size() == 1){
				// only one component instance is called (either there is only one, or there is a local one). 
				if (localContextWrapper != null){
					myContextWrapper = localContextWrapper;
				} else {
					myContextWrapper = contextWrapperList.get(0);
				}
				AllocationContext toAllocationContext = myContextWrapper.getAllCtx();
				calledAllocationContextList.add(toAllocationContext);

				// create LQN call
				createCallActivity(callId, seff, callType);

			} else {
				// need to create a branch because several remote component instances are called
				// thus, iterate over all context wrappers and call the following SEFF for them. 

				double branchProb = 1.0/contextWrapperList.size();

				for (ContextWrapper contextWrapper : contextWrapperList) {
					myContextWrapper = contextWrapper;

					AllocationContext toAllocationContext = myContextWrapper.getAllCtx();
					calledAllocationContextList.add(toAllocationContext);
					
					// create LQN call
					createCallActivity(callId, seff, callType, branchProb);

					// the ends of the branches are connected below after it has been decided whether to include network calls.
				}
				
			}

			myContextWrapper = oldContextWrapper;
			
			String successorId = (String) doSwitch(successor);
			
			// Handle network calls. 
			// Just create a network call before the call created above that calls any network, 
			// and another one for the response afterwards. 
			// this is inaccurate, because the network of replica 1 may be called before replica 2 is called now,  
			// the proper dependency is lost.  
			// For the LQNS MVA analysis, it does not matter, though, because the mean values will stay the same
			
			for (AllocationContext targetAllocationContext : calledAllocationContextList) {
				
				// Add linking resource demand if this is a remote call.
				// careful: The linking resource processor is only generated if the latency is != 0. 
				if (callerAllocationContext.getResourceContainer_AllocationContext() != targetAllocationContext.getResourceContainer_AllocationContext()){
					// call latency entry of linking resource before and after call.

					// get resource that connects the two
					CommunicationLinkResourceSpecification link = oldContextWrapper.getConcreteLinkingResource(object, targetAllocationContext);

					// only create a call if latency is larger than 0
					if (link != null && ExpressionHelper.getMeanValue(link.getLatency_CommunicationLinkResourceSpecification()) > 0){

						String linkId = Pcm2LqnHelper.getIdForCommResource(link.getLinkingResource_CommunicationLinkResourceSpecification(), link.getCommunicationLinkResourceType_CommunicationLinkResourceSpecification());
						String latencyId = Pcm2LqnHelper.getIdForLatency(linkId, callType);

						String networkCallId = "LAN_"+callId+"_"+callType;
						String networkResponseId = "LAN_"+callId+"_return";

						lqnBuilder.addActivityDef(networkCallId);
						lqnBuilder.addActivityMakingCall(networkCallId, latencyId+"_Entry", callType);

						// only response if it is a synch call
						if (callType == CallType.SYNCH){
							lqnBuilder.addActivityDef(networkResponseId);
							lqnBuilder.addActivityMakingCall(networkResponseId, latencyId+"_Entry", callType);
						}

						// TODO: call throughput entry if bytesize characterization is available
						// there is same very initial implementation at 
						// contextWrapper.getDelayOnLinkingResource(eca, clrs);
						// pay attention to use the right context wraper (old or new?)

						// first LAN call(s), then external call(s), then LAN call(s), then successor
						// no response for asynchronous call
						lqnBuilder.addSequencePrecedence(networkCallId, callId);
						if (callType == CallType.SYNCH){
							lqnBuilder.addSequencePrecedence(callId, networkResponseId);
							lqnBuilder.addSequencePrecedence(networkResponseId, successorId);
						} else {
							lqnBuilder.addSequencePrecedence(callId, successorId);
						}

						return networkCallId;
	

					} else {
						if (link == null){
							logger.warn("No link found between "+callerAllocationContext.getEntityName()+" <"+callerAllocationContext.getId()+"> and "+targetAllocationContext.getEntityName()+" <"+targetAllocationContext.getId()+"> , ignoring this.");
						}
					}
					// else go to return statement below and return the id of the external call itself.
				}
			}
			
            //only come here if no linking resource calls have been created, e.g. because there is no latency defined.  
			lqnBuilder.addSequencePrecedence(callId, successorId);
			
			
			
			// all possible communication paths are thus the following
			// replication and LAN:     branch, LAN, external, LAN, branch, successor
			// no replication and LAN:          LAN, external, LAN,         successor
            // no replication and local:             external,              successor
			//
			// The last combination, namely
			// replication and no LAN:  branch,      external,      branch, successor
			// is usually not used because two replicas cannot be on the same node, so branch is always combined with remote.
			// However, if a remote call has no latency specified, then this will be generated, ignoring the link. 
			// 
			
			return callId; // for predecessor
		}
	}
	
	private void createCallActivity(String callerId, ResourceDemandingSEFF sefftoBeCalled, CallType callType) {
		createCallActivity(callerId, sefftoBeCalled, callType, 1.0);
	}

	private void createCallActivity(String callerId, ResourceDemandingSEFF sefftoBeCalled, CallType callType, double callMeans) {
		String entryId = "";
		try {
			Rdseff2Lqn seffVisitor = new Rdseff2Lqn(lqnBuilder, myContextWrapper);
			entryId = (String)seffVisitor.doSwitch(sefftoBeCalled);
		} catch (RuntimeException e) {
			logger.error("Error while visiting RDSEFF "+sefftoBeCalled.getId());
			e.printStackTrace();
			throw e;
		}

		lqnBuilder.addActivityDef(callerId);
		lqnBuilder.addActivityMakingCall(callerId, entryId, callType, callMeans);
	}

	@Override
	public String caseInternalAction(InternalAction object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		
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
			Double demand = myContextWrapper.getMeanTimeConsumption(resourceDemand);
			String hostDemand = demand.toString();
			apt.setHostDemandMean(hostDemand);
			
			//if continuous function, get coefficient of variance
			//TODO: also get this for stepwise defined functions!
			//Check whether this has been a distribution originally 
			if (myContextWrapper.getIsOriginalPDFFor(resourceDemand)){
				ManagedPDF pdf = myContextWrapper.getTimeConsumptionAsPDF(resourceDemand);
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
			lqnBuilder.addActivityMakingCall(id+counter, et.getName(), CallType.SYNCH);
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
		ProcessingResourceSpecification prs = myContextWrapper.getConcreteProcessingResource(resourceDemand);
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
	public String caseStopAction(StopAction object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		lqnBuilder.addActivityDef(id);
		// Precedence has already been created by predecessor
		return id;
	}
	
	private StartAction getStartAction(ResourceDemandingBehaviour behaviour) {
		StartAction startAction = (StartAction) EMFQueryHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		return startAction;
	}

	
	private StopAction getStopAction(ResourceDemandingBehaviour behaviour) {
		StopAction stopAction = (StopAction) EMFQueryHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StopAction.class);
		return stopAction;
	}

	
	public String caseForkActionOld(ForkAction object) {
		// if this fork action is asynchronous and only contains an external call, 
		// it can be modelled in LQN by just changing the call to send-no-reply
		// TODO: for now only support one forked behaviour. TODO add several ones, 
		// should be possible to map them to the same constructs, too.
		if (object.getAsynchronousForkedBehaviours_ForkAction().size() == 1
				&& (object.getSynchronisingBehaviours_ForkAction() == null 
					|| object.getSynchronisingBehaviours_ForkAction().getSynchronousForkedBehaviours_SynchronisationPoint().size() == 0)){
			ForkedBehaviour innerFork = object.getAsynchronousForkedBehaviours_ForkAction().get(0);
			// if there is only an external call, that means there are three steps (start, call, stop) and one is an external call
			if (innerFork.getSteps_Behaviour().size() == 3){
				// find the external call action, the other two have to be start and stop in a valid model
				ExternalCallAction eca = null;
				for (AbstractAction action : innerFork.getSteps_Behaviour()) {
					if (action instanceof ExternalCallAction){
						eca = (ExternalCallAction)action;
						break;
					}
				}
				if (eca != null){
					// we have the preconditions for using an LQN send-no-response call
					return handleExternalCallAction(eca, CallType.ASYNCH, object.getSuccessor_AbstractAction());
				}
				// else return super.caseFork (i.e. go to end of method)
			}
				
		} 
		logger.warn("No arbitrary Fork action supported yet, only asnychronous Forks containing a single ExternalCall are supported.");
		
		return super.caseForkAction(object);
		
	}
	
	@Override
	public String caseForkAction(ForkAction object){
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		ActivityDefType adt = lqnBuilder.addActivityDef(id);

		String currentId = id;
		String predecessorId = id;

		EList<ForkedBehaviour> asyncBehList = object.getAsynchronousForkedBehaviours_ForkAction();
		for (ForkedBehaviour asyncBeh : asyncBehList){
			currentId = Pcm2LqnHelper.getIdForForkedBehaviour(asyncBeh, myContextWrapper);
			
			// create new task graph for the forked behaviour
			ProcessorType pt = lqnBuilder.addProcessor(currentId);
			TaskType tt = lqnBuilder.addTask(currentId,pt);
			EntryType et = lqnBuilder.addEntry(currentId,tt);
			lqnBuilder.addTaskActivityGraph(tt);

			// create the actions of the new task graph by traversing the forked behavior's steps
			doSwitch(getStartAction(asyncBeh));
			
			lqnBuilder.restoreFormerTaskActivityGraph();
			
			// create an asynchronous external call to the task representing the forked behaviour
			lqnBuilder.addActivityDef(currentId+"_Action");
			lqnBuilder.addActivityMakingCall(currentId+"_Action", currentId+"_Entry", CallType.ASYNCH);
			
			lqnBuilder.addSequencePrecedence(predecessorId, currentId+"_Action");
			predecessorId = currentId+"_Action";
			
		}
		
		if (object.getSynchronisingBehaviours_ForkAction() != null
			&& object.getSynchronisingBehaviours_ForkAction().getSynchronousForkedBehaviours_SynchronisationPoint().size() > 0) {
			EList<ForkedBehaviour> syncBehList = object.getSynchronisingBehaviours_ForkAction().getSynchronousForkedBehaviours_SynchronisationPoint();
		
			PrecedenceType ptBegin = lqnBuilder.addBeginForkPrecedence(currentId+"_Action");
			PrecedenceType ptEnd = lqnBuilder.addEndForkPrecedence();		

			for (ForkedBehaviour syncBeh : syncBehList){
				
				String startId = doSwitch(getStartAction(syncBeh));
				lqnBuilder.addActivityToPostAnd(startId, ptBegin);
				
				String stopId = Pcm2LqnHelper.getId(getStopAction(syncBeh), myContextWrapper);
				lqnBuilder.addActivityToPreAnd(stopId, ptEnd);
				
			}
			String successorId = (String) doSwitch(object.getSuccessor_AbstractAction());
			ptEnd.getPost().getActivity().setName(successorId);
		} else {
			String successorId = (String) doSwitch(object.getSuccessor_AbstractAction());
			lqnBuilder.addSequencePrecedence(currentId + "_Action", successorId);
		}
		
		return id;
	}
	
	
}
