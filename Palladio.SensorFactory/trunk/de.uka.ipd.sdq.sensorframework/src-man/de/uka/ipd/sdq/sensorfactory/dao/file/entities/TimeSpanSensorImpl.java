/**
 * 
 */
package de.uka.ipd.sdq.sensorfactory.dao.file.entities;

import de.uka.ipd.sdq.sensorfactory.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;

/**
 * @author ihssane
 * 
 */
public class TimeSpanSensorImpl extends SensorImpl implements TimeSpanSensor {

	private static final long serialVersionUID = 7666935671159276065L;

	public TimeSpanSensorImpl(FileDAOFactory factory) {
		super(factory);
	}

}
