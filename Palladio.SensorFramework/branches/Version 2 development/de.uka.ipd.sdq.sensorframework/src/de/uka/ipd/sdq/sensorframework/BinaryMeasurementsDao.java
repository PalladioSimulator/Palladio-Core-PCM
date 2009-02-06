package de.uka.ipd.sdq.sensorframework;

import de.uka.ipd.sdq.sensorframework.models.binary.BinaryMeasurements;

/**Interface used to access a list of measurements of a certain type.
 * An example is a list of double values measured for a sensor in an experiment run.
 * @author groenda
 * @param <T> Data type of measurements.
 */
public interface BinaryMeasurementsDao<T> {
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
	
	/**Returns the model for accessing binary measurements.
	 * @return Model for binary measurements.
	 */
	public BinaryMeasurements<T> getBinaryMeasurements();
}
