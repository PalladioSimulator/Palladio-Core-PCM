package de.uka.ipd.sdq.measurements.driver.os.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import de.uka.ipd.sdq.measurements.driver.common.Constants;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.driver.os.MidisHostHelper;
import de.uka.ipd.sdq.measurements.driver.os.OSDriver;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiDemand;

public class HostImpl implements HostInterface {

	public boolean shutdown() throws RemoteException {
		OSDriver.log("Shutting down...");
		return OSDriver.getInstance().shutdown();
	}

	public boolean lookupMaster(String masterURL, int port) throws RemoteException {
		/*MasterInterface masterInterface = null;
		try {
			if (OSDriver.getLoggingDebugEnabled()) {
				OSDriver.logDebug("Looking up Master on " + masterURL + ":" + port);
			}
			//masterInterface = Naming.lookup("rmi://" + masterURL + ":" + port + "/Master");
			Registry registry = LocateRegistry.getRegistry(masterURL, port);
			masterInterface = (MasterInterface) registry.lookup(Constants.SystemControllerRMIName);
			OSDriver.getInstance().setMaster(masterInterface);
		} catch (NotBoundException e) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError(e.getMessage());
			}
			return false;
		} catch (Exception e) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError(e.getMessage());
			}
		}*/
		return true;
	}

	public boolean prepareTasks(final RmiAbstractTask rootTask, final boolean autoStartExecution)
			throws RemoteException {
		// First, copy Host calibration files to Guests in case they do not have them available 
		//MidisHostHelper.storeHostCalibrationFiles(false);

		/*if (autoStartExecution == true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					TaskManager.getInstance().prepareTasks(rootTask, autoStartExecution);
				};
			}).start();
			return true;
		}
		return TaskManager.getInstance().prepareTasks(rootTask, autoStartExecution);*/
		return true;
	}

	public boolean executeTasks() throws RemoteException {
		return true;
		//return TaskManager.getInstance().executeTasks();
	}

	public long calibrate(final RmiDemand demand, int degreeOfAccuracy, boolean signalOnFinish, String masterURL,
			int masterPort) throws RemoteException {
		return MidisHostHelper.calibrate(demand, degreeOfAccuracy, signalOnFinish, masterURL, masterPort);
	}

	public String ping() throws RemoteException {
		return Constants.RmiPingResult;
	}

	/*public ArrayList<AbstractTaskResult> getTemporaryResults() throws RemoteException {
		return OSDriver.getInstance().getTemporaryResults();
	}*/

	public boolean updateJarFile(byte[] buffer) throws RemoteException {
		return MidisHostHelper.updateJarFile(buffer);
	}

	public void cleanup() throws RemoteException {
		//TaskManager.getInstance().clearPreparedTasks();
		Runtime r = Runtime.getRuntime();
		r.gc();
	}

}
