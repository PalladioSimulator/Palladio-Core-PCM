package edu.kit.ipd.sdq.eventsim.resources.calculators;

import org.apache.log4j.Logger;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.Metric;
import edu.kit.ipd.sdq.eventsim.measurement.calculator.AbstractBinaryCalculator;
import edu.kit.ipd.sdq.eventsim.measurement.probe.IProbe;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimulatedProcess;

public class WaitingTimeCalculator extends
		AbstractBinaryCalculator<SimPassiveResource, SimPassiveResource, SimPassiveResource, SimulatedProcess> {

	private static final Logger log = Logger.getLogger(WaitingTimeCalculator.class);

	@Override
	public void setup(IProbe<SimPassiveResource, SimulatedProcess> fromProbe,
			IProbe<SimPassiveResource, SimulatedProcess> toProbe) {
		toProbe.forEachMeasurement(m -> {
			// find "from"-measurement
			SimulatedProcess process = m.getWho();
			Measurement<SimPassiveResource, SimulatedProcess> fromMeasurement = null;
			do {
				fromMeasurement = fromProbe.getLastMeasurementOf(process);
				process = process.getParent();
			} while (fromMeasurement == null && process != null);

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
	public Measurement<SimPassiveResource, SimulatedProcess> calculate(
			Measurement<SimPassiveResource, SimulatedProcess> from, Measurement<SimPassiveResource, SimulatedProcess> to) {
		if (from == null) {
			return null;
		}

		double when = to.getWhen();
		double waitingTime = to.getValue() - from.getValue();

		AssemblyContext assemblyCtx = from.getWhere().getElement().getAssemblyContext();
		// TODO current position not yet accurate
		return new Measurement<SimPassiveResource, SimulatedProcess>(Metric.WAITING_TIME, to.getWhere()
				.withProperty("waiting_time").withAddedContexts(assemblyCtx), to.getWho(), waitingTime, when);
		
		// TODO add request as metadata? from.getWho().getCurrentPosition().getId()
	}

}
