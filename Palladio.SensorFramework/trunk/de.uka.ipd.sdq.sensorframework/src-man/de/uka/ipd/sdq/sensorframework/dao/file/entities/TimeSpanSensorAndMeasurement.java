/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.util.ArrayList;
import java.util.List;

import cern.colt.list.DoubleArrayList;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;

/**
 * @author ihssane
 * 
 */
public class TimeSpanSensorAndMeasurement extends AbstractSensorAndMeasurements {

	private static final long serialVersionUID = 3516448762554779531L;
	private DoubleArrayList timeSpans;

	public TimeSpanSensorAndMeasurement(ExperimentRun er, Sensor sensor) {
		super(er, sensor);
		timeSpans = new DoubleArrayList();
	}

	public synchronized void addTimeSpan(double et, double ts) {
		eventTimes.add(et);
		timeSpans.add(ts);
	}

	@Override
	public synchronized List<Measurement> getMeasurements() {
		ArrayList<Measurement> m = new ArrayList<Measurement>();
		for (int i = 0; i < timeSpans.size(); i++) {
			m.add(new TimeSpanMeasurementImpl(i, eventTimes.get(i), timeSpans
					.get(i)));
		}
		return m;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TimeSpanSensorAndMeasurement))
			return false;
		TimeSpanSensorAndMeasurement sam = (TimeSpanSensorAndMeasurement) obj;
		
		return super.equals(obj) && equalTimeSpans(this,sam);
	}

	private boolean equalTimeSpans(
			TimeSpanSensorAndMeasurement sam1,
			TimeSpanSensorAndMeasurement sam2) {
		if (sam1.timeSpans.size() == sam2.timeSpans.size()) {
			for (int i=0; i<sam1.timeSpans.size(); i++){
				if (sam1.timeSpans.get(i) != sam2.timeSpans.get(i))
					return false;
			}
			return true;
		} else {
			return false;
		}
	}

}
