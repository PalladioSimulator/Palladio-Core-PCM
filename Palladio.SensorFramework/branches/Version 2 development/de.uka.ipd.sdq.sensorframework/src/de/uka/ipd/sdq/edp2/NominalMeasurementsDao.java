/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements;

/**
 * @author groenda
 *
 */
public interface NominalMeasurementsDao extends Edp2Dao, EmfResourceDao {

	public ObservedNominalMeasurements getNominalMeasurements();
}
