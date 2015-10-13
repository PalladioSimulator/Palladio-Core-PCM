package edu.kit.ipd.sdq.eventsim.workload.calculators;

import org.apache.log4j.Logger;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPointPair;
import edu.kit.ipd.sdq.eventsim.measurement.Metric;
import edu.kit.ipd.sdq.eventsim.measurement.Pair;
import edu.kit.ipd.sdq.eventsim.measurement.calculator.AbstractBinaryCalculator;
import edu.kit.ipd.sdq.eventsim.measurement.probe.IProbe;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;

public class TimeSpanBetweenUserActionsCalculator
		extends
		AbstractBinaryCalculator<Pair<AbstractUserAction, AbstractUserAction>, AbstractUserAction, AbstractUserAction, User> {

	private static final Logger log = Logger.getLogger(TimeSpanBetweenUserActionsCalculator.class);

	private Metric metric;

	public TimeSpanBetweenUserActionsCalculator(Metric metric) {
		this.metric = metric;
	}

	@Override
	public void setup(IProbe<AbstractUserAction, User> fromProbe, IProbe<AbstractUserAction, User> toProbe) {
		// if(fromProbe == null || toProbe == null) {
		// log.warn("Cancelled setup of %s because one of the probes supplied is null.");
		// }
		fromProbe.enableCaching();
		toProbe.forEachMeasurement(m -> {
			// find "from"-measurement
			User user = m.getWho();
			notify(calculate(fromProbe.getLastMeasurementOf(user), m));
		});
	}

	@Override
	public Measurement<Pair<AbstractUserAction, AbstractUserAction>, User> calculate(
			Measurement<AbstractUserAction, User> from, Measurement<AbstractUserAction, User> to) {
		if (from == null) {
			return null;
		}

		double when = to.getWhen();
		double timeDifference = to.getValue() - from.getValue();

		Metric metric = this.metric == null ? Metric.TIME_SPAN : this.metric;
		return new Measurement<Pair<AbstractUserAction, AbstractUserAction>, User>(metric, new MeasuringPointPair<>(
				from.getWhere().getElement(), to.getWhere().getElement(), "timespan", to.getWhere().getContexts()),
				to.getWho(), timeDifference, when);

	}

}
