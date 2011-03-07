package de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.strategies;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public class WaitingTimeWriteDataStrategy extends AbstractWriteDataStrategy {

	public WaitingTimeWriteDataStrategy(IDAOFactory daoFactory,
			Experiment experiment, ExperimentRun run) {
		super(daoFactory, experiment, run);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void writeData(PipeData data) {
		Measure<Double, Duration> timeSpanMeasure = (Measure<Double, Duration>) data
				.getTupleElement(0);
		double timeSpan = timeSpanMeasure.doubleValue(SI.SECOND);
		Measure<Double, Duration> eventTimeMeasure = (Measure<Double, Duration>) data
				.getTupleElement(1);
		double eventTime = eventTimeMeasure.doubleValue(SI.SECOND);
		run.addTimeSpanMeasurement((TimeSpanSensor)sensor, eventTime, timeSpan);
	}

}
