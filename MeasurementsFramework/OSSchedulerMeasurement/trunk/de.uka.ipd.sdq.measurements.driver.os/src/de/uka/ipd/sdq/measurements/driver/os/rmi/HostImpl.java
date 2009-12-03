package de.uka.ipd.sdq.measurements.driver.os.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;

import de.uka.ipd.sdq.measurements.driver.common.Constants;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskListener;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskManager;
import de.uka.ipd.sdq.measurements.driver.os.ChildProcessManager;
import de.uka.ipd.sdq.measurements.driver.os.OSDriver;
import de.uka.ipd.sdq.measurements.driver.os.OSDriverHelper;
import de.uka.ipd.sdq.measurements.rmi.ExperimentResult;
import de.uka.ipd.sdq.measurements.rmi.SystemAdapterRmiInterface;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiDemand;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResult;

public class HostImpl implements HostInterface {

	public boolean shutdown() throws RemoteException {
		OSDriver.log("Shutting down...");
		return OSDriver.getInstance().shutdown();
	}

	public boolean lookupSystemAdapter(final String masterURL, final int port) throws RemoteException {
		SystemAdapterRmiInterface systemAdapterInterface = null;
		try {
			if (OSDriver.getLoggingDebugEnabled()) {
				OSDriver.logDebug("Looking up System Adapter on " + masterURL + ":" + port);
			}
			//masterInterface = Naming.lookup("rmi://" + masterURL + ":" + port + "/Master");
			Registry registry = LocateRegistry.getRegistry(masterURL, port);
			systemAdapterInterface = (SystemAdapterRmiInterface) registry.lookup(Constants.SystemAdapterRMIName);
			OSDriver.getInstance().setSystemAdapterRmiInterface(systemAdapterInterface);
		} catch (NotBoundException e) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError(e.getMessage());
			}
			return false;
		} catch (Exception e) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError(e.getMessage());
			}
		}
		return true;
	}
	

	public boolean prepareTasks(final RmiAbstractTask rootTask, final boolean autoStartExecution, final int numberOfIterations)
			throws RemoteException {
		// First, copy Host calibration files to Guests in case they do not have them available 
		//MidisHostHelper.storeHostCalibrationFiles(false);

		if (autoStartExecution == true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					TaskManager.getInstance().prepareTasks(rootTask, autoStartExecution, numberOfIterations);
				};
			}).start();
			return true;
		}
		return TaskManager.getInstance().prepareTasks(rootTask, autoStartExecution, numberOfIterations);
	}
	
	public boolean executeOneTaskExecution(final int rootTaskId) throws RemoteException {
		return executeTasks(rootTaskId, false);
	}

	public boolean executeTasks(final int rootTaskId) throws RemoteException {
		return executeTasks(rootTaskId, true);
	}
	
	private boolean executeTasks(final int rootTaskId, boolean performAllIterations) {
		if (OSDriver.IS_SUB_PROCESS) {
			TaskManager.getInstance().addTaskListener(new TaskListener() {

				public void taskCompleted(int taskId, int completedIterations) {
					if (rootTaskId == taskId) {
						try {
							OSDriver.getInstance().getParentHost().childTaskCompleted(taskId, completedIterations);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						TaskManager.getInstance().removeTaskListener(this);
					}
				}
				
			});
		} else {
			TaskManager.getInstance().addTaskListener(new TaskListener() {

				public void taskCompleted(int taskId, int completedIterations) {
					if (rootTaskId == taskId) {
						try {
							//OSDriver.getInstance().getSystemAdapterRmiInterface().experimentCompleted(TaskManager.getInstance().getResults(rootTaskId));
							OSDriver.getInstance().getSystemAdapterRmiInterface().experimentCompleted(ExperimentResult.SUCCESS, rootTaskId);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						TaskManager.getInstance().removeTaskListener(this);
					}
				}
				
			});
		}
		return TaskManager.getInstance().executeTasksAsync(rootTaskId, performAllIterations);
	}

	public long calibrate(final RmiDemand demand, int degreeOfAccuracy, boolean signalOnFinish, String masterURL,
			int masterPort) throws RemoteException {
		return OSDriverHelper.calibrate(demand, degreeOfAccuracy, signalOnFinish, masterURL, masterPort);
	}

	public String ping() throws RemoteException {
		return Constants.RmiPingResult;
	}

	/*public ArrayList<AbstractTaskResult> getTemporaryResults() throws RemoteException {
		return OSDriver.getInstance().getTemporaryResults();
	}*/

	public boolean updateJarFile(byte[] buffer) throws RemoteException {
		return OSDriverHelper.updateJarFile(buffer);
	}

	public void cleanup() throws RemoteException {
		TaskManager.getInstance().clearPreparedTasks();
		ChildProcessManager.getInstance().cleanupAllChildProcesses();
		Runtime r = Runtime.getRuntime();
		r.gc();
		
	}
	
	public HashMap<Integer, ArrayList<RmiResult>> getTaskResults(int taskId) throws RemoteException {
		return TaskManager.getInstance().getResults(taskId);
	}

	public void childTaskCompleted(int taskId, int completedIterations) {
		ChildProcessManager.getInstance().childTaskCompleted(taskId, completedIterations);
	}

}
