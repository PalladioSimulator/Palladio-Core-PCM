
		package de.uka.ipd.sdq.sensorfactory.entities.base;
		@javax.persistence.Entity
		
			@javax.persistence.Table(name="SENSOR")
		
		public abstract class AbstractSensor
		
		implements 
	de.uka.ipd.sdq.sensorfactory.entities.Sensor

		{
			
			protected transient de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory  myDAOFactory = null;
				public AbstractSensor(de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory myFactory) {
					this.myDAOFactory = myFactory;
				}
			
			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
			
	
	
		@javax.persistence.Column(name="SENSORNAME")
	

	private 
	String
 m_sensorName;
	public 
	
	String
 getSensorName()
 {
		return m_sensorName;
	}
	public 
	void setSensorName(
	String
 value)
 {
		this.m_sensorName = value;
	}
;
	
	@javax.persistence.Id
	@javax.persistence.Column(name="SENSORID")
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)

	private 
	long
 m_sensorID;
	public 
	
	long
 getSensorID()
 {
		return m_sensorID;
	}
	public 
	void setSensorID(
	long
 value)
 {
		this.m_sensorID = value;
	}

			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are not a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are a composition */
			
			
			/* Abstract Operations */
			
		}
	