package de.uka.ipd.sdq.measurements.driver.os;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import de.uka.ipd.sdq.measurements.driver.common.Constants;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskListener;
import de.uka.ipd.sdq.measurements.driver.os.rmi.RmiClient;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiAbstractTask;
import de.uka.ipd.sdq.measurements.rmi.tasks.RmiResult;


public class ChildProcessManager {
	
	private static ChildProcessManager instance = null;
	public static final int MAX_NUMBER_OF_CHILD_PROCESSES = 10;
	private HostInterface[] childRmiInterfaces;

	public static ChildProcessManager getInstance() {
		if (instance == null) {
			instance = new ChildProcessManager();
		}
		return instance;
	}
	
	private List<ChildProcess> runningProcesses;
	
	private ChildProcessManager() {
		runningProcesses = new ArrayList<ChildProcess>();
		childRmiInterfaces = new HostInterface[MAX_NUMBER_OF_CHILD_PROCESSES];
		
	}
		
	private boolean startChildProcess() {
		String hostUrl = PropertyManager.getInstance().getHostRmiIp();
		int rmiPort = PropertyManager.getInstance().getDriverRmiPort();
		int newRmiPort = rmiPort + 1;
		List<String> processArguments = new ArrayList<String>();
		processArguments.add("java");
		processArguments.add("-ea");
		processArguments.add("-Xms40m");
		processArguments.add("-Xmx512m");
		processArguments.add("-cp");
		processArguments.add("osdriver.jar");
		processArguments.add("-Djava.security.policy=host.policy");
		processArguments.add("-Dosdriver.properties=osdriver.properties");
		processArguments.add("-D" + OSDriverConstants.JavaPropertyOSDriverRmiParentHostIP + "="+hostUrl);
		processArguments.add("-D" + OSDriverConstants.JavaPropertyOSDriverRmiParentHostPort + "="+rmiPort);
		processArguments.add("-D" + OSDriverConstants.JavaPropertyOSDriverRmiIP + "="+hostUrl);
		processArguments.add("-D" + OSDriverConstants.JavaPropertyOSDriverRmiPort + "="+newRmiPort);
		processArguments.add("StartHost");
		processArguments.add("-subprocess");
		for (String s : processArguments) {
			System.out.print(s + " ");
		}
		System.out.println();
		try {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.log("Starting child process on " + hostUrl + ":" + newRmiPort);
			}
			ProcessBuilder processBuilder = new ProcessBuilder(processArguments);
			Process process = processBuilder.start();
			
			runningProcesses.add(new ChildProcess(process, hostUrl, newRmiPort));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	/**
	 * Prepare a task on a running child process. If the child process is not running, a new child process is started.
	 * @param childProcessNumber the number of the child process. 0 <= childProcessNumber < MAX_NUMBER_OF_CHILD_PROCESSES
	 * @param rootTask
	 * @return
	 */
	public boolean prepareTask(int childProcessNumber, RmiAbstractTask rootTask, int numberOfIterations) {
		if ((childProcessNumber < 0) || (childProcessNumber >= MAX_NUMBER_OF_CHILD_PROCESSES)) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError("Cannot prepare task for child process " + childProcessNumber + ". Only " + MAX_NUMBER_OF_CHILD_PROCESSES + " child processes are allowed.");
			}
			return false;
		}
		ChildProcess process = getChildProcess(childProcessNumber);
		
