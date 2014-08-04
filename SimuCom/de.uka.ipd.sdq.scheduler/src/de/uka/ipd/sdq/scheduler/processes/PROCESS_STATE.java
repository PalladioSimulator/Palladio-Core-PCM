package de.uka.ipd.sdq.scheduler.processes;

public enum PROCESS_STATE {
    /**
     * Thread is waiting to execute.
     */
    READY,
    /**
     * Thread executes.
     */
    RUNNING,
    /**
     * Waiting for an object to synchronise.
     */
    WAITING
}
