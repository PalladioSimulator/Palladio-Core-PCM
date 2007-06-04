
		package de.uka.ipd.sdq.sensorfactory.entities.dao;
		public interface IStateDAO {
			
				
	de.uka.ipd.sdq.sensorfactory.entities.State addState(
		
		
   
	String
 p_stateliteral
	)
;
			

			/* Finder methods to search for States */
			
	java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.State> findByStateLiteral
		(
	String
 searchKey);
;

			de.uka.ipd.sdq.sensorfactory.entities.State get(long id);
			java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.State> getStates();
		} 
	