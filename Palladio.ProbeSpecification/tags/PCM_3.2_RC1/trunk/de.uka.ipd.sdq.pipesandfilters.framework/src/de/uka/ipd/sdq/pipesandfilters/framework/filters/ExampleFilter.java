package de.uka.ipd.sdq.pipesandfilters.framework.filters;

import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;

/**
 * A simple filter example for test cases. This filter simply forwards incoming
 * data. It also counts the number of elements he has received.
 * 
 * @author pmerkle
 * @author Baum
 */

public class ExampleFilter extends Filter {

	/**
	 * This element stores the last pipe data element that arrived.
	 */
	private PipeData lastArrivedData = null;

	/**
	 * This element stores the number of elements the filter has received.
	 */
	private int receiveCount = 0;

	/**
	 * The processData method of the ExampleFilter. Incoming data only forwarded
	 * to the successive pipe element. No actual filtering is performed.
	 */
	@Override
	public void processData(PipeData data) {
		lastArrivedData = data;
		receiveCount++;
		super.processData(data);
	}

	/**
	 * Getter method for lastArrivedData.
	 * 
	 * @return the last pipe data element that arrived.
	 */
	public PipeData getLastArrivedData() {
		return lastArrivedData;
	}

	/**
	 * Returns the number of data elements this filter has received.
	 * 
	 * @return The number of data elements received.
	 */
	public int getReceiveCount() {
		return receiveCount;
	}
}
