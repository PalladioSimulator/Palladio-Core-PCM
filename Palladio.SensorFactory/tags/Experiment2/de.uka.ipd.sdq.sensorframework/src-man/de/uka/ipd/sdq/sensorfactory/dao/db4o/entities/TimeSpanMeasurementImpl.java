package de.uka.ipd.sdq.sensorfactory.dao.db4o.entities;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorfactory.dao.db4o.util.IByteSerialisable;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

@javax.persistence.Entity
public class TimeSpanMeasurementImpl extends de.uka.ipd.sdq.sensorfactory.entities.base.AbstractTimeSpanMeasurement 
implements IByteSerialisable {

	public TimeSpanMeasurementImpl(IDAOFactory myFactory) {
		super(myFactory);
	}

	public TimeSpanMeasurementImpl() {
		super(null);
	}
	
	public void objectOnActivate(com.db4o.ObjectContainer arg0) {
		this.myDAOFactory = DB4ODAOFactory.factoryRegistry.get(arg0);
	}

	public void fromBytes(DataInputStream stream) throws IOException {
		this.setTimeSpan(stream.readDouble());
		this.setEventTime(stream.readDouble());
	}

	public void toBytes(DataOutputStream stream) throws IOException {
		stream.writeDouble(this.getTimeSpan());
		stream.writeDouble(this.getEventTime());
	}
}
