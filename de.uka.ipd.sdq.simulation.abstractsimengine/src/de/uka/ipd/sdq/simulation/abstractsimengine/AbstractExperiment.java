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

    private static Logger logger = Logger.getLogger(AbstractExperiment.class);

    protected final IEvent STOP_EVENT = new StopEvent();
    protected final IEvent CHECK_EVENT = new CheckEvent();

    private final ArrayList<SimCondition> stopConditions = new ArrayList<SimCondition>();
    private final ArrayList<Observer> timeObservers = new ArrayList<Observer>();
    private final AtomicBoolean isRunning = new AtomicBoolean();
    private double lastNotificationTime = 0.0;

    protected final ISimulationModel model;

    public AbstractExperiment(ISimulationModel model) {
        this.model = model;
    }

    public void setMaxSimTime(final long simTime) {
        scheduleEvent(new StopEvent(), simTime);
    }

    public void addStopCondition(final SimCondition condition) {
        this.stopConditions.add(condition);
    }

    public void start() {
        this.isRunning.set(true);

        // schedule initial events
        this.model.init();

        // start the simulator
        final double start = System.nanoTime();
        if(logger.isEnabledFor(Level.INFO))
        	logger.info("Starting simulation...");
        startSimulator();

        // the simulation has stopped, print a log message
        if(logger.isEnabledFor(Level.INFO))
        	logger.info("Simulation terminated. Took " + ((System.nanoTime() - start) / Math.pow(10, 9))
                + " real time seconds.");
    }

    public void stop() {
        // isRunning indicates that this method has been already executed.
        // The method must only be executed once, so we use an atomic operation
        // to avoid multiple accesses. Setting isRunning to false allows all
        // processes to clean up.
        if (this.isRunning.compareAndSet(true, false)) {
        	if(logger.isEnabledFor(Level.INFO))
        		logger.info("Simulation stop requested!");

            // This method MUST be called before all resources are deactivated,
            // otherwise new threads might request processing time after the
            // resource has been removed. These threads will not be cleaned up
            // correctly.
            stopSimulator();

            this.model.finalise();
        } else {
        	if(logger.isEnabledFor(Level.WARN))
        		logger.warn("Tried to stop the simulation, which has already been stopped.");
        }

    }

    public boolean isRunning() {
        return this.isRunning.get();
    }

    public void checkStopConditions() {
        if (this.lastNotificationTime != this.getCurrentSimulationTime()) {
            this.lastNotificationTime = this.getCurrentSimulationTime();
            for (final Observer o : this.timeObservers) {
                o.update(null, this.lastNotificationTime);
            }
        }
        for (final SimCondition c : this.stopConditions) {
            if (c.check()) {
                scheduleEvent(STOP_EVENT, 0);
                return;
            }
        }
    }

    public void addTimeObserver(final Observer observer) {
        this.timeObservers.add(observer);
    }

    public abstract void scheduleEvent(final IEvent event, final double delay);

    public abstract void startSimulator();

    public abstract void stopSimulator();

    protected class StopEvent implements IEvent {

        @Override
        public void run() {
            if (AbstractExperiment.this.isRunning()) {
            	if(logger.isDebugEnabled())
            		logger.debug("Executing Stop Event");
                AbstractExperiment.this.stop();
            }
        }

    }

    protected class CheckEvent implements IEvent {

        @Override
        public void run() {
            AbstractExperiment.this.checkStopConditions();
            if (model.getSimulationControl().isRunning()) {
                scheduleEvent(this, 1);
            }
        }

    }

    protected interface IEvent {

        public void run();

    }

}
