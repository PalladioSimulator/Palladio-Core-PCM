package de.uka.ipd.sdq.simulation.workload;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.entities.IEntityListener;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.events.SpawnUserEvent;

public class ClosedWorkloadDriver implements IWorkloadDriver {

    private EventSimModel model;
    private ClosedWorkload workload;
    private int population;
    private PCMRandomVariable thinkTime;
    private int userCount;

    public ClosedWorkloadDriver(EventSimModel model, ClosedWorkload workload) {
        this.model = model;
        this.workload = workload;
        this.population = workload.getPopulation();
        this.thinkTime = workload.getThinkTime_ClosedWorkload();
    }

    @Override
    public void start() {
        // spawn initial user population
        for (int i = 0; i < population; i++) {
            spawnUser();
        }
    }

    @Override
    public int getUserCount() {
        return userCount;
    }

    private void spawnUser() {
        User u = new User(model, workload.getUsageScenario_Workload());
        // TODO is it correct to use the user's context here?
        u.addEntityListener(new IEntityListener() {

            @Override
            public void leftSystem() {
                userCount--;
                spawnUser();
            }

            @Override
            public void enteredSystem() {
                userCount++;
            }
        });
        new SpawnUserEvent(model).schedule(u, StackContext.evaluateStatic(thinkTime.getSpecification(), Double.class));
    }

}
