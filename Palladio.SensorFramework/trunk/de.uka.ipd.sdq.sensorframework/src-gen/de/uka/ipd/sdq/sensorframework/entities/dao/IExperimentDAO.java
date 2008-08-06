
package de.uka.ipd.sdq.sensorframework.entities.dao;

public interface IExperimentDAO {


	de.uka.ipd.sdq.sensorframework.entities.Experiment 
		addExperiment(String p_experimentname);
	
	/**
	 * delete the experiment data and remove it from the dao
	 * @param experiment the experiment to remove
	 * @param doCascade should the remove cascade down to children and remove them aswell
	 */
	void removeExperiment(de.uka.ipd.sdq.sensorframework.entities.Experiment experiment, boolean doCascade);

	/** 
	 * Finder methods to search for Experiments. Returns a collection of experiments with that name. 
	 * @return A collection of matching experiment. The collection might be empty, but must not be null.  
	 * 
	 */
	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Experiment> 
		findByExperimentName(String searchKey);

	de.uka.ipd.sdq.sensorframework.entities.Experiment get(long id);
	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Experiment> getExperiments();


	void storeAll();
} 
