package edu.kit.ipd.sdq.eventsim.workload.generator;

import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.usagemodel.OpenWorkload;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import edu.kit.ipd.sdq.eventsim.api.events.WorkloadUserFinished;
import edu.kit.ipd.sdq.eventsim.entities.IEntityListener;
import edu.kit.ipd.sdq.eventsim.workload.EventSimWorkloadModel;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.events.BeginUsageTraversalEvent;

/**
 * An open workload generates a new {@link User} as soon as a specified time duration has passed
 * since the previous user has been created. This time duration between two subsequent user arrivals
 * is called the interarrival time.
 * 
 * @author Philipp Merkle
 * 
 */
public class OpenWorkloadGenerator implements IWorkloadGenerator {

    private final EventSimWorkloadModel model;
    private final OpenWorkload workload;
    private final PCMRandomVariable interarrivalTime;

    /**
     * Constructs an open workload in accordance with the specified workload description.
     * 
     * @param model
     *            the model
     * @param workload
     *            the workload description
     */
    public OpenWorkloadGenerator(final EventSimWorkloadModel model, final OpenWorkload workload) {
        this.model = model;
        this.workload = workload;
        this.interarrivalTime = workload.getInterArrivalTime_OpenWorkload();
    }

    /**
     * {@inheritDoc}
     */
    public void processWorkload() {
        // spawn initial user
        this.spawnUser(0);
    }

    /**
     * Creates a new user and schedule the next user to enter the system after the interarrival time
     * has passed.
     */
    private void spawnUser(double waitingTime) {
        // create the user
        final UsageScenario scenario = this.workload.getUsageScenario_Workload();
        final User user = new User(this.model, scenario);

        // when the user entered the system, we wait until the interarrival time has passed and then
        // schedule a new one
        user.addEntityListener(new IEntityListener() {

            @Override
            public void enteredSystem() {
                final double waitingTime = StackContext.evaluateStatic(OpenWorkloadGenerator.this.interarrivalTime.getSpecification(), Double.class);
                OpenWorkloadGenerator.this.spawnUser(waitingTime);
            }

            @Override
            public void leftSystem() {
            	// trigger event that the user finished his work
            	model.getSimulationMiddleware().triggerEvent(new WorkloadUserFinished(user));
            }

        });
        
        new BeginUsageTraversalEvent(this.model, scenario).schedule(user, waitingTime);
    }

}
