package de.uka.ipd.sdq.simulation.workload;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.entities.IEntityListener;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.events.BeginUsageTraversalEvent;

/**
 * A closed workload is a workload sustaining a fixed amount of {@link User}s, which are called the
 * workload population. The workload starts with generating a whole user generation. Whenever a user
 * finishes its usage scenario, a new user is generated after waiting a specified amount of time.
 * This duration is called the think time of an user.
 * 
 * @author Philipp Merkle
 * 
 */
public class ClosedWorkloadGenerator implements IWorkloadGenerator {

    private final EventSimModel model;
    private final ClosedWorkload workload;
    private final int population;
    private final PCMRandomVariable thinkTime;
    private final IRegionBasedGarbageCollector<RequestContext> blackboardGarbageCollector;

    /**
     * Constructs a closed workload in accordance with the specified workload description.
     * 
     * @param model
     *            the model
     * @param workload
     *            the workload description
     */
    public ClosedWorkloadGenerator(final EventSimModel model, final ClosedWorkload workload) {
        this.model = model;
        this.workload = workload;
        this.population = workload.getPopulation();
        this.thinkTime = workload.getThinkTime_ClosedWorkload();
        this.blackboardGarbageCollector = this.model.getProbeSpecContext().getBlackboardGarbageCollector();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processWorkload() {
        // spawn initial user population
        for (int i = 0; i < this.population; i++) {
            this.spawnUser();
        }
    }

    /**
     * Creates a new user and schedules him to enter the system after the think time has passed.
     */
    private void spawnUser() {
        // create the user
        final UsageScenario scenario = this.workload.getUsageScenario_Workload();
        final User user = new User(this.model, scenario);

        // when the user leaves the system, we schedule a new one
        user.addEntityListener(new IEntityListener() {

            @Override
            public void leftSystem() {
                ClosedWorkloadGenerator.this.blackboardGarbageCollector.leaveRegion(user.getRequestContext()
                        .rootContext());
                ClosedWorkloadGenerator.this.model.increaseMainMeasurementsCount();
                ClosedWorkloadGenerator.this.spawnUser();
            }

            @Override
            public void enteredSystem() {
                ClosedWorkloadGenerator.this.blackboardGarbageCollector.enterRegion(user.getRequestContext()
                        .rootContext());
            }
            
        });
        final double waitingTime = StackContext.evaluateStatic(this.thinkTime.getSpecification(), Double.class);
        new BeginUsageTraversalEvent(this.model, scenario).schedule(user, waitingTime);
    }

}
