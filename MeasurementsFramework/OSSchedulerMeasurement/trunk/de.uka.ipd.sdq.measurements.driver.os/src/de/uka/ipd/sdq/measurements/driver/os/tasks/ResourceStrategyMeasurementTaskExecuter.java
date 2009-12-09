package de.uka.ipd.sdq.measurements.driver.os.tasks;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.MandelbrotDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.WaitDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand;
import de.uka.ipd.sdq.measurements.driver.common.tasks.AbstractTaskExecuter;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskFinishIndicator;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskResultStorage;
import de.uka.ipd.sdq.measurements.driver.os.PropertyManager;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiDemand;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResourceStrategyMeasurementTask;

public class ResourceStrategyMeasurementTaskExecuter extends AbstractTaskExecuter {

	protected IDemandStrategy theStrategy = null;
	protected long measurementTime = 0L;

	public ResourceStrategyMeasurementTaskExecuter(RmiResourceStrategyMeasurementTask task, int numberOfIterations, TaskFinishIndicator finishIndicator) {
		super(task, numberOfIterations, finishIndicator);
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
		case READ_FROM_HDD_DEMAND:
			if (measurementTime > Integer.MAX_VALUE) {
				measurementTime = Integer.MAX_VALUE;
			}
			URL url = ResourceStrategyMeasurementTaskExecuter.class.getProtectionDomain().getCodeSource().getLocation();
			theStrategy = new ReadLargeChunksDemand(url.getPath()+"temp/" + task.getId() + "/", numberOfIterations, (int)measurementTime);
			break;
		default:
			theStrategy = new FibonacciDemand();
			break;
		}
		
	}

	@Override
	protected void doWork(int iteration) {
		//System.out.println("RES STRAT " + task.getId()+ " Iter. " + iteration + " consuming " + measurementTime + "... TOTAL: " +  numberOfIterations);
		theStrategy.consume(measurementTime);
		//System.out.println("RES STRAT " + task.getId()+ " Iter. " + iteration + " consumed!");

	}

	@Override
	public boolean prepare() {
		String calibrationFilePath = PropertyManager.getInstance().getCalibrationFilePath();
		if ((calibrationFilePath != null) && (!calibrationFilePath.equals(""))) {
			Properties properties = new Properties();
			properties.setProperty("CalibrationPath", calibrationFilePath);
			theStrategy.setProperties(properties);
		}
		theStrategy.initializeStrategy(DegreeOfAccuracyEnum.HIGH, 1000);
		return true;
	}
	
	@Override
	public void storeResults() {
		TaskResultStorage.getInstance().storeTaskResult(task.getId(), getTaskResult());
	}
	
	@Override
	protected void signalizeFinish() {
		// Do nothing.
	}
	
	@Override
	protected void doCleanup() {
		theStrategy.cleanup();
		// Delete folder where the files have been stored in
		if (((RmiResourceStrategyMeasurementTask)task).getDemand().equals(RmiDemand.READ_FROM_HDD_DEMAND)) {
			URL url = ResourceStrategyMeasurementTaskExecuter.class.getProtectionDomain().getCodeSource().getLocation();
			File file = new File(url.getPath()+"temp/" + task.getId() + "/");
			file.delete();
		}
	}

}
