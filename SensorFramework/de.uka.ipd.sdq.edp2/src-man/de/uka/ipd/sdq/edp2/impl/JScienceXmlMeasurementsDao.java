/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.util.List;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;

/**Access for JScienceXmlMeasurements.
 * @author groenda
 *
 */
public interface JScienceXmlMeasurementsDao<V,Q extends Quantity> extends OrdinalMeasurementsDao<V,Q> {

	public List<Measure<V,Q>> getMeasurements();
}
