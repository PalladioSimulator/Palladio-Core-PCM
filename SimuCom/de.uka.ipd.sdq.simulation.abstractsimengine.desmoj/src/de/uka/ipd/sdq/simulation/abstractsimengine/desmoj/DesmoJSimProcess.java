/**
 * 
 */
package de.uka.ipd.sdq.simulation.abstractsimengine.desmoj;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimProcessDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.processes.ProcessState;
import de.uka.ipd.sdq.simulation.abstractsimengine.processes.SimProcessThreadingStrategy;
import de.uka.ipd.sdq.simulation.abstractsimengine.processes.SimulatedProcess;
import desmoj.core.simulator.ExternalEvent;
import desmoj.core.simulator.TimeSpan;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 */
public class DesmoJSimProcess extends SimulatedProcess {

    private AbstractSimProcessDelegator myAbstractProcess;

    private DesmoJModel model;

    /**
     * Reference to the underlying experiment
     */
    private final DesmoJExperiment experiment;

    public DesmoJSimProcess(AbstractSimProcessDelegator process, DesmoJModel model, String name) {
        super(new SimProcessThreadingStrategy());
        this.myAbstractProcess = process;
        this.model = model;
        this.experiment = (DesmoJExperiment) myAbstractProcess.getModel().getSimulationControl();

        startProcess(processStrategy);
    }

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

            // TODO set event name
            new ExternalEvent(this.model, "TODO event name", false) {
                @Override
                public void eventRoutine() {
                    if (!isTerminated()) {
                        resume();
                    }
                }
            }.schedule(new TimeSpan(delay));
        }
    }
    
    public void passivate(double delay) {
        if (!isTerminated()) {
            if (this.myProcessState != ProcessState.RUNNING) {
                throw new IllegalStateException("Tried to passivate thread which was not running ["
                        + this.myAbstractProcess.getId() + "]");
            }

            // Resume process immediately to force process cleanup
            if (!simIsRunning()) {
                resume();
            }

            new ExternalEvent(this.model, "Passivate " + this.myAbstractProcess.getId(), false) {
                @Override
                public void eventRoutine() {
                    if (!isTerminated()) {
                        resume();
                    }
                }
            }.schedule(new TimeSpan(delay));
            
            suspend();
        }
    }

    private boolean simIsRunning() {
        // do not use isRunning method here, since !isRunning != isStopped
        return !experiment.getExperiment().isStopped();
    }

    @Override
    protected AbstractSimProcessDelegator getAbstractProcess() {
        return this.myAbstractProcess;
    }

    @Override
    public boolean isScheduled() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reschedule(double delay) {
        throw new UnsupportedOperationException();
    }

}
