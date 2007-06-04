package de.uka.ipd.sdq.sensorfactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.sensorfactory.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

public class SensorFrameworkDataset {
	private static SensorFrameworkDataset singleton = new SensorFrameworkDataset();
	private ArrayList<IDAOFactory> datasources = new ArrayList<IDAOFactory>();
	
	private SensorFrameworkDataset() {
		datasources.add(new MemoryDAOFactory());
	}
	
	public static SensorFrameworkDataset singleton() {
		return singleton;
	}
	
	public Collection<IDAOFactory> getDataSources() {
		return Collections.unmodifiableCollection(datasources);
	}
	
	public IDAOFactory getMemoryDataset() {
		return datasources.get(0);
	}
	
	public IDAOFactory getDataset(int pos){
		return datasources.get(pos);
	}
}
