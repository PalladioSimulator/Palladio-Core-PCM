package de.uka.ipd.sdq.simulation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.simucomframework.AbstractMain;
import de.uka.ipd.sdq.simucomframework.AbstractSimulationConfig;
import de.uka.ipd.sdq.simucomframework.IStatusObserver;
import de.uka.ipd.sdq.simucomframework.SimuComResult;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.ssj.SSJSimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEngineFactory;

/**
 * 
 * This class is based on {@link AbstractMain}. Some code has been reused.
 * 
 * @author Philipp Merkle
 *
 */
public class SimulationMain implements de.uka.ipd.sdq.simucomframework.ISimulationControl,
        org.osgi.framework.BundleActivator {

    private static Logger logger = Logger.getLogger(SimulationMain.class);
    
    private EventSimModel model;
    
    private BundleContext bundleContext;
    
    // Service registry entry for registering this object in Eclipse's service registry where
    // it can be found by the simulation runner
    private org.osgi.framework.ServiceRegistration serviceRegistryEntry;
    
    @Override
    public Throwable getErrorThrowable() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SimuComStatus getStatus() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SimuComResult startSimulation(AbstractSimulationConfig config, IStatusObserver statusObserver,
            boolean useOwnSensorstorage) {
        
        
//        initializeLogger(config);
//        model = EventSimFactory.getSimulationModel((EventSimConfig)config);
//        model.getSimulationControl().start();
        ISimEngineFactory<EventSimModel> factory = new SSJSimEngineFactory<EventSimModel>();
        this.model = new EventSimModel((EventSimConfig)config, factory, bundleContext);
        factory.setModel(this.model);
        this.model.getSimulationControl().setMaxSimTime(config.getSimuTime());
        this.model.getSimulationControl().start();
        
        return null; // TODO
    }

    /**
     * Request a simulation stop 
     */
    @Override
    public void stopSimulation() {
        // TODO Auto-generated method stub
        
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(BundleContext context) throws Exception {
        // register the service
        serviceRegistryEntry = context.registerService(
                de.uka.ipd.sdq.simucomframework.ISimulationControl.class.getName(), 
                this, new java.util.Hashtable());
        
        bundleContext = context;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        serviceRegistryEntry.unregister();
    }
    
    /**
     * Setup log4j
     * 
     * @param config simulation config which is queried for the logging settings
     */
    private void initializeLogger(AbstractSimulationConfig config) {
        Logger logger = Logger.getLogger("de.uka.ipd.sdq.simulation");
        if (config.getVerboseLogging()) {
            //Set to Level.ALL if verbose logging is enabled,
            logger.setLevel(Level.ALL);
            logger.debug("Extended Simulation Logging enabled!");
        }
        else {
            // Set to INFO if verbose level is not enabled but global logging level 
            // is lower than INFO, otherwise keep global level. 
            // In this way the global logging settings
            // are kept if they are INFO, WARN or ERROR
            Level currentLevel = logger.getEffectiveLevel();
            if (!currentLevel.isGreaterOrEqual(Level.INFO)){
                logger.setLevel(Level.INFO);
            }
        }
    }

}
