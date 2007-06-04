
		package de.uka.ipd.sdq.sensorfactory.entities.base;
		@javax.persistence.Entity
		
		public abstract class AbstractStateMeasurement
		
			extends de.uka.ipd.sdq.sensorfactory.entities.base.AbstractMeasurement
		
		implements 
	de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement

		{
			
				public AbstractStateMeasurement(de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory myFactory) {
					super(myFactory);
				}
			
			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
			
	
	
		@javax.persistence.OneToOne(
		
		)
		@javax.persistence.JoinColumn(name="FK_SENSORSTATE")
	

	private 
	de.uka.ipd.sdq.sensorfactory.entities.State
 m_sensorState;
	public 
	
	de.uka.ipd.sdq.sensorfactory.entities.State
 getSensorState()
 {
		return m_sensorState;
	}
	public 
	void setSensorState(
	de.uka.ipd.sdq.sensorfactory.entities.State
 value)
 {
		this.m_sensorState = value;
	}
;
	
	
		@javax.persistence.OneToOne(
		
		)
		@javax.persistence.JoinColumn(name="FK_SENSOR")
	

	private 
	de.uka.ipd.sdq.sensorfactory.entities.StateSensor
 m_sensor;
	public 
	
	de.uka.ipd.sdq.sensorfactory.entities.StateSensor
 getSensor()
 {
		return m_sensor;
	}
	public 
	void setSensor(
	de.uka.ipd.sdq.sensorfactory.entities.StateSensor
 value)
 {
		this.m_sensor = value;
	}

			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are not a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are a composition */
			
			
			/* Abstract Operations */
			
		}
	