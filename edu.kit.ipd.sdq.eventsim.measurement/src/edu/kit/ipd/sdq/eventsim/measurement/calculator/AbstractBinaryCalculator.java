package edu.kit.ipd.sdq.eventsim.measurement.calculator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasurementListener;

public abstract class AbstractBinaryCalculator<R, F, S, T> implements BinaryCalculator<R, F, S, T> {

	private static final Logger log = Logger.getLogger(AbstractBinaryCalculator.class);

	protected List<MeasurementListener<R, T>> measurementListener;

	public AbstractBinaryCalculator() {
		measurementListener = new ArrayList<>();
	}

	@Override
	public void forEachMeasurement(MeasurementListener<R, T> l) {
		measurementListener.add(l);
	}

	protected void notify(Measurement<R, T> measurement) {
		if (measurement != null) {
			measurementListener.forEach(listener -> listener.notify(measurement));
		} else {
			log.warn(String.format("Calculator %s tried to send null to its measurement listeners. "
					+ "Canceled notification.", getClass().getSimpleName()));
		}
	}

}