		if (process == null) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError("Child process " + childProcessNumber + " is null!");
			}
			return false;
		}
		OSDriver.log("Checking if process " + childProcessNumber + " is running...");
		if (!process.isProcessRunning()) {
			runningProcesses.remove(process);
		}
		process = getChildProcess(childProcessNumber);
		if (process == null) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError("Child process " + childProcessNumber + " is null!");
			}
			return false;
		}
		// try to reach child process.
		int NUMBER_OF_TRIES = 10;
		HostInterface host = null;
		for (int i=0; i<NUMBER_OF_TRIES; i++) {
			host = RmiClient.getChildHost(process.getRmiIp(), process.getRmiPort());
			if (host != null) {
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
		String pingResult = null;
		if (host != null) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.log("Trying to ping child process " + childProcessNumber + " on " + process.getRmiIp() + ":" + process.getRmiPort() + "...");
			}
			try {
				pingResult = host.ping();
				if (pingResult != null) {
					if (!pingResult.equals(Constants.RmiPingResult)) {
						pingResult = null;
					}
				}
			} catch (RemoteException e) {
				pingResult = null;
			}
			if (pingResult == null) {
				if (OSDriver.getLoggingEnabled()) {
					OSDriver.log("Pinging child process " + childProcessNumber + " on " + process.getRmiIp() + ":" + process.getRmiPort() + " failed.");
				}
				host = null;
			}
			
		}
		
		if (host == null) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError("Failed to reach child process " + childProcessNumber + " on " + process.getRmiIp() + ":" + process.getRmiPort());
			}
			return false;
		}
		childRmiInterfaces[childProcessNumber] = host;
		try {
			return host.prepareTasks(rootTask, false, numberOfIterations);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void cleanupAllChildProcesses() {
		for (int i=0; i<childRmiInterfaces.length; i++) {
			if (childRmiInterfaces[i] != null) {
				try {
					childRmiInterfaces[i].cleanup();
				} catch (RemoteException e) {
					//TODO
					e.printStackTrace();
				}
			}
		}
	}
	
	private ChildProcess getChildProcess(int childProcessNumber) {
		while (runningProcesses.get(childProcessNumber) == null) {
			if (!startChildProcess()) {
				if (OSDriver.getLoggingEnabled()) {
					OSDriver.logError("Failed to start child process.");
				}
				return null;
			}
		}
		return runningProcesses.get(childProcessNumber);
	}
	
	
	public void executeTask(int taskId, int childProcessNumber, int iteration) {
		if ((childProcessNumber < 0) || (childProcessNumber >= MAX_NUMBER_OF_CHILD_PROCESSES)) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError("Cannot execute task for child process " + childProcessNumber + ". Only " + MAX_NUMBER_OF_CHILD_PROCESSES + " child processes are allowed.");
			}
			return;
		}
		if (childRmiInterfaces[childProcessNumber] == null) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError("RMI interface for child process " + childProcessNumber + " is not set.");
			}
			return;
		}
		try {
			childProcesses.put(taskId, childProcessNumber);
			childRmiInterfaces[childProcessNumber].executeOneTaskExecution(taskId);
		} catch (RemoteException e) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError("Failed to execute task " + taskId + " on child process via RMI.");
			}
		}
		
	}
	
	private HashMap<Integer, Integer> childProcesses;
	
	private int getChildProcessNumber(int taskId) {
		return childProcesses.get(taskId);
	}
	
	public HashMap<Integer, ArrayList<RmiResult>> getTaskResultsFromChildProcess(int taskId) throws RemoteException {
		int number = getChildProcessNumber(taskId);
		if (childRmiInterfaces.length > number) {
			return childRmiInterfaces[number].getTaskResults(taskId);
		}
		return new HashMap<Integer, ArrayList<RmiResult>>();
	}

	public void childTaskCompleted(int taskId, int completedIterations) {
		fireTaskCompleted(taskId, completedIterations, getChildProcessNumber(taskId));
	}
	
	
	
	
	//
	// Event handling
	//

	private transient Vector<TaskListener>[] taskListeners;

	/** Register a listener for MasterModel events */
	synchronized public void addTaskListener(TaskListener listener, int childProcessNumber) {
		if ((childProcessNumber < 0) || (childProcessNumber >= taskListeners.length)) {
			return;
		}
		if (taskListeners[childProcessNumber] == null) {
			taskListeners[childProcessNumber] = new Vector<TaskListener>();
		}
		taskListeners[childProcessNumber].addElement(listener);
	}

	synchronized public void removeTaskListener(TaskListener listener, int childProcessNumber) {
		if ((childProcessNumber < 0) || (childProcessNumber >= taskListeners.length)) {
			return;
		}
		if (taskListeners[childProcessNumber] == null) {
			taskListeners[childProcessNumber] = new Vector<TaskListener>();
		}
		taskListeners[childProcessNumber].removeElement(listener);
	}

	/** Fire to all registered listeners */
	@SuppressWarnings("unchecked")
	protected void fireTaskCompleted(int taskId, int completedIterations, int childProcessNumber) {
		// If we have no listeners, do nothing.
		if ((taskListeners[childProcessNumber] != null) && !taskListeners[childProcessNumber].isEmpty()) {

			// Make a copy of the listener list in case anyone adds or removes
			// listeners.
			Vector<TaskListener> targets;
			synchronized (taskListeners) {
				targets = (Vector<TaskListener>) taskListeners[childProcessNumber].clone();
			}

			// Walk through the listener list and call the listener method in
			// each.
			Enumeration<TaskListener> e = targets.elements();
			while (e.hasMoreElements()) {
				TaskListener l = (TaskListener) e.nextElement();
				l.taskCompleted(taskId, completedIterations);
			}
		}
	}

}
