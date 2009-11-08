package de.uka.ipd.sdq.measurements.systemcontroller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Logger;

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

	private static Logger logger = Logger.getLogger(RmiConnectionManager.class.getName());

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
			logger.severe("Failed to reach Host via RMI. (URL: " + hostUrl + ")");
			return null;
		} catch (MalformedURLException e) {
			logger.severe("Host RMI URL is not valid: " + hostUrl);
			return null;
		} catch (NotBoundException e) {
			logger.severe("Host is not bound to the specified name. (URL: " + hostUrl + ")");
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
			logger.severe("Error during Host connection test!");
			return null;
		}
		logger.info("RMI connection to Host established.");
		return hostInterface;
	}
	
	
	
}
