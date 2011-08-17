package de.uka.ipd.sdq.edp2;

import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;

/**Interface for the access to any measurement data.
 * @author groenda
 */
public interface MeasurementsDao extends Edp2Dao {
	// Life cycle
	
	/**Serialize the data to an output stream.
	 * Used to transfer Measurements to and from remote locations.
	 * @param output Output data stream
	 * @throws DataNotAccessibleException
	 */
	public void serialize(ExtendedDataOutputStream output) throws DataNotAccessibleException;
	
	/**Deserialize the data from an input stream.
	 * Used to transfer Measurements to and from remote locations.
	 * @param input Input data stream.
	 */
	public void deserialize(ExtendedDataInputStream input) throws DataNotAccessibleException;
}
