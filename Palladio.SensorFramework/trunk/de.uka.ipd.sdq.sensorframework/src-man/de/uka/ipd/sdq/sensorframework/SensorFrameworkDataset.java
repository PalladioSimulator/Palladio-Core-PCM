package de.uka.ipd.sdq.sensorframework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**TODO add documentation
 * @author Steffen Becker
 *
 */
public class SensorFrameworkDataset {
	private static SensorFrameworkDataset singleton = new SensorFrameworkDataset();
	private ArrayList<IDAOFactory> datasources = new ArrayList<IDAOFactory>();
	private long nextID = 1;
	
	private SensorFrameworkDataset() {
	}
	
	public static SensorFrameworkDataset singleton() {
		return singleton;
	}
	
	public Collection<IDAOFactory> getDataSources() {
		return Collections.unmodifiableCollection(datasources);
	}
	
	public IDAOFactory getDataSourceByID(long id){
		for (IDAOFactory f:datasources)
			if (f.getID() == id)
				return f;
		return null;
	}

	public synchronized void addDataSource(IDAOFactory factory) {
		for(IDAOFactory f : datasources) {
			if (f.getID() == factory.getID())
				throw new RuntimeException("Attemped to add Datasource with an ID already existing in the Sensorframework Dataset");
			if (f.getID() == nextID && factory.getID() <= 0)
				throw new RuntimeException("Attemped to add Datasource with an ID already existing in the Sensorframework Dataset");
		}
		
		datasources.add(factory);
		if (factory.getID() <= 0) {
			factory.setID(nextID);
			nextID += 1;
		}
		else {
			if(factory.getID() >= nextID) {
				this.nextID = 0;
				for (IDAOFactory f : datasources) {
					if (f.getID() >= nextID)
						this.nextID = f.getID() + 1;
				}
			}
		}
	}

	public void removeDataSource(IDAOFactory factory) {
		factory.finalizeAndClose();
		datasources.remove(factory);
	}

	public void reload() {
		String errorMessage = "";
		boolean failed = false;
		for (IDAOFactory f : datasources) {
			try {
				f.reload();
			} catch (Exception e) {
				failed = true;
				errorMessage += ">"+e.getMessage()+"< ";
				this.removeDataSource(f);
			}
		}
		if (failed) {
			throw new RuntimeException("Some Datasources failed to reload. Please see Error Log for details. Details: "+errorMessage);
		}
	}
}
