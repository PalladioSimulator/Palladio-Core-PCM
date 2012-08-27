/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import java.util.List;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;


/**
 * Interface for all measurements which have at least ordinal type. For example,
 * measurements stored as JSXmlMeasurements, DoubleBinaryMeasurements, or
 * LongBinaryMeasurements can be accessed through this interface.
 * 
 * @author groenda
 * 
 */
public interface OrdinalMeasurementsDao<V,Q extends Quantity> extends MeasurementsDao {

	/**
	 * @return Observed measurements.
	 */
	public List<Measure<V,Q>> getMeasurements();

}
