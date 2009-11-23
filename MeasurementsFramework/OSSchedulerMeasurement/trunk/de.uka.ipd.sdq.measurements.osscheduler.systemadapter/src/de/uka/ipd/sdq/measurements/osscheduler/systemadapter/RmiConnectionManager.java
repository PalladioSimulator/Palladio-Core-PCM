package de.uka.ipd.sdq.measurements.osscheduler.systemadapter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.measurements.driver.common.Constants;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
/**
 * This class is responsible for managing connections to other
 * RMI servers, e.g. the Host or Guests.
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

	public HostInterface initializeHost(String hostIP, int hostPort, String hostName) {
		String hostUrl = "rmi://" + hostIP + ":" + hostPort + "/" + hostName;
		return initializeHost(hostUrl);
	}
	
	public HostInterface initializeHost(String hostUrl) {
		HostInterface hostInterface = null;
		try {
			hostInterface = (HostInterface) Naming.lookup(hostUrl);

		} catch (RemoteException e) {
			// e.printStackTrace();
			logger.error("Failed to reach Host via RMI. (URL: " + hostUrl + ")");
			return null;
		} catch (MalformedURLException e) {
			logger.error("Host RMI URL is not valid: " + hostUrl);
			return null;
		} catch (NotBoundException e) {
			logger.error("Host is not bound to the specified name. (URL: " + hostUrl + ")");
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
			return null;
		}
		logger.info("RMI connection to Host established.");
		return hostInterface;
	}
	
	
	
}
