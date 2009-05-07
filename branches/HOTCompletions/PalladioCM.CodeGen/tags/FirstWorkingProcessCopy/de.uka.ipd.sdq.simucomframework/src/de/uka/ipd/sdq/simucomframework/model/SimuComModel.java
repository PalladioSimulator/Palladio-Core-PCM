package de.uka.ipd.sdq.simucomframework.model;

import de.uka.ipd.sdq.simucomframework.ResouceRegistry;
import de.uka.ipd.sdq.simucomframework.sensors.SensorFactory;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;
import desmoj.core.simulator.Model;

public class SimuComModel extends Model {

	protected ResouceRegistry resourceRegistry = null;
	protected SensorFactory sensorFactory = null;
	private IWorkloadDriver[] workloadDrivers;
	
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
		for (IWorkloadDriver w : workloadDrivers)
		{
			w.run();
		}
	}

	@Override
	public void init() {
	}
	
	public void setUsageScenarios(IWorkloadDriver[] workload)
	{
		this.workloadDrivers = workload;
	}

	public ResouceRegistry getResourceRegistry() {
		return resourceRegistry;
	}

	public SensorFactory getSensorFactory() {
		return sensorFactory;
	}
}
