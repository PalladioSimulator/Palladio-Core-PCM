/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

/**
 * @author Ihssane El-Oudghiri 
 * 
 */
public class TimeSpanSensorImpl extends SensorImpl implements TimeSpanSensor {

    private static final long serialVersionUID = 7666935671159276065L;

    public TimeSpanSensorImpl(FileDAOFactory factory) {
	super(factory);
    }

    @Override
    public boolean equals(Object obj) {
	if (!(obj instanceof TimeSpanSensorImpl))
	    return false;
	TimeSpanSensorImpl s = (TimeSpanSensorImpl) obj;
	if (!(sensorID == s.getSensorID() && sensorName.equals(s
		.getSensorName())))
	    return false;
	return true;
    }

	public void serializeChildren() {
		// Nothing to serialize here
	}
}
