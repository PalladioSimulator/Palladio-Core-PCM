package de.uka.ipd.sdq.sensorframework.dao.db4o.entities;

import de.uka.ipd.sdq.sensorframework.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

@javax.persistence.Entity
public class StateSensorImpl extends de.uka.ipd.sdq.sensorframework.entities.base.AbstractStateSensor {

	public StateSensorImpl(IDAOFactory myFactory) {
		super(myFactory);
		// TODO Auto-generated constructor stub
	}
	
	public void objectOnActivate(com.db4o.ObjectContainer arg0) {
		this.myDAOFactory = DB4ODAOFactory.factoryRegistry.get(arg0);
	}

}
