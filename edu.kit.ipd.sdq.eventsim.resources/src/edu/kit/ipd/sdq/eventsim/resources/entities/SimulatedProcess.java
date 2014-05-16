package edu.kit.ipd.sdq.eventsim.resources.entities;

import java.util.ArrayList;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.simcomp.component.IRequest;

/**
 * A simulated process is a process that can be scheduled on an active or passive resource. Whenever
 * the scheduler activates or passivates the process, the {@link IProcessListener}, which has been
 * passed to the constructor, gets notified. 
 * 
 * TODO (SimComp) fix me
 * 
 * @author Philipp Merkle
 * 
 * @see ISchedulableProcess
 */
public class SimulatedProcess extends EventSimEntity implements ISchedulableProcess {

    private final String id;
    private final ArrayList<IActiveResource> terminatedObservers;
    private final IRequest request;
    private boolean finished;
    private int priority;
    
    /**
     * Creates a simulated process with the specified id and registers the passed listener.
     * 
     * @param request
     *            the request that created this simulated process.
     * @param id
     *            a unique identifier for this simulated process
     * @param listener
     *            the listener that is to be notified when this simulated process is being activated
     *            or passivated
     */
    public SimulatedProcess(AbstractEventSimModel model, final IRequest request, final String id) {
        super(model, SimulatedProcess.class.getName());
        this.request = request;
        this.id = id;
        this.terminatedObservers = new ArrayList<IActiveResource>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void activate() {
        request.activate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void passivate() {
    	request.passivate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ISchedulableProcess getRootProcess() {
        // TODO is this correct!?
        return this;
    }

    /**
     * Returns the request that created this simulated process.
     */
    public IRequest getRequest() {
        return request;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFinished() {
        return this.finished;
    }

    /**
     * Sets the state of this simulated process to finished. When called the first time, this method
     * notifies all observers that has been registered by the {@code addTerminatedObserver} method.
     */
    public void setFinished() {
        boolean wasAlreadyFinished = this.finished;
        this.finished = true;

        if (!wasAlreadyFinished) {
            // TODO is this the correct position to notify the listeners?
            fireTerminated();
        }
    }
    
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    /**
     * Adds an observer which gets notifies when the process has ended its execution.
     */
    @Override
    public void addTerminatedObserver(final IActiveResource o) {
        terminatedObservers.add(o);
    }

    /**
     * Notifies the observers which have been registered via
     * {@link #addTerminatedObserver(IActiveResource)} that the process has ended it execution. This
     * is automatically done, when {@link #setFinished()} method is being invoked.
     */
    @Override
    public void fireTerminated() {
        for (IActiveResource o : terminatedObservers) {
            o.notifyTerminated(this);
        }
        terminatedObservers.clear();
    }

    /**
     * Removes the specified resource from the observer list.
     */
    @Override
    public void removeTerminatedObserver(final IActiveResource o) {
        terminatedObservers.remove(o);
    }

    @Override
    public void timeout(String timeoutFailureName) {
        // TODO Failures are not yet supported
        throw new RuntimeException("Encountered a timeout but simulation of failures is not yet supported.");
    }
        

}
