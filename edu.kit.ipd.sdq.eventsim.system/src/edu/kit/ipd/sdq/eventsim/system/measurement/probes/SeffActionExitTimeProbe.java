package edu.kit.ipd.sdq.eventsim.system.measurement.probes;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
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

@Probe(type = AbstractAction.class, property = "after")
public class SeffActionExitTimeProbe<E extends AbstractAction> extends
		AbstractProbe<E, Request, SystemMeasurementConfiguration> {

	public SeffActionExitTimeProbe(MeasuringPoint<E> p, SystemMeasurementConfiguration configuration) {
		super(p, configuration);

		configuration.getInterpreterConfiguration().addTraversalListener(getMeasuringPoint().getElement(),
				new ISeffTraversalListener() {

					@Override
					public void before(AbstractAction action, Request request, RequestState state) {
						// nothing to do
					}

					@Override
					public void after(AbstractAction action, Request request, RequestState state) {
						// make sure that the current measurement context matches the measurement context prescribed by
						// the measuring point; do not emit a measurement, if measurement contexts do not match
						Set<Object> contexts = extractContexts(request, state);
						Optional<Object> difference = getMeasuringPoint().getContexts().stream()
								.filter(ctx -> !contexts.contains(ctx)).findFirst();
						if (difference.isPresent()) {
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
				});

	}

	private Set<Object> extractContexts(Request request, RequestState state) {
		AssemblyContext assemblyCtx = state.getComponent().getAssemblyCtx();
		Set<Object> contextSet = new HashSet<Object>();
		contextSet.add(assemblyCtx);
		return contextSet;
		// return new Object[]{assemblyCtx};
	}

}
