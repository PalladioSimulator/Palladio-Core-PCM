package de.uka.ipd.sdq.sensorframework.entities.impl;

import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

@javax.persistence.Entity
public class TimeSpanMeasurementImpl extends de.uka.ipd.sdq.sensorframework.entities.base.AbstractTimeSpanMeasurement {

	public TimeSpanMeasurementImpl(IDAOFactory myFactory) {
		super(myFactory);
		// TODO Auto-generated constructor stub
	}
	
	/** {@inheritDoc}
	 */
	public void setTimeSpan(double value) {
		if (value < 0)
			throw new RuntimeException("TimeSpan Measurements are not allowed to be smaller than 0.");
		
		super.setTimeSpan(value);
	}
}
