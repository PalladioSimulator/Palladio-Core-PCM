package de.uka.ipd.sdq.edp2.impl;

import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;

/**Interface used to access a list of measurements of a certain type.
 * An example is a list of double values measured for a sensor in an experiment run.
 * @author groenda
 * @param <T> Data type of measurements.
 */
public interface BinaryMeasurementsDao<V,Q extends Quantity> extends OrdinalMeasurementsDao<V,Q> {
	
	/**Returns the unit in which all measurements are stored.
	 * @return The unit.
	 */
	public Unit<Q> getUnit();

	/**Sets the unit in which all measurements are stored.
	 * @param unit The unit.
	 */
	public void setUnit(Unit<Q> unit);
}
