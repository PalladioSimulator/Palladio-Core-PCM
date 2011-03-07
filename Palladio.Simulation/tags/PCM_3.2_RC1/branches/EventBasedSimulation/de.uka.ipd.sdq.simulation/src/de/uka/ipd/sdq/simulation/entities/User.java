package de.uka.ipd.sdq.simulation.entities;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.context.UsageContext;
import de.uka.ipd.sdq.simulation.debug.DebugEntityListener;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * A simulated user.
 * 
 * @author Philipp Merkle
 * 
 */
public class User extends EventSimEntity {

    private static final Logger logger = Logger.getLogger(User.class);

    private final TraversalState<AbstractUserAction> traversalState;
    private final UsageScenario scenario;

    // TODO does a user need a Context!? 
    private final UsageContext context;

    // TODO maybe the id of the request suffices!?
    private final RequestContext requestContext; // only used for the probespec

    public User(final EventSimModel model, final UsageScenario scenario) {
        super(model, "User");
        this.scenario = scenario;

        this.requestContext = new RequestContext(Long.toString(this.getEntityId()));
        this.traversalState = new TraversalState<AbstractUserAction>();
        this.context = new UsageContext(this.getModel(), this.traversalState);
        
        if (logger.isDebugEnabled()) {
            this.addEntityListener(new DebugEntityListener(this));
        }
    }

    public UsageScenario getScenario() {
        return this.scenario;
    }

    public RequestContext getRequestContext() {
        return this.requestContext;
    }

    public TraversalState<AbstractUserAction> getTraversalState() {
        return this.traversalState;
    }
    
    public UsageContext getContext() {
        return this.context;
    }

}
