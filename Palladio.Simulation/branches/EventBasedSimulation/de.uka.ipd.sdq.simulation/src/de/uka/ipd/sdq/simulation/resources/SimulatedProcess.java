package de.uka.ipd.sdq.simulation.resources;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.simulation.resources.listener.IProcessListener;

public class SimulatedProcess implements ISchedulableProcess {

    private final String id;
    private boolean finished;
    private final IProcessListener listener;

    public SimulatedProcess(final String id, final IProcessListener listener) {
        this.id = id;
        this.listener = listener;
    }

    @Override
    public void activate() {
        this.listener.activated();
    }

    @Override
    public void addTerminatedObserver(final IActiveResource o) {
        // TODO what is to do here?
    }

    @Override
    public void fireTerminated() {
        // TODO what is to do here?
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public ISchedulableProcess getRootProcess() {
        // TODO ok!?
        return this;
    }

    @Override
    public boolean isFinished() {
        return this.finished;
    }

    public void setFinished(final boolean finished) {
        this.finished = finished;
    }

    @Override
    public void passivate() {
        this.listener.passivated();
    }

    @Override
    public void removeTerminatedObserver(final IActiveResource o) {
        throw new RuntimeException("Operation not supported");
    }

}
