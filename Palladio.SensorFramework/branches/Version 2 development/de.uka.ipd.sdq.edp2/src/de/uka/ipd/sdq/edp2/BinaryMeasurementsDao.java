package de.uka.ipd.sdq.edp2;

import de.uka.ipd.sdq.edp2.models.binary.BinaryMeasurements;

/**Interface used to access a list of measurements of a certain type.
 * An example is a list of double values measured for a sensor in an experiment run.
 * @author groenda
 * @param <T> Data type of measurements.
 */
public interface BinaryMeasurementsDao<T> extends Dao {
	
	/**Returns the model for accessing binary measurements.
	 * @return Model for binary measurements.
	 */
	public BinaryMeasurements<T> getBinaryMeasurements();
}
