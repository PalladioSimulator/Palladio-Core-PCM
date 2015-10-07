package edu.kit.ipd.sdq.eventsim.workload.entities;

import org.apache.log4j.Logger;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;

import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.debug.DebugEntityListener;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.workload.generator.IWorkloadGenerator;
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

    public UserState getUserState() {
		return state;
	}

	public void setUserState(UserState state) {
		this.state = state;
	}

}
