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
import de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;

/**
 * @author Ihssane El-Oudghiri 
 * @author Steffen Becker
 */
public class ScalabilitySensorAndMeasurement extends AbstractSensorAndMeasurements {

	private static final long serialVersionUID = 3516448762784779531L;
	private BackgroundMemoryList<Double[]> timeSpans;

	public ScalabilitySensorAndMeasurement(FileManager fm, ExperimentRun er, Sensor sensor) throws IOException {
		super(fm, er, sensor);
		timeSpans = new BackgroundMemoryList<Double[]>(
				getMeasurementsFileName(),
				new ParameterValueSerialiser((ScalabilitySensor)sensor));
		fm.addOpenList(timeSpans);
	}

	public synchronized void addResult(Double[] ts, double et) {
		eventTimes.add(et);
		timeSpans.add(ts);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ScalabilitySensorAndMeasurement))
			return false;
		ScalabilitySensorAndMeasurement sam = (ScalabilitySensorAndMeasurement) obj;
		
		return super.equals(obj) && equalTimeSpans(this,sam);
	}

	private boolean equalTimeSpans(
			ScalabilitySensorAndMeasurement sam1,
			ScalabilitySensorAndMeasurement sam2) {
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
		ArrayList<Measurement> m = new ArrayList<Measurement>();
		for (int i = 0; i < timeSpans.size(); i++) {
			m.add(new ScalabilityMeasurementImpl(i, eventTimes.get(i), timeSpans
					.get(i)));
		}
		return m;
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
