package de.uka.ipd.sdq.simucomframework.model;

import java.util.Date;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.ResourceRegistry;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEngineFactory;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimulationControlDelegate;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;

/**
 * Central simulation class needed by desmoj. Keeps the simulation state
 * which is not part of the context of threads
 * @author Steffen Becker
 *
 */
public class SimuComModel {

	protected ResourceRegistry resourceRegistry = null;
	private IWorkloadDriver[] workloadDrivers;
	private SimuComStatus status = SimuComStatus.OK;
	private Throwable errorMessage = null;
	private SimuComConfig config;
	private Experiment experiment = null;
	private ExperimentRun run = null;
	private IDAOFactory daoFactory;
	private long mainMeasurementsCount;
	private ISimEngineFactory simulationEngineFactory;
	private ISimulationControlDelegate simControl;
	
	public SimuComModel(SimuComConfig config, ISimEngineFactory factory) {
		this.config = config;
		this.simulationEngineFactory = factory;
		this.simControl = factory.createSimulationControl(this);
		resourceRegistry = new ResourceRegistry(this);
		initialiseNewSensorframework(config);
	}

	public void doInitialSchedules() {
		for (IWorkloadDriver w : workloadDrivers)
		{
			w.run();
		}
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
	
	public ISimulationControlDelegate getSimulationControl() {
		return simControl;
	}

	public void setSimulationControl(ISimulationControlDelegate control) {
		this.simControl = control;
	}

	public void setSimulationEngineFactory(
			ISimEngineFactory factory) {
		this.simulationEngineFactory = factory;
	}

	public ISimEngineFactory getSimEngineFactory() {
		return this.simulationEngineFactory;
	}
}
