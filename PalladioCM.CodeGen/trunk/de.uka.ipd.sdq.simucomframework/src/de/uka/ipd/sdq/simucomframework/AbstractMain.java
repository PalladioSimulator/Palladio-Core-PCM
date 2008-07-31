package de.uka.ipd.sdq.simucomframework;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;

/**
 * Base class for simulation instances. It contains a generic simulation start
 * and stop logic as well as basic error handling mechanisms.
 * 
 * The code generated for each SimuCom instance contains the class 
 * main.SimuComControl that inherits from this one and provides the 
 * missing information. 
 * 
 * Excerpt from main.SimuComControl:
 * public class SimuComControl extends
 * 		de.uka.ipd.sdq.simucomframework.AbstractMain implements
 * 		de.uka.ipd.sdq.simucomframework.ISimuComControl,
 * 		org.osgi.framework.BundleActivator {
 * 	
 * 
 * @author Steffen Becker
 *
 */
public abstract class AbstractMain {
	private SimuComModel model = null;
	private boolean isRemoteRun = false;
	private SimuComStatus simuComStatus;
	private static Logger logger = 
		Logger.getLogger(AbstractMain.class.getName());

	/**
	 * Run a simulation using the given configuration and report to the given
	 * observer
	 * @param statusObserver Observer to notify about the simulation's progress
	 * @param config Configuration options for the simulation
	 * @param isRemoteRun True if this simulation runs remotely and has no access to the local sensorframework
	 * @return A status code indicating success or failure of the simulation
	 */
	protected SimuComResult run(final IStatusObserver statusObserver, SimuComConfig config, boolean isRemoteRun)
	{
		initializeLogger(config);
		
		this.isRemoteRun  = isRemoteRun;
		
		final long SIM_STOP_TIME = config.getSimuTime();
		
		model = 
			SimuComFactory.getSimuComModel(config,getStatus(),isRemoteRun); 
		model.initialiseResourceContainer(getResourceContainerFactory());
		model.setUsageScenarios(getWorkloads());
		model.getSimulationControl().addTimeObserver(new Observer(){

			public void update(Observable clock, Object data) {
				int timePercent = (int)(model.getSimulationControl().getCurrentSimulationTime() * 100 / SIM_STOP_TIME);
				int measurementsPercent = (int)(model.getMainMeasurementsCount() * 100 / model.getConfig().getMaxMeasurementsCount());
				statusObserver.updateStatus(
						timePercent < measurementsPercent ? measurementsPercent : timePercent,
						model.getSimulationControl().getCurrentSimulationTime(),
						model.getMainMeasurementsCount());
			}
			
		});
		getStatus().setCurrentSimulationTime(0);
		ExperimentRunner.run(model, SIM_STOP_TIME);
		return model.getErrorStatus();
	}
	
	/**
	 * Setup log4j
	 * @param config SimuCom config which is queried for the logging settings
	 */
	private void initializeLogger(SimuComConfig config) {
		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %m [%c]%n");
		ConsoleAppender myAppender = new ConsoleAppender(myLayout);
		if (config.getVerboseLogging())
			myAppender.setThreshold(Priority.DEBUG);
		else
			myAppender.setThreshold(Priority.WARN);
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure(myAppender);
		logger.debug("Simulation Logging enabled!");
		logger.info("Starting Simulation");
	}

	/**
	 * Request a simulation stop 
	 */
	protected void stop() {
		model.getSimulationControl().stop();
	}
	
	/**
	 * @return The simucom model used in this simulation run
	 */
	protected SimuComModel getModel() {
		return model;
	}
	
	/**
	 * @return An error object in case an exception occurred during simulation 
	 * execution
	 */
	public Throwable getErrorThrowable(){
		return model.getErrorThrowable();
	}

	public de.uka.ipd.sdq.simucomframework.SimuComResult startSimulation(
			de.uka.ipd.sdq.simucomframework.SimuComConfig config, de.uka.ipd.sdq.simucomframework.IStatusObserver observer,
			boolean isRemoteRun) {
		return run(observer,config,isRemoteRun);
	}	

	public void stopSimulation() {
		stop();
	}
	
	/**
	 * Template method pattern. Child classes have to implement this to
	 * return workload drivers to use in the simulation. The workload
	 * drivers are used to generate the simulated users. 
	 * @return Workload drivers to use in the simulation run
	 */
	protected abstract IWorkloadDriver[] getWorkloads();
	
	/**
	 * Template method to return a factory which can be used to instanciate the
	 * simulated resource environment.
	 * @return A factory which is used to create the simulated resource environment
	 */
	protected abstract IResourceContainerFactory getResourceContainerFactory();
	
	public SimuComStatus getStatus() {
		if (this.simuComStatus == null) {
			this.simuComStatus = SimucomstatusFactory.eINSTANCE.createSimuComStatus();
			this.simuComStatus.setProcessStatus(SimucomstatusFactory.eINSTANCE.createSimulatedProcesses());
			this.simuComStatus.setResourceStatus(SimucomstatusFactory.eINSTANCE.createSimulatedResources());
		}
		return this.simuComStatus;
	}
	
}
