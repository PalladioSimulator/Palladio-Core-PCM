package de.uka.ipd.sdq.simucom.usage;

import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.simucom.SimuComModel;
import desmoj.core.simulator.SimTime;

public class SimulatedUsageScenario
{
	protected UsageScenario myScenario = null;	
	protected SimuComModel myModel = null;
	
	public SimulatedUsageScenario(UsageScenario myScenario, SimuComModel model) {
		this.myScenario = myScenario;
		this.myModel = model;
	}
	
	public void init()
	{
		if (myScenario.getWorkload_UsageScenario().eClass() == UsagemodelPackage.eINSTANCE.getClosedWorkload())
		{
			initialiseClosedWorkload();
		}
		else
		{
			initialiseOpenWorkload();
		}
	}

	private void initialiseOpenWorkload() {
		OpenWorkload load = (OpenWorkload)myScenario.getWorkload_UsageScenario();
		String baseName = "Scenario "+myScenario.getEntityName();
		OpenWorkloadDriver driver = new OpenWorkloadDriver(load, myModel, baseName , true);
		driver.activate(SimTime.NOW);
	}

	private void initialiseClosedWorkload() {
		ClosedWorkload load = (ClosedWorkload) myScenario.getWorkload_UsageScenario();
		String baseName = "Scenario "+myScenario.getEntityName();
		
		for (int i=0; i<load.getPopulation(); i++)
		{
			ClosedWorkloadDriver driver = new ClosedWorkloadDriver(myModel, baseName + "- (simulated) user #"+(i+1), true);
			driver.init(load, myScenario.getScenarioBehaviour_UsageScenario());
			driver.activateNow();
		}
	}
}