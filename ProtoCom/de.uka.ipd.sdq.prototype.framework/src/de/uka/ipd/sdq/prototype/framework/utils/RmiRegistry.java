package de.uka.ipd.sdq.prototype.framework.utils;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import de.uka.ipd.sdq.prototype.framework.AbstractScenarioThread;

public class RmiRegistry extends UnicastRemoteObject implements IRmiRegistry, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String LOCALHOST = "localhost";
	
	private static RmiRegistry singleton;
	
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger
		.getLogger(AbstractScenarioThread.class);
	
	private RmiRegistry() throws RemoteException
	{
		// Locate java RMI registry or create one
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			logger.info("Java RMI registry started");
			
		} catch (RemoteException e) {
			LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
			logger.info("Java RMI registry already running");
		}
		
		// Create registry binding service if it doesn't exist yet
		try {
			Naming.lookup("//localhost/" + PCM_RMI_REGISTRY);
		
			logger.info("RMI binding service already running");
			System.exit(0);
			
		} catch (MalformedURLException e) {		
		} catch (NotBoundException e) {
			logger.info("Starting RMI binding service");
			
			try {
				Naming.bind(PCM_RMI_REGISTRY, this);
			} catch (MalformedURLException e2) {
					logger.error("RMI registry failed", e2);
			} catch (RemoteException e2) {
					logger.error("RMI registry failed", e2);
			} catch (AlreadyBoundException e2) {
					logger.error("RMI registry failed: Registry already bound on this port", e2);
			}	
		}
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.prototype.framework.IRmiRegistry#bindComponent(java.lang.String, java.rmi.server.UnicastRemoteObject)
	 */
	public void bindComponent(String name, Remote component) throws RemoteException
	{
		logger.info("Binding " + name + " to RMI registry.");
		try {
			java.rmi.Naming.rebind(name, component);
		} catch (MalformedURLException e) {
			logger.error("RMI registry failed", e);
//		} catch (AlreadyBoundException e) {
//			logger.error("RMI Registry failed: Component " + name + " already bound",e);
		}
	}
	
	public static void startRegistry() 
	{
		if (singleton == null) {
			try {
				singleton = new RmiRegistry();
			} catch (RemoteException e) {
				logger.error("RMI Registry failed", e);
			}
		}
	}
	
	/**
	 * Registers a component to a RMI registry at the given IP.
	 * @param registryIP	IP of the registry
	 * @param component		instance of the component
	 * @param componentName	unique name of the component
	 */
	public static void registerComponent(String registryIP, java.rmi.Remote component, String componentName) {

		try {
			Registry reg = LocateRegistry.getRegistry(registryIP);

			de.uka.ipd.sdq.prototype.framework.utils.IRmiRegistry pcmRegistry = null;
			
			while (true) {
				try {
					pcmRegistry = (IRmiRegistry) reg.lookup(PCM_RMI_REGISTRY);
					pcmRegistry.bindComponent(componentName, component);
					break;
				} catch (RemoteException e) {
					logger.info("RMI registry not found. Next attempt in 3 seconds.");
					Thread.sleep(3000);
				} catch (NotBoundException e) {
					logger.info("RMI binding service not found. Next attempt in 3 seconds.");
					Thread.sleep(3000);	
				}
			}

			logger.info(componentName + " bound in registry");

		} catch (Exception e) {
			logger.error(componentName + " err: " + e.getMessage());
		}

	}
	
	/**
	 * Returns an IP from an argument string array or LOCALHOST instead
	 * @param args
	 * @return
	 */
	public static String getIpFromArguments(String[] args) {
		if (args != null && args.length > 0) {
			return args[0];
		}
		return LOCALHOST;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Remote lookup(String name) {
		Remote result = null;

		while (true) {
			try {		
				
				result = java.rmi.Naming.lookup(name); 
		
			} catch (java.net.MalformedURLException e) {
				logger.error("Remote URI malformed. This should never happen, strange model names used?");
			} catch (java.rmi.RemoteException e) {
				logger.error("Error while waiting for system. " + e);
			} catch (java.rmi.NotBoundException e) {
				logger.info("System missing: " + e.getMessage());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException innerE) {
					logger.error("Error while waiting for system. " + e);
				}
				continue;
			}
			
			return result;
		}
	}
	
	
	public static void main(String[] args)
	{	
		startRegistry();
		
		logger.info("RMI registry started on port " + Registry.REGISTRY_PORT);
		
		new Thread() {
			public void run() {
				Scanner input = new Scanner(System.in);
				if (input.hasNext()) {
					input.nextLine();
				}
			}
		}.run();
	}	
}
