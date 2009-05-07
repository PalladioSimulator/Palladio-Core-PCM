/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import java.util.List;

/**
 * @author groenda
 *
 */
public interface JScienceXmlMeasurementsDao extends Dao {

	@SuppressWarnings("unchecked")
	public List<javax.measure.Measure> getMeasurements();
}
