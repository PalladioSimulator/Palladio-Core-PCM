/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.util.List;

import de.uka.ipd.sdq.edp2.MeasurementsDao;

/**
 * @author groenda
 *
 */
public interface JScienceXmlMeasurementsDao extends MeasurementsDao {

	@SuppressWarnings("unchecked")
	public List<javax.measure.Measure> getMeasurements();
}
