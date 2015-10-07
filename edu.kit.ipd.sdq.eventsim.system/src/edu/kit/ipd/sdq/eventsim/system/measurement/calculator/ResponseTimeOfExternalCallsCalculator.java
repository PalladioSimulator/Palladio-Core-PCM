package edu.kit.ipd.sdq.eventsim.system.measurement.calculator;

import org.palladiosimulator.pcm.seff.ExternalCallAction;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;
import edu.kit.ipd.sdq.eventsim.measurement.Metric;
import edu.kit.ipd.sdq.eventsim.measurement.calculator.AbstractBinaryCalculator;
import edu.kit.ipd.sdq.eventsim.measurement.probe.IProbe;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;

public class ResponseTimeOfExternalCallsCalculator extends
		AbstractBinaryCalculator<ExternalCallAction, ExternalCallAction, ExternalCallAction, Request> {

	@Override
	public void setup(IProbe<ExternalCallAction, Request> fromProbe, IProbe<ExternalCallAction, Request> toProbe) {
		toProbe.forEachMeasurement(measurement -> {
			notify(calculate(fromProbe.getLastMeasurementOf(measurement.getWho()), measurement));
		});
	}

	@Override
	public Measurement<ExternalCallAction, Request> calculate(Measurement<ExternalCallAction, Request> from,
			Measurement<ExternalCallAction, Request> to) {
		if(from == null) {
			return null;
		}
		
		double when = to.getWhen();
		double responseTime = to.getMeasurement() - from.getMeasurement();

		MeasuringPoint<ExternalCallAction> mp = new MeasuringPoint<ExternalCallAction>(to.getWhere().getElement(),
				"responsetime", to.getWhere().getContexts());

		return new Measurement<ExternalCallAction, Request>(Metric.TIME_SPAN, mp, to.getWho(), responseTime, when);
	}

}
