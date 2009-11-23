package de.uka.ipd.sdq.measurements.osscheduler.systemadapter;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.measurements.MachineDescription;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.tasks.TaskSet;


public class OSSchedulerSystemAdapter {
	
	private HostInterface hostInterface = null;
	
	private static Logger logger = Logger.getLogger(OSSchedulerSystemAdapter.class);
	
	private String machineIP = null;
	public String getMachineIP() {
		return machineIP;
	}

	private int machinePort = 0;
	public int getMachinePort() {
		return machinePort;
	}

	public OSSchedulerSystemAdapter(String ip, int port) {
		machineIP = ip;
		machinePort = port;
	}
	
	public boolean checkConnection() {
		// Do this every time for a connection check. Otherwise, a Host shutdown/restart is not noticed.
		initializeConnection();
		if (hostInterface == null) {
			return false;
		}
		try {
			hostInterface.ping();
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private RmiAbstractTask rmiTask = null;
	
	public boolean prepareExperiment(List<MachineDescription> machineDescriptions, TaskSet taskSet) {
		if (taskSet == null) {
			logger.error("No task set specified!");
			return false;
		}
		EmfTaskToRmiTaskConverter emfTaskToRmiTaskConverter = new EmfTaskToRmiTaskConverter(taskSet, machineDescriptions);
		if (taskSet.getRootTask() == null) {
			logger.error("No root task specified for task set!");
			return false;
		}
		rmiTask = emfTaskToRmiTaskConverter.convert(taskSet.getRootTask());
		if (rmiTask == null) {
			logger.error("Failed to convert task " + taskSet.getRootTask().getName());
			return false;
		}
		try {
			hostInterface.prepareTasks(rmiTask, false);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void initializeConnection() {
		hostInterface = RmiConnectionManager.getInstance().initializeHost(machineIP, machinePort, "Driver");
	}
	
	public boolean executeExperiment() {
		try {
			hostInterface.executeTasks();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public void cleanup() {
	}
}
