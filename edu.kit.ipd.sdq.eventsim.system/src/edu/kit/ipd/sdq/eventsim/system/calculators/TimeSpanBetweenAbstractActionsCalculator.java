package edu.kit.ipd.sdq.eventsim.system.calculators;

import org.apache.log4j.Logger;
import org.palladiosimulator.pcm.seff.AbstractAction;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPointPair;
import edu.kit.ipd.sdq.eventsim.measurement.Metric;
import edu.kit.ipd.sdq.eventsim.measurement.Pair;
import edu.kit.ipd.sdq.eventsim.measurement.calculator.AbstractBinaryCalculator;
import edu.kit.ipd.sdq.eventsim.measurement.probe.IProbe;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;

public class TimeSpanBetweenAbstractActionsCalculator extends
		AbstractBinaryCalculator<Pair<AbstractAction, AbstractAction>, AbstractAction, AbstractAction, Request> {

	private static final Logger log = Logger.getLogger(TimeSpanBetweenAbstractActionsCalculator.class);

	@Override
	public void setup(IProbe<AbstractAction, Request> fromProbe, IProbe<AbstractAction, Request> toProbe) {
		// if(fromProbe == null || toProbe == null) {
		// log.warn("Cancelled setup of %s because one of the probes supplied is null.");
		// }
		fromProbe.enableCaching();
		toProbe.forEachMeasurement(m -> {
			// find "from"-measurement
			Request request = m.getWho();
			Measurement<AbstractAction, Request> fromMeasurement = null;
			do {
				fromMeasurement = fromProbe.getLastMeasurementOf(request);
				request = request.getParent();
			} while (fromMeasurement == null && request != null);

			if (fromMeasurement != null) {
				notify(calculate(fromMeasurement, m));
			} else {
				// TODO improve warning, give hits on how to resolve this problem
				log.warn(String.format("Could not find last measurement triggered by %s or a parent request. "
						+ "Skipping calculation.", m.getWho()));
			}
		});
	}

	@Override
	public Measurement<Pair<AbstractAction, AbstractAction>, Request> calculate(Measurement<AbstractAction, Request> from,
			Measurement<AbstractAction, Request> to) {
		if (from == null) {
			return null;
		}

		double when = to.getWhen();
		double timeDifference = to.getValue() - from.getValue();

		MeasuringPoint<AbstractAction> mp = new MeasuringPoint<AbstractAction>(to.getWhere().getElement(), "time_span",
				to.getWhere().getContexts());

		// TODO AbstractAction doesn't fit here actually
//		return new Measurement<AbstractAction, Request>(Metric.TIME_SPAN, mp, to.getWho(), timeDifference, when);
		
		
		return new Measurement<Pair<AbstractAction, AbstractAction>, Request>(Metric.TIME_SPAN,
				new MeasuringPointPair<>(from.getWhere().getElement(), to.getWhere().getElement(), "timespan", to
						.getWhere().getContexts()), to.getWho(), timeDifference, when);
	}

}
