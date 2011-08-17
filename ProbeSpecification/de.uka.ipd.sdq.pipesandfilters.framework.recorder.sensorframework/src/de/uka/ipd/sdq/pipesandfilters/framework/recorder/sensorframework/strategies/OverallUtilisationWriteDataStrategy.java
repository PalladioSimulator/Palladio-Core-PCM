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

public class OverallUtilisationWriteDataStrategy extends AbstractWriteDataStrategy {

	private State idleState;

	private State busyState;

	public OverallUtilisationWriteDataStrategy(IDAOFactory daoFactory,
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
			state = busyState;
		}
		run.addStateMeasurement((StateSensor)sensor, state, measurementTime);
	}

}
