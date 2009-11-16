package de.uka.ipd.sdq.measurements.driver.os.tasks;

import de.uka.ipd.sdq.measurements.driver.common.tasks.AbstractTaskExecuter;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskExecuterFactoryInterface;
import de.uka.ipd.sdq.measurements.driver.os.OSDriver;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResourceStrategyMeasurementTask;

public class OSDriverTaskExecuterFactory implements TaskExecuterFactoryInterface {

	public OSDriverTaskExecuterFactory() {
	}

	public AbstractTaskExecuter convertTask(RmiAbstractTask rmiTask, int numberOfTaskIterations) {
		if (rmiTask instanceof RmiResourceStrategyMeasurementTask) {
			RmiResourceStrategyMeasurementTask measurementTask = (RmiResourceStrategyMeasurementTask) rmiTask;
			OSDriver.logDebug("Preparing measurement for machine " + measurementTask.getMachineIp() + ":" + measurementTask.getMachinePort());
			ResourceStrategyMeasurementTaskExecuter measurementTaskExecuter = new ResourceStrategyMeasurementTaskExecuter(measurementTask,
					numberOfTaskIterations);
			return measurementTaskExecuter;
		}
		return null;
	}

}
