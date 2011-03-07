package de.uka.ipd.sdq.simulation.entities;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.context.SeffContext;
import de.uka.ipd.sdq.simulation.debug.DebugEntityListener;
import de.uka.ipd.sdq.simulation.events.TraverseResourceDemandingBehaviourEvent;
import de.uka.ipd.sdq.simulation.resources.SimulatedProcess;
import de.uka.ipd.sdq.simulation.resources.listener.IProcessListener;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * A simulated request.
 * 
 * @author Philipp Merkle
 * 
 */
public class Request extends EventSimEntity {

    private static final Logger logger = Logger.getLogger(Request.class);

    /** the user which has started the request */
    private final User user;
    private final TraversalState<AbstractAction> traversalState;
    private final EntryLevelSystemCall call;
    private final RequestContext requestContext; // only used for the probespec
    private final SimulatedProcess process;
    private final SeffContext context;

    public Request(final EventSimModel model, final User user, final EntryLevelSystemCall call) {
        super(model, "Request");
        this.user = user;
        this.call = call;

        this.process = new SimulatedProcess(Long.toString(this.getEntityId()), new ProcessActivatedHandler(model));
        this.requestContext = new RequestContext(Long.toString(this.getEntityId()), user.getRequestContext());
        this.traversalState = new TraversalState<AbstractAction>();
        this.context = new SeffContext(this.getModel(), this.traversalState, user.getContext());
        this.addEntityListener(new RequestFinishedHandler());

        if (logger.isDebugEnabled()) {
            this.addEntityListener(new DebugEntityListener(this));
        }
    }

    public User getUser() {
        return this.user;
    }

    public EntryLevelSystemCall getCall() {
        return this.call;
    }

    public RequestContext getRequestContext() {
        return this.requestContext;
    }

    public TraversalState<AbstractAction> getTraversalState() {
        return this.traversalState;
    }

    @Override
    public String getName() {
        return super.getName() + " of " + this.getUser().getName();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public SeffContext getContext() {
        return this.context;
    }

    /**
     * Returns the simulated process which executes the request.
     * 
     * @return
     */
    public SimulatedProcess getProcess() {
        return this.process;
    }

    private final class RequestFinishedHandler implements IEntityListener {
        @Override
        public void leftSystem() {
            Request.this.process.setFinished(true);
        }

        @Override
        public void enteredSystem() {
            // nothing to do
        }
    }

    private final class ProcessActivatedHandler implements IProcessListener {
        private final EventSimModel model;

        private ProcessActivatedHandler(final EventSimModel model) {
            this.model = model;
        }

        @Override
        public void passivated() {
            // nothing to do
        }

        @Override
        public void activated() {
            new TraverseResourceDemandingBehaviourEvent(this.model, Request.this.traversalState).schedule(Request.this,
                    0);
        }
    }

}
