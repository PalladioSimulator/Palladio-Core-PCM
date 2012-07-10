package de.uka.ipd.sdq.simulation.abstractsimengine;

/**
 * The simulation model is the central class of a discrete-event system simulator.
 * <p>
 * Its <code>init</code> method is the entry point of each simulation run in that it schedules
 * initial events that put the simulation into operation. For this, the simulation model relies on a
 * simulation library (which is also referred to as simulation engine), which offers means to create
 * and schedule events (or processes, respectively), which are then executed at the intended
 * simulation time.
 * <p>
 * The methods <code>getSimEngineFactory</code> and <code>getSimulationControl</code> both provide
 * access to simulation library services, where the former focuses on the creation of events and
 * processes, for instance, and the latter offers means to control the simulation run (e.g. to start
 * and stop the simulation).
 * <p>
 * Notice, that the term <i>model</i> refers to the circumstance that the simulation model is an
 * abstraction of a real-world system in that it imitates the system's behaviour.
 * 
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 */
public interface ISimulationModel {

    public ISimulationControl getSimulationControl();

    public void setSimulationControl(ISimulationControl control);

    public void setSimulationEngineFactory(ISimEngineFactory factory);

    public ISimEngineFactory getSimEngineFactory();

    /**
     * Initialises the simulation. Especially, the initial events are scheduled here before the
     * simulation starts. If no events are scheduled, the simulator stops immediately after being
     * started.
     * <p>
     * This method is called directly before the simulation starts.
     */
    public void init();

    /**
     * Cleans up when the simulation stops.
     * <p>
     * This method is called directly after the simulation have stopped.
     */
    public void finalise();

    /**
     * Returns the configuration of the simulation run. Each running simulation model has a
     * configuration.
     */
    public ISimulationConfig getConfiguration();

}
