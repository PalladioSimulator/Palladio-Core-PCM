package de.uka.ipd.sdq.pipesandfilters.framework.filters;

import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;

/**
 * A simple example filter that drops the first n incoming data elements. All
 * following elements are passed forward. This filter serves as a simple warm up
 * filter to skip the first n measurements of the experiment run.
 * 
 * @author Baum
 * 
 */

public class SimpleWarmUpFilter extends Filter {

	private int skip;
	private int skipCount = 0;

	/**
	 * The constructor of a SimpleWarmUpFilter
	 * 
	 * @param skip
	 *            The number of elements to be dropped at the start.
	 */
	public SimpleWarmUpFilter(int skip) {
		super();
		this.skip = skip;
	}

	/**
	 * This method handles incoming data. The data is dropped if it belongs to
	 * the first n incoming data elements, else it is forwarded to the next pipe
	 * element.
	 */
	public void processData(PipeData p) {
		if (skipCount >= skip) {
			forwardData(p);
		} else {
			skipCount++;
		}
	}

}
