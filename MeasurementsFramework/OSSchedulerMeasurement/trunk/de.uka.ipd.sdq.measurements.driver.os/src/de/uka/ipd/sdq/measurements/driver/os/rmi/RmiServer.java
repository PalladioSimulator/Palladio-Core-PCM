package de.uka.ipd.sdq.measurements.driver.os.rmi;

import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;
import java.security.AccessControlException;

import de.uka.ipd.sdq.measurements.driver.common.Constants;
import de.uka.ipd.sdq.measurements.driver.common.DriverLogger;
import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.driver.os.OSDriverConstants;
import de.uka.ipd.sdq.measurements.driver.os.PropertyManager;

public class RmiServer {

	public RmiServer() {
	}

	HostImpl hostInterface = null;
	HostInterface stub = null;
	
	private int hostPort = 0;
	private String hostIP = null;

	public boolean initialize() {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		DriverLogger.log("Starting RMI services...");
		try {

			hostIP = PropertyManager.getInstance().getHostRmiIp();
			if (hostIP == null) {
				DriverLogger.logError("Failed to lookup Driver IP address. Start MidisHost with -D" + OSDriverConstants.JavaPropertyOSDriverRmiIP + "=<IP_ADDRESS>");
			}
			hostPort = PropertyManager.getInstance().getDriverRmiPort();


			hostInterface = new HostImpl();
			stub = null;
			try {
				stub = (HostInterface) UnicastRemoteObject.exportObject(hostInterface, hostPort);
			} catch (ExportException e) {
				if (e.detail instanceof IllegalArgumentException) {
					DriverLogger.logError("Failed to start RMI server, the RMI interface is invalid: " + e.detail.getMessage());
				} else {
					DriverLogger.logError("Failed to start RMI server, probably the port is already in use: " + hostIP + ":" + hostPort);
					e.printStackTrace();
				}
				return false;
			}
			LocateRegistry.createRegistry(hostPort);

			try {
				DriverLogger.logDebug("Binding: " + "rmi://" + hostIP + ":" + hostPort + "/" + Constants.DriverRMIName);
				Naming.rebind("rmi://" + hostIP + ":" + hostPort + "/" + Constants.DriverRMIName, stub);
			} catch (UnknownHostException e) {
				DriverLogger.logError("Failed to start RMI server, Host not known: " + hostIP + ":" + hostPort);
				return false;
			} catch (AccessControlException e) {
				DriverLogger.logError("Failed to start RMI server, access denied. Please adapt security manager.");
				return false;
			} catch (ConnectException e) {
				DriverLogger.logError("Failed to start RMI server on " + hostIP + ":" + hostPort + ".");
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		catch (RemoteException ex) {
			ex.printStackTrace();
			return false;
		}

		DriverLogger.log("OS Driver RMI server started on " + "rmi://" + hostIP + ":" + hostPort + ".");

		return true;
	}

	public boolean shutdown() {
		try {
			DriverLogger.log("Stopping RMI server...");
			UnicastRemoteObject.unexportObject(hostInterface, true);
			return true;
		} catch (NoSuchObjectException e) {
			DriverLogger.logError("Failed to shutdown RMI server.");
			return false;
		}
	}

}
