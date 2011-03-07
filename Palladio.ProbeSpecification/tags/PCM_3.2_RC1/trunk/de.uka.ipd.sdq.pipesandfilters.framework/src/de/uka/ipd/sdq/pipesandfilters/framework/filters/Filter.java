package de.uka.ipd.sdq.pipesandfilters.framework.filters;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeElement;

/**
 * The Filter class is the super class of any implemented filter in the pipe. A
 * filter has exactly one successive pipe element to which every received data
 * should be forwarded.
 * 
 * @author Baum
 * 
 */

public abstract class Filter extends PipeElement {

	/**
	 * The default constructor of a Filter. This constructor sets MAX_IN_DEGREE
	 * to 1 and MAX_OUT_DEGREE to Integer.MAX_VALUE.
	 */
	protected Filter() {
		super(1, Integer.MAX_VALUE);
	}

	/**
	 * The constructor of a Filter.
	 * 
	 * @param MAX_IN_DEGREE
	 *            The maximum in degree of the filter.
	 * @param MAX_OUT_DEGREE
	 *            The maximum out degree of the filter.
	 */
	protected Filter(int MAX_IN_DEGREE, int MAX_OUT_DEGREE) {
		super(MAX_IN_DEGREE, MAX_OUT_DEGREE);
	}

	/**
	 * If this method is not overridden by the filter implementation, this
	 * method does nothing
	 */
	protected void initialize(MetaDataInit metaDataInit) {
	}

	/**
	 * If this method is not overridden by the filter implementation, this
	 * method does nothing except forwarding the flush instruction.
	 */
	protected void flush() {
		forwardFlush();
	}

	/**
	 * If this method is not overridden by the filter implementation, the data
	 * is simply forwarded to the successive element in the pipe
	 */
	protected void processData(PipeData data) {
		forwardData(data);
	}
}
