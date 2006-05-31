package de.uka.ipd.sdq.simucom;

import java.util.Vector;

import UsageModelPackage.UsageScenario;

import de.uka.ipd.sdq.simucom.ui.UsageScenarioResponseTimeMonitor;
import de.uka.ipd.sdq.simucom.usage.SimulatedUsageScenario;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

public class SimuComModel extends Model {

	protected ModelSetup setup;
	protected String configFile = null;
	protected DistributionObjectsStorage distributionStorage = null;
	protected Vector<UsageScenario> usageScenarios = null;
	
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
		for (UsageScenario u : usageScenarios)
		{
			SimulatedUsageScenario simulatedScenario = 
				new SimulatedUsageScenario(u, getModel(), true);
			simulatedScenario.activate(new SimTime(0));
			new UsageScenarioResponseTimeMonitor(simulatedScenario);
		}
	}

	@Override
	public void init() {
		setup =  new ModelSetup(this, configFile);
		usageScenarios = setup.getScenarios();
	}

	public DistributionObjectsStorage getDistributionObjectsStorage()
	{
		return distributionStorage;
	}
}
