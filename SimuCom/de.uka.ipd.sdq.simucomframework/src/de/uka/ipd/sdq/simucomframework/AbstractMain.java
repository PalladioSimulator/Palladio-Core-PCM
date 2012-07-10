package de.uka.ipd.sdq.simucomframework;

import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.errorhandling.dialogs.issues.DisplayIssuesDialog;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.simulation.IStatusObserver;
import de.uka.ipd.sdq.simulation.SimulationResult;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.preferences.SimulationPreferencesHelper;

/**
 * Base class for simulation instances. It contains a generic simulation start
 * and stop logic as well as basic error handling mechanisms.
 * 
 * The code generated for each SimuCom instance contains the class
 * main.SimuComControl that inherits from this one and provides the missing
 * information.
 * 
 * Excerpt from main.SimuComControl: public class SimuComControl extends
 * de.uka.ipd.sdq.simucomframework.AbstractMain
 * 
 * @author Steffen Becker
 * 
 */
public abstract class AbstractMain implements de.uka.ipd.sdq.simulation.ISimulationControl,
		org.osgi.framework.BundleActivator {

	// Service registry entry for registering this object in Eclipse's service
	// registry where
	// it can be found by the simulation runner
	private org.osgi.framework.ServiceRegistration serviceRegistryEntry;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	@SuppressWarnings("unchecked")
	public void start(org.osgi.framework.BundleContext context) throws Exception {
		// register the service
		serviceRegistryEntry = context.registerService(de.uka.ipd.sdq.simulation.ISimulationControl.class
				.getName(), this, new java.util.Hashtable());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(org.osgi.framework.BundleContext context) throws Exception {
		serviceRegistryEntry.unregister();
	}

	private SimuComModel model = null;
	private SimuComStatus simuComStatus;
	private static Logger logger = Logger.getLogger(AbstractMain.class.getName());

	/**
	 * Run a simulation using the given configuration and report to the given
	 * observer
	 * 
	 * @param statusObserver
	 *            Observer to notify about the simulation's progress
	 * @param config
	 *            Configuration options for the simulation
	 * @param isRemoteRun
	 *            True if this simulation runs remotely and has no access to the
	 *            local sensorframework
	 * @return A status code indicating success or failure of the simulation
	 */
	protected SimulationResult run(final IStatusObserver statusObserver, SimuComConfig config, boolean isRemoteRun) {

		if(logger.isEnabledFor(Level.INFO))
			logger.info("Starting Simulation");

		final long SIM_STOP_TIME = config.getSimuTime();

		model.getSimulationControl().addTimeObserver(new Observer() {

			public void update(Observable clock, Object data) {
				int timePercent = (int) (model.getSimulationControl().getCurrentSimulationTime() * 100 / SIM_STOP_TIME);
				int measurementsPercent = (int) (model.getMainMeasurementsCount() * 100 / model.getConfig()
						.getMaxMeasurementsCount());
				statusObserver.updateStatus(timePercent < measurementsPercent ? measurementsPercent : timePercent,
						model.getSimulationControl().getCurrentSimulationTime(), model.getMainMeasurementsCount());
			}

		});
		getStatus().setCurrentSimulationTime(0);
		double simRealTime = ExperimentRunner.run(model, SIM_STOP_TIME);
		model.getProbeSpecContext().finish();
		// check if there are accuracy influence analysis issues
		if (model.getIssues().size() > 0) {
			if(logger.isEnabledFor(Level.INFO))
				logger.info(model.getIssues().size() + " issues experience during the simulation run.");
			DisplayIssuesDialog runner = new DisplayIssuesDialog(model.getIssues());
			DisplayIssuesDialog.showDialogSync(runner);
		}

		if(logger.isEnabledFor(Level.INFO))
			logger.info("Simulation stopped. It took " + (simRealTime / Math.pow(10, 9))
				+ " seconds real time to terminate");

		// TODO
		// storeRunDescription(config.getExperimentRunDescriptor());

		model.getConfig().disposeRandomGenerator();
		return model.getErrorStatus();
	}

	/**
	 * TODO: Where to put this code?
	 * 
	 * If a sensitivity analysis has been conducted we need to store the current
	 * parameter values.
	 * 
	 * @param descriptor
	 * @param run
	 */
	// private void storeRunDescription(
	// ExperimentRunDescriptor descriptor) {
	// if (descriptor == null) return;
	//
	// // TODO: Save data in clean model after migration to EDP2
	// for(ParameterDescriptor p : descriptor.getParameters()){
	// TimeSpanSensor s = createSensor(p.getName());
	// storeValue(s, p.getValue());
	// }
	//
	// }
	//
	// private void storeValue(TimeSpanSensor s, double value) {
	// if (model.getCurrentExperimentRun() instanceof
	// SimuComExperimentRunDecorator){
	// SimuComExperimentRunDecorator erd = (SimuComExperimentRunDecorator)
	// model.getCurrentExperimentRun();
	// erd.addTimeSpanMeasurementAfterRun(s, 0, value);
	// }
	//
	// }
	//
	// private TimeSpanSensor createSensor(String name) {
	// return SensorHelper.createOrReuseTimeSensor(model.getDAOFactory(),
	// model.getExperimentDatastore(), name);
	// }

	/**
	 * Setup log4j
	 * 
	 * @param config
	 *            SimuCom config which is queried for the logging settings
	 */
	private void initializeLogger(SimuComConfig config) {
		Logger simuComLogger = Logger.getLogger("de.uka.ipd.sdq.simucomframework");
		if (config.getVerboseLogging())
			// Set to Level.ALL if verbose logging is enabled,
			simuComLogger.setLevel(Level.ALL);
		else {
			// Set to INFO if verbose level is not enabled but global logging
			// level
			// is lower than INFO, otherwise keep global level.
			// In this way the global logging settings
			// are kept if they are INFO, WARN or ERROR
			Level currentLevel = simuComLogger.getEffectiveLevel();
			if (!currentLevel.isGreaterOrEqual(Level.INFO)) {
				simuComLogger.setLevel(Level.INFO);
			}
		}
		if(logger.isDebugEnabled())
			logger.debug("Extended Simulation Logging enabled!");

		// Set this class' log level to info to see start and stop messages of
		// SimuCom
		logger.setLevel(Level.INFO);
	}

	/**
	 * Request a simulation stop
	 */
	protected void stop() {
		model.getSimulationControl().stop();
	}

	/**
	 * @return The simucom model used in this simulation run
	 */
	public SimuComModel getModel() {
		return model;
	}

	/**
	 * @return An error object in case an exception occurred during simulation
	 *         execution
	 */
	public Throwable getErrorThrowable() {
		return model.getErrorThrowable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.simucomframework.ISimuComControl#startSimulation(de.uka
	 * .ipd.sdq.simucomframework.SimuComConfig,
	 * de.uka.ipd.sdq.simucomframework.IStatusObserver, boolean)
	 */
    public void prepareSimulation(AbstractSimulationConfig config, IStatusObserver observer, boolean isRemoteRun) {
        // load factory for the preferred simulation engine
        ISimEngineFactory factory = SimulationPreferencesHelper.getPreferredSimulationEngine();
        if (factory == null) {
            throw new RuntimeException("There is no simulation engine available. Install at least one engine.");
        }
        
        // create simulation model
        model = new SimuComModel((SimuComConfig) config, getStatus(), factory, isRemoteRun);

        // initialse simulation model
        model.initialiseResourceContainer(getResourceContainerFactory());
        model.setUsageScenarios(getWorkloads((SimuComConfig) config));
        setupCalculators((SimuComConfig) config);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.simucomframework.ISimuComControl#startSimulation(de.uka
	 * .ipd.sdq.simucomframework.SimuComConfig,
	 * de.uka.ipd.sdq.simucomframework.IStatusObserver, boolean)
	 */
    public de.uka.ipd.sdq.simulation.SimulationResult startSimulation(AbstractSimulationConfig config,
            IStatusObserver observer, boolean isRemoteRun) {
        return run(observer, (SimuComConfig) config, isRemoteRun);
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.simucomframework.ISimuComControl#stopSimulation()
	 */
	public void stopSimulation() {
		stop();
	}

	/**
	 * Template method pattern. Child classes have to implement this to return
	 * workload drivers to use in the simulation. The workload drivers are used
	 * to generate the simulated users.
	 * 
	 * @param config
	 *            the simulation configuration data
	 * @return Workload drivers to use in the simulation run
	 */
	protected abstract IWorkloadDriver[] getWorkloads(SimuComConfig config);

	/**
	 * Template method to return a factory which can be used to instanciate the
	 * simulated resource environment.
	 * 
	 * @return A factory which is used to create the simulated resource
	 *         environment
	 */
	protected abstract IResourceContainerFactory getResourceContainerFactory();

	/**
	 * Template method. Child classes implement this method to set up
	 * {@link Calculator}s before the simulation begins.
	 * 
	 * @param config
	 *            the simulation configuration data
	 */
	protected abstract void setupCalculators(SimuComConfig config);

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.simucomframework.ISimuComControl#getStatus()
	 */
	public SimuComStatus getStatus() {
		if (this.simuComStatus == null) {
			this.simuComStatus = SimucomstatusFactory.eINSTANCE.createSimuComStatus();
			this.simuComStatus.setProcessStatus(SimucomstatusFactory.eINSTANCE.createSimulatedProcesses());
			this.simuComStatus.setResourceStatus(SimucomstatusFactory.eINSTANCE.createSimulatedResources());
		}
		return this.simuComStatus;
	}

}
