package edu.kit.ipd.sdq.eventsim.workload.generator;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import edu.kit.ipd.sdq.eventsim.entities.IEntityListener;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.EventSimWorkloadModel;
import edu.kit.ipd.sdq.eventsim.workload.events.BeginUsageTraversalEvent;
import edu.kit.ipd.sdq.simcomp.event.workload.WorkloadUserFinished;
import edu.kit.ipd.sdq.simcomp.event.workload.WorkloadUserSpawn;

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
    private final IRegionBasedGarbageCollector<RequestContext> blackboardGarbageCollector = null;

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
        // TODO (SimComp): reactivate garbage collector
        //this.blackboardGarbageCollector = this.model.getProbeSpecContext().getBlackboardGarbageCollector();
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
                //OpenWorkloadGenerator.this.blackboardGarbageCollector.enterRegion(user.getRequestContext().rootContext());
                final double waitingTime = StackContext.evaluateStatic(OpenWorkloadGenerator.this.interarrivalTime.getSpecification(), Double.class);
                OpenWorkloadGenerator.this.spawnUser(waitingTime);
            }

            @Override
            public void leftSystem() {
            	// trigger event that the user finished his work
            	model.getSimulationMiddleware().triggerEvent(new WorkloadUserFinished(user));

                //OpenWorkloadGenerator.this.blackboardGarbageCollector.leaveRegion(user.getRequestContext().rootContext());
                OpenWorkloadGenerator.this.model.increaseMainMeasurementsCount();
            }

        });
        
        new BeginUsageTraversalEvent(this.model, scenario).schedule(user, waitingTime);
    }

}
