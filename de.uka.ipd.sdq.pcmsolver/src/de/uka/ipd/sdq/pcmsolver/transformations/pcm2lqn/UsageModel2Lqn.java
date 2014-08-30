package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityDefType;
import LqnCore.ActivityMakingCallType;
import LqnCore.ActivityPhasesType;
import LqnCore.EntryType;
import LqnCore.PhaseActivities;
import LqnCore.PrecedenceType;
import LqnCore.ProcessorType;
import LqnCore.SchedulingType;
import LqnCore.TaskSchedulingType;
import LqnCore.TaskType;
import LqnCore.TypeType;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
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
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFQueryHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.probfunction.ExponentialDistribution;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.StringNotPDFException;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionSolveVisitor;

public class UsageModel2Lqn extends UsagemodelSwitch<String> {

	private static final String USAGE_DELAY = "USAGE_DELAY";

	private static Logger logger = Logger.getLogger(UsageModel2Lqn.class
			.getName());
	
	private int counter;

	private ContextWrapper myContextWrapper;
	private LqnBuilder lqnBuilder;

	public UsageModel2Lqn(LqnBuilder aLqnBuilder, ContextWrapper ctxWrp) {
		lqnBuilder = aLqnBuilder;
		myContextWrapper = ctxWrp;
		counter = 0;
	}

	@Override
	public String caseUsageModel(UsageModel usageModel) {
		
		ProcessorType pt = lqnBuilder.addProcessor(USAGE_DELAY);
		pt.setScheduling(SchedulingType.INF);
		TaskType tt = lqnBuilder.addTask(USAGE_DELAY,pt);
		
		EntryType et = lqnBuilder.addEntry(USAGE_DELAY+counter,tt);
		et.setType(TypeType.PH1PH2);
		ActivityPhasesType apt = lqnBuilder.addActivityPhases(USAGE_DELAY+counter);
		apt.setHostDemandMean("0.0");
		PhaseActivities pa = lqnBuilder.addPhaseActivities(apt);
		et.setEntryPhaseActivities(pa);
		counter++;
		
		EList<UsageScenario> scenList = usageModel
				.getUsageScenario_UsageModel();
		for (UsageScenario us : scenList) {
			doSwitch(us);
		}
		return null;
	}

