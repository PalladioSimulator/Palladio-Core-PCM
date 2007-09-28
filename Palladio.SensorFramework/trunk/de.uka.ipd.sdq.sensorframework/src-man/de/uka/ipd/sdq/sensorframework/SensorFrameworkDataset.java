package de.uka.ipd.sdq.sensorframework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.sensorframework.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public class SensorFrameworkDataset {
	private static SensorFrameworkDataset singleton = new SensorFrameworkDataset();
	private ArrayList<IDAOFactory> datasources = new ArrayList<IDAOFactory>();
	private long nextID = 1;
	
	private SensorFrameworkDataset() {
		//datasources.add(new MemoryDAOFactory(0));
		//datasources.add(new DB4ODAOFactory(2,"C:\\temp\\test.db"));
		//addDataSource(new FileDAOFactory(1,"D:/temp"));
//		IDAOFactory factory = new FileDAOFactory(2,"D:\\Diss\\dev\\runtime-EclipseApplication\\SchedulerConfigurator\\temp\\");
//		addDataSource(factory);
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
		if (factory.getID() <= 0)
			factory.setID(nextID ++);
		else
			if(factory.getID() > nextID)
				nextID = factory.getID() + 1;
	}

	public void removeDataSource(IDAOFactory factory) {
		factory.finalizeAndClose();
		datasources.remove(factory);
	}
}
