package org.palladiosimulator.protocom.framework.experiment;

import java.io.File;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.management.RuntimeErrorException;

import org.palladiosimulator.protocom.framework.registry.IRmiRegistry;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * Manages the time span sensors and measurements.
 * 
 * @author Steffen Becker, Sebastian Lehrig, Thomas Zolynski
 *
 */
public class ExperimentManager extends UnicastRemoteObject implements IExperimentManager, Serializable {

    protected ExperimentManager() throws RemoteException {
        super();
    }

    private static final long serialVersionUID = 4939697784092741922L;

    protected static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getRootLogger();

    /**
     * Stores whether this ExperimentManager is a master or slave. The master ExperimentManager is
     * informing the slave ones when the experiment run finishes.
     */
    private int remoteType;

    /**
     * Single instance which communicates via RMI.
     */
    private static ExperimentManager singleton;

    /**
     * Attributes for the measurements store.
     */
    private transient IDAOFactory datasource;

    /**
     * Experiment.
     */
    private Experiment exp;
    private String experimentName;

    public static ExperimentManager getInstance() {
        return singleton;
    }

    @Override
    public String getName() throws RemoteException {
        return experimentName;
    }

    public static Experiment getExperiment() {
        return singleton.exp;
    }

    private void setExperiment(Experiment exp) {
        this.exp = exp;
    }

    /**
     * Adds a new experiment run to the experiment. Current date is used for as date.
     *
     * @return the newly created experiment run
     */
    public static ExperimentRun addExperimentRun() {
        if (singleton.exp == null) {
            LOGGER.error("Experiment not set");
            throw new RuntimeErrorException(null, "Experiment not set");
        }

        return singleton.exp.addExperimentRun(new java.util.Date().toString());
    }

    /**
     * Restored this from an older version. Will be changed eventually.
     * 
     * @return
     */
    public static long takeStartTimeForInnerMeasurement() {
        return System.nanoTime();
    }

    /**
     * Takes a measurement (from start time till current time) on the given sensor
     * 
     * @param start
     *            start time
     * @param experimentRun
     * @param timeSpanSensor
     *            sensor
     */
    public static void takeMeasurement(long start, ExperimentRun experimentRun, TimeSpanSensor timeSpanSensor) {

        LOGGER.info("Take measurement of " + timeSpanSensor.getSensorName());

        long now = System.nanoTime();
        double measuredTimeSpan = (now - start) / Math.pow(10, 9);

        experimentRun.addTimeSpanMeasurement(timeSpanSensor, now / Math.pow(10, 9), measuredTimeSpan);
    }

    /**
     * Returns a {@link TimeSpanSensor} in the experiment that has the name sensorName. Creates a
     * new sensor and returns it of no sensor with this name exists. The reuse is required because
     * the EJB container may decide at times to create new instances of the components, so for one
     * component type and one signature, this method may be called multiple times during the
     * measurements. We want to store all results per component type into one sensor, though.
     * 
     * @param sensorName
     *            The sensor name to match
     * @return The {@link TimeSpanSensor} with the passed name or a new {@link TimeSpanSensor} with
     *         that name that is then also added to the experiment.
     */
    public static TimeSpanSensor createOrReuseTimeSpanSensor(String sensorName) {

        Collection<Sensor> existingSensors = singleton.exp.getSensors();
        for (Sensor sensor : existingSensors) {
            if (sensor instanceof TimeSpanSensor && sensor.getSensorName().equals(sensorName)) { // +
                                                                                                 // ExperimentManager.PROTOCOM_SENSOR_SUFFIX);
                return (TimeSpanSensor) sensor;
            }
        }

        TimeSpanSensor tss = getExperiment().addTimeSpanSensor(sensorName); // +
                                                                            // ExperimentManager.PROTOCOM_SENSOR_SUFFIX);
        return tss;
    }

