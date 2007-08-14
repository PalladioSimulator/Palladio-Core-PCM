
		package de.uka.ipd.sdq.sensorframework.entities.base;
		@javax.persistence.Entity
		
		public abstract class AbstractStateSensor
		
			extends de.uka.ipd.sdq.sensorframework.entities.base.AbstractSensor
		
		implements 
	de.uka.ipd.sdq.sensorframework.entities.StateSensor

		{
			
				public AbstractStateSensor(de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory myFactory) {
					super(myFactory);
				}
			
			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
			
	
	
		@javax.persistence.OneToOne(
		
		)
		@javax.persistence.JoinColumn(name="FK_INITIALSTATE")
	

	private 
	de.uka.ipd.sdq.sensorframework.entities.State
 m_initialState;
	public 
	
	de.uka.ipd.sdq.sensorframework.entities.State
 getInitialState()
 {
		return m_initialState;
	}
	public 
	void setInitialState(
	de.uka.ipd.sdq.sensorframework.entities.State
 value)
 {
		this.m_initialState = value;
	}

			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are not a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are a composition */
			
	
	@javax.persistence.OneToMany(cascade=javax.persistence.CascadeType.ALL)
	@javax.persistence.JoinTable(name="StateSensor_sensorStates",
					joinColumns={@javax.persistence.JoinColumn(name="STATESENSOR_ID")},
					inverseJoinColumns={@javax.persistence.JoinColumn(name="SENSORSTATE_ID")})

	private java.util.Collection<
	de.uka.ipd.sdq.sensorframework.entities.State
> m_sensorStates 
	   = new java.util.ArrayList<
	de.uka.ipd.sdq.sensorframework.entities.State
>();
	
		public 
	de.uka.ipd.sdq.sensorframework.entities.State addState(
		
		
   
	String
 p_stateliteral
	)
 {
			
	de.uka.ipd.sdq.sensorframework.entities.State
 result = 
				myDAOFactory.createStateDAO().addState(


			
			
				p_stateliteral
			);

			m_sensorStates.add(result);
			return result;
		}
	
	public 
	void addSensorState(de.uka.ipd.sdq.sensorframework.entities.State value)
 {
		this.m_sensorStates.add(value);
	}
	public 
	java.util.Collection<
	de.uka.ipd.sdq.sensorframework.entities.State
> getSensorStates()
 {
		return this.m_sensorStates;
	}

			
			/* Abstract Operations */
			
		}
	