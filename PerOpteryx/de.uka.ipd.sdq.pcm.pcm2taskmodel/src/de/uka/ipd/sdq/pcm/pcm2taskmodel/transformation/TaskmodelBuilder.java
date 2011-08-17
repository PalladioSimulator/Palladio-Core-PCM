package de.uka.ipd.sdq.pcm.pcm2taskmodel.transformation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import de.uka.ipd.sdq.pcm.reliability.FailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.taskmodel.Edge;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.TaskList;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelFactory;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;

public class TaskmodelBuilder {
	
	private taskmodelFactory factory = taskmodelFactory.eINSTANCE;
	
	/** Stack of previous dangling tasks, not containing the current danglingTasks list. 
	 * Should only be used by methods {@link #openNewDanglingTaskList()} and 
	 * {@link #restorePreviousDanglingTaskList()}. */
	private Deque<List<Task>> danglingTasksStack = new ArrayDeque<List<Task>>();
	
	/** Current list of dangling tasks, not contained in danglingTasksStack. */
	private List<Task> danglingTasks = new ArrayList<Task>();;
	
	/**
	 * If a new {@link ResourceDemandingBehaviour} is entered, a new
	 * list of danglingTasks has tpo be started to know which Tasks to connect
	 * after exiting the behaviour.
	 */
	public void openNewDanglingTaskList(){
		this.danglingTasksStack.push(this.danglingTasks);
		this.danglingTasks = new ArrayList<Task>();
	}
	
	/**
	 * Takes the last list of dangling tasks from the stack and 
	 * as the current list. If any tasks are left in the old list,
	 * they are added to the new one.
	 */
	private void restorePreviousDanglingTaskList(){
		
		List<Task> newList = this.danglingTasksStack.pop();
		newList.addAll(this.danglingTasks);
		
		this.danglingTasks = newList;

	}
	
	
	public Task createTask(TaskList taskmodel, String name){
		return createTask(1.0, taskmodel, name);
	}

	Task createTask(double d, TaskList taskmodel, String name) {
		Task task = factory.createTask();
		taskmodel.getTask_TaskList().add(task);
		
		task.setProbabilityOfExecution(d);
		task.setFailureProbability(0);
		task.setMeanDemandedTime(0);
		task.setName(name);
		
		// always add task to list of danglingTasks. Remove when adding enough edges.
		this.danglingTasks.add(task);
		
		return task;
	}

	public void createEdge(Task predecessor, Task successor, double d) {
		Edge edge = factory.createEdge();
		edge.setSuccessor_Edge(successor);
		edge.setTransitionProbability(d);
		
		predecessor.getEdge_Task().add(edge);
		
		// if task has edges that sum up to one, remove from dangling edges
		List<Edge> edges = predecessor.getEdge_Task();
		double probability = 0;
		for (Edge edge2 : edges) {
			probability += edge2.getTransitionProbability();
		}
		if (probability == 1){
			this.danglingTasks.remove(predecessor);
		}
		
	}
	
	public void createEdge(Task predecessor, Task successor) {
		createEdge(predecessor, successor, 1);
	}
	
	public List<Task> asList(Task task) {
		ArrayList<Task> list = new ArrayList<Task>(1);
		list.add(task);
		return list;
	}

	/**
	 * Connects the passed currentTask with all successors. The remaining probability is equally shared. 
	 * @param currentTask
	 * @param successors
	 */
	public void connectTaskWithSuccessors(Task currentTask,
			List<Task> successors) {
		if (successors != null){
			for (Task task : successors) {
				
				// only the remaining probability is assigned to the Edge
				double probability = 1;
				if (currentTask.getEdge_Task().size() > 0){
					for (Edge edge : currentTask.getEdge_Task()) {
						probability -= edge.getTransitionProbability();
					}
				}
				
				if (probability > 0){
					
					//FIXME this distinction is not enough if several tasks are predecessors of several other tasks (n:m).  
					/*if (successors.size() > 1){
					edge.setTransitionProbability(task.getProbabilityOfExecution() / currentTask.getProbabilityOfExecution());
					} else {**/
					this.createEdge(currentTask, task, probability);
				}
				
			}
		}
		
	}

	/**
	 * calls {@link #connectTaskWithSuccessors(Task, List)} for each innerTask.
	 * @param innerTasks
	 * @param successors
	 */
	public void connectAllWithRemainingProbability(
			List<Task> danglingTasks, List<Task> successors) {
		
		//List<Task> danglingTasks = this.collectDanglingTasks(innerTasks);
		
//		for (Task task : innerTasks) {
//			List<Task> danglingTasks = collectDanglingTasks(task);
			for (Task danglingTask : danglingTasks) {
				connectTaskWithSuccessors(danglingTask, successors);
			}
//			
//		}
		
	}


	public List<Task> collectDanglingTasks() {
		/*List<Task> result = new ArrayList<Task>();
		for (Task task : currentInnerTasks) {
			//result.addAll(collectDanglingTasks(task));
		}
		return result;*/
		List<Task> currentDanglingTask = this.danglingTasks;
		restorePreviousDanglingTaskList();
		return currentDanglingTask;
	}
	
	/**
	 * If one loop is empty, nothing happens.
	 * @param successors
	 * @param predecessors
	 * @param probability
	 */
	public void connectAllWithProbability(List<Task> successors,
			List<Task> predecessors, double probability) {
		for (Task predecessor : predecessors) {
			for (Task successor : successors) {
				this.createEdge(predecessor, successor, probability);
			}
		}
	}
	
	public double getFailureProbability(InternalAction object) {
		
		double failureProbability = 0;
		
		List<InternalFailureOccurrenceDescription> failures = object.getInternalFailureOccurrenceDescriptions__InternalAction();
		for (FailureOccurrenceDescription failureOccurrenceDescription : failures) {
			failureProbability += failureOccurrenceDescription.getFailureProbability();
		}
		return failureProbability;
	}
	
	public StartAction getStartAction(ResourceDemandingBehaviour behaviour) {
		StartAction startAction = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		return startAction;
	}

}
