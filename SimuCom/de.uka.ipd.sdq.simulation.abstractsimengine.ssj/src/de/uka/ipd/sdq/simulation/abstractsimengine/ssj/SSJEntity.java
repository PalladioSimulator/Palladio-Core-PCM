/**
 * 
 */
package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 */
public class SSJEntity<M extends ISimulationModel<M>> implements IEntity {

    private AbstractSimEntity<M> entity;

    protected boolean isScheduled = false;
    protected Event nextEventForThisEntity = null;

    public SSJEntity(AbstractSimEntity<M> entity, String name) {
        this.entity = entity;
    }

    public IEntity getEncapsulatedEntity() {
        return entity;
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void reschedule(double d) {
        nextEventForThisEntity.reschedule(d);
    }

}
