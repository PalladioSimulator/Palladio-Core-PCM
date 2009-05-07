package de.uka.ipd.sdq.sensorframework.entities.impl;

import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

@javax.persistence.Entity
public class TimeSpanMeasurementImpl extends de.uka.ipd.sdq.sensorframework.entities.base.AbstractTimeSpanMeasurement {

	/** Difference up to which two values are considered as equal.
	 */
	public static final double EPSILON_ERROR = 1e-5;
	
	public TimeSpanMeasurementImpl(IDAOFactory myFactory) {
		super(myFactory);
	}
	
	/** {@inheritDoc}
	 */
	public void setTimeSpan(double value) {
		if (value < -EPSILON_ERROR)
			throw new RuntimeException("TimeSpan Measurements are not allowed to be smaller than 0.");
		if (value < 0)
			value = 0;
		
		super.setTimeSpan(value);
	}
}
