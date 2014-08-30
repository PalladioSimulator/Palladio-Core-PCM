package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityPhasesType;
import LqnCore.EntryType;
import LqnCore.PhaseActivities;
import LqnCore.ProcessorType;
import LqnCore.SchedulingType;
import LqnCore.TaskType;
import LqnCore.TypeType;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.util.ResourceenvironmentSwitch;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcmsolver.transformations.ExpressionToPDFWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;

public class ResourceEnvironment2Lqn extends ResourceenvironmentSwitch {
	
	private static Logger logger = Logger.getLogger(ResourceEnvironment2Lqn.class.getName());
	
	private LqnBuilder lqnBuilder;
	private PCMSolverWorkflowRunConfiguration config;

	public ResourceEnvironment2Lqn(LqnBuilder aLqnBuilder, PCMSolverWorkflowRunConfiguration aConfig) {
		lqnBuilder = aLqnBuilder;
		config = aConfig;
	}

	@Override
	public Object caseCommunicationLinkResourceSpecification(
			CommunicationLinkResourceSpecification object) {
		LinkingResource lr = (LinkingResource) object.eContainer();
		CommunicationLinkResourceType clrt = object
				.getCommunicationLinkResourceType_CommunicationLinkResourceSpecification();
		String id = Pcm2LqnHelper.getIdForCommResource(lr,clrt);

		PCMRandomVariable throughputVariable = object.getThroughput_CommunicationLinkResourceSpecification();
		PCMRandomVariable latencyVariable = object.getLatency_CommunicationLinkResourceSpecification();
		
		
		if (throughputVariable != null || latencyVariable != null){
			//only handle linking resource if a throughput or latency is specified
			
			ProcessorType pt = lqnBuilder.addProcessor(id);
			pt.setSpeedFactor("1");
			pt.setScheduling(SchedulingType.FCFS);
			
			TaskType tt = lqnBuilder.addTask(id, pt);
			
			// Throughput: Create throughput entry that can be called
			// for remote external call with bytesize information
			// FIXME: Calls to this need to be added with BYTESIZE info. Not yet supported.
			if (throughputVariable != null){
				
				String throughputID = Pcm2LqnHelper.getIdForThroughput(id);
				ActivityPhasesType apt = lqnBuilder.addActivityPhases(throughputID);
				PhaseActivities pa = lqnBuilder.addPhaseActivities(apt);
				EntryType et = lqnBuilder.addEntry(throughputID, tt);
				et.setType(TypeType.NONE);
				et.setEntryPhaseActivities(pa);
				
				// callers must call this task BYTESIZE times, that should make no difference for the LQN mean value analysis
				// we could thin about aggregating this to KB or so, but that might cause misunderstandings.
				// alternatively, for each call using a BYTESIZE, a new entry of this processor must be created.  
				double throughputSpeedFactor = 1/ExpressionHelper.getMeanValue(throughputVariable);
				apt.setHostDemandMean(""+throughputSpeedFactor);
				
				//TODO: each external call can create a new entry here with the demand (compare internal actions)
			
			}
			if (latencyVariable != null){
				// careful: calls to the latency are generated only if latency is larger > 0 
				
				ExpressionToPDFWrapper expToPDF = ExpressionToPDFWrapper.createExpressionToPDFWrapper(latencyVariable.getExpression());
				double latency = expToPDF.getMeanValue();
								
				CallType[] callTypes = CallType.values();
				// LQN does not allow to receive synchronous and asynchronous calls at one entry, 
				// so need to create one entry per call type. 
				for (int i = 0; i < callTypes.length; i++) {
					CallType callType = callTypes[i];
					
					String latencyID = Pcm2LqnHelper.getIdForLatency(id, callType);
					ActivityPhasesType apt = lqnBuilder.addActivityPhases(latencyID);
					PhaseActivities pa = lqnBuilder.addPhaseActivities(apt);
					
					EntryType et = lqnBuilder.addEntry(latencyID, tt);
					et.setType(TypeType.PH1PH2);
					et.setEntryPhaseActivities(pa);
					
					apt.setHostDemandMean(""+latency);
					double stdev = expToPDF.getStandardDeviation();
					if (!Double.isNaN(stdev) && latency != 0){
						// squared coefficient of variation
						apt.setHostDemandCvsq(""+(stdev*stdev/(latency*latency)));
					}
				}
			}
			
		} else {
			logger.warn("Found linking resource with neither throughput specification nor latency specification, ignoring it.");
		}
		
		return null;
	}

