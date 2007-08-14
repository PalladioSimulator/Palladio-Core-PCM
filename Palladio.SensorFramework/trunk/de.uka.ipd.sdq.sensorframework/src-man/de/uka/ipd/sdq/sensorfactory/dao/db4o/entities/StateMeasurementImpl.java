package de.uka.ipd.sdq.sensorfactory.dao.db4o.entities;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorfactory.dao.db4o.util.IByteSerialisable;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

@javax.persistence.Entity
public class StateMeasurementImpl extends de.uka.ipd.sdq.sensorfactory.entities.base.AbstractStateMeasurement 
implements IByteSerialisable {

	public StateMeasurementImpl(IDAOFactory myFactory) {
		super(myFactory);
	}

	public StateMeasurementImpl() {
		super(null);
	}
	
	public void objectOnActivate(com.db4o.ObjectContainer arg0) {
		this.myDAOFactory = DB4ODAOFactory.factoryRegistry.get(arg0);
	}

	public void fromBytes(DataInputStream stream) throws IOException {
		this.setEventTime(stream.readDouble());
		long id = stream.readLong();
		this.setSensorState(this.myDAOFactory.createStateDAO().get(id));
	}

	public void toBytes(DataOutputStream stream) throws IOException {
		stream.writeDouble(this.getEventTime());
		stream.writeLong(this.getSensorState().getStateID());
	}
}
