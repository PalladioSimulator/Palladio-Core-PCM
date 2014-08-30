package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityDefType;
import LqnCore.ActivityListType;
import LqnCore.ActivityMakingCallType;
import LqnCore.ActivityOrType;
import LqnCore.ActivityPhasesType;
import LqnCore.ActivityType;
import LqnCore.AndJoinListType;
import LqnCore.EntryType;
import LqnCore.LqnCoreFactory;
import LqnCore.LqnModelType;
import LqnCore.OrListType;
import LqnCore.OutputEntryDistributionType;
import LqnCore.PhaseActivities;
import LqnCore.PrecedenceType;
import LqnCore.ProcessorType;
import LqnCore.ReplyActivityType;
import LqnCore.ReplyEntryType;
import LqnCore.SchedulingType;
import LqnCore.SemaphoreType;
import LqnCore.ServiceType;
import LqnCore.SingleActivityListType;
import LqnCore.SolverParamsType;
import LqnCore.TaskActivityGraph;
import LqnCore.TaskOptionType;
import LqnCore.TaskSchedulingType;
import LqnCore.TaskType;
import LqnCore.TypeType;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;

public class LqnBuilder {

	private static Logger logger = Logger.getLogger(LqnBuilder.class.getName());

	private LqnCoreFactory lqnFactory = LqnCoreFactory.eINSTANCE;
	private LqnModelType lqnModel = null;

	private Stack<TaskActivityGraph> taskGraphStack = new Stack<TaskActivityGraph>();

	private boolean isLQSimAnalysis;
	private boolean isInfiniteTaskMultiplicity;

	public LqnBuilder(boolean isInfTask) {
		lqnModel = lqnFactory.createLqnModelType();
		lqnModel.setName("PCM2LQN_Model");
		
		setIsLQSimAnalysis(false);
		this.isInfiniteTaskMultiplicity = isInfTask;
	}

	/**
	 * Creates a new processor if no processor with the given id exists yet.
	 * Otherwise, returns the matching existing processor. 
	 * See {@link #getProcessorTypeFromModel(String)} for how to match the id.
	 * 
	 * @param id
	 * @return
	 */
	public ProcessorType addProcessor(String id) {
		ProcessorType pt = getProcessorTypeFromModel(id);
		if (pt == null) {
			pt = lqnFactory.createProcessorType();
			pt.setName(id + "_Processor");
			pt.setMultiplicity(new BigInteger("1"));
			pt.setScheduling(SchedulingType.FCFS);
			lqnModel.getProcessor().add(pt);
		}
		return pt;
	}

	private ProcessorType getProcessorTypeFromModel(String id) {
		EList<ProcessorType> list = lqnModel.getProcessor();
		for (ProcessorType procType : list) {
			if (procType.getName().equals(id + "_Processor")) {
				return procType;
			}
		}
		return null;
	}

	private EntryType getEntryTypeFromTask(String id, TaskType tt) {
		EList<EntryType> entryList = tt.getEntry();
		for (EntryType entryType : entryList) {
			if (entryType.getName().equals(id + "_Entry")) {
				return entryType;
			}
		}
		return null;
	}
	
