/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.util.List;

import javax.measure.Measure;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;

/**Access for JScienceXmlMeasurements.
 * @author groenda
 *
 */
@SuppressWarnings("unchecked")
public interface JScienceXmlMeasurementsDao extends OrdinalMeasurementsDao<Measure> {

	public List<javax.measure.Measure> getMeasurements();
}
