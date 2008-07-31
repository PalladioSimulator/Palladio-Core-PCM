package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;



/**
 * Control interface for the SimuCom Framework. It defines methods, which are responsible
 * for starting and stopping the simulation.
 * 
 * The code generated for each SimuCom instance contains the class 
 * main.SimuComControl that implements this interface and provides the 
 * missing information. 
 * 
 * Excerpt from main.SimuComControl:
 * public class SimuComControl extends
 * 		de.uka.ipd.sdq.simucomframework.AbstractMain implements
 * 		de.uka.ipd.sdq.simucomframework.ISimuComControl,
 * 		org.osgi.framework.BundleActivator {
 * 
 * @author Roman Andrej
 * 		   Steffen Becker
 */
public interface ISimuComControl {

	/** Start a simulation run
	 * @param config The configuration object which sets many simulation parameters like stop conditions, storage location, etc.
	 * @param statusObserver An observer which gets notifications on the simulation progress
	 * @param useOwnSensorstorage If true, the simulation uses an own, temporary result store instead of the sensorfactory
	 * storage passed in the simulation parameter object. Use this for remote simulation docks which do not have access to the
	 * local sensor factory storages
	 * @return The result of the simulation run
	 */
	public SimuComResult startSimulation(SimuComConfig config, IStatusObserver statusObserver, boolean useOwnSensorstorage);
	
	/**
	 * Cancels a running simulation 
	 */
	public void stopSimulation();
	
	/**
	 * Returns an exception which caused the simulation to terminate in case of simulation errors
	 * @return The exception which caused the simulation to terminate
	 */
	public Throwable getErrorThrowable();

	public SimuComStatus getStatus();
}
