package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityDefType;
import LqnCore.ActivityMakingCallType;
import LqnCore.ActivityPhasesType;
import LqnCore.EntryType;
import LqnCore.PhaseActivities;
import LqnCore.PrecedenceType;
import LqnCore.ProcessorType;
import LqnCore.TaskType;
import LqnCore.TypeType;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.probfunction.math.IContinousPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;

public class Rdseff2Lqn extends SeffSwitch {

	private static Logger logger = Logger.getLogger(Rdseff2Lqn.class.getName());
	
	private ContextWrapper contextWrapper;
	private LqnBuilder lqnBuilder;
	
	public Rdseff2Lqn(LqnBuilder aLqnBuilder, ContextWrapper aContextWrapper) {
		lqnBuilder = aLqnBuilder;
		contextWrapper = aContextWrapper;
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
				String startId = (String) doSwitch(rdb);
				String branchProb = new Double(contextWrapper.getBranchProbability(bt)).toString();
				lqnBuilder.addActivityOrType(startId,branchProb, ptBegin);

				String stopId = Pcm2LqnHelper.getId(getStopAction(rdb), contextWrapper);
				lqnBuilder.addActivityType(stopId, ptEnd);
//			}
		}

		String successorId = (String) doSwitch(object.getSuccessor_AbstractAction());
		ptEnd.getPost().getActivity().setName(successorId);

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
		
		ResourceDemandingSEFF seff = (ResourceDemandingSEFF)contextWrapper.getNextSEFF(object);
		if (seff == null){
			// this is a system external call
			// we continue with the internal action added after this action
			return doSwitch(object.getSuccessor_AbstractAction());
		} else {
			ContextWrapper oldContextWrapper = (ContextWrapper)contextWrapper.clone();
			contextWrapper = contextWrapper.getContextWrapperFor(object);
	
			String entryId = "";
			Rdseff2Lqn seffVisitor = new Rdseff2Lqn(lqnBuilder, contextWrapper);
			try {
				entryId = (String)seffVisitor.doSwitch(seff);
			} catch (Exception e) {
				logger.error("Error while visiting RDSEFF");
				e.printStackTrace();
			}
			
			contextWrapper = oldContextWrapper;
			
			lqnBuilder.addActivityDef(id);
			lqnBuilder.addActivityMakingCall(id, entryId);
			String successorId = (String) doSwitch(object.getSuccessor_AbstractAction());
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
			ManagedPDF pdf = contextWrapper.getTimeConsumption(resourceDemand);
			String hostDemand = null;
			try {
				hostDemand = new Double(pdf.getPdfTimeDomain().getArithmeticMeanValue()).toString();
			} catch (DomainNotNumbersException e) {
				logger.error("Error calculating arithmetic mean value.", e);
				e.printStackTrace();
			} catch (FunctionNotInTimeDomainException e) {
				logger.error("Error calculating arithmetic mean value.", e);
				e.printStackTrace();
			}
			apt.setHostDemandMean(hostDemand);
			
			//if continuous function, get coefficient of variance
			//TODO: also get this for stepwise defined functions!
			IProbabilityDensityFunction innerPDF = pdf.getPdfTimeDomain();
			if (innerPDF instanceof IContinousPDF){
				IContinousPDF innerContPDF = (IContinousPDF)innerPDF; 
				double coeffv = innerContPDF.getCoefficientOfVariance();
				Double squaredcv = coeffv * coeffv;
				apt.setHostDemandCvsq(squaredcv.toString());
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
		lqnBuilder.addSequencePrecedence(id+(counter-1), successorId);

		return id+0; // for predecessor
	}

	private String getProcessorName(ParametricResourceDemand resourceDemand) {
		ProcessingResourceSpecification prs = contextWrapper.getConcreteProcessingResource(resourceDemand);
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
