package de.uka.ipd.sdq.pipesandfilters.framework.recorder;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;

/**
 * A WriteStrategy is responsible for storing the measurements 
 * to any external, independent device
 *
 * @author pmerkle
 * @author Baum
 */
public interface IWriteStrategy {

	/**
	 * This method contains meta data of the measurements to initialize the
	 * writer.
	 * 
	 * @param metaData
	 *            The meta data of the measurements.
	 */
	public abstract void initialize(MetaDataInit metaData);

	/**
	 * This method is called at the end of the writing process.
	 */
	public abstract void flush();

	/**
	 * Writes data into the storing devices.
	 * 
	 * @param data
	 *            The measurement that should be stored.
	 */
	public abstract void writeData(PipeData data);
}
