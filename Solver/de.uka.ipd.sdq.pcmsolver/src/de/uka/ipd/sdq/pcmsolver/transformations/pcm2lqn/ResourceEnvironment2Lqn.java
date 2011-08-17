package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
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
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;

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
				double throughputSpeedFactor = 1/Double.valueOf(throughputVariable.getSpecification());
				apt.setHostDemandMean(""+throughputSpeedFactor);
				
				//TODO: each external call can create a new entry here with the demand (compare internal actions)
			
			}
			if (latencyVariable != null){
				// careful: calls to the latency are generated only if latency is larger > 0 
				
				String latencyID = Pcm2LqnHelper.getIdForLatency(id);
				ActivityPhasesType apt = lqnBuilder.addActivityPhases(latencyID);
				PhaseActivities pa = lqnBuilder.addPhaseActivities(apt);
				EntryType et = lqnBuilder.addEntry(latencyID, tt);
				et.setType(TypeType.PH1PH2);
				et.setEntryPhaseActivities(pa);
				
				double latency = Double.valueOf(latencyVariable.getSpecification());
				
				apt.setHostDemandMean(""+latency);
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
		switch (object.getSchedulingPolicy()) {
		case FCFS:
			pt.setScheduling(SchedulingType.FCFS);
			break;
		case DELAY:
			// DELAY not supported!!!
			pt.setScheduling(SchedulingType.FCFS);
			break;
		case PROCESSOR_SHARING:
			pt.setScheduling(SchedulingType.PS);
			pt.setQuantum(config.getPsQuantum());
			break;
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
