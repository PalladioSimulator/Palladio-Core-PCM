package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityDefType;
import LqnCore.ActivityListType;
import LqnCore.ActivityMakingCallType;
import LqnCore.ActivityOrType;
import LqnCore.ActivityPhasesType;
import LqnCore.ActivityType;
import LqnCore.EntryType;
import LqnCore.LqnCoreFactory;
import LqnCore.LqnModelType;
import LqnCore.OrListType;
import LqnCore.PhaseActivities;
import LqnCore.PrecedenceType;
import LqnCore.ProcessorType;
import LqnCore.ReplyActivityType;
import LqnCore.ReplyEntryType;
import LqnCore.SchedulingType;
import LqnCore.ServiceType;
import LqnCore.SingleActivityListType;
import LqnCore.TaskActivityGraph;
import LqnCore.TaskOptionType;
import LqnCore.TaskSchedulingType;
import LqnCore.TaskType;
import LqnCore.TypeType;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Sequence;

public class Rdseff2Lqn extends SeffSwitch {

	private static Logger logger = Logger.getLogger(Rdseff2Lqn.class.getName());
	
	private ContextWrapper contextWrapper;
	private LqnCoreFactory lqnFactory = LqnCoreFactory.eINSTANCE;

	private LqnModelType lqnModel = null;
	private TaskActivityGraph taskActivityGraph = null;
	
	public Rdseff2Lqn(ContextWrapper ctwWrapper, LqnModelType model) {
		contextWrapper = ctwWrapper;
		lqnModel = model;
	}

	@Override
	public Object caseResourceDemandingSEFF(ResourceDemandingSEFF object) {
		String name = "RDSEFF_"+object.getDescribedService__SEFF().getServiceName()+
			Pcm2LqnHelper.fixGUID(object.getId());

		return createProcessorAndTask((ResourceDemandingBehaviour)object, name);
	}

	@Override
	public Object caseLoopAction(LoopAction object) {
		object.setId("LoopAction"+Pcm2LqnHelper.fixGUID(object.getId()));
		
		
		
		//return doSwitch(object.getSuccessor_AbstractAction());
		handleLoop(object);
		return object.getId();
	}

	@Override
	public Object caseCollectionIteratorAction(CollectionIteratorAction object) {
		object.setId("CollectionIteratorAction"+Pcm2LqnHelper.fixGUID(object.getId()));
//		return doSwitch(object.getSuccessor_AbstractAction());
		handleLoop(object);
		return object.getId();
	}

	private void handleLoop(AbstractLoopAction object) {
		ResourceDemandingBehaviour rdb = object.getBodyBehaviour_Loop();
		
		TaskActivityGraph tagBackup = taskActivityGraph;
		// here a new task and processor a generated for the loop body
		String entryId = createProcessorAndTask(rdb, object.getId());
		
		taskActivityGraph = tagBackup;
		
		ActivityMakingCallType amct = lqnFactory.createActivityMakingCallType();
		amct.setDest(entryId);
		
		// so far, we use the maxCount from the IntPMF specifying
		// the number of loop iterations
		ManagedPMF pmf = contextWrapper.getLoopIterations(object);
		if (pmf != null){
			amct.setCallsMean(pmf.getExpectedValue().toString());
		} else {
			amct.setCallsMean("0.0");
		}
		ActivityDefType adt = createActivityAndPrecedence(object, 0.0);
		adt.getSynchCall().add(amct);
	}

	private String createProcessorAndTask(ResourceDemandingBehaviour rdb,
			String name) {
		ProcessorType pt = lqnFactory.createProcessorType(); // TODO
		pt.setName(name+"_Processor"); //TODO
		pt.setMultiplicity(new BigInteger("1")); 
		pt.setScheduling(SchedulingType.FCFS);
		
		TaskType tt = lqnFactory.createTaskType();
		tt.setName(name+"_Task");
		tt.setMultiplicity(new BigInteger("1"));
		tt.setScheduling(TaskSchedulingType.FCFS);
		tt.setActivityGraph(TaskOptionType.YES);
		pt.getTask().add(tt);
		
		EntryType et = lqnFactory.createEntryType();
		et.setName(name+"_Entry");
		et.setType(TypeType.NONE); // actually TypeType.GRAPH, but not supported by lqns
		tt.getEntry().add(et);
		
		taskActivityGraph = lqnFactory.createTaskActivityGraph();
		tt.setTaskActivities(taskActivityGraph);
		
		
		
		ReplyActivityType rat = lqnFactory.createReplyActivityType();
		rat.setName((String)doSwitch(getStartAction(rdb)));
		rat.setName(getStopAction(rdb).getId()); //TODO: this is a strange fix
		
		ReplyEntryType ret = lqnFactory.createReplyEntryType();
		ret.setName(name+"_Entry"); // TODO
		ret.getReplyActivity().add(rat);
		taskActivityGraph.getReplyEntry().add(ret);
		
		lqnModel.getProcessor().add(pt);

		return et.getName();
	}

