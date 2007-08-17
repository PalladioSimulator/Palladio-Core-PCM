/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.util.ArrayList;
import java.util.List;

import cern.colt.list.DoubleArrayList;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;

/**
 * @author ihssane
 * 
 */
public class TimeSpanSensorAndMeasurement extends SensorAndMeasurementsImpl {

	private static final long serialVersionUID = 3516448762554779531L;
	private DoubleArrayList timeSpan;

	public TimeSpanSensorAndMeasurement(Sensor sensor) {
		super(sensor);
		timeSpan = new DoubleArrayList();
	}

	@SuppressWarnings("unchecked")
	public List<Double> getTimeSpan() {
		return timeSpan.toList();
	}

	public void addTimeSpan(double ts) {
		timeSpan.add(ts);
	}

	@Override
	public List<Measurement> getMeasurements() {
		ArrayList<Measurement> m = new ArrayList<Measurement>();
		for (int i = 0; i < timeSpan.size(); i++) {
			m.add(new TimeSpanMeasurementImpl(i, eventTimes.get(i), timeSpan
					.get(i)));
		}
		return m;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TimeSpanSensorAndMeasurement))
			return false;
		TimeSpanSensorAndMeasurement sam = (TimeSpanSensorAndMeasurement) obj;
		return (getEventTimes().equals(sam.getEventTimes()))
				&& (getTimeSpan().equals(sam.getTimeSpan()));
	}

}
