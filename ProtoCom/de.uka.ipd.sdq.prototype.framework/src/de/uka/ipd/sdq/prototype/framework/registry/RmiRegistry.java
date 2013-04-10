package de.uka.ipd.sdq.prototype.framework.registry;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.ServerException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import de.uka.ipd.sdq.prototype.framework.experiment.IExperimentManager;

/**
 * RMI registry service for ProtoCom. It can be started on any hardware node of
 * the ProtoCom system.
 * 
 * Ports register themselves at this service using their name and assembly
 * context.
 * 
 * TODO: Split this class into two parts: One for managing remote connection to 
 * the registry and one for the registry service itself.
 * 
 * @author zolynski
 * 
 */
public class RmiRegistry extends UnicastRemoteObject implements IRmiRegistry, Serializable {

	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RmiRegistry.class);

	private static final long serialVersionUID = 8964579189837506625L;

	public static final String LOCALHOST = "localhost";

	private static RmiRegistry singleton;

	/**
	 * Remote address of RMI registry.
	 */
	private static String configuredRemoteAddr = LOCALHOST;
	
	/**
	 * IP Port of RMI registry, default is 1099.
	 */
	private static int configuredRegistryPort = Registry.REGISTRY_PORT;

	/**
	 * List of all associated experiment managers.
	 */
	private List<IExperimentManager> experimentManagers = new LinkedList<IExperimentManager>();
	
	/**
	 * Initializes a new RMI registry.
	 * 
	 * @throws RemoteException
	 */
	private RmiRegistry() throws RemoteException {
		// Locate java/sun's RMI registry or create one
		try {
			LocateRegistry.createRegistry(configuredRegistryPort);
			logger.info("Java RMI registry started at port " + configuredRegistryPort);

		} catch (RemoteException e) {
			LocateRegistry.getRegistry(configuredRegistryPort);
			logger.info("Java RMI registry already running at port " + configuredRegistryPort);
		}

		// Create registry binding service if it doesn't exist yet
		try {
			Naming.lookup("//" + configuredRemoteAddr + ":" + configuredRegistryPort + "/" + PCM_RMI_REGISTRY);

			logger.info("RMI binding service already running");

		} catch (MalformedURLException e) {			
		} catch (NotBoundException e) {
			logger.info("Starting RMI binding service");

			try {
				String bindingName = "//" + configuredRemoteAddr + ":" + configuredRegistryPort + "/" + PCM_RMI_REGISTRY;
//				String bindingName = PCM_RMI_REGISTRY;
				Naming.bind(bindingName, this);
				
				logger.info("RMI binding service bound as " + bindingName);
			} catch (MalformedURLException e2) {
				logger.error("RMI registry failed: Malformed URL", e2);
			} catch (AlreadyBoundException e2) {
				logger.error("RMI registry failed: Registry already bound on this port", e2);
			}
			
			try {
				String bindingName = "//" + configuredRemoteAddr + ":" + configuredRegistryPort + "/" + PCM_EXPERIMENT_MANAGER_REGISTRY;
				Naming.bind(bindingName, this);
				
				logger.info("Experiment Manager service bound as " + bindingName);
			} catch (MalformedURLException e2) {
				logger.error("Experiment Manager service failed: Malformed URL", e2);
			} catch (AlreadyBoundException e2) {
				logger.error("Experiment Manager service failed: Service already bound on this port", e2);
			}
		}
	}

	@Override
	public void bindPort(String name, Remote portClass) throws RemoteException {
		String bindingName = "//" + getRemoteAddress() + ":" + getRegistryPort() + "/" + name;
//		String bindingName = name;
		logger.info("Binding " + name + " to RMI registry as " + bindingName);
		try {
			java.rmi.Naming.rebind(bindingName, portClass);
		} catch (MalformedURLException e) {
			logger.error("RMI registry failed", e);
		}
	}

	public static void startRegistry() {
		if (singleton == null) {
			try {
				singleton = new RmiRegistry();
			} catch (RemoteException e) {
				logger.error("RMI registry failed", e);
			}
		}
	}

	/**
	 * Registers a port to a RMI registry at the given IP. This method remotely calls bindPort. 
	 * 
	 * @param registryIP
	 *            IP of the registry
	 * @param port
	 *            instance of the port
	 * @param portName
	 *            unique name of the port, using assembly context
	 */
	public static void registerPort(String registryIP, int registryPort, java.rmi.Remote component, String componentName) {

		try {
			Registry reg = LocateRegistry.getRegistry(registryIP, registryPort);

			logger.info("Located Java RMI Registy at " + registryIP + ":" + registryPort + ", " + reg);
			
			de.uka.ipd.sdq.prototype.framework.registry.IRmiRegistry pcmRegistry = null;

			String bindingName = PCM_RMI_REGISTRY;
//			String bindingName = "//" + configuredRemoteAddr + ":" + configuredRegistryPort + "/" + PCM_RMI_REGISTRY;

			while (true) {
				try {
					pcmRegistry = (IRmiRegistry) reg.lookup(bindingName);
					pcmRegistry.bindPort(componentName, component);
					break;
				} catch (ServerException e) {
					logger.error("Server Error: Check marshalling/serialization of your model!", e);
					break;
				} catch (RemoteException e) {
					logger.info("RMI registry (" + bindingName + ") at " + registryIP + ":" + registryPort + " not found. Next attempt in 3 seconds.");
					Thread.sleep(3000);
				} catch (NotBoundException e) {
					logger.info("RMI binding service (" + bindingName + ") at " + registryIP + ":" + registryPort + " not found. Next attempt in 3 seconds.");
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
	 * 
	 * @param args
	 * @return
	 */
	public static String getIpFromArguments(String[] args) {
		if (args != null && args.length > 0 && args[0] != null && !args[0].equals("")) {
			return args[0];
		}
		return LOCALHOST;
	}

	/**
	 * Returns an port number from an argument string array or 1099 instead
	 * 
	 * @param args
	 * @return
	 */
	public static int getPortFromArguments(String[] args) {
		if (args != null && args.length > 1 && args[1] != null && !args[1].equals("")) {
			return Integer.parseInt(args[1]);
		}
		return Registry.REGISTRY_PORT;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Remote lookup(String name) {
		Remote result = null;

		logger.info("RMI lookup for: " + name);

		if (getRemoteAddress() == null) {
			logger.error("Remote address of RMI registry not defined.");
			return null;
		}

		String addr = "//" + getRemoteAddress() + ":" + getRegistryPort() + "/" + name;

		while (true) {
			try {
				result = java.rmi.Naming.lookup(addr);

			} catch (java.net.MalformedURLException e) {
				logger.error("Remote URI malformed. This should never happen, strange model names used? (" + addr + ")");
			} catch (java.rmi.RemoteException e) {
				logger.error("Error while waiting for system. (" + addr + ")" + e);
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

	public static String getRemoteAddress() {
		return configuredRemoteAddr;
	}

	public static void setRemoteAddress(String configuredRemoteAddr) {
		assert(configuredRemoteAddr != null);
		RmiRegistry.configuredRemoteAddr = configuredRemoteAddr;
	}
	
	public static int getRegistryPort() {
		return configuredRegistryPort;
	}

	public static void setRegistryPort(int configuredRegistryPort) {
		RmiRegistry.configuredRegistryPort = configuredRegistryPort;
	}

	public static void main(String[] args) {
		startRegistry();

		logger.info("RMI registry started on port " + configuredRegistryPort);

		// Dirty fix to keep this java process alive...
		new Thread() {
			public void run() {
				Scanner input = new Scanner(System.in);
				if (input.hasNext()) {
					input.nextLine();
				}
			}
		}.run();
	}

	@Override
	public void bindExperimentManager(IExperimentManager experimentManager)
			throws RemoteException {
		
		experimentManagers.add(experimentManager);
		logger.info("Added " + experimentManager.getName() + " to associated experiment managers");
	}
	

	@Override
	public List<IExperimentManager> getExperimentManagers() {
		return experimentManagers;
	}
}
