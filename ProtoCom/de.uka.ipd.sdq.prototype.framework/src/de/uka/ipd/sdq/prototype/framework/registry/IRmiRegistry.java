package de.uka.ipd.sdq.prototype.framework.registry;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRmiRegistry extends java.rmi.Remote
{
	/**
	 * Default name of the registry service.
	 */
	public static final String PCM_RMI_REGISTRY = "PCM_RMI_Registry";
	
	/**
	 * Binds the calling port to the registry.
	 * 
	 * @param name		name of the port, including assembly context.
	 * @param port		the port
	 * @throws RemoteException
	 */
	public void bindPort(String name, Remote port) throws RemoteException;
	
}