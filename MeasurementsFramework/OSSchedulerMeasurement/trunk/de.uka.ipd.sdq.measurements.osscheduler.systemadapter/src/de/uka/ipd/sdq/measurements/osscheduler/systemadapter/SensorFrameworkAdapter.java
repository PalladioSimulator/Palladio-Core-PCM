package de.uka.ipd.sdq.measurements.osscheduler.systemadapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResult;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public class SensorFrameworkAdapter {
	
	private static Logger logger = Logger
	.getLogger(SensorFrameworkAdapter.class);
	
	public static String experimentName = "OS Scheduler Measurements";
	
	public Experiment experiment = null;
	public ExperimentRun experimentRun = null;
	private IDAOFactory factory = null;
	private int dataSourceId = -1;
	
	
	public SensorFrameworkAdapter(int dataSourceId) {
		this.dataSourceId = dataSourceId;
		
	}
	
	private void initialize() {
		factory = SensorFrameworkDataset.singleton().getDataSourceByID(dataSourceId);
		if (factory == null) {
			logger.error("Cannot create specified data source!");
			factory = new MemoryDAOFactory(1);	
		}

		experiment = factory.createExperimentDAO()
				.addExperiment(experimentName);
		experimentRun = experiment.addExperimentRun("Benchmark Run "
				+ new Date().toString());
	}
	
	public void store(HashMap<Integer, ArrayList<RmiResult>> allResults) {
		initialize();
		logger.info("Storing!");
		Iterator<Integer> taskIds = allResults.keySet().iterator();
		while (taskIds.hasNext()) {
			int taskId = taskIds.next();
			storeTask(taskId, allResults.get(taskId));
		}
		finish();
	}
	
	private void storeTask(int taskId, List<RmiResult> results) {
		if ((results == null) || (results.size() == 0)) {
			return;
		}
		RmiAbstractTask task = results.get(0).getTask();
		TimeSpanSensor sensor = experiment.addTimeSpanSensor("Task " + task.getName() + " ["+ taskId + "]");
		for (int i = 0; i < results.size(); i++) {
			for (int j =0; j < results.get(i).getResults().length; j++) {
				experimentRun.addTimeSpanMeasurement(sensor, results.get(i).getResults()[j], results.get(i).getResults()[j]);

			}
		}
	}
	
	private void finish() {
		factory.finalizeAndClose();
	}

}
