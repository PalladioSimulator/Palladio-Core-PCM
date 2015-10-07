package edu.kit.ipd.sdq.eventsim.system;

import edu.kit.ipd.sdq.eventsim.measurement.ProbeConfiguration;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffInterpreterConfiguration;

public class SystemMeasurementConfiguration implements ProbeConfiguration {

	private SeffInterpreterConfiguration interpreterConfiguration;
	
	public SystemMeasurementConfiguration(SeffInterpreterConfiguration interpreterConfiguration) {
		this.interpreterConfiguration = interpreterConfiguration;
	}

	public SeffInterpreterConfiguration getInterpreterConfiguration() {
		return interpreterConfiguration;
	}
	
	public static SystemMeasurementConfiguration from(EventSimSystemModel model) {
		return new SystemMeasurementConfiguration(model.getSeffInterpreter().getConfiguration());
	}

}
