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
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;

/**
 * Base class for simulation instances. It contains a generic simulation start
 * and stop logic as well as basic error handling mechanisms
 * @author Steffen Becker
 *
 */
public abstract class AbstractMain {
	private SimuComModel model = null;
	private static Logger logger = 
		Logger.getLogger(AbstractMain.class.getName());

	/**
	 * Run a simulation using the given configuration and report to the given
	 * observer
	 * @param statusObserver Observer to notify about the simulation's progress
	 * @param config Configuration options for the simulation
	 * @return A status code indicating success or failure of the simulation
	 */
	protected SimuComStatus run(final IStatusObserver statusObserver, SimuComConfig config)
	{
		initializeLogger(config);
		
		final long SIM_STOP_TIME = config.getSimuTime();
		
		model = 
			SimuComFactory.getSimuComModel( 
                "SimuCom Model", true, true);
		model.setConfig(config);
		model.initialiseResourceContainer(getResourceContainerFactory());
		model.setUsageScenarios(getWorkloads());
		model.getExperiment().getSimClock().addObserver(new Observer(){

			public void update(Observable clock, Object data) {
				statusObserver.updateStatus(
						(int)(model.currentTime().getTimeValue() * 100 / SIM_STOP_TIME));
			}
			
		});
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
		model.getExperiment().stop();
	}
	
	/**
	 * @return The simucom model used in this simulation run
	 */
	protected SimuComModel getModel() {
		return model;
	}
	
	/**
	 * @return An error object in case an exception occured during simulation 
	 * execution
	 */
	public Throwable getErrorThrowable(){
		return model.getErrorThrowable();
	}

	public de.uka.ipd.sdq.simucomframework.SimuComStatus startSimulation(
			de.uka.ipd.sdq.simucomframework.SimuComConfig config, de.uka.ipd.sdq.simucomframework.IStatusObserver observer) {
		return run(observer,config);
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
}
