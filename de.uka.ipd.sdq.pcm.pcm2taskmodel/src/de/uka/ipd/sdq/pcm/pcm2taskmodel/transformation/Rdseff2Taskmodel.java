package de.uka.ipd.sdq.pcm.pcm2taskmodel.transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.reliability.FailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.EmitEventAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.TaskList;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.Pcm2LqnHelper;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.Rdseff2Lqn;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

public class Rdseff2Taskmodel extends SeffSwitch<List<Task>> {

	private ContextWrapper contextWrapper;
	private TaskList taskModel;
	private double executionProbability;
	
	private static Logger logger = Logger.getLogger(Rdseff2Taskmodel.class
			.getName());

	public Rdseff2Taskmodel(ContextWrapper contextWrapper, TaskList taskModel, double globalExecutionProbability) {
		this.contextWrapper = contextWrapper;
		this.taskModel = taskModel;
		this.executionProbability = globalExecutionProbability;
	}

	@Override
	public List<Task> caseExternalCallAction(ExternalCallAction object) {
		ResourceDemandingSEFF seff = (ResourceDemandingSEFF)contextWrapper.getNextSEFF(object);
		if (seff == null){
			// this is a system external call
			// we continue with the internal action added after this action
			return doSwitch(object.getSuccessor_AbstractAction());
		} else {
			ContextWrapper oldContextWrapper = (ContextWrapper)contextWrapper.clone();
			contextWrapper = contextWrapper.getContextWrapperFor(object);
			
			Rdseff2Taskmodel seffVisitor = new Rdseff2Taskmodel(contextWrapper, taskModel, executionProbability);
			List<Task> innerTasks = seffVisitor.doSwitch(seff);
						
			contextWrapper = oldContextWrapper;

			
			List<Task> successors = doSwitch(object.getSuccessor_AbstractAction());
			
			// get last tasks of the inner task tree and connect them with the successors of this task
			TaskmodelBuilder.connectAllDanglingInnerTasksWithSuccessors(innerTasks, successors);
			
			return innerTasks;
		}
	}



	@Override
	public List<Task> caseAbstractLoopAction(AbstractLoopAction object) {
		ManagedPMF iterations = contextWrapper.getLoopIterations(object);
		ResourceDemandingBehaviour bodyBehaviour = object.getBodyBehaviour_Loop();
		
		double oldProbabilityOfExecution = this.executionProbability;
		
		List<Sample> samples = iterations.getModelPmf().getSamples();
		// we assume here that the samples are ordered from smallest to largest. 
		
		// store the initial tasks of the first iteration to return this to this Loop's predecessor
		List<Task> innerTasks = new ArrayList<Task>();
		
		// store the loop exit probabilities to later connect all end tasks to this Loop's successor tasks (see below). 
		List<ProbabilityAndTasks> innerEndTasks = new ArrayList<ProbabilityAndTasks>();
		
		// 1 - probabilities that have already been handled, multiply all remaining probabilities by this
		// remaining "Grundgesamtheit"
		double remainingPopulationProbability = 1;
				
		// first, create so many repetitions as needed for the first sample
		// and then exit with the probability of the first sample
		if (samples.size() >0 ){
			
			// to calculate how many repetitions in the next step, thisSample.value - previousSample.value 
			int position = 0;
			
			// remember previous tasks to connect the edges within the loop.
			List<Task> previousEndTasks = Collections.emptyList();
			
			for (Sample sample : samples) {
				// get probability from each sample and clone the inner behaviour so many times
				Integer iterationValue = (Integer)sample.getValue();
				
				// repeat the loop thisSample.value - previousSample.value times
				List<Task> currentInnerTasks = repeatInnerLoopBehaviour(iterationValue - position, bodyBehaviour);

				// collect all end tasks of the previous loop iteration. They need to be connected to the 
				// next loop iteration (within this for loop) and to the exit node for the case that the loop ends here
				// (after this for loop, see below). 
				List<Task> currentInnerEndTasks = TaskmodelBuilder.collectDanglingTasks(currentInnerTasks);
				double probabilityToExitLoop = sample.getProbability() / remainingPopulationProbability;
				// remember the probability to exit the loop here for later
				innerEndTasks.add(new ProbabilityAndTasks(probabilityToExitLoop, currentInnerEndTasks));
				
				// connect these tasks to previous loop iteration end tasks (previousEndTasks is empty in first iteration).
				TaskmodelBuilder.connectAllWithProbability(currentInnerTasks, previousEndTasks, 1 - probabilityToExitLoop);

				//only the start tasks of the first iteration need to be stored and then returned to the whole Loop's predecessor
				if (samples.indexOf(sample) == 0){
					innerTasks.addAll(currentInnerTasks);
				}
				
				position = iterationValue;
				remainingPopulationProbability -= sample.getProbability();
				previousEndTasks = currentInnerEndTasks;
				
				//reduce execution probability with the probability that the loop is exited here.
				this.executionProbability = this.executionProbability - probabilityToExitLoop; 
			}

		
		}
		
		this.executionProbability = oldProbabilityOfExecution;
		List<Task> successors = doSwitch(object.getSuccessor_AbstractAction());
		
		// connect according to probability with successors 
		for (ProbabilityAndTasks probabilityAndTasks : innerEndTasks) {
			List<Task> predecessors = probabilityAndTasks.getCurrentInnerEndTasks();
			double probability = probabilityAndTasks.getProbability();
			TaskmodelBuilder.connectAllWithProbability(successors, predecessors, probability);
		}
		
		return innerTasks;
		
	}



