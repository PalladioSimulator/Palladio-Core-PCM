
		package de.uka.ipd.sdq.sensorfactory.entities.dao;

import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
		public interface IExperimentRunDAO {
			
				
	de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun addExperimentRun(
		
		
   
	String
 p_experimentdatetime
	)
;
			

			/* Finder methods to search for ExperimentRuns */
			;

			de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun get(long id);
			java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun> getExperimentRuns();


			void store(ExperimentRun er);
		} 
	