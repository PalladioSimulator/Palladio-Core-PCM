/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

/**
 * @author groenda
 *
 */
public abstract class MeasurementsDaoImpl extends Edp2DaoImpl implements de.uka.ipd.sdq.edp2.MeasurementsDao {

	public void deserialize(ExtendedDataInputStream input)
			throws DataNotAccessibleException {
		if (isDeleted()) {
			throw new IllegalStateException("Deserialization not possible on deleted data.");
		}
	}

	public void serialize(ExtendedDataOutputStream output)
			throws DataNotAccessibleException {
		if (isDeleted()) {
			throw new IllegalStateException("Serialization not possible on deleted data.");
		}
	}
}
