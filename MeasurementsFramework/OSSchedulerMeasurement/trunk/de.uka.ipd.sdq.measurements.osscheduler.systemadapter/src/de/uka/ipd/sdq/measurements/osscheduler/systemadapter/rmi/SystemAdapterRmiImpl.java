package de.uka.ipd.sdq.measurements.osscheduler.systemadapter.rmi;

import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;

import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.ExperimentCompletedListener;
import de.uka.ipd.sdq.measurements.rmi.ExperimentResult;
import de.uka.ipd.sdq.measurements.rmi.SystemAdapterRmiInterface;

public class SystemAdapterRmiImpl implements SystemAdapterRmiInterface {

	//public void experimentCompleted(HashMap<Integer, ArrayList<RmiResult>> allResults) throws RemoteException {
	public void experimentCompleted(ExperimentResult experimentResult, int rootTaskId) throws RemoteException {
		fireExperimentCompleted(experimentResult, rootTaskId);
	}

	public void driverShutdown() throws RemoteException {
		System.out.println("Driver shutdown!");
	}
	
	//
	// Event handling
	//

	private transient Vector<ExperimentCompletedListener> experimentCompletedListeners;

	/** Register a listener for MasterModel events */
	synchronized public void addExperimentCompletedListener(
			ExperimentCompletedListener listener) {
		if (experimentCompletedListeners == null) {
			experimentCompletedListeners = new Vector<ExperimentCompletedListener>();
		}
		experimentCompletedListeners.addElement(listener);
	}

	synchronized public void removeExperimentCompletedListener(
			ExperimentCompletedListener listener) {
		if (experimentCompletedListeners == null) {
			experimentCompletedListeners = new Vector<ExperimentCompletedListener>();
		}
		experimentCompletedListeners.removeElement(listener);
	}

	/** Fire to all registered listeners */
	@SuppressWarnings("unchecked")
	//public void fireExperimentCompleted(HashMap<Integer, ArrayList<RmiResult>> allResults) {
	public void fireExperimentCompleted(ExperimentResult experimentResult, int rootTaskId) {
		// If we have no listeners, do nothing.
		if ((experimentCompletedListeners != null)
				&& !experimentCompletedListeners.isEmpty()) {

			// Make a copy of the listener list in case anyone adds or removes
			// listeners.
			Vector<ExperimentCompletedListener> targets;
			synchronized (experimentCompletedListeners) {
				targets = (Vector<ExperimentCompletedListener>) experimentCompletedListeners
						.clone();
			}

			// Walk through the listener list and call the listener method in
			// each.
			Enumeration<ExperimentCompletedListener> e = targets.elements();
			while (e.hasMoreElements()) {
				ExperimentCompletedListener l = (ExperimentCompletedListener) e
						.nextElement();
				l.experimentCompleted(experimentResult, rootTaskId);
			}
		}
	}

}
