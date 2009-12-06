package de.uka.ipd.sdq.measurements.driver.os.tasks;

import de.uka.ipd.sdq.measurements.driver.common.tasks.AbstractTaskExecuter;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskExecuterFactoryInterface;
import de.uka.ipd.sdq.measurements.driver.os.OSDriver;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiParallelProcessTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResourceStrategyMeasurementTask;

public class OSDriverTaskExecuterFactory implements TaskExecuterFactoryInterface {

	public OSDriverTaskExecuterFactory() {
	}

	public AbstractTaskExecuter convertTask(RmiAbstractTask rmiTask, int numberOfTaskIterations) {
		if (rmiTask.getClass().equals(RmiResourceStrategyMeasurementTask.class)) {
			RmiResourceStrategyMeasurementTask measurementTask = (RmiResourceStrategyMeasurementTask) rmiTask;
			OSDriver.logDebug("Preparing measurement for machine " + measurementTask.getMachineIp() + ":" + measurementTask.getMachinePort());
			ResourceStrategyMeasurementTaskExecuter measurementTaskExecuter = new ResourceStrategyMeasurementTaskExecuter(measurementTask,
					numberOfTaskIterations);
			measurementTaskExecuter.prepare();
			return measurementTaskExecuter;
		} else if (rmiTask.getClass().equals(RmiParallelProcessTask.class)) {
			RmiParallelProcessTask parallelProcessTask = (RmiParallelProcessTask) rmiTask;
			OSDriver.logDebug("Preparing parallel process task");
			ParallelProcessTaskExecuter parallelProcessTaskExecuter = new ParallelProcessTaskExecuter(parallelProcessTask, numberOfTaskIterations);
			parallelProcessTaskExecuter.prepare();
			return parallelProcessTaskExecuter;
		}
		return null;
	}

}
