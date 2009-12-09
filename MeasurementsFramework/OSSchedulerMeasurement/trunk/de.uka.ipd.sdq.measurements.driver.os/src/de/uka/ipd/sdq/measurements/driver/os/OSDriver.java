package de.uka.ipd.sdq.measurements.driver.os;

import java.io.File;
import java.rmi.RemoteException;

import org.apache.log4j.PropertyConfigurator;

import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.driver.common.tasks.TaskExecuterFactory;
import de.uka.ipd.sdq.measurements.driver.os.rmi.RmiClient;
import de.uka.ipd.sdq.measurements.driver.os.rmi.RmiServer;
import de.uka.ipd.sdq.measurements.driver.os.tasks.OSDriverTaskExecuterFactory;
import de.uka.ipd.sdq.measurements.rmi.SystemAdapterRmiInterface;

public class OSDriver {

	public static boolean IS_SUB_PROCESS = false; 

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
		OSDriver.getInstance().initialize(args);

	}

	private RmiServer rmiServer = null;
	//private MasterInterface masterInterface = null;
	private SystemAdapterRmiInterface systemAdapterRmiInterface = null;
	public SystemAdapterRmiInterface getSystemAdapterRmiInterface() {
		return systemAdapterRmiInterface;
	}

	public void setSystemAdapterRmiInterface(SystemAdapterRmiInterface systemAdapterRmiInterface) {
		this.systemAdapterRmiInterface = systemAdapterRmiInterface;
	}

	private HostInterface parentHostInterface = null;
	//private HashMap<String, GuestInterface> guestInterfaces = new HashMap<String, GuestInterface>();

	public HostInterface getParentHost() {
		return parentHostInterface;
	}

	public void setParentHost(HostInterface parentHostInterface) {
		this.parentHostInterface = parentHostInterface;
	}

	private void initialize(String[] args) {
		// Check if the driver has been launched as a subprocess.
		if ((args != null) && (args.length >0)) {
			for (String arg : args) {
				if (arg.toLowerCase().endsWith("subprocess")) {
					IS_SUB_PROCESS = true;
					DriverLogger.LOGGING = false;
					DriverLogger.DEBUG = false;
					break;
				}
			}
		}
				
		if (!IS_SUB_PROCESS) {
			StringBuffer configure = new StringBuffer("export/log4j.properties");
		 	PropertyConfigurator.configure(configure.toString());
		}
		
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
		DriverLogger.LOGGING = PropertyManager.getInstance().getLogging();
		DriverLogger.DEBUG = PropertyManager.getInstance().getLoggingDebug();

		rmiServer = new RmiServer();
		if (!rmiServer.initialize()) {
			DriverLogger.logError("Failed to start RMI server. Exiting.");
			System.exit(-1);
		}
		
		// If we are a SubProcess, we look for a connection to the main Driver.
		if (IS_SUB_PROCESS == true) {
			if (!RmiClient.lookupParentHost()) {
				DriverLogger.logError("Failed to lookup parent Driver.");
				System.exit(-1);
			}
		}

		// If the Java application is terminated normally, this
		// thread should be executed to do some termination work.
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				OSDriver.this.shutdown();
			}
		});

		DriverLogger.log("Host up and running.");
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
		
		if (DriverLogger.LOGGING) {
			DriverLogger.log("Shutting down...");
		}
		
		ChildProcessManager.getInstance().stopAllChildProcesses();
		
		// Start the final shutdown thread.
		new Thread(new Runnable() {

			public void run() {
				// Wait 1 sec to allow for
				// returning RMI calls
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				if (DriverLogger.LOGGING) {
					DriverLogger.log("Exiting...");
				}
				System.exit(0);

			}
		}).start();
		if (systemAdapterRmiInterface != null) {
			try {
				systemAdapterRmiInterface.driverShutdown();
			} catch (RemoteException e) {
			}
		}

		return true;
	}

}