    /**
     * Returns the newest experiment run instance. If no one exists, a new experiment run will be
     * created. Note that the experiment run usually should be created explicitly and not here. This
     * one is just a (quick) fix to get measurements from sensors running on instances different
     * from the usage scenario.
     * 
     * @return latest experiment run instance or a new one
     */
    public static ExperimentRun getLatestExperimentRun() {
        if (getExperiment().getExperimentRuns().isEmpty()) {
            addExperimentRun();
        }

        Collection<ExperimentRun> runs = getExperiment().getExperimentRuns();
        Iterator<ExperimentRun> it = runs.iterator();

        ExperimentRun experimentRun = null;

        while (it.hasNext()) {
            experimentRun = it.next();
        }

        return experimentRun;
    }

    /**
     * Creates a factory for file DAOs.
     * 
     * @return
     */
    public static void init(String experimentName, String directory, int remoteType) {

        if (!checkDirectory(directory)) {
            String error = "Unable to find data directory. Ensure data directory exists and is writeable";
            LOGGER.error(error);
            throw new RuntimeException(error);
        }

        if (singleton == null) {
            try {
                singleton = new ExperimentManager();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        singleton.experimentName = experimentName;
        singleton.remoteType = remoteType;
        singleton.datasource = new FileDAOFactory(directory);

        if (remoteType == EXPERIMENT_MANAGER_SLAVE) {
            IRmiRegistry registry = (IRmiRegistry) org.palladiosimulator.protocom.framework.registry.RmiRegistry
                    .lookup(IRmiRegistry.PCM_EXPERIMENT_MANAGER_REGISTRY);
            try {
                LOGGER.info("Register experiment manager for " + experimentName);
                registry.bindExperimentManager(singleton);
            } catch (RemoteException e) {
                LOGGER.error("Failed to register experiment manager", e);
            }
        }

        singleton.setExperiment(singleton.datasource.createExperimentDAO().addExperiment(experimentName));
        LOGGER.info("Created data source at event time " + (System.nanoTime() / Math.pow(10, 9)));

    }

    /**
     * Checks if the given directory can be used to store experiments.
     * 
     * @param path
     * @return
     */
    private static boolean checkDirectory(String path) {
        File f = new File(path);
        if (f.isDirectory() && f.canWrite()) {
            return true;
        }
        if (!f.exists()) {
            return f.mkdir();
        } else {
            return false;
        }
    }

    public void createExperimentRun() {
        addExperimentRun();
    }

    @Override
    public void writeResultsAndClose() throws RemoteException {
        LOGGER.info("Storing results for " + this.experimentName);
        LOGGER.info("Current time: " + new Date());

        datasource.store();

        // Wait a little before closing down results writer.
        // Not the best solution tbh, but... eh, works.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            LOGGER.error("Failed to persist measurements", e);
            System.exit(-1);
        }

        LOGGER.info("...Done!");

        if (remoteType == EXPERIMENT_MANAGER_MASTER) {
            datasource.finalizeAndClose();

            IRmiRegistry registry = (IRmiRegistry) org.palladiosimulator.protocom.framework.registry.RmiRegistry
                    .lookup(IRmiRegistry.PCM_EXPERIMENT_MANAGER_REGISTRY);

            try {
                for (IExperimentManager manager : registry.getExperimentManagers()) {
                    LOGGER.info("Send finalizeAndClose to slave " + manager);
                    manager.writeResultsAndClose();
                }
            } catch (RemoteException e) {
                LOGGER.error("Failed to contact slave experiment managers", e);
            }
        }
    }

    @Override
    public void startNewExperimentRun() throws RemoteException {
        LOGGER.info("Received startNewExperimentRun");
        LOGGER.info("Current time: " + new Date());

        createExperimentRun();

        if (remoteType == EXPERIMENT_MANAGER_MASTER) {
            IRmiRegistry registry = (IRmiRegistry) org.palladiosimulator.protocom.framework.registry.RmiRegistry
                    .lookup(IRmiRegistry.PCM_EXPERIMENT_MANAGER_REGISTRY);

            try {
                for (IExperimentManager manager : registry.getExperimentManagers()) {
                    LOGGER.info("Send startNewExperimentRun to slave " + manager);
                    manager.startNewExperimentRun();
                }
            } catch (RemoteException e) {
                LOGGER.error("Failed to contact slave experiment managers", e);
            }
        }
    }
}
