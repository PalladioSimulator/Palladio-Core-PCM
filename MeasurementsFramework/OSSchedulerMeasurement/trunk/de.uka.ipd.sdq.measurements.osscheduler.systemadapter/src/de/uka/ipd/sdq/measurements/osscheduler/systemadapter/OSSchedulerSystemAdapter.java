package de.uka.ipd.sdq.measurements.osscheduler.systemadapter;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Status;

import de.uka.ipd.sdq.measurements.MachineDescription;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.rmi.RmiConnectionManager;
import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.rmi.RmiServer;
import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.rmi.SystemAdapterRmiImpl;
import de.uka.ipd.sdq.measurements.rmi.ExperimentResult;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResult;
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
		
	private RmiServer rmiServer = null;
	private final SystemAdapterRmiImpl rmiImpl = new SystemAdapterRmiImpl();
	private int currentlyRunningExperimentRootTaskId = -1;
	private ExperimentResult experimentResult = null;

	public OSSchedulerSystemAdapter(String ip, int port) {
		machineIP = ip;
		machinePort = port;
		rmiServer = new RmiServer();
		rmiServer.start(rmiImpl);
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
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "No task set specified!"));
			return false;
		}
		EmfTaskToRmiTaskConverter emfTaskToRmiTaskConverter = new EmfTaskToRmiTaskConverter(taskSet, machineDescriptions);
		if (taskSet.getRootTask() == null) {
			logger.error("No root task specified for task set!");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "No root task specified for task set!"));
			return false;
		}
		rmiTask = emfTaskToRmiTaskConverter.convert(taskSet.getRootTask());
		if (rmiTask == null) {
			logger.error("Failed to convert task " + taskSet.getRootTask().getName());
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to convert task " + taskSet.getRootTask().getName()));
			return false;
		}
		try {
			return hostInterface.prepareTasks(rmiTask, 1);
		} catch (RemoteException e) {
			logger.error("Failed to prepare task.");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to prepare task.", e));
			return false;
		}
	}
	
	public void initializeConnection() {
		hostInterface = RmiConnectionManager.getInstance().initializeHost(machineIP, machinePort, "Driver", rmiServer.getRmiIp(), rmiServer.getRmiPort());
	}
	
	public boolean executeExperiment(final int dataSourceId) {
		rmiImpl.addExperimentCompletedListener(new ExperimentCompletedListener() {
			public void experimentCompleted(ExperimentResult expResult, int rootTaskId) {
				synchronized(OSSchedulerSystemAdapter.this) {
					if (currentlyRunningExperimentRootTaskId == rootTaskId) {
						experimentResult = expResult;
						OSSchedulerSystemAdapter.this.notify();
						rmiImpl.removeExperimentCompletedListener(this);	
					}
				}
			}
		});
		try {
			hostInterface.executeTasks(rmiTask.getId(), 1);
		} catch (RemoteException e) {
			logger.error("Failed to execute experiment.");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to execute experiment.", e));
			return false;
		}
		synchronized(this) {
			try {
				currentlyRunningExperimentRootTaskId = rmiTask.getId();
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		if (experimentResult == null) {
			logger.error("Experiment finished, but no experiment result status available.");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Experiment finished, but now experiment result status available."));
			return false;
		}
		if (experimentResult.equals(ExperimentResult.FAILURE)) {
			logger.error("Executing experiment failed.");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Executing experiment failed."));
			return false;	
		}
		if (experimentResult.equals(ExperimentResult.SUCCESS)) {
			logger.info("Experiment finished, fetching results...");
		}
		HashMap<Integer, ArrayList<RmiResult>> experimentResults = null;
		try {
			experimentResults = hostInterface.getTaskResults();
		} catch (RemoteException e) {
			logger.error("Failed to get results for task " + currentlyRunningExperimentRootTaskId);
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to get results for task " + currentlyRunningExperimentRootTaskId, e));
			return false;
		}
		if (experimentResults == null) {
			logger.error("Failed to retrieve experiment results.");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to retrieve experiment results."));
			return false;
		}
		storeExperimentResults(experimentResults, dataSourceId);
		logger.info("Cleaning up...");
		try {
			hostInterface.cleanup();
		} catch (RemoteException e) {
			logger.error("Failed to cleanup for for task " + currentlyRunningExperimentRootTaskId);
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to cleanup for for task " + currentlyRunningExperimentRootTaskId, e));
		}
		return true;
	}

	public void cleanup() {
	}
		
	private void storeExperimentResults(HashMap<Integer, ArrayList<RmiResult>> allResults, int dataSourceId) {
		SensorFrameworkAdapter sensorFrameworkAdapter = new SensorFrameworkAdapter(dataSourceId);
		sensorFrameworkAdapter.store(allResults);
		
	}
}
