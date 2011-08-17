package de.uka.ipd.sdq.pcm.pcm2taskmodel.transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.TaskList;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.StringNotPDFException;

public class Pcm2TaskmodelUsagemodelSwitch extends UsagemodelSwitch<List<Task>> {

	private TaskList taskModel;
	private ContextWrapper contextWrapper;
	
	private TaskmodelBuilder builder;
	
	private double executionProbability = 1;
	
	private static Logger logger = Logger.getLogger(Pcm2TaskmodelUsagemodelSwitch.class
			.getName());

	public Pcm2TaskmodelUsagemodelSwitch(TaskList taskModel,
			ContextWrapper contextWrapper) {

		this.taskModel = taskModel;
		this.contextWrapper = contextWrapper;
		
		builder = new TaskmodelBuilder();
		
	}
	
	@Override
	public List<Task> caseBranch(Branch object) {
		throw new UnsupportedOperationException("Branch is not yet supported in usage model by PCM2Taskmodel. Please simplify your model.");
	}

	@Override
	public List<Task> caseLoop(Loop object) {
		/* Copied from Rdseff2Taskmodel#caseAbstractLoopAction: Do not change here, but there. */
		ManagedPMF iterations = null;
		try {
			iterations = ManagedPMF.createFromString(object.getLoopIteration_Loop().getSpecification());
		} catch (StringNotPDFException e) {
			e.printStackTrace();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		//ManagedPMF iterations = contextWrapper.getLoopIterations(object);
		
		ScenarioBehaviour bodyBehaviour = object.getBodyBehaviour_Loop();
		
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
		List<Task> successors = doSwitch(object.getSuccessor());
		
		// connect according to probability with successors 
		for (ProbabilityAndTasks probabilityAndTasks : innerEndTasks) {
			List<Task> predecessors = probabilityAndTasks.getCurrentInnerEndTasks();
			double probability = probabilityAndTasks.getProbability();
			this.builder.connectAllWithProbability(successors, predecessors, probability);
		}
		
		return innerTasks;
	}
	
	private List<Task> repeatInnerLoopBehaviour(int numberOfRepetitions,
			ScenarioBehaviour bodyBehaviourLoop) {
		/* Copied from Rdseff2Taskmodel, do not change here, but there */
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
	public List<Task> caseUsageModel(UsageModel usageModel) {
		EList<UsageScenario> scenList = usageModel
				.getUsageScenario_UsageModel();
		
		Task startTask = this.builder.createTask(taskModel, "start task");
		List<Task> allTasks = new ArrayList<Task>();
		
//		for (UsageScenario us : scenList) {
//			allTasks.addAll(doSwitch(us));
//		}
		if (scenList.size() > 0){
			allTasks.addAll(doSwitch(scenList.get(0)));
		}
		
		if (scenList.size() > 1){
			logger.warn("Only one usage scenario supported so far, analysed just the first.");
		}
		

		this.builder.connectTaskWithSuccessors(startTask, allTasks);
		
		this.taskModel.setStartTask_TaskList(startTask);
		
		return null;
	}

	@Override
	public List<Task> caseUsageScenario(UsageScenario object) {
		doSwitch(object.getWorkload_UsageScenario());
		return doSwitch(object.getScenarioBehaviour_UsageScenario());

	}
	
	
	@Override
	public List<Task> caseAbstractUserAction(AbstractUserAction object) {
		return doSwitch(object.getSuccessor());
	}

	@Override
	public List<Task> caseEntryLevelSystemCall(EntryLevelSystemCall object) {
		
		contextWrapper = contextWrapper.getContextWrapperFor(object);

		RepositoryComponent offeringComponent = contextWrapper.getAssCtx()
				.getEncapsulatedComponent__AssemblyContext();
		
		List<Task> innerTasks = Collections.emptyList();

		if (offeringComponent instanceof BasicComponent) {
			ServiceEffectSpecification seff = contextWrapper.getNextSEFF(object);
			
			Rdseff2Taskmodel seffVisitor = new Rdseff2Taskmodel(contextWrapper, taskModel, builder, this.executionProbability);
			innerTasks = seffVisitor.doSwitch((ResourceDemandingSEFF) seff);
			
		} else {
			logger.error("Composite Component type not yet supported.");
			throw new UnsupportedOperationException();
		}
		
		// get last tasks of the inner task tree
		List<Task> danglingTasks = this.builder.collectDanglingTasks();

		List<Task> successors = doSwitch(object.getSuccessor());

		// and connect them with the successors of this task
		this.builder.connectAllWithRemainingProbability(danglingTasks, successors);
		
		return innerTasks;
	}

	@Override
	public List<Task> caseStop(Stop object) {
		return Collections.emptyList();
	}
	
	@Override
	public List<Task> caseScenarioBehaviour(ScenarioBehaviour object) {
		// start new list of dagnling tasks to be connected by this behaviour's successor.
		this.builder.openNewDanglingTaskList();
		return doSwitch(getStartAction(object));
	}

	private Start getStartAction(ScenarioBehaviour object) {
		Start startAction = (Start) EMFHelper.getObjectByType(object
				.getActions_ScenarioBehaviour(), Start.class);
		return startAction;
	}

}