	@Override
	public String caseUsageScenario(UsageScenario object) {
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
	public String caseClosedWorkload(ClosedWorkload closedWorkload) {
		UsageScenario us = (UsageScenario) closedWorkload.eContainer();
		String id = Pcm2LqnHelper.getIdForUsageScenario(us);
		
		ProcessorType pt = lqnBuilder.addProcessor(id);

		TaskType tt = lqnBuilder.addTask(id,pt);
		String population = new Integer(closedWorkload.getPopulation())
				.toString();
		PCMRandomVariable thinkTime = closedWorkload
				.getThinkTime_ClosedWorkload();
		if (thinkTime == null){
			throw new RuntimeException("No think tiome defined for closed workload. Fix your model and validate it before running the analyses.");
		}
		tt.setMultiplicity(new BigInteger(population));
		tt.setThinkTime(thinkTime.getSpecification());
		tt.setScheduling(TaskSchedulingType.REF);

		EntryType et = lqnBuilder.addEntry(id,tt);
		lqnBuilder.addOutputEntryDistributionType(et);
		lqnBuilder.addTaskActivityGraph(tt);

		return null;
	}

	@Override
	public String caseOpenWorkload(OpenWorkload openWorkload) {
		UsageScenario us = (UsageScenario) openWorkload.eContainer();
		String id = Pcm2LqnHelper.getIdForUsageScenario(us);
		
		ProcessorType pt = lqnBuilder.addProcessor(id);
		TaskType tt = lqnBuilder.addTask(id,pt);

		EntryType et = lqnBuilder.addEntry(id,tt);
		
		//Arrival rate is Kehrwert of the inter arrival time
		double interarrivaltime = 0;
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		String specification = openWorkload.getInterArrivalTime_OpenWorkload().getSpecification();
		
		Expression exp = ExpressionHelper.parseToExpression(specification);
		//TOOD: Only handles IntLiterals and DoubleLiterals
		if (IntLiteral.class.isInstance(exp)){
			IntLiteral intExp = (IntLiteral) exp;
			interarrivaltime = intExp.getValue();
		} else if (DoubleLiteral.class.isInstance(exp)) {
			DoubleLiteral doubleExp = (DoubleLiteral) exp;
			interarrivaltime = doubleExp.getValue();
		} else if(FunctionLiteral.class.isInstance(exp)) {
			ExpressionSolveVisitor expressionSolveVisitor = new ExpressionSolveVisitor(ExpressionHelper.getTypeAnnotation(exp));
			Expression result = (Expression) expressionSolveVisitor.doSwitch(exp);
			if (ProbabilityFunctionLiteral.class.isInstance(result)){
				ProbabilityFunctionLiteral propFunctionLiteral = (ProbabilityFunctionLiteral)result;
				ProbabilityFunction probFunc = propFunctionLiteral.getFunction_ProbabilityFunctionLiteral();
				if (probFunc instanceof ExponentialDistribution){
					ExponentialDistribution expDistr = (ExponentialDistribution)probFunc;
					interarrivaltime = 1/expDistr.getRate();
				}
		} else {
				throw new RuntimeException("Only double values, integer values or exponential functions are supported as interarrival time. You provided something else: "+specification);
		}
		} else {
			throw new RuntimeException("Only double values, integer values or exponential functions are supported as interarrival time. You provided something else: "+specification);
		}
	
		String arrivalRate = (1.0 / interarrivaltime)+"";
		et.setOpenArrivalRate(arrivalRate);

		lqnBuilder.addTaskActivityGraph(tt);

		return null;
	}

	@Override
	public String caseScenarioBehaviour(ScenarioBehaviour object) {
		return doSwitch(getStartAction(object));
	}

	@Override
	public String caseStart(Start object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		String entryId = "";
		
		if (object.eContainer().eContainer() instanceof UsageScenario) {
			UsageScenario us = (UsageScenario) object.eContainer().eContainer();
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			entryId = Pcm2LqnHelper.getIdForUsageScenario(us)+"_Entry";
			adt.setBoundToEntry(entryId);
		} else if (object.eContainer().eContainer() instanceof Loop){
			Loop loop = (Loop)object.eContainer().eContainer();
			ActivityDefType adt = lqnBuilder.addActivityDef(id);
			entryId = Pcm2LqnHelper.getId(loop, myContextWrapper)+"_Entry";
			adt.setBoundToEntry(entryId);
		} else { //nested scenario behaviour
			lqnBuilder.addActivityDef(id);
		}

		String successorId = (String) doSwitch(object.getSuccessor());
		lqnBuilder.addSequencePrecedence(id, successorId);

		if (entryId.equals("")) return id;
		else return entryId;
	}

	@Override
	public String caseStop(Stop object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		lqnBuilder.addActivityDef(id);
		return id;
	}

	@Override
	public String caseEntryLevelSystemCall(EntryLevelSystemCall object) {

		String id = Pcm2LqnHelper.getIdForEntryLevelSystemCall(object);

		List<ContextWrapper> contextWrapperList= myContextWrapper.getContextWrapperFor(object);

		double branchProb = 1.0/contextWrapperList.size();

		for (ContextWrapper contextWrapperForComponentInstance : contextWrapperList) {

			myContextWrapper = contextWrapperForComponentInstance;
			createCallActivity(object, id, contextWrapperForComponentInstance, branchProb);

		}


		String successorId = (String) doSwitch(object.getSuccessor());
		lqnBuilder.addSequencePrecedence(id, successorId);

		return id;
	}

	private void createCallActivity(EntryLevelSystemCall object, String id,
			ContextWrapper contextWrapperForComponentInstance, double callMeans) {
		RepositoryComponent offeringComponent = contextWrapperForComponentInstance.getAssCtx()
		.getEncapsulatedComponent__AssemblyContext();
								
		String entryId = "";
		if (offeringComponent instanceof BasicComponent) {
			ServiceEffectSpecification seff = contextWrapperForComponentInstance
					.getNextSEFF(object);
			Rdseff2Lqn seffVisitor = new Rdseff2Lqn(lqnBuilder, contextWrapperForComponentInstance);
			try {
				entryId = (String) seffVisitor
						.doSwitch((ResourceDemandingSEFF) seff);
			} catch (RuntimeException e) {
				logger.error("Error while visiting RDSEFF");
				throw e;
			}
		} else {
			logger.error("Composite Component type not yet supported.");
			throw new UnsupportedOperationException();
		}

		lqnBuilder.addActivityDef(id);
		lqnBuilder.addActivityMakingCall(id, entryId, CallType.SYNCH, callMeans);

	}

	@Override
	public String caseDelay(Delay object) {
//		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
//		
//		ActivityDefType adt = lqnBuilder.addActivityDef(id);
//		adt.setThinkTime(object.getTimeSpecification_Delay()
//						.getSpecification());
//
//		String successorId = (String) doSwitch(object.getSuccessor());
//		lqnBuilder.addSequencePrecedence(id, successorId);
//
//		return id;
		
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		
		ProcessorType delayProcessor = lqnBuilder.getProcessor(USAGE_DELAY);
		TaskType delayTask = delayProcessor.getTask().get(0);
		
		EntryType et = lqnBuilder.addEntry(USAGE_DELAY+counter,delayTask);
		et.setType(TypeType.PH1PH2);

		// the entry makes a call to the processor
		ActivityPhasesType apt = lqnBuilder.addActivityPhases(USAGE_DELAY+counter);
		counter++;
		
		String hostDemand = object.getTimeSpecification_Delay().getSpecification();
		apt.setHostDemandMean(hostDemand);
		
		PhaseActivities pa = lqnBuilder.addPhaseActivities(apt);
		et.setEntryPhaseActivities(pa);
		
		lqnBuilder.addActivityDef(id);
		lqnBuilder.addActivityMakingCall(id, et.getName(), CallType.SYNCH);

		String successorId = (String) doSwitch(object.getSuccessor());
		lqnBuilder.addSequencePrecedence(id, successorId);

		return id;
	}

	@Override
	public String caseBranch(Branch object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		
		lqnBuilder.addActivityDef(id);
		PrecedenceType ptBegin = lqnBuilder.addBeginBranchPrecedence(id);
		PrecedenceType ptEnd = lqnBuilder.addEndBranchPrecedence();

		EList<BranchTransition> btList = object.getBranchTransitions_Branch();
		for (BranchTransition bt : btList) {
			ScenarioBehaviour sb = bt.getBranchedBehaviour_BranchTransition();

			String startId = (String) doSwitch(sb);
			String branchProb = new Double(bt.getBranchProbability())
					.toString();
			lqnBuilder.addActivityOrType(startId,branchProb,ptBegin);

			String stopId = Pcm2LqnHelper.getId(getStopAction(sb), myContextWrapper);
			lqnBuilder.addActivityType(stopId, ptEnd);
		}

		String successorId = (String) doSwitch(object.getSuccessor());
		ptEnd.getPost().getActivity().setName(successorId);

		return id;
	}

	@Override
	public String caseLoop(Loop object) {
		String id = Pcm2LqnHelper.getId(object, myContextWrapper);
		
		String startId = handleLoopBody(object,id); // creates a new task/processor

		lqnBuilder.addActivityDef(id); // for the loop action
		// makes an external call to the task representing the loop body:
		ActivityMakingCallType amct = lqnBuilder.addActivityMakingCall(id,
				startId, CallType.SYNCH);
		amct.setCallsMean(getLoopIterations(object));

		String successorId = (String) doSwitch(object.getSuccessor());
		lqnBuilder.addSequencePrecedence(id, successorId);

		return id;
	}

	private String handleLoopBody(Loop loop, String id) {
		ProcessorType pt = lqnBuilder.addProcessor(id);
		TaskType tt = lqnBuilder.addTask(id,pt);
		//tt.setScheduling(TaskSchedulingType.INF);
		
		EntryType et = lqnBuilder.addEntry(id,tt);
		lqnBuilder.addTaskActivityGraph(tt);

		ScenarioBehaviour sb = loop.getBodyBehaviour_Loop();
		String startId = (String) doSwitch(getStartAction(sb));
		String stopId = Pcm2LqnHelper.getId(getStopAction(sb), myContextWrapper);
		lqnBuilder.addReplyActivity(id, startId, stopId);
		
		lqnBuilder.restoreFormerTaskActivityGraph();
		
		return startId;
	}

	private String getLoopIterations(Loop object) {
		ManagedPMF pmf = null;
		try {
			pmf = ManagedPMF.createFromString(object.getLoopIteration_Loop()
					.getSpecification());
		} catch (StringNotPDFException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
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

	private Stop getStopAction(ScenarioBehaviour object) {
		Stop stopAction = (Stop) EMFQueryHelper.getObjectByType(object
				.getActions_ScenarioBehaviour(), Stop.class);
		return stopAction;
	}

	private Start getStartAction(ScenarioBehaviour object) {
		Start startAction = (Start) EMFQueryHelper.getObjectByType(object
				.getActions_ScenarioBehaviour(), Start.class);
		return startAction;
	}

}
