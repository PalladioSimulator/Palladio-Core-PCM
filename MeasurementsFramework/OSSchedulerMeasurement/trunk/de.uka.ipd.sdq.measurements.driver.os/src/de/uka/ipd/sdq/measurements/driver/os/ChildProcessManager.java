package de.uka.ipd.sdq.measurements.driver.os;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import de.uka.ipd.sdq.measurements.driver.common.Constants;
import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskListener;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskResultStorage;
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
		taskListeners = new Vector[MAX_NUMBER_OF_CHILD_PROCESSES];
		childProcesses = new HashMap<Integer, Integer>();
		newRmiPort = PropertyManager.getInstance().getDriverRmiPort();
	}
	
	int newRmiPort = 0;
		
	private boolean startChildProcess() {
		String hostUrl = PropertyManager.getInstance().getHostRmiIp();
		int rmiPort = PropertyManager.getInstance().getDriverRmiPort();
		newRmiPort++;
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
		if (DriverLogger.DEBUG) {
			processArguments.add("-D" + OSDriverConstants.JavaPropertyOSDriverLogging + "=true");
			processArguments.add("-D" + OSDriverConstants.JavaPropertyOSDriverLoggingDebug + "=true");
		} else {
			processArguments.add("-D" + OSDriverConstants.JavaPropertyOSDriverLogging + "=false");
			processArguments.add("-D" + OSDriverConstants.JavaPropertyOSDriverLoggingDebug + "=false");
		}
		processArguments.add("StartHost");
		processArguments.add("-subprocess");
		if (DriverLogger.DEBUG) {
			for (String s : processArguments) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
		try {
			if (DriverLogger.LOGGING) {
				DriverLogger.log("Starting child process on " + hostUrl + ":" + newRmiPort);
			}
			ProcessBuilder processBuilder = new ProcessBuilder(processArguments);
			processBuilder.directory(new File("C:/Code/workspace_measurements/de.uka.ipd.sdq.measurements.driver.os/export/"));
			Process process = processBuilder.start();
			if (DriverLogger.DEBUG) {
				ChildProcessFileLog c = new ChildProcessFileLog(process.getInputStream(), "output" + newRmiPort + ".txt");
				ChildProcessFileLog c2 = new ChildProcessFileLog(process.getErrorStream(), "outputerr" + newRmiPort + ".txt");
				new Thread(c).start();
				new Thread(c2).start();
			} else {
				ChildProcessFileLog c = new ChildProcessFileLog(process.getInputStream(), null);
				ChildProcessFileLog c2 = new ChildProcessFileLog(process.getErrorStream(), null);
				new Thread(c).start();
				new Thread(c2).start();
			}
			
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
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("Cannot prepare task for child process " + childProcessNumber + ". Only " + MAX_NUMBER_OF_CHILD_PROCESSES + " child processes are allowed.");
			}
			return false;
		}
		ChildProcess process = getChildProcess(childProcessNumber);
		
		if (process == null) {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("Child process " + childProcessNumber + " is null!");
			}
			return false;
		}
		DriverLogger.log("Checking if process " + childProcessNumber + " is running...");
		if (!process.isProcessRunning()) {
			runningProcesses.remove(process);
		}
		process = getChildProcess(childProcessNumber);
		if (process == null) {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("Child process " + childProcessNumber + " is null!");
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
			if (DriverLogger.LOGGING) {
				DriverLogger.log("Trying to ping child process " + childProcessNumber + " on " + process.getRmiIp() + ":" + process.getRmiPort() + "...");
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
				if (DriverLogger.LOGGING) {
					DriverLogger.log("Pinging child process " + childProcessNumber + " on " + process.getRmiIp() + ":" + process.getRmiPort() + " failed.");
				}
				host = null;
			}
			
		}
		
		if (host == null) {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("Failed to reach child process " + childProcessNumber + " on " + process.getRmiIp() + ":" + process.getRmiPort());
			}
			return false;
		}
		childRmiInterfaces[childProcessNumber] = host;
		try {
			return host.prepareTasks(rootTask, false, numberOfIterations);
		} catch (RemoteException e) {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("Failed to prepare child task: " + e.getMessage());	
			}
			return false;
		}
	}
	
	public void executeTask(int taskId, int childProcessNumber, int iteration) {
		if ((childProcessNumber < 0) || (childProcessNumber >= MAX_NUMBER_OF_CHILD_PROCESSES)) {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("Cannot execute task for child process " + childProcessNumber + ". Only " + MAX_NUMBER_OF_CHILD_PROCESSES + " child processes are allowed.");
			}
			return;
		}
		if (childRmiInterfaces[childProcessNumber] == null) {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("RMI interface for child process " + childProcessNumber + " is not set.");
			}
			return;
		}
		try {
			childProcesses.put(taskId, childProcessNumber);
			if (DriverLogger.DEBUG) {
			DriverLogger.logDebug("Executing task " + taskId + " on child process " + childProcessNumber + ", iteration " + iteration);
			}
			childRmiInterfaces[childProcessNumber].executeOneTaskExecution(taskId);
		} catch (RemoteException e) {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("Failed to execute task " + taskId + " on child process via RMI.");
			}
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
		while (runningProcesses.size() <= childProcessNumber) {
			if (!startChildProcess()) {
				if (DriverLogger.LOGGING) {
					DriverLogger.logError("Failed to start child process.");
				}
				return null;
			}
		}
		return runningProcesses.get(childProcessNumber);
	}
	
	
	private HashMap<Integer, Integer> childProcesses;
	
	private int getChildProcessNumber(int taskId) {
		return childProcesses.get(taskId);
	}
	
	public HashMap<Integer, ArrayList<RmiResult>> getTaskResultsFromChildProcess(int childProcessNumber) {
		if (childRmiInterfaces.length > childProcessNumber) {
			try {
				return childRmiInterfaces[childProcessNumber].getTaskResults();
			} catch (RemoteException e) {
				if (DriverLogger.LOGGING) {
					DriverLogger.logError("Failed to get results from child process " + childProcessNumber + ": " + e.getMessage());
				}
			}
		}
		return new HashMap<Integer, ArrayList<RmiResult>>();
	}
	
	public void storeChildResults() {
		for (int i = 0; i<childRmiInterfaces.length; i++) {
			if (childRmiInterfaces[i] != null) {
				TaskResultStorage.getInstance().storeResults(getTaskResultsFromChildProcess(i));
			}
		}
	}
	
	public void finishTask(int taskId, int childProcessNumber) {
		if ((childProcessNumber < 0) || (childProcessNumber >= MAX_NUMBER_OF_CHILD_PROCESSES)) {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("Cannot finish task for child process " + childProcessNumber + ". Only " + MAX_NUMBER_OF_CHILD_PROCESSES + " child processes are allowed.");
			}
			return;
		}
		if (childRmiInterfaces[childProcessNumber] == null) {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("RMI interface for child process " + childProcessNumber + " is not set.");
			}
			return;
		}
		try {
			if (DriverLogger.DEBUG) {
				DriverLogger.logDebug("Try to finish task " + taskId + " on child process " + childProcessNumber);
			}
			childRmiInterfaces[childProcessNumber].finishTask(taskId);
		} catch (RemoteException e) {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("Failed to execute task " + taskId + " on child process via RMI.");
			}
		}
		
	}

	public void childTaskCompleted(int taskId, int completedIterations) {
		if (DriverLogger.DEBUG) {
			DriverLogger.logDebug("ChildProcessManager: Child task completed! Task ID: " + taskId + ", Completed iterations: " +  completedIterations);
		}
		fireTaskCompleted(taskId, completedIterations, getChildProcessNumber(taskId));
	}
	
	public void stopAllChildProcesses() {
		for (ChildProcess c : runningProcesses) {
			c.getProcess().destroy();
			
		}
		
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
		if (DriverLogger.DEBUG) {
			DriverLogger.logDebug("ChildProcessManager: Task completed, notifying all listeners for task " + taskId + ", child process number " + childProcessNumber);
		}
		
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
				TaskListener l = e.nextElement();
				l.taskCompleted(taskId, completedIterations);
			}
		} else {
			if (DriverLogger.LOGGING) {
				DriverLogger.logError("ChildProcessManager: No listeners for task " + taskId + ", child process number: " + childProcessNumber);
			}
		}
	}

}
