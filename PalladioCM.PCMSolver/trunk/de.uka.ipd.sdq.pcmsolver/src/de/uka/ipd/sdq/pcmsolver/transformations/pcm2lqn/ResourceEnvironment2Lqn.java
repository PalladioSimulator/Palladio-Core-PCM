package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityPhasesType;
import LqnCore.EntryType;
import LqnCore.LqnCoreFactory;
import LqnCore.LqnModelType;
import LqnCore.PhaseActivities;
import LqnCore.ProcessorType;
import LqnCore.SchedulingType;
import LqnCore.ServiceType;
import LqnCore.TaskOptionType;
import LqnCore.TaskSchedulingType;
import LqnCore.TaskType;
import LqnCore.TypeType;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.pcm.resourceenvironment.util.ResourceenvironmentSwitch;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

public class ResourceEnvironment2Lqn extends ResourceenvironmentSwitch {

	private LqnCoreFactory lqnFactory = LqnCoreFactory.eINSTANCE;

	private LqnModelType lqnModel = null;

	public ResourceEnvironment2Lqn(LqnModelType model) {
		lqnModel = model;
	}

	@Override
	public Object caseCommunicationLinkResourceSpecification(
			CommunicationLinkResourceSpecification object) {
		LinkingResource lr = (LinkingResource) object.eContainer();
		CommunicationLinkResourceType clrt = object
				.getCommunicationLinkResourceType_CommunicationLinkResourceSpecification();
		String name = lr.getEntityName() + "_" + clrt.getEntityName()
				+ Pcm2LqnHelper.fixGUID(clrt.getId());

		ProcessorType pt = lqnFactory.createProcessorType();
		pt.setName(name);
		pt.setMultiplicity(new BigInteger("1"));
		pt.setScheduling(SchedulingType.FCFS);
		String throughput = object
				.getThroughput_CommunicationLinkResourceSpecification()
				.getSpecification();
		pt.setSpeedFactor(throughput); // TODO

		TaskType tt = lqnFactory.createTaskType();
		tt.setName(name+"_Task");
		tt.setMultiplicity(new BigInteger("1"));
		tt.setScheduling(TaskSchedulingType.FCFS); // TODO?
		pt.getTask().add(tt);
		
		// standard entry, never used, only makes sure
		// that the generated XML is valid
		ActivityPhasesType apt = lqnFactory.createActivityPhasesType();
		apt.setHostDemandMean("0.0");
		apt.setPhase(new BigInteger("1"));
		apt.setName(name+"_Activity");
		PhaseActivities pa = lqnFactory.createPhaseActivities();
		pa.getActivity().add(apt);
		
		EntryType et = lqnFactory.createEntryType(); 
		et.setName(name+"_Entry");
		et.setType(TypeType.NONE); 
		et.setEntryPhaseActivities(pa);
		tt.getEntry().add(et);
		
		return pt;
	}

	@Override
	public Object caseLinkingResource(LinkingResource object) {
		ProcessorType pt = (ProcessorType) doSwitch(object
				.getCommunicationLinkResourceSpecifications_LinkingResource());
		//lqnModel.getProcessor().add(pt);
		return null;
	}

	@Override
	public Object caseProcessingResourceSpecification(
			ProcessingResourceSpecification object) {
		ResourceContainer rc = (ResourceContainer) object.eContainer();
		ProcessingResourceType prt = object
				.getActiveResourceType_ActiveResourceSpecification();
		String name = rc.getEntityName() + "_" + prt.getEntityName() +
			Pcm2LqnHelper.fixGUID(prt.getId());
		
		ProcessorType pt = lqnFactory.createProcessorType();
		pt.setName(name);
		pt.setMultiplicity(new BigInteger("1"));

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
			// quantum only needed for lqsim and PS
			pt.setQuantum("0.001"); // TODO
			break;
		}

		String processingRate = object
				.getProcessingRate_ProcessingResourceSpecification()
				.getSpecification();
		pt.setSpeedFactor(processingRate);
		
		TaskType tt = lqnFactory.createTaskType();
		tt.setName(name+"_Task");
		tt.setMultiplicity(new BigInteger("1"));
		tt.setScheduling(TaskSchedulingType.FCFS); // TODO?
		pt.getTask().add(tt);
		
		// standard entry, never used, only makes sure
		// that the generated XML is valid
		ActivityPhasesType apt = lqnFactory.createActivityPhasesType();
		apt.setHostDemandMean("1.0");
		apt.setPhase(new BigInteger("1"));
		apt.setName(name+"_Activity");
		PhaseActivities pa = lqnFactory.createPhaseActivities();
		pa.getActivity().add(apt);
		
		EntryType et = lqnFactory.createEntryType(); 
		et.setName(name+"_Entry");
		et.setType(TypeType.PH1PH2); 
		et.setEntryPhaseActivities(pa);
		tt.getEntry().add(et);

		return pt;
	}

	@Override
	public Object caseResourceContainer(ResourceContainer object) {
		EList<ProcessingResourceSpecification> procResList = object
				.getActiveResourceSpecifications_ResourceContainer();
		for (ProcessingResourceSpecification prs : procResList) {
			ProcessorType pt = (ProcessorType) doSwitch(prs);
			lqnModel.getProcessor().add(pt);
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
