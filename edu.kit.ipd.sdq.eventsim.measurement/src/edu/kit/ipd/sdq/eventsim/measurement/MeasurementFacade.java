package edu.kit.ipd.sdq.eventsim.measurement;

import org.osgi.framework.Bundle;

import edu.kit.ipd.sdq.eventsim.measurement.calculator.BinaryCalculator;
import edu.kit.ipd.sdq.eventsim.measurement.calculator.CalculatorBuilder;
import edu.kit.ipd.sdq.eventsim.measurement.calculator.IntermediateCalculatorFrom;
import edu.kit.ipd.sdq.eventsim.measurement.probe.IProbe;
import edu.kit.ipd.sdq.eventsim.measurement.probe.ProbeFactory;

public class MeasurementFacade<C extends ProbeConfiguration> {
	
	private ProbeFactory<C> probeFactory;
	
	public MeasurementFacade(C configuration, Bundle bundle) {
		this.probeFactory = new ProbeFactory<>(configuration, bundle);
	}
	
	public <R, F, S, T> IntermediateCalculatorFrom<R, F, S, T> createCalculator(BinaryCalculator<R, F, S, T> c) {
		return CalculatorBuilder.create(c, probeFactory);
	}
	
	public <E, T> IProbe<E, T> createProbe(E element, String property) {
		return probeFactory.create(element, property);
	}
	
}
