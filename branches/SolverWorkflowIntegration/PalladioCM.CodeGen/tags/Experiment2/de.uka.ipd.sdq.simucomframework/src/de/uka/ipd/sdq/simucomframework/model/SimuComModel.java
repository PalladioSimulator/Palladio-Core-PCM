package de.uka.ipd.sdq.simucomframework.model;

import java.util.Date;

import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.ResourceRegistry;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.sensors.SensorFactory;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;
import desmoj.core.simulator.Model;

public class SimuComModel extends Model {

	protected ResourceRegistry resourceRegistry = null;
	protected SensorFactory sensorFactory = null;
	private IWorkloadDriver[] workloadDrivers;
	private SimuComStatus status = SimuComStatus.OK;
	private Throwable errorMessage = null;
	private SimuComConfig config;
	private Experiment experiment = null;
	private ExperimentRun run = null;
	private IDAOFactory daoFactory;
	
	public SimuComModel(Model owner, String myName, boolean showInReport, boolean showInTrace) {
		super(owner, myName, showInReport, showInTrace);
		// DistributionObjectsStorage.getSingletonInstance().initializeModel(this);
		sensorFactory = new SensorFactory(this);
		resourceRegistry = new ResourceRegistry(this);
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

	public ResourceRegistry getResourceRegistry() {
		return resourceRegistry;
	}

	public SensorFactory getSensorFactory() {
		return sensorFactory;
	}

	public void initialiseResourceContainer(IResourceContainerFactory resourceContainerFactory) {
		for (String id : resourceContainerFactory.getResourceContainerIDList()) {
			SimulatedResourceContainer rc = (SimulatedResourceContainer) resourceRegistry.createResourceContainer(id);
			resourceContainerFactory.fillResourceContainer(rc);
		}
		for (String id : resourceContainerFactory.getLinkingResourceContainerIDList()) {
			SimulatedLinkingResourceContainer rc = (SimulatedLinkingResourceContainer) resourceRegistry.createLinkingResourceContainer(id);
			resourceContainerFactory.fillLinkingResourceContainer(rc);
		}
		resourceRegistry.activateAllActiveResources();
	}

	public void setStatus(SimuComStatus error, Throwable t) {
		this.status = error;
		this.errorMessage = t;
	}
	
	public SimuComStatus getErrorStatus(){
		return status;
	}
	
	public Throwable getErrorThrowable(){
		return this.errorMessage;
	}

	public SimuComConfig getConfig() {
		return config;
	}

	public void setConfig(SimuComConfig config) {
		this.config = config;
		this.daoFactory = SensorFrameworkDataset.singleton().getDataSourceByID(config.getDatasourceID()); 
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
