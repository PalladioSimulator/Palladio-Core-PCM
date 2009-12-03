package de.uka.ipd.sdq.measurements.driver.common.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResult;

public class TaskResultStorage {
	
	private static TaskResultStorage instance;
	private TaskResultStorage() {
		allResults = new HashMap<Integer, ArrayList<RmiResult>>();
	}
	
	public static TaskResultStorage getInstance() {
		if (instance == null) {
			instance = new TaskResultStorage();
		}
		return instance;
	}
	
	HashMap<Integer, ArrayList<RmiResult>> allResults;
	
	public void storeTaskResult(int taskId, RmiResult taskResult) {
		if (taskResult == null) {
			return;
		}
		if (allResults.get(taskId) == null) {
			allResults.put(taskId, new ArrayList<RmiResult>());
		}
		allResults.get(taskId).add(taskResult);
	}
	
	public HashMap<Integer, ArrayList<RmiResult>> getAllResults() {
		return allResults;
	}

	public void storeResults(HashMap<Integer, ArrayList<RmiResult>> taskResultsFromChildProcess) {
		if (taskResultsFromChildProcess == null) {
			return;
		}
		for (Entry<Integer, ArrayList<RmiResult>> entry : taskResultsFromChildProcess.entrySet()) {
			if (allResults.get(entry.getKey()) == null) {
				allResults.put(entry.getKey(), entry.getValue());
			} else {
				allResults.get(entry.getKey()).addAll(entry.getValue());
			}
		}
	}
	

}
