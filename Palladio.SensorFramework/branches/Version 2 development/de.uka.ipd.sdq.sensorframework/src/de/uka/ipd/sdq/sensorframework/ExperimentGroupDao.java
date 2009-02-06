/**
 * 
 */
package de.uka.ipd.sdq.sensorframework;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentGroup;

/**DAO to access experiment groups.
 * @author groenda
 */
public interface ExperimentGroupDao {
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

	/**Returns the emf representation of the experiment group.
	 * @return emf model of the experiment group.
	 */
	public ExperimentGroup getExperimentGroup();
}
