package de.uka.ipd.sdq.sensorfactory.dao.db4o.entities;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

@javax.persistence.Entity
public class TimeSpanSensorImpl extends de.uka.ipd.sdq.sensorfactory.entities.base.AbstractTimeSpanSensor {

	public TimeSpanSensorImpl(IDAOFactory myFactory) {
		super(myFactory);
		// TODO Auto-generated constructor stub
	}

	public void objectOnActivate(com.db4o.ObjectContainer arg0) {
		this.myDAOFactory = DB4ODAOFactory.factoryRegistry.get(arg0);
	}

}
