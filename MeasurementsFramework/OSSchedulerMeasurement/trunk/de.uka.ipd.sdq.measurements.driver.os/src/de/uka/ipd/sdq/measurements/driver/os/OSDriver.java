package de.uka.ipd.sdq.measurements.driver.os;

import java.io.File;

import de.uka.ipd.sdq.measurements.driver.common.LoggerDelegate;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskExecuterFactory;
import de.uka.ipd.sdq.measurements.driver.os.rmi.RMIServer;
import de.uka.ipd.sdq.measurements.driver.os.tasks.OSDriverTaskExecuterFactory;

public class OSDriver {

	private static boolean DEBUG = false;
	private static boolean LOGGING = true;
	private static OSDriverLoggerDelegate loggerDelegate = null;

	private static OSDriver midisHost = null;

	public static OSDriver getInstance() {
		if (midisHost == null) {
			midisHost = new OSDriver();
		}
		return midisHost;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OSDriver.getInstance().initialize();

	}

	private RMIServer rmiServer = null;
	//private MasterInterface masterInterface = null;
	//private HashMap<String, GuestInterface> guestInterfaces = new HashMap<String, GuestInterface>();

	private void initialize() {
		if (System.getProperty(OSDriverConstants.JavaPropertyKey) != null) {
			PropertyManager.getInstance().initializeProperties(
					new File(System
							.getProperty(OSDriverConstants.JavaPropertyKey)));
		} else {
			PropertyManager.getInstance().initializeProperties(null);
		}
		
		// Register OS task sub factory.
		TaskExecuterFactory.getInstance().registerSubFactory(new OSDriverTaskExecuterFactory());

		// Check if logging should be done.
		LOGGING = PropertyManager.getInstance().getLogging();
		DEBUG = PropertyManager.getInstance().getLoggingDebug();

		rmiServer = new RMIServer();
		if (!rmiServer.initialize()) {
			logError("Failed to start RMI server. Exiting.");
			System.exit(-1);
		}

		// If the Java application is terminated normally, this
		// thread should be executed to do some termination work.
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				OSDriver.this.shutdown();
			}
		});

		log("Host up and running.");
		//MidisHostHelper.storeHostCalibrationFilesOnGuest("1233", 2101, "Guest1", true);	

	}

	/*public void setGuest(String guestIP, int guestPort,
			GuestInterface guestInterface) {
		guestInterfaces.put(guestIP + ":" + guestPort, guestInterface);
	}

	public GuestInterface getGuest(String guestIP, int guestPort) {
		return guestInterfaces.get(guestIP + ":" + guestPort);
	}

	public ArrayList<GuestInterface> getGuests() {
		return new ArrayList<GuestInterface>(guestInterfaces.values());
	}*/

	public boolean shutdown() {
		// Start the final shutdown thread.
		new Thread(new Runnable() {

			public void run() {
				// Wait 1 sec to allow for
				// returning RMI calls
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				log("Exiting...");
				System.exit(0);

			}
		}).start();
		
		if (rmiServer != null) {
			rmiServer.shutdown();
		}

		return true;
	}

	/**
	 * Retrieve the Host's IP address.
	 * 
	 * @return
	 */
	/*
	 * public String getHostIPAddress() { if (hostIpAddress != null) { return
	 * hostIpAddress; } try { InetAddress addr = InetAddress.getLocalHost();
	 * hostIpAddress = addr.getHostAddress(); } catch (UnknownHostException e) {
	 * logError("Failed to lookup Host IP address. Property lookup used.");
	 * hostIpAddress = null; } if (hostIpAddress != null) { return
	 * hostIpAddress; } hostIpAddress =
	 * PropertyManager.getInstance().getHostIp(); if (hostIpAddress == null) {
	 * logError("Failed to lookup Host IP address. Start WorkloadHost with -D" +
	 * MidisHostConstants.JavaPropertyHostIP + "=<IP_ADDRESS>"); } return
	 * hostIpAddress; }
	 */


	/*public void allTasksCompleted(TaskExecuter rootTaskExecuter) {
		boolean masterCalledSuccessfully = false;
		try {
			if ((getMaster() != null)
					&& (getMaster().allTasksCompleted(rootTaskExecuter
							.getTaskResults(true)))) {
				masterCalledSuccessfully = true;
			} else {
				logError("Master reported problems when storing results. Storing results in temporary file.");
			}
		} catch (RemoteException e) {
			masterInterface = null;
			masterCalledSuccessfully = false;
			logError("Failed to call master after task execution. Storing results in temporary file.");
		}
		if (masterCalledSuccessfully == true) {
			return;
		}
		File tmpResultFile = new File("tempresults");
		try {
			tmpResultFile.createNewFile();
		} catch (IOException e) {
			logError("Failed to create temporary result file.");
		}
		try {
			log("Writing temporary results file...");
			FileOutputStream fileOutputStream = new FileOutputStream(
					tmpResultFile);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			objectOutputStream.writeObject(rootTaskExecuter
					.getTaskResults(true));
			objectOutputStream.close();
			fileOutputStream.close();
			log("Temporary results file written successfully!");
		} catch (IOException e) {
			logError("Error while storing results. Results probably not persisted!");
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<AbstractTaskResult> getTemporaryResults() {
		ArrayList<AbstractTaskResult> results = null;
		File tmpResultFile = new File("tempresults");
		if (!tmpResultFile.exists()) {
			logError("No file with temporary results found.");
			return results;
		}
		try {
			FileInputStream fileInputStream = new FileInputStream(tmpResultFile);
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);
			results = (ArrayList<AbstractTaskResult>) objectInputStream
					.readObject();
			objectInputStream.close();
			fileInputStream.close();
		} catch (ClassNotFoundException e) {
			logError("Error while reading temporary results. No temporary file returned.");
			results = null;
		} catch (IOException e) {
			logError("Error while reading temporary results. No temporary file returned.");
			results = null;
		}
		log("Returning temporary results...");
		return results;
	}*/

	public static void logDebug(String debugMessage) {
		if (OSDriver.DEBUG) {
			System.out.println(debugMessage);
		}
	}

	public static void logDebugError(String debugMessage) {
		if (OSDriver.DEBUG) {
			System.err.println(debugMessage);
		}
	}

	public static void log(String logMessage) {
		if (OSDriver.LOGGING) {
			System.out.println(logMessage);
		}
	}

	public static void logError(String logMessage) {
		if (OSDriver.LOGGING) {
			System.err.println(logMessage);
		}
	}

	public static boolean getLoggingEnabled() {
		return OSDriver.LOGGING;
	}

	public static boolean getLoggingDebugEnabled() {
		return OSDriver.DEBUG;
	}

	public static LoggerDelegate getLoggerDelegate() {
		if (loggerDelegate == null) {
			loggerDelegate = new OSDriverLoggerDelegate();
		}
		return loggerDelegate;
	}

}
