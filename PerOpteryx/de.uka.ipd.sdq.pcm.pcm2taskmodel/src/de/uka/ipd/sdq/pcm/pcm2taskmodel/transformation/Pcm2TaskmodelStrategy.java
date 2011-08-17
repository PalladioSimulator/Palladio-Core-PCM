package de.uka.ipd.sdq.pcm.pcm2taskmodel.transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.dsexplore.helper.FixDesignDecisionReferenceSwitch;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.pcm2taskmodel.runconfig.PCM2TaskModelWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.taskmodel.Alternative;
import de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.TaskList;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelFactory;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.transformations.EMFHelper;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;

public class Pcm2TaskmodelStrategy implements SolverStrategy {
	
	TaskList taskModel = null;

	private PCM2TaskModelWorkflowRunConfiguration config;
	
	private static Logger logger = Logger.getLogger(Pcm2TaskmodelStrategy.class
			.getName());

	public Pcm2TaskmodelStrategy(PCM2TaskModelWorkflowRunConfiguration config, PCMInstance pcmInstance) {
		taskModel = taskmodelFactory.eINSTANCE.createTaskList();
		this.config = config;
		
		
	}
	
	private Problem loadProblem(String filename, PCMInstance pcmInstance) {
		EObject eproblem = EMFHelper.loadFromXMIFile(filename);
		if (!(eproblem instanceof Problem)){
			throw new RuntimeException(new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "Cannot read design decision file "+filename+". Please create a new one.", null)));
		}
		Problem problem = (Problem)eproblem;
		//Adjust references with the right loaded model objects in memory?

		FixDesignDecisionReferenceSwitch visitor = new FixDesignDecisionReferenceSwitch(pcmInstance);
		visitor.doSwitch(problem);
		
		return problem;
	}

	@Override
	public void loadTransformedModel(String fileName) {
	}

	@Override
	public void solve() {
		logger.warn("No solution available for task model");

	}

	@Override
	public void storeTransformedModel(String fileName) {
		EMFHelper.saveToXMIFile(taskModel, fileName);
	}

	@Override
	public void transform(PCMInstance pcmInstance) {
		
		Pcm2TaskmodelUsagemodelSwitch usageModelSwitch = new Pcm2TaskmodelUsagemodelSwitch(taskModel, new ContextWrapper(pcmInstance));
		
		usageModelSwitch.doSwitch(pcmInstance.getUsageModel());
		
		// determine alternatives
		Problem problem = this.loadProblem(this.config.getDesignDecisionFileName(), pcmInstance);
		
		for (DegreeOfFreedom dof : problem.getDesigndecision()) {
			if (dof instanceof AssembledComponentDegree){
				
				taskModel.getAlternative_TaskList().addAll(determineAlternativeComponents((AssembledComponentDegree)dof,pcmInstance));
				
				// TODO: multiply alternative task if there are several tasks with the same internal action in the original.
			}
		}
		
	}

	private List<Alternative> determineAlternativeComponents(
			AssembledComponentDegree dof, PCMInstance pcmInstance) {
		
		if (dof.getDomainOfEntities().size() > 1){

			List<Alternative> results = new ArrayList<Alternative>(dof.getDomainOfEntities().size());
			
			// find each tasks to create an alternative for
			AssemblyContext ac = (AssemblyContext)dof.getChangeableEntity();
			BasicComponent replaceableComp = null;
			if (ac.getEncapsulatedComponent__AssemblyContext() instanceof BasicComponent){
				replaceableComp = (BasicComponent)ac.getEncapsulatedComponent__AssemblyContext();
			} else {
				throw new RuntimeException("Can only handle BasicComponents as alternatives yet.");
			}
			
			List<Task> tasksToReplace = new ArrayList<Task>();
			for (Task task : taskModel.getTask_TaskList()) {
				//FIXME: does not work for inner composed components
				if (task.getRepositorycomponent() != null 
						&& task.getRepositorycomponent().getId().equals(replaceableComp.getId())){
					tasksToReplace.add(task);
				}
			}
			
			List<SignatureAndTasks> originalTasksWithSignatures = getSignaturesAndTasks(replaceableComp);
			
			// identify the task in the original task model
			Map<AlternativeTask, List<Task>> helperTaskToRealTask = new HashMap<AlternativeTask, List<Task>>();
			for (SignatureAndTasks signatureAndTasks : originalTasksWithSignatures) {
				List<AlternativeTask> helperTasks = signatureAndTasks.getTasks();
				for (int i = 0; i < helperTasks.size(); i++) {
					AlternativeTask helperTask = helperTasks.get(i);
					boolean found = false;
					for (Task originalTask : tasksToReplace) {
						if (helperTask.getName().equals(originalTask.getName())){
							List<Task> alreadyFoundTasks = helperTaskToRealTask.get(helperTask);
							if (alreadyFoundTasks == null){
								alreadyFoundTasks = new ArrayList<Task>();
								helperTaskToRealTask.put(helperTask, alreadyFoundTasks);
							}
							alreadyFoundTasks.add(originalTask);
							found = true;
							
						}
					}
					// check if a task has been found. If not, then this task is not called in the usage model and should be removed. 
					if (!found){
						helperTasks.set(i, null);
					}
				}
				
			}
			
			
			for (Entity entity : dof.getDomainOfEntities()) {
				
				// no alternative for the current component
				if (entity.getId().equals(replaceableComp.getId()))
					continue;
				
				if (entity instanceof BasicComponent){
					BasicComponent comp = (BasicComponent)entity;
				
					//FIXME: control flow in alternative task may change... Assume for now that it does not.
					//FIXME: maybe worse: parameters may change. Dependencies need to be solved again. And then merge models? Assume for now that parameters do not change. 

					//XXX: For now we assume that the components have the same 
					// control flow and the same parameters and the same internal actions,
					// so that we can just use the relative difference of resource demands
					// to calculate the task properties

					// sort tasks by signature / call

					// then, for each call, we have a list of tasks. 

					List<SignatureAndTasks> alternativeTasksWithSignatures = getSignaturesAndTasks(comp);
					
					if (originalTasksWithSignatures.size() != alternativeTasksWithSignatures.size()){
						// should not happen ;)
						throw new RuntimeException("Internal Error: Original tasks and alternative tasks do not have the same number of provided signatures. Contact developers.");
					}
					
					Alternative alternative = taskmodelFactory.eINSTANCE.createAlternative();
					
					for (int i = 0; i < alternativeTasksWithSignatures.size(); i++) {
						
						// internally, the order is the same
						SignatureAndTasks original = originalTasksWithSignatures.get(i);
						SignatureAndTasks replacement = alternativeTasksWithSignatures.get(i);
						
						fillTaskAndAddToAlternative(original, replacement, helperTaskToRealTask, comp, alternative);
						
					}
					results.add(alternative);
					
					
				} else {
					throw new RuntimeException("Can only handle BasicComponents as alternatives yet.");
				}
				
			}
			
			return results;
		} else 
			return null;
	}
	
	private void fillTaskAndAddToAlternative(SignatureAndTasks helperForOriginal,
			SignatureAndTasks replacement,
			Map<AlternativeTask, List<Task>> helperTaskToRealTask,
			BasicComponent alternativeComponent,
			Alternative alternative) {
		
		if (helperForOriginal.getTasks().size() != replacement.getTasks().size()){
			throw new RuntimeException("The task graphs of original and alternative are not equivalent. Different control flows are not yet supported, sorry.");
		}
		
		// the order of the tasks within each SignatureAndTasks is assumed to be the same, as it comes from the DetermineTaskSwitch visitor.
		// in the helperForOriginal list, there can be null values indicating that the task is not used and should be deleted. 
		//List<AlternativeTask> altTasksToDelete = new ArrayList<AlternativeTask>();
		for (int i = 0; i < replacement.getTasks().size(); i++) {
			
			AlternativeTask templateAlternativeTask = replacement.getTasks().get(i);
			AlternativeTask helperForOriginalTask = helperForOriginal.getTasks().get(i);
			
			if (helperForOriginalTask == null){
				//altTasksToDelete.add(alternativeTask);
				// alternative task is not added to Alternative. 
			} else {
			
				List<Task> originalTasks = helperTaskToRealTask.get(helperForOriginalTask);
				for (Task originalTask : originalTasks) {
					
					// copy the templateAlternativeTask as we may have to create several ones, one per original Task 
					AlternativeTask alternativeTask = taskmodelFactory.eINSTANCE.createAlternativeTask();
					alternativeTask.setFailureProbability(templateAlternativeTask.getFailureProbability());
					alternativeTask.setName(templateAlternativeTask.getName());
					alternativeTask.setAbstractaction(templateAlternativeTask.getAbstractaction());
					alternativeTask.setRepositorycomponent(templateAlternativeTask.getRepositorycomponent());

					alternativeTask.setRepositorycomponent(alternativeComponent);
					alternativeTask.setAllocationcontext(originalTask.getAllocationcontext());
					alternativeTask.setProbabilityOfExecution(originalTask.getProbabilityOfExecution());

					alternativeTask.setTask_AlternativeTask(originalTask);

					double originalDemand = getResourceDemand(originalTask.getAbstractaction());
					double alternativeDemand = getResourceDemand(alternativeTask.getAbstractaction());

					double dependencySolvedOldDemand = originalTask.getMeanDemandedTime(); 

					// Rule of three: originalDemand / dependencySolvedOldDemand = alternativeDemand / dependencySolvedAltDemand
					// we want dependencySolvedAltDemand, so take left part times alternativeDemand.
					alternativeTask.setMeanDemandedTime(dependencySolvedOldDemand / originalDemand * alternativeDemand);


					alternative.getAlternativetasks_Alternative().add(alternativeTask);
					
				}
			}
		}
		
	}

	private double getResourceDemand(AbstractAction action) {
		if (action instanceof InternalAction){
			InternalAction ia = (InternalAction)action;
			
			double demand = 0;
			for (ParametricResourceDemand prd : ia.getResourceDemand_Action()) {
				String spec = prd.getSpecification_ParametericResourceDemand().getSpecification();
				double d = Double.valueOf(spec);
				demand += d;
			}
			return demand;
			
		} else {
			throw new RuntimeException("Internal error: Alternative are only supported for internal actions. Contact developer.");
		}
	}

	/**
	 * 
	 * @param bc
	 * @return The list of {@link SignatureAndTasks}, sorted by signature id so that it can be traversed.
	 */
	public List<SignatureAndTasks> getSignaturesAndTasks(BasicComponent bc){
		List<ServiceEffectSpecification> seffs = bc.getServiceEffectSpecifications__BasicComponent();
		List<SignatureAndTasks> result = new ArrayList<SignatureAndTasks>(seffs.size());
		
		for (ServiceEffectSpecification seff : seffs) {
			SignatureAndTasks sat = new SignatureAndTasks(seff.getDescribedService__SEFF());
			
			DetermineTaskSwitch visitor = new DetermineTaskSwitch();
			List<AlternativeTask> tasks = visitor.doSwitch(seff);
			
			sat.setTasks(tasks);
			result.add(sat);
			
		}
		Collections.sort(result);
		return result;
	}


}

class SignatureAndTasks implements Comparable<SignatureAndTasks>{

	private Signature signature;
	private List<AlternativeTask> tasks;

	public SignatureAndTasks(Signature describedServiceSEFF) {
		this.signature = describedServiceSEFF;
	}

	public void setTasks(List<AlternativeTask> tasks) {
		this.tasks = tasks;
		
	}

	public Signature getSignature() {
		return signature;
	}

	public List<AlternativeTask> getTasks() {
		return tasks;
	}

	@Override
	public int compareTo(SignatureAndTasks o) {
		return this.signature.getId().compareTo(o.getSignature().getId());
	}
	
	
	
}