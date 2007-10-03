/**
 * 
 */
package de.uka.ipd.sdq.prototype.framework;

import java.io.File;
import java.util.ArrayList;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * @author Snowball
 *
 */
public abstract class AbstractMain {
	public static de.uka.ipd.sdq.sensorframework.entities.Experiment exp = null;
	protected ArrayList<Thread> threads = new ArrayList<Thread>();
	private ExperimentRun expRun;

	protected void run(String[] args) {
		IDAOFactory datasource = prepareDatasource(args);
		exp = datasource.createExperimentDAO().addExperiment("test");
		expRun = exp.addExperimentRun(new java.util.Date().toString());

		TimeSpanSensor tss = exp.addTimeSpanSensor("Scenario overall defaultUsageScenario");

		System.out.println("Please pin java runtime to a single processor if needed! Press a key to continue!");
		waitForKeyPress();
		
		setupResources();
		initialiseThreads(expRun, tss);
		
		System.out.println("Starting workload threads. Request a measurement stop by pressing any key!");
		for (Thread t : threads) {
			t.start();
		}
		
		waitForKeyPress();
		
		stop();

		datasource.createExperimentDAO().store(exp);
		datasource.finalizeAndClose();
	}


	private void waitForKeyPress() {
		try {
			System.in.read();
			while (System.in.available() > 0) System.in.read();
		} catch (java.io.IOException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}
	}

	private void stop() {
		System.out.println("Request Thread stop");
		for (Thread t : threads) {
			((IStopable) t).requestStop();
		}
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}

	private static IDAOFactory prepareDatasource(String[] args) {
		if (args.length != 1 || !checkDirectory(args[0])) {
			System.out.println("Usage: Main <FileDataSourceFolder>");
			System.out.println("Ensure folder exists and is writeable");
			System.exit(-1);
		}
		IDAOFactory datasource = new FileDAOFactory(args[0]);
		return datasource;
	}

	private static boolean checkDirectory(String path) {
		File f = new File(path);
		if (!f.isDirectory())
			return false;
		return true;
	}

	protected abstract void setupResources();
	protected abstract void initialiseThreads(ExperimentRun expRun, TimeSpanSensor tss);
}
