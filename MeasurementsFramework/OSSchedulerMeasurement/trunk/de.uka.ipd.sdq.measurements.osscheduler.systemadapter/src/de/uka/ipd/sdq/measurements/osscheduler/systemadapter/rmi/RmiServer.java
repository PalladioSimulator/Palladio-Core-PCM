package de.uka.ipd.sdq.measurements.osscheduler.systemadapter.rmi;

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

import de.uka.ipd.sdq.measurements.driver.common.Constants;
import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.OSSchedulerSystemAdapterPlugin;
import de.uka.ipd.sdq.measurements.rmi.SystemAdapterRmiInterface;

public class RmiServer {
	
	private static Logger logger = Logger.getLogger(RmiServer.class);
	
	public RmiServer() {
		
	}
	
	public void start(String machineIp, int machinePort, SystemAdapterRmiImpl rmiImpl) {
		logger.info("Starting RMI server...");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			SystemAdapterRmiInterface stub = null;
			try {
				stub = (SystemAdapterRmiInterface) UnicastRemoteObject.exportObject(rmiImpl, machinePort);
			} catch (ExportException e) {
				logger.error("Failed to start RMI server, probably the port is already in use.");
				OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to start RMI server, probably the port is already in use.", e));
				return;
			}
			LocateRegistry.createRegistry(machinePort);
	
			try {
				logger.info("Binding: " + "rmi://" + machineIp + ":" + machinePort + "/" + Constants.SystemAdapterRMIName);
				Naming.rebind("rmi://" + machineIp + ":" + machinePort + "/" + Constants.SystemAdapterRMIName, stub);
			} catch (UnknownHostException e) {
				logger.error("Failed to start RMI server, Host not known: " + machineIp + ":" + machinePort);
				OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to start RMI server, Host not known: " + machineIp + ":" + machinePort, e));
			} catch (AccessControlException e) {
				e.printStackTrace();
				logger.error("Failed to start RMI server, access denied. Please adapt security manager.");
				OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to start RMI server, access denied. Please adapt security manager.", e));
			} catch (ConnectException e) {
				logger.error("Failed to start RMI server on " + machineIp + ":" + machinePort + ".");
				OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to start RMI server on " + machineIp + ":" + machinePort + ".", e));
			} catch (Exception e) {
				OSSchedulerSystemAdapterPlugin.getDefault().getLog().log(new Status(Status.ERROR, OSSchedulerSystemAdapterPlugin.PLUGIN_ID, "Failed to start RMI server.", e));
			}
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}
			

}
