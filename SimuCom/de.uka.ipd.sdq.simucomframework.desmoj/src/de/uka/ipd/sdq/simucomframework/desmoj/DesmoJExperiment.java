package de.uka.ipd.sdq.simucomframework.desmoj;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractSimEngine.SimCondition;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.ExternalEvent;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.TimeSpan;

public class DesmoJExperiment<T extends ISimulationModel<T>> implements ISimulationControl<T> {

    private static Logger logger = Logger.getLogger(DesmoJExperiment.class);

    private DesmoJModel<T> model;
    private Experiment experiment;
    private ArrayList<SimCondition<T>> stopConditions = new ArrayList<SimCondition<T>>();
    private boolean isRunning;
    private double lastStopConditionEvaluationSimTime = 0;

    public DesmoJExperiment(DesmoJModel<T> model) {
        this.model = model;
        this.experiment = new Experiment(model.getConfiguration().getSimulationRunName());
        this.model.connectToExperiment(experiment);
        this.experiment.setShowProgressBar(false);
    }

    public void addStopCondition(SimCondition<T> condition) {
        stopConditions.add(condition);
    }

    public void checkStopConditions() {
        if (lastStopConditionEvaluationSimTime < this.getCurrentSimulationTime()) {
            if (isRunning()) {
                for (SimCondition<T> c : stopConditions) {
                    if (c.check()) {
                        logger.debug("Scheduling stop event, as a stop condition is true.");
                        createStopEvent().schedule(new TimeSpan(0));
                        return;
                    }
                }
            }
            lastStopConditionEvaluationSimTime = this.getCurrentSimulationTime();
        }
    }

    private ExternalEvent createStopEvent() {
        return new ExternalEvent(model, "StopEvent", false) {

            @Override
            public void eventRoutine() {
                logger.debug("Handling simulation stop event...");
                stop();
            }

        };
    }

    public void addTimeObserver(Observer observer) {
        model.getExperiment().getSimClock().addObserver(observer);
    }

    public double getCurrentSimulationTime() {
        return experiment.getSimClock().getTime().getTimeAsDouble();
    }

    public void setMaxSimTime(long stopTime) {
        if (stopTime < 0) {
            throw new IllegalArgumentException("Simulation time may not be negative");
        }
        double currentTime = getCurrentSimulationTime();
        double delta = stopTime - currentTime;
        createStopEvent().schedule(new TimeSpan(delta));
    }

    public void start() {
        this.isRunning = true;

        this.addTimeObserver(new Observer() {

            public void update(Observable o, Object arg) {
                checkStopConditions();
            }

        });

        // start the simulator
        double start = System.nanoTime();
        logger.warn("Starting simulation...");
        this.experiment.start();
        this.isRunning = false;

        // the simulation has stopped, print a log message
        logger.warn("Simulation terminated. Took " + ((System.nanoTime() - start) / Math.pow(10, 9))
                + " real time seconds.");
    }

    
    public void stop() {
        if (isRunning) {
            logger.info("Simulation stop requested!");
            this.isRunning = false;

            // TODO schedule simulation stop event here!

            model.finalise();
        } else {
            logger.warn("Tried to stop the simulation, which has already been stopped.");
        }
    }

    public Model getDesmoJModel() {
        return model;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public Experiment getExperiment() {
        return experiment;
    }

}
