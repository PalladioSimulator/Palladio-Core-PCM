package de.uka.ipd.sdq.simulation.abstractsimengine;

import java.util.Observer;

/**
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 */
public interface ISimulationControl {

    /**
     * Starts the simulation.
     */
    public abstract void start();

    /**
     * Stops the simulation.
     */
    public abstract void stop();

    /**
     * Returns the current simulation time.
     */
    public abstract double getCurrentSimulationTime();

    /**
     * Sets the simulation time at which the simulation is supposed to stop.
     * 
     * @param simTime
     *            the time instant at which the simulation is to stop, expressed in simulated time
     *            units
     */
    public abstract void setMaxSimTime(long simTime);

    public abstract void addStopCondition(SimCondition maxMeasurementsStopCondition);

    public abstract void addTimeObserver(Observer observer);

    /**
     * Returns whether the simulation is running.
     */
    public abstract boolean isRunning();

}