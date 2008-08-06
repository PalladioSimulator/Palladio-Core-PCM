/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;

/**
 * @author Ihssane El-Oudghiri 
 * @author Steffen Becker
 */
public class StateSensorImpl extends SensorImpl implements StateSensor {

	private static final long serialVersionUID = -1981199624361875277L;
	private Long initialStateID;
	private ArrayList<Long> sensorStateIDs;

	public StateSensorImpl(FileDAOFactory factory) {
		super(factory);
		sensorStateIDs = new ArrayList<Long>();
	}

	public void addSensorState(State value) {
		sensorStateIDs.add(value.getStateID());
	}

	public State addState(String p_stateliteral) {
		State state = factory.createStateDAO().addState(p_stateliteral);
		sensorStateIDs.add(state.getStateID());
		return state;
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

	public State getInitialState() {
		return factory.createStateDAO().get(initialStateID);
	}

	public Collection<State> getSensorStates() {
		ArrayList<State> result = new ArrayList<State>();
		for (Long id : this.sensorStateIDs) {
			result.add(factory.createStateDAO().get(id));
		}
		return Collections.unmodifiableCollection(result);
	}

	public void setInitialState(State value) {
		this.initialStateID = value.getStateID();
	}

}
