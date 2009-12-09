package de.uka.ipd.sdq.measurements.driver.os.tasks;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskFinishIndicator;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResourceStrategyMeasurementTask;

public class ResourceStrategyMeasurementAfterIoTaskExecuter extends ResourceStrategyMeasurementTaskExecuter {

	public ResourceStrategyMeasurementAfterIoTaskExecuter(RmiResourceStrategyMeasurementTask task, int numberOfIterations, TaskFinishIndicator finishIndicator) {
		super(task, numberOfIterations, finishIndicator);

	}
	
	private InetAddress pingHost = null;
	private int pingPort = 80;
	
	@Override
	public boolean prepare() {
		
		// Test if IO succeeds
		try {
			pingHost = InetAddress.getByName(((RmiResourceStrategyMeasurementTask)task).getMachineIp());
		} catch (UnknownHostException e) {
			DriverLogger.logError("Failed to prepare I/O access. Cannot resolve host.", e);
			return false;
		}
		pingPort = ((RmiResourceStrategyMeasurementTask)task).getMachinePort();
		try {
			Socket socket = new Socket ( pingHost, pingPort );
			socket.close();
		} catch(IOException e) {
			DriverLogger.logError("Failed to prepare I/O access. Cannot ping host on " + pingHost.getHostAddress() + ":" + pingPort, e);
			return false;
		}
		
		return super.prepare();
	}
	
	@Override
	protected void work(int iterationsToRun) {
		/*if (doMeasuring) {
			startSystemTime = System.currentTimeMillis();
			startSystemNanoTime = System.nanoTime();
		}*/
		int numberOfExecutedIterations=0;
		for (int i=numberOfExecutedTasks; i<(numberOfExecutedTasks+iterationsToRun); i++) {
			
			try {
				Socket socket = new Socket ( pingHost, pingPort );
				socket.close();
			} catch(IOException e) {
				if (DriverLogger.LOGGING) {
					DriverLogger.logError("Failed to do I/O!", e);
				}
			}
						
			if (doMeasuring) {
				startTimes[i] = System.nanoTime();
			}
			theStrategy.consume(measurementTime);
			//doWork(i);
			if (doMeasuring) {
				endTimes[i] = System.nanoTime();
			}
			numberOfExecutedIterations++;
			//if (finishSignal == true) {
			if ((finishIndicator != null) && (finishIndicator.getFinishSignal())) {
				signalizeFinish();
				break;
			}
		}
		numberOfExecutedTasks += numberOfExecutedIterations;
	}

}
