package de.uka.ipd.sdq.simucomframework;

import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import de.uka.ipd.sdq.errorhandling.dialogs.issues.DisplayIssuesDialog;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simucomframework.usage.IUserFactory;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.simulation.ISimulationControl;
import de.uka.ipd.sdq.simulation.ISimulationListener;
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
public abstract class AbstractMain
implements ISimulationControl, BundleActivator {

    // Service registry entry for registering this object in Eclipse's service
    // registry where
    // it can be found by the simulation runner
    private ServiceRegistration<ISimulationControl> serviceRegistryEntry;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        // register the service
        serviceRegistryEntry = context.registerService(
                ISimulationControl.class,
                this,
                new Hashtable<String,ISimulationControl>());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(final org.osgi.framework.BundleContext context) throws Exception {
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
    protected SimulationResult run(final IStatusObserver statusObserver, final SimuComConfig config, final boolean isRemoteRun) {

        if(logger.isEnabledFor(Level.INFO)) {
            logger.info("Starting Simulation");
            logger.info("Simulation engine used: "+model.getSimulationControl().getClass().getSimpleName());
        }

        final long SIM_STOP_TIME = config.getSimuTime();

        model.getConfiguration().addListener(new ISimulationListener() {

            @Override
            public void simulationStop() {
                model.getProbeSpecContext().finish();
            }

            @Override
            public void simulationStart() {}
        });

        model.getSimulationControl().addTimeObserver(new Observer() {

            @Override
            public void update(final Observable clock, final Object data) {
                final int timePercent = SIM_STOP_TIME < 0 ? 0 : (int) (model.getSimulationControl().getCurrentSimulationTime() * 100 / SIM_STOP_TIME);
                final int measurementsPercent = (int) (model.getMainMeasurementsCount() * 100 / model.getConfiguration()
                        .getMaxMeasurementsCount());
                statusObserver.updateStatus(timePercent < measurementsPercent ? measurementsPercent : timePercent,
                        model.getSimulationControl().getCurrentSimulationTime(), model.getMainMeasurementsCount());
            }

        });
        getStatus().setCurrentSimulationTime(0);
        final double simRealTime = ExperimentRunner.run(model);
        // check if there are accuracy influence analysis issues
        if (model.getIssues().size() > 0) {
            if(logger.isEnabledFor(Level.INFO)) {
                logger.info(model.getIssues().size() + " issues experience during the simulation run.");
            }
            final DisplayIssuesDialog runner = new DisplayIssuesDialog(model.getIssues());
            DisplayIssuesDialog.showDialogSync(runner);
        }

        if(logger.isEnabledFor(Level.INFO)) {
            logger.info("Simulation stopped. It took " + (simRealTime / Math.pow(10, 9))
                    + " seconds real time to terminate");
        }

        // TODO
        // storeRunDescription(config.getExperimentRunDescriptor());

        model.getConfiguration().disposeRandomGenerator();
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
    @Override
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
    @Override
    public void prepareSimulation(final AbstractSimulationConfig config, final IStatusObserver observer, final boolean isRemoteRun) {
        // load factory for the preferred simulation engine
        final ISimEngineFactory factory = SimulationPreferencesHelper.getPreferredSimulationEngine();
        if (factory == null) {
            throw new RuntimeException("There is no simulation engine available. Install at least one engine.");
        }

        // create simulation model
        model = new SimuComModel((SimuComConfig) config, getStatus(), factory, isRemoteRun);

        // initialse simulation model
        model.initialiseResourceContainer(getResourceContainerFactory());
        final IWorkloadDriver[] workloadDrivers = getWorkloads((SimuComConfig) config);
        attachUsageResponseTimeCalculators(workloadDrivers);
        model.setUsageScenarios(workloadDrivers);
    }

    private void attachUsageResponseTimeCalculators(final IWorkloadDriver[] workloadDrivers) {
        final ICalculatorFactory calculatorFactory = model.getProbeSpecContext().getCalculatorFactory();
        for (final IWorkloadDriver driver : workloadDrivers) {
            final IUserFactory userFactory = driver.getUserFactory();
            userFactory.attachResponseTimeCalculator();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.simucomframework.ISimuComControl#startSimulation(de.uka
     * .ipd.sdq.simucomframework.SimuComConfig,
     * de.uka.ipd.sdq.simucomframework.IStatusObserver, boolean)
     */
    @Override
    public de.uka.ipd.sdq.simulation.SimulationResult startSimulation(final AbstractSimulationConfig config,
            final IStatusObserver observer, final boolean isRemoteRun) {
        return run(observer, (SimuComConfig) config, isRemoteRun);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simucomframework.ISimuComControl#stopSimulation()
     */
    @Override
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
    // TODO: protected abstract void setupCalculators(SimuComConfig config);

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simucomframework.ISimuComControl#getStatus()
     */
    @Override
    public SimuComStatus getStatus() {
        if (this.simuComStatus == null) {
            this.simuComStatus = SimucomstatusFactory.eINSTANCE.createSimuComStatus();
            this.simuComStatus.setProcessStatus(SimucomstatusFactory.eINSTANCE.createSimulatedProcesses());
            this.simuComStatus.setResourceStatus(SimucomstatusFactory.eINSTANCE.createSimulatedResources());
        }
        return this.simuComStatus;
    }

}
