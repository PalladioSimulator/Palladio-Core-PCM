package de.uka.ipd.sdq.measurements.driver.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiDemand;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResult;

/**
 * This interface has to be provided via RMI by the host. It is used by the
 * Master only.
 * 
 * @author hauck
 * 
 */
public interface HostInterface extends Remote {

	/**
	 * Shut down the Host driver. This should recursively lead to shut down the
	 * Guest drivers.
	 * 
	 * @return true if Host driver and Guest drivers have been shut down
	 *         successfully.
	 * @throws RemoteException
	 */
	boolean shutdown() throws RemoteException;

	/**
	 * 
	 * Let the Host perform an RMI lookup for the System Adapter's RMI port
	 * 
	 * @param masterURL
	 *            the URL of the System Adapter
	 * @param port
	 *            the RMI port of the System Adapter
	 * @return
	 * @throws RemoteException
	 */
	boolean lookupSystemAdapter(String systemAdapterURL, int port) throws RemoteException;
	
	
	/**
	 * Let the Host initialize an RMI connection to a Guest.
	 * 
	 * @param guestIP
	 *            the ip of the Guest
	 * @param guestPort
	 *            the RMI port of the Guest
	 * @param guestName
	 *            the RMI name of the Guest's RMI services
	 * @param lookupHost
	 *            denotes if an inverse RMI connection between Guest and Host
	 *            has to be established. Such an connection requires the Host to
	 *            know its internal IP address.
	 * @return true if the RMI connection has been initialized successfully.
	 * @throws RemoteException
	 */
	//boolean initializeGuest(String guestIP, int guestPort, String guestName) throws RemoteException;

	/**
	 * Make all necessary task preparation.
	 * 
	 * @param rootTask
	 *            the root task that contains all other tasks.
	 * @param autostartExecution true if the prepared tasks should be executed
	 * directly afterwards. In this case, the method returns true, but the 
	 * preparation (and execution) goes on. 
	 * @return true if the preparation succeeded.
	 * @throws RemoteException
	 */
	boolean prepareTasks(RmiAbstractTask rootTask, boolean autostartExecution, int numberOfIterations) throws RemoteException;

	/**
	 * Initiate the task execution on the host. The host will call all guests to
	 * start task execution. If the task has multiple iterations, all iterations are executed.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	boolean executeTasks(int taskId) throws RemoteException;
	
	/**
	 * Initiate the task execution on the host. The host will call all guests to
	 * start task execution. If the task has multiple iterations, only one iteration is executed.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public boolean executeOneTaskExecution(final int rootTaskId) throws RemoteException;

	/**
	 * Performs a calibration on the Host. This method does only have to be
	 * called if no tasks are to be conducted on the Host.
	 * 
	 * @param demand
	 *            the demand kind to be calibrated
	 * @param degreeOfAccuracy
	 *            the degree of accuracy (low, medium, high)
	 * @param signalOnFinish
	 *            true if Host should call the Master after calibration is
	 *            finished
	 * @param masterURL
	 * @param port
	 * 
	 * @return the id of the calibration task
	 * @throws RemoteException
	 * 
	 */
	long calibrate(RmiDemand demand, int degreeOfAccuracy,
			boolean signalOnFinish, String masterURL, int masterPort)
			throws RemoteException;

	public String ping() throws RemoteException;

	/**
	 * Returns results that have been stored temporarily. If no results have
	 * been stored, null is being returned.
	 * 
	 * @return the temporarily stored results
	 * @throws RemoteException
	 */
	//public ArrayList<AbstractTaskResult> getTemporaryResults()
	//		throws RemoteException;

	/**
	 * Deploy a new Host jar file on the host.
	 * 
	 */
	boolean updateJarFile(byte[] buffer) throws RemoteException;

	
	/**
	 * Cleanup Host, e.g. clear all prepared tasks and call cleanup() on
	 * all Guests.
	 * 
	 * @throws RemoteException
	 */
	void cleanup() throws RemoteException;

	/**
	 * Called by a child process if a child task is completed.
	 * @param taskId
	 * @param completedIterations
	 */
	void childTaskCompleted(int taskId, int completedIterations) throws RemoteException;

	HashMap<Integer, ArrayList<RmiResult>> getTaskResults() throws RemoteException;

	void finishTask(int taskId) throws RemoteException;
}
