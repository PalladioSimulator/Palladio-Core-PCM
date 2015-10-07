package edu.kit.ipd.sdq.eventsim.measurement.calculator;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasurementProducer;
import edu.kit.ipd.sdq.eventsim.measurement.probe.IProbe;


public interface BinaryCalculator<R, F, S, T> extends MeasurementProducer<R, T> {

	void setup(IProbe<F, T> fromProbe, IProbe<S, T> toProbe);

	Measurement<R, T> calculate(Measurement<F, T> first, Measurement<S, T> second);
	
}
