package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.math.BigInteger;
import java.util.Date;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityDefType;
import LqnCore.ActivityListType;
import LqnCore.ActivityMakingCallType;
import LqnCore.ActivityOrType;
import LqnCore.ActivityType;
import LqnCore.EntryType;
import LqnCore.LqnCoreFactory;
import LqnCore.LqnModelType;
import LqnCore.OrListType;
import LqnCore.OutputEntryDistributionType;
import LqnCore.PrecedenceType;
import LqnCore.ProcessorType;
import LqnCore.SchedulingType;
import LqnCore.ServiceType;
import LqnCore.SingleActivityListType;
import LqnCore.SolverParamsType;
import LqnCore.TaskActivityGraph;
import LqnCore.TaskOptionType;
import LqnCore.TaskSchedulingType;
import LqnCore.TaskType;
import LqnCore.TypeType;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;

public class UsageModel2Lqn extends UsagemodelSwitch {

	private static Logger logger = Logger.getLogger(UsageModel2Lqn.class.getName());
	
	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	private LqnCoreFactory lqnFactory = LqnCoreFactory.eINSTANCE;
	
	private LqnModelType lqnModel = null;
	private TaskActivityGraph taskActivityGraph = null;
	
	private PCMInstance pcmInstance;
	private ContextWrapper contextWrapper = null;
	
	public UsageModel2Lqn(PCMInstance pcm){
		pcmInstance = pcm;
	}

	@Override
	public Object caseEntryLevelSystemCall(EntryLevelSystemCall object) {
		object.setId("ELSC"+Pcm2LqnHelper.fixGUID(object.getId()));
		
		if (contextWrapper == null)
			contextWrapper = new ContextWrapper(object, pcmInstance);
		else
			contextWrapper = contextWrapper.getContextWrapperFor(object);

		ProvidesComponentType offeringComponent = contextWrapper.getAssCtx()
				.getEncapsulatedComponent_ChildComponentContext();

		String entryId = "";
		if (offeringComponent instanceof BasicComponent){
			ServiceEffectSpecification seff = contextWrapper.getNextSEFF(object); 
			Rdseff2Lqn seffVisitor = new Rdseff2Lqn(contextWrapper,lqnModel);
			try {
				entryId = (String)seffVisitor.doSwitch((ResourceDemandingSEFF) seff);
			} catch (Exception e) {
				logger.error("Error while visiting RDSEFF");
				e.printStackTrace();
			}
		} else {
			logger.error("Composite Component type not yet supported.");
			return null;
		}
		
		ActivityMakingCallType amct = lqnFactory.createActivityMakingCallType();
		amct.setDest(entryId);
		amct.setCallsMean("1.0");
		
		ActivityDefType adt = createActivityAndPrecedence(object, 0.0);
		adt.getSynchCall().add(amct);
		
		return object.getId();
		
	}
	
	


	private StopAction getStopAction(ResourceDemandingBehaviour object) {
		StopAction stopAction = (StopAction) EMFHelper.getObjectByType(object
				.getSteps_Behaviour(), StopAction.class);
		return stopAction;
	}

	@Override
	public Object caseDelay(Delay object) {
		object.setId("Delay"+Pcm2LqnHelper.fixGUID(object.getId()));
	
		ActivityDefType adt = createActivityAndPrecedence(object,0.0);
		adt.setThinkTime(object.getTimeSpecification_Delay().getSpecification());
	
		return object.getId();
	}




	@Override
	public Object caseLoop(Loop object) {
		object.setId("Loop"+Pcm2LqnHelper.fixGUID(object.getId()));
//		de.uka.ipd.sdq.spa.expression.Loop loop = expFactory.createLoop();
//		RandomVariable iterations = (RandomVariable)object.getLoopIteration_Loop();
//		loop.setIterationsString(iterations.getSpecification());
//		loop.setRegExp((Expression)doSwitch(object.getBodyBehaviour_Loop()));
//		
//		Sequence seq = expFactory.createSequence();		
//		seq.setLeftRegExp(loop);
//		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor()));
//		
//		return seq;
		return null;
	}

	
	
