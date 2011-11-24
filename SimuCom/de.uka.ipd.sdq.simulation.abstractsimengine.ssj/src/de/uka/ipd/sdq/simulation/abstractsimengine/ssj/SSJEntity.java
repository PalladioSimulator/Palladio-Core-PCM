/**
 * 
 */
package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 */
public class SSJEntity implements IEntity {

    private AbstractSimEntityDelegator entity;

    protected boolean isScheduled = false;
    protected Event nextEventForThisEntity = null;

    public SSJEntity(AbstractSimEntityDelegator entity, String name) {
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
