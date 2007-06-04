
		package de.uka.ipd.sdq.sensorfactory.entities.dao;
		public interface IExperimentDAO {
			
				
	de.uka.ipd.sdq.sensorfactory.entities.Experiment addExperiment(
		
		
   
	String
 p_experimentname
	)
;
			

			/* Finder methods to search for Experiments */
			
	java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Experiment> findByExperimentName
		(
	String
 searchKey);
;

			de.uka.ipd.sdq.sensorfactory.entities.Experiment get(long id);
			java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Experiment> getExperiments();
		} 
	