	@Override
	public Object caseUsageModel(UsageModel usageModel) {
		lqnModel = lqnFactory.createLqnModelType();
		lqnModel.setName("TODO_EnterUsageModelName");
		
		// TODO: set default parameter
		// make configurable in run config
		SolverParamsType spt = lqnFactory.createSolverParamsType();
		
		spt.setComment("Generated by PCM2LQN on "+new Date());
		spt.setConvVal("1e-005");
		spt.setItLimit(50);
		spt.setPrintInt(10);
		spt.setUnderrelaxCoeff("0.5");
		lqnModel.setSolverParams(spt);
		
		// first, create processors from resource environment
		ResourceEnvironment2Lqn reVisitor = new ResourceEnvironment2Lqn(lqnModel);
		reVisitor.doSwitch(pcmInstance.getResourceEnvironment());
		
		// next, visit all usage scenarios and rdseffs
		EList<UsageScenario> scenList = usageModel.getUsageScenario_UsageModel();
		for (UsageScenario us : scenList){
			doSwitch(us);
		}
	
		return lqnModel;
	}

	
	
	@Override
	public Object caseUsageScenario(UsageScenario object) {
		doSwitch(object.getWorkload_UsageScenario());
		doSwitch(object.getScenarioBehaviour_UsageScenario());
		
// Generating a reply leads to an error, therefore commented out:				
//		ReplyActivityType rat = lqnFactory.createReplyActivityType();
//		rat.setName((String)doSwitch(object.getScenarioBehaviour_UsageScenario()));
//
//		ReplyEntryType ret = lqnFactory.createReplyEntryType();
//		ret.setName(object.getEntityName()+"_Entry"); // TODO
//		ret.getReplyActivity().add(rat);
//		
//		taskActivityGraph.getReplyEntry().add(ret);
		
		return null;
	}



	@Override
	public Object caseClosedWorkload(ClosedWorkload closedWorkload) {
		UsageScenario us = (UsageScenario)closedWorkload.eContainer();
		
		ProcessorType pt = lqnFactory.createProcessorType();
		pt.setName(us.getEntityName()+"_Processor");
		pt.setMultiplicity(new BigInteger("0")); // TODO
		pt.setScheduling(SchedulingType.FCFS);
		
		TaskType tt = lqnFactory.createTaskType();
		tt.setName(us.getEntityName()+"_Task");
		String population = new Integer(closedWorkload.getPopulation()).toString();
		tt.setMultiplicity(new BigInteger(population));
		
		PCMRandomVariable thinkTime = closedWorkload.getThinkTime_ClosedWorkload();
		tt.setThinkTime(thinkTime.getSpecification());
		tt.setScheduling(TaskSchedulingType.REF);
		tt.setActivityGraph(TaskOptionType.YES);
		pt.getTask().add(tt);
				
		ServiceType st = lqnFactory.createServiceType();
		st.setName("MyService");
		tt.getService().add(st);
		
		EntryType et = lqnFactory.createEntryType();
		et.setName(us.getEntityName()+"_Entry");
		et.setType(TypeType.NONE); // actually TypeType.GRAPH, but not supported by lqns
		OutputEntryDistributionType oedt = lqnFactory.createOutputEntryDistributionType();
		oedt.setPhase(new BigInteger("1"));
		oedt.setMin("0.0");
		oedt.setMax("10.0");
		
		et.getServiceTimeDistribution().add(oedt);
		tt.getEntry().add(et);
				
		taskActivityGraph = lqnFactory.createTaskActivityGraph();
		
		tt.setTaskActivities(taskActivityGraph);
		
		lqnModel.getProcessor().add(pt);
		
		//return pt;
		return null;
	}

	@Override
	public Object caseOpenWorkload(OpenWorkload openWorkload) {
		UsageScenario us = (UsageScenario)openWorkload.eContainer();
		
		ProcessorType pt = lqnFactory.createProcessorType();
		pt.setName(us.getEntityName()+"_Processor");
		pt.setMultiplicity(new BigInteger("0")); // TODO
		pt.setScheduling(SchedulingType.FCFS);
		
		TaskType tt = lqnFactory.createTaskType();
		tt.setName(us.getEntityName()+"_Task");
		tt.setMultiplicity(new BigInteger("1"));
		
		tt.setThinkTime("0.0");
		tt.setScheduling(TaskSchedulingType.FCFS);
		tt.setActivityGraph(TaskOptionType.YES);
		pt.getTask().add(tt);
				
		ServiceType st = lqnFactory.createServiceType();
		st.setName("MyService");
		tt.getService().add(st);
		
		EntryType et = lqnFactory.createEntryType();
		et.setName(us.getEntityName()+"_Entry");
		et.setType(TypeType.NONE); // actually TypeType.GRAPH, but not supported by lqns
		et.setOpenArrivalRate(openWorkload.getInterArrivalTime_OpenWorkload().getSpecification());
		tt.getEntry().add(et);
				
		taskActivityGraph = lqnFactory.createTaskActivityGraph();
		
		tt.setTaskActivities(taskActivityGraph);
		
		lqnModel.getProcessor().add(pt);
		
		//return pt;
		return null;
	}

