package de.uka.ipd.sdq.simucom;

import java.util.ArrayList;

import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simucom.resources.SimulatedResources;
import de.uka.ipd.sdq.simucom.sensors.SensorFactory;
import de.uka.ipd.sdq.simucom.usage.SimulatedUsageScenario;
import desmoj.core.simulator.Model;

public class SimuComModel extends Model {

	protected ModelSetup setup;
	protected String configFile = null;
	protected SimulatedResources resources = null;
	protected SensorFactory sensorFactory = null;
	
	public SimuComModel(Model owner, String myName, boolean showInReport, boolean showInTrace, String configFile) {
		super(owner, myName, showInReport, showInTrace);
		this.configFile = configFile;
		DistributionObjectsStorage.getSingletonInstance().initializeModel(this);
		sensorFactory = new SensorFactory(this);
	}

	@Override
	public String description() {
		return "SimuCom Simulation";
	}

	@Override
	public void doInitialSchedules() {
		resources.activateAllActiveResources();
		for (UsageScenario u : setup.getScenarios())
		{
			SimulatedUsageScenario simulatedScenario = new SimulatedUsageScenario(u, this);
			simulatedScenario.init();
		}
	}

	@Override
	public void init() {
		setup =  new ModelSetup(this, configFile);
		resources = new SimulatedResources(this, setup.getResourceEnvironment());
	}

	public ArrayList<UsageScenario> getUsageScenarios()
	{
		return setup.getScenarios();
	}
	
	public de.uka.ipd.sdq.pcm.system.System getSystem()
	{
		return setup.getSystem();
	}
	
	public SimulatedResources getSimulatedResources()
	{
		return resources;
	}
	
	public SensorFactory getSensorFactory()
	{
		return sensorFactory;
	}
}
