package edu.kit.ipd.sdq.eventsim.system.measurement.calculator;

import org.palladiosimulator.pcm.seff.ExternalCallAction;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPointPair;
import edu.kit.ipd.sdq.eventsim.measurement.Metric;
import edu.kit.ipd.sdq.eventsim.measurement.Pair;
import edu.kit.ipd.sdq.eventsim.measurement.calculator.AbstractBinaryCalculator;
import edu.kit.ipd.sdq.eventsim.measurement.probe.IProbe;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;

public class ResponseTimeOfExternalCallsCalculator extends
		AbstractBinaryCalculator<ExternalCallAction, ExternalCallAction, Request> {

	@Override
	public void setup(IProbe<ExternalCallAction, Request> fromProbe, IProbe<ExternalCallAction, Request> toProbe) {
		toProbe.forEachMeasurement(measurement -> {
			notify(calculate(fromProbe.getLastMeasurementOf(measurement.getWho()), measurement));
		});
	}

	@Override
	public Measurement<Pair<ExternalCallAction, ExternalCallAction>, Request> calculate(Measurement<ExternalCallAction, Request> from,
			Measurement<ExternalCallAction, Request> to) {
		if(from == null) {
			return null;
		}
		
		double when = to.getWhen();
		double responseTime = to.getValue() - from.getValue();

		MeasuringPoint<ExternalCallAction> mp = new MeasuringPoint<ExternalCallAction>(to.getWhere().getElement(),
				"responsetime", to.getWhere().getContexts());

		return new Measurement<Pair<ExternalCallAction, ExternalCallAction>, Request>(Metric.TIME_SPAN,
				new MeasuringPointPair<>(from.getWhere().getElement(), to.getWhere().getElement(), "responsetime", to
						.getWhere().getContexts()), to.getWho(), responseTime, when);
	}

}
