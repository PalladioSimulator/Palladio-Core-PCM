package edu.kit.ipd.sdq.eventsim.system.entities;

import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.IEntityListener;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;

public class ForkedRequest extends Request {

    private Request parent;
    private boolean asynchronous;

    private final ForkedBehaviour behaviour;

    public ForkedRequest(AbstractEventSimModel model, ForkedBehaviour behaviour, boolean asynchronous, Request parent) {
        super((EventSimSystemModel) model, parent.getSystemCall(), parent.getUser());
        this.behaviour = behaviour;
        this.asynchronous = asynchronous;
        this.parent = parent;

        // TODO (SimComp): reenable the garbage collector
        //this.addEntityListener(new GarbageCollectionListener(model.getProbeSpecContext().getBlackboardGarbageCollector()));
    }

    @Override
    protected RequestContext createRequestContext() {
        RequestContext parentContex = this.parent.getRequestContext();
        return new RequestContext(Long.toString(this.getEntityId()), parentContex);
    }

    public Request getParentRequest() {
        return this.parent;
    }

    public boolean isAsynchronous() {
        return this.asynchronous;
    }

    public ForkedBehaviour getBehaviour() {
        return behaviour;
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
        }

        @Override
        public void enteredSystem() {
            garbageCollector.enterRegion(ForkedRequest.this.getRequestContext().rootContext());
        }

    }

}
