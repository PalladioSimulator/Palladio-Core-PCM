package de.uka.ipd.sdq.measurements.systemcontroller;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.measurements.MeasurementScript;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;


public class SystemController {
	
	private HostInterface hostInterface = null;
	
	private static Logger logger = Logger.getLogger(SystemController.class);
	
	public SystemController() {
		System.out.println("SystemController!");
		hostInterface = RmiConnectionManager.getInstance().initializeHost("192.168.2.192", 2101, "Driver");
	}
	
	private RmiAbstractTask rmiTask = null;
	
	public void prepareScript(MeasurementScript script) {
		if ((script.getTaskSets() != null) && (script.getTaskSets().size() > 0)) {
			EmfTaskToRmiTaskConverter emfTaskToRmiTaskConverter = new EmfTaskToRmiTaskConverter(script.getTaskSets().get(0), script.getMachineDescriptions());
			rmiTask = emfTaskToRmiTaskConverter.convert(script.getTaskSets().get(0).getRootTask());
			try {
				hostInterface.prepareTasks(rmiTask, false);
				hostInterface.executeTasks();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void executeScript() {
		
	}

	public void cleanup() {
	}
}
