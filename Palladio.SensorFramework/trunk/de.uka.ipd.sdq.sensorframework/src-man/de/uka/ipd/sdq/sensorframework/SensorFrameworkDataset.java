package de.uka.ipd.sdq.sensorframework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * Provides access to the single dataset of the SensorFramework. Used to display
 * all datasources in the SimuBench Perspective.
 * 
 * @author Steffen Becker
 * @author groenda
 */
public class SensorFrameworkDataset {
	private static SensorFrameworkDataset singleton = new SensorFrameworkDataset();
	private ArrayList<IDAOFactory> datasources = new ArrayList<IDAOFactory>();
	private long nextID = 1;

	private SensorFrameworkDataset() {
	}

	/**
	 * @return the one central instance containing all datasources.
	 */
	public static SensorFrameworkDataset singleton() {
		return singleton;
	}

	/**
	 * Returns all data sources in the dataset.
	 * 
	 * @return datasources.
	 */
	public synchronized Collection<IDAOFactory> getDataSources() {
		return Collections.unmodifiableCollection(datasources);
	}

	/**
	 * Retrieve a datasource by its dynamic numeric identifier.
	 * 
	 * @param id
	 *            id of the datasource.
	 * @return datasource.
	 */
	public synchronized IDAOFactory getDataSourceByID(long id) {
		for (IDAOFactory f : datasources)
			if (f.getID() == id)
				return f;
		return null;
	}

	/**
	 * Add a provided datasource.
	 * 
	 * @param factory
	 *            the datasource.
	 */
	public synchronized void addDataSource(IDAOFactory factory) {
		for (IDAOFactory f : datasources) {
			if (f.getID() == factory.getID())
				throw new RuntimeException(
						"Attemped to add Datasource with an ID already existing in the Sensorframework Dataset.");
			if (f.getID() == nextID
					&& factory.getID() == IDAOFactory.ID_NOT_SET)
				throw new RuntimeException(
						"Conflict of IDs occurred when attemping to add a new datasource to the Sensorframework Dataset.");
		}

		datasources.add(factory);
		if (factory.getID() == IDAOFactory.ID_NOT_SET) {
			factory.setID(nextID);
			nextID += 1;
		} else {
			if (factory.getID() >= nextID) {
				// reset nextID completely
				this.nextID = Long.MIN_VALUE;
				for (IDAOFactory f : datasources) {
					if (f.getID() >= nextID)
						this.nextID = f.getID() + 1;
				}
			}
		}
	}

	/**
	 * Removes a datasource from the current Dataset.
	 * 
	 * @param factory
	 *            the datasource itself to remove.
	 */
	public synchronized void removeDataSource(IDAOFactory factory) {
		factory.finalizeAndClose();
		datasources.remove(factory);
	}

	/**
	 * Removes all data sources from the current data set.
	 */
	public synchronized void removeAllDataSources() {
		while (datasources.size() > 0) {
			removeDataSource(datasources.get(0));
		}
	}

	/**
	 * Reloads all known datasources. Throws runtime exeception if some
	 * datasources are faulty.
	 */
	public synchronized void reload() {
		String errorMessage = "";
		boolean failed = false;
		for (IDAOFactory f : datasources) {
			try {
				f.reload();
			} catch (Exception e) {
				failed = true;
				errorMessage += ">" + e.getMessage() + "< ";
				this.removeDataSource(f);
			}
		}
		if (failed) {
			throw new RuntimeException(
					"Some Datasources failed to reload. Please see Error Log for details. Details: "
							+ errorMessage);
		}
	}
}