	@Override
	public Object caseScenarioBehaviour(ScenarioBehaviour object) {
		return doSwitch(getStartAction(object));
	}

	@Override
	public Object caseStart(Start object) {
		object.setId("Start"+Pcm2LqnHelper.fixGUID(object.getId()));
		if (object.eContainer().eContainer() instanceof UsageScenario){
			UsageScenario us = (UsageScenario)object.eContainer().eContainer();
			ActivityDefType adt = createActivityAndPrecedence(object,0.0);
			adt.setBoundToEntry(us.getEntityName()+"_Entry");
			return object.getId(); // for reply activity
		} else{ //nested scenario behaviour
			createActivityAndPrecedence(object, 0.0);
			return object.getId(); // for predecessor
		}
	}
	
	@Override
	public Object caseStop(Stop object) {
		object.setId("Stop"+Pcm2LqnHelper.fixGUID(object.getId()));

		ActivityDefType adt = lqnFactory.createActivityDefType();
		adt.setHostDemandMean("0.0");
		adt.setName(object.getId());
		taskActivityGraph.getActivity().add(adt);
		
		return object.getId();
	}

	private ActivityDefType createActivityAndPrecedence(AbstractUserAction action,
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
		atPost.setName((String)doSwitch(action.getSuccessor()));
		saltPost.setActivity(atPost);

		pt.setPre(saltPre);
		pt.setPost(saltPost);
		
		taskActivityGraph.getPrecedence().add(pt);
		
		return adt;
	}

	public Object caseBranch(Branch object) {
		object.setId("Branch"+Pcm2LqnHelper.fixGUID(object.getId()));
		
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
		
		EList<BranchTransition> btList = object.getBranchTransitions_Branch();
		for (BranchTransition bt : btList){
			ActivityOrType aot = lqnFactory.createActivityOrType();
			aot.setProb(new Double(bt.getBranchProbability()).toString());
			
			ScenarioBehaviour sb = bt.getBranchedBehaviour_BranchTransition();
			String name = (String)doSwitch(sb);
			aot.setName(name);

			Stop stopUserAction = getStopAction(sb);
			ActivityType at = lqnFactory.createActivityType();
			at.setName(stopUserAction.getId());

			oltPreBegin.getActivity().add(aot);
			altPreEnd.getActivity().add(at);
		}
		
		PrecedenceType ptEnd = lqnFactory.createPrecedenceType();
		SingleActivityListType saltPostEnd = lqnFactory.createSingleActivityListType();
		ActivityType atPostEnd = lqnFactory.createActivityType();
		atPostEnd.setName((String)doSwitch(object.getSuccessor()));
		saltPostEnd.setActivity(atPostEnd);
		
		ptBegin.setPre(saltPreBegin);
		ptBegin.setPostOR(oltPreBegin);
		taskActivityGraph.getPrecedence().add(ptBegin);
		
		ptEnd.setPreOR(altPreEnd);
		ptEnd.setPost(saltPostEnd);
		taskActivityGraph.getPrecedence().add(ptEnd);
		
		return object.getId();
	}
	
	private Stop getStopAction(ScenarioBehaviour object) {
		Stop stopAction = (Stop) EMFHelper.getObjectByType(object
				.getActions_ScenarioBehaviour(), Stop.class);
		return stopAction;
	}

	private Start getStartAction(ScenarioBehaviour object) {
		Start startAction = (Start) EMFHelper.getObjectByType(object
				.getActions_ScenarioBehaviour(), Start.class);
		return startAction;
	}
}