	/**
	 * Checks whether the passed {@link ProcessorType} contains a task. 
	 * If yes, the first task is returned. If no, a new task is created and
	 * added to the processor. 
	 * 
	 * Two entries are created for the task if it is newly created: A wait entry and a signal 
	 * entry. The entry ids are created using {@link #getSignalEntryId(String)} and
	 * {@link #getWaitEntryId(String)} (use these for accessing the entries, using the id of the
	 * passive resource).
	 * 
	 * The multiplicity of the task are set to the passed capacity.
	 * 
	 * @param id The id of the {@link PassiveResource}
	 * @param pt 
	 * @param capacity The {@link PassiveResource}'s capacity
	 * @return
	 */
	public TaskType addSemaphoreTask(String id, ProcessorType pt, int capacity){
		
		TaskType tt = addTask(id, pt);
		
		//if this task has been newly created, it has no semaphore scheduling yet 
		//and thus needs to be initialised.
		if (!tt.getScheduling().equals(TaskSchedulingType.SEMAPHORE)){
			
			//set this task to be a semaphore (see LQN userman Sec. 3.2.3) 
			tt.setScheduling(TaskSchedulingType.SEMAPHORE);
			//set the capacity (see LQN userman Sec. 1.1.2)
			tt.setMultiplicity(BigInteger.valueOf(capacity));
			
			LqnCoreFactory lqnFactory = LqnCoreFactory.eINSTANCE;
			
			EntryType wait = lqnFactory.createEntryType();
			wait.setName(Pcm2LqnHelper.getWaitEntryId(id));
			wait.setType(TypeType.PH1PH2); 
			wait.setSemaphore(SemaphoreType.WAIT);
			tt.getEntry().add(wait);
			
			ActivityPhasesType aptWait = this.addActivityPhases(id);
			PhaseActivities paWait = this.addPhaseActivities(aptWait);
			wait.setEntryPhaseActivities(paWait);
			
			EntryType signal = lqnFactory.createEntryType();
			signal.setName(Pcm2LqnHelper.getSignalEntryId(id));
			signal.setType(TypeType.PH1PH2); 
			signal.setSemaphore(SemaphoreType.SIGNAL);
			tt.getEntry().add(signal);
			
			ActivityPhasesType aptSignal = this.addActivityPhases(id);
			PhaseActivities paSignal = this.addPhaseActivities(aptSignal);
			signal.setEntryPhaseActivities(paSignal);
			
		}
		return tt;
		
	}

	/**
	 * Checks whether the passed {@link ProcessorType} contains a task. 
	 * If yes, the first task is returned. If no, a new task is created and
	 * added to the processor. 
	 * 
	 * @param id
	 * @param pt
	 * @return
	 */
	public TaskType addTask(String id, ProcessorType pt) {

		TaskType tt = null;
		if (!pt.getTask().isEmpty()) {
			tt = pt.getTask().get(0);
		}
		if (tt == null) {
			tt = lqnFactory.createTaskType();
			tt.setName(id + "_Task");
			tt.setMultiplicity(new BigInteger("1"));

			tt.setThinkTime("0.0");
			tt.setActivityGraph(TaskOptionType.YES);

			if (this.isInfiniteTaskMultiplicity){
				tt.setScheduling(TaskSchedulingType.INF);				
			} else{
				tt.setScheduling(TaskSchedulingType.FCFS);
				tt.setMultiplicity(new BigInteger("10000"));
			}

			ServiceType st = lqnFactory.createServiceType();
			st.setName("MyService");
			tt.getService().add(st);

			pt.getTask().add(tt);
		}
		return tt;
	}

	public TaskType addTaskForResourceDemand(String id, ProcessorType pt) {

		TaskType tt = null;
		if (!pt.getTask().isEmpty()) {
			EList<TaskType> taskList = pt.getTask();
			for (TaskType t : taskList) {
				if (t.getName().equals(id + "_Task")) {
					return t;
				}
			}
		}
		if (tt == null) {
			tt = lqnFactory.createTaskType();
			tt.setName(id + "_Task");
			tt.setMultiplicity(new BigInteger("1"));

			tt.setThinkTime("0.0");
			tt.setScheduling(TaskSchedulingType.FCFS);
			tt.setActivityGraph(TaskOptionType.YES);

			ServiceType st = lqnFactory.createServiceType();
			st.setName("MyService");
			tt.getService().add(st);

			pt.getTask().add(tt);
		}
		return tt;
	}

	public EntryType addEntry(String id, TaskType tt) {
		EntryType et = getEntryTypeFromTask(id, tt);
		if (et == null) {
			et = lqnFactory.createEntryType();
			et.setName(id + "_Entry");
			et.setType(TypeType.NONE); // actually TypeType.GRAPH, but not
			// supported by lqns
			tt.getEntry().add(et);
		}
		return et;
	}

