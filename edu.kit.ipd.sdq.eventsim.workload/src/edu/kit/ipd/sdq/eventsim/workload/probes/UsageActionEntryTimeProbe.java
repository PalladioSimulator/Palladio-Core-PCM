package edu.kit.ipd.sdq.eventsim.workload.probes;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;

import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;
import edu.kit.ipd.sdq.eventsim.measurement.Metric;
import edu.kit.ipd.sdq.eventsim.measurement.annotation.Probe;
import edu.kit.ipd.sdq.eventsim.measurement.probe.AbstractProbe;
import edu.kit.ipd.sdq.eventsim.workload.WorkloadMeasurementConfiguration;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.listener.IUsageTraversalListener;

@Probe(type = AbstractUserAction.class, property = "before")
public class UsageActionEntryTimeProbe<E extends AbstractUserAction> extends
		AbstractProbe<E, User, WorkloadMeasurementConfiguration> {

	public UsageActionEntryTimeProbe(MeasuringPoint<E> p, WorkloadMeasurementConfiguration cfg) {
		super(p, cfg);

		configuration.getInterpreterConfiguration().addTraversalListener(getMeasuringPoint().getElement(),
				new IUsageTraversalListener() {

					@Override
					public void before(AbstractUserAction action, User user, UserState state) {
						// build measurement
						double simTime = user.getModel().getSimulationControl().getCurrentSimulationTime();
						Measurement<E, User> m = new Measurement<>(Metric.CURRENT_TIME, getMeasuringPoint(),
								user, simTime, simTime);

						// store
						cache.put(m);

						// notify
						measurementListener.forEach(l -> l.notify(m));

					}

					@Override
					public void after(AbstractUserAction action, User user, UserState state) {
						// nothing to do
					}
				});
	}

}
