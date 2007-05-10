package de.uka.ipd.sdq.simucomframework;
import java.util.Observable;
import java.util.Observer;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;

public abstract class AbstractMain {
	private static final long SIM_STOP_TIME = 1500000;
	private SimuComModel model = null;

	protected SimuComStatus run(final IStatusObserver statusObserver)
	{
		model = 
			SimuComFactory.getSimuComModel( 
                "SimuCom Model", true, true);
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
