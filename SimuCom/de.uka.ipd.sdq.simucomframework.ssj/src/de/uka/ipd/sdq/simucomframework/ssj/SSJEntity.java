/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.ssj;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.IEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;

/**
 * @author Steffen Becker
 *
 */
public class SSJEntity<M extends ISimulationModel<M>> implements IEntity {

	private AbstractSimEntity<M> entity;
	
	// TODO make these private
	protected boolean isScheduled = false;
	protected Event nextEventForThisEntity = null;
	
	public SSJEntity(AbstractSimEntity<M> entity, String name) {
		// super(owner, name, false);
		this.entity = entity;
	}

	public IEntity getEncapsulatedEntity() {
		return entity;
	}

	public boolean isScheduled() {
		return isScheduled;
	}

	public void reschedule(double d) {
	    // TODO this seems weird
		nextEventForThisEntity.reschedule(d);
	}

}
