/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.IEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.TimeSpan;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 */
public class DesmoJEntity<M extends ISimulationModel<M>> extends Entity implements IEntity {

    // TODO?
    private AbstractSimEntity<M> entity;
    
	public DesmoJEntity(AbstractSimEntity<M> entity, DesmoJModel<M> owner, String name) {
		super(owner, name, false);
		this.entity = entity;
	}

    @Override
    public void reschedule(double delay) {
        this.reSchedule(new TimeSpan(delay));
    }

    public AbstractSimEntity<M> getEncapsulatedEntity() {
        return entity;
    }

  

}
