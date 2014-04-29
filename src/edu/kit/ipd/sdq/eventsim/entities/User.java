package edu.kit.ipd.sdq.eventsim.entities;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.debug.DebugEntityListener;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.simcomp.component.IUser;

/**
 * This entity represents a user of the system under simulation. Users issue system calls while
 * traversing a usage scenario. They are spawned by a {@link IWorkloadGenerator}.
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 * 
 * @see EventSimEntity
 */
public class User extends EventSimEntity implements IUser {

    private static final Logger logger = Logger.getLogger(User.class);

    /** the usage scenario that is to be simulated by this User */
    private final UsageScenario scenario;
    
    private UserState state;

	/**
     * the request context is a unique identifier for this user, which is required for the Probe
     * Specification.
     */
    private final RequestContext requestContext;

    /**
     * Constructs a new User that is supposed to traverse the specified usage scenario.
     * 
     * @param model
     *            the simulation model
     * @param scenario
     *            the usage scenario
     */
    public User(final AbstractEventSimModel model, final UsageScenario scenario) {
        super(model, "User");
        this.scenario = scenario;

        // set the request context of this user. As this entity's ID is unique, we can use it to
        // construct the request context
        this.requestContext = new RequestContext(Long.toString(this.getEntityId()));

        // install debug listener, if debugging is enabled
        if (logger.isDebugEnabled()) {
            this.addEntityListener(new DebugEntityListener(this));
        }
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public String getId() {
		return "IUser" + this.getEntityId();
	}

    /**
     * Returns the usage scenario that is to be executed by this User.
     * 
     * @return the usage scenario
     */
    public UsageScenario getUsageScenario() {
        return this.scenario;
    }

    /**
     * Returns the RequestContext required by the Probe Specification to identify this User.
     * 
     * @return a unique identifier, encapsulated in a RequestContext, for this User
     */
    public RequestContext getRequestContext() {
        return this.requestContext;
    }

    public UserState getUserState() {
		return state;
	}

	public void setUserState(UserState state) {
		this.state = state;
	}

}