	@Override
	public Object caseLinkingResource(LinkingResource object) {
		doSwitch(object
				.getCommunicationLinkResourceSpecifications_LinkingResource());
		return null;
	}

	@Override
	public Object caseProcessingResourceSpecification(
			ProcessingResourceSpecification object) {
		ResourceContainer rc = (ResourceContainer) object.eContainer();
		ProcessingResourceType prt = object
				.getActiveResourceType_ActiveResourceSpecification();
		String id = Pcm2LqnHelper.getIdForProcResource(rc, prt);
		
		ProcessorType pt = lqnBuilder.addProcessor(id);
		setSchedulingPolicy(object, pt);
		
		// The speed of the processing resource is already considered in the resource demands,
		// they are calculated in term of tiem spent on the processor. 
		/*String processingRate = object
				.getProcessingRate_ProcessingResourceSpecification()
				.getSpecification();*/
		pt.setSpeedFactor("1.0");
		//pt.setMultiplicity(new BigInteger("1"));
		pt.setMultiplicity(new BigInteger(""+object.getNumberOfReplicas()));
		
//		String processingRateSolved = ExpressionHelper.getSolvedExpressionAsString(processingRate, null);
//		
//		pt.setSpeedFactor(processingRateSolved);
		
		TaskType tt = lqnBuilder.addTask(id,pt);
		ActivityPhasesType apt = lqnBuilder.addActivityPhases(id);
		PhaseActivities pa = lqnBuilder.addPhaseActivities(apt);
		EntryType et = lqnBuilder.addEntry(id, tt);
		et.setType(TypeType.NONE);
		et.setEntryPhaseActivities(pa);
		
		return null;
	}

	private void setSchedulingPolicy(ProcessingResourceSpecification object,
			ProcessorType pt) {
		String schedulingPolicyID = object.getSchedulingPolicy().getId();
		if (schedulingPolicyID.equals("FCFS")) {
			pt.setScheduling(SchedulingType.FCFS);
		} else if (schedulingPolicyID.equals("Delay")) {
			// The SchedulingType.INF has been added manually to the generated code, so 
			// there may appear a compile error here if the LQN code is regenerated again. 
			// I purposefully did not set it to "generated not" so that this problem is 
			// brought to attention whenever the model is regenerated
			// However, if the model is successfully regenerated from the LQN version 4.3 or later XML schema
			// the inf value should be available in the generated code and this note can be deleted.  
			pt.setScheduling(SchedulingType.INF);
		} else if (schedulingPolicyID.equals("ProcessorSharing")) {
			pt.setScheduling(SchedulingType.PS);
			pt.setQuantum(config.getPsQuantum());
		} else {
			logger.warn("Unknown scheduling strategy "
					+ object.getSchedulingPolicy().getId()
					+ ", using PROCESSOR_SHARING for "
					+ object
							.getActiveResourceType_ActiveResourceSpecification()
							.getEntityName()
					+ " of server "
					+ object
							.getResourceContainer_ProcessingResourceSpecification()
							.getEntityName()
					+ " (id: "
					+ object
							.getResourceContainer_ProcessingResourceSpecification()
							.getId() + ")");
			pt.setScheduling(SchedulingType.PS);
			pt.setQuantum(config.getPsQuantum());
		}
	}

	@Override
	public Object caseResourceContainer(ResourceContainer object) {
		EList<ProcessingResourceSpecification> procResList = object
				.getActiveResourceSpecifications_ResourceContainer();
		for (ProcessingResourceSpecification prs : procResList) {
			doSwitch(prs);
		}
		return null;
	}

	@Override
	public Object caseResourceEnvironment(ResourceEnvironment object) {
		EList<ResourceContainer> resConList = object
				.getResourceContainer_ResourceEnvironment();
		for (ResourceContainer rc : resConList) {
			doSwitch(rc); //TODO
		}

		EList<LinkingResource> linkResList = object.getLinkingResources__ResourceEnvironment();
		for (LinkingResource lr : linkResList) {
			doSwitch(lr);
		}

		return null;
	}
	
}
