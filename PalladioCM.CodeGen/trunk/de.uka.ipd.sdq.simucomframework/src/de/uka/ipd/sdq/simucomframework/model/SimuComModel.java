package de.uka.ipd.sdq.simucomframework.model;

import de.uka.ipd.sdq.simucomframework.IUsageScenario;
import de.uka.ipd.sdq.simucomframework.ResouceRegistry;
import de.uka.ipd.sdq.simucomframework.sensors.SensorFactory;
import desmoj.core.simulator.Model;

public class SimuComModel extends Model {

	protected ResouceRegistry resourceRegistry = null;
	protected SensorFactory sensorFactory = null;
	private IUsageScenario[] usageScenarios;
	
	public SimuComModel(Model owner, String myName, boolean showInReport, boolean showInTrace) {
		super(owner, myName, showInReport, showInTrace);
		// DistributionObjectsStorage.getSingletonInstance().initializeModel(this);
		sensorFactory = SensorFactory.singleton();
		sensorFactory.setModel(this);
		resourceRegistry = new ResouceRegistry(this);
	}

	@Override
	public String description() {
		return "SimuCom Simulation";
	}

	@Override
	public void doInitialSchedules() {
		resourceRegistry.activateAllActiveResources();
		for (IUsageScenario u : usageScenarios)
		{
			u.doInitialSchedules();
		}
	}

	@Override
	public void init() {
	}
	
	public void setUsageScenarios(IUsageScenario[] scenarios)
	{
		this.usageScenarios = scenarios;
	}

	public ResouceRegistry getResourceRegistry() {
		return resourceRegistry;
	}

	public SensorFactory getSensorFactory() {
		return sensorFactory;
	}
}
