package edu.kit.ipd.sdq.eventsim;

import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.simucomframework.AbstractMain;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.simulation.ISimulationControl;
import de.uka.ipd.sdq.simulation.IStatusObserver;
import de.uka.ipd.sdq.simulation.SimulationResult;

/**
 * This class is the entry point of an EventSim simulation run.
 * 
 * @author Steffen Becker (this class is based on {@link AbstractMain})
 * @author Philipp Merkle
 * 
 */
public class SimulationMain implements ISimulationControl, BundleActivator {

    private EventSimModel model;
    private BundleContext bundleContext;
    private SimuComStatus simuComStatus;
    private Throwable exceptionOccured;

    // Service registry entry for registering this object in Eclipse's service registry where
    // it can be found by the simulation runner
    private org.osgi.framework.ServiceRegistration serviceRegistryEntry;

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void start(final BundleContext context) throws Exception {
        // register the service
        this.serviceRegistryEntry = context.registerService(ISimulationControl.class
                .getName(), this, new Hashtable());

        this.bundleContext = context;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        this.serviceRegistryEntry.unregister();
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public void prepareSimulation(AbstractSimulationConfig config,
			final IStatusObserver statusObserver, boolean useOwnSensorstorage) {
		this.initializeLogger(config);

        // create simulation model
        this.model = EventSimModel.create((EventSimConfig) config, this.bundleContext);

        // set up an observer for the simulation progress
        final long SIM_STOP_TIME = config.getSimuTime();
        this.model.getSimulationControl().addTimeObserver(new Observer() {

            public void update(final Observable clock, final Object data) {
                final int timePercent = (int) (SimulationMain.this.model.getSimulationControl()
                        .getCurrentSimulationTime() * 100 / SIM_STOP_TIME);
                final int measurementsPercent = (int) (SimulationMain.this.model.getMainMeasurementsCount() * 100 / SimulationMain.this.model
                        .getConfiguration().getMaxMeasurementsCount());
                statusObserver.updateStatus(timePercent < measurementsPercent ? measurementsPercent : timePercent,
                        SimulationMain.this.model.getSimulationControl().getCurrentSimulationTime(),
                        SimulationMain.this.model.getMainMeasurementsCount());
            }

        });
        this.getStatus().setCurrentSimulationTime(0);
	}
    
    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationResult startSimulation(final AbstractSimulationConfig config, final IStatusObserver statusObserver,
            final boolean useOwnSensorstorage) {
        try {
            this.model.getSimulationControl().start();
        } catch (final Throwable t) {
            t.printStackTrace();
            this.exceptionOccured = t;
            return SimulationResult.ERROR;
        }

        return SimulationResult.OK;
    }

    /**
     * Request a simulation stop
     */
    @Override
    public void stopSimulation() {
        this.model.getSimulationControl().stop();
    }

    /**
     * {@inheritDoc}
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Throwable getErrorThrowable() {
        return this.exceptionOccured;
    }

    /**
     * Setup log4j
     * 
     * @param config
     *            simulation config which is queried for the logging settings
     */
    private void initializeLogger(final AbstractSimulationConfig config) {
        final Logger logger = Logger.getLogger("edu.kit.ipd.sdq.eventsim");
        if (config.getVerboseLogging()) {
            // Set to Level.ALL if verbose logging is enabled,
            logger.setLevel(Level.ALL);
            if(logger.isDebugEnabled())
            	logger.debug("Extended Simulation Logging enabled!");
        } else {
            // Set to INFO if verbose level is not enabled but global logging level
            // is lower than INFO, otherwise keep global level.
            // In this way the global logging settings
            // are kept if they are INFO, WARN or ERROR
            final Level currentLevel = logger.getEffectiveLevel();
            if (!currentLevel.isGreaterOrEqual(Level.INFO)) {
                logger.setLevel(Level.INFO);
            }
        }
    }

}
