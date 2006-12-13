package de.uka.ipd.sdq.simucomframework;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;

public abstract class AbstractMain {
	private SimuComModel model = null;

	protected void run()
	{
		model = 
			SimuComFactory.getSimuComModel( 
                "SimuCom Model", true, true);
		model.setUsageScenarios(getWorkloads());
		ExperimentRunner.run(model, 150000000);
	}
	
	protected SimuComModel getModel() {
		return model;
	}
	
	protected abstract IWorkloadDriver[] getWorkloads();
}
