package de.uka.ipd.sdq.edp2.file;

import java.io.IOException;

import javax.measure.Measure;

import de.uka.ipd.sdq.edp2.models.binary.BinaryMeasurements;

@SuppressWarnings("unchecked")
public interface BackgroundMemoryList<T extends Measure> extends BinaryMeasurements<T> {
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
