/**
 * 
 */
package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.processes.ProcessState;
import de.uka.ipd.sdq.simulation.abstractsimengine.processes.SimProcessThreadingStrategy;
import de.uka.ipd.sdq.simulation.abstractsimengine.processes.SimulatedProcess;

/**
 * Simulation Process implementation for SSJ
 * 
 * @author Snowball, Michael H. & Jens (bugfixing, refactorings, cleanup) 
 */
public class SSJSimProcess<T extends ISimulationModel<T>> extends SimulatedProcess<T> {

    public static final Logger logger = Logger.getLogger(SSJSimProcess.class);

    /**
     * Underlying abstract simulation process
     */
    public final AbstractSimProcess<T> myAbstractProcess;
    
    /**
     * Reference to the actual and concrete simulation engine 
     */
    private final Simulator sim;
    
    /**
	 * Reference to the underlying SSJ experiment 
	 */
	private final SSJExperiment<T> ssjExperiment;

    /**
     * Constructor
     * @param myProcess Underlying abstract sim process
     * @param name an ID
     */
    public SSJSimProcess(AbstractSimProcess<T> myProcess, String name) {
        super(new SimProcessThreadingStrategy());
        this.myAbstractProcess = myProcess;
        this.ssjExperiment = (SSJExperiment<T>) myAbstractProcess.getModel().getSimulationControl();
        this.sim = ssjExperiment.getSimulator();

        startProcess(processStrategy);
    }

    /* (non-Javadoc)
     * @see de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcess#scheduleAt(double)
     */
    public void scheduleAt(double delay) {
        if (!isTerminated()) {
        	if (this.myProcessState != ProcessState.SUSPENDED) {
        		throw new IllegalStateException("Tried to schedule thread which was not suspended ["
        				+ this.myAbstractProcess.getId() + "]");
        	}

        	// Resume process immediately to force process cleanup
        	if (!simIsRunning()) {
        		resume();
        	}

            new Event(sim) {
                @Override
                public void actions() {
                    if (!isTerminated()) {
                        resume();
                    }
                }
            }.schedule(delay);
        }
    }

    private boolean simIsRunning() {
        return ssjExperiment.isRunning();
    }

    @Override
    protected AbstractSimProcess<T> getAbstractProcess() {
        return this.myAbstractProcess;
    }

}
