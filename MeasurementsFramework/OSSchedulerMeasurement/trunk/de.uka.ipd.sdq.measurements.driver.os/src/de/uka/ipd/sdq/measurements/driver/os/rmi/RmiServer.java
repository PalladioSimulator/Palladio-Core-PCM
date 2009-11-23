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

import de.uka.ipd.sdq.measurements.driver.common.rmi.HostInterface;
import de.uka.ipd.sdq.measurements.driver.os.OSDriver;
import de.uka.ipd.sdq.measurements.driver.os.OSDriverConstants;
import de.uka.ipd.sdq.measurements.driver.os.PropertyManager;

public class RmiServer {

	public RmiServer() {
	}

	HostImpl hostInterface = null;

	public boolean initialize() {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		OSDriver.log("Starting RMI services...");
		String hostIP = null;
		int hostPort = 0;
		try {

			hostIP = PropertyManager.getInstance().getHostRmiIp();
			if (hostIP == null) {
				OSDriver.logError("Failed to lookup Driver IP address. Start MidisHost with -D" + OSDriverConstants.JavaPropertyOSDriverRmiIP + "=<IP_ADDRESS>");
			}
			hostPort = PropertyManager.getInstance().getDriverRmiPort();


			hostInterface = new HostImpl();
			HostInterface stub = null;
			try {
				stub = (HostInterface) UnicastRemoteObject.exportObject(hostInterface, hostPort);
			} catch (ExportException e) {
				OSDriver.logError("Failed to start RMI server, probably the port is already in use.");
				return false;
			}
			LocateRegistry.createRegistry(hostPort);

			try {
				OSDriver.logDebug("Binding: " + "rmi://" + hostIP + ":" + hostPort + "/" + OSDriverConstants.OSDriverRMIName);
				Naming.rebind("rmi://" + hostIP + ":" + hostPort + "/" + OSDriverConstants.OSDriverRMIName, stub);
			} catch (UnknownHostException e) {
				OSDriver.logError("Failed to start RMI server, Host not known: " + hostIP + ":" + hostPort);
				return false;
			} catch (AccessControlException e) {
				OSDriver.logError("Failed to start RMI server, access denied. Please adapt security manager.");
				return false;
			} catch (ConnectException e) {
				OSDriver.logError("Failed to start RMI server on " + hostIP + ":" + hostPort + ".");
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

		OSDriver.log("OS Driver RMI server started on " + "rmi://" + hostIP + ":" + hostPort + ".");

		return true;
	}

	public boolean shutdown() {
		try {
			OSDriver.log("Stopping RMI server...");
			UnicastRemoteObject.unexportObject(hostInterface, true);
			return true;
		} catch (NoSuchObjectException e) {
			OSDriver.logError("Failed to shutdown RMI server.");
			return false;
		}
	}

}