	public TaskActivityGraph addTaskActivityGraph(TaskType tt) {
		TaskActivityGraph taskActivityGraph = tt.getTaskActivities();
		if (taskActivityGraph == null) {
			taskActivityGraph = lqnFactory.createTaskActivityGraph();
			tt.setTaskActivities(taskActivityGraph);
		}
		taskGraphStack.push(taskActivityGraph);
		return taskActivityGraph;
	}

	public OutputEntryDistributionType addOutputEntryDistributionType(
			EntryType et) {
		OutputEntryDistributionType oedt = lqnFactory
				.createOutputEntryDistributionType();
		oedt.setPhase(new BigInteger("1"));
		oedt.setMin("0.0");
		oedt.setMax("10.0");
		et.getServiceTimeDistribution().add(oedt);
		return oedt;
	}

	public ReplyActivityType addReplyActivity(String id, String startId,
			String stopId) {
		EList<ReplyEntryType> list = taskGraphStack.peek().getReplyEntry();
		if (list.size() > 0) {
			return list.get(0).getReplyActivity().get(0);
		}

		ReplyActivityType rat = lqnFactory.createReplyActivityType();
		// rat.setName((String)doSwitch(getStartAction(sb)));
		rat.setName(stopId);

		ReplyEntryType ret = lqnFactory.createReplyEntryType();
		ret.setName(id + "_Entry");
		ret.getReplyActivity().add(rat);
		taskGraphStack.peek().getReplyEntry().add(ret);
		return rat;
	}

	public PrecedenceType addSequencePrecedence(String firstId, String secondId) {
		EList<PrecedenceType> list = taskGraphStack.peek().getPrecedence();
		for (PrecedenceType precType : list) {
			SingleActivityListType salt = precType.getPre();
			if (salt != null) {
				if (salt.getActivity().getName().equals(firstId)) {
					return precType;
				}
			}
		}

		PrecedenceType pt = lqnFactory.createPrecedenceType();

		SingleActivityListType saltPre = lqnFactory
				.createSingleActivityListType();
		ActivityType atPre = lqnFactory.createActivityType();
		atPre.setName(firstId);
		saltPre.setActivity(atPre);

		SingleActivityListType saltPost = lqnFactory
				.createSingleActivityListType();
		ActivityType atPost = lqnFactory.createActivityType();
		atPost.setName(secondId);
		saltPost.setActivity(atPost);

		pt.setPre(saltPre);
		pt.setPost(saltPost);

		taskGraphStack.peek().getPrecedence().add(pt);
		return pt;
	}

	public ActivityDefType addActivityDef(String id) {
		EList<ActivityDefType> list = taskGraphStack.peek().getActivity();
		for (ActivityDefType actDefType : list) {
			if (actDefType.getName().equals(id))
				return actDefType;
		}

		ActivityDefType adt = lqnFactory.createActivityDefType();
		adt.setHostDemandMean("0.0");
		adt.setName(id);
		taskGraphStack.peek().getActivity().add(adt);
		return adt;
	}
	
	/**
	 * Add or reuse an activity making call with call means = 1.0
	 * @param callId
	 * @param targetId
	 * @param callType
	 * @return
	 */
	public ActivityMakingCallType addActivityMakingCall(String callId,
			String targetId, CallType callType) {
		return addActivityMakingCall(callId, targetId, callType, 1.0);
	}

	/**
	 * Add or reuse an activity making call
	 * @param callId
	 * @param targetId
	 * @param callType 
	 * @param callMeans 
	 * @return
	 */
	public ActivityMakingCallType addActivityMakingCall(String callId,
			String targetId, CallType callType, double callMeans) {
		EList<ActivityDefType> actList = taskGraphStack.peek().getActivity();
		// check the existing ActivityMakingCallTypes and possibly reuse one of them
		for (ActivityDefType actDefType : actList) {
			if (actDefType.getName().equals(callId)) {
				EList<ActivityMakingCallType> list2 = null;
				if (callType == CallType.SYNCH){
					list2 = actDefType.getSynchCall();
				} else {
					list2 = actDefType.getAsynchCall();
				}
				for (ActivityMakingCallType amct : list2) {
					if (amct.getDest().equals(targetId)){
						// should not be incremented when this part of the system is just revisited due to parameters in different contexts / or replication
						//amct.setCallsMean(""+(getDoubleFromValue(amct.getCallsMean())+callMeans));
						amct.setCallsMean("1.0");
						return amct;
					}
				}
			}
		}

		// no existing matching ActivityMakingCallType found, use a new one. 
		ActivityMakingCallType amct = lqnFactory.createActivityMakingCallType();
		amct.setDest(targetId);
		amct.setCallsMean(""+callMeans);

		EList<ActivityDefType> list = taskGraphStack.peek().getActivity();
		for (ActivityDefType adt : list) {
			if (adt.getName().equals(callId)) {
				if (callType == CallType.SYNCH){
					adt.getSynchCall().add(amct);
				} else {
					adt.getAsynchCall().add(amct);
				}
			}
		}

		return amct;
	}

