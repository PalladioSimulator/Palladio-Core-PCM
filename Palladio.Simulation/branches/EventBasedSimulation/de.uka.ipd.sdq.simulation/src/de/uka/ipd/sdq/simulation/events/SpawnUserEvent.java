package de.uka.ipd.sdq.simulation.events;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.entities.User;

public class SpawnUserEvent extends AbstractSimEvent<EventSimModel, User> {

    private static Logger logger = Logger.getLogger(SpawnUserEvent.class);

    public SpawnUserEvent(EventSimModel owner) {
        super(owner, SpawnUserEvent.class.getName());
    }

    @Override
    public void eventRoutine(User who) {
        if (logger.isDebugEnabled()) {
            logger.debug("Spawned " + who.getName());
        }

        // schedule simulation of the user's behavior
        final ScenarioBehaviour behaviour = who.getScenario().getScenarioBehaviour_UsageScenario();
        new TraverseScenarioBehaviourEvent(this.getModel(), behaviour).schedule(who, 0);
    }

}
