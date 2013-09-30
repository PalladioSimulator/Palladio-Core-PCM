/**
 * 
 */
package de.uka.ipd.sdq.simulation.abstractsimengine.desmoj;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.TimeSpan;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 */
public class DesmoJEntity extends Entity implements IEntity {

    private AbstractSimEntityDelegator entity;
    
	public DesmoJEntity(AbstractSimEntityDelegator entity, DesmoJModel owner, String name) {
		super(owner, name, false);
		this.entity = entity;
	}

    @Override
    public void reschedule(double delay) {
        this.reSchedule(new TimeSpan(delay));
    }

    public AbstractSimEntityDelegator getEncapsulatedEntity() {
        return entity;
    }

}
