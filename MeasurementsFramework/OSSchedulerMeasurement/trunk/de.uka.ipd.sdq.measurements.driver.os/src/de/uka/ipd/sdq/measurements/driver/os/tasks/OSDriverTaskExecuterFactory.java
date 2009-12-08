package de.uka.ipd.sdq.measurements.driver.os.tasks;

import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.driver.common.tasks.AbstractTaskExecuter;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskFinishIndicator;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskExecuterFactoryInterface;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiParallelProcessTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResourceStrategyMeasurementTask;

public class OSDriverTaskExecuterFactory implements TaskExecuterFactoryInterface {

	public OSDriverTaskExecuterFactory() {
	}

	public AbstractTaskExecuter convertTask(RmiAbstractTask rmiTask, int numberOfTaskIterations, TaskFinishIndicator finishIndicator) {
		if (rmiTask.getClass().equals(RmiResourceStrategyMeasurementTask.class)) {
			RmiResourceStrategyMeasurementTask measurementTask = (RmiResourceStrategyMeasurementTask) rmiTask;
			DriverLogger.logDebug("Preparing measurement for machine " + measurementTask.getMachineIp() + ":" + measurementTask.getMachinePort());
			ResourceStrategyMeasurementTaskExecuter measurementTaskExecuter = new ResourceStrategyMeasurementTaskExecuter(measurementTask,
					numberOfTaskIterations, finishIndicator);
			measurementTaskExecuter.prepare();
			return measurementTaskExecuter;
		} else if (rmiTask.getClass().equals(RmiParallelProcessTask.class)) {
			RmiParallelProcessTask parallelProcessTask = (RmiParallelProcessTask) rmiTask;
			DriverLogger.logDebug("Preparing parallel process task");
			ParallelProcessTaskExecuter parallelProcessTaskExecuter = new ParallelProcessTaskExecuter(parallelProcessTask, numberOfTaskIterations, finishIndicator);
			parallelProcessTaskExecuter.prepare();
			return parallelProcessTaskExecuter;
		}
		return null;
	}

}
