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

@Probe(type = SimPassiveResource.class, property = "release")
public class PassiveResourceReleasedProbe extends
		AbstractProbe<SimPassiveResource, SimulatedProcess, ResourceProbeConfiguration> {

	public PassiveResourceReleasedProbe(MeasuringPoint<SimPassiveResource> p, ResourceProbeConfiguration configuration) {
		super(p, configuration);

		SimPassiveResource resource = p.getElement();
		resource.addListener(new IPassiveResourceListener() {

			@Override
			public void request(SimulatedProcess process, long num) {
				// nothing to do
			}

			@Override
			public void acquire(SimulatedProcess process, long num) {
			// nothing to do	
			}

			@Override
			public void release(SimulatedProcess process, long num) {
				double simTime = process.getModel().getSimulationControl().getCurrentSimulationTime();

				Measurement<SimPassiveResource, SimulatedProcess> m = new Measurement<>(Metric.CURRENT_TIME,
						getMeasuringPoint(), process, simTime, simTime);

				// store
				cache.put(m);

				// notify
				measurementListener.forEach(l -> l.notify(m));
			}

		});
	}

}