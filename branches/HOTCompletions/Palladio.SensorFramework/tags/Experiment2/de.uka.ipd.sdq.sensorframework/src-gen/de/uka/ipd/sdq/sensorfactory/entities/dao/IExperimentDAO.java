
package de.uka.ipd.sdq.sensorfactory.entities.dao;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
public interface IExperimentDAO {


	de.uka.ipd.sdq.sensorfactory.entities.Experiment 
		addExperiment(String p_experimentname);
	
	/**
	 * delete the experiment data and remove it from the dao
	 * @param experiment the experiment to remove
	 * @param doCascade should the remove cascade down to children and remove them aswell
	 */
	void removeExperiment(de.uka.ipd.sdq.sensorfactory.entities.Experiment experiment, boolean doCascade);

	/* Finder methods to search for Experiments */

	java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Experiment> 
		findByExperimentName(String searchKey);

	de.uka.ipd.sdq.sensorfactory.entities.Experiment get(long id);
	java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Experiment> getExperiments();


	void store(Experiment e);
} 
