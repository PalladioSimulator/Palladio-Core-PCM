package de.uka.ipd.sdq.sensorframework.entities.dao;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;

public interface IExperimentRunDAO {

	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun addExperimentRun(

	String p_experimentdatetime);
	
	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun addScalabilityExperimentRun(

			String p_experimentdatetime);

	/* Finder methods to search for ExperimentRuns */
	;
	
	void removeExperimentRun(de.uka.ipd.sdq.sensorframework.entities.ExperimentRun experimentRun, boolean doCascade);

	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun get(long id);

	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.ExperimentRun> getExperimentRuns();

	void storeAll();
}
