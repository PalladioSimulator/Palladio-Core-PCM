package de.uka.ipd.sdq.measurements.driver.os.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import de.uka.ipd.sdq.measurements.driver.common.Constants;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.driver.os.OSDriver;
import de.uka.ipd.sdq.measurements.driver.os.PropertyManager;

public class RmiClient {
	
	/**
	 * Multiple Host processes can run in parallel. In this case, the processes can communicate.
	 * The parent process which launched a subprocess has to call the process via the lookupParentHost method
	 * to make him look up the parent.
	 * 
	 * @return true if the lookup succeeded.
	 */
	public static boolean lookupParentHost() {
		String hostUrl = PropertyManager.getInstance().getParentHostRmiIp();
		int port = PropertyManager.getInstance().getParentHostRmiPort();
		HostInterface hostInterface = null;
		try {
			if (OSDriver.getLoggingDebugEnabled()) {
				OSDriver.logDebug("Looking up parent driver on " + hostUrl + ":" + port);
			}
			//masterInterface = Naming.lookup("rmi://" + masterURL + ":" + port + "/Master");
			Registry registry = LocateRegistry.getRegistry(hostUrl, port);
			hostInterface = (HostInterface) registry.lookup(Constants.DriverRMIName);
			OSDriver.getInstance().setParentHost(hostInterface);
		} catch (NotBoundException e) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError(e.getMessage());
			}
			return false;
		} catch (Exception e) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError(e.getMessage());
			}
			return false;
		}
		try {
			hostInterface.ping();
		} catch (RemoteException e) {
			return false;
		}
		return true;
	}
	
	public static HostInterface getChildHost(String hostUrl, int port) {
		HostInterface hostInterface = null;
		try {
			if (OSDriver.getLoggingDebugEnabled()) {
				OSDriver.logDebug("Looking up child driver on " + hostUrl + ":" + port);
			}
			//masterInterface = Naming.lookup("rmi://" + masterURL + ":" + port + "/Master");
			Registry registry = LocateRegistry.getRegistry(hostUrl, port);
			hostInterface = (HostInterface) registry.lookup(Constants.DriverRMIName);
		} catch (NotBoundException e) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError(e.getMessage());
			}
			return null;
		} catch (Exception e) {
			if (OSDriver.getLoggingEnabled()) {
				OSDriver.logError(e.getMessage());
			}
			return null;
		}
		return hostInterface;
	}

}
