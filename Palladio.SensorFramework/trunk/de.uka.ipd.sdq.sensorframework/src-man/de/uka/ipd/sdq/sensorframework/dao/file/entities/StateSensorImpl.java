/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;

/**
 * @author ihssane
 * 
 */
public class StateSensorImpl extends SensorImpl implements StateSensor {

	private static final long serialVersionUID = -1981199624361875277L;
	private State initialState;
	private Collection<State> sensorStates;

	public StateSensorImpl(FileDAOFactory factory) {
		super(factory);
		sensorStates = new ArrayList<State>();
	}

	public void addSensorState(State value) {
		sensorStates.add(value);
	}

	public State addState(String p_stateliteral) {
		State state = factory.createStateDAO().addState(p_stateliteral);
		sensorStates.add(state);
		return state;
	}

	public State getInitialState() {
		return initialState;
	}

	public Collection<State> getSensorStates() {
		return sensorStates;
	}

	public void setInitialState(State value) {
		this.initialState = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof StateSensorImpl))
			return false;
		StateSensorImpl s = (StateSensorImpl) obj;
		if (!(sensorID == s.getSensorID() && sensorName.equals(s
				.getSensorName())))
			return false;

		return true;
	}

}
