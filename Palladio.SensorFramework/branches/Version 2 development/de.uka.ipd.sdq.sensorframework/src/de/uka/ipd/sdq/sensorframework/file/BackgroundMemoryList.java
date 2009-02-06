package de.uka.ipd.sdq.sensorframework.file;

import java.io.IOException;
import java.util.List;
import java.util.RandomAccess;

import de.uka.ipd.sdq.sensorframework.models.binary.BinaryMeasurements;

public interface BackgroundMemoryList<T> extends BinaryMeasurements<T> {
	/**Opens the link to the file on background storage. Only allowed if there is no open link.
	 * @throws IOException Thrown if file IO fails.
	 */
	public void open() throws IOException;
	
	/** Closes the link to the file on background storage. There are no further add or get operations allowed after closing.
	 * @throws IOException
	 */
	public void close() throws IOException;

	/**Get the status of the link to the attached file. Any read or write operation is only allowed in open state.
	 * @return <code>true</code> if the link to the attached file is closed.
	 */
	public boolean isClosed();

}
