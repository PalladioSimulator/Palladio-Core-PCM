package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import java.util.ArrayList;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Simulator;
import umontreal.iro.lecuyer.simevents.eventlist.SplayTree;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 */
public class SSJExperiment<M extends ISimulationModel<M>> implements ISimulationControl<M> {

    private static Logger logger = Logger.getLogger(SSJExperiment.class);

    private final Simulator simulator;
    private final ArrayList<SimCondition<M>> stopConditions = new ArrayList<SimCondition<M>>();
    private final ArrayList<Observer> timeObservers = new ArrayList<Observer>();
    double lastNotificationTime = 0.0;
    private final AtomicBoolean isRunning = new AtomicBoolean();
    private final SSJModel<M> model;

    public SSJExperiment(final SSJModel<M> model) {
        // model.setSimulationControl(this);
        this.simulator = new Simulator();
        this.simulator.init(new SplayTree());

        this.model = model;
        createCheckEvent(model).schedule(1);
    }

    public void addStopCondition(final SimCondition<M> condition) {
        this.stopConditions.add(condition);
    }

    public void checkStopConditions() {
        if (this.lastNotificationTime != this.getCurrentSimulationTime()) {
            this.lastNotificationTime = this.getCurrentSimulationTime();
            for (final Observer o : this.timeObservers) {
                o.update(null, this.lastNotificationTime);
            }
        }
        for (final SimCondition<M> c : this.stopConditions) {
            if (c.check()) {
                this.createStopEvent().schedule(0);
                return;
            }
        }
    }

    public void addTimeObserver(final Observer observer) {
        this.timeObservers.add(observer);
    }

    public double getCurrentSimulationTime() {
        return this.simulator.time();
    }

    public void setMaxSimTime(final long simTime) {
        this.createStopEvent().schedule(simTime);
    }

    public void start() {
        this.isRunning.set(true);

        // schedule initial events
        this.model.init();

        // start the simulator
        final double start = System.nanoTime();
        logger.warn("Starting simulation...");
        this.simulator.start();

        // the simulation has stopped, print a log message
        logger.warn("Simulation terminated. Took " + ((System.nanoTime() - start) / Math.pow(10, 9))
                + " real time seconds.");
    }

    public void stop() {
        // isRunning indicates that this method has been already executed.
        // The method must only be executed once, so we use an atomic operation
        // to avoid multiple accesses. Setting isRunning to false allows all
        // processes to clean up.
        if (this.isRunning.compareAndSet(true, false)) {
            logger.info("Simulation stop requested!");

            // This method MUST be called before all resources are deactivated,
            // otherwise new threads might request processing time after the
            // resource has been removed. These threads will not be cleaned up
            // correctly.
            this.simulator.stop();

            this.model.finalise();
        } else {
            logger.warn("Tried to stop the simulation, which has already been stopped.");
        }

    }

    public Simulator getSimulator() {
        return this.simulator;
    }

    public boolean isRunning() {
        return this.isRunning.get();
    }

    private Event createStopEvent() {
        return new Event(this.simulator) {

            @Override
            public void actions() {
                if (SSJExperiment.this.isRunning()) {
                    logger.debug("Executing Stop Event");
                    SSJExperiment.this.stop();
                }
            }

        };
    }

    private Event createCheckEvent(final SSJModel<M> model) {
        return new Event(this.simulator) {

            @Override
            public void actions() {
                SSJExperiment.this.checkStopConditions();
                if (model.getSimulationControl().isRunning()) {
                    this.schedule(1);
                }
            }

        };
    }
}