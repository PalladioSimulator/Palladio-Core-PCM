package de.uka.ipd.sdq.sensorfactory.entities.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.sensorfactory.IExperimentDAO;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;

public class MemoryStoreExperimentDAO implements IExperimentDAO {

	private ArrayList<Experiment> experiments = new ArrayList<Experiment>();
	
	public Experiment createExperiment(String experimentName) {
		Experiment ex = new ExperimentImpl();
		experiments.add(ex);
		ex.setExperimentName(experimentName);
		return ex;
	}

	public Collection<Experiment> getExperiments() {
		return Collections.unmodifiableCollection(experiments);
	}

	public String getDescription() {
		return "A datasource stored in memory. Changes are lost, when unsafed";
	}

	public String getName() {
		return "Memory Datasource";
	}

	public void storeExperiment(Experiment experiment) {
		// nothing to do for memory based storage
	}

	@Override
	public void insertExperiment(Experiment experiment) {
		experiments.add(experiment);
	}
}
