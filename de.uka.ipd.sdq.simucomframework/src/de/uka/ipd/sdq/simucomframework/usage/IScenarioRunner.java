package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;

/**
 * Interface which encapsulates a behaviour. The behaviour can be executed when passed a simulation
 * thread that executes the behaviour.
 * 
 * @author Steffen Becker
 *
 */
public interface IScenarioRunner {
    /**
     * Execute the behaviour represented by this object using the given simulation process
     * 
     * @param thread
     *            The simulation process used to execute the behaviour encapsulated in this object
     */
    void scenarioRunner(SimuComSimProcess thread);
}
