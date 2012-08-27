/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import de.uka.ipd.sdq.edp2.MeasurementsDao;

/**
 * Abstract base class for all DAO implementations which manage persisted measurements.
 * 
 * @author groenda
 *
 */
public abstract class AbstractMeasurementsDaoImpl extends Edp2DaoImpl implements MeasurementsDao {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.MeasurementsDao#deserialize(org.eclipse.net4j.util.io.ExtendedDataInputStream)
	 */
	public void deserialize(ExtendedDataInputStream input)
			throws DataNotAccessibleException {
		if (isDeleted()) {
			throw new IllegalStateException("Deserialization not possible on deleted data.");
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.MeasurementsDao#serialize(org.eclipse.net4j.util.io.ExtendedDataOutputStream)
	 */
	public void serialize(ExtendedDataOutputStream output)
			throws DataNotAccessibleException {
		if (isDeleted()) {
			throw new IllegalStateException("Serialization not possible on deleted data.");
		}
	}
}
