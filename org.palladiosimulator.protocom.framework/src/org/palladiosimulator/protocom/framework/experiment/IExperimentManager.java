package org.palladiosimulator.protocom.framework.experiment;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface provides remote calls to Experiment Managers.
 * 
 * @author Thomas Zolynski
 */
public interface IExperimentManager extends Remote {

	public static final int EXPERIMENT_MANAGER_MASTER = 1;
	public static final int EXPERIMENT_MANAGER_SLAVE = 2;
	
	/**
	 * Start a new experiment run.
	 */
	public void startNewExperimentRun() throws RemoteException;
	
	/**
	 * Writes the experiment run to the specified DAO source.
	 */
	public void writeResultsAndClose() throws RemoteException;
	
	public String getName() throws RemoteException;

}