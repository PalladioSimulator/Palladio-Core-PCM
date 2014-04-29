package edu.kit.ipd.sdq.eventsim.system.entities;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.osgi.service.useradmin.User;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.debug.DebugEntityListener;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.entities.IEntityListener;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;
import edu.kit.ipd.sdq.eventsim.system.entities.scheduler.IProcessListener;
import edu.kit.ipd.sdq.eventsim.system.entities.scheduler.SimulatedProcess;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.IUser;

/**
 * This entity represents the execution of a system call, which has been issued by a {@link User}.
 * 
 * @author Philipp Merkle
 * 
 * @see EventSimEntity
 */
public class Request extends EventSimEntity implements IRequest {

    private static final Logger logger = Logger.getLogger(Request.class);

    /** the user that has issued the request */
    private final IUser user;

    /** the system call that is to be simulated by this request */
    private final EntryLevelSystemCall call;

    /**
     * the request context is a unique identifier for this Request, which is required for the Probe
     * Specification.
     */
    private RequestContext requestContext;

    /**
     * the simulated process is used to schedule resource requests issued by this Request on an
     * active or passive resource.
     */
    private SimulatedProcess simulatedProcess;

    /**
     * the activation event encapsulates the bahaviour that is to be performed when this Request is
     * activated after it has been passivated before (see also: activate and passivate methods).
     */
    private AbstractSimEventDelegator<Request> activationEvent;

    /**
     * Constructs a new Request representing the execution of the specified system call, which has
     * been issued by the given User.
     * 
     * @param model
     *            the simulation model
     * @param call
     *            the system call
     * @param user
     *            the User that has issued the Request
     */
    public Request(final EventSimSystemModel model, final EntryLevelSystemCall call, final IUser user) {
        super(model, "Request");
        this.call = call;
        this.user = user;

        // install debug listener, if debugging is enabled
        if (logger.isDebugEnabled()) {
            this.addEntityListener(new DebugEntityListener(this));
        }
    }

    protected SimulatedProcess createSimulatedProcess() {
        // initialise the simulated process by specifying its ID and a handler that reacts when the
        // process gets activated by the scheduler
        SimulatedProcess process = new SimulatedProcess(this, Long.toString(this.getEntityId()), new ProcessActivatedHandler());

        // add a handler that reacts when this Request has finished its execution and informs the
        // simulated process about that.
        this.addEntityListener(new RequestFinishedHandler(process));

        return process;
    }

    protected RequestContext createRequestContext() {
        // set the request context of this request. As this entity's ID is unique, we can use it to
        // construct the request context
        RequestContext parentContex = this.user.getRequestContext();
        return new RequestContext(Long.toString(this.getEntityId()), parentContex);
    }

    /**
     * Returns the user that has issued this Request.
     * 
     * @return the user
     */
    public IUser getUser() {
        return this.user;
    }

    /**
     * Returns the system call that is to be executed by this Request.
     * 
     * @return the system call
     */
    public EntryLevelSystemCall getSystemCall() {
        return this.call;
    }

    /**
     * Returns the RequestContext required by the Probe Specification to identify this Request.
     * 
     * @return a unique identifier, encapsulated in a RequestContext, for this Request
     */
    public RequestContext getRequestContext() {
        if (this.requestContext == null) {
            this.requestContext = createRequestContext();
        }
        return this.requestContext;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Request#" + this.getEntityId() + " of " + this.getUser().getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * Returns the simulated process that is used to schedule resource requests issued by this
     * Request on an active or passive resource.
     * 
     * @return the simulated process
     */
    public SimulatedProcess getSimulatedProcess() {
        if (this.simulatedProcess == null) {
            this.simulatedProcess = this.createSimulatedProcess();
        }
        return this.simulatedProcess;
    }

    /**
     * Call this method when the simulated process (see: {@code getSimulatedProcess()} method) has
     * been scheduled on a resource and waits for being serviced. The specified activationEvent will
     * be scheduled as soon as the simulated process has been activated.
     * 
     * @param activationEvent
     *            the event that is to be scheduled when the simulated process has been activated
     */
    public void passivate(AbstractSimEventDelegator<Request> activationEvent) {
        assert (activationEvent != null) : "The argument activationEvent may not be null";
        this.activationEvent = activationEvent;
    }

    /**
     * Activates this Request by scheduling the activationEvent passed to the {@code passivate}
     * method. The Request must have been passivated before.
     * 
     * @see #passivate(AbstractSimEventDelegator)
     */
    protected void activate() {
        if (this.activationEvent == null) {
        	if(logger.isEnabledFor(Level.WARN))
        		logger.warn("Tried to activate request " + this.getName() + ", but there is no activation event.");
            return;
        }

        // schedule the activation event...
        this.activationEvent.schedule(this, 0);

        // ...and clear the event thereafter
        this.activationEvent = null;
    }

    /**
     * This handler reacts when the Request has been finished and informs the simulated process
     * about that.
     * 
     * @author Philipp Merkle
     * 
     */
    private static final class RequestFinishedHandler implements IEntityListener {

        private SimulatedProcess process;

        public RequestFinishedHandler(SimulatedProcess process) {
            this.process = process;
        }

        @Override
        public void leftSystem() {
            this.process.setFinished();
        }

        @Override
        public void enteredSystem() {
            // nothing to do
        }

    }

    /**
     * This handler reacts when the simulated process is being activated.
     * 
     * @author Philipp Merkle
     * 
     */
    private final class ProcessActivatedHandler implements IProcessListener {

        @Override
        public void passivated() {
            // nothing to do
        }

        @Override
        public void activated() {
            Request.this.activate();
        }
    }

}
