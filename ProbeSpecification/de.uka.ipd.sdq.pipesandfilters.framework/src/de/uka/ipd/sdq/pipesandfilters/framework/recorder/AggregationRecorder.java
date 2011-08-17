package de.uka.ipd.sdq.pipesandfilters.framework.recorder;

/**
 * An aggregation recorder can aggregate incoming measurements and write them to
 * EDP2. The concrete aggregation must be specified in the implementing
 * subclass.
 * 
 * @author Baum
 * 
 */

public abstract class AggregationRecorder extends Recorder {

	/**
	 * The constructor for an aggregation recorder.
	 * 
	 * @param writeStrategy
	 *            The write strategy of the recorder.
	 */
	public AggregationRecorder(IAggregationWriteStrategy writeStrategy) {
		super(writeStrategy);
	}
}