	private double getDoubleFromValue(Object callsMean) {
		if (callsMean instanceof String){
			return Double.valueOf((String)callsMean);
		} if (callsMean instanceof Double){
			return ((Double)callsMean).doubleValue();
		} else {
			throw new RuntimeException("Cannot parse LQN value "+callsMean.getClass().getName()+" "+callsMean.toString());
		}
		
	}

	public PrecedenceType addBeginBranchPrecedence(String id) {
		EList<PrecedenceType> list = taskGraphStack.peek().getPrecedence();
		for (PrecedenceType precType : list) {
			if (precType.getPre()!= null){
				if (precType.getPre().getActivity().getName().equals(id)) {
					return precType;
				}
			}
		}

		PrecedenceType ptBegin = getInitialPrecedence(id);

		OrListType oltPreBegin = lqnFactory.createOrListType(); // branch
		ptBegin.setPostOR(oltPreBegin);
		taskGraphStack.peek().getPrecedence().add(ptBegin);

		return ptBegin;
	}

	private PrecedenceType getInitialPrecedence(String id) {
		PrecedenceType ptBegin = lqnFactory.createPrecedenceType();
		SingleActivityListType saltPreBegin = lqnFactory
				.createSingleActivityListType();
		ActivityType atPre = lqnFactory.createActivityType();
		atPre.setName(id);
		saltPreBegin.setActivity(atPre);
		ptBegin.setPre(saltPreBegin);
		return ptBegin;
	}
	
	
	public PrecedenceType addBeginForkPrecedence(String id){
		EList<PrecedenceType> list = taskGraphStack.peek().getPrecedence();
		for (PrecedenceType precType : list) {
			if (precType.getPre()!= null){
				if (precType.getPre().getActivity().getName().equals(id)) {
					return precType;
				}
			}
		}
		
		PrecedenceType ptBegin = getInitialPrecedence(id);
		
		ActivityListType alt = lqnFactory.createActivityListType();
		ptBegin.setPostAND(alt);
		taskGraphStack.peek().getPrecedence().add(ptBegin);
		return ptBegin;		
	}
	
	public PrecedenceType addEndForkPrecedence(){
		PrecedenceType ptEnd = lqnFactory.createPrecedenceType();
		AndJoinListType ajlt = lqnFactory.createAndJoinListType();
		ptEnd.setPreAND(ajlt);
		
		SingleActivityListType saltPostEnd = lqnFactory.createSingleActivityListType();
		ActivityType atPostEnd = lqnFactory.createActivityType();
		saltPostEnd.setActivity(atPostEnd);
		
		ptEnd.setPost(saltPostEnd);
		taskGraphStack.peek().getPrecedence().add(ptEnd);
		return ptEnd;
	}
	

	public PrecedenceType addEndBranchPrecedence() {
		PrecedenceType ptEnd = lqnFactory.createPrecedenceType();
		ActivityListType altPreEnd = lqnFactory.createActivityListType(); // merge
		ptEnd.setPreOR(altPreEnd);

		SingleActivityListType saltPostEnd = lqnFactory
				.createSingleActivityListType();
		ActivityType atPostEnd = lqnFactory.createActivityType();
		// atPostEnd.setName(successorId);
		saltPostEnd.setActivity(atPostEnd);

		ptEnd.setPost(saltPostEnd);
		taskGraphStack.peek().getPrecedence().add(ptEnd);
		return ptEnd;
	}

