package de.uka.ipd.sdq.simulation.entities;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.simulation.EventSimModel;

public class ForkedRequest extends Request {

    private static final Logger logger = Logger.getLogger(ForkedRequest.class);

    private Request parent;
    private boolean asynchronous;

    private final ForkedBehaviour behaviour;

    public ForkedRequest(EventSimModel model, ForkedBehaviour behaviour, boolean asynchronous, Request parent) {
        super(model, parent.getSystemCall(), parent.getUser());
        this.behaviour = behaviour;
        this.asynchronous = asynchronous;
        this.parent = parent;

        this.addEntityListener(new GarbageCollectionListener(ProbeSpecContext.instance()
                .getBlackboardGarbageCollector()));
        // this.addEntityListener(new ForkFinishedHandler());
    }

    @Override
    protected RequestContext createRequestContext() {
        RequestContext parentContex = this.parent.getRequestContext();
        return new RequestContext(Long.toString(this.getEntityId()), parentContex);
    }

    // @Override
    // protected SimulatedProcess createSimulatedProcess() {
    // throw new EventSimException("This method should never be called.");
    // }

    // @Override
    // public SimulatedProcess getSimulatedProcess() {
    // return parent.getSimulatedProcess();
    // }

    public Request getParent() {
        return this.parent;
    }

    public boolean isAsynchronous() {
        return this.asynchronous;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "ForkedRequest#" + this.getEntityId() + " of " + this.parent.getName();
    }

    /**
     * This handler increments the fork counter of the associated request when the fork is about to
     * start its execution. As soon as the fork has finished its execution, the counter is being
     * decremented.
     * 
     * @author Philipp Merkle
     * 
     */
    private final class GarbageCollectionListener implements IEntityListener {

        private IRegionBasedGarbageCollector<RequestContext> garbageCollector;

        public GarbageCollectionListener(IRegionBasedGarbageCollector<RequestContext> garbageCollector) {
            this.garbageCollector = garbageCollector;
        }

        @Override
        public void leftSystem() {
            garbageCollector.leaveRegion(ForkedRequest.this.getRequestContext().rootContext());
            // ForkedRequest.this.getParent().decrementRunningForks();
        }

        @Override
        public void enteredSystem() {
            garbageCollector.enterRegion(ForkedRequest.this.getRequestContext().rootContext());
            // ForkedRequest.this.getParent().incrementRunningForks();
        }

    }

}
