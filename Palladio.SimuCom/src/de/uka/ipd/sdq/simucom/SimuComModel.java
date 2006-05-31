package de.uka.ipd.sdq.simucom;

import java.util.ArrayList;

import UsageModelPackage.UsageScenario;
import de.uka.ipd.sdq.simucom.ui.UsageScenarioResponseTimeMonitor;
import de.uka.ipd.sdq.simucom.usage.SimulatedUsageScenario;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

public class SimuComModel extends Model {

	protected ModelSetup setup;
	protected String configFile = null;
	protected DistributionObjectsStorage distributionStorage = null;
	
	public SimuComModel(Model owner, String myName, boolean showInReport, boolean showInTrace, String configFile) {
		super(owner, myName, showInReport, showInTrace);
		this.configFile = configFile;
		this.distributionStorage = new DistributionObjectsStorage(this);
	}

	@Override
	public String description() {
		return "SimuCom Simulation";
	}

	@Override
	public void doInitialSchedules() {
		for (UsageScenario u : setup.getScenarios())
		{
			SimulatedUsageScenario simulatedScenario = 
				new SimulatedUsageScenario(u, this, true);
			simulatedScenario.activate(new SimTime(0));
			simulatedScenario.getResponseTimeSensor().addObserver(new UsageScenarioResponseTimeMonitor(simulatedScenario));
		}
	}

	@Override
	public void init() {
		setup =  new ModelSetup(this, configFile);
	}

	public DistributionObjectsStorage getDistributionObjectsStorage()
	{
		return distributionStorage;
	}
	
	public ArrayList<UsageScenario> getUsageScenarios()
	{
		return setup.getScenarios();
	}
	
	public SystemPackage.System getSystem()
	{
		return setup.getSystem();
	}
}
