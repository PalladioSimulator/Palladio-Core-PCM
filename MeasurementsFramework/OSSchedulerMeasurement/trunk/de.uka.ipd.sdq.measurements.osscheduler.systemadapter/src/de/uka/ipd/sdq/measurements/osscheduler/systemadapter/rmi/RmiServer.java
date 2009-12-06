package de.uka.ipd.sdq.measurements.osscheduler.systemadapter.rmi;

import java.net.InetAddress;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;
import java.security.AccessControlException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Status;

import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.Constants;
import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.OSSchedulerSystemAdapterPlugin;
import de.uka.ipd.sdq.measurements.rmi.SystemAdapterRmiInterface;

public class RmiServer {
	
	private static Logger logger = Logger.getLogger(RmiServer.class);
	
	public RmiServer() {
		
	}
	
	private int port = 0;
	private String ip = "";
	
	public int getRmiPort() {
		return port;
	}
	
	public String getRmiIp() {
		return ip;
	}
	
	public void start(SystemAdapterRmiImpl rmiImpl) {
		logger.info("Starting RMI server...");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		ip = OSSchedulerSystemAdapterPlugin.getDefault().getPreference(Constants.PreferenceKeySystemAdapterIp);
		port = OSSchedulerSystemAdapterPlugin.getDefault().getIntPreference(Constants.PreferenceKeySystemAdapterPort);
		String rmiUrl = ip + ":" + port;
		try {
			SystemAdapterRmiInterface stub = null;
			try {
				stub = (SystemAdapterRmiInterface) UnicastRemoteObject.exportObject(rmiImpl, port);
			} catch (ExportException e) {
				logger.error("Failed to start RMI server, probably the port is already in use.");
				OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to start RMI server, probably the port is already in use.", e));
				return;
			}
			LocateRegistry.createRegistry(port);
	
			try {
				logger.info("Binding: " + "rmi://" + rmiUrl + "/" + de.uka.ipd.sdq.measurements.driver.common.Constants.SystemAdapterRMIName);
				Naming.rebind("rmi://" + rmiUrl + "/" + de.uka.ipd.sdq.measurements.driver.common.Constants.SystemAdapterRMIName, stub);
			} catch (UnknownHostException e) {
				logger.error("Failed to start RMI server, Host not known: " + rmiUrl);
				OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to start RMI server, Host not known: " + rmiUrl, e));
			} catch (AccessControlException e) {
				e.printStackTrace();
				logger.error("Failed to start RMI server, access denied. Please adapt security manager.");
				OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to start RMI server, access denied. Please adapt security manager.", e));
			} catch (ConnectException e) {
				logger.error("Failed to start RMI server on " + rmiUrl + ".");
				OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to start RMI server on " + rmiUrl + ".", e));
			} catch (Exception e) {
				OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to start RMI server.", e));
			}
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}
	
	public static String detectIp() {
		String ipAddress = null;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			ipAddress = addr.getHostAddress();
		} catch (java.net.UnknownHostException e) {
			OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to lookup System Adapter IP address.", e));
			ipAddress = null;
		}
		return ipAddress;
		
	}
			

}
