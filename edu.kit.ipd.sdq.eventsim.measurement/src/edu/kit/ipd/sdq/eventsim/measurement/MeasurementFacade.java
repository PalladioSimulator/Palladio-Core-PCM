package edu.kit.ipd.sdq.eventsim.measurement;

import java.util.HashSet;
import java.util.Set;

import org.osgi.framework.Bundle;

import edu.kit.ipd.sdq.eventsim.measurement.calculator.BinaryCalculator;
import edu.kit.ipd.sdq.eventsim.measurement.calculator.CalculatorBuilder;
import edu.kit.ipd.sdq.eventsim.measurement.calculator.IntermediateCalculatorFrom;
import edu.kit.ipd.sdq.eventsim.measurement.probe.IProbe;
import edu.kit.ipd.sdq.eventsim.measurement.probe.ProbeFactory;

public class MeasurementFacade<C extends ProbeConfiguration> {

	private ProbeFactory<C> probeFactory;

	private Set<IProbe<?, ?>> existingProbesSet;

	public MeasurementFacade(C configuration, Bundle bundle) {
		this.probeFactory = new ProbeFactory<>(configuration, bundle);
		this.existingProbesSet = new HashSet<>();
	}

	public <R, F, S, T> IntermediateCalculatorFrom<R, F, S, T> createCalculator(BinaryCalculator<R, F, S, T> c) {
		return CalculatorBuilder.create(c, this);
	}

	@SuppressWarnings("unchecked")
	public <E, T> IProbe<E, T> createProbe(E element, String property, Object... contexts) {
		IProbe<E, T> probe = probeFactory.create(element, property, contexts);
		if (existingProbesSet.contains(probe)) {
			// TODO perhaps use a map because iterating over the set becomes expensive for many probes
			for (IProbe<?, ?> p : existingProbesSet) {
				if (p.equals(probe)) {
					return (IProbe<E, T>) p;
				}
			}
			// this code should no be reachable without a programming mistake introduced
			throw new RuntimeException("Could not find probe.");
		}
		// not yet contained in set -> add probe
		existingProbesSet.add(probe);
		return probe;
	}
}
