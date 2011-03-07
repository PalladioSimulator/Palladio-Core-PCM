/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import java.util.List;

import javax.measure.Measure;


/**
 * Interface for all measurements which have at least ordinal type. For example,
 * measurements stored as JSXmlMeasurements, DoubleBinaryMeasurements, or
 * LongBinaryMeasurements can be access through this interface.
 * 
 * @author groenda
 * 
 */
@SuppressWarnings("unchecked")
public interface OrdinalMeasurementsDao<T extends Measure> extends MeasurementsDao {

	/**
	 * @return Observed measurements.
	 */
	public List<T> getMeasurements();

}
