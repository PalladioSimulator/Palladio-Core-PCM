package de.uka.ipd.sdq.sensorfactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorfactory.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

public class SensorFrameworkDataset {
	private static SensorFrameworkDataset singleton = new SensorFrameworkDataset();
	private ArrayList<IDAOFactory> datasources = new ArrayList<IDAOFactory>();
	private int nextID = 1;
	
	private SensorFrameworkDataset() {
		//datasources.add(new MemoryDAOFactory(0));
		//datasources.add(new DB4ODAOFactory(1,"C:\\temp\\test.db"));
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
	
	public IDAOFactory getDataSourceByID(long id){
		for (IDAOFactory f:datasources)
			if (f.getID() == id)
				return f;
		return null;
	}

	public void addDataSource(IDAOFactory factory) {
		datasources.add(factory);
		factory.setID(nextID ++);
	}

	public void removeDataSource(IDAOFactory factory) {
		factory.finalizeAndClose();
		datasources.remove(factory);
	}
}