	public ActivityOrType addActivityOrType(String startId, String branchProb,
			PrecedenceType pt) {
		EList<ActivityOrType> list = pt.getPostOR().getActivity();
		for (ActivityOrType aot : list) {
			if (aot.getName().equals(startId))
				return aot;
		}

		ActivityOrType aot = lqnFactory.createActivityOrType();
		aot.setProb(branchProb);
		aot.setName(startId);
		pt.getPostOR().getActivity().add(aot);
		return aot;
	}

	public ActivityType addActivityType(String stopId, PrecedenceType pt) {
		EList<ActivityType> list = pt.getPreOR().getActivity();
		for (ActivityType at : list) {
			if (at.getName().equals(stopId))
				return at;
		}

		ActivityType at = lqnFactory.createActivityType();
		at.setName(stopId);
		pt.getPreOR().getActivity().add(at);
		return at;
	}

	public PhaseActivities addPhaseActivities(ActivityPhasesType apt) {
		PhaseActivities pa = lqnFactory.createPhaseActivities();
		pa.getActivity().add(apt);
		return pa;
	}

	public ActivityPhasesType addActivityPhases(String id) {
		ActivityPhasesType apt = lqnFactory.createActivityPhasesType();
		apt.setHostDemandMean("0.0");
		apt.setPhase(new BigInteger("1"));
		apt.setName(id + "_Activity");
		return apt;
	}

	public TaskType getTaskForProcessor(String processorId) {
		EList<ProcessorType> list = lqnModel.getProcessor();
		for (ProcessorType pt : list) {
			if (pt.getName().equals(processorId + "_Processor")) {
				return pt.getTask().get(0);
			}
		}
		logger.error("Could not find processor in Lqn Model.");
		return null;
	}

	public void finalizeLqnModel(PCMSolverWorkflowRunConfiguration config) {

		// Two branches may generated two precedences with exactly
		// the same activities, which causes errors in the lqn solver.
		// this one needs to be deleted.
		// This can happen if this SEFF is called from multiple contexts.
		// TODO: should we not be able to distinguish multiple contexts?
		List<ProcessorType> processors = this.lqnModel.getProcessor();
		// We want to compare the precedences for all processors and all their
		// activities
		for (ProcessorType processorType : processors) {
			if (processorType == null)
				continue;
			List<TaskType> tasks = processorType.getTask();
			for (TaskType taskType : tasks) {
				if (taskType == null)
					continue;
				TaskActivityGraph taskActivityGraph = taskType
						.getTaskActivities();
				if (taskActivityGraph == null)
					continue;
				List<PrecedenceType> precedences = taskActivityGraph
						.getPrecedence();
				// Compare each precedence entry with each other. We only
				// compare the pre entries.
				for (int i = 0; i < precedences.size() - 1; i++) {
					// using an temporary variable here for iteration to avoid
					// concurrent modification exceptions.
					// Size is checked again each time, so this should be safe.
					PrecedenceType precedenceType = precedences.get(i);
					// Only compare with the ones further down in the list, so
					// we compare each pair just once.
					for (ListIterator<PrecedenceType> iteratorToCompareTo = precedences
							.listIterator(i + 1); iteratorToCompareTo.hasNext();) {
						// using an iterator here to be able to directly remove
						// a found duplicate element.
						PrecedenceType precedenceTypeToCompareTo = (PrecedenceType) iteratorToCompareTo
								.next();
						// logger.debug("comparing item "+i+" with item "+nextIndex);
						if (duplicatePrecedence(precedenceType,
								precedenceTypeToCompareTo)) {
							iteratorToCompareTo.remove();
							// logger.warn("removed precedence with index "+nextIndex);
						}

					}
				}
			}
		}

		SolverParamsType spt = LqnCoreFactory.eINSTANCE
				.createSolverParamsType();

		spt.setConvVal(config.getConvValue());

		int itLimit = Integer.parseInt(config.getItLimit());
		spt.setItLimit(itLimit);

		int printInt = Integer.parseInt(config.getPrintInt());
		spt.setPrintInt(printInt);

		spt.setUnderrelaxCoeff(config.getUnderCoeff());

		spt.setComment("Generated by PCM2LQN on " + new Date());

		lqnModel.setSolverParams(spt);
		
	}

