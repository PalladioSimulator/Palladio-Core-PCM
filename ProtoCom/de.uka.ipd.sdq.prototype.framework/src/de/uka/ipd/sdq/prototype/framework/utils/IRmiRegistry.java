package de.uka.ipd.sdq.prototype.framework.utils;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRmiRegistry extends java.rmi.Remote
{
	public static final String PCM_RMI_REGISTRY = "PCM_RMI_Registry";
	
	public abstract void bindComponent(String name, Remote component) throws RemoteException;
	
}