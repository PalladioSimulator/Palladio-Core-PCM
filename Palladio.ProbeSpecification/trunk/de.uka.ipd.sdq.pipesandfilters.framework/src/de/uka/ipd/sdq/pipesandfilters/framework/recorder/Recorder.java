package de.uka.ipd.sdq.pipesandfilters.framework.recorder;

import de.uka.ipd.sdq.pipesandfilters.framework.PipeElement;

/**
 * This class is the super class of any recorder implementations. A recorder is
 * responsible of making the measurements persistent, using a specified
 * WriteStrategy. The measurements can either be aggregated before storing or be
 * stored as raw measurements.
 * 
 * @author Baum
 * 
 */
public abstract class Recorder extends PipeElement {

	/**
	 * The write strategy of the recorder. It determines in which way that
	 * measurement data is made persistent.
	 */
	protected IWriteStrategy writeStrategy;

	/**
	 * The default constructor for a recorder. This constructor sets
	 * MAX_IN_DEGREE to 1 and MAX_OUT_DEGREE to 0.
	 * 
	 * @param writeStrategy
	 *            The write strategy of the recorder.
	 */
	public Recorder(IWriteStrategy writeStrategy) {
		super(1, 0);
		this.writeStrategy = writeStrategy;
	}

	/**
	 * The constructor of a Recorder.
	 * 
	 * @param writeStrategy
	 *            The write strategy of the recorder.
	 * @param MAX_INT_DEGREE
	 *            The maximum in degree of the filter.
	 * @param MAX_OUT_DEGREE
	 *            The maximum out degree of the filter.
	 */
	public Recorder(IWriteStrategy writeStrategy, int MAX_IN_DEGREE,
			int MAX_OUT_DEGREE) {
		super(MAX_IN_DEGREE, MAX_OUT_DEGREE);
		this.writeStrategy = writeStrategy;
	}

	/**
	 * Returns the write strategy of the recorder.
	 * 
	 * @return The recorder's write strategy.
	 */
	public IWriteStrategy getWriteStrategy() {
		return writeStrategy;
	}
}
