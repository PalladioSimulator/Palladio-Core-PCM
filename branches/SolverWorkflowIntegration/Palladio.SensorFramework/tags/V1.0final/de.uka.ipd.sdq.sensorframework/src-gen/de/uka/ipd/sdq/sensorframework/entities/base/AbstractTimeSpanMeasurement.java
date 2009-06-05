
		package de.uka.ipd.sdq.sensorframework.entities.base;
		@javax.persistence.Entity
		
		public abstract class AbstractTimeSpanMeasurement
		
			extends de.uka.ipd.sdq.sensorframework.entities.base.AbstractMeasurement
		
		implements 
	de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement

		{
			
				public AbstractTimeSpanMeasurement(de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory myFactory) {
					super(myFactory);
				}
			
			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
			
	
	
		@javax.persistence.Column(name="TIMESPAN")
	

	private 
	double
 m_timeSpan;
	public 
	
	double
 getTimeSpan()
 {
		return m_timeSpan;
	}
	public 
	void setTimeSpan(
	double
 value)
 {
		this.m_timeSpan = value;
	}
;
	
	
		@javax.persistence.OneToOne(
		
		)
		@javax.persistence.JoinColumn(name="FK_SENSOR")
	

	private 
	de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor
 m_sensor;
	public 
	
	de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor
 getSensor()
 {
		return m_sensor;
	}
	public 
	void setSensor(
	de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor
 value)
 {
		this.m_sensor = value;
	}

			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are not a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are a composition */
			
			
			/* Abstract Operations */
			
		}
	