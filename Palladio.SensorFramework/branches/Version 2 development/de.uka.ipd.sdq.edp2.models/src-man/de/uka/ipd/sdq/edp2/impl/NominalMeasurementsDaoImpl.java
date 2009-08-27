/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import de.uka.ipd.sdq.edp2.MeasurementsDao;
import de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements;

/**
 * @author groenda
 *
 */
public interface NominalMeasurementsDaoImpl extends MeasurementsDao, EmfResourceDao {

	public ObservedNominalMeasurements getNominalMeasurements();
}
