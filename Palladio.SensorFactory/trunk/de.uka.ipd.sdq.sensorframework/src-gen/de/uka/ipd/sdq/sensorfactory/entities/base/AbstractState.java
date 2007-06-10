
		package de.uka.ipd.sdq.sensorfactory.entities.base;
		@javax.persistence.Entity
		
			@javax.persistence.Table(name="STATE")
		
		public abstract class AbstractState
		
		implements 
	de.uka.ipd.sdq.sensorfactory.entities.State

		{
			
			protected transient de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory  myDAOFactory = null;
				public AbstractState(de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory myFactory) {
					this.myDAOFactory = myFactory;
				}
			
			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
			
	
	@javax.persistence.Id
	@javax.persistence.Column(name="STATEID")
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)

	private 
	long
 m_stateID;
	public 
	
	long
 getStateID()
 {
		return m_stateID;
	}
	public 
	void setStateID(
	long
 value)
 {
		this.m_stateID = value;
	}
;
	
	
		@javax.persistence.Column(name="STATELITERAL")
	

	private 
	String
 m_stateLiteral;
	public 
	
	String
 getStateLiteral()
 {
		return m_stateLiteral;
	}
	public 
	void setStateLiteral(
	String
 value)
 {
		this.m_stateLiteral = value;
	}

			
			/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are not a composition */
			
			
			/* Getter and Setter for Properties with cardinality 0..* which are a composition */
			
			
			/* Abstract Operations */
			
		}
	