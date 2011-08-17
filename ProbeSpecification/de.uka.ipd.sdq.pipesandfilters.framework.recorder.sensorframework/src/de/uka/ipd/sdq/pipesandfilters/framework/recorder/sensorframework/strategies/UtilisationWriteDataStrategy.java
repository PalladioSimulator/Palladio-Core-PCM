package de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies;

import java.util.HashMap;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.SensorHelper;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public class UtilisationWriteDataStrategy extends AbstractWriteDataStrategy {

	private HashMap<String, State> statesCache = new HashMap<String, State>();

	private State idleState;

	private State busyState;

	public UtilisationWriteDataStrategy(IDAOFactory daoFactory,
			Experiment experiment, ExperimentRun run) {
		super(daoFactory, experiment, run);
	}	

	public void initialise(MetaDataInit metaData) {
		String sensorId = metaData.getMeasurementName();
		this.idleState = SensorHelper.createOrReuseState(daoFactory, "Idle");
		this.busyState = SensorHelper.createOrReuseState(daoFactory, "Busy");
		sensor = SensorHelper.createOrReuseStateSensor(daoFactory, experiment,
				sensorId, idleState);
		if (!((StateSensor) sensor).getSensorStates().contains(idleState)) {
			((StateSensor) sensor).addSensorState(idleState);
		}
		((StateSensor) sensor).addSensorState(busyState);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void writeData(PipeData data) {
		Measure<Double, Duration> measurementTimeMeasure = (Measure<Double, Duration>) data
				.getTupleElement(0);
		double measurementTime = measurementTimeMeasure.doubleValue(SI.SECOND);
		Measure<Integer, Dimensionless> numericStateMeasure = (Measure<Integer, Dimensionless>) data
				.getTupleElement(1);
		int numericState = numericStateMeasure.intValue(Dimensionless.UNIT);
		State state = null;
		if (numericState == 0) {
			state = idleState;
		} else {
			String stateLiteral = "Busy " + Integer.toString(numericState)
					+ " Job(s)";
			if (!statesCache.containsKey(stateLiteral)) {
				State newState = SensorHelper.createOrReuseState(daoFactory,
						stateLiteral);
				statesCache.put(stateLiteral, newState);
				if (!((StateSensor) sensor).getSensorStates()
						.contains(newState))
					((StateSensor) sensor).addSensorState(newState);
			}
			state = statesCache.get(stateLiteral);
		}
		run.addStateMeasurement((StateSensor)sensor, state, measurementTime);
	}

}
