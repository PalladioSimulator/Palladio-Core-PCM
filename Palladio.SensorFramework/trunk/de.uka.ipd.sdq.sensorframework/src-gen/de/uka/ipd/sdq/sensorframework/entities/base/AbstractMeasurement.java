
		package de.uka.ipd.sdq.sensorframework.entities.base;
		@javax.persistence.Entity
		
			@javax.persistence.Table(name="MEASUREMENT")
		
		public abstract class AbstractMeasurement
		
		implements 
	de.uka.ipd.sdq.sensorframework.entities.Measurement

		{
			
			protected transient de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory  myDAOFactory = null;
				public AbstractMeasurement(de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory myFactory) {
					this.myDAOFactory = myFactory;
				}
			
			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
			
	
	@javax.persistence.Id
	@javax.persistence.Column(name="MEASUREMENTID")
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)

	private 
	long
 m_measurementID;
	public 
	
	long
 getMeasurementID()
 {
		return m_measurementID;
	}
	public 
	void setMeasurementID(
	long
 value)
 {
		this.m_measurementID = value;
	}
;
	
	
		@javax.persistence.Column(name="EVENTTIME")
	

	private 
	double
 m_eventTime;
	public 
	
	double
 getEventTime()
 {
		return m_eventTime;
	}
	public 
	void setEventTime(
	double
 value)
 {
		this.m_eventTime = value;
	}

			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are not a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are a composition */
			
			
			/* Abstract Operations */
			
		}
	