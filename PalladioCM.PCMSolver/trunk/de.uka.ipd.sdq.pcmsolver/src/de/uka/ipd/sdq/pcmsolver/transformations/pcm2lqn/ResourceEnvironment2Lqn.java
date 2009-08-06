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
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.util.ResourceenvironmentSwitch;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;

public class ResourceEnvironment2Lqn extends ResourceenvironmentSwitch {
	
	private static Logger logger = Logger.getLogger(ResourceEnvironment2Lqn.class.getName());
	
	private LqnBuilder lqnBuilder;
	private ILaunchConfiguration config;

	public ResourceEnvironment2Lqn(LqnBuilder aLqnBuilder, ILaunchConfiguration aConfig) {
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

		ProcessorType pt = lqnBuilder.addProcessor(id);
		String throughput = object
				.getThroughput_CommunicationLinkResourceSpecification()
				.getSpecification();
		pt.setSpeedFactor(throughput);

		TaskType tt = lqnBuilder.addTask(id, pt);
		ActivityPhasesType apt = lqnBuilder.addActivityPhases(id);
		PhaseActivities pa = lqnBuilder.addPhaseActivities(apt);
		EntryType et = lqnBuilder.addEntry(id, tt);
		et.setType(TypeType.NONE);
		et.setEntryPhaseActivities(pa);
		
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
			String quantum = "0.001";
			try {
				quantum = config.getAttribute(MessageStrings.PS_QUANTUM,
						"0.001");
			} catch (CoreException e) {
				logger.error("Could not determine Processor "
						+ "Sharing Time Quantum. "
						+ "Check LQSIM configuration.");
				e.printStackTrace();
			}
			pt.setQuantum(quantum);
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

		EList<LinkingResource> linkResList = object.getLinkingresource();
		for (LinkingResource lr : linkResList) {
			doSwitch(lr);
		}

		return null;
	}

}