	/**
	 * Checks whether all pre entries of the precedence are different.
	 * 
	 * @param precedenceType
	 * @param precedenceTypeToCompareTo
	 * @return
	 */
	private boolean duplicatePrecedence(PrecedenceType precedenceType,
			PrecedenceType precedenceTypeToCompareTo) {

		boolean same = false;

		// first compare normal pre
		if (precedenceType.getPre() != null
				&& precedenceTypeToCompareTo.getPre() != null
				&& precedenceType.getPre().getActivity() != null
				&& precedenceTypeToCompareTo.getPre().getActivity() != null) {
			if (precedenceType.getPre().getActivity().getName().equals(
					precedenceTypeToCompareTo.getPre().getActivity().getName())) {
				same = true;
			}
		}

		// compare pre-AND
		if (precedenceType.getPreAND() != null
				&& precedenceTypeToCompareTo.getPreAND() != null) {
			List<ActivityType> activityList = precedenceType.getPreAND()
					.getActivity();
			List<ActivityType> activityListToCompareTo = precedenceTypeToCompareTo
					.getPreAND().getActivity();
			if (listContainsSameActivities(activityList,
					activityListToCompareTo))
				same = true;
		}

		// compare pre-OR
		if (precedenceType.getPreOR() != null
				&& precedenceTypeToCompareTo.getPreOR() != null) {
			List<ActivityType> activityList = precedenceType.getPreOR()
					.getActivity();
			List<ActivityType> activityListToCompareTo = precedenceTypeToCompareTo
					.getPreOR().getActivity();
			if (listContainsSameActivities(activityList,
					activityListToCompareTo))
				same = true;
		}
		return same;
	}

	private boolean listContainsSameActivities(List<ActivityType> activityList,
			List<ActivityType> activityListToCompareTo) {
		if (activityList == null || activityListToCompareTo == null
				|| activityList.size() == 0
				|| activityListToCompareTo.size() != activityList.size()) {
			return false;
		}
		for (int i = 0; i < activityList.size(); i++) {
			ActivityType activity1 = activityList.get(i);
			ActivityType activity2 = activityListToCompareTo.get(i);
			if (!activity1.getName().equals(activity2.getName())) {
				return false;
			}
		}
		return true;
	}

	public void restoreFormerTaskActivityGraph() {
		taskGraphStack.pop();
	}

	public LqnModelType getLqnModel() {
		return lqnModel;
	}

	public ProcessorType getProcessor(String processorId) {
		EList<ProcessorType> list = lqnModel.getProcessor();
		for (ProcessorType pt : list) {
			if (pt.getName().equals(processorId + "_Processor")) {
				return pt;
			}
		}
		return null;
	}

	public boolean isLQSimAnalysis() {
		return this.isLQSimAnalysis;
	}
	
	public void setIsLQSimAnalysis(boolean isQLSim){
		this.isLQSimAnalysis = isQLSim;
		Pcm2LqnHelper.shortenIds = this.isLQSimAnalysis;
	}

	public void addActivityToPostAnd(String startId, PrecedenceType ptBegin) {
		ActivityType at = lqnFactory.createActivityType();
		at.setName(startId);
		ptBegin.getPostAND().getActivity().add(at);
	}

	public void addActivityToPreAnd(String stopId, PrecedenceType ptEnd) {
		ActivityType at = lqnFactory.createActivityType();
		at.setName(stopId);
		ptEnd.getPreAND().getActivity().add(at);
	}

	public void setPoolCapacity(Integer poolCapacity) {
		TaskActivityGraph tag = taskGraphStack.peek();		
		TaskType task = (TaskType)tag.eContainer();
		task.setMultiplicity(new BigInteger(poolCapacity.toString()));
		task.setScheduling(TaskSchedulingType.FCFS);
	}
	
}

enum CallType {SYNCH, ASYNCH}
