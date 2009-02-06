/**
 * 
 */
package de.uka.ipd.sdq.sensorframework;

import java.util.List;

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
	 * @return <code>true</code> if the storage is not accessible.
	 */
	public boolean isStorageClosed();
	
	/**Returns identifiers for all experiment groups at the opened storage.
	 * @return List of UUIDs.
	 */
	public List<String> getStoredExperimentGroupUuids();
	
	// Creating DAOs
	
	/**Creates a DAO to access experiment groups.
	 * @param uuid UUID of the experiment group.
	 * @return DAO for the (root) model element experiment group.
	 */
	public ExperimentGroupDao createExperimentGroupDao(String uuid);
	
	/**Creates a DAO to access measured data of type double.
	 * @param uuid UUID of the Measurement.
	 * @return DAO for the measurements with the specified uuid.
	 */
	public BinaryMeasurementsDao<Double> createDoubleMeasurementDataDao(String uuid);
}
