package de.uka.ipd.sdq.sensorframework.storage;

import java.util.List;
import java.util.RandomAccess;

/**Interface used to access a list of measurements of a certain type.
 * An example is a list of double values measured for a sensor in an experiment run.
 * @author groenda
 * @param <T> Data type of measurements.
 */
public interface MeasurementDataDao<T> extends List<T>, RandomAccess {
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
	
	// plus the interface for List<T>
}
