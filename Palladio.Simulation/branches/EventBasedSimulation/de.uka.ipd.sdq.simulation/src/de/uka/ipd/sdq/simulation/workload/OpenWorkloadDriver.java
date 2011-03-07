package de.uka.ipd.sdq.simulation.workload;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.entities.IEntityListener;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.events.SpawnUserEvent;

public class OpenWorkloadDriver implements IWorkloadDriver {

    private EventSimModel model;
    private OpenWorkload workload;
    private PCMRandomVariable interarrivalTime;
    private int userCount;

    public OpenWorkloadDriver(EventSimModel model, OpenWorkload workload) {
        this.model = model;
        this.workload = workload;
        
        // TODO korrekt!?? nicht eher median der verteilung o.ä.!?
        this.interarrivalTime = workload.getInterArrivalTime_OpenWorkload();
    }

    @Override
    public int getUserCount() {
        return userCount;
    }

    public void start() {
        // spawn initial user
        spawnUser();
    }

    private void spawnUser() {
        // spawn user to traverse the specified usage scenario
        User user = new User(model, workload.getUsageScenario_Workload());
        user.addEntityListener(new IEntityListener() {

            @Override
            public void leftSystem() {
                userCount--;
            }

            @Override
            public void enteredSystem() {
                userCount++;
                spawnUser();
            }
        });
        double delay = StackContext.evaluateStatic(interarrivalTime.getSpecification(), Double.class);
        new SpawnUserEvent(model).schedule(user, delay);
    }

}