	@Override
	public Object caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
		return doSwitch(getStartAction(object));
	}
	
	@Override
	public Object caseStartAction(StartAction object) {
		object.setId("StartAction"+Pcm2LqnHelper.fixGUID(object.getId()));

		if (object.eContainer() instanceof ResourceDemandingSEFF){
			ResourceDemandingSEFF rdseff = (ResourceDemandingSEFF)object.eContainer();
			String id = "RDSEFF_"+rdseff.getDescribedService__SEFF().getServiceName() +
				Pcm2LqnHelper.fixGUID(rdseff.getId());
			ActivityDefType adt = createActivityAndPrecedence(object,0.0);
			adt.setBoundToEntry(id+"_Entry");
			return object.getId(); // for reply activity
		} else if (object.eContainer().eContainer() instanceof LoopAction){
			LoopAction la = (LoopAction)object.eContainer().eContainer();
			ActivityDefType adt = createActivityAndPrecedence(object,0.0);
			adt.setBoundToEntry(la.getId()+"_Entry");
			return object.getId(); 
		} else if (object.eContainer().eContainer() instanceof CollectionIteratorAction){
			CollectionIteratorAction cia = (CollectionIteratorAction)object.eContainer().eContainer();
			ActivityDefType adt = createActivityAndPrecedence(object,0.0);
			adt.setBoundToEntry(cia.getId()+"_Entry");
			return object.getId(); 
		} else { //nested resource demanding behaviour
			createActivityAndPrecedence(object, 0.0);
			return object.getId(); // for predecessor
		}
	}
	

	@Override
	public Object caseBranchAction(BranchAction object) {
		object.setId("BranchAction"+Pcm2LqnHelper.fixGUID(object.getId()));
		
		ActivityDefType adt = lqnFactory.createActivityDefType();
		adt.setHostDemandMean("0.0");
		adt.setName(object.getId());
		taskActivityGraph.getActivity().add(adt);
		
		PrecedenceType ptBegin = lqnFactory.createPrecedenceType();
		SingleActivityListType saltPreBegin = lqnFactory.createSingleActivityListType();
		ActivityType atPre = lqnFactory.createActivityType();
		atPre.setName(object.getId());
		saltPreBegin.setActivity(atPre);
		
		OrListType oltPreBegin = lqnFactory.createOrListType(); // branch
		ActivityListType altPreEnd = lqnFactory.createActivityListType(); //merge
		
		EList<AbstractBranchTransition> btList = object.getBranches_Branch();
		for (AbstractBranchTransition bt : btList){
			ActivityOrType aot = lqnFactory.createActivityOrType();
			aot.setProb(new Double(contextWrapper.getBranchProbability(bt)).toString());
			
			ResourceDemandingBehaviour rdb = bt.getBranchBehaviour_BranchTransition();
			String name = (String)doSwitch(rdb);
			aot.setName(name);

			StopAction stopAction = getStopAction(rdb);
			ActivityType at = lqnFactory.createActivityType();
			at.setName(stopAction.getId());

			oltPreBegin.getActivity().add(aot);
			altPreEnd.getActivity().add(at);
		}
		
		PrecedenceType ptEnd = lqnFactory.createPrecedenceType();
		SingleActivityListType saltPostEnd = lqnFactory.createSingleActivityListType();
		ActivityType atPostEnd = lqnFactory.createActivityType();
		atPostEnd.setName((String)doSwitch(object.getSuccessor_AbstractAction()));
		saltPostEnd.setActivity(atPostEnd);
		
		ptBegin.setPre(saltPreBegin);
		ptBegin.setPostOR(oltPreBegin);
		taskActivityGraph.getPrecedence().add(ptBegin);
		
		ptEnd.setPreOR(altPreEnd);
		ptEnd.setPost(saltPostEnd);
		taskActivityGraph.getPrecedence().add(ptEnd);
		
		return object.getId();
	}

	@Override
	public Object caseSetVariableAction(SetVariableAction object) {
		object.setId("SetVariableAction"+Pcm2LqnHelper.fixGUID(object.getId()));
		
		return doSwitch(object.getSuccessor_AbstractAction());
	}

	@Override
	public Object caseExternalCallAction(ExternalCallAction object) {
		object.setId("ExternalCallAction"+Pcm2LqnHelper.fixGUID(object.getId()));

		ResourceDemandingSEFF seff = (ResourceDemandingSEFF)contextWrapper.getNextSEFF(object);
		if (seff == null){
			// this is a system external call
			// we continue with the internal action added after this action
			return doSwitch(object.getSuccessor_AbstractAction());
		} else {
			ContextWrapper oldContextWrapper = (ContextWrapper)contextWrapper.clone();
			contextWrapper = contextWrapper.getContextWrapperFor(object);
	
			String entryId = "";
			Rdseff2Lqn seffVisitor = new Rdseff2Lqn(contextWrapper,lqnModel);
			try {
				entryId = (String)seffVisitor.doSwitch(seff);
			} catch (Exception e) {
				logger.error("Error while visiting RDSEFF");
				e.printStackTrace();
			}
			
			contextWrapper = oldContextWrapper;
			
			ActivityMakingCallType amct = lqnFactory.createActivityMakingCallType();
			amct.setDest(entryId);
			amct.setCallsMean("1.0");
			
			ActivityDefType adt = createActivityAndPrecedence(object, 0.0);
			adt.getSynchCall().add(amct);
			
			
			return object.getId(); // for predecessor
		}
	}

	@Override
	public Object caseInternalAction(InternalAction object) {
		object.setId("InternalAction"+Pcm2LqnHelper.fixGUID(object.getId()));
		
		EList<ParametricResourceDemand> resDemList = object.getResourceDemand_Action();
		int counter = 0; // for the number of resource demands (mapped to entry name)
		for (ParametricResourceDemand resourceDemand : resDemList){
			String name = getProcessorName(resourceDemand);
			EList<ProcessorType> processorList = lqnModel.getProcessor();
			for(ProcessorType proc : processorList){
				// we assume that the processor is available, as the model is valid
				if(proc.getName().equals(name)){
					EntryType et = createEntry(resourceDemand, proc, counter);
					
					createActivityWithCounter(object, counter, et);
					
					if (counter < resDemList.size()-1){
						createPrecedenceWithCounter(object, counter);
					}
				}
			}
			counter++;
		}

		// create last precedence, which connects with successor
		PrecedenceType pt = lqnFactory.createPrecedenceType();
		
		SingleActivityListType saltPre = lqnFactory.createSingleActivityListType();
		ActivityType atPre = lqnFactory.createActivityType();
		atPre.setName(object.getId()+"_"+(counter-1)); 
		saltPre.setActivity(atPre);
		
		SingleActivityListType saltPost = lqnFactory.createSingleActivityListType();
		ActivityType atPost = lqnFactory.createActivityType();
		atPost.setName((String)doSwitch(object.getSuccessor_AbstractAction()));
		saltPost.setActivity(atPost);

		pt.setPre(saltPre);
		pt.setPost(saltPost);
		
		taskActivityGraph.getPrecedence().add(pt);
		

		return object.getId()+"_0"; // for predecessor
	}

	private String getProcessorName(ParametricResourceDemand resourceDemand) {
		ProcessingResourceSpecification prs = contextWrapper.getConcreteProcessingResource(resourceDemand);
		ResourceContainer rc = (ResourceContainer)prs.eContainer();
		ProcessingResourceType prt = prs.getActiveResourceType_ActiveResourceSpecification();
		String name = rc.getEntityName()+"_"+prt.getEntityName() + 
			Pcm2LqnHelper.fixGUID(prt.getId());
		return name;
	}

	private void createActivityWithCounter(InternalAction object, int counter,
			EntryType et) {
		object.setId(Pcm2LqnHelper.fixGUID(object.getId()));
		
		ActivityDefType adt = lqnFactory.createActivityDefType();
		adt.setHostDemandMean(new Double(0.0).toString());
		adt.setName(object.getId()+"_"+counter);
		taskActivityGraph.getActivity().add(adt);
		
		ActivityMakingCallType amct = lqnFactory.createActivityMakingCallType();
		amct.setDest(et.getName());
		amct.setCallsMean("1.0");
		adt.getSynchCall().add(amct);
	}

	private void createPrecedenceWithCounter(InternalAction object, int counter) {
		object.setId(Pcm2LqnHelper.fixGUID(object.getId()));
		
		PrecedenceType pt = lqnFactory.createPrecedenceType();
		
		SingleActivityListType saltPre = lqnFactory.createSingleActivityListType();
		ActivityType atPre = lqnFactory.createActivityType();
		atPre.setName(object.getId()+"_"+counter); 
		saltPre.setActivity(atPre);
		
		SingleActivityListType saltPost = lqnFactory.createSingleActivityListType();
		ActivityType atPost = lqnFactory.createActivityType();
		atPost.setName(object.getId()+"_"+(counter+1));
		saltPost.setActivity(atPost);

		pt.setPre(saltPre);
		pt.setPost(saltPost);
		
		taskActivityGraph.getPrecedence().add(pt);
	}

	private EntryType createEntry(ParametricResourceDemand resourceDemand,
			ProcessorType proc, int counter) {
		TaskType tt = proc.getTask().get(0);
						
		ActivityPhasesType apt = lqnFactory.createActivityPhasesType();
		ManagedPDF pdf = contextWrapper.getTimeConsumption(resourceDemand);
		// convert pdf to Double-String, TODO: expected value
		String hostDemand = new Double(pdf.getExpectedValue()).toString();
		apt.setHostDemandMean(hostDemand);
		apt.setPhase(new BigInteger("1"));
		
		String id = resourceDemand.getAction_ParametricResourceDemand().getId();
		id = Pcm2LqnHelper.fixGUID(id);
		apt.setName(id+"_Activity_"+counter);
		
		PhaseActivities pa = lqnFactory.createPhaseActivities();
		pa.getActivity().add(apt);
							
		EntryType et = lqnFactory.createEntryType();
		et.setType(TypeType.PH1PH2);
		et.setEntryPhaseActivities(pa);
		et.setName(id+"_Entry_"+counter);
		
		tt.getEntry().add(et);
		return et;
	}

	private void createCallToEntry(InternalAction object, EntryType et) {
		ActivityMakingCallType amct = lqnFactory.createActivityMakingCallType();
		amct.setDest(et.getName());
		amct.setCallsMean("1.0");
		
		ActivityDefType adt = createActivityAndPrecedence(object, 0.0);
		adt.getSynchCall().add(amct);
	}

	@Override
	public Object caseStopAction(StopAction object) {
		object.setId("StopAction"+Pcm2LqnHelper.fixGUID(object.getId()));

		ActivityDefType adt = lqnFactory.createActivityDefType();
		adt.setHostDemandMean("0.0");
		adt.setName(object.getId());
		taskActivityGraph.getActivity().add(adt);
		
		// Precedence has already been created by predecessor
		
		return object.getId();
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

	
	private ActivityDefType createActivityAndPrecedence(AbstractAction action,
			double hostDemandMean) {
		action.setId(Pcm2LqnHelper.fixGUID(action.getId()));
		
		ActivityDefType adt = lqnFactory.createActivityDefType();
		adt.setHostDemandMean(new Double(hostDemandMean).toString());
		adt.setName(action.getId());
		taskActivityGraph.getActivity().add(adt);
		
		PrecedenceType pt = lqnFactory.createPrecedenceType();
		
		SingleActivityListType saltPre = lqnFactory.createSingleActivityListType();
		ActivityType atPre = lqnFactory.createActivityType();
		atPre.setName(action.getId()); 
		saltPre.setActivity(atPre);
		
		SingleActivityListType saltPost = lqnFactory.createSingleActivityListType();
		ActivityType atPost = lqnFactory.createActivityType();
		atPost.setName((String)doSwitch(action.getSuccessor_AbstractAction()));
		saltPost.setActivity(atPost);

		pt.setPre(saltPre);
		pt.setPost(saltPost);
		
		taskActivityGraph.getPrecedence().add(pt);
		
		return adt;
	}
	
}
