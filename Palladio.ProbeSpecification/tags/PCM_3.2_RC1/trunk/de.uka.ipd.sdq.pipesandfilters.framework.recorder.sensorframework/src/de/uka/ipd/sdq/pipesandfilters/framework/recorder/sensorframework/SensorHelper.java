package de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.ISensorDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.IStateDAO;

public class SensorHelper {
	public static StateSensor createOrReuseStateSensor(IDAOFactory f, Experiment experiment, String id, State initialState) {
		ISensorDAO sensorDAO = f.createSensorDAO();
		if (sensorDAO.findBySensorName(id).size() > 0) {
			for (Sensor s : sensorDAO.findBySensorName(id)) {
				if (s instanceof StateSensor && experiment.getSensors().contains(s))
					return (StateSensor) s;
			}
		}
		return experiment.addStateSensor(initialState,id);
	}

	public static State createOrReuseState(IDAOFactory f, String id) {
		IStateDAO stateDAO = f.createStateDAO();
		if (stateDAO.findByStateLiteral(id).size() == 1) {
			return stateDAO.findByStateLiteral(id).iterator().next();
		}
		return stateDAO.addState(id);
	}


	public static TimeSpanSensor createOrReuseTimeSensor(
			IDAOFactory f, Experiment experimentDatastore, String id) {
		ISensorDAO sensorDAO = f.createSensorDAO();
		if (sensorDAO.findBySensorName(id).size() > 0) {
			for (Sensor s : sensorDAO.findBySensorName(id)) {
				if (s instanceof TimeSpanSensor && experimentDatastore.getSensors().contains(s))
					return (TimeSpanSensor) s;
			}
		}
		return experimentDatastore.addTimeSpanSensor(id);
	}
}
