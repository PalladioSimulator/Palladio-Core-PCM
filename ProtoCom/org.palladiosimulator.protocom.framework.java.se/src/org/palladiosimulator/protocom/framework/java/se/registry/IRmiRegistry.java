package org.palladiosimulator.protocom.framework.java.se.registry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.palladiosimulator.protocom.framework.java.se.experiment.IExperimentManager;

public interface IRmiRegistry extends java.rmi.Remote {
    /**
     * Default name of the registry service.
     */
    public static final String PCM_RMI_REGISTRY = "PCM_RMI_REGISTRY";

    /**
     * Default name of the experiment manager service.
     */
    public static final String PCM_EXPERIMENT_MANAGER_REGISTRY = "PCM_EXPERIMENT_MANAGER_REGISTRY";

    /**
     * Binds the calling port to the registry.
     * 
     * @param name
     *            name of the port, including assembly context.
     * @param port
     *            the port
     * @throws RemoteException
     */
    public void bindPort(String name, Remote port) throws RemoteException;

    /**
     * Binds the calling experiment manager to the registry.
     * 
     * @param experimentManager
     *            the manager
     * @throws RemoteException
     */
    public void bindExperimentManager(IExperimentManager experimentManager) throws RemoteException;

    /**
     * Returns the list of associated experiment managers.
     * 
     * @return
     * @throws RemoteException
     */
    public List<IExperimentManager> getExperimentManagers() throws RemoteException;

}
