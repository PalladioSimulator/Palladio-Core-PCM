/**
 * 
 */
package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcessListener;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

/**
 * Enumeration of all process states (in analogy to process states of any
 * operating system)
 */
enum ProcessState {
    READY, SUSPENDED, RUNNING, TERMINATED
}

/**
 * Simulation Process implementation for SSJ
 * 
 * @author Snowball, Michael H. & Jens (bugfixing, refactorings, cleanup) 
 */
public class SSJSimProcess<T extends ISimulationModel<T>> implements ISimProcess {

    /**
     * This class' logger
     */
    private static final Logger logger = Logger.getLogger(SSJSimProcess.class.getName());

    /**
     * Underlying abstract simulation process
     */
    private final AbstractSimProcess<T> myAbstractProcess;
    
    /**
     * Current state of this process 
     */
    private ProcessState myProcessState = ProcessState.READY;
    
    /**
     * Strategy used to suspend threads if requested 
     */
    private final ISimProcessStrategy processStrategy = new SimProcessThreadingStrategy();
    
    /**
     * Reference to the actual and concrete simulation engine 
     */
    private final Simulator sim;
    
    /**
     * A list of process listeners getting notifications on resume and suspend 
     */
    private final List<ISimProcessListener> listeners;

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
        this.myAbstractProcess = myProcess;
        this.ssjExperiment = (SSJExperiment<T>) myAbstractProcess.getModel().getSimulationControl();
        this.sim = ssjExperiment.getSimulator();

        this.listeners = new ArrayList<ISimProcessListener>();
        Runnable myRunnable = new Runnable() {
            public void run() {
            	if (logger.isDebugEnabled()) {
            		logger.debug("Starting sim process [ID: " + SSJSimProcess.this.myAbstractProcess.getId() + "]");
            	}
                SSJSimProcess.this.actions();
                // SSJSimProcess.this.processStrategy = null;
            	if (logger.isDebugEnabled()) {
            		logger.debug("Sim process ended [ID: " + SSJSimProcess.this.myAbstractProcess.getId() + "]");
            	}
            }
        };

        processStrategy.startProcess(myRunnable);
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

    public void actions() {
        // set state to running and suspended, i.e., return to constructor
        this.myProcessState = ProcessState.RUNNING;
        suspend();

        // execute process's behavior
        myAbstractProcess.lifeCycle();

        // terminate process
        this.myProcessState = ProcessState.TERMINATED;
        processStrategy.finishProcess();
    }

    public boolean isTerminated() {
        return this.myProcessState == ProcessState.TERMINATED;
    }

    public void passivate() {
        suspend();
    }

    private void suspend() {
        if (this.myProcessState != ProcessState.RUNNING)
            throw new IllegalStateException("Tried to suspend non-running process [" + this.myAbstractProcess.getId()
                    + "]");
        if (logger.isDebugEnabled()) {
            logger.debug("Suspending thread [" + this.myAbstractProcess.getId() + "]");
        }

        // notify listeners of the imminent suspend
        notifyListeners(this, true);

        // suspend this process
        this.myProcessState = ProcessState.SUSPENDED;
        processStrategy.suspendProcess();
        
        // notify listeners of the imminent resume
        notifyListeners(this, false);
    }

    private void resume() {
        if (this.myProcessState != ProcessState.SUSPENDED)
            throw new IllegalStateException("Tried to resume thread which was not suspended ["
                    + this.myAbstractProcess.getId() + "]");
        if (logger.isDebugEnabled()) {
            logger.debug("Resuming thread [" + this.myAbstractProcess.getId() + "]");
        }

        // resume this process
        this.myProcessState = ProcessState.RUNNING;
        processStrategy.resumeProcess();
    }

    public void addProcessListener(ISimProcessListener l) {
        this.listeners.add(l);
    }

    public void removeProcessListener(ISimProcessListener l) {
        this.listeners.remove(l);
    }

    /**
     * Notifies registered listeners that the given process is about to be suspended or resumed
     * again.
     * 
     * @param process
     *            the process which is being resumed or suspended
     * @param isSuspending
     *            true, if the process is about to be suspended; false, if the process is about to
     *            be resumed
     */
    protected void notifyListeners(ISimProcess process, boolean isSuspending) {
        for (ISimProcessListener l : listeners) {
            if (isSuspending) {
                l.notifySuspending(process);
            } else {
                l.notifyResuming(process);
            }
        }
    }

}
