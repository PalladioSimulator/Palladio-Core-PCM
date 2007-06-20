
package de.uka.ipd.sdq.sensorfactory.entities.dao;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
public interface IExperimentDAO {


	de.uka.ipd.sdq.sensorfactory.entities.Experiment 
		addExperiment(String p_experimentname);
	
	void removeExperiment(de.uka.ipd.sdq.sensorfactory.entities.Experiment experiment);

	/* Finder methods to search for Experiments */

	java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Experiment> 
		findByExperimentName(String searchKey);

	de.uka.ipd.sdq.sensorfactory.entities.Experiment get(long id);
	java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Experiment> getExperiments();


	void store(Experiment e);
} 
