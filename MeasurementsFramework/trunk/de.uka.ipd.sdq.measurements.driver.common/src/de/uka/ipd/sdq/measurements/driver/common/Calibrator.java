package de.uka.ipd.sdq.measurements.driver.common;

import java.util.Properties;

import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.MandelbrotDemand;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiDemand;

public class Calibrator implements Runnable {
	
	private RmiDemand demand;
	private DegreeOfAccuracyEnum degreeOfAccuracy;
	private boolean signalOnFinish = false;
	private String masterURL;
	private int masterPort = 0;
	private long calibrationId = 0;
	private Properties properties = null;

	public Calibrator(long calibrationId, RmiDemand demand, int degreeOfAccuracy, Properties properties, boolean signalOnFinish, String masterURL, int masterPort) {
		this.calibrationId = calibrationId;
		this.demand = demand;
		this.signalOnFinish = signalOnFinish;
		this.masterURL = masterURL;
		this.masterPort = masterPort;
		this.properties = properties;
		switch (degreeOfAccuracy) {
		case Constants.DegreeOfAccuracyLow:
			this.degreeOfAccuracy = DegreeOfAccuracyEnum.LOW;
			break;
		case Constants.DegreeOfAccuracyMedium:
			this.degreeOfAccuracy = DegreeOfAccuracyEnum.MEDIUM;
			break;
		case Constants.DegreeOfAccuracyHigh:
			this.degreeOfAccuracy = DegreeOfAccuracyEnum.HIGH;
			break;
		default:
			this.degreeOfAccuracy = DegreeOfAccuracyEnum.MEDIUM;
			break;
		
		}
	}
	
	public void run() {
		IDemandStrategy theStrategy = null;
		switch (demand) {
		case FIBONACCI_DEMAND:
			theStrategy = new FibonacciDemand();
			break;
		case MANDELBROT_DEMAND:
			theStrategy = new MandelbrotDemand();
			break;
		default:
			theStrategy = new FibonacciDemand();
			break;
		}
		if (properties != null) {
			theStrategy.setProperties(properties);
		}
		theStrategy.initializeStrategy(degreeOfAccuracy, 1000);
		
		/*if (signalOnFinish){
			try {
				Registry registry = LocateRegistry.getRegistry(masterURL, masterPort);
				MasterInterface masterInterface = (MasterInterface) registry
						.lookup(Constants.WorkloadMasterRMIName);
				masterInterface.calibrationCompleted(calibrationId);
			} catch (NotBoundException e) {
				return;
			} catch(RemoteException e) {
				return;
			}
		}*/
		
	}

}
