package de.uka.ipd.sdq.sensorfactory;

import java.util.Collection;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;

public interface IExperimentDAO {
	Experiment createExperiment(String experimentName);
	Collection<Experiment> getExperiments();
	String getName();
	String getDescription();
	void storeExperiment(Experiment experiment);
	void insertExperiment(Experiment experiment);
	Experiment createOrReuseExperiment(String nameExperimentRun);
}