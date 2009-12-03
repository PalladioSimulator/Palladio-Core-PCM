package de.uka.ipd.sdq.measurements.osscheduler.systemadapter.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Status;

import de.uka.ipd.sdq.measurements.driver.common.Constants;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.OSSchedulerSystemAdapterPlugin;

/**
 * This class is responsible for managing connections to other RMI servers, e.g.
 * the Host or Guests.
 * 
 * @author hauck
 * 
 */
public class RmiConnectionManager {

	private static Logger logger = Logger.getLogger(RmiConnectionManager.class);

	public static RmiConnectionManager instance = null;

	public static RmiConnectionManager getInstance() {
		if (instance == null) {
			instance = new RmiConnectionManager();
		}
		return instance;
	}

	private RmiConnectionManager() {
	}

	public HostInterface initializeHost(String hostIP, int hostPort, String hostName, String systemAdapterIP, int systemAdapterPort) {
		String hostUrl = "rmi://" + hostIP + ":" + hostPort + "/" + hostName;
		return initializeHost(hostUrl, systemAdapterIP, systemAdapterPort);
	}

	public HostInterface initializeHost(String hostUrl, String systemAdapterIP, int systemAdapterPort) {
		HostInterface hostInterface = null;
		try {
			hostInterface = (HostInterface) Naming.lookup(hostUrl);

		} catch (RemoteException e) {
			logger.error("Failed to reach Host via RMI. (URL: " + hostUrl + ")");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to reach Host via RMI. (URL: " + hostUrl + ")", e));
			return null;
		} catch (MalformedURLException e) {
			logger.error("Host RMI URL is not valid: " + hostUrl);
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Host RMI URL is not valid: " + hostUrl, e));
			return null;
		} catch (NotBoundException e) {
			logger.error("Host is not bound to the specified name. (URL: " + hostUrl + ")");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Host is not bound to the specified name. (URL: " + hostUrl + ")", e));
			return null;
		}

		logger.info("Host found.");

		// Do ping test.
		try {
			String pingResult = hostInterface.ping();
			if (pingResult.equals(Constants.RmiPingResult)) {
				logger.info("Host connection test succeeded.");
			}
		} catch (RemoteException e) {
			logger.error("Error during Host connection test!");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Error during Host connection test!", e));
			return null;
		}
		logger.info("RMI connection to Host established.");

		// Call Host to lookup Master
		boolean lookupMasterResult = false;
		try {
			logger.info("Asking Host to look up SystemAdapter...");
			lookupMasterResult = hostInterface.lookupSystemAdapter(systemAdapterIP, systemAdapterPort);
		} catch (RemoteException e) {
			logger.error("Failed to call lookupMaster on Host.");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to call lookupMaster on Host.", e));
			return null;
		}
		if (lookupMasterResult == false) {
			logger.error("Host has been contacted, but reported problems.");
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Host has been contacted, but reported problems."));
			return null;
		}
		logger.info("Host is up and running.");

		return hostInterface;
	}

}
