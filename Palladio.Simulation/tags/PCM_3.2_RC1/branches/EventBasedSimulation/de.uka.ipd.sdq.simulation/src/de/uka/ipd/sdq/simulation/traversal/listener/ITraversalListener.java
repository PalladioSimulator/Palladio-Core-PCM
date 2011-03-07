package de.uka.ipd.sdq.simulation.traversal.listener;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEntity;

public interface ITraversalListener<A extends Entity, E extends AbstractSimEntity<EventSimModel>> {

    public void before(A action, E who);

    public void after(A action, E who);

}
