package de.uka.ipd.sdq.pcm.pcm2taskmodel.transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.EmitEventAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.TaskList;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

/**
 * Each case returns the task it creates so that the calling case can use it as the successor.
 * @author martens
 *
 */
public class Rdseff2Taskmodel extends SeffSwitch<List<Task>> {

	private ContextWrapper contextWrapper;
	private TaskList taskModel;
	private double executionProbability;
	private TaskmodelBuilder builder;

	public Rdseff2Taskmodel(ContextWrapper contextWrapper, TaskList taskModel, TaskmodelBuilder builder, double globalExecutionProbability) {
		this.contextWrapper = contextWrapper;
		this.taskModel = taskModel;
		this.executionProbability = globalExecutionProbability;
		this.builder = builder;
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
			
			Rdseff2Taskmodel seffVisitor = new Rdseff2Taskmodel(contextWrapper, taskModel, builder, executionProbability);
			List<Task> innerTasks = seffVisitor.doSwitch(seff);
						
			contextWrapper = oldContextWrapper;

			// get last tasks of the inner task tree
			List<Task> danglingTasks = this.builder.collectDanglingTasks();
			
			List<Task> successors = doSwitch(object.getSuccessor_AbstractAction());
			
			// and connect them with the successors of this task
			this.builder.connectAllWithRemainingProbability(danglingTasks, successors);
			
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
				List<Task> currentInnerEndTasks = this.builder.collectDanglingTasks();
				double probabilityToExitLoop = sample.getProbability() / remainingPopulationProbability;
				// remember the probability to exit the loop here for later
				innerEndTasks.add(new ProbabilityAndTasks(probabilityToExitLoop, currentInnerEndTasks));
				
				// connect these tasks to previous loop iteration end tasks (previousEndTasks is empty in first iteration).
				this.builder.connectAllWithProbability(currentInnerTasks, previousEndTasks, 1 - probabilityToExitLoop);

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
			this.builder.connectAllWithProbability(successors, predecessors, probability);
		}
		
		return innerTasks;
		
	}



	private List<Task> repeatInnerLoopBehaviour(int numberOfRepetitions,
			ResourceDemandingBehaviour bodyBehaviourLoop) {
		if (numberOfRepetitions > 0 ){
			
			//initial tasks need to be returned
			List<Task> initialTasks = doSwitch(bodyBehaviourLoop);
			
	
			// repeat the do switch if more iterations are requested (i.e. if numberOfRepetitions > 1)
			for (int i = 1; i < numberOfRepetitions; i++) {
				
				List<Task> danglingTasks = this.builder.collectDanglingTasks();
				
				List<Task> successors = doSwitch(bodyBehaviourLoop);
				
				this.builder.connectAllWithRemainingProbability(danglingTasks, successors);
				
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
		
		Task dummyTask = this.builder.createTask(this.executionProbability, this.taskModel, "Branch "+object.getEntityName()+" "+object.getId()+" dummy task");
		
		for (AbstractBranchTransition bt : btList) {
			ResourceDemandingBehaviour rdb = bt.getBranchBehaviour_BranchTransition();

			Double branchProbNumeric = new Double(contextWrapper.getBranchProbability(bt));
			
			if (branchProbNumeric > 0){
			
				this.executionProbability = branchProbNumeric * oldProbabilityOfExecution;
				List<Task> innerTasks = doSwitch(rdb);
				
				for (Task task : innerTasks) {
					this.builder.createEdge(dummyTask, task, branchProbNumeric);
				}
			}
		}

		this.executionProbability = oldProbabilityOfExecution;
		
		// get last tasks of the inner task tree
		List<Task> danglingTasks = this.builder.collectDanglingTasks();
		
		List<Task> successors = doSwitch(object.getSuccessor_AbstractAction());
		
		// and connect them with the successors of this task
		this.builder.connectAllWithRemainingProbability(danglingTasks, successors);
		
		List<Task> result = new ArrayList<Task>(1);
		result.add(dummyTask);
		return result;
	}

	
	@Override
	public List<Task> caseResourceDemandingBehaviour(
			ResourceDemandingBehaviour object) {
		// start new list of dagnling tasks to be connected by this RDB's successor. 
		this.builder.openNewDanglingTaskList();
		return doSwitch(this.builder.getStartAction(object));
	}

	@Override
	public List<Task> caseInternalAction(InternalAction object) {
		Task task = this.builder.createTask(taskModel, object.getEntityName()+" "+object.getId());
		
		task.setFailureProbability(this.builder.getFailureProbability(object));
		task.setAllocationcontext(contextWrapper.getAllCtx());
		
		task.setProbabilityOfExecution(this.executionProbability);
		
		task.setAbstractaction(object);
		
		task.setRepositorycomponent(
				contextWrapper.getCompUsgCtx().getAssemblyContext_ComputedUsageContext().getEncapsulatedComponent__AssemblyContext());
		
		double demandedTime = 0;
		for (ParametricResourceDemand resourceDemand : object.getResourceDemand_Action()){
			demandedTime += contextWrapper.getMeanTimeConsumption(resourceDemand);
		}
		task.setMeanDemandedTime(demandedTime);

		List<Task> successors = doSwitch(object.getSuccessor_AbstractAction());
		
		this.builder.connectTaskWithSuccessors(task, successors);
		
		return this.builder.asList(task);
		
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
