package de.uka.ipd.sdq.pipesandfilters.framework;

import java.util.Iterator;
import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

/**
 * This class represents the Data objects which are passed and transformed
 * through the pipe and filter chain. Basically it contains a Vector
 * (resultTuple) with Measure objects. Information about the structure and the
 * metrics of the Vector is initially passed through the chain as an instance of
 * MetaDataInit using the initialize method of the Filters.
 * 
 * @author Faber
 * @author Baum
 */

public class PipeData implements Iterable<Measure<?, ? extends Quantity>> {

	private final Vector<Measure<?, ? extends Quantity>> resultTuple;

	/**
	 * The constructor of a pipe data element.
	 * 
	 * @param resultTuple
	 *            A vector holding the measurement result tuple.
	 */
	public PipeData(Vector<Measure<?, ? extends Quantity>> resultTuple) {
		this.resultTuple = resultTuple;
	}

	/**
	 * Returns the size of the resultTuple.
	 * 
	 * @return Size of the resultTuple.
	 */
	public int getTupleSize() {
		return resultTuple.size();
	}

	/**
	 * Returns the Measure for a given index position from the resultTuple.
	 * 
	 * @param index
	 *            Identifies the element from the resultTuple.
	 * @return The Measure for the index position or null if the index position
	 *         is invalid.
	 */
	public Measure<?, ? extends Quantity> getTupleElement(int index) {
		return resultTuple.get(index);
	}

	/**
	 * The iterator method of PipeData
	 * 
	 * @return An iterator of the result tuple.
	 */
	public Iterator<Measure<?, ? extends Quantity>> iterator() {
		return resultTuple.iterator();
	}

}
