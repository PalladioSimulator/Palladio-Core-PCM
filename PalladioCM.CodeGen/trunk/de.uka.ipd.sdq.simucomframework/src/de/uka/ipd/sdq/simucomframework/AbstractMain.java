package de.uka.ipd.sdq.simucomframework;
import java.util.Observable;
import java.util.Observer;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;

public abstract class AbstractMain {
	private static final long SIM_STOP_TIME = 150000;
	private SimuComModel model = null;

	protected void run(final IStatusObserver statusObserver)
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
	}
	
	protected SimuComModel getModel() {
		return model;
	}
	
	protected abstract IWorkloadDriver[] getWorkloads();
	protected abstract IResourceContainerFactory getResourceContainerFactory();
}
