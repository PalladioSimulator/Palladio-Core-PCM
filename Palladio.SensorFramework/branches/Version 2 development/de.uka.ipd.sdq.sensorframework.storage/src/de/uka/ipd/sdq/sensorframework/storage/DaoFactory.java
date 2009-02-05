/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.storage;

import de.uka.ipd.sdq.sensorframework.ExperimentGroup;

/**Factory for creating DataAccessObjects (DAO) of the sensorframework.
 * This allows to access measured data as well as metadata.
 * @author groenda
 */
public interface DaoFactory {
	// Connection and access to storage
	
	/**Opens the connection to the storage and makes it accessible.
	 * @throws DataNotAccessibleException Errors when initializing the data access.
	 */
	public void openStorage() throws DataNotAccessibleException;
	
	/**Closes the access connection to the storage.
	 * If necessary, data is persisted before closing.
	 * @throws DataNotAccessibleException Errors when initializing the data access.
	 */
	public void closeStorage() throws DataNotAccessibleException;
	
	/**Returns if the storage is in an accessible state.
	 * @return
	 */
	public boolean isStorageClosed();
	
	// Creating DAOs
	
	/**Creates a DAO to access experiment groups.
	 * @return DAO for the (root) model element experiment group.
	 */
	public ExperimentGroup createExperimentGroupDao();
	
	/**Creates a DAO to access measured data of type double.
	 * @param uuid UUID of the Measurement.
	 * @return DAO for the measurements with the specified uuid.
	 */
	public MeasurementDataDao<Double> createDoubleMeasurementDataDao(String uuid);
}
