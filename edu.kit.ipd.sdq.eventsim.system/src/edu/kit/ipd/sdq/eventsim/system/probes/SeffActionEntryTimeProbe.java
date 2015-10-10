package edu.kit.ipd.sdq.eventsim.system.probes;

import org.palladiosimulator.pcm.seff.AbstractAction;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;
import edu.kit.ipd.sdq.eventsim.measurement.Metric;
import edu.kit.ipd.sdq.eventsim.measurement.annotation.Probe;
import edu.kit.ipd.sdq.eventsim.measurement.probe.AbstractProbe;
import edu.kit.ipd.sdq.eventsim.system.SystemMeasurementConfiguration;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.listener.ISeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;

@Probe(type = AbstractAction.class, property = "before")
public class SeffActionEntryTimeProbe<E extends AbstractAction> extends
		AbstractProbe<E, Request, SystemMeasurementConfiguration> {

	public SeffActionEntryTimeProbe(MeasuringPoint<E> p, SystemMeasurementConfiguration cfg) {
		super(p, cfg);

		configuration.getInterpreterConfiguration().addTraversalListener(getMeasuringPoint().getElement(),
				new ISeffTraversalListener() {

					@Override
					public void before(AbstractAction action, Request request, RequestState state) {
						// process the currently observed measurement only when it originates from a measurement context
						// equal to or more specific than this probe's measurement context.
						if (!p.equalsOrIsMoreSpecific(getMeasuringPoint())) {
							return;
						}

						// build measurement
						double simTime = request.getModel().getSimulationControl().getCurrentSimulationTime();
						Measurement<E, Request> m = new Measurement<>(Metric.CURRENT_TIME, getMeasuringPoint(),
								request, simTime, simTime);

						// store
						cache.put(m);

						// notify
						measurementListener.forEach(l -> l.notify(m));

					}

					@Override
					public void after(AbstractAction action, Request request, RequestState state) {
						// nothing to do
					}
				});
	}

}
