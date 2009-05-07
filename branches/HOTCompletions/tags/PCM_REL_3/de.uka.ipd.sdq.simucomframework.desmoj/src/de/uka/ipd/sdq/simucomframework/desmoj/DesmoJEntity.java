/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

/**
 * @author Snowball
 *
 */
public class DesmoJEntity extends Entity implements IEntityDelegate {

	private de.uka.ipd.sdq.simucomframework.abstractSimEngine.Entity myAbstractEntity;

	public DesmoJEntity(de.uka.ipd.sdq.simucomframework.abstractSimEngine.Entity entity, Model owner, String name) {
		super(owner, name, false);
		this.myAbstractEntity = entity;
	}

	public IEntityDelegate getEntity() {
		return myAbstractEntity;
	}

	public void reschedule(double d) {
		this.reSchedule(new SimTime(d));
	}

}
