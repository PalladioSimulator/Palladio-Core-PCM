package de.uka.ipd.sdq.edp2.local.file;

import java.io.IOException;

import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.edp2.models.binary.BinaryMeasurementsList;

/**
 * Interface of a @link {@link BinaryMeasurementsList} list, which uses a file on a drive as efficient background
 * storage, i.e., it consumes constant main memory so that it can store huge amounts of list entries.
 * 
 * @author S. Becker
 * @param <V> Value type of the measurements to be stored. Most often used values are Double or Long
 * @param <Q> Quantity to be stored, see {@link Quantity}
 * 
 */
public interface BackgroundMemoryList<V,Q extends Quantity> extends BinaryMeasurementsList<V,Q> {
	/** 
	 * Opens the link to the file on background storage. Only allowed if there is no open link.
	 * @throws IOException Thrown if file IO fails.
	 */
	public void open() throws IOException;
	
	/** 
	 * Closes the link to the file on background storage. There are no further add or get operations allowed after closing.
	 * @throws IOException
	 */
	public void close() throws IOException;

	/**
	 * Get the status of the link to the attached file. Any read or write operation is only allowed in open state.
	 * @return <code>true</code> if the link to the attached file is closed.
	 */
	public boolean isClosed();

}
