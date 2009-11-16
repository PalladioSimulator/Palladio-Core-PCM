package de.uka.ipd.sdq.measurements.driver.os.tasks;

import java.util.Properties;

import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.MandelbrotDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.WaitDemand;
import de.uka.ipd.sdq.measurements.driver.common.tasks.AbstractTaskExecuter;
import de.uka.ipd.sdq.measurements.driver.os.PropertyManager;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResourceStrategyMeasurementTask;

public class ResourceStrategyMeasurementTaskExecuter extends AbstractTaskExecuter {

	protected IDemandStrategy theStrategy = null;
	private long measurementTime = 0L;

	public ResourceStrategyMeasurementTaskExecuter(RmiResourceStrategyMeasurementTask task, int numberOfIterations) {
		super(task, numberOfIterations);
		measurementTime = task.getMeasurementTime();
		switch (task.getDemand()) {
		case FIBONACCI_DEMAND:
			theStrategy = new FibonacciDemand();
			break;
		case MANDELBROT_DEMAND:
			theStrategy = new MandelbrotDemand();
			break;
		case WAIT_DEMAND:
			theStrategy = new WaitDemand();
			break;
		default:
			theStrategy = new FibonacciDemand();
			break;
		}
		String calibrationFilePath = PropertyManager.getInstance().getCalibrationFilePath();
		if ((calibrationFilePath != null) && (!calibrationFilePath.equals(""))) {
			Properties properties = new Properties();
			properties.setProperty("CalibrationPath", calibrationFilePath);
			theStrategy.setProperties(properties);
		}
		theStrategy.initializeStrategy(DegreeOfAccuracyEnum.HIGH, 1000);
		
	}

	@Override
	protected void doWork(int iteration) {
		theStrategy.consume(measurementTime);

	}

	@Override
	protected void prepare(int iteration) {
		// Nothing to prepare here. Preparation has been done in Constructor.
	}

}
