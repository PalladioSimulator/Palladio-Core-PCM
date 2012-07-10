package de.uka.ipd.sdq.simulation.abstractsimengine.processes;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimProcessDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcessListener;

public abstract class SimulatedProcess implements ISimProcess {

    public static final Logger logger = Logger.getLogger(SimulatedProcess.class);
    
    /**
     * Current state of this process 
     */
    public ProcessState myProcessState = ProcessState.READY;
    
    /**
     * A list of process listeners getting notifications on resume and suspend 
     */
    protected final List<ISimProcessListener> listeners;

    /**
     * Strategy used to suspend threads if requested 
     */
    public final ISimProcessStrategy processStrategy;
    
    /**
     * Default constructor.
     * @param processStrategy 
     */
    public SimulatedProcess(ISimProcessStrategy processStrategy) {
        this.processStrategy = processStrategy;
        this.listeners = new ArrayList<ISimProcessListener>();
    }

    public void startProcess(ISimProcessStrategy processStrategy) {
        Runnable myRunnable = new Runnable() {
            public void run() {
                if (logger.isDebugEnabled()) {
                    logger.debug("Starting sim process [ID: " + getAbstractProcess().getId() + "]");
                }
                actions();
                // SSJSimProcess.this.processStrategy = null;
                if (logger.isDebugEnabled()) {
                    logger.debug("Sim process ended [ID: " + getAbstractProcess().getId() + "]");
                }
            }
        };

        processStrategy.startProcess(myRunnable);
    }
    
    public void actions() {
        // set state to running and suspended, i.e., return to constructor
        this.myProcessState = ProcessState.RUNNING;
        suspend();
    
        // execute process's behavior
        getAbstractProcess().lifeCycle();
    
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
    
    abstract protected AbstractSimProcessDelegator getAbstractProcess();

    public void suspend() {
        if (this.myProcessState != ProcessState.RUNNING)
            throw new IllegalStateException("Tried to suspend non-running process [" + this.getAbstractProcess().getId()
                    + "]");
        if (logger.isDebugEnabled()) {
            logger.debug("Suspending thread [" + this.getAbstractProcess().getId() + "]");
        }
    
        // notify listeners of the imminent suspend
        notifyListeners(this, true);
    
        // suspend this process
        this.myProcessState = ProcessState.SUSPENDED;
        processStrategy.suspendProcess();
        
        // notify listeners of the imminent resume
        notifyListeners(this, false);
    }

    protected void resume() {
        if (this.myProcessState != ProcessState.SUSPENDED)
            throw new IllegalStateException("Tried to resume thread which was not suspended ["
                    + this.getAbstractProcess().getId() + "]");
        if (logger.isDebugEnabled()) {
            logger.debug("Resuming thread [" + this.getAbstractProcess().getId() + "]");
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
