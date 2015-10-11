package edu.kit.ipd.sdq.eventsim.resources.probes.passive;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;
import edu.kit.ipd.sdq.eventsim.measurement.Metric;
import edu.kit.ipd.sdq.eventsim.measurement.annotation.Probe;
import edu.kit.ipd.sdq.eventsim.measurement.probe.AbstractProbe;
import edu.kit.ipd.sdq.eventsim.resources.ResourceProbeConfiguration;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimulatedProcess;
import edu.kit.ipd.sdq.eventsim.resources.listener.IPassiveResourceListener;

@Probe(type=SimPassiveResource.class, property="queue_length")
public class PassiveQueueLengthProbe extends AbstractProbe<SimPassiveResource, Void, ResourceProbeConfiguration> {

	public PassiveQueueLengthProbe(MeasuringPoint<SimPassiveResource> p, ResourceProbeConfiguration configuration) {
		super(p, configuration);

		SimPassiveResource resource = p.getElement();
		resource.addListener(new IPassiveResourceListener() {

			@Override
			public void request(SimulatedProcess process, long num) {
				// nothing to do
			}

			@Override
			public void release(SimulatedProcess process, long num) {
				queueLengthChanged(process, num);
			}

			@Override
			public void acquire(SimulatedProcess process, long num) {
				queueLengthChanged(process, num);
			}

			private void queueLengthChanged(SimulatedProcess process, long num) {
				double simTime = process.getModel().getSimulationControl().getCurrentSimulationTime();
				
				long state = resource.getCapacity() - resource.getAvailable();
				
				Measurement<SimPassiveResource, Void> m = new Measurement<>(Metric.QUEUE_LENGTH, getMeasuringPoint()
						.withAddedContexts(resource.getAssemblyContext()), null, state, simTime);

				// store
				// cache.put(m); TODO cache not needed! --> account for in abstract superclass/constructor? or
				// enable by calculator (!)?

				// notify
				measurementListener.forEach(l -> l.notify(m));
			}

		});
	}

}
