package de.uka.ipd.sdq.simulation.events;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.SimulatedComponentInstance;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.entities.Request;

public class SpawnRequestEvent extends AbstractSimEvent<EventSimModel, Request> {

    private static Logger logger = Logger.getLogger(SpawnRequestEvent.class);

    private SimulatedComponentInstance component;
    private OperationSignature signature;

    public SpawnRequestEvent(EventSimModel model, SimulatedComponentInstance component, OperationSignature signature) {
        super(model, SpawnRequestEvent.class.getName());
        this.component = component;
        this.signature = signature;
    }

    @Override
    public void eventRoutine(Request who) {
        if (logger.isDebugEnabled()) {
            logger.debug("Spawned " + who.getName());
        }

        new TraverseResourceDemandingBehaviourEvent(this.getModel(), component, signature).schedule(who, 0);
    }

}
