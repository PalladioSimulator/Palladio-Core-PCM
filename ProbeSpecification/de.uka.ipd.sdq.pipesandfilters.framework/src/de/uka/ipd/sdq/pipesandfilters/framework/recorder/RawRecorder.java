package de.uka.ipd.sdq.pipesandfilters.framework.recorder;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;

/**
 * A RawRecorder is responsible of recording the raw measurements using a
 * specified WriteStrategy. No aggregations of the possibly filtered
 * data are performed.
 * 
 * @author Baum
 * 
 */
public class RawRecorder extends Recorder {
	
	/**
	 * The constructor for a raw data recorder.
	 * 
	 * @param writeStrategy The write strategy of the recorder.
	 */
	public RawRecorder(IRawWriteStrategy writeStrategy) {
		super(writeStrategy);
	}

	/**
	 * This method initializes the WriteStrategy with the given meta data.
	 * 
	 * @param metaData
	 *            The meta data of the measurement.
	 */
	public void initialize(MetaDataInit metaData) {
		writeStrategy.initialize(metaData);
	}

	/**
	 * This method tells the WriteStrategy to flush all measurements of the
	 * current experiment run.
	 */
	public void flush() {
		writeStrategy.flush();
	}

	/**
	 * This method forwards the raw measurement data to the specified
	 * WriteStrategy.
	 */
	public void processData(PipeData data) {
		writeStrategy.writeData(data);
	}
}
