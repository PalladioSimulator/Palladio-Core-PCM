package de.uka.ipd.sdq.simucomframework.model;

import java.util.Date;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.ResourceRegistry;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;
import desmoj.core.simulator.Model;

/**
 * Central simulation class needed by desmoj. Keeps the simulation state
 * which is not part of the context of threads
 * @author Steffen Becker
 *
 */
public class SimuComModel extends Model {

	protected ResourceRegistry resourceRegistry = null;
	private IWorkloadDriver[] workloadDrivers;
	private SimuComStatus status = SimuComStatus.OK;
	private Throwable errorMessage = null;
	private SimuComConfig config;
	private Experiment experiment = null;
	private ExperimentRun run = null;
	private IDAOFactory daoFactory;
	private long mainMeasurementsCount;
	
	public SimuComModel(Model owner, String myName, boolean showInReport, boolean showInTrace) {
		super(owner, myName, showInReport, showInTrace);
		resourceRegistry = new ResourceRegistry(this);
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.Model#description()
	 */
	@Override
	public String description() {
		return "SimuCom Simulation";
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.Model#doInitialSchedules()
	 */
	@Override
	public void doInitialSchedules() {
		for (IWorkloadDriver w : workloadDrivers)
		{
			w.run();
		}
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.Model#init()
	 */
	@Override
	public void init() {
	}
	
	/**
	 * Add the given usage scenarios to this simulation run
	 * @param workload Usage scenarios to execute during this
	 * simulation run
	 */
	public void setUsageScenarios(IWorkloadDriver[] workload)
	{
		this.workloadDrivers = workload;
	}

	/**
	 * @return The resource registry storing all simulated resources and
	 * their states
	 */
	public ResourceRegistry getResourceRegistry() {
		return resourceRegistry;
	}

	/**
	 * Create this simulation run's resources using the resource factory given.
	 * The factory is queried for the list of IDs of the resources to create and
	 * creates and inialises each of them
	 * @param resourceContainerFactory The resource factory used to initialse the simulated
	 * resources
	 */
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

	/**
	 * Set the simulation result
	 * @param error The new status
	 * @param t The exception message if any, null otherwise
	 */
	public void setStatus(SimuComStatus error, Throwable t) {
		this.status = error;
		this.errorMessage = t;
	}
	
	/**
	 * @return The simulation status
	 */
	public SimuComStatus getErrorStatus(){
		return status;
	}
	
	/**
	 * @return The exception caused during the last simulation run. Null
	 * if there was no such exception
	 */
	public Throwable getErrorThrowable(){
		return this.errorMessage;
	}

	/**
	 * @return The configuration settings of this simulation model instance
	 */
	public SimuComConfig getConfig() {
		return config;
	}

	/**
	 * Set the configuration of this simulation model. Initialse the model
	 * to the parameters given.
	 * @param config The simulation parameters to use during execution of
	 * the simulation
	 */
	public void setConfig(SimuComConfig config) {
		this.config = config;
		initialiseNewSensorframework(config);
	}

	private void initialiseNewSensorframework(SimuComConfig config) {
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

	/**
	 * @return The datasource of the sensorframework used to record simulation
	 * run results
	 */
	public IDAOFactory getDAOFactory(){
		return this.daoFactory;
	}
	
	/**
	 * @return The sensorframworks experiment object used to store simulation results
	 */
	public Experiment getExperimentDatastore() {
		return experiment;
	}

	/**
	 * @return Experiment run of the sensorframework used to record simulation results
	 */
	public ExperimentRun getCurrentExperimentRun() {
		return run;
	}

	public void increaseMainMeasurementsCount(){
		mainMeasurementsCount++;
	}
	
	public long getMainMeasurementsCount() {
		return mainMeasurementsCount;
	}
}
