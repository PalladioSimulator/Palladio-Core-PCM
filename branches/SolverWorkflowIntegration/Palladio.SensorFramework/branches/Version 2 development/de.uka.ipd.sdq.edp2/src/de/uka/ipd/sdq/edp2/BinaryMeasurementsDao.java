package de.uka.ipd.sdq.edp2;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import de.uka.ipd.sdq.edp2.models.binary.BinaryMeasurements;

/**Interface used to access a list of measurements of a certain type.
 * An example is a list of double values measured for a sensor in an experiment run.
 * @author groenda
 * @param <T> Data type of measurements.
 */
@SuppressWarnings("unchecked")
public interface BinaryMeasurementsDao<T extends Measure> extends Dao {
	
	/**Returns the model for accessing binary measurements.
	 * @return Model for binary measurements.
	 */
	public BinaryMeasurements<T> getBinaryMeasurements();
	
	/**Returns the unit in which all measurements are stored.
	 * @return The unit.
	 */
	public Unit<Quantity> getUnit();

	/**Sets the unit in which all measurements are stored.
	 * @param unit The unit.
	 */
	public void setUnit(Unit<Quantity> unit);
}
