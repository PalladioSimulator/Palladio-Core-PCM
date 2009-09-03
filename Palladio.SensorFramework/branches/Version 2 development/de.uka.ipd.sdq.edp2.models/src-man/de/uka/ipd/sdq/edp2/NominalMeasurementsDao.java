/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import de.uka.ipd.sdq.edp2.impl.EmfResourceDao;
import de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements;

/**Interface for nominal measurements.
 * @author groenda
 *
 */
public interface NominalMeasurementsDao extends MeasurementsDao, EmfResourceDao {

	/**
	 * @return EMF-Model containing all observed nominal measurements.
	 */
	public ObservedNominalMeasurements getNominalMeasurements();
}
