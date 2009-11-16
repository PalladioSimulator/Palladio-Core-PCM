package de.uka.ipd.sdq.measurements.driver.common.tasks;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiLoopTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiParallelTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiSequenceTask;

public class TaskManager {
	
	private static TaskManager instance = null;

	public static TaskManager getInstance() {
		if (instance == null) {
			instance = new TaskManager();
		}
		return instance;
	}

	private TaskManager() {
	}
	
	public AbstractTaskExecuter convertTask(RmiAbstractTask rmiTask, int numberOfTaskIterations) {
		/*if (rmiTask instanceof RmiMeasurementTask) {
			AbstractHostTaskExecuter measurementTaskExecuter = null;
			RmiMeasurementTask measurementTask = (RmiMeasurementTask) rmiTask;
			MidisHost.logDebug("Preparing measurement for machine " + measurementTask.getMachineIp() + ":" + measurementTask.getMachinePort());
			if ((measurementTask.getMachineIp().equals(PropertyManager.getInstance().getHostRmiIp())) && (measurementTask.getMachinePort() == PropertyManager.getInstance().getHostRmiPort())) {
				MidisHost.logDebug("Creating Host Task Executer!");
				measurementTaskExecuter = new MeasurementTaskExecuter(newExecuterId(), 
						measurementTask);
			} else {
				MidisHost.logDebug("Creating Guest Task Executer!");
				measurementTaskExecuter = new GuestTaskExecuterStub(newExecuterId(), 
						measurementTask);
			}
			return measurementTaskExecuter;
		} else if (rmiTask instanceof RmiHeavyLoadTask) {
			AbstractHostTaskExecuter heavyLoadTaskExecuter = null;
			RmiHeavyLoadTask heavyLoadTask = (RmiHeavyLoadTask) rmiTask;
			MidisHost.logDebug("Preparing heavy load for machine " + heavyLoadTask.getMachineIp() + ":" + heavyLoadTask.getMachinePort());
			if ((heavyLoadTask.getMachineIp().equals(PropertyManager.getInstance().getHostRmiIp())) && (heavyLoadTask.getMachinePort() == PropertyManager.getInstance().getHostRmiPort())) {
				heavyLoadTaskExecuter = new HeavyLoadTaskExecuter(newExecuterId(), heavyLoadTask);
			} else {
				heavyLoadTaskExecuter = new GuestTaskExecuterStub(newExecuterId(), 
						heavyLoadTask);
			}
			return heavyLoadTaskExecuter;
		} else*/ if (rmiTask instanceof RmiSequenceTask) {
			SequenceTaskExecuter sequenceTaskExecuter = new SequenceTaskExecuter((RmiSequenceTask)rmiTask, numberOfTaskIterations);
			return sequenceTaskExecuter;
		} else if (rmiTask instanceof RmiParallelTask) {
			ParallelTaskExecuter parallelTaskExecuter = new ParallelTaskExecuter((RmiParallelTask)rmiTask, numberOfTaskIterations);
			return parallelTaskExecuter;

		} else if (rmiTask instanceof RmiLoopTask) {
			LoopTaskExecuter loopTaskExecuter = new LoopTaskExecuter((RmiLoopTask)rmiTask, numberOfTaskIterations);
			return loopTaskExecuter;
		}
		return null;
	}

}
