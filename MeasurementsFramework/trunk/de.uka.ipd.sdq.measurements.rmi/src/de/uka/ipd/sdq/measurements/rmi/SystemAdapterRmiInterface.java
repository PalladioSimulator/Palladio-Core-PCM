package de.uka.ipd.sdq.measurements.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SystemAdapterRmiInterface extends Remote {
	
	/**
	 * Signalize the System Adapter that an experiment execution is finished.
	 * 
	 * @throws RemoteException
	 */
	//void experimentCompleted(HashMap<Integer, ArrayList<RmiResult>> allResults) throws RemoteException;
	void experimentCompleted(ExperimentResult experimentResult, int rootTaskId) throws RemoteException;
	
	/**
	 * This method is called by the driver if it is shut down.
	 * 
	 * @throws RemoteException
	 */
	void driverShutdown() throws RemoteException;

}
