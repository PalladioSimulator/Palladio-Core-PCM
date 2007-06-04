package de.uka.ipd.sdq.simucomframework.model;

import java.util.Date;

import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.ResouceRegistry;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.sensors.SensorFactory;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;
import desmoj.core.simulator.Model;

public class SimuComModel extends Model {

	protected ResouceRegistry resourceRegistry = null;
	protected SensorFactory sensorFactory = null;
	private IWorkloadDriver[] workloadDrivers;
	private SimuComStatus status = SimuComStatus.OK;
	private String errorMessage = "";
	private SimuComConfig config;
	private Experiment experiment = null;
	private ExperimentRun run = null;
	private IDAOFactory daoFactory;
	
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

	public void initialiseResourceContainer(IResourceContainerFactory resourceContainerFactory) {
		for (String id : resourceContainerFactory.getResourceContainerIDList()) {
			SimulatedResourceContainer rc = resourceRegistry.createResourceContainer(id);
			resourceContainerFactory.fillResourceContainer(rc);
		}
		resourceRegistry.activateAllActiveResources();
	}

	public void setStatus(SimuComStatus error, String message) {
		this.status = error;
		this.errorMessage = message;
	}
	
	public SimuComStatus getErrorStatus(){
		return status;
	}
	
	public String getErrorMessage(){
		return this.errorMessage;
	}

	public SimuComConfig getConfig() {
		return config;
	}

	public void setConfig(SimuComConfig config) {
		this.config = config;
		this.daoFactory = SensorFrameworkDataset.singleton().getMemoryDataset(); 
		if (daoFactory.createExperimentDAO().findByExperimentName(this.getConfig().getNameExperimentRun()).size() == 1){
			experiment = daoFactory.createExperimentDAO().findByExperimentName(this.getConfig().getNameExperimentRun()).
							iterator().next();
		} else {
			experiment = daoFactory.createExperimentDAO().addExperiment(
				this.getConfig().getNameExperimentRun());
		}
		run = experiment.addExperimentRun("Run "+new Date());
	}

	public IDAOFactory getDAOFactory(){
		return this.daoFactory;
	}
	
	public Experiment getExperimentDatastore() {
		return experiment;
	}

	public ExperimentRun getCurrentExperimentRun() {
		return run;
	}
}