	private List<Task> repeatInnerLoopBehaviour(int numberOfRepetitions,
			ResourceDemandingBehaviour bodyBehaviourLoop) {
		if (numberOfRepetitions > 0 ){
			
			//initial tasks need to be returned
			List<Task> initialTasks = doSwitch(bodyBehaviourLoop);
			
			List<Task> currentTasks = initialTasks;
			
			// repeat the do switch if more iterations are requested (i.e. if numberOfRepetitions > 1)
			for (int i = 1; i <= numberOfRepetitions; i++) {
				
				List<Task> successors = doSwitch(bodyBehaviourLoop);
				
				TaskmodelBuilder.connectAllDanglingInnerTasksWithSuccessors(currentTasks, successors);
				currentTasks = successors;
				
			}
			return initialTasks;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public List<Task> caseBranchAction(BranchAction object) {
		EList<AbstractBranchTransition> btList = object.getBranches_Branch();
		
		double oldProbabilityOfExecution = this.executionProbability;
		
		Task dummyTask = TaskmodelBuilder.createTask(this.executionProbability, this.taskModel);
		
		List<Task> allInnerTasks = new LinkedList<Task>();
		
		for (AbstractBranchTransition bt : btList) {
			ResourceDemandingBehaviour rdb = bt.getBranchBehaviour_BranchTransition();

			Double branchProbNumeric = new Double(contextWrapper.getBranchProbability(bt));
			
			if (branchProbNumeric > 0){
			
				this.executionProbability = branchProbNumeric * oldProbabilityOfExecution;
				List<Task> innerTasks = doSwitch(rdb);
				
				for (Task task : innerTasks) {
					dummyTask.getEdge_Task().add(TaskmodelBuilder.createEdge(task, branchProbNumeric));
				}
			}
		}

		this.executionProbability = oldProbabilityOfExecution;
		List<Task> successors = doSwitch(object.getSuccessor_AbstractAction());
		TaskmodelBuilder.connectAllDanglingInnerTasksWithSuccessors(allInnerTasks, successors);
		
		List<Task> result = new ArrayList<Task>(1);
		result.add(dummyTask);
		return result;
	}

	
	@Override
	public List<Task> caseResourceDemandingBehaviour(
			ResourceDemandingBehaviour object) {
		return doSwitch(getStartAction(object));
	}

	@Override
	public List<Task> caseInternalAction(InternalAction object) {
		Task task = TaskmodelBuilder.createTask(taskModel);
		
		task.setFailureProbability(getFailureProbability(object));
		task.setAllocationcontext(contextWrapper.getAllCtx());
		
		task.setProbabilityOfExecution(this.executionProbability);
		
		task.setAbstractaction(object);
		
		task.setRepositorycomponent(
				contextWrapper.getCompUsgCtx().getAssemblyContext_ComputedUsageContext().getEncapsulatedComponent_AssemblyContext());
		
		double demandedTime = 0;
		for (ParametricResourceDemand resourceDemand : object.getResourceDemand_Action()){
			demandedTime += contextWrapper.getMeanTimeConsumption(resourceDemand);
		}
		task.setMeanDemandedTime(demandedTime);

		List<Task> successors = doSwitch(object.getSuccessor_AbstractAction());
		TaskmodelBuilder.connectTaskWithSuccessors(task, successors);
		
		return TaskmodelBuilder.asList(task);
		
	}
	
	
	
	@Override
	public List<Task> caseStopAction(StopAction object) {
		return Collections.emptyList();
	}

	@Override
	public List<Task> caseAbstractAction(AbstractAction object) {
		return doSwitch(object.getSuccessor_AbstractAction());
	}
	
	@Override
	public List<Task> caseEmitEventAction(EmitEventAction object) {
		throw new UnsupportedOperationException("Action "+object.getEntityName()+" of type "+object.getClass().getName()+" not supported in PCM2Taskmodel transformation yet.");
	}

	@Override
	public List<Task> caseForkAction(ForkAction object) {
		throw new UnsupportedOperationException("Action "+object.getEntityName()+" of type "+object.getClass().getName()+" not supported in PCM2Taskmodel transformation yet.");
	}

	@Override
	public List<Task> caseInternalCallAction(InternalCallAction object) {
		throw new UnsupportedOperationException("Action "+object.getEntityName()+" of type "+object.getClass().getName()+" not supported in PCM2Taskmodel transformation yet.");
	}

	private double getFailureProbability(InternalAction object) {
		
		double failureProbability = 0;
		
		List<FailureOccurrenceDescription> failures = object.getFailureOccurrenceDescriptions_InternalAction();
		for (FailureOccurrenceDescription failureOccurrenceDescription : failures) {
			failureProbability += failureOccurrenceDescription.getFailureProbability();
		}
		return failureProbability;
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

	
	/**
	 * Returns the first tasks of the task graph created by the switch. The 
	 * caller needs to set these as the successor of its own tasks. <p>
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public List<Task> doSwitch(EObject theEObject) {
		return super.doSwitch(theEObject);
	}
	
	

}

class ProbabilityAndTasks{

	private double probability;
	private List<Task> currentInnerEndTasks;

	public ProbabilityAndTasks(double probability,
			List<Task> currentInnerEndTasks) {
		this.probability = probability;
		this.currentInnerEndTasks = currentInnerEndTasks;
	}

	public double getProbability() {
		return probability;
	}

	public List<Task> getCurrentInnerEndTasks() {
		return currentInnerEndTasks;
	}
	
	
}
