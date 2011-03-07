package de.uka.ipd.sdq.pcm.pcm2taskmodel.transformation;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.taskmodel.Edge;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.TaskList;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelFactory;

public class TaskmodelBuilder {
	
	private static taskmodelFactory factory = taskmodelFactory.eINSTANCE;
	
	public static Task createTask(TaskList taskmodel){
		return createTask(1.0, taskmodel);
	}

	static Task createTask(double d, TaskList taskmodel) {
		Task task = factory.createTask();
		taskmodel.getTask_TaskList().add(task);
		
		task.setProbabilityOfExecution(d);
		task.setFailureProbability(0);
		task.setMeanDemandedTime(0);
		
		return task;
	}

	public static Edge createEdge(Task successor, double d) {
		Edge edge = factory.createEdge();
		edge.setSuccessor_Edge(successor);
		edge.setTransitionProbability(d);
		return edge;
	}
	
	public static Edge createEdge(Task successor) {
		return createEdge(successor, 1);
	}
	
	public static List<Task> asList(Task task) {
		ArrayList<Task> list = new ArrayList<Task>(1);
		list.add(task);
		return list;
	}

	public static void connectTaskWithSuccessors(Task currentTask,
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
					Edge edge = TaskmodelBuilder.createEdge(task);
					//FIXME this distinction is not enough if several tasks are predecessors of several other tasks (n:m).  
					/*if (successors.size() > 1){
					edge.setTransitionProbability(task.getProbabilityOfExecution() / currentTask.getProbabilityOfExecution());
					} else {**/
					edge.setTransitionProbability(probability);
					//}
					currentTask.getEdge_Task().add(edge);
				}
			}
		}
		
	}

	public static void connectAllDanglingInnerTasksWithSuccessors(
			List<Task> innerTasks, List<Task> successors) {
		
		for (Task task : innerTasks) {
			List<Task> danglingTasks = collectDanglingTasks(task);
			for (Task danglingTask : danglingTasks) {
				connectTaskWithSuccessors(danglingTask, successors);
			}
			
		}
		
	}

	/**
	 * Find all tasks that have Edges with less than probability 1
	 * @param task
	 * @return
	 */
	public static List<Task> collectDanglingTasks(Task task) {
		
		ArrayList<Task> result;
		if (task.getEdge_Task().size() == 0){
			result = new ArrayList<Task>(1);
			result.add(task);

		} else {
			result = new ArrayList<Task>(task.getEdge_Task().size()+1);
			double probability = 0;
			for (Edge edge : task.getEdge_Task()) {
				result.addAll(collectDanglingTasks(edge.getSuccessor_Edge()));
				probability += edge.getTransitionProbability();
			}
			if (probability < 1){
				result.add(task);
			}
		}
		return result;
		
	}

	public static List<Task> collectDanglingTasks(List<Task> currentInnerTasks) {
		List<Task> result = new ArrayList<Task>();
		for (Task task : currentInnerTasks) {
			result.addAll(collectDanglingTasks(task));
		}
		return result;
	}
	
	/**
	 * If one loop is empty, nothing happens.
	 * @param successors
	 * @param predecessors
	 * @param probability
	 */
	public static void connectAllWithProbability(List<Task> successors,
			List<Task> predecessors, double probability) {
		for (Task predecessor : predecessors) {
			for (Task successor : successors) {
				predecessor.getEdge_Task().add(TaskmodelBuilder.createEdge(successor, probability));
			}
		}
	}
	
	

}
