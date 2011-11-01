/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.dao.file.FileManager;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;
import de.uka.ipd.sdq.sensorframework.storage.lists.DoubleSerialiser;

/**
 * @author Ihssane El-Oudghiri 
 * @author Steffen Becker
 * 
 */
public class TimeSpanSensorAndMeasurement extends AbstractSensorAndMeasurements {

	private static final long serialVersionUID = 3516448762554779531L;
	private BackgroundMemoryList<Double> timeSpans;

	public TimeSpanSensorAndMeasurement(FileManager fm, ExperimentRun er, Sensor sensor) throws IOException {
		super(fm, er, sensor);
		timeSpans = new BackgroundMemoryList<Double>(getMeasurementsFileName(),new DoubleSerialiser());
		fm.addOpenList(timeSpans);
	}

	public synchronized void addTimeSpan(double et, double ts) {
		eventTimes.add(et);
		timeSpans.add(ts);
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

	@Override
	public synchronized List<Measurement> getMeasurements() {
		return new TimeSpanMeasurementListWithBackgroundStore(eventTimes, timeSpans);
	}

	@Override
	public void store() {
		super.store();
		try {
			timeSpans.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
