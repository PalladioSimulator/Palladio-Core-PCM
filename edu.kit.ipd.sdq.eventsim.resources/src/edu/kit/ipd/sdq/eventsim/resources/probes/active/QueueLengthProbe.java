package edu.kit.ipd.sdq.eventsim.resources.probes.active;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;
import edu.kit.ipd.sdq.eventsim.measurement.Metric;
import edu.kit.ipd.sdq.eventsim.measurement.annotation.Probe;
import edu.kit.ipd.sdq.eventsim.measurement.probe.AbstractProbe;
import edu.kit.ipd.sdq.eventsim.resources.ResourceProbeConfiguration;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.resources.listener.IStateListener;

@Probe(type = SimActiveResource.class, property = "queue_length")
public class QueueLengthProbe extends AbstractProbe<SimActiveResource, Void, ResourceProbeConfiguration> {

	public QueueLengthProbe(MeasuringPoint<SimActiveResource> p, ResourceProbeConfiguration configuration) {
		super(p, configuration);

		SimActiveResource resource = p.getElement();
		for (int instance = 0; instance < resource.getNumberOfInstances(); instance++) {
			final int i = instance;
			resource.addStateListener(new IStateListener() {

				// TODO account for instanceid in measuring point (property suffix? explicit objects?)
				@Override
				public void stateChanged(long state, int instanceId) {
					// build measurement
					double simTime = resource.getModel().getSimulationControl().getCurrentSimulationTime();
					Measurement<SimActiveResource, Void> m = new Measurement<>(Metric.QUEUE_LENGTH,
							getMeasuringPoint(), null, state, simTime);

					// store
					// cache.put(m); TODO cache not needed! --> account for in abstract superclass/constructor? or
					// enable by calculator (!)?

					// notify
					measurementListener.forEach(l -> l.notify(m));
				}
			}, instance);
		}

	}

}
