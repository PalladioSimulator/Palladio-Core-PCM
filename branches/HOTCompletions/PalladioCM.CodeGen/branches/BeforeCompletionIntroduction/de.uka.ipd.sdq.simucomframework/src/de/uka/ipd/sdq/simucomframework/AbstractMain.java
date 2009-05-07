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

public abstract class AbstractMain {
	private SimuComModel model = null;
	private static Logger logger = 
		Logger.getLogger(AbstractMain.class.getName());

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

	protected void stop() {
		model.getExperiment().stop();
	}
	
	protected SimuComModel getModel() {
		return model;
	}
	
	public String getErrorMessage(){
		return model.getErrorMessage();
	}
	
	protected abstract IWorkloadDriver[] getWorkloads();
	protected abstract IResourceContainerFactory getResourceContainerFactory();
}
