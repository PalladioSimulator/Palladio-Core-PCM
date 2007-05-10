package de.uka.ipd.sdq.sensorfactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.sensorfactory.entities.impl.JPAExperimentDAO;
import de.uka.ipd.sdq.sensorfactory.entities.impl.MemoryStoreExperimentDAO;

public class SensorFrameworkDataset {
	private static SensorFrameworkDataset singleton = new SensorFrameworkDataset();
	private ArrayList<IExperimentDAO> datasources = new ArrayList<IExperimentDAO>();
	
	private SensorFrameworkDataset() {
		datasources.add(new MemoryStoreExperimentDAO());
		datasources.add(new JPAExperimentDAO("Dery DB"));
	}
	
	public static SensorFrameworkDataset singleton() {
		return singleton;
	}
	
	public Collection<IExperimentDAO> getDataSources() {
		return Collections.unmodifiableCollection(datasources);
	}
	
	public IExperimentDAO getMemoryDataset() {
		return datasources.get(0);
	}
	
	public IExperimentDAO getDataset(int pos){
		return datasources.get(pos);
	}
}
