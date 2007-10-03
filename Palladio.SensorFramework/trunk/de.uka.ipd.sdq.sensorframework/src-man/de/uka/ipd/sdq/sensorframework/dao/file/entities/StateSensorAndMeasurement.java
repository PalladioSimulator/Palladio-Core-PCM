/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.State;

/**
 * @author ihssane
 * 
 */
public class StateSensorAndMeasurement extends AbstractSensorAndMeasurements {

	private static final long serialVersionUID = -7553464522648015852L;
	private List<State> states;

	public StateSensorAndMeasurement(ExperimentRun er, Sensor sensor) {
		super(er, sensor);
		states = new ArrayList<State>();
	}

	public void addState(double et, State state) {
		eventTimes.add(et);
		states.add(state);
	}

	public List<State> getStates() {
		return states;
	}

	@Override
	public List<Measurement> getMeasurements() {
		ArrayList<Measurement> m = new ArrayList<Measurement>();
		for (int i = 0; i < states.size(); i++) {
			m.add(new StateMeasurementImpl(i, eventTimes.get(i), states
							.get(i)));
		}
		return m;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof StateSensorAndMeasurement))
			return false;
		StateSensorAndMeasurement sam = (StateSensorAndMeasurement) obj;
		return (super.equals(obj)) && (getStates().equals(sam.getStates()));
	}

}
