package de.uka.ipd.sdq.edp2;

import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

/**Interface for the access to any EDP2 data.
 * @author groenda
 */
public interface Dao {
	/**Opens the connection to the storage and makes it accessible.
	 * @throws DataNotAccessibleException Errors when initializing the data access.
	 */
	public void open() throws DataNotAccessibleException;
	
	/**Closes the access connection to the storage.
	 * If necessary, data is persisted before closing.
	 * @throws DataNotAccessibleException Errors when accessing data.
	 */
	public void close() throws DataNotAccessibleException;

	/**Deletes the data on the storage.
	 * @throws DataNotAccessibleException Errors when accessing data.
	 */
	public void delete() throws DataNotAccessibleException;
	
	/**Returns if data is accessible or not.
	 * @return <code>true</code> if the connection is open and data is accessible.
	 */
	public boolean isOpen();

	/**Returns if the referenced data has been deleted.
	 * @return <code>true</code> if the data has been delete.
	 */
	public boolean isDeleted();

	/**Serialize the data.
	 * @param output Output data stream
	 * @throws DataNotAccessibleException 
	 */
	public void serialize(ExtendedDataOutputStream output) throws DataNotAccessibleException;
	
	/**Deserialize the data.
	 * @param input Input data stream.
	 */
	public void deserialize(ExtendedDataInputStream input) throws DataNotAccessibleException;
}
