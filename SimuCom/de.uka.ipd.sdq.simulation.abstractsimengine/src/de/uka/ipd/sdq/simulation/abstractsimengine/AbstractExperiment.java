package de.uka.ipd.sdq.simulation.abstractsimengine;

import java.util.ArrayList;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 */
public abstract class AbstractExperiment implements ISimulationControl {

    private final static Logger LOG = Logger.getLogger(AbstractExperiment.class);

    private final ArrayList<SimCondition> stopConditions = new ArrayList<SimCondition>();
    private final ArrayList<Observer> timeObservers = new ArrayList<Observer>();
    private final AtomicBoolean isRunning = new AtomicBoolean();
    private double lastNotificationTime = 0.0;

    protected final ISimulationModel model;

    public AbstractExperiment(final ISimulationModel model) {
        super();
        this.model = model;
    }

    @Override
    public void setMaxSimTime(final long simTime) {
        addStopCondition(new SimCondition() {

            @Override
            public boolean check() {
                return getCurrentSimulationTime() >= simTime;
            }

        });
    }

    @Override
    public void addStopCondition(final SimCondition condition) {
        this.stopConditions.add(condition);
    }

    @Override
    public void start() {
        this.isRunning.set(true);

        // schedule initial events
        this.model.init();

        // start the simulator
        final double start = System.nanoTime();
        if (LOG.isEnabledFor(Level.INFO)) {
            LOG.info("Starting simulation...");
        }
        startSimulator();

        // the simulation has stopped, print a log message
        if (LOG.isEnabledFor(Level.INFO)) {
            LOG.info("Simulation terminated. Took " + ((System.nanoTime() - start) / Math.pow(10, 9))
                    + " real time seconds.");
        }
    }

    @Override
    public void stop() {
        // isRunning indicates that this method has been already executed.
        // The method must only be executed once, so we use an atomic operation
        // to avoid multiple accesses. Setting isRunning to false allows all
        // processes to clean up.
        if (this.isRunning.compareAndSet(true, false)) {
            if (LOG.isEnabledFor(Level.INFO)) {
                LOG.info("Simulation stop requested!");
            }

            // This method MUST be called before all resources are deactivated,
            // otherwise new threads might request processing time after the
            // resource has been removed. These threads will not be cleaned up
            // correctly.
            stopSimulator();

            this.model.finalise();
        } else {
            if (LOG.isEnabledFor(Level.WARN)) {
                LOG.warn("Tried to stop the simulation, which has already been stopped.");
            }
        }

    }

    @Override
    public boolean isRunning() {
        return this.isRunning.get();
    }

    public boolean checkStopConditions() {
        notifyTimeObservers();
        for (final SimCondition c : this.stopConditions) {
            if (c.check()) {
                LOG.debug("Found matching stop condition: " + c.getClass().getCanonicalName());
                return true;
            }
        }
        return false;
    }

    @Override
    public void addTimeObserver(final Observer observer) {
        this.timeObservers.add(observer);
    }

    public abstract void startSimulator();

    public abstract void stopSimulator();

    protected void notifyTimeObservers() {
        if (this.lastNotificationTime != this.getCurrentSimulationTime()) {
            this.lastNotificationTime = this.getCurrentSimulationTime();
            for (final Observer o : this.timeObservers) {
                o.update(null, this.lastNotificationTime);
            }
        }
    }

}